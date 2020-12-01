package Base.DAO;

import Base.Model.Personagem;

import java.sql.Connection;
import java.sql.DriverManager;
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
    public void insertDB() {

    }
}
