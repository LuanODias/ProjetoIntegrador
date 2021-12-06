package br.com.pintegrador.interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import br.com.pintegrador.dao.ColaboradorDAO;
import br.com.pintegrador.model.Colaborador;
import br.com.pintegrador.util.Utilitarios;

public class TelaCadastroColaborador extends JFrame {

	private JPanel contentPane;
	private JTextField nomeColaborador;
	private JTextField matriculaColaborador;
	ColaboradorDAO colaboradorDAO = new ColaboradorDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroColaborador frame = new TelaCadastroColaborador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastroColaborador() {
		Utilitarios util = new Utilitarios();
		
		setResizable(false);
		setTitle("Cadastro Colaborador");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Op\u00E7\u00F5es");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Print");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Item1");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Item2");
		mnNewMenu.add(mntmNewMenuItem_2);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 639, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 231, SpringLayout.WEST, getContentPane());
		getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblNewLabel = new JLabel("LISTAS");
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, -79, SpringLayout.EAST, panel);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		JButton btnColaborador = new JButton("Colaboradores");
		sl_panel.putConstraint(SpringLayout.NORTH, btnColaborador, 40, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnColaborador, -576, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel, -6, SpringLayout.NORTH, btnColaborador);
		sl_panel.putConstraint(SpringLayout.WEST, btnColaborador, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnColaborador, -10, SpringLayout.EAST, panel);
		panel.add(btnColaborador);
		btnColaborador.addActionListener(e->{util.telas("colaborador", this, 0);});
		
		JButton btnVeiculo = new JButton("Veiculos");
		sl_panel.putConstraint(SpringLayout.NORTH, btnVeiculo, 8, SpringLayout.SOUTH, btnColaborador);
		sl_panel.putConstraint(SpringLayout.WEST, btnVeiculo, 0, SpringLayout.WEST, btnColaborador);
		sl_panel.putConstraint(SpringLayout.EAST, btnVeiculo, 0, SpringLayout.EAST, btnColaborador);
		panel.add(btnVeiculo);
		btnVeiculo.addActionListener(e->{util.telas("veiculo", this, 0);});
		
		JButton btnChamado = new JButton("Chamados");
		sl_panel.putConstraint(SpringLayout.NORTH, btnChamado, 10, SpringLayout.SOUTH, btnVeiculo);
		sl_panel.putConstraint(SpringLayout.WEST, btnChamado, 0, SpringLayout.WEST, btnColaborador);
		sl_panel.putConstraint(SpringLayout.EAST, btnChamado, 0, SpringLayout.EAST, btnColaborador);
		panel.add(btnChamado);
		btnChamado.addActionListener(e->{util.telas("chamado", this, 0);});
		
		JButton btnCadastrar = new JButton("Cadastrar");
		sl_panel.putConstraint(SpringLayout.WEST, btnCadastrar, 0, SpringLayout.WEST, btnColaborador);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnCadastrar, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnCadastrar, 0, SpringLayout.EAST, btnColaborador);
		panel.add(btnCadastrar);
		btnCadastrar.addActionListener(e->{
			Colaborador colaborador = new Colaborador(nomeColaborador.getText(),matriculaColaborador.getText());
			colaboradorDAO.save(colaborador);
		});
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Novo Colaborador");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 6, SpringLayout.EAST, panel);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 34));
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nome:");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 36, SpringLayout.SOUTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 6, SpringLayout.EAST, panel);
		getContentPane().add(lblNewLabel_2);
		
		nomeColaborador = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, nomeColaborador, 55, SpringLayout.SOUTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, nomeColaborador, 6, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.EAST, nomeColaborador, 160, SpringLayout.EAST, panel);
		getContentPane().add(nomeColaborador);
		nomeColaborador.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Matricula:");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2_1, 6, SpringLayout.EAST, panel);
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 16));
		getContentPane().add(lblNewLabel_2_1);
		
		matriculaColaborador = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_2_1, 0, SpringLayout.NORTH, matriculaColaborador);
		springLayout.putConstraint(SpringLayout.NORTH, matriculaColaborador, 170, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, matriculaColaborador, 6, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.EAST, matriculaColaborador, 0, SpringLayout.EAST, nomeColaborador);
		matriculaColaborador.setColumns(10);
		getContentPane().add(matriculaColaborador);
	}
}
