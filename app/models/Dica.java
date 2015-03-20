package models;

import javax.persistence.*;


/**
 * Created by rafaelle on 14/03/15.
 */
@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", length=1, discriminatorType= DiscriminatorType.STRING)
@DiscriminatorValue("D")
public abstract class Dica {

    @Id
    @GeneratedValue
    private Long id;

    String nomeDica;

    public Dica(String nomeDica){
        this.nomeDica = nomeDica;
    }

    public Dica() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    void setNomeDica(String nomeDica) {
        this.nomeDica = nomeDica;
    }

    public Object getNomeDica() {
        return nomeDica;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dica dica = (Dica) o;

        if (id != null ? !id.equals(dica.id) : dica.id != null) return false;
        if (nomeDica != null ? !nomeDica.equals(dica.nomeDica) : dica.nomeDica != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nomeDica != null ? nomeDica.hashCode() : 0);
        return result;
    }
}
/*Como aluno, clico em um tema e adiciono uma dica no tema. A dica pode ser de diferentes tipos*/
/* verificar se fica assim mesmo*/