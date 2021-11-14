package UI;

import DAO.ConectionFactory;
import DAO.FuncionarioDAOJDBC;
import DAO.FuncionarioDao;
import model.Funcionario;
import org.postgresql.core.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class GUI {
    public static void main(String[] args) throws SQLException {
        FuncionarioDao funDAO = new FuncionarioDAOJDBC();

        //funDAO.insert(new Funcionario(1, "000.000.000-00", 395878, "Bruno", "Bruno@hotmail", "88997970847"));
    }
}
