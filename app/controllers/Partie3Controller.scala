package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import model.Produit
import akka.actor._
import akka.actor.ActorSystem
import services.ActeurServicePartie3
import scala.concurrent.{ExecutionContext, Future, Promise, Await}
import scala.concurrent.duration._
import akka.pattern.ask
import scala.concurrent.duration.Duration
import akka.util.Timeout
import play.api.libs.json._

//Ceci est le controller a implementer pour la 3eme partie de facon asynchrone
@Singleton
class Partie3Controller @Inject()(cc: ControllerComponents, actorSystem: ActorSystem)(implicit exec: ExecutionContext) extends AbstractController(cc) {

  implicit val timeout: Timeout = 20 seconds
  val acteurServicePartie3 = actorSystem.actorOf(Props(new ActeurServicePartie3(actorSystem)), "ActeurServicePartie3")

  //TODO appeller acteurServicePartie3 en lui fournissant l id recu puis retournez le produit obtenu de facon asynchrone (en utilisant mapTo & map)
  //indication: vous devez utiliser Action.async
  def getProduit(id: String) = Action{ implicit request: Request[AnyContent] => {
    val produit = new Produit( "0", "TODO:nom", "TODO:description", -1)
    Ok(produit.toJson())
  }
  }

}
