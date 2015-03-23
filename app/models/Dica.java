package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * Created by rafaelle on 14/03/15.
 */

@Entity(name = "Dica")
public abstract class Dica {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nomeDica;

    @Column
    private String usuario;

/*
    @Column
    private int like;

    @Column
    private int deslike;


*/

    public Dica(String usuario) {
        this.usuario = usuario;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
/*
    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getDeslike() {
        return deslike;
    }

    public void setDeslike(int deslike) {
        this.deslike = deslike;
    }

    public void addLike(){
        like+=1;
    }

    public void addDeslike(){
        deslike+=1;
    }
*/
}
/*Como aluno, clico em um tema e adiciono uma dica no tema. A dica pode ser de diferentes tipos*/
/* verificar se fica assim mesmo*/