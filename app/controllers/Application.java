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
        List<Dica> dicas = tema.getDica();

        for(int i = 0; i < tema.getDica().size(); i++) {
            if(dicas.get(i).dicaExclusao()) {
                dicas.remove(i);

                tema.setDicas(dicas);
                dao.merge(tema);
                dao.flush();
                return ok(views.html.tema.render(tema));
            }
        }
        return ok(views.html.tema.render(tema));
    }


    @Transactional
    public static Result addDicaTipo(Long idTema ,String tipoDica) {
        DynamicForm filledForm = Form.form().bindFromRequest();
        String dica = filledForm.data().get("dica");
        if (tipoDica.equals("ConselhoDica")) {

            Tema tema = dao.findByEntityId(Tema.class, idTema);
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
    public static Result addAvaliacao(Long idTema){
        Tema tema = dao.findByEntityId(Tema.class, idTema);
        DynamicForm filledForm = Form.form().bindFromRequest();

            String avaliacao = filledForm.data().get("avaliacao");

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

    @Transactional
    public static Result addLike(Long idTema, Long idDica) {
        Dica dica = dao.findByEntityId(Dica.class, idDica);
        dica.addLike();

        dao.merge(dica);
        dao.flush();
        return Application.tema(idTema);
    }

    @Transactional
    public static Result addDeslike(Long idTema, Long idDica) {
        Dica dica = dao.findByEntityId(Dica.class, idDica);
        dica.addDeslike();

        dao.merge(dica);
        dao.flush();
        return Application.tema(idTema);

    }

    @Transactional
    public static Result addFlag(Long idTema, Long idDica) {
        Dica dica = dao.findByEntityId(Dica.class, idDica);
        dica.addFlag();

        dao.merge(dica);
        dao.flush();
        return Application.tema(idTema);
    }
}




