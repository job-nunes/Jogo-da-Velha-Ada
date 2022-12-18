import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String bolinha = "\u26AA";
    static String xis = "\u2716";
    public static void main(String[] args) {

        String[][] tabuleiro = new String[3][3];
        tabuleiro[1][2] = xis;
        tabuleiro[2][2] = bolinha;
        tabuleiro[1][1] = bolinha;
        mostrarTabuleiro(tabuleiro);
        //asdasd
    }

    public static void mostrarTabuleiro(String[][] tabuleiro){
        for(int linha = 0; linha < tabuleiro.length; linha++){
            for(int coluna = 0; coluna < tabuleiro[linha].length; coluna++){
                if(tabuleiro[linha][coluna] == null){
                    System.out.printf("\t\t");
                } else {
                    System.out.printf("\t"+tabuleiro[linha][coluna]+"\t");
                }

                if(coluna != tabuleiro[linha].length - 1){
                    System.out.printf("\t|\t");
                }
            }
            System.out.println();
            if(linha != tabuleiro.length-1) {
                System.out.println("_____________________________________________");
            }
        }
    }

    public static void marcarNoTabuleiro(String[][] tabuleiro, String posicao, String marcacao){
        boolean isPosicaoValida = ValidarPosicao(tabuleiro,posicao);
        if(isPosicaoValida){
            int[] posicoes = receberPosicoesStringToInt(posicao);
            if(marcacao.equals("x")){
                tabuleiro[posicoes[0]][posicoes[1]] = xis;
            } else {
                tabuleiro[posicoes[0]][posicoes[1]] = bolinha;
            }
        }
    }

    private static boolean ValidarPosicao(String[][] tabuleiro, String posicao) {
        int[] posicoesDigitadas = receberPosicoesStringToInt(posicao);
        if(posicoesDigitadas[0] > tabuleiro.length){
            System.out.println("A linha digitada é maior do que a quantidade de linhas possíveis");
            return false;
        }
        if(posicoesDigitadas[1] > tabuleiro[posicoesDigitadas[1]].length){
            System.out.println("A coluna digitada é maior do que a quantidade de colunas possíveis");
            return false;
        }
        if(tabuleiro[posicoesDigitadas[0]][posicoesDigitadas[1]] != null) {
            System.out.println("A posição digitada já possui um valor: " + tabuleiro[posicoesDigitadas[0]][posicoesDigitadas[1]]);
            return false;
        }
        return true;
    }

    private static int[] receberPosicoesStringToInt(String posicao) {
        String[] posicoes = posicao.split(",");
        int[] numerosPosicoes = {Integer.parseInt(posicoes[0]), Integer.parseInt(posicoes[1])};
        return numerosPosicoes;
    }

}