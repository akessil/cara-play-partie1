package ressourcesExternes

/**
  * Vous n avez pas a toucher a cette classe
  */
class RessourceDescription {
  def getDescription(id: String): String = {
    println(s"La ressource externe Description demarre son traitement")
    Thread.sleep(800) //block for many ms, representing blocking I/O, etc
    println(s"La ressource externe Description reponds a la demande")

    id match {
      case "1" ⇒ "tout bon devellopeur se doit d avoir une belle tasse de café"
      case "2" ⇒ "pour toi la mémé"
      case "3" ⇒ "Et oui paris c'est cher"
      case "4" ⇒ "Viens dans ce bar, le shooter est offert (obligation d'acheter une bière)"
      case "5" ⇒ "si tu veux avoir la silouette de nos bouteille, bois cette canette"
      case "6" ⇒ "tres bon cru"
    }
  }
}
