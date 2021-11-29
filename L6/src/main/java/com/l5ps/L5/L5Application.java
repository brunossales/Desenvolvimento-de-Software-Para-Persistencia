package com.l5ps.L5;

import com.l5ps.L5.DAO.FuncionarioDAO;
import com.l5ps.L5.DAO.FuncionarioDAOJDBC;
import com.l5ps.L5.DAO.GenericDAO;
import com.l5ps.L5.DAO.GenericJPADAO;
import com.l5ps.L5.UI.UI;
import com.l5ps.L5.model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class L5Application implements CommandLineRunner {

	private GenericDAO funDAO = new GenericJPADAO<Funcionario>(Funcionario.class);
	public static void main(String[] args) {
		//SpringApplication.run(L5Application.class, args);
		SpringApplicationBuilder builder = new SpringApplicationBuilder(L5Application.class);
		builder.headless(false).run(args);
	}

	@Override
	public void run(String... args) throws Exception {
			long start = System.currentTimeMillis();
			String op;

			do{
				try {
					op = UI.view();
					switch (op) {
						case "1":
							List<Funcionario> funs = funDAO.findAll();
							StringBuffer sb = new StringBuffer();
							for (Funcionario f : funs)
								sb.append(f).append("\n");
							JOptionPane.showMessageDialog(null, sb.toString(), "Funcionários armazenados no Banco", JOptionPane.INFORMATION_MESSAGE);
							break;
						case "2":
							String id = UI.viewForId();
							Funcionario fun = (Funcionario) funDAO.findId(Integer.parseInt(id));
							JOptionPane.showMessageDialog(null, fun, "Find By Id", JOptionPane.INFORMATION_MESSAGE);
							break;
						case "3":
							Funcionario funcs = UI.viewForInsert();
							funDAO.insert(funcs);
							break;
						case "4":
							String op11 = UI.viewForId();
							String op44 = JOptionPane.showInputDialog(null, "Nome - String");

							funDAO.updateNome(Integer.parseInt(op11), op44);
							break;
						case "5":
							String opp = UI.viewForId();
							String op55 = JOptionPane.showInputDialog(null, "Email - String");

							funDAO.updateEmail(Integer.parseInt(opp), op55);
							break;
						case "6":
							String oop = UI.viewForId();
							String op66 = JOptionPane.showInputDialog(null, "Telefone - String");

							funDAO.updateTelefone(Integer.parseInt(oop), op66);
							break;
						case "7":
							String idDelete = UI.viewForId();

							funDAO.delete(Integer.parseInt(idDelete));
							break;
						case "8":
							long elapsed = (System.currentTimeMillis() - start) / 1000;
							JOptionPane.showMessageDialog(null, "Exiting For the Menu...\nTime for de session: " + elapsed + "seg", "Exit", JOptionPane.INFORMATION_MESSAGE);
							break;
						default:
							JOptionPane.showMessageDialog(null, "Digite uma Opção válida!", "Opção errada", JOptionPane.ERROR_MESSAGE);
					}
				}catch (NullPointerException z){
					long elapsed = (System.currentTimeMillis() - start) / 1000;
					JOptionPane.showMessageDialog(null, "Exiting For the Menu...\nTime for de session: " + elapsed + "seg", "Exit", JOptionPane.INFORMATION_MESSAGE);
					op = "8";
				}
			}while(!op.equals("8"));
			//funDAO.insert(new Funcionario(1, "000.000.000-00", 395878, "Bruno", "Bruno@hotmail", "88997970847"));
		}
	}

