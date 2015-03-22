package models;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by rafaelle on 14/03/15.
 */
@Entity(name = "LinkDica")
public class LinkDica extends Dica {

    @Column
    private String link;

    public LinkDica() {
    }

    public LinkDica(String usuario, String link) {
        super(usuario);
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String material) {
        this.link = material;
    }

    private boolean verificaAutenticidadeDoLink(String link) {
        if (link.startsWith("http://") &&
                (link.startsWith(".com", link.length() - 4)
                        || link.startsWith(".com.br", link.length() - 7)
                        || link.startsWith(".edu", link.length() - 4)
                        || link.startsWith(".edu.br", link.length() - 7))) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return getLink();
    }

}
