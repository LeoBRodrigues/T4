package Base.DAO;

import Base.Model.Personagem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class PersonagemDAO implements DAO<Personagem> {

    private Connection conn;

    private String DB = "jdbc:sqlite:T4_RPG.db";

    /**
     * Construtor que lida com conexão ao banco de dados.
     */
    public PersonagemDAO(){

        try {
            conn = DriverManager.getConnection(DB);
        } catch (SQLException throwables) {

            throwables.printStackTrace();
        }

    }

    /**
     * Retorna todas as personagens cadastradas no banco de dados
     * @return Lista de personagens com objetos do tipo Personagem.
     */
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

                personagem.setId(result.getInt("ID"));
                personagens.add(personagem);
            }



        } catch (Exception e) { e.printStackTrace(); }

        return personagens;
    }


    /**
     * Insere personagem atribuida no banco de dados.
     * @param personagem Personagem a ser inserida.
     */
    @Override
    public void insertDB(Personagem personagem) {

        try {
            String query = "INSERT INTO personagens " +
                    "(id, " +
                    "nome, " +
                    "raca, " +
                    "profissao, " +
                    "mana, " +
                    "ataque, " +
                    "ataque_magico, " +
                    "defesa, defesa_magica, " +
                    "velocidade, " +
                    "destreza, " +
                    "experiencia, " +
                    "nivel_atual ) " +
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

    /**
     * Remove personagem do banco de dados de acordo com seu ID.
     * @param personagem Personagem a ser testada contra o ID
     * @param ID ID da personagem a ser deletada.
     */
    @Override
    public void deleteDB(Personagem personagem, int ID) {

        try {
            String query = "DELETE FROM personagens WHERE ID = ? ";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, ID);
            ps.executeUpdate();


        } catch (Exception e){

            e.printStackTrace();
        }
    }

    /**
     * Altera personagem baseada em seu ID.
     * @param personagem Personagem a ser testada contra o ID
     * @param ID ID da personagem a ser modificada.
     */
    @Override
    public void alterDB(Personagem personagem, int ID){

        try {

            String query = "UPDATE personagens " +
                    "SET nome = ? , " +
                    "raca = ? , " +
                    "profissao = ? , " +
                    "mana= ? , " +
                    "ataque= ? , " +
                    "ataque_magico= ? , " +
                    "defesa= ? , " +
                    "defesa_magica= ? , " +
                    "velocidade= ? , " +
                    "destreza= ? , " +
                    "experiencia= ? , " +
                    "nivel_atual= ?  " +
                    "WHERE ID = ?";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, personagem.getNome());
            ps.setString(2, personagem.getRaca());
            ps.setString(3, personagem.getProfissao());
            ps.setInt(4, personagem.getMana());
            ps.setInt(5, personagem.getAtaque());
            ps.setInt(6, personagem.getAtaque_magico());
            ps.setInt(7, personagem.getDefesa());
            ps.setInt(8, personagem.getDefesa_magica());
            ps.setInt(9, personagem.getVelocidade());
            ps.setInt(10, personagem.getDestreza());
            ps.setInt(11, personagem.getExperiencia());
            ps.setInt(12, personagem.getNivel_atual());
            ps.setInt(13, ID);

            ps.executeUpdate();

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Função para gerar números pseudo aleatórios para servirem de ID.
     * @param personagem personagem a ter o ID atribuido.
     * @return retorna um número cálculado pelo hash de atributos da personagem somados a um número
     * pseudo aleatório.
     */
    public int geradorID(Personagem personagem){

        Random random = new Random();

        return Math.abs(Objects.hash(personagem.getRaca(),personagem.getProfissao()) + random.nextInt(10000));
    }

}

