package br.com.pintegrador.interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import br.com.pintegrador.dao.ChamadoDAO;
import br.com.pintegrador.dao.VeiculoDAO;
import br.com.pintegrador.model.Chamado;
import br.com.pintegrador.util.Utilitarios;
import javax.swing.JFormattedTextField;

public class TelaCadastroChamado extends JFrame {

	private JPanel contentPane;
	private JTextField numChamado;
	private JTextField kmchamado;
	private JTextField dataChamado;
	private JTextField veiculoChamado;
	private JTextField colaboradorChamado;
	ChamadoDAO DAO = new ChamadoDAO();

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
		
		Utilitarios util = new Utilitarios();
		
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
		
		JLabel labelLista = new JLabel("LISTAS");
		sl_panel.putConstraint(SpringLayout.EAST, labelLista, -79, SpringLayout.EAST, panel);
		labelLista.setFont(new Font("Arial", Font.BOLD, 20));
		panel.add(labelLista);
		
		JLabel labelChamado = new JLabel("Novo Chamado");
		springLayout.putConstraint(SpringLayout.NORTH, labelChamado, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, labelChamado, 6, SpringLayout.EAST, panel);
		labelChamado.setFont(new Font("Arial", Font.BOLD, 34));
		getContentPane().add(labelChamado);
		
		JButton btnColaborador = new JButton("Colaboradores");
		sl_panel.putConstraint(SpringLayout.NORTH, btnColaborador, 40, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnColaborador, -576, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, labelLista, -6, SpringLayout.NORTH, btnColaborador);
		sl_panel.putConstraint(SpringLayout.WEST, btnColaborador, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnColaborador, -10, SpringLayout.EAST, panel);
		panel.add(btnColaborador);
		btnColaborador.addActionListener(e->{util.telas("colaborador", this);});
		
		
		JButton btnVeiculo = new JButton("Veiculos");
		sl_panel.putConstraint(SpringLayout.NORTH, btnVeiculo, 8, SpringLayout.SOUTH, btnColaborador);
		sl_panel.putConstraint(SpringLayout.WEST, btnVeiculo, 0, SpringLayout.WEST, btnColaborador);
		sl_panel.putConstraint(SpringLayout.EAST, btnVeiculo, 0, SpringLayout.EAST, btnColaborador);
		panel.add(btnVeiculo);
		btnVeiculo.addActionListener(e->{util.telas("veiculo", this);});
		
		JButton btnChamado = new JButton("Chamados");
		sl_panel.putConstraint(SpringLayout.NORTH, btnChamado, 10, SpringLayout.SOUTH, btnVeiculo);
		sl_panel.putConstraint(SpringLayout.WEST, btnChamado, 0, SpringLayout.WEST, btnColaborador);
		sl_panel.putConstraint(SpringLayout.EAST, btnChamado, 0, SpringLayout.EAST, btnColaborador);
		panel.add(btnChamado);
		btnChamado.addActionListener(e->{util.telas("chamado", this);});
		
