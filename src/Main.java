public class Main {
    public static void main(String[] args) {
        String teste = "\u26AA";
        String teste2 = "\u2716";
        String[][] tabuleiro = new String[3][3];
        tabuleiro[1][2] = teste2;
        tabuleiro[2][2] = teste;
        tabuleiro[1][1] = teste;
        tabuleiro[0][2] = teste;
        tabuleiro[2][0] = teste;
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
                System.out.println("________________________________________");
            }
        }
    }
}