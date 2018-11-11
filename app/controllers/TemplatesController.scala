package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import model.Produit

@Singleton
class TemplatesController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  //Vous n avez pas besoin de modifier ce controller

  def pageListeProduits() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.pageListeProduits("Liste de produits"))
  }
  def pageTestPerf() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.pageTestPerf("Test de performance"))
  }

}
