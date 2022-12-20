package Models;

public class Jogador {
    public String nome;
    public int placar;
    public String marcacao;

    public Jogador(String nome, String marcacao){
        this.nome = nome;
        if(marcacao.equals("x")){
            this.marcacao = "\u2716";
        } else if (marcacao.equals("o")){
            this.marcacao = "\u26AA";
        }
        this.placar = 0;
    }

    public void trocarMarcacaoUsuario(String marcacaoAtual){
        if(marcacaoAtual.equals("\u2716")){
            this.marcacao = "\u26AA";
        } else {
            this.marcacao = "\u2716";
        }
    }


}
