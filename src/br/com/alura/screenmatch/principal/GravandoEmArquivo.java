package br.com.alura.screenmatch.principal;

import java.io.FileWriter;
import java.io.IOException;

public class GravandoEmArquivo {
    public static void main(String[] args) throws IOException {

        String texto = "Conteúdo a ser gravado no arquivo.";

        FileWriter escrita = new FileWriter("arquivo.txt");
        escrita.write(texto);
        escrita.close();

        System.out.println("O arquivo foi criado com sucesso!");
    }
}
