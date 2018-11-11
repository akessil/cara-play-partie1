window.addEventListener('load', function() {
    $('#test-btn').click(testPerf);
});

function testPerf(){
    var timeBetweenRequestsInput=document.getElementById("time-between-requests").value;
    var timeTestInput = document.getElementById("time-test").value;
    var timeBetweenRequests = parseInt(timeBetweenRequestsInput);
    var timeTest = parseInt(timeTestInput);
    if((isNaN(timeBetweenRequests) || timeBetweenRequests == undefined || timeBetweenRequests == null || timeBetweenRequests <=0) || (isNaN(timeTest) || timeTest == undefined || timeTest == null || timeTest <=0) || timeBetweenRequests > timeTest){
        alert("Erreur dans les prams");
    }else{

        var firstTime = new Date();

        var t2 = setInterval(function (){testASync(firstTime, timeTest);}, timeBetweenRequests);
        setTimeout(function(){clearInterval(t2)}, timeTest);

        setTimeout(function(){
            var firstTime = new Date();
            var t = setInterval(function (){testSync(firstTime, timeTest);}, timeBetweenRequests);
            setTimeout(function(){clearInterval(t)}, timeTest);
        }, timeTest * 2)
    }

}
var cmptNbRequestSync=0;
var timesSync=[];
function testSync(firstTime,timeTest){
    var sendRequestDate = new Date();
    $.get("http://localhost:9000/getProduitPartie2/1", function (){
        var currentTime = new Date();
        if((currentTime.getTime() - firstTime.getTime()) <= timeTest){
            cmptNbRequestSync++;
            var currentDate = new Date();
            timesSync[cmptNbRequestSync-1]= currentDate.getTime() - sendRequestDate.getTime();
            updateVueSync(firstTime, currentTime,cmptNbRequestSync, timesSync);
        }

    });
}

function  updateVueSync(firstTime, currentTime,cmptNbRequestSync,times){
    $("#nb-request-sync").text(cmptNbRequestSync);
    $("#time-average-sync").text((currentTime.getTime() - firstTime.getTime())/cmptNbRequestSync);
    $("#time-average-sync-per-request").text(somme(times)/cmptNbRequestSync);
}

function somme(times) {
    var s = 0;
    for(var i=0; i<times.length; i++){
        s+= times[i];
    }
    return s;
}

var cmptNbRequestASync=0;
var timesAsync = [];
function testASync(firstTime, timeTest){
    var sendingRequestDate = new Date();
    $.get("http://localhost:9000/getProduitPartie3/1", function (data){
        var currentTime = new Date();
        if((currentTime.getTime() - firstTime.getTime()) <= timeTest){
            cmptNbRequestASync++;
            var currentDate = new Date();
            console.log("sending:" + sendingRequestDate);
            console.log("current:" + currentDate);
            console.log("delta:" + (currentDate.getTime() - sendingRequestDate.getTime()));
            timesAsync[cmptNbRequestASync-1] = currentDate.getTime() - sendingRequestDate.getTime();
            updateVueASync(firstTime, currentTime,cmptNbRequestASync, timesAsync);
        }
    });
}

function  updateVueASync(firstTime, currentTime,cmptNbRequestASync, times){
    $("#nb-request-async").text(cmptNbRequestASync);
    $("#time-average-async").text((currentTime.getTime() - firstTime.getTime())/cmptNbRequestASync);
    $("#time-average-async-per-request").text(somme(times)/cmptNbRequestASync);
}