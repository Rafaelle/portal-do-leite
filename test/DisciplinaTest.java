import models.DAO.DAO;
import models.Disciplina;
import models.Tema;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by rafaelle on 10/03/15.
 */


public class DisciplinaTest extends AbstractTest{

    DAO dao = new DAO();
    Disciplina disciplina;
    Tema tema;
    Tema tema2;

    @Test
    public void deveCriarDisciplina() {
        //disciplina = (Disciplina) dao.findAllByClass(Disciplina.class); //consulta o bd
        assertTrue(disciplina.equals(null));
        disciplina = new Disciplina("Calculo");
        //dao.persist(disciplina);
        //disciplina = (Disciplina) dao.findAllByClass(Disciplina.class); //consulta o bd
        assertNotNull(disciplina);
        assertTrue(disciplina.equals("Calculo"));

    }

    @Test
    public void deveAdicionarTema () {
        tema = new Tema("Limite");
        tema2 = new Tema("Derivada");

        disciplina.addTema(tema);
        disciplina.addTema(tema2);

        assertTrue(disciplina.getTemas().size() == 2);
        assertTrue(disciplina.getTemas().get(0).equals("Limite"));
        assertTrue(disciplina.getTemas().get(1).equals("Derivada"));


    }


}
