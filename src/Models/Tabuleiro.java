package Models;

public class Tabuleiro {
    public EtapaTabuleiro etapaTabuleiro;
    public String[][] tabuleiro;

    public void mostrarTabuleiro(){
        for(int linha = 0; linha < this.tabuleiro.length; linha++){
            for(int coluna = 0; coluna < this.tabuleiro[linha].length; coluna++){
                if(this.tabuleiro[linha][coluna] == null){
                    System.out.printf("\t\t");
                } else {
                    System.out.printf("\t"+this.tabuleiro[linha][coluna]+"\t");
                }

                if(coluna != this.tabuleiro[linha].length - 1){
                    System.out.printf("\t|\t");
                }
            }
            System.out.println();
            if(linha != this.tabuleiro.length-1) {
                System.out.println("---------------------------------------------");
            }
        }
        System.out.println();
    }







    public void verificarJogadaGanhadora(int[] posicoes, Jogador jogador){
        VerificarDiagonalPrincipal(posicoes, jogador);
        VerificarDiagonalSecundaria(posicoes, jogador);
        VerificarColuna(posicoes, jogador);
        VerificarLinha(posicoes, jogador);
        if(this.etapaTabuleiro == EtapaTabuleiro.JogoConcluido){
            jogador.placar += 1;
        } else {
//            VerificarSeAcabaramAsJogadasPossiveis();
        }
    }

//    private void VerificarSeAcabaramAsJogadasPossiveis() {
//        for (int i = 0;i< this.tabuleiro.length;i++){
//            for (int j = 0; j< this.tabuleiro[i].length; j++){
//                if(this.tabuleiro[i][j] == null){
//
//                }
//            }
//        }
//    }

    private void VerificarDiagonalPrincipal(int[] posicoes, Jogador jogador){
        boolean isPosicaoPertenceDiagonalPrincipal = false;
        boolean ganhouPelaDiagonalPrincipal = true;
        for(int i=0;i< this.tabuleiro.length;i++){
            if (posicoes[0] == i && posicoes[1] == i){
                isPosicaoPertenceDiagonalPrincipal = true;
                ganhouPelaDiagonalPrincipal = true;
                break;
            } else {
                ganhouPelaDiagonalPrincipal = false;
            }
        }
        if(isPosicaoPertenceDiagonalPrincipal){
            for(int i = 0; i < this.tabuleiro.length;i++){
                if(this.tabuleiro[i][i] != jogador.marcacao){
                    ganhouPelaDiagonalPrincipal = false;
                    break;
                }
            }
        }
        if(ganhouPelaDiagonalPrincipal){
            this.etapaTabuleiro = EtapaTabuleiro.JogoConcluido;
            System.out.printf("O jogador %s Ganhou pela Diagonal Principal.\n", jogador.nome);
        }

    }
    private void VerificarDiagonalSecundaria(int[] posicoes, Jogador jogador){
        boolean isPosicaoPertenceDiagonalSecundaria = false;
        boolean ganhouPelaDiagonalSecundaria = true;
        for(int i=0;i< this.tabuleiro.length;i++){
            if (posicoes[0] == this.tabuleiro.length-1-i && posicoes[1] == i){
                isPosicaoPertenceDiagonalSecundaria = true;
                ganhouPelaDiagonalSecundaria = true;
                break;
            } else {
                ganhouPelaDiagonalSecundaria = false;
            }
        }

        if(isPosicaoPertenceDiagonalSecundaria){
            for(int i = 0; i < this.tabuleiro.length;i++){
                if(this.tabuleiro[this.tabuleiro.length-1-i][i] != jogador.marcacao){
                    ganhouPelaDiagonalSecundaria = false;
                    break;
                }
            }
        }
        if(ganhouPelaDiagonalSecundaria){
            this.etapaTabuleiro = EtapaTabuleiro.JogoConcluido;
            System.out.printf("O jogador %s Ganhou pela Diagonal Secundária.\n", jogador.nome);
        }
    }
    private void VerificarColuna(int[] posicoes, Jogador jogador){
        boolean ganhouPelaColuna = true;
        for(int i=0;i<this.tabuleiro.length;i++){
            if(this.tabuleiro[i][posicoes[1]] != jogador.marcacao){
                ganhouPelaColuna = false;
                break;
            }
        }
        if(ganhouPelaColuna){
            this.etapaTabuleiro = EtapaTabuleiro.JogoConcluido;
            System.out.printf("O jogador %s Ganhou pela coluna %d.\n", jogador.nome, posicoes[1]+1);
        }
    }
    private void VerificarLinha(int[] posicoes, Jogador jogador){
        boolean ganhouPelaLinha = true;
        for(int i=0;i<this.tabuleiro.length;i++){
            if(this.tabuleiro[posicoes[0]][i] != jogador.marcacao){
                ganhouPelaLinha = false;
                break;
            }
        }
        if(ganhouPelaLinha){
            this.etapaTabuleiro = EtapaTabuleiro.JogoConcluido;
            System.out.printf("O jogador %s Ganhou pela linha %d.\n", jogador.nome, posicoes[0]+1);
        }
    }
}
