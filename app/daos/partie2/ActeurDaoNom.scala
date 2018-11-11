package daos.partie2;
import javax.inject._
import akka.actor._
import scala.concurrent.{ExecutionContext, Future, Promise}
import scala.concurrent.duration._
import ressourcesExternes.RessourceNom

import play.api.libs.concurrent.Akka

class ActeurDaoNom @Inject()(implicit ec: ExecutionContext) extends Actor {
  def receive = {
    case id: String ⇒
      val ressourceExterne = new RessourceNom()
      val res = ressourceExterne.getNom(id)
      sender() ! res
  }

}