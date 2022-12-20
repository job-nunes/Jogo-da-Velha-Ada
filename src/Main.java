import Models.Jogador;
import Models.Tabuleiro;

import java.time.chrono.ThaiBuddhistChronology;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.tabuleiro = new String[3][3];
        String posicao = "";
        Jogador jogador = new Jogador("teste", "x");
        while(posicao != "-1"){
            System.out.println("Escreva a posição que quer marcar: \n( Usar formato: linha,coluna )");
            posicao = scanner.nextLine();

            marcarNoTabuleiro(tabuleiro,posicao,jogador);
        }
        System.out.println("jogo acabou");
    }

    public static void marcarNoTabuleiro(Tabuleiro tabuleiro, String posicao, Jogador jogador){
        boolean isPosicaoValida = ValidarPosicao(tabuleiro,posicao);
        if(isPosicaoValida){
            int[] posicoes = receberPosicoesStringToInt(posicao);
            tabuleiro.tabuleiro[posicoes[0]][posicoes[1]] = jogador.marcacao;
            tabuleiro.verificarJogadaGanhadora(posicoes,jogador);
            tabuleiro.mostrarTabuleiro();
        }

    }

    private static boolean ValidarPosicao(Tabuleiro tabuleiro, String posicao) {
        int[] posicoesDigitadas = receberPosicoesStringToInt(posicao);
        if(posicoesDigitadas[0] > tabuleiro.tabuleiro.length-1){
            System.out.println("A linha digitada é maior do que a quantidade de linhas possíveis");
            return false;
        }
        if(posicoesDigitadas[1] > tabuleiro.tabuleiro[posicoesDigitadas[0]].length-1){
            System.out.println("A coluna digitada é maior do que a quantidade de colunas possíveis");
            return false;
        }
        if(tabuleiro.tabuleiro[posicoesDigitadas[0]][posicoesDigitadas[1]] != null) {
            System.out.println("A posição digitada já possui um valor: " + tabuleiro.tabuleiro[posicoesDigitadas[0]][posicoesDigitadas[1]]);
            return false;
        }
        return true;
    }

    private static int[] receberPosicoesStringToInt(String posicao) {
        String[] posicoes = posicao.split(",");
        int[] numerosPosicoes = {Integer.parseInt(posicoes[0])-1, Integer.parseInt(posicoes[1])-1};
        return numerosPosicoes;
    }




}