package models;

/**
 * Created by rafaelle on 10/03/15.
 */
public class Tema {

    String nomeTema;

    public Tema(String nomeTema) {
        this.nomeTema = nomeTema;
    }

    public String getNomeTema() {
        return nomeTema;
    }

    public void setNomeTema(String nomeTema) {
        this.nomeTema = nomeTema;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tema tema = (Tema) o;

        if (nomeTema != null ? !nomeTema.equals(tema.nomeTema) : tema.nomeTema != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return nomeTema != null ? nomeTema.hashCode() : 0;
    }
}

