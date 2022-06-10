import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Login {

    Scanner tec = new Scanner(System.in);
    private String usuario;
    private String senha;

    public Login(){

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void lerArquivo() throws IOException{

        int usuario_existente = 0;
        int opStart;
        int cont = 0;
        String linhas;

        System.out.println();
        System.out.println("\t\t[1] - Entrar");
        System.out.println("\t\t[2] - Sair");
        System.out.print("\n\t\t- Opção: ");

        opStart = tec.nextInt();
        tec.nextLine();

        if(opStart == 1){
            System.out.println(SaudacaoEnum.Empresa.getMsg());
        }
        else if(opStart == 2){
            System.out.println(SaudacaoEnum.Saida.getMsg());
            System.exit(0);
        }
        else{
            System.out.println("\n\t\t**** Digite Apenas Itens do Menu ****");
            lerArquivo();
        }

        while(true) {
            File caminho = new File("logins.csv");
            BufferedReader leitorCSV = new BufferedReader(new FileReader(caminho));

            System.out.println("\n\t\t<<<<<<<<<<<<<< LOGIN >>>>>>>>>>>>>>");
            System.out.print("\n\n\t\t- Usuário: ");
            usuario = tec.nextLine();
            System.out.print("\n\t\t- Senha: ");
            senha = tec.nextLine();

            setUsuario(usuario);
            setSenha(senha);

            System.out.println("\n----------------------------------------------------");

            while ((linhas = leitorCSV.readLine()) != null) {

                String[] dados = linhas.split(",");

                if (cont >= 1) {
                    if (dados[0].equalsIgnoreCase(getUsuario()) && String.valueOf(dados[1]).equals(getSenha())) {
                        usuario_existente += 1;
                        break;
                    }
                }
                cont++;
            }

            if(usuario_existente == 0){
                System.out.println("\t\t******* USUÁRIO INVÁLIDO *******");
                leitorCSV.close();
                lerArquivo();
                break;
            }
            else{
                try {
                    File caminhoLog = new File("LogAcesso.csv");
                    FileWriter arquivoLog = new FileWriter(caminhoLog, StandardCharsets.UTF_8, true);

                    DateTimeFormatter data = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    DateTimeFormatter hora = DateTimeFormatter.ofPattern("HH:mm");
                    arquivoLog.write("\n\n" + usuario + " entrou no sistema no dia " + data.format(LocalDateTime.now()) + " às " + hora.format(LocalDateTime.now()));
                    arquivoLog.flush();
                    arquivoLog.close();

                    leitorCSV.close();
                    break;
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
