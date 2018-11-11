// @GENERATOR:play-routes-compiler
// @SOURCE:/home/fvantorre/Bureau/Repositories/test-play/cara-play-tutorial/conf/routes
// @DATE:Sat Nov 10 21:32:23 CET 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
