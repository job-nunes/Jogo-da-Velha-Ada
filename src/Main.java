import Models.EtapaTabuleiro;
import Models.Jogador;
import Models.Tabuleiro;

import java.time.chrono.ThaiBuddhistChronology;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.tabuleiro = new String[3][3];
        tabuleiro.etapaTabuleiro = EtapaTabuleiro.JogoComecando;
        tabuleiro.jogadores = Jogador.criarJogadoresParaOJogoDaVelha();
        Jogador jogadorDaVez = new Jogador();
        String posicao = "";
        String opcaoMenu = "";
        System.out.println("O Jogo vai começar!");

        while(!opcaoMenu.equals("5")){
            for(int i = 0; i < tabuleiro.jogadores.length; i++){
                if(tabuleiro.jogadores[i].jogadorDaVez){
                    System.out.printf("Digite sua jogada, %s. (Você marca com %s)\n", tabuleiro.jogadores[i].nome,tabuleiro.jogadores[i].marcacao);
                    System.out.printf("Digite no formato (linha,coluna) de 1 a %d.\n", tabuleiro.tabuleiro.length);
                    jogadorDaVez = tabuleiro.jogadores[i];
                }
            }
            posicao = scanner.nextLine();

            tabuleiro.marcarNoTabuleiro(posicao,jogadorDaVez);


            if(tabuleiro.etapaTabuleiro == EtapaTabuleiro.JogoConcluido){
                System.out.println();
                System.out.println("1 - Continuar Jogando");
                System.out.println("5 - Sair");
                opcaoMenu = scanner.nextLine();
                if(opcaoMenu.equals("1")){
                    tabuleiro.etapaTabuleiro = EtapaTabuleiro.JogoEmAndamento;
                    Jogador.trocarMarcacaoJogadores(tabuleiro.jogadores);
                }
            }
        }
        System.out.println("O jogo acabou!");
    }


}