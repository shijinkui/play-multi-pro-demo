package controllers.admin

import play.api.mvc.{Results, Action}


object Application {

  def index() = Action { implicit request =>
    Results.Ok(views.html.admin.index.render())
  }
}