		JButton btnCadastrar = new JButton("Cadastrar");
		sl_panel.putConstraint(SpringLayout.WEST, btnCadastrar, 0, SpringLayout.WEST, btnColaborador);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnCadastrar, -37, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnCadastrar, 0, SpringLayout.EAST, btnColaborador);
		panel.add(btnCadastrar);
		btnCadastrar.addActionListener(e->{
			
			int kmChamado = Integer.parseInt(kmchamado.getText());
			int veiculochamado = Integer.parseInt(veiculoChamado.getText());
			int colaboradorchamado = Integer.parseInt(colaboradorChamado.getText());
			String dataFormatada =  dataChamado.getText().substring(0, 2) + "/" +
									dataChamado.getText().substring(2, 4) + "/" +
									dataChamado.getText().substring(4, 8);
						
			Chamado chamado = new Chamado(numChamado.getText(), kmChamado, 0, dataFormatada, veiculochamado, colaboradorchamado);
			double autonomia = DAO.getAutonomia(veiculochamado);
			chamado.calularPegadaCarbono(kmChamado, autonomia);
			DAO.save(chamado);
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		sl_panel.putConstraint(SpringLayout.NORTH, btnCancelar, 6, SpringLayout.SOUTH, btnCadastrar);
		sl_panel.putConstraint(SpringLayout.WEST, btnCancelar, 0, SpringLayout.WEST, btnColaborador);
		sl_panel.putConstraint(SpringLayout.EAST, btnCancelar, 0, SpringLayout.EAST, btnColaborador);
		panel.add(btnCancelar);
		
		JLabel labelchamado = new JLabel("N\u00FAmero do chamado:");
		labelchamado.setFont(new Font("Arial", Font.BOLD, 16));
		labelChamado.setFont(new Font("Arial", Font.BOLD, 16));
		springLayout.putConstraint(SpringLayout.NORTH, labelchamado, 36, SpringLayout.SOUTH, labelLista);
		springLayout.putConstraint(SpringLayout.WEST, labelchamado, 6, SpringLayout.EAST, panel);
		getContentPane().add(labelchamado);
		
		numChamado = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, numChamado, 55, SpringLayout.SOUTH, labelLista);
		springLayout.putConstraint(SpringLayout.WEST, numChamado, 6, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.EAST, numChamado, 160, SpringLayout.EAST, panel);
		getContentPane().add(numChamado);
		numChamado.setColumns(10);
		
		JLabel labelRodado = new JLabel("KM Rodado:");
		springLayout.putConstraint(SpringLayout.NORTH, labelRodado, 16, SpringLayout.SOUTH, numChamado);
		springLayout.putConstraint(SpringLayout.WEST, labelRodado, 6, SpringLayout.EAST, panel);
		labelRodado.setFont(new Font("Arial", Font.BOLD, 16));
		getContentPane().add(labelRodado);
		
		kmchamado = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, kmchamado, 35, SpringLayout.SOUTH, numChamado);
		springLayout.putConstraint(SpringLayout.WEST, kmchamado, 6, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.EAST, kmchamado, 0, SpringLayout.EAST, numChamado);
		kmchamado.setColumns(10);
		getContentPane().add(kmchamado);
		
		JLabel labelData = new JLabel("Data do Chamado:");
		springLayout.putConstraint(SpringLayout.NORTH, labelData, 15, SpringLayout.SOUTH, kmchamado);
		springLayout.putConstraint(SpringLayout.WEST, labelData, 6, SpringLayout.EAST, panel);
		labelData.setFont(new Font("Arial", Font.BOLD, 16));
		getContentPane().add(labelData);
		
		dataChamado = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, dataChamado, 34, SpringLayout.SOUTH, kmchamado);
		springLayout.putConstraint(SpringLayout.WEST, dataChamado, 6, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.EAST, dataChamado, 0, SpringLayout.EAST, numChamado);
		dataChamado.setColumns(10);
		getContentPane().add(dataChamado);
		
		JLabel labelVeiculo = new JLabel("Ve\u00EDculo:");
		springLayout.putConstraint(SpringLayout.NORTH, labelVeiculo, 21, SpringLayout.SOUTH, dataChamado);
		springLayout.putConstraint(SpringLayout.WEST, labelVeiculo, 6, SpringLayout.EAST, panel);
		labelVeiculo.setFont(new Font("Arial", Font.BOLD, 16));
		getContentPane().add(labelVeiculo);
		
		veiculoChamado = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, veiculoChamado, 40, SpringLayout.SOUTH, dataChamado);
		springLayout.putConstraint(SpringLayout.WEST, veiculoChamado, 6, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.EAST, veiculoChamado, 0, SpringLayout.EAST, numChamado);
		veiculoChamado.setColumns(10);
		getContentPane().add(veiculoChamado);
		
		JLabel labelColaborador = new JLabel("Colaborador:");
		springLayout.putConstraint(SpringLayout.NORTH, labelColaborador, 18, SpringLayout.SOUTH, veiculoChamado);
		springLayout.putConstraint(SpringLayout.WEST, labelColaborador, 6, SpringLayout.EAST, panel);
		labelColaborador.setFont(new Font("Arial", Font.BOLD, 16));
		getContentPane().add(labelColaborador);
		
		colaboradorChamado = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, colaboradorChamado, 37, SpringLayout.SOUTH, veiculoChamado);
		springLayout.putConstraint(SpringLayout.WEST, colaboradorChamado, 6, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.EAST, colaboradorChamado, 0, SpringLayout.EAST, numChamado);
		colaboradorChamado.setColumns(10);
		getContentPane().add(colaboradorChamado);
		
		
		
	}
}
