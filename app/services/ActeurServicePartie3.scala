package services;
import javax.inject._
import akka.actor._
import akka.actor.ActorSystem
import scala.concurrent.{ExecutionContext, Future, Promise, Await}
import scala.concurrent.duration._
import daos.partie3.{ActeurDaoNomAsync, ActeurDaoDescriptionAsync, ActeurDaoPrixAsync}
import akka.util.Timeout
import akka.pattern.ask
import model.Produit
import scala.concurrent.duration.Duration

import play.api.libs.concurrent.Akka


//Ceci est le service a implementer pour la partie2, de facon synchrone (flatMap map)
class ActeurServicePartie3 @Inject()(actorSystem: ActorSystem)(implicit ec: ExecutionContext) extends Actor {
  implicit val timeout: Timeout = 20 seconds
  val duration: Duration = 20.seconds

  val acteurDaoNom = actorSystem.actorOf(Props(new ActeurDaoNomAsync()), "ActeurDaoNomAsync")
  val acteurDaoDescription = actorSystem.actorOf(Props(new ActeurDaoDescriptionAsync()), "ActeurDaoDescriptionAsync")
  val acteurDaoPrix = actorSystem.actorOf(Props(new ActeurDaoPrixAsync()), "ActeurDaoPrixAsync")

  //TODO: appeller les differents Daos PARALLELEMENT, construisez le produit et envoyez le à l'acteur appellant
  def receive = {
    case id: String ⇒
      //utilisez cet appelant dans la callback car la methode sender() aura perdu sa cible
      val appelant = sender()

      appelant ! new Produit( "0", "TODO:nom", "TODO:description", -1)

  }

}