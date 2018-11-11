package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import model.Produit
import akka.actor._
import akka.actor.ActorSystem
import services.ActeurServicePartie2
import scala.concurrent.{ExecutionContext, Future, Promise, Await}
import scala.concurrent.duration._
import akka.pattern.ask
import scala.concurrent.duration.Duration
import akka.util.Timeout

//Ceci est le controller a implementer pour la 2eme partie de facon synchrone
@Singleton
class Partie2Controller @Inject()(cc: ControllerComponents, actorSystem: ActorSystem)(implicit exec: ExecutionContext) extends AbstractController(cc) {

  implicit val timeout: Timeout = 20 seconds
  val duration: Duration = 20.seconds
  val acteurServicePartie2 = actorSystem.actorOf(Props(new ActeurServicePartie2(actorSystem)), "ActeurServicePartie2")

  //TODO appeller acteurServicePartie2 en lui fournissant l id recu puis retournez le produit obtenu de facon synchrone (en utilisant Await)
  def getProduit(id: String) = Action { implicit request: Request[AnyContent] => {
    var produit: Produit = new Produit( "0", "TODO:nom", "TODO:description", -1)
    Ok(produit.toJson())
  }
  }

}
