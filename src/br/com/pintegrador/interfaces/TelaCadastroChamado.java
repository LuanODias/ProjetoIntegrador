package br.com.pintegrador.interfaces;

import java.awt.BorderLayout;
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
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class TelaCadastroChamado extends JFrame {

	private JPanel contentPane;
	private JTextField numChamado;
	private JTextField kmChamado;
	private JTextField kmchamado;
	private JTextField dataChamado;
	private JTextField veiculoChamado;
	private JTextField colaboradorChamado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroChamado frame = new TelaCadastroChamado();
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
	public TelaCadastroChamado() {
		setResizable(false);
		setTitle("Cadastro Chamado");
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
		
		JLabel lblNewLabel_1 = new JLabel("Novo Chamado");
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
		
		JButton btnVeiculo = new JButton("Veiculos");
		sl_panel.putConstraint(SpringLayout.NORTH, btnVeiculo, 8, SpringLayout.SOUTH, btnColaborador);
		sl_panel.putConstraint(SpringLayout.WEST, btnVeiculo, 0, SpringLayout.WEST, btnColaborador);
		sl_panel.putConstraint(SpringLayout.EAST, btnVeiculo, 0, SpringLayout.EAST, btnColaborador);
		panel.add(btnVeiculo);
		
		JButton btnChamado = new JButton("Chamados");
		sl_panel.putConstraint(SpringLayout.NORTH, btnChamado, 10, SpringLayout.SOUTH, btnVeiculo);
		sl_panel.putConstraint(SpringLayout.WEST, btnChamado, 0, SpringLayout.WEST, btnColaborador);
		sl_panel.putConstraint(SpringLayout.EAST, btnChamado, 0, SpringLayout.EAST, btnColaborador);
		panel.add(btnChamado);
		
		JButton btnCriar = new JButton("Adicionar");
		sl_panel.putConstraint(SpringLayout.WEST, btnCriar, 0, SpringLayout.WEST, btnColaborador);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnCriar, -37, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnCriar, 0, SpringLayout.EAST, btnColaborador);
		panel.add(btnCriar);
		
		JButton btnRemover = new JButton("Remover");
		sl_panel.putConstraint(SpringLayout.NORTH, btnRemover, 6, SpringLayout.SOUTH, btnCriar);
		sl_panel.putConstraint(SpringLayout.WEST, btnRemover, 0, SpringLayout.WEST, btnColaborador);
		sl_panel.putConstraint(SpringLayout.EAST, btnRemover, 0, SpringLayout.EAST, btnColaborador);
		panel.add(btnRemover);
		
		JLabel lblNewLabel_2 = new JLabel("N\u00FAmero do chamado:");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 36, SpringLayout.SOUTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 6, SpringLayout.EAST, panel);
		getContentPane().add(lblNewLabel_2);
		
		numChamado = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, numChamado, 55, SpringLayout.SOUTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, numChamado, 6, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.EAST, numChamado, 160, SpringLayout.EAST, panel);
		getContentPane().add(numChamado);
		numChamado.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("KM Rodado:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1, 16, SpringLayout.SOUTH, numChamado);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2_1, 6, SpringLayout.EAST, panel);
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 16));
		getContentPane().add(lblNewLabel_2_1);
		
		kmchamado = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, kmchamado, 35, SpringLayout.SOUTH, numChamado);
		springLayout.putConstraint(SpringLayout.WEST, kmchamado, 6, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.EAST, kmchamado, 0, SpringLayout.EAST, numChamado);
		kmchamado.setColumns(10);
		getContentPane().add(kmchamado);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Data do Chamado:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1_1, 15, SpringLayout.SOUTH, kmchamado);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2_1_1, 6, SpringLayout.EAST, panel);
		lblNewLabel_2_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		getContentPane().add(lblNewLabel_2_1_1);
		
		dataChamado = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, dataChamado, 34, SpringLayout.SOUTH, kmchamado);
		springLayout.putConstraint(SpringLayout.WEST, dataChamado, 6, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.EAST, dataChamado, 0, SpringLayout.EAST, numChamado);
		dataChamado.setColumns(10);
		getContentPane().add(dataChamado);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Ve\u00EDculo:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1_1_1, 21, SpringLayout.SOUTH, dataChamado);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2_1_1_1, 6, SpringLayout.EAST, panel);
		lblNewLabel_2_1_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		getContentPane().add(lblNewLabel_2_1_1_1);
		
		veiculoChamado = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, veiculoChamado, 40, SpringLayout.SOUTH, dataChamado);
		springLayout.putConstraint(SpringLayout.WEST, veiculoChamado, 6, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.EAST, veiculoChamado, 0, SpringLayout.EAST, numChamado);
		veiculoChamado.setColumns(10);
		getContentPane().add(veiculoChamado);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Colaborador:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1_1_1_1, 18, SpringLayout.SOUTH, veiculoChamado);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2_1_1_1_1, 6, SpringLayout.EAST, panel);
		lblNewLabel_2_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		getContentPane().add(lblNewLabel_2_1_1_1_1);
		
		colaboradorChamado = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, colaboradorChamado, 37, SpringLayout.SOUTH, veiculoChamado);
		springLayout.putConstraint(SpringLayout.WEST, colaboradorChamado, 6, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.EAST, colaboradorChamado, 0, SpringLayout.EAST, numChamado);
		colaboradorChamado.setColumns(10);
		getContentPane().add(colaboradorChamado);
		
		
		
	}
}
