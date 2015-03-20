package controllers;

import models.ConselhoDica;
import models.DAO.DAO;
import models.Dica;
import models.Tema;
import play.data.DynamicForm;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.dicasTema;
import views.html.index;

import java.util.List;

public class Application extends Controller {

    static final DAO dao = new DAO();
    private static Long idAtual;

    @Transactional
    public static Result index() {
        return redirect(routes.Application.temas());
    }

    @Transactional
    public static Result temas(){
        List<Tema> temas = dao.findAllByClass(Tema.class);
        return ok(index.render(temas));
    }

    @Transactional
    public static Result dicasTema(Long id){
        Tema tema = dao.findByEntityId(Tema.class, id);
        idAtual = id;
        return ok(dicasTema.render(tema));
    }

    @Transactional
    public static Result adicionaDica(){
        DynamicForm form = Form.form().bindFromRequest();

        String dica1 = form.get("form1");
        String dica2 = form.get("form2") == null? "" : " pois: " + form.get("form2") ;

        Tema tema = dao.findByEntityId(Tema.class, idAtual);
        System.out.println("antes");
        tema.addDica(new ConselhoDica(dica1 + dica2)); //tema.addDica(new Dica(dica1 + dica2));
        System.out.println("depois");
        dao.persist(tema);
        dao.flush();

        return dicasTema(idAtual);
    }

}
