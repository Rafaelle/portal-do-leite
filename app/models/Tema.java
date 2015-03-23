package models;

import javax.persistence.*;
import java.util.*;

/**
 * Created by rafaelle on 10/03/15.
 */
@Entity(name = "Tema")
public class Tema {

    public void setDificuldade(int i) {
    }

    public int getDificuldade() {
        return 0;
    }


    public enum DificuldadeTema {
        EAZY(-2), NORMAL(-1), HARD(0), EXPERT(1), MASTER(2);

        private int valor;

        private DificuldadeTema(int valor) {
            this.valor = valor;
        }

        public int getValor() {
            return valor;
        }
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nomeTema;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Dica> dicas;

    //private Map<Usuario , DificuldadeTema> avaliacoesTema;
    @ElementCollection
    @Column(name="avaliacoes")
    private List<DificuldadeTema> avaliacoes;

    public Tema() {
    }

    public Tema(String nomeTema) {
        this.nomeTema = nomeTema;
        //avaliacoesTema = new HashMap<Usuario, DificuldadeTema>();
        dicas = new ArrayList<Dica>();
        avaliacoes = new ArrayList<DificuldadeTema>();
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

    public List<Dica> getDica() {
        return dicas;
    }

    public void setDicas(List<Dica> dicas) {
        this.dicas = dicas;
    }

    public void addDica(Dica dica) {
        dicas.add(dica);
    }

    public void addAvaliacaoTema(DificuldadeTema avaliacao) {
        avaliacoes.add(avaliacao);
    }

    public int getAvaliacaoMedia() {
        return calculaMedia();
    }

    private int calculaMedia() {
        if(avaliacoes.size() == 0){
            return 0;
        }else {
            double soma = 0;

            for(int i = 0; i < avaliacoes.size(); i++) {
                soma += avaliacoes.get(i).getValor();
            }
            return soma == 0 ? 0 : (int)(soma/avaliacoes.size());
        }
    }

    public int getAvaliacaoMediana() {
        return calculaMediana();
    }

    private int calculaMediana() {
        if(avaliacoes.size() == 0){
            return 0;
        }else {
            double mediana;
            List<Integer> avaliacoesNumeros = new ArrayList<>();

            for(int i = 0; i < avaliacoes.size(); i++) {
                avaliacoesNumeros.add(avaliacoes.get(i).getValor());
            }
            avaliacoesNumeros.sort(Comparator.<Integer>naturalOrder());

            if(avaliacoesNumeros.size()%2 != 0){
                mediana = avaliacoesNumeros.get(avaliacoesNumeros.size()/2);
            }else{
                double soma = 	(avaliacoesNumeros.get(avaliacoesNumeros.size() / 2) - 1) +
                        (avaliacoesNumeros.get(avaliacoesNumeros.size() / 2));
                mediana = soma == 0 ? 0 : soma / 2;
            }
            return (int)mediana;
        }
    }

    /*
    public void addAvaliacaoTema(Usuario usuario, DificuldadeTema avaliacao) {
        avaliacoesTema.put(usuario, avaliacao);
    }

    public int getAvaliacaoMedia() {
        if(avaliacoesTema.isEmpty()){
            return -2;
        }
        else{
            Iterator<Usuario> iterator = avaliacoesTema.keySet().iterator();

            int soma = 0;
            while(iterator.hasNext()){
                soma += avaliacoesTema.get(iterator.next()).getValor();
            }
            return soma/avaliacoesTema.size();
        }
    }
    */

    /*
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

