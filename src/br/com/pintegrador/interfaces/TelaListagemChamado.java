package br.com.pintegrador.interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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

import br.com.pintegrador.dao.ChamadoDAO;
import br.com.pintegrador.util.Utilitarios;

public class TelaListagemChamado extends JFrame {

	private JPanel contentPane;
	
	ChamadoDAO chamadodao = new ChamadoDAO();
	ResultSet rs;
	private JTable tabela_chamado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListagemChamado frame = new TelaListagemChamado();
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
	public TelaListagemChamado() {
		Utilitarios util = new Utilitarios();
		
		setResizable(false);
		setTitle("Lista de Chamados");
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
		btnCriar.addActionListener(e->{util.telas("criarChamado", this, 0);});
		
		JButton btnRemover = new JButton("Remover");
		sl_panel.putConstraint(SpringLayout.SOUTH, btnCriar, -37, SpringLayout.NORTH, btnRemover);
		sl_panel.putConstraint(SpringLayout.NORTH, btnRemover, 608, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btnRemover, 0, SpringLayout.WEST, btnColaborador);
		sl_panel.putConstraint(SpringLayout.EAST, btnRemover, 0, SpringLayout.EAST, btnColaborador);
		panel.add(btnRemover);
		btnRemover.addActionListener(e->{
			try {
				int id = (int) tabela_chamado.getValueAt(tabela_chamado.getSelectedRow(), 0);
				chamadodao.delete(id);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"É necessário selecionar um chamado para remove-lo!");
			}finally {
				util.telas("chamado", this, 0);
			}
		});
		
		JButton btnEditar = new JButton("Editar");
		sl_panel.putConstraint(SpringLayout.NORTH, btnEditar, 6, SpringLayout.SOUTH, btnCriar);
		sl_panel.putConstraint(SpringLayout.WEST, btnEditar, 0, SpringLayout.WEST, btnColaborador);
		sl_panel.putConstraint(SpringLayout.EAST, btnEditar, 0, SpringLayout.EAST, btnColaborador);
		panel.add(btnEditar);
		btnEditar.addActionListener(e->{
			try {
				int id = (int) tabela_chamado.getValueAt(tabela_chamado.getSelectedRow(), 0);
				util.telas("editarChamado", this, id);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Selecione um Chamado para ser editado!");
			}	
		});
		
		JPanel panel_1 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 47, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 56, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, -56, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_1, -28, SpringLayout.EAST, getContentPane());
		getContentPane().add(panel_1);
		
		
		
		
		
		JLabel lblidchamado = new JLabel("ID");
		lblidchamado.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(lblidchamado);
		
		JLabel lblnumerochamado = new JLabel("NUMERO");
		springLayout.putConstraint(SpringLayout.NORTH, lblidchamado, 0, SpringLayout.NORTH, lblnumerochamado);
		springLayout.putConstraint(SpringLayout.EAST, lblidchamado, -36, SpringLayout.WEST, lblnumerochamado);
		springLayout.putConstraint(SpringLayout.SOUTH, lblnumerochamado, -598, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblnumerochamado, -452, SpringLayout.EAST, getContentPane());
		lblnumerochamado.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(lblnumerochamado);
		
		JLabel lblkmrodado = new JLabel("KM_RODADO");
		springLayout.putConstraint(SpringLayout.NORTH, lblkmrodado, 27, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblkmrodado, 20, SpringLayout.EAST, lblnumerochamado);
		lblkmrodado.setFont(new Font("Tahoma", Font.BOLD, 10));
		getContentPane().add(lblkmrodado);
		
		JLabel lblco2 = new JLabel("CO2");
		springLayout.putConstraint(SpringLayout.WEST, lblco2, 38, SpringLayout.EAST, lblkmrodado);
		springLayout.putConstraint(SpringLayout.SOUTH, lblco2, -6, SpringLayout.NORTH, panel_1);
		lblco2.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(lblco2);
		
		JLabel lbldatachamado = new JLabel("DATA");
		springLayout.putConstraint(SpringLayout.NORTH, lbldatachamado, 28, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lbldatachamado, -6, SpringLayout.NORTH, panel_1);
		springLayout.putConstraint(SpringLayout.EAST, lbldatachamado, -221, SpringLayout.EAST, getContentPane());
		lbldatachamado.setFont(new Font("Tahoma", Font.BOLD, 10));
		getContentPane().add(lbldatachamado);
		
		JLabel lblid_veiculo = new JLabel("ID_VEICULO");
		springLayout.putConstraint(SpringLayout.NORTH, lblid_veiculo, 27, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblid_veiculo, -128, SpringLayout.EAST, getContentPane());
		lblid_veiculo.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(lblid_veiculo);
		
		JLabel lblid_veiculo_1 = new JLabel("ID_COLAB.");
		springLayout.putConstraint(SpringLayout.WEST, lblid_veiculo_1, 14, SpringLayout.EAST, lblid_veiculo);
		springLayout.putConstraint(SpringLayout.SOUTH, lblid_veiculo_1, -6, SpringLayout.NORTH, panel_1);
		lblid_veiculo_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(lblid_veiculo_1);
		
		
		DefaultTableModel dtm = new DefaultTableModel();
		tabela_chamado = new JTable();
		tabela_chamado.setModel(dtm);
		dtm.setColumnIdentifiers(new Object[]{"id_chamado", "numero_chamado", "km_rodado", "co2", "data_chamado", "veiculo", "colaborador"});
		rs = chamadodao.listar();
		try{
			while(rs.next()) {
				dtm.addRow(new Object[]{rs.getInt("id_chamado"), rs.getString("numero_chamado"), rs.getInt("km_rodado"), rs.getString("co2"), rs.getString("data_chamado"), rs.getInt("veiculo"), rs.getInt("colaborador")});
			}
		}catch(Exception e) {
			
		}
		
		panel_1.add(tabela_chamado);
		
		
		
		
	}
}
