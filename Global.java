import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import play.*;
import play.db.jpa.JPA;

import models.DAO.DAO;
import models.Disciplina;
import models.Tema;


public class Global extends GlobalSettings {

    private static DAO dao = new DAO();


    @Override
    public void onStart(Application app) {
        Logger.info("Aplicação inicializada...");

        Disciplina disciplina = new Disciplina("Sistemas de Informação 1");

        JPA.withTransaction(new play.libs.F.Callback0() {

            @Override
            public void invoke() throws Throwable {
                //Armazena dados do csv numa lista de arrays
                String arquivo = "temas.csv";
                String separador = ",";
                String entrada = "";
                List<String[]> entradas = new ArrayList<String[]>();


                try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {

                    while ((entrada = reader.readLine()) != null) {
                        String[] entradaArray = entrada.split(separador);
                        entradas.add(entradaArray);

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

                List<Tema> novosTemas = new ArrayList<Tema>();

                //Cria Tema
                Iterator<String[]> it = entradas.iterator();
                while (it.hasNext()) {
                    String[] entradaAtual = it.next();

                    String nomeTema = entradaAtual[0];

                    //Se o tema não existe, cria um tema...
                    Tema temaAtual = new Tema(nomeTema);
                    if (!novosTemas.contains(temaAtual)) {
                        novosTemas.add(temaAtual);
                    }
                    //Adiciona todos os temas no BD

                }
                int teste = 0;
                for (Tema tema : novosTemas) {
                    dao.persist(tema);
                    dao.flush();
                }
            }
        });
    }

    @Override
    public void onStop(Application app) {
        Logger.info("Aplicação finalizada...");

        JPA.withTransaction(new play.libs.F.Callback0() {

            @Override
            public void invoke() throws Throwable {
                List<Tema> temas = dao.findAllByClass(Tema.class);
                for (Tema tema : temas) {

                    dao.remove(tema);
                    dao.flush();
                }
            }
        });
    }
}