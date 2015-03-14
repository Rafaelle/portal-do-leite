package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafaelle on 10/03/15.
 */
public class Disciplina {

    String nomeDisciplina;

    List<Dica> dicas = new ArrayList<Dica>();

    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public void addDica(Dica dica){
        dicas.add(dica);
    }

    public List<Dica> getDicas() {
        return dicas;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Disciplina that = (Disciplina) o;

        if (nomeDisciplina != null ? !nomeDisciplina.equals(that.nomeDisciplina) : that.nomeDisciplina != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return nomeDisciplina != null ? nomeDisciplina.hashCode() : 0;
    }

}
