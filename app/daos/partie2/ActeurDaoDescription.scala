package daos.partie2;
import javax.inject._
import akka.actor._
import scala.concurrent.{ExecutionContext, Future, Promise}
import scala.concurrent.duration._
import ressourcesExternes.RessourceDescription

import play.api.libs.concurrent.Akka

//Cet acteur synchrone appel une ressource externe (API/BDD?) pour recuperer la description associée à un id de produit
class ActeurDaoDescription @Inject()(implicit ec: ExecutionContext) extends Actor {
  //TODO: implementez la methode receive en vous inspirant de l acteur ActeurDaoNom
  def receive = {
    case id: String ⇒
      val ressourceExterne = new RessourceDescription()
      sender() ! "TODO:description"
  }

}