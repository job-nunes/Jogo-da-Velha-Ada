package Models;

public class Jogador {
    String nome;
    int placar;
    String marcacao;

    Jogador(String nome, String marcacao){
        this.nome = nome;
        this.marcacao = marcacao;
        this.placar = 0;
    }

    public void trocarMarcacaoUsuario(String marcacaoAtual){
        if(marcacaoAtual.equals("x")){
            this.marcacao = "o";
        } else {
            this.marcacao = "x";
        }
    }


}
