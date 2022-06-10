import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RemoveProduto {

    public void removerProduto() throws IOException {

        Scanner tec = new Scanner(System.in);
        int opRemover;
        String linhas;
        List<String> conteudoFinal = new ArrayList<>();

        File caminho = new File("produtos.csv");

        System.out.println("\n\t\t&&&&&&&&&& REMOÇÃO DE PRODUTOS &&&&&&&&&&");
        System.out.print("\n\t\t [1] - Apagar Arquivo\n\t\t [2] - Apagar uma Linha\n\t\t [3] - Sair\n\n\t - Opção: ");
        opRemover = tec.nextInt();

        tec.nextLine();

        if(opRemover == 1){
            caminho.delete();
        }

        else if(opRemover == 2) {

            BufferedReader leitorCSV = new BufferedReader(new FileReader(caminho));
            String linhaAlinha = "";

            System.out.print("\n\t\t- Qual linha deseja Apagar: ");
            int linhaApagar = tec.nextInt();
            tec.nextLine();

            System.out.println("------------------------------------");
            while ((linhas = leitorCSV.readLine()) != null) {
                String[] dados = linhas.split(",");

                for (int i = 0; i < 4; i++) {
                    System.out.print(dados[i]+",");
                    linhaAlinha += dados[i] + ",";
                }
                System.out.println();

                conteudoFinal.add(linhaAlinha.substring(0, linhaAlinha.length() - 1));
                linhaAlinha = "";
            }
            //sobrescrever
            FileWriter arquivo = new FileWriter(caminho, StandardCharsets.UTF_8);

            for (int i = 0; i < conteudoFinal.size(); i++) {
                if(i != linhaApagar-1) {
                    arquivo.write(conteudoFinal.get(i) + "\n");
                }
            }
            arquivo.flush();
            arquivo.close();
        }

        else if(opRemover == 3){
            System.out.println();
        }
        else{
            System.out.println("\n\n\t\t** Digite Apenas Itens do Menu **\n");
            removerProduto();
        }
        System.out.print("\n\n\t\t---------------------------------\n\n");
    }
}
