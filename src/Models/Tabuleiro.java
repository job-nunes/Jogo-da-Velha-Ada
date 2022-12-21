package Models;

public class Tabuleiro {
    public EtapaTabuleiro etapaTabuleiro;
    public String[][] tabuleiro;
    public Jogador[] jogadores;

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
    public void marcarNoTabuleiro(String posicao, Jogador jogador){
        boolean isPosicaoValida = validarPosicao(posicao);
        if(isPosicaoValida){
            int[] posicoes = receberPosicoesStringToInt(posicao);
            this.tabuleiro[posicoes[0]][posicoes[1]] = jogador.marcacao;
            this.verificarJogadaGanhadora(posicoes,jogador);
            this.mostrarTabuleiro();
            Jogador.alterarJogadorDaVez(this.jogadores);
            if(this.etapaTabuleiro == EtapaTabuleiro.JogoConcluido){
                resetaTabuleiro();
                System.out.println("##### Placar #####");
                for(int i =0; i< this.jogadores.length; i++){
                    System.out.printf("Jogador: %s, placar: %d.\n", this.jogadores[i].nome, this.jogadores[i].placar);
                }
            }
        }

    }
    private boolean validarPosicao(String posicao) {
        int[] posicoesDigitadas = receberPosicoesStringToInt(posicao);
        if(posicoesDigitadas[0] > this.tabuleiro.length-1|| posicoesDigitadas[0] < 0){
            System.out.println("A linha digitada é maior do que a quantidade de linhas possíveis");
            return false;
        }
        if(posicoesDigitadas[1] > this.tabuleiro[posicoesDigitadas[0]].length-1 || posicoesDigitadas[1] < 0){
            System.out.println("A coluna digitada é maior do que a quantidade de colunas possíveis");
            return false;
        }
        if(this.tabuleiro[posicoesDigitadas[0]][posicoesDigitadas[1]] != null) {
            System.out.println("A posição digitada já possui um valor: " + this.tabuleiro[posicoesDigitadas[0]][posicoesDigitadas[1]]);
            return false;
        }
        return true;
    }
    private void verificarJogadaGanhadora(int[] posicoes, Jogador jogador){
        verificarDiagonalPrincipal(posicoes, jogador);
        verificarDiagonalSecundaria(posicoes, jogador);
        verificarColuna(posicoes, jogador);
        verificarLinha(posicoes, jogador);
        if(this.etapaTabuleiro == EtapaTabuleiro.JogoConcluido){
            jogador.placar += 1;
        } else {
            verificarSeAcabaramAsJogadasPossiveis();
        }
    }
    private void verificarSeAcabaramAsJogadasPossiveis() {
        boolean isAcabaramAsJogadasPossiveis = true;
        for (int i = 0;i< this.tabuleiro.length;i++){
            for (int j = 0; j< this.tabuleiro[i].length; j++){
                if(this.tabuleiro[i][j] == null){
                    isAcabaramAsJogadasPossiveis = false;
                }
            }
        }
        if(isAcabaramAsJogadasPossiveis){
            this.etapaTabuleiro = EtapaTabuleiro.JogoConcluido;
            System.out.println("O jogo empatou!");
        }
    }
    private void verificarDiagonalPrincipal(int[] posicoes, Jogador jogador){
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
    private void verificarDiagonalSecundaria(int[] posicoes, Jogador jogador){
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
    private void verificarColuna(int[] posicoes, Jogador jogador){
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
    private void verificarLinha(int[] posicoes, Jogador jogador){
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
    private void resetaTabuleiro(){
        for(int linha = 0; linha < this.tabuleiro.length; linha++){
            for(int coluna = 0; coluna < this.tabuleiro[linha].length; coluna++){
                this.tabuleiro[linha][coluna] = null;
            }
        }
    }
    private int[] receberPosicoesStringToInt(String posicao) {
        String[] posicoes = posicao.split(",");
        int[] numerosPosicoes = {Integer.parseInt(posicoes[0])-1, Integer.parseInt(posicoes[1])-1};
        return numerosPosicoes;

    }
}
