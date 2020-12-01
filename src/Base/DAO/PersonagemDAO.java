package Base.DAO;

import Base.Model.Personagem;

import java.sql.*;
import java.util.ArrayList;
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

        List<Personagem> personagens = new ArrayList<>();

        try {

            String query = "SELECT * FROM personagens";

            Statement st = conn.createStatement();
            ResultSet result = st.executeQuery(query);

            while (result.next()) {
                Personagem personagem = new Personagem(
                        result.getString("nome"),
                        result.getString("raca"),
                        result.getString("profissao"),
                        result.getInt("mana"),
                        result.getInt("ataque"),
                        result.getInt("ataque_magico"),
                        result.getInt("defesa"),
                        result.getInt("defesa_magica"),
                        result.getInt("velocidade"),
                        result.getInt("destreza"),
                        result.getInt("experiencia"),
                        result.getInt("nivel_atual"));

                personagens.add(personagem);
            }



        } catch (Exception e) { e.printStackTrace(); }

        return personagens;
    }


    @Override
    public void insertDB(Personagem personagem) {

        try {
            String query = "INSERT INTO personagens " +
                    "(id, nome, raca, profissao, mana, ataque, ataque_magico, defesa, defesa_magica, velocidade, destreza, experiencia, nivel_atual ) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, personagem.getId());
            ps.setString(2, personagem.getNome());
            ps.setString(3, personagem.getRaca());
            ps.setString(4, personagem.getProfissao());
            ps.setInt(5, personagem.getMana());
            ps.setInt(6, personagem.getAtaque());
            ps.setInt(7, personagem.getAtaque_magico());
            ps.setInt(8, personagem.getDefesa());
            ps.setInt(9, personagem.getDefesa_magica());
            ps.setInt(10, personagem.getVelocidade());
            ps.setInt(11, personagem.getDestreza());
            ps.setInt(12, personagem.getExperiencia());
            ps.setInt(13, personagem.getNivel_atual());

            ps.executeUpdate();

        } catch(Exception e){

            e.printStackTrace();
        }

    }

    @Override
    public void deleteDB(Personagem personagem, int ID) {

        try {
            String query = "DELETE FROM personagens WHERE id = ? ";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, ID);
            ps.executeUpdate();

        } catch (Exception e){

            e.printStackTrace();
        }
    }
}
