package controllers;

import models.DAO.ApplicationDAO;
import models.DAO.DAO;
import models.Tema;
import play.*;
import play.mvc.*;

import views.html.*;

import java.util.ArrayList;
import java.util.List;

public class Application extends Controller {

    static final ApplicationDAO dao = new ApplicationDAO();

    public static Result index() {
        return redirect(routes.Application.home());
    }

    @play.db.jpa.Transactional
    public static Result home() {
        Tema tema;

        /* isso aqui é so pra adicionar os temas a primeira vez acho que tme que ir dentro do global
        String[] nome = {"Análise x Design", "OO", "GRASP", "GoF", "Arquitetura", "Play", "JS", "HTML+CSS+Bootstrap"
                , "Heroku", "Labs", "Minitestes", "Projeto"};

        for (int i = 0; i < nome.length; i++) {
            tema = new Tema(nome[i]);
            dao.persist(tema);
        }
        */
        List<Tema> temas = dao.getAllByClass(Tema.class);
        return ok(index.render(temas));
    }

}
