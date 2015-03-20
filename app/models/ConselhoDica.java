package models;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by rafaelle on 14/03/15.
 */
@Entity
@DiscriminatorValue("C")
public class ConselhoDica extends Dica {
    /*conselho (com texto, apenas)*/

    public ConselhoDica(String conselho) {
        super(conselho);
    }

    public ConselhoDica() {

    }

}
