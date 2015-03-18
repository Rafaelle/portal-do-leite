import models.DAO.DAO;
import models.Dica;
import models.NomeAssuntoDica;
import models.Tema;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rafaelle on 15/03/15.
 */
public class TemaTest extends AbstractTest {




    DAO dao = new DAO();
    Tema tema;
    Dica dica;
    Dica dica2;

    @Test
    public void deveCriarTema() {
        //tema = (Tema) dao.findAllByClass(Tema.class); //consulta o bd

        assertTrue(tema.equals(null));
        tema = new Tema("Limite");
        System.out.println(tema);
        //dao.persist(tema);
        //tema = (Tema) dao.findAllByClass(Tema.class); //consulta o bd
        assertNotNull(tema);
        assertTrue(tema.equals("Limite"));
    }

    @Test
    public void deveTerEMudarDificuldade () {
        tema = new Tema("Limite");
        dao.persist(tema);

        assertEquals(tema.getDificuldade(),-2);
        tema.setDificuldade(0);
        assertEquals(tema.getDificuldade(),0);

    }


    @Test
    //testar melhor isso aqui
    public void deveAdicionarTema () {
        tema = new Tema("Serie");

        dica = new NomeAssuntoDica("integral");
        dica2 = new NomeAssuntoDica("limite");

        tema.addDica(dica);
        tema.addDica(dica2);

        assertTrue(tema.getDica().size() == 2);
        assertTrue(tema.getDica().get(0).equals("integral"));
        assertTrue(tema.getDica().get(1).equals("limite"));


    }





}
