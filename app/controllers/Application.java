package controllers;

import models.*;
import models.DAO.DAO;
import play.data.DynamicForm;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.tema;

import java.util.List;

public class Application extends Controller {

    static final DAO dao = new DAO();

    @Transactional
    public static Result index() {
        return redirect(routes.Application.temas());
    }

    @Transactional
    public static Result temas() {
        List<Tema> temas = dao.findAllByClass(Tema.class);
        return ok(index.render(temas));
    }

    @Transactional
    public static Result tema(Long id) {
        Tema tema = dao.findByEntityId(Tema.class, id);
        return ok(views.html.tema.render(tema));
    }


    @Transactional
    public static Result addDica(Long idTema) {
        DynamicForm filledForm = Form.form().bindFromRequest();
        String dica = filledForm.data().get("dica");
        if (dica.equals("conselhoDica")) {
            Tema tema = dao.findByEntityId(Tema.class, idTema);
            tema.addDica(new ConselhoDica(session().get("usuario"), dica));
            dao.merge(tema);
            dao.flush();
            return Application.tema(idTema);

        } else if (dica.equals("linkDica")) {

            Tema tema = dao.findByEntityId(Tema.class, idTema);
            tema.addDica(new LinkDica(session().get("usuario"), dica));
            dao.merge(tema);
            dao.flush();
            return Application.tema(idTema);

        } else if (dica.equals("disciplinaDica")) {
            Tema tema = dao.findByEntityId(Tema.class, idTema);
            String razao = filledForm.get("razao");
            tema.addDica(new DisciplinaDica(session().get("usuario"), dica, razao));
            dao.merge(tema);
            dao.flush();
            return Application.tema(idTema);

        } else if (dica.equals("assuntoDica")) {
            Tema tema = dao.findByEntityId(Tema.class, idTema);
            tema.addDica(new AssuntoDica(session().get("usuario"), dica));
            dao.merge(tema);
            dao.flush();
            return Application.tema(idTema);

        }
        return Application.tema(idTema);
    }


}




