package model

import java.io.Serializable
import play.api.libs.json.Json
import play.api.libs.json._

class Produit(var id: String, var nom: String, var description: String, var prix: Int) extends Serializable{

def toJson(): JsValue = {
  Json.toJson(
      Map("id" -> id, "nom" -> nom, "description" -> description, "prix" -> prix.toString)
  )
}

};