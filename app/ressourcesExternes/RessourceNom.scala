package ressourcesExternes

/**
  * Vous n avez pas a toucher a cette classe
  */
class RessourceNom {
  def getNom(id: String): String = {
    println(s"La ressource externe Titre demarre son traitement")
    Thread.sleep(300) //block for many ms, representing blocking I/O, etc
    println(s"La ressource externe Titre reponds a la demande")

    id match {
      case "1" ⇒ "Tasse de café"
      case "2" ⇒ "Tasse de thé"
      case "3" ⇒ "Pinte de bière"
      case "4" ⇒ "Shooter"
      case "5" ⇒ "Canette d'orangina"
      case "6" ⇒ "Bouteille de vin"
    }
  }
}
