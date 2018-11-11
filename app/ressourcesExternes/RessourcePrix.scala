package ressourcesExternes

/**
  * Vous n avez pas a toucher a cette classe
  */
class RessourcePrix {
  def getPrix(id: String): Int = {
    println(s"La ressource externe Prix demarre son traitement")
    Thread.sleep(150) //block for many ms, representing blocking I/O, etc
    println(s"La ressource externe Prix reponds a la demande")

    id match {
      case "1" ⇒ 2
      case "2" ⇒ 2
      case "3" ⇒ 18
      case "4" ⇒ 0
      case "5" ⇒ 1
      case "6" ⇒ 67
    }
  }
}
