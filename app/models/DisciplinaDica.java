package models;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by rafaelle on 21/03/15.
 */
@Entity(name = "DisciplinaDica")
public class DisciplinaDica extends Dica {

    @Column
    private String disciplinaNome;

    @Column
    private String razao;

    public DisciplinaDica() {
    }

    public DisciplinaDica(String usuario, String disciplinaNome, String razao) {
        super(usuario);
        this.disciplinaNome = disciplinaNome;
        this.razao = razao;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public String getDisciplinaNome() {
        return disciplinaNome;
    }

    public void setDisciplinaNome(String nome) {
        this.disciplinaNome = nome;
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer("Nome: ");
        str.append(getDisciplinaNome()).append("\n").append(" Razão: ").append(getRazao());
        return str.toString();
    }
}