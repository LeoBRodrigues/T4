package Base.UserInteraction;

import Base.DAO.PersonagemDAO;
import Base.Model.Personagem;
import org.sqlite.core.DB;

import java.util.List;
import java.util.Scanner;

public class Menu {


    private PersonagemDAO dao = new PersonagemDAO();
    private Scanner scanner = new Scanner(System.in);
    private List<Personagem> DBPersonagens = dao.getAll();
    private boolean flag = true;

    /**
     * Função de funcionamento principal.
     */

    public void run(){

        while(flag) {
            System.out.println("Qual a ação desejada?");
            System.out.println("" +
                    "[0] Criar novo personagem\n"+
                    "[1] Apagar personagem\n"+
                    "[2] Modificar personagem\n"+
                    "[3] Consultar personagens\n"+
                    "[q/Q] Sair\n");
            String option = scanner.nextLine();
            userAction(option);
        }
    }

    /**
     * Função para lidar com os inputs de usuários.
     * @param option entrada númerica do usuário.
     */
    private void userAction(String option){
        switch (option.toLowerCase()){
            case ("0"):
                criarPersonagem();
                break;
            case("1"):
                apagarPersonagem();
                break;
            case("2"):
                modificarPersonagem();
                break;
            case("3"):
                consultarPersonagens();
                break;
            case("q"):
                flag = false;
                break;
            default:
                System.out.println("Opção Inválida. Tente novamente." );

        }
    }

    /**
     * Lê os dados da personagem sendo cadastrada ou modificada.
     * @return objeto do tipo Personagem com seus atributos cadastrados.
     */
    private Personagem inputDados(){

        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        System.out.println("Raça: ");
        String raca = scanner.nextLine();
        System.out.println("Profissao: ");
        String profissao = scanner.nextLine();
        System.out.println("Mana: ");
        int mana = Integer.parseInt(scanner.nextLine());
        System.out.println("Ataque: ");
        int ataque = Integer.parseInt(scanner.nextLine());
        System.out.println("Ataque Mágico: ");
        int ataque_magico = Integer.parseInt(scanner.nextLine());
        System.out.println("Defesa: ");
        int defesa = Integer.parseInt(scanner.nextLine());
        System.out.println("Defesa magica: ");
        int defesa_magica =Integer.parseInt(scanner.nextLine());
        System.out.println("Velocidade: ");
        int velocidade =Integer.parseInt(scanner.nextLine());
        System.out.println("Destreza: ");
        int destreza =Integer.parseInt(scanner.nextLine());
        System.out.println("Experiencia: ");
        int experiencia = Integer.parseInt(scanner.nextLine());
        System.out.println("Nivel atual: ");
        int nivel_atual = Integer.parseInt(scanner.nextLine());

        return new Personagem(
                nome,
                raca,
                profissao,
                mana,
                ataque,
                ataque_magico,
                defesa,
                defesa_magica,
                velocidade,
                destreza,
                experiencia,
                nivel_atual);
    }

    /**
     * Atualiza o banco de dados.
     */
    private void updateDB() {
        DBPersonagens = dao.getAll();
    }

    /**
     * Cria a personagem a ser cadastrada.
     */
    private void criarPersonagem() {


        Personagem personagem = inputDados();

        personagem.setId(dao.geradorID(personagem));

        dao.insertDB(personagem);

        System.out.println("INSERIDO COM SUCESSO");
        System.out.println(personagem);

    }

    /**
     * Apaga a Personagem selecionada por sua ID.
     */
    private void apagarPersonagem() {
        System.out.println("Digite o ID da personagem a ser apagada: ");

        int ID = Integer.parseInt(scanner.nextLine());

         for (Personagem personagem : DBPersonagens){
            if (personagem.getId() == ID){
                dao.deleteDB(personagem, ID);
                System.out.println("Personagem removida com sucesso.");
                break;
            }
        }
    }

    /**
     * Modifica a Personagem selecionada por sua ID.
     */
    private void modificarPersonagem() {
        System.out.println("Digite o ID da personagem a ser modificada: ");

        int ID = Integer.parseInt(scanner.nextLine());

        System.out.println("Digite os novos dados da personagem: ");

        Personagem personagem = inputDados();

        dao.alterDB(personagem, ID);
    }

    /**
     * Mostra todas as personagens cadastradas no sistema.
     */
    private void consultarPersonagens() {

        System.out.println("PERSONAGENS CADASTRADOS: " + '\n');
        updateDB();

        for (Personagem personagem : DBPersonagens) {
            System.out.print(personagem + "\n");
        }
    }

}
