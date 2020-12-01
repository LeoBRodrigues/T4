package Base.Model;

public class Personagem { ;

    static int instanceCounter = 0;
    private int id;
    private String nome;
    private String raca;
    private String profissao;
    private int mana;
    private int ataque;
    private int ataque_magico;
    private int defesa;
    private int defesa_magica;
    private int velocidade;
    private int destreza;
    private int experiencia;
    private int nivel_atual;

    public Personagem(String nome, String raca, String profissao, int mana, int ataque, int ataque_magico, int defesa, int defesa_magica, int velocidade, int destreza, int experiencia, int nivel_atual) {
        instanceCounter++;

        this.id = instanceCounter;
        this.nome = nome;
        this.raca = raca;
        this.profissao = profissao;
        this.mana = mana;
        this.ataque = ataque;
        this.ataque_magico = ataque_magico;
        this.defesa = defesa;
        this.defesa_magica = defesa_magica;
        this.velocidade = velocidade;
        this.destreza = destreza;
        this.experiencia = experiencia;
        this.nivel_atual = nivel_atual;
    }

    @Override
    public String toString() {
        return "-----------Personagem----------" +'\n' +
                "ID: " + id +'\n' +
                "Nome: " + nome + '\n' +
                "Raça: " + raca + '\n' +
                "Profissão: " + profissao + '\n' +
                "Mana: " + mana + '\n' +
                "Ataque: " + ataque +'\n' +
                "Ataque Mágico: " + ataque_magico + '\n' +
                "Defesa: " + defesa +'\n' +
                "Defesa Mágica: " + defesa_magica +'\n' +
                "Velocidade: " + velocidade +'\n' +
                "Destreza: " + destreza +'\n' +
                "Experiência: " + experiencia +'\n' +
                "Nível Atual: " + nivel_atual +'\n' +
                "-------------------------------";
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getRaca() {
        return raca;
    }

    public String getProfissao() {
        return profissao;
    }

    public int getMana() {
        return mana;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getAtaque_magico() {
        return ataque_magico;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getDefesa_magica() {
        return defesa_magica;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public int getDestreza() {
        return destreza;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public int getNivel_atual() {
        return nivel_atual;
    }
}
