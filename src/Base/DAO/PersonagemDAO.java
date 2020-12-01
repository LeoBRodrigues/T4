package Base.DAO;

import Base.Model.Personagem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PersonagemDAO implements DAO<Personagem> {

    private Connection conn;

    private String DB = "jdbc:sqlite:T4_RPG.db";



    public PersonagemDAO(){

        try {
            conn = DriverManager.getConnection(DB);
        } catch (SQLException throwables) {

            throwables.printStackTrace();
        }

    }

    @Override
    public List<Personagem> getAll() {
        return null;
    }

    @Override
    public void insertDB(Personagem personagem) {

        String query = "INSERT INTO personagens " +
                "(id, nome, raca, profissao, mana, ataque, defesa_magica, velocidade, destreza, experiencia, nivel_atual ) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(query);

        ps.setInt(1, personagem.getId());
        ps.setString(2, personagem.getNome());
        ps.setString(3, personagem.getRaca());
        ps.setString(4, personagem.getProfissao());
        ps.setInt(5, personagem.getMana());
        ps.setInt(6, personagem.getAtaque());
        ps.setInt(7, personagem.getDefesa_magica());
        ps.setInt(8, personagem.getVelocidade());
        ps.setInt(9, personagem.getMana());
        ps.setInt(10, personagem.getMana());
        ps.setInt(11, personagem.getMana());

        ps.executeUpdate();

    }
}
