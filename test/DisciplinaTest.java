import models.Disciplina;
import models.Tema;
import models.Usuario;
import org.junit.Before;
import org.junit.Test;
import static org.junit.*;


import static play.test.Helpers.*;

/**
 * Created by rafaelle on 10/03/15.
 */


public class DisciplinaTest {

    Tema tem;
    Usuario usuario;
    @Before
    public void setUp() {
        start(fakeApplication(inMemoryDatabase()));
        usuario = new Usuario();
    }

    @Test
    public void VerificaCriacaoDeDisciplina(){
        Disciplina d1 = new Disciplina("d1");
        assertTrue

    }

    @Test
    public void VerificaAdicaoDeTema(){
        Disciplina d1 = new Disciplina("d1");

    }

    /*@Test
    public void VerificaAdicaoDeDependentes() {
        Disciplina d1 = new Disciplina("d1");
        Disciplina d2 = new Disciplina("d2");

        Set<Disciplina> dependentesD1 = new HashSet<Disciplina>();
        Set<Disciplina> requisitosD2 = new HashSet<Disciplina>();
        assertTrue(dependentesD1.equals(d1.getDependentes()));
        assertTrue(requisitosD2.equals(d1.getRequisitos()));
        d1.acrescentaDependente(d2);
        dependentesD1.add(d2);
        requisitosD2.add(d1);
        assertTrue(dependentesD1.equals(d1.getDependentes()));
        assertTrue(requisitosD2.equals(d2.getRequisitos()));
    }
*/

}
