package models;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by rafaelle on 14/03/15.
 */
@Entity(name = "AssuntoDica")
public class AssuntoDica extends Dica {

    @Column
    private String assunto;

    public AssuntoDica() {

    }

    public AssuntoDica(String usuario, String assunto) {
        super(usuario);
        this.assunto = assunto;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {

        this.assunto = assunto;
    }

    @Override
    public String toString() {
        return getAssunto();
    }

}
