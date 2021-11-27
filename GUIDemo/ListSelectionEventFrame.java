import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListSelectionEventFrame extends EventFrame {
	private static final int NUM_ITEMS = 5;

	private JList<String> list1;
	private DefaultListModel<String> listModel1;
	private JList<String> list2;
	private DefaultListModel<String> listModel2;
	private JButton btn;

	public ListSelectionEventFrame() {
		super("Demo List Selection Event");

		listModel1 = new DefaultListModel<String>();
		listModel2 = new DefaultListModel<String>();

		preparar();
	}

	private void preparar() {
		JScrollPane scroll;

		for (int i = 1; i <= NUM_ITEMS; i++) {
			listModel1.addElement("Item " + i);
		}
		list1 = new JList<String>(listModel1);
		list1.setVisibleRowCount(3);
		list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list1.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					prefixaSaida(String.format("List 1: %s (%d)", list1.getSelectedValue(), list1.getSelectedIndex()));
				}
			}
		});
		scroll = new JScrollPane(list1);
		adicionaComponente(scroll, 0, 0, 1, 3);

		list2 = new JList<String>(listModel2);
		list2.setVisibleRowCount(3);
		list2.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scroll = new JScrollPane(list2);
		scroll.setPreferredSize(list1.getPreferredSize());
		adicionaComponente(scroll, 0, 2, 1, 3);

		btn = new JButton("Mover");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (list1.getSelectedIndex() >= 0) {
					listModel2.addElement(list1.getSelectedValue());
					listModel1.removeElement(list1.getSelectedValue());
				}

				if (list2.getSelectedIndices() != null) {
					listModel1.addAll(list2.getSelectedValuesList());
					for (String s : list2.getSelectedValuesList()) {
						listModel2.removeElement(s);
					}
				}
			}
		});
		adicionaComponente(btn, 0, 1, 1, 1);
	}
} // fim da classe ListSelectionEventFrame
