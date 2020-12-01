package Base.Model;
import java.util.UUID;

public class Personagem {

    private UUID id = UUID.randomUUID();
    private String nome;
    private String raca;
    private String profissao;
    private Integer mana;
    private Integer ataque;
    private Integer defesa;
    private Integer defesa_magica;
    private Integer velocidade;
    private Integer destreza;
    private Integer experiencia;
    private Integer nivel_atual;

    public Personagem(String nome, String raca, String profissao, Integer mana, Integer ataque, Integer defesa, Integer defesa_magica, Integer velocidade, Integer destreza, Integer experiencia, Integer nivel_atual) {
        this.nome = nome;
        this.raca = raca;
        this.profissao = profissao;
        this.mana = mana;
        this.ataque = ataque;
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
                "Nome: " + nome + '\n' +
                "Raça: " + raca + '\n' +
                "Profissão: " + profissao + '\n' +
                "Mana: " + mana + '\n' +
                "Ataque: " + ataque +'\n' +
                "Defesa: " + defesa +'\n' +
                "Defesa Mágica: " + defesa_magica +'\n' +
                "Velocidade: " + velocidade +'\n' +
                "Destreza: " + destreza +'\n' +
                "Experiência: " + experiencia +'\n' +
                "Nível Atual: " + nivel_atual +'\n' +
                "ID: " + id +'\n' +
                "-------------------------------";
    }

    public UUID getId() {
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

    public Integer getMana() {
        return mana;
    }

    public Integer getAtaque() {
        return ataque;
    }

    public Integer getDefesa() {
        return defesa;
    }

    public Integer getDefesa_magica() {
        return defesa_magica;
    }

    public Integer getVelocidade() {
        return velocidade;
    }

    public Integer getDestreza() {
        return destreza;
    }

    public Integer getExperiencia() {
        return experiencia;
    }

    public Integer getNivel_atual() {
        return nivel_atual;
    }
}
