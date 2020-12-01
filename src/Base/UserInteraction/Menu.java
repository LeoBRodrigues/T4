package Base.UserInteraction;

import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);

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
        System.out.println("Raça: ");
        System.out.println("Profissao: ");
        System.out.println("Mana: ");
        System.out.println("Ataque: ");
        System.out.println("Defesa: ");
        System.out.println("Defesa magica: ");
        System.out.println("Destreza: ");
        System.out.println("Experiencia: ");
        System.out.println("Nivel atual: ");

    }

    private void apagarPersonagem() {
    }

    private void modificarPersonagem() {
    }

    private void consultarPersonagens() {
    }

}
