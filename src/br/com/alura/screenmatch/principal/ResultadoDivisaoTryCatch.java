package br.com.alura.screenmatch.principal;

import java.util.Scanner;

public class ResultadoDivisaoTryCatch {
    public static void main(String[] args) {

        try {

            System.out.println("""
                    Seja bem-vindo(a) ao teste de tratamento de exceções da divisão de dois números!
                    """);

            Scanner leitura = new Scanner(System.in);

            System.out.println("Escolha o primeiro número para divisão:");
            int numero1 = leitura.nextInt();

            System.out.println("Escolha o segundo número para divisão:");
            int numero2 = leitura.nextInt();

            int resultado = (numero1 / numero2);

            System.out.println("O resultado da divisão é: " + resultado);

        } catch (ArithmeticException e) {
            System.out.println("""
                    O número escolhido para divisão não pode ser 0, ele deve ser igual ou maior a 1.
                    """);
        }

    }
}
