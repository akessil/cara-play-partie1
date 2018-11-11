package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import model.Produit

@Singleton
class Partie1Controller @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  // TODO : cette methode doit retourner le template partie1 en lui passant en parametre la liste de produits ainsi que le titre
  def listeProduits() = Action { implicit request: Request[AnyContent] => {
    val produits = getProduits();

    //c est le titre a passer en parametre au template
    val titre = "Partie 1"

    //Inspirez vous du controller TemplatesController
    Ok("placez ici le template partie1 avec les bons parametres")
  }
  }

  //ce sont les produits a passer en parametre au template
  private def getProduits(): List[Produit] = {
    var produits: List[Produit] = List ()
    produits = new Produit ("1", "Tasse de café", "tout bon devellopeur se doit d avoir une belle tasse de café", 2) :: produits
    produits = new Produit ("2", "Tasse de thé", "pour toi la mémé", 2) :: produits
    produits = new Produit ("3", "Pinte de bière", "Et oui paris c'est cher", 18) :: produits
    produits = new Produit ("4", "Shooter", "Viens dans ce bar, le shooter est offert (obligation d'acheter une bière)", 0) :: produits
    produits = new Produit ("5", "Canette d'orangina", "si tu veux avoir la silouette de nos bouteille, bois cette canette", 1) :: produits
    produits = new Produit ("6", "Bouteille de vin", "tres bon cru", 67) :: produits
    return produits
  }

}
