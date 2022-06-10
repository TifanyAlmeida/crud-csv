import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroProduto {

    int qtdProdutoCadastro, cont = 0;
    String conjuntoLinha;
    List<String> conteudo = new ArrayList<>();

    Scanner tec = new Scanner(System.in);

    private String nomeProduto, fornecedor;
    private int quantidadeProduto;
    private double valorProduto;

    public CadastroProduto(){

    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public void cadastrarProduto(){

        System.out.println("\n\t\t&&&&&&&&&& CADASTRO DE PRODUTOS &&&&&&&&&&");
        System.out.print("\n\n\t\t- Quantos Produtos deseja Cadastrar: ");
        qtdProdutoCadastro = tec.nextInt();
        tec.nextLine();

        while(cont<qtdProdutoCadastro) {
            cont++;

            System.out.print("\n\n\t\t\t- Nome do Produto: ");
            setNomeProduto(tec.nextLine());

            System.out.print("\n\t\t\t- Fornecedor: ");
            setFornecedor(tec.nextLine());

            System.out.print("\n\t\t\t- Quantidade: ");
            setQuantidadeProduto(tec.nextInt());
            tec.nextLine();

            System.out.print("\n\t\t\t- Valor: R$ ");
            setValorProduto(tec.nextDouble());
            tec.nextLine();

            System.out.println("\t\t\t\n--------");

            conjuntoLinha = getNomeProduto()+","+getFornecedor()+","+getQuantidadeProduto()+","+getValorProduto();
            conteudo.add(conjuntoLinha);
        }

        try {
            File caminho = new File("produtos.csv");

            FileWriter arquivo = new FileWriter(caminho, StandardCharsets.UTF_8, true);
            for (String produto : conteudo) {
                arquivo.write("\n"+produto);
            }
            arquivo.flush();
            arquivo.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
