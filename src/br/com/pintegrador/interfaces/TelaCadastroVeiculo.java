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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import br.com.pintegrador.model.Veiculo;
import br.com.pintegrador.util.Utilitarios;
import br.com.pintegrador.dao.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaCadastroVeiculo extends JFrame {

	private JPanel contentPane;
	private JTextField anoVeiculo;
	private JTextField modeloVeiculo;
	private JTextField autonomiaVeiculo;
	Utilitarios util = new Utilitarios();
	VeiculoDAO veiculoDAO = new VeiculoDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroVeiculo frame = new TelaCadastroVeiculo();
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
	public TelaCadastroVeiculo() {
		
		setResizable(false);
		setTitle("Cadastro Ve\u00EDculo");
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
		
		JLabel lblNewLabel_1 = new JLabel("Novo Veículo");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 6, SpringLayout.EAST, panel);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 34));
		getContentPane().add(lblNewLabel_1);
		
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
			double autonomia = Double.parseDouble(autonomiaVeiculo.getText());
			Veiculo veiculo = new Veiculo(anoVeiculo.getText(), modeloVeiculo.getText(), autonomia);
			veiculoDAO.save(veiculo);
			JOptionPane.showMessageDialog(null, "Veiculo Cadastrado com sucesso");
		});
	
		
		JLabel lblNewLabel_2 = new JLabel("Ano:");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 36, SpringLayout.SOUTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 6, SpringLayout.EAST, panel);
		getContentPane().add(lblNewLabel_2);
		
		anoVeiculo = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, anoVeiculo, 55, SpringLayout.SOUTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, anoVeiculo, 6, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.EAST, anoVeiculo, 160, SpringLayout.EAST, panel);
		getContentPane().add(anoVeiculo);
		anoVeiculo.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Modelo:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1, 24, SpringLayout.SOUTH, anoVeiculo);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2_1, 6, SpringLayout.EAST, panel);
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 16));
		getContentPane().add(lblNewLabel_2_1);
		
		modeloVeiculo = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_2_1, -4, SpringLayout.NORTH, modeloVeiculo);
		springLayout.putConstraint(SpringLayout.NORTH, modeloVeiculo, 43, SpringLayout.SOUTH, anoVeiculo);
		springLayout.putConstraint(SpringLayout.WEST, modeloVeiculo, 6, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.EAST, modeloVeiculo, 0, SpringLayout.EAST, anoVeiculo);
		getContentPane().add(modeloVeiculo);
		modeloVeiculo.setColumns(10);
		
		JLabel lblNewLabel_2_2 = new JLabel("Autonomia:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2_2, 26, SpringLayout.SOUTH, modeloVeiculo);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2_2, 6, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_2_2, 0, SpringLayout.EAST, anoVeiculo);
		lblNewLabel_2_2.setFont(new Font("Arial", Font.BOLD, 16));
		getContentPane().add(lblNewLabel_2_2);
		
		autonomiaVeiculo = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, autonomiaVeiculo, 0, SpringLayout.SOUTH, lblNewLabel_2_2);
		springLayout.putConstraint(SpringLayout.WEST, autonomiaVeiculo, 6, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.EAST, autonomiaVeiculo, 0, SpringLayout.EAST, anoVeiculo);
		autonomiaVeiculo.setColumns(10);
		getContentPane().add(autonomiaVeiculo);
		
		
		
		
		
	}

}
