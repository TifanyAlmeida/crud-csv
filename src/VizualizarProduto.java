import java.io.*;
import java.util.Scanner;

public class VizualizarProduto {


    int opVizualizar = 0;

    Scanner tec = new Scanner(System.in);

    public void vizualizarProduto() throws IOException {

        int colunaVizualiza = 0, cont = 0, total = 0, qtdProdutos = 0;
        double totalDouble = 0;

        System.out.println("\n\t\t&&&&&&&&&& VIZUALIZAÇÃO DE PRODUTOS &&&&&&&&&&");
        System.out.print("\n\t\t [1] - Ler uma Determinada Coluna\n\t\t [2] - Ler todas as Colunas\n\t\t [3] - Sair\n\n\t - Opção: ");
        opVizualizar = tec.nextInt();
        tec.nextLine();

        String linhas;
        File caminho = new File("produtos.csv");
        BufferedReader leitorCSV = new BufferedReader(new FileReader(caminho));

        if(opVizualizar == 1) {

            while ((linhas = leitorCSV.readLine()) != null) {

                String[] dados = linhas.split(",");
                cont++;

                if (cont == 1) {
                    for (int i = 0; i < 4; i++) {
                        System.out.printf("\n\t\t[%d] - %s", cont, dados[i]);
                        cont++;
                    }
                    System.out.print("\n\n\t\t- Qual coluna Deseja Vizualizar?: ");
                    colunaVizualiza = tec.nextInt();
                    tec.nextLine();
                    cont = 1;
                    System.out.printf("\n\n\t\t------------ %s ------------", dados[colunaVizualiza - 1]);
                } else {
                    if (colunaVizualiza == 1) {
                        System.out.printf("\n\t\t%s", dados[colunaVizualiza - 1]);
                    } else if (colunaVizualiza == 2) {
                        System.out.printf("\n\t\t%s", dados[colunaVizualiza - 1]);
                    } else if (colunaVizualiza == 3) {
                        System.out.printf("\n\t\t%s", dados[colunaVizualiza - 1]);
                        total += Integer.parseInt(dados[colunaVizualiza - 1]);
                    } else if (colunaVizualiza == 4) {
                        System.out.printf("\n\t\tR$ %s", dados[colunaVizualiza - 1]);
                        totalDouble += Double.parseDouble(dados[colunaVizualiza - 1]);
                    }
                }
            }
            if (colunaVizualiza == 3) {
                System.out.printf("\n\t\tTOTAL: %d", total);
            } else if (colunaVizualiza == 4) {
                System.out.printf("\n\t\tTOTAL: R$ %.2f", totalDouble);
            }
            System.out.print("\n\n\t\t---------------------------------\n\n");
            vizualizarProduto();
        }

        else if(opVizualizar == 2){

            System.out.print("\n---------------------------------\n");
            String linha;

            System.out.print(leitorCSV.readLine());
            System.out.println("\n");

            while ((linha = leitorCSV.readLine()) != null) {
                System.out.println(linha);
                qtdProdutos++;
            }
            System.out.printf("\nPRODUTOS CADASTRADOS: %d", qtdProdutos);
            System.out.print("\n---------------------------------\n");
            vizualizarProduto();
        }

        else if(opVizualizar == 3){
            System.out.println();
        }

        else{
            System.out.println("\n\n\t\t** Digite Apenas Itens do Menu **\n");
            vizualizarProduto();
        }
    }
}
