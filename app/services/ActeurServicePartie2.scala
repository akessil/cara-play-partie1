package services;
import javax.inject._
import akka.actor._
import akka.actor.ActorSystem
import scala.concurrent.{ExecutionContext, Future, Promise, Await}
import scala.concurrent.duration._
import daos.partie2.{ActeurDaoNom, ActeurDaoDescription, ActeurDaoPrix}
import akka.util.Timeout
import akka.pattern.ask
import model.Produit
import scala.concurrent.duration.Duration

import play.api.libs.concurrent.Akka

//Ceci est le service a implementer pour la partie2, de facon synchrone (Await)
class ActeurServicePartie2 @Inject()(actorSystem: ActorSystem)(implicit ec: ExecutionContext) extends Actor {
  implicit val timeout: Timeout = 20 seconds
  val duration: Duration = 20.seconds

  val acteurDaoNom = actorSystem.actorOf(Props(new ActeurDaoNom()), "ActeurDaoNom")
  val acteurDaoDescription = actorSystem.actorOf(Props(new ActeurDaoDescription()), "ActeurDaoDescription")
  val acteurDaoPrix = actorSystem.actorOf(Props(new ActeurDaoPrix()), "ActeurDaoPrix")

  //TODO: appeller les differents Daos sequentiellement, construisez le produit et envoyez le à l'acteur appellant (sender())
  def receive = {
    case id: String ⇒

      val res = new Produit( "0", "TODO:nom", "TODO:description", -1)
      sender() ! res
  }

}