import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class BuscaCep {
    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("""
                                
                //////////////////////////////////////////////////////////
                Seja bem-vindo(a) ao serviço de busca de endereço por CEP!
                //////////////////////////////////////////////////////////
                                
                Ao executar a classe, o resultado da sua busca será exibido no console e gravado em um arquivo JSON.
                                
                """);

        Scanner busca = new Scanner(System.in);

        String cep = null;
        HttpResponse<String> response;
        try {

            System.out.println("Digite um CEP para busca (somente números):");
            cep = busca.nextLine();

            String url = "https://viacep.com.br/ws/" + cep + "/json/";

            System.out.println("A sua busca será realizada para o CEP " + cep + " através da URL " + url);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.body());

            FileWriter buscacep = new FileWriter("cep.json");
            buscacep.write(response.body());
            buscacep.close();

            System.out.println("A busca pelo CEP " + cep + " foi realizada e o arquivo foi criado com sucesso!");

        } catch (RuntimeException | IOException e) {
            System.out.println("Ocorreu um erro na busca pelo CEP " + cep);
        }
    }
}
