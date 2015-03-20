package controllers;

import models.DAO.DAO;
import models.Tema;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import java.util.List;

public class Application extends Controller {

    static final DAO dao = new DAO();

    @Transactional
    public static Result index() {
        return redirect(routes.Application.temas());
    }

    @Transactional
    public static Result temas(){
        List<Tema> temas = dao.findAllByClass(Tema.class);
        return ok(index.render(temas));
    }



}
