package Models;

import java.util.Scanner;

public class Jogador {
    public String nome;
    public int placar;
    public String marcacao;
    public boolean jogadorDaVez;


    static Scanner scanner = new Scanner(System.in);

    public Jogador(String nome, String marcacao,boolean jogadorDaVez){
        this.nome = nome;
        if(marcacao.equals("x")){
            this.marcacao = "\u2716";
        } else if (marcacao.equals("o")){
            this.marcacao = "\u26AA";
        }
        this.placar = 0;
        this.jogadorDaVez = jogadorDaVez;
    }
    public Jogador(){}

    public static void trocarMarcacaoJogadores(Jogador[] jogadores) {
        System.out.println("Foi alterado a marcação dos usuarios");
        for(int i=0;i< jogadores.length;i++){
            jogadores[i].trocarMarcacaoUsuario();
            if(jogadores[i].jogadorDaVez){
                System.out.printf("O Jogador %s inicia agora!\n", jogadores[i].nome);
            }
        }
    }

    private void trocarMarcacaoUsuario(){
        if(this.marcacao.equals("\u2716")){
            this.marcacao = "\u26AA";
            this.jogadorDaVez = false;
        } else {
            this.marcacao = "\u2716";
            this.jogadorDaVez = true;
        }
    }

    public static Jogador alterarJogadorDaVez(Jogador[] jogadores){
        Jogador jogador = new Jogador();
        for(int i = 0; i<jogadores.length;i++){
            if(jogadores[i].jogadorDaVez){
                jogadores[i].jogadorDaVez = false;
                jogador = jogadores[i];
            } else {
                jogadores[i].jogadorDaVez = true;
            }
        }
        return jogador;
    }

    public static Jogador[] criarJogadoresParaOJogoDaVelha(){

        Jogador[] jogadores = new Jogador[2];
        System.out.println("Digite o nome do primeiro jogador (Jogará primeiro e começar sendo o \u2716)");
        String nomePrimeiroJogador = scanner.nextLine();
        Jogador player1 = new Jogador(nomePrimeiroJogador, "x",true);

        System.out.println("Digite o nome do segundo jogador (Jogará segundo e começar sendo o \u26AA)");
        String nomeSegundoJogador = scanner.nextLine();
        Jogador player2 = new Jogador(nomeSegundoJogador,"o",false);
        System.out.println("");
        return new Jogador[] {player1,player2};

    }

}
