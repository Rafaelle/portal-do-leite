package models;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by rafaelle on 14/03/15.
 */
@Entity(name = "ConselhoDica")
public class ConselhoDica extends Dica {
    @Column
    private String conselhoDica;

    public ConselhoDica() {
    }

    public ConselhoDica(String usuario, String conselho) {
        super(usuario);
        this.conselhoDica = conselho;
    }

    public String getConselhoDica() {
        return conselhoDica;
    }

    public void setConselhoDica(String conselhoDica) {
        this.conselhoDica = conselhoDica;
    }

    @Override
    public String toString() {
        return conselhoDica;
    }
}
