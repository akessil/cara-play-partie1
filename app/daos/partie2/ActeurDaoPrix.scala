package daos.partie2;
import javax.inject._
import akka.actor._
import scala.concurrent.{ExecutionContext, Future, Promise}
import scala.concurrent.duration._
import ressourcesExternes.RessourcePrix

import play.api.libs.concurrent.Akka

class ActeurDaoPrix @Inject()(implicit ec: ExecutionContext) extends Actor {
  def receive = {
    case id: String ⇒
      val ressourceExterne = new RessourcePrix()
      val res = ressourceExterne.getPrix(id)
      sender() ! res
  }

}