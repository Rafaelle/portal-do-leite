package models;

import javax.persistence.*;

/**
 * Created by rafaelle on 10/03/15.
 */
@Entity
public class Tema {

    public enum DificuldadeTema{
        EAZY(-2), NORMAL(-1), HARD(0), EXPERT(1), MASTER(2);

        private int valor;
        private DificuldadeTema(int valor){
            this.valor = valor;
        }

        public int getValor(){
            return valor;
        }
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nomeTema;

    //@OneToMany(	cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE},
    //        fetch=FetchType.LAZY,mappedBy="Tema")
    //private List<Dica> dicas;

    public  Tema(){ }
    public Tema(String nomeTema) {
        this.nomeTema = nomeTema;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeTema() {
        return nomeTema;
    }

    public void setNomeTema(String nomeTema) {
        this.nomeTema = nomeTema;
    }
    /*
    public List<Dica> getDica() {
        return dicas;
    }

    public void setDicas(List<Dica> dicas) {
        this.dicas = dicas;
    }

    public void addDica(Dica dica) {
        if (dicas.equals(null)){
            dicas = new ArrayList<Dica>();
            // recursividde cria o array e depois volta para o proprio metodo com o array criado e adicionando
            // a dica
            addDica(dica);
        } else {
            dicas.add(dica);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        if (this == o) return true;

        Tema tema = (Tema) o;

        if (dificuldade != tema.dificuldade) return false;
        if (dicas != null ? !dicas.equals(tema.dicas) : tema.dicas != null) return false;
        if (id != null ? !id.equals(tema.id) : tema.id != null) return false;
        if (nomeTema != null ? !nomeTema.equals(tema.nomeTema) : tema.nomeTema != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nomeTema != null ? nomeTema.hashCode() : 0);
        result = 31 * result + (dicas != null ? dicas.hashCode() : 0);
        result = 31 * result + dificuldade;
        return result;
    }
    */
}

