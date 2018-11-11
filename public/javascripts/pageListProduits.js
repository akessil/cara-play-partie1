window.addEventListener('load', function() {
    $('#reload').click(chargerListProduits)
});

function chargerListProduits(){
    var synchrone = document.getElementById('synchrone').checked;
    var asynchrone = document.getElementById('asynchrone').checked;

    var urlSync  = "http://localhost:9000/getProduitPartie2";
    var urlAsync = "http://localhost:9000/getProduitPartie3"
    var ids =["1","2","3","4","5","6"];

    var url= urlSync;
    if(synchrone){
        url = urlSync;
    }else if(asynchrone){
        url = urlAsync;
    }

    $("#container-produit").html("");

    for(var i=0; i<ids.length; i++){
        $.get(url + "/" + ids[i], function(produit){
            callbackChargerProduit(produit);
        });
    }
}

function callbackChargerProduit(produit){
    var produitHtml = '<div class="produit">'
        + '<h2> ' + produit.nom + '</h2>'
        + '<img src="/assets/produits/produit' +(produit.id) + '.jpg" alt="produit" height="300" width="300">'
        + '<p>Ce poduit est disponnible au prix de' +  produit.prix +'€</p>'
        + '<p>' + produit.description + '</p>'
        + '</div>';
    $("#container-produit").html($("#container-produit").html() + produitHtml);
}
