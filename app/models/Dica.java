package models;

/**
 * Created by rafaelle on 14/03/15.
 */
public abstract class Dica {

    String nomeDica;

    public Dica(String nomeDica){
        this.nomeDica = nomeDica;
    }

    void setNomeDica(String nomeDica) {
        this.nomeDica = nomeDica;
    }

    public String getNomeDica() {
        return nomeDica;
    }
}
/*Como aluno, clico em um tema e adiciono uma dica no tema. A dica pode ser de diferentes tipos:

        o que você precisa saber para não ter dificuldades (nome de um assunto)



*/