package com.mycompany.jogodavelha;
import java.util.*;

public class JogoDaVelha {

    public static void main(String[] args) {
        char[][] tabuleiro = {{' ', ' ', ' ',},
                              {' ', ' ', ' ',},
                              {' ', ' ', ' ',}};
       
        mostrarTabuleiro(tabuleiro);

        for (int i = 1; i < 10; i++) {
            
           
            if (usuarioGanhou(tabuleiro)) {
                System.out.println("O Usuário ganhou!!!");
                break;
            } else if (computadorGanhou(tabuleiro)) {
                System.out.println("O Computador ganhou!!!");
                break;
            } else {
                jogadaUsuario(tabuleiro);
                jogadaComputador(tabuleiro);
                mostrarTabuleiro(tabuleiro);
            }
           
           
        }
       
    }

    private static boolean posicaoEhValida (char[][] tabuleiro, int posicao) {
        return switch (posicao) {
            case 1 -> tabuleiro[0][0] == ' '; // se a expressão for verdade retorna true, senao retorna false
        //mesma função do if e else
            case 2 -> tabuleiro[0][1] == ' ';
            case 3 -> tabuleiro[0][2] == ' ';
            case 4 -> tabuleiro[1][0] == ' ';
            case 5 -> tabuleiro[1][1] == ' ';
            case 6 -> tabuleiro[1][2] == ' ';
            case 7 -> tabuleiro[2][0] == ' ';
            case 8 -> tabuleiro[2][1] == ' ';
            case 9 -> tabuleiro[2][2] == ' ';
            default -> false;
        };
    }
   
    private static boolean usuarioGanhou (char[][] tabuleiro) {
        return tabuleiro[0][0] == 'X' && tabuleiro[0][1] == 'X' && tabuleiro[0][2] == 'X' ||
               tabuleiro[1][0] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[1][2] == 'X' ||
               tabuleiro[2][0] == 'X' && tabuleiro[2][1] == 'X' && tabuleiro[2][2] == 'X' ||
               tabuleiro[0][0] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[2][2] == 'X' ||
               tabuleiro[0][2] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[2][0] == 'X' ||
               tabuleiro[0][0] == 'X' && tabuleiro[1][0] == 'X' && tabuleiro[2][0] == 'X' ||
               tabuleiro[0][2] == 'X' && tabuleiro[1][2] == 'X' && tabuleiro[2][2] == 'X' ;
    }
   
    private static boolean computadorGanhou (char[][] tabuleiro) {
        return tabuleiro[0][0] == 'O' && tabuleiro[0][1] == 'O' && tabuleiro[0][2] == 'O' ||
               tabuleiro[1][0] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[1][2] == 'O' ||
               tabuleiro[2][0] == 'O' && tabuleiro[2][1] == 'O' && tabuleiro[2][2] == 'O' ||
               tabuleiro[0][0] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[2][2] == 'O' ||
               tabuleiro[0][2] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[2][0] == 'O' ||
               tabuleiro[0][0] == '0' && tabuleiro[1][0] == 'O' && tabuleiro[2][0] == 'O' ||
               tabuleiro[0][2] == 'O' && tabuleiro[1][2] == 'O' && tabuleiro[2][2] == 'O' ;
    }
   
    private static void escolherJogada(char[][] tabuleiro, int posicao, char simbolo) {
       
            switch (posicao) {
            case 1:
                tabuleiro[0][0] = simbolo;
                break;
            case 2:
                tabuleiro[0][1] = simbolo;
                break;  
            case 3:
                tabuleiro[0][2] = simbolo;
                break;
            case 4:
                tabuleiro[1][0] = simbolo;
                break;
            case 5:
                tabuleiro[1][1] = simbolo;
                break;
            case 6:
                tabuleiro[1][2] = simbolo;
                break;
            case 7:
                tabuleiro[2][0] = simbolo;
                break;
            case 8:
                tabuleiro[2][1] = simbolo;
                break;
            case 9:
                tabuleiro[2][2] = simbolo;
                break;
            default:
                System.out.println("Insira uma posição entre 1 e 9!");      
            }  
    }

    private static void jogadaUsuario(char [][] tabuleiro) {
        Scanner sc = new Scanner(System.in);
        int inputUsuario;
       
        while (true) {
            System.out.println("Onde você quer jogar no tabuleiro? (1-9)");
            inputUsuario = sc.nextInt();
            if (posicaoEhValida(tabuleiro, inputUsuario)) {
                break;
            } else {
                System.out.println(inputUsuario + " Não é uma posição possível, escolha outra:");
            }
        }
       
        escolherJogada(tabuleiro, inputUsuario, 'X');
   
    }
   
    private static void jogadaComputador(char [][] tabuleiro) {
        int jogadaPC;
   
        while (true) {
            jogadaPC = new Random().nextInt(9) + 1;
            if (posicaoEhValida(tabuleiro, jogadaPC)) {
                break;
            }
        }
        System.out.println("O computador escolheu: " + jogadaPC);
        escolherJogada(tabuleiro, jogadaPC, 'O');
    }

    private static void mostrarTabuleiro(char[][] tabuleiro) {
        System.out.println(tabuleiro[0][0] + "|" + tabuleiro[0][1] + "|" + tabuleiro[0][2]);
        System.out.println("-+-+-");
        System.out.println(tabuleiro[1][0] + "|" + tabuleiro[1][1] + "|" + tabuleiro[1][2]);
        System.out.println("-+-+-");
        System.out.println(tabuleiro[2][0] + "|" + tabuleiro[2][1] + "|" + tabuleiro[2][2]);
    }
}