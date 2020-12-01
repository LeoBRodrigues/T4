package Base.UserInteraction;

import Base.DAO.PersonagemDAO;
import Base.Model.Personagem;

import java.util.Scanner;

public class Menu {


    private PersonagemDAO dao = new PersonagemDAO();
    private Scanner scanner = new Scanner(System.in);

    public void run(){
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

    private void userAction(String option){
        switch (option){
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

        }
    }

    private void criarPersonagem() {

        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        System.out.println("Raça: ");
        String raca = scanner.nextLine();
        System.out.println("Profissao: ");
        String profissao = scanner.nextLine();
        System.out.println("Mana: ");
        Integer mana = Integer.parseInt(scanner.nextLine());
        System.out.println("Ataque: ");
        Integer ataque = Integer.parseInt(scanner.nextLine());
        System.out.println("Defesa: ");
        Integer defesa = Integer.parseInt(scanner.nextLine());
        System.out.println("Defesa magica: ");
        Integer defesa_magica =Integer.parseInt(scanner.nextLine());
        System.out.println("Velocidade: ");
        Integer velocidade =Integer.parseInt(scanner.nextLine());
        System.out.println("Destreza: ");
        Integer destreza =Integer.parseInt(scanner.nextLine());
        System.out.println("Experiencia: ");
        Integer experiencia = Integer.parseInt(scanner.nextLine());
        System.out.println("Nivel atual: ");
        Integer nivel_atual = Integer.parseInt(scanner.nextLine());

        Personagem personagem = new Personagem( nome,  raca,  profissao,  mana,  ataque,  defesa,  defesa_magica,  velocidade,  destreza,  experiencia,  nivel_atual);



        dao.insertDB(personagem);

        System.out.println("INSERIDO COM SUCESSO");
        System.out.println(personagem);





    }

    private void apagarPersonagem() {
        System.out.println("Apagar");
    }

    private void modificarPersonagem() {
        System.out.println("Modificar");
    }

    private void consultarPersonagens() {
        System.out.println("Sair");
    }

}
