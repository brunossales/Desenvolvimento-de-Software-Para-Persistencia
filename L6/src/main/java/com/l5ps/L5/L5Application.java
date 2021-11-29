package com.l5ps.L5;

import com.l5ps.L5.DAO.FuncionarioDAO;
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
	@Autowired
	private FuncionarioDAO funDAO;
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
					op = JOptionPane.showInputDialog(null,
							"1 - Find All\n"
									+ "2 - Find ID\n"
									+ "3 - Insert\n"
									+ "4 - Update Name\n"
									+ "5 - Update Email\n"
									+ "6 - Update Fone\n"
									+ "7 - Delete\n"
									+ "8 - Exit",
							"Menu", JOptionPane.QUESTION_MESSAGE);
					switch (op) {
						case "1":
							List<Funcionario> funs = funDAO.findAll();
							StringBuffer sb = new StringBuffer();
							for (Funcionario f : funs)
								sb.append(f).append("\n");
							JOptionPane.showMessageDialog(null, sb.toString(), "Funcionários armazenados no Banco", JOptionPane.INFORMATION_MESSAGE);
							break;
						case "2":
							String id = JOptionPane.showInputDialog(null, "Digite o id do Funcionário", "Find By ID", JOptionPane.QUESTION_MESSAGE);
							Funcionario fun = funDAO.findId(Integer.parseInt(id));
							JOptionPane.showMessageDialog(null, fun, "Find By Id", JOptionPane.INFORMATION_MESSAGE);
							break;
						case "3":
							String op1 = JOptionPane.showInputDialog(null, "ID - int");
							String op2 = JOptionPane.showInputDialog(null, "CPF - String");
							String op3 = JOptionPane.showInputDialog(null, "Matricula - int");
							String op4 = JOptionPane.showInputDialog(null, "Nome - String");
							String op5 = JOptionPane.showInputDialog(null, "Email - String");
							String op6 = JOptionPane.showInputDialog(null, "Telefone - String");

							Funcionario funcs = new Funcionario(Integer.parseInt(op1), op2, Integer.parseInt(op3), op4, op5, op6);
							funDAO.insert(funcs);
							JOptionPane.showMessageDialog(null, "Inserido!", "Insertion", JOptionPane.INFORMATION_MESSAGE);
							break;
						case "4":
							String idd = JOptionPane.showInputDialog(null, "Insira o ID", "Update By Name", JOptionPane.QUESTION_MESSAGE);
							String namee = JOptionPane.showInputDialog(null, "Insira o Nome", "Update By Name", JOptionPane.QUESTION_MESSAGE);

							funDAO.updateNome(Integer.parseInt(idd), namee);
							JOptionPane.showMessageDialog(null, "Mudado!", "Update By Name", JOptionPane.INFORMATION_MESSAGE);
							break;
						case "5":
							String idd1 = JOptionPane.showInputDialog(null, "Insira o ID", "Update By Email", JOptionPane.QUESTION_MESSAGE);
							String email = JOptionPane.showInputDialog(null, "Insira o Email", "Update By Email", JOptionPane.QUESTION_MESSAGE);

							funDAO.updateEmail(Integer.parseInt(idd1), email);
							JOptionPane.showMessageDialog(null, "Mudado!", "Update By Email", JOptionPane.INFORMATION_MESSAGE);
							break;
						case "6":
							String idd2 = JOptionPane.showInputDialog(null, "Insira o ID", "Update By Fone", JOptionPane.QUESTION_MESSAGE);
							String fone = JOptionPane.showInputDialog(null, "Insira o Fone", "Update By Fone", JOptionPane.QUESTION_MESSAGE);

							funDAO.updateTelefone(Integer.parseInt(idd2), fone);
							JOptionPane.showMessageDialog(null, "Mudado!", "Update By Fone", JOptionPane.INFORMATION_MESSAGE);
							break;
						case "7":
							String idDelete = JOptionPane.showInputDialog(null, "Insira o ID", "Delete Funcionário", JOptionPane.QUESTION_MESSAGE);

							funDAO.delete(Integer.parseInt(idDelete));
							JOptionPane.showMessageDialog(null, "Deletado!", "Delete Funcionário", JOptionPane.INFORMATION_MESSAGE);
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

