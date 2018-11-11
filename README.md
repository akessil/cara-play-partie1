Liens vers notre diapo : https://drive.google.com/open?id=1AiqWwfgNDy-e6EhezEhLRiICYyxc2BuilAIZRW5J8KA

#Installation :
Ouvrez le projet dans IntelliJ
Installez le plugin Scala (File>Settings>Plugins)
Lancez la commande >sbt run

Si vous ne parvenez pas a faire fonctionner sbt ou que la version disponnible n est pas compatible:
enlevez tous les prefixes "no-" devans les fichiers et dossiers gradle et lancez la commande gradle runPlayBinary via IntelliJ


Tout le travail que vous aurez à faire est facilement repérable grâce aux marqueurs “TODO” (navigation facile dans IntelliJ)


#Partie 1
Dans cette partie vous verrez comment fonctionne le moteur de template Twirl, le router et les assets.

* Implémentez Partie1Controller
* Implémentez Partie1.scala.html, ajoutez le bon paramètre,  @for(item <- list){ @item }
* Voir le résultat localhost:9000/partie1
* Vous devez ajouter la liens vers la partie 2 en utilisant le reverse Router pour passer à la 