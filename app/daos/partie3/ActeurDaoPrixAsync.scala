package daos.partie3



import javax.inject._
import akka.actor._
import scala.concurrent.{ExecutionContext, Future, Promise}
import scala.concurrent.duration._
import ressourcesExternes.RessourcePrix
import akka.pattern.ask

import play.api.libs.concurrent.Akka

import ressourcesExternes.RessourcePrix

class ActeurDaoPrixAsync @Inject()(implicit ec: ExecutionContext) extends Actor {

  def receive = {
    case id: String ⇒{
      val appelant = sender()
      getFutureResult(id).map(result => appelant ! result)
    }
  }

  //On place un traitement long dans une future pour que l acteur soit libere en attendant la reponse de la ressource
  def getFutureResult(id: String) =
    Future {
      val ressourceExterne = new RessourcePrix()
      ressourceExterne.getPrix(id)
    }(ec)


}