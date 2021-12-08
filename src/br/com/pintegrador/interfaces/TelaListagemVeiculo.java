package br.com.pintegrador.interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

import br.com.pintegrador.dao.VeiculoDAO;
import br.com.pintegrador.util.Utilitarios;

public class TelaListagemVeiculo extends JFrame {

	
	VeiculoDAO veiculodao = new VeiculoDAO();
	private JPanel contentPane;
	private JTable table;
	private JTable tabela_veiculos;
	
	
	

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
		
		JButton btnCriar = new JButton("Adicionar");
		sl_panel.putConstraint(SpringLayout.WEST, btnCriar, 0, SpringLayout.WEST, btnColaborador);
		sl_panel.putConstraint(SpringLayout.EAST, btnCriar, 0, SpringLayout.EAST, btnColaborador);
		panel.add(btnCriar);
		btnCriar.addActionListener(e->{util.telas("criarVeiculo", this, 0);});
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setEnabled(true);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnCriar, -36, SpringLayout.NORTH, btnRemover);
		sl_panel.putConstraint(SpringLayout.NORTH, btnRemover, 608, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btnRemover, 0, SpringLayout.WEST, btnColaborador);
		sl_panel.putConstraint(SpringLayout.EAST, btnRemover, 0, SpringLayout.EAST, btnColaborador);
		panel.add(btnRemover);
		btnRemover.addActionListener(e ->{
			
			try {
				int id = (int) tabela_veiculos.getValueAt(tabela_veiculos.getSelectedRow(), 0);
				veiculodao.delete(id);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"É necessário selecionar um veiculo para remove-lo!");
			}finally {
				util.telas("veiculo", this, 0);
			}
			
		});
		
		JPanel panel_1 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 38, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 44, SpringLayout.EAST, panel);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setEnabled(true);
		sl_panel.putConstraint(SpringLayout.WEST, btnEditar, 0, SpringLayout.WEST, btnColaborador);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnEditar, -6, SpringLayout.NORTH, btnRemover);
		sl_panel.putConstraint(SpringLayout.EAST, btnEditar, 0, SpringLayout.EAST, btnColaborador);
		panel.add(btnEditar);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, -11, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_1, -31, SpringLayout.EAST, getContentPane());
		getContentPane().add(panel_1);
		btnEditar.addActionListener(e->{
			try {
				int id = (int) tabela_veiculos.getValueAt(tabela_veiculos.getSelectedRow(), 0);
				util.telas("editarVeiculo", this, id);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Selecione um Veiculo para ser editado!");
			}	
		});
		
		
		
		
		ResultSet rs;
		DefaultTableModel dtm = new DefaultTableModel();
		tabela_veiculos = new JTable();
		tabela_veiculos.setModel(dtm);
		tabela_veiculos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		dtm.setColumnIdentifiers(new Object[]{"id_veiculo", "ano", "modelo", "autonomia"});
		rs = veiculodao.listar();
		try{
			while(rs.next()) {
				dtm.addRow(new Object[]{rs.getInt("id_veiculo"), rs.getString("ano"), rs.getString("modelo"), rs.getDouble("autonomia")});
			}
		}catch(Exception e) {
			
		}
		panel_1.add(tabela_veiculos);
		
		JLabel lblid_veiculo = new JLabel("id_veiculo");
		springLayout.putConstraint(SpringLayout.WEST, lblid_veiculo, 90, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, lblid_veiculo, -6, SpringLayout.NORTH, panel_1);
		lblid_veiculo.setFont(new Font("Tahoma", Font.BOLD, 13));
		getContentPane().add(lblid_veiculo);
		
		JLabel lblano = new JLabel("Ano");
		springLayout.putConstraint(SpringLayout.WEST, lblano, 93, SpringLayout.EAST, lblid_veiculo);
		springLayout.putConstraint(SpringLayout.SOUTH, lblano, -6, SpringLayout.NORTH, panel_1);
		lblano.setFont(new Font("Tahoma", Font.BOLD, 13));
		getContentPane().add(lblano);
		
		JLabel lblmodelo = new JLabel("Modelo");
		springLayout.putConstraint(SpringLayout.NORTH, lblmodelo, 0, SpringLayout.NORTH, lblid_veiculo);
		springLayout.putConstraint(SpringLayout.WEST, lblmodelo, 110, SpringLayout.EAST, lblano);
		lblmodelo.setFont(new Font("Tahoma", Font.BOLD, 13));
		getContentPane().add(lblmodelo);
		
		JLabel lblautonomia = new JLabel("Autonomia");
		springLayout.putConstraint(SpringLayout.NORTH, lblautonomia, 0, SpringLayout.NORTH, lblid_veiculo);
		springLayout.putConstraint(SpringLayout.EAST, lblautonomia, -70, SpringLayout.EAST, getContentPane());
		lblautonomia.setFont(new Font("Tahoma", Font.BOLD, 13));
		getContentPane().add(lblautonomia);
		
	
		
		
	}
}
