package br.com.pintegrador.interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import br.com.pintegrador.util.Utilitarios;
import java.awt.GridLayout;
import javax.swing.AbstractListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaListagemVeiculo extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListagemVeiculo frame = new TelaListagemVeiculo();
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
	public TelaListagemVeiculo() {
		Utilitarios util = new Utilitarios();
		
		setResizable(false);
		setTitle("Lista de Veículos");
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
		
		JButton btnCriar = new JButton("Adicionar");
		sl_panel.putConstraint(SpringLayout.WEST, btnCriar, 0, SpringLayout.WEST, btnColaborador);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnCriar, -37, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnCriar, 0, SpringLayout.EAST, btnColaborador);
		panel.add(btnCriar);
		btnCriar.addActionListener(null);
		
		JButton btnRemover = new JButton("Remover");
		sl_panel.putConstraint(SpringLayout.NORTH, btnRemover, 6, SpringLayout.SOUTH, btnCriar);
		sl_panel.putConstraint(SpringLayout.WEST, btnRemover, 0, SpringLayout.WEST, btnColaborador);
		sl_panel.putConstraint(SpringLayout.EAST, btnRemover, 0, SpringLayout.EAST, btnColaborador);
		panel.add(btnRemover);
		
		JPanel panel_1 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 38, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 44, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, -11, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_1, -31, SpringLayout.EAST, getContentPane());
		getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		
	}
}
