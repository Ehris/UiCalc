import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTabbedPane;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TestFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField txtFunktion;
	
	
	//private String[] lang= {"Rechen","Verlauf","Graph","Umrechnen"};
	private String[] lang= {"Calculate","Log","Graph","Convert"};
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestFrame frame = new TestFrame();
					
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
	public TestFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab(lang[0], null, panel, null);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("*");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double zahl1, zahl2, erg;
				zahl1 = Double.parseDouble(textField.getText());
				zahl2 = Double.parseDouble(textField_1.getText());
				erg = zahl1 * zahl2;
				textField_2.setText(""+erg);
			}
		});
		
		JButton button_1 = new JButton("/");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double zahl1, zahl2, erg;
				zahl1 = Double.parseDouble(textField.getText());
				zahl2 = Double.parseDouble(textField_1.getText());
				erg = zahl1 / zahl2;
				textField_2.setText(""+erg);
			}
		});
		panel.add(button_1);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("-");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double zahl1, zahl2, erg;
				zahl1 = Double.parseDouble(textField.getText());
				zahl2 = Double.parseDouble(textField_1.getText());
				erg = zahl1 - zahl2;
				textField_2.setText(""+erg);
			}
		});
		panel.add(btnNewButton);
		
		JButton button = new JButton("+");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double zahl1, zahl2, erg;
				zahl1 = Double.parseDouble(textField.getText());
				zahl2 = Double.parseDouble(textField_1.getText());
				erg = zahl1 + zahl2;
				textField_2.setText(""+erg);
			}
		});
		panel.add(button);
		
		textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label = new JLabel("=");
		panel.add(label);
		
		textField_2 = new JTextField();
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab(lang[1], null, panel_1, null);
		
		JComboBox comboBox_1 = new JComboBox();
		panel_1.add(comboBox_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab(lang[2], null, panel_2, null);
		
		txtFunktion = new JTextField();
		txtFunktion.setText("Funktion");
		panel_2.add(txtFunktion);
		txtFunktion.setColumns(10);
		
		JButton btnPlot = new JButton("Plot");
		panel_2.add(btnPlot);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab(lang[3], null, panel_3, null);
		
		textField_3 = new JTextField();
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() == 0) {
					textField_4.setText(Integer.toBinaryString(Integer.parseInt(textField_3.getText())));
				}else if (comboBox.getSelectedIndex() == 1) {
					textField_4.setText(Integer.toHexString(Integer.parseInt(textField_3.getText())));
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Binary", "Hex"}));
		panel_3.add(comboBox);
		
		textField_4 = new JTextField();
		panel_3.add(textField_4);
		textField_4.setColumns(10);
	}

}
