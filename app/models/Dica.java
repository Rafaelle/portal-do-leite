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

    @Column
    private int[] dadosControle;

    public Dica(String usuario) {
        this.usuario = usuario;
        this.dadosControle = new int[3];
        iniciaDadosControle();
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

    public void iniciaDadosControle(){
        for(int i = 0; i < 3; i++) {
            dadosControle[i] = 0;
        }
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

    public int getLike() {
        return dadosControle[0];
    }

    public void setLike(int like) {
        this.dadosControle[0] = like;
    }

    public int getDeslike() {
        return dadosControle[1];
    }

    public void setDeslike(int deslike) {
        this.dadosControle[1] = deslike;
    }

    public int getFlag() {
        return dadosControle[2];
    }

    public void setFlag(int flag) {
        this.dadosControle[2] = flag;
    }

    public void addLike(){
        this.dadosControle[0] = this.dadosControle[0] >= 20 ? 20 :this.dadosControle[0] + 1;
    }

    public void addDeslike(){
        this.dadosControle[1] = this.dadosControle[1] >= 20 ? 20 :this.dadosControle[1] + 1;
    }

    public void addFlag() {
        this.dadosControle[2] += 1;
    }

    public boolean dicaExclusao() {
        return dadosControle[2] >= 3;
    }

}
/*Como aluno, clico em um tema e adiciono uma dica no tema. A dica pode ser de diferentes tipos*/
/* verificar se fica assim mesmo*/