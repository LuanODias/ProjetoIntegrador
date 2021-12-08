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
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

import br.com.pintegrador.dao.ColaboradorDAO;
import br.com.pintegrador.util.Utilitarios;

public class TelaListagemColaborador extends JFrame {

	private JPanel contentPane;
	
	ResultSet rs;
	ColaboradorDAO colaboradordao = new ColaboradorDAO();
	private JTable tabela_colaboradores;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListagemColaborador frame = new TelaListagemColaborador();
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
	public TelaListagemColaborador() {
		Utilitarios util = new Utilitarios();
		
		setResizable(false);
		setTitle("Lista de Colaboradores");
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
		btnCriar.addActionListener(e->{util.telas("criarColaborador", this, 0);});
		
		JButton btnRemover = new JButton("Remover");
		sl_panel.putConstraint(SpringLayout.SOUTH, btnCriar, -35, SpringLayout.NORTH, btnRemover);
		sl_panel.putConstraint(SpringLayout.NORTH, btnRemover, 608, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btnRemover, 0, SpringLayout.WEST, btnColaborador);
		sl_panel.putConstraint(SpringLayout.EAST, btnRemover, 0, SpringLayout.EAST, btnColaborador);
		panel.add(btnRemover);
		btnRemover.addActionListener(e ->{
					
					try {
						int id = (int) tabela_colaboradores.getValueAt(tabela_colaboradores.getSelectedRow(), 0);
						colaboradordao.delete(id);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null,"É necessário selecionar um colaborador para remove-lo!");
					}finally {
						util.telas("colaborador", this, 0);
					}
					
				});
		
		JButton btnEditar = new JButton("Editar");
		sl_panel.putConstraint(SpringLayout.NORTH, btnEditar, 6, SpringLayout.SOUTH, btnCriar);
		sl_panel.putConstraint(SpringLayout.WEST, btnEditar, 0, SpringLayout.WEST, btnColaborador);
		sl_panel.putConstraint(SpringLayout.EAST, btnEditar, 0, SpringLayout.EAST, btnColaborador);
		panel.add(btnEditar);
		btnEditar.addActionListener(e->{
			try {
				int id = (int) tabela_colaboradores.getValueAt(tabela_colaboradores.getSelectedRow(), 0);
				util.telas("editarColaborador", this, id);
			}catch (Exception o) {
				o.getStackTrace();
				JOptionPane.showMessageDialog(null, "Selecione um Colaborador para ser editado!");
			}
			
			});
		
		JPanel panel_2 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_2, 40, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel_2, 41, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_2, -23, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_2, -33, SpringLayout.EAST, getContentPane());
		getContentPane().add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblid = new JLabel("Id_Colaborador");
		springLayout.putConstraint(SpringLayout.WEST, lblid, 87, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, lblid, -6, SpringLayout.NORTH, panel_2);
		lblid.setFont(new Font("Tahoma", Font.BOLD, 13));
		getContentPane().add(lblid);
		
		JLabel lblnome = new JLabel("Nome");
		springLayout.putConstraint(SpringLayout.WEST, lblnome, 118, SpringLayout.EAST, lblid);
		springLayout.putConstraint(SpringLayout.SOUTH, lblnome, -6, SpringLayout.NORTH, panel_2);
		lblnome.setFont(new Font("Tahoma", Font.BOLD, 13));
		getContentPane().add(lblnome);
		
		JLabel lblMatricula = new JLabel("Matricula");
		springLayout.putConstraint(SpringLayout.NORTH, lblMatricula, 0, SpringLayout.NORTH, lblid);
		springLayout.putConstraint(SpringLayout.EAST, lblMatricula, -105, SpringLayout.EAST, getContentPane());
		lblMatricula.setFont(new Font("Tahoma", Font.BOLD, 13));
		getContentPane().add(lblMatricula);
		
		
		
		
		DefaultTableModel dtm = new DefaultTableModel();
		tabela_colaboradores = new JTable();
		tabela_colaboradores.setModel(dtm);
		
		dtm.setColumnIdentifiers(new Object[]{"id_colaborador", "nome", "matricula"});
		rs = colaboradordao.listar();
		try{
			while(rs.next()) {
				dtm.addRow(new Object[]{rs.getInt("id_colaborador"), rs.getString("nome"), rs.getString("matricula")});
			}
		}catch(Exception e) {
			
		}
		
		
		panel_2.add(tabela_colaboradores);
		
		
		
	}
}
