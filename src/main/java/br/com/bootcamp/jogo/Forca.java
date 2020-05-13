package br.com.bootcamp.jogo;

import java.util.Random;
import java.util.Scanner;

public class Forca {
    private static String[] dica;

    public static void main(String[] args) {
        String palavraChave = null;
        int qtdLetras = 0;
        System.out.println("Bem vindo ao jogo!");
        Scanner in = new Scanner(System.in);
        System.out.print("Qual dificuldade do jogo?: F (Fácil); N(Normal); D(Dificil) -->");
        String dificuldadeJogo = in.next().toUpperCase();
        switch (dificuldadeJogo) {
            case "F":
                palavraChave = listaPalavrasFacil();
                break;
            case "N":
                palavraChave = listaPalavrasNormais();
                break;
            case "D":
                palavraChave = listaPalavrasDificeis();
                break;
            default:
                palavraChave = "";
                System.out.println("Nenhuma tecla valida.");
                break;
        }
        String listaEmString = "";
        montaDica(palavraChave.length());
        for (String s : dica) {
            listaEmString = listaEmString + s;
        }

        System.out.println("Qual Letra você chuta? --> ");
        String letraDigitada = in.next().toLowerCase();


        String[] listaLetrasCorretas = palavraChave.split("");

        int i = 0;
        qtdLetras = palavraChave.length();
        while (i < qtdLetras) {
            if (listaLetrasCorretas[i].equals(letraDigitada)) {
                dica[i] = letraDigitada;

            }
            i++;
        }
        String novaDica = "";

        for (String s: dica){
            novaDica+= s;
        }
        System.out.println(novaDica);

    }


    public static String[] montaDica(int qtdLetras) {
        dica = new String[qtdLetras];

        for (int i = 0; i < dica.length; i++) {
            dica[i] = " __ ";
        }
        return dica;
    }

    public static String listaPalavrasFacil() {
        String[] palavras = {"banana", "uva", "maca"};
        Random random = new Random();
        return palavras[random.nextInt(palavras.length - 1)];
    }

    public static String listaPalavrasNormais() {
        String[] palavras = {"abacaxi", "melancia", "melao"};
        Random random = new Random();
        return palavras[random.nextInt(palavras.length-1)];
    }

    public static String listaPalavrasDificeis() {
        String[] palavras = {"carambola", "lichia", "jatoba"};
        Random random = new Random();
        return palavras[random.nextInt(palavras.length-1)];
    }
}
