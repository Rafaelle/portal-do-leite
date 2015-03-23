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

import java.util.ArrayList;
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
    public static Result addDicaTipo(Long idTema ,String tipoDica) {
        DynamicForm filledForm = Form.form().bindFromRequest();
        String dica = filledForm.data().get("dica");
        if (tipoDica.equals("ConselhoDica")) {

            Tema tema = dao.findByEntityId(Tema.class, idTema);
            System.out.println(session().get("usuario")+"\n");
            tema.addDica(new ConselhoDica(session().get("usuario"), dica));
            dao.merge(tema);
            dao.flush();
            return Application.tema(idTema);

        } else if (tipoDica.equals("LinkDica")) {

            Tema tema = dao.findByEntityId(Tema.class, idTema);
            tema.addDica(new LinkDica(session().get("usuario"), dica));
            dao.merge(tema);
            dao.flush();
            return Application.tema(idTema);

        } else if (tipoDica.equals("DisciplinaDica")) {
            Tema tema = dao.findByEntityId(Tema.class, idTema);
            String razao = filledForm.get("razao");
            tema.addDica(new DisciplinaDica(session().get("usuario"), dica, razao));
            dao.merge(tema);
            dao.flush();
            return Application.tema(idTema);

        } else if (tipoDica.equals("AssuntoDica")) {
            Tema tema = dao.findByEntityId(Tema.class, idTema);
            tema.addDica(new AssuntoDica(session().get("usuario"), dica));
            dao.merge(tema);
            dao.flush();
            return Application.tema(idTema);

        }

        return Application.tema(idTema);
    }



    @Transactional
    private static Result addLikeDica(Long idDica){
        Dica dica = dao.findByEntityId(Dica.class, idDica);
        addLike();

    }

    @Transactional
    public static Result addAvaliacao(Long idTema){
        Tema tema = dao.findByEntityId(Tema.class, idTema);
        DynamicForm filledForm = Form.form().bindFromRequest();

            String avaliacao = filledForm.data().get("avaliacao");

            /*
            if(avaliacao.equals("Facil")){
                tema.addAvaliacaoTema(new Usuario("joao", "joao", "joao"), Tema.DificuldadeTema.EAZY);
            }else if(avaliacao.equals("Normal")) {
                tema.addAvaliacaoTema(new Usuario("joao", "joao", "joao"), Tema.DificuldadeTema.NORMAL);
            }else if(avaliacao.equals("Dificil")) {
                tema.addAvaliacaoTema(new Usuario("joao", "joao", "joao"), Tema.DificuldadeTema.HARD);
            }else if(avaliacao.equals("MuitoDificil")) {
                tema.addAvaliacaoTema(new Usuario("joao", "joao", "joao"), Tema.DificuldadeTema.EXPERT);
            }else if(avaliacao.equals("Impossivel")){
                tema.addAvaliacaoTema(new Usuario("joao", "joao", "joao"), Tema.DificuldadeTema.MASTER);
            }
            */

            if(avaliacao.equals("Facil")){
                tema.addAvaliacaoTema(Tema.DificuldadeTema.EAZY);
            }else if(avaliacao.equals("Normal")) {
                tema.addAvaliacaoTema(Tema.DificuldadeTema.NORMAL);
            }else if(avaliacao.equals("Dificil")) {
                tema.addAvaliacaoTema(Tema.DificuldadeTema.HARD);
            }else if(avaliacao.equals("MuitoDificil")) {
                tema.addAvaliacaoTema(Tema.DificuldadeTema.EXPERT);
            }else if(avaliacao.equals("Impossivel")){
                tema.addAvaliacaoTema(Tema.DificuldadeTema.MASTER);
            }

            dao.merge(tema);
            dao.flush();
            return Application.tema(idTema);
    }



    /* eu não estou usando esse metodo mais preferi não apagar */
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




