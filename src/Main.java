import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main extends Login{
    public static void main(String[] args) throws IOException{

        int opMenu;

        Scanner tec = new Scanner(System.in);

        Login login = new Login();
        login.lerArquivo();

        DateTimeFormatter data = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter hora = DateTimeFormatter.ofPattern("hh:mm");

        while(true) {

            System.out.println("\n\t\t<<<<<<< CONTROLE DE PRODUTOS >>>>>>>");
            System.out.println("\n\t\t1 - Cadastrar Produtos");
            System.out.println("\t\t2 - Alterar Quantidade de Produtos");
            System.out.println("\t\t3 - Remover Produtos");
            System.out.println("\t\t4 - Listar Produtos Cadastrados no Sistema");
            System.out.println("\t\t5 - Logout");
            System.out.println("\t\t6 - Sair");
            System.out.print("\n\t\t- Opção: ");

            opMenu = tec.nextInt();
            tec.nextLine();
            System.out.println("\n----------------------------------------------------");

            if (opMenu == MenuEnum.CADASTRAR.getValue()) {
                CadastroProduto cadastroProduto = new CadastroProduto();
                cadastroProduto.cadastrarProduto();

                File caminho = new File("LogAcesso.csv");
                FileWriter arquivo = new FileWriter(caminho, StandardCharsets.ISO_8859_1, true);
                arquivo.write("\n"+login.getUsuario()+" cadastrou produtos no dia "+data.format(LocalDateTime.now())+" às "+hora.format(LocalDateTime.now()));
                arquivo.flush();
                arquivo.close();
            }

            else if (opMenu == MenuEnum.ALTERAR.getValue()) {
                File caminho = new File("LogAcesso.csv");
                FileWriter arquivo = new FileWriter(caminho, StandardCharsets.ISO_8859_1, true);
                arquivo.write("\n"+login.getUsuario()+" alterou algum produtos no dia "+data.format(LocalDateTime.now())+" às "+hora.format(LocalDateTime.now()));
                arquivo.flush();
                arquivo.close();
            }

            else if (opMenu == MenuEnum.REMOVER.getValue()) {
                RemoveProduto removeProduto = new RemoveProduto();
                removeProduto.removerProduto();

                File caminho = new File("LogAcesso.csv");
                FileWriter arquivo = new FileWriter(caminho, StandardCharsets.ISO_8859_1, true);
                arquivo.write("\n"+login.getUsuario()+" removeu algum produtos no dia "+data.format(LocalDateTime.now())+" às "+hora.format(LocalDateTime.now()));
                arquivo.flush();
                arquivo.close();
            }

            else if (opMenu == MenuEnum.VIZUALIZAR.getValue()) {

                VizualizarProduto vizualizarProduto = new VizualizarProduto();
                vizualizarProduto.vizualizarProduto();

                File caminho = new File("LogAcesso.csv");
                FileWriter arquivo = new FileWriter(caminho, StandardCharsets.ISO_8859_1, true);
                arquivo.write("\n" + login.getUsuario() + " vizualizou os produtos no dia " + data.format(LocalDateTime.now()) + " às " + hora.format(LocalDateTime.now()));
                arquivo.flush();
                arquivo.close();
            }

            else if (opMenu == MenuEnum.LOGOUT.getValue()) {
                File caminho = new File("LogAcesso.csv");
                FileWriter arquivo = new FileWriter(caminho, StandardCharsets.ISO_8859_1, true);

                arquivo.write("\n"+login.getUsuario()+" saiu do sistema no dia "+data.format(LocalDateTime.now())+" às "+hora.format(LocalDateTime.now()));

                arquivo.flush();
                arquivo.close();
                login.lerArquivo();
            }

            else if (opMenu == MenuEnum.SAIR.getValue()) {
                System.out.println(SaudacaoEnum.Saida.getMsg());

                File caminho = new File("LogAcesso.csv");
                FileWriter arquivo = new FileWriter(caminho, StandardCharsets.ISO_8859_1, true);

                arquivo.write("\n"+login.getUsuario()+" encerrou o sistema no dia "+data.format(LocalDateTime.now())+" às "+hora.format(LocalDateTime.now()));

                arquivo.flush();
                arquivo.close();
                System.exit(0);
            }
            else {
                System.out.println("\t\t**** Digite Apenas Itens do Menu ****");
            }

        }
    }
}
