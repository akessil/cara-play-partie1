package daos.partie3



import javax.inject._
import akka.actor._
import scala.concurrent.{ExecutionContext, Future, Promise}
import scala.concurrent.duration._
import ressourcesExternes.RessourceDescription
import akka.pattern.ask

import play.api.libs.concurrent.Akka

import ressourcesExternes.RessourceDescription

//Cet acteur asynchrone appel une ressource externe (API/BDD?) pour recuperer la description associée à un id de produit
class ActeurDaoDescriptionAsync @Inject()(implicit ec: ExecutionContext) extends Actor {

  //TODO: implementez la methode receive de facon asynchrone (vous pouvez vous inspirer de l acteur ActeurDaoNomAsync)
  def receive = {
    case id: String ⇒{
      val appelant = sender()
      appelant ! "TODO:description"
    }
  }


}