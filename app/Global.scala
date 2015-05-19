import play.api._
import play.api.mvc._


object Global extends GlobalSettings {

  private def getSubdomain(request: RequestHeader) = {
    request.domain.replaceFirst("[\\.]?[^\\.]+[\\.][^\\.]+$", "")
  }

  override def onRouteRequest(request: RequestHeader) = getSubdomain(request) match {
    case _ => admin.Routes.routes.lift(request)
  }

  // 404 - page not found error
  override def onHandlerNotFound(request: RequestHeader) = getSubdomain(request) match {
    case _ => GlobalAdmin.onHandlerNotFound(request)
  }

  // 500 - internal server error
  override def onError(request: RequestHeader, throwable: Throwable) = getSubdomain(request) match {
    case _ => GlobalAdmin.onError(request, throwable)
  }

  // called when a route is found, but it was not possible to bind the request parameters
  override def onBadRequest(request: RequestHeader, error: String) = getSubdomain(request) match {
    case _ => GlobalAdmin.onBadRequest(request, error)
  }

}
