package models;

/**
 * Created by rafaelle on 10/03/15.
 */
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Disciplina {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private String nomeDisciplina;

    @OneToMany(	cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE},
            fetch=FetchType.LAZY,mappedBy="Disciplina")
    private List<Tema> temas;

    public Disciplina(){}

    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public List<Tema> getTemas() {
        return temas;
    }

    public void setTema(List<Tema> temas) {
        this.temas = temas;
    }

    public void addTema(Tema tema) {
        if (temas.equals(null)){
            temas = new ArrayList<Tema>();
            // recursividde cria o array e depois volta para o proprio metodo com o array criado e adicionando
            // o tema
            addTema(tema);
        } else {
            temas.add(tema);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Disciplina that = (Disciplina) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nomeDisciplina != null ? !nomeDisciplina.equals(that.nomeDisciplina) : that.nomeDisciplina != null)
            return false;
        if (temas != null ? !temas.equals(that.temas) : that.temas != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nomeDisciplina != null ? nomeDisciplina.hashCode() : 0);
        result = 31 * result + (temas != null ? temas.hashCode() : 0);
        return result;
    }
}
