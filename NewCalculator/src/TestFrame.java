import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ibm.xtq.xslt.xylem.instructions.LangInstruction;

import javax.swing.JTabbedPane;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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
	private JComboBox<String> comboBox_1;
	private static boolean lang = true; //german = true -> eng = false

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		lang = false;
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
	
	public String lang(String string) {
		
		if (lang) {
			
			switch (string) {
			case "Berechnen":
				return "Berechnen";
			case "Verlauf":
				return "Verlauf";
			case "Funktion":
				return "Funktion";
			case "Plot":
				return "Zeichnen";
			case "Convert":
				return "Umrechnen";
			default:
				break;
			}
			
		}else {
			switch (string) {
			case "Berechnen":
				return "Calculate";
			case "Verlauf":
				return "Log";
			case "Funktion":
				return "Funktion";
			case "Plot":
				return "Plot";
			case "Convert":
				return "Convert";
			default:
				break;
			}
		}
		
		return "Error";
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
		tabbedPane.addTab(lang("Berechnen"), null, panel, null);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("*");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float zahl1, zahl2, erg;
				zahl1 = Float.parseFloat(textField.getText());
				zahl2 = Float.parseFloat(textField_1.getText());
				erg = zahl1 * zahl2;
				textField_2.setText(""+erg);
				comboBox_1.addItem(zahl1+"*"+zahl2+"="+erg);

			}
		});
		
		JButton button_1 = new JButton("/");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float zahl1, zahl2, erg;
				zahl1 = Float.parseFloat(textField.getText());
				zahl2 = Float.parseFloat(textField_1.getText());
				erg = zahl1 / zahl2;
				textField_2.setText(""+erg);
				comboBox_1.addItem(zahl1+"/"+zahl2+"="+erg);

			}
		});
		panel.add(button_1);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("-");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float zahl1, zahl2, erg;
				zahl1 = Float.parseFloat(textField.getText());
				zahl2 = Float.parseFloat(textField_1.getText());
				erg = zahl1 - zahl2;
				textField_2.setText(""+erg);
				comboBox_1.addItem(zahl1+"-"+zahl2+"="+erg);
			}
		});
		panel.add(btnNewButton);
		
		JButton button = new JButton("+");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				float zahl1, zahl2, erg;
				zahl1 = Float.parseFloat(textField.getText());
				zahl2 = Float.parseFloat(textField_1.getText());
				erg = zahl1 + zahl2;
				textField_2.setText(""+erg);
				comboBox_1.addItem(zahl1+"+"+zahl2+"="+erg);

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
		tabbedPane.addTab(lang("Verlauf"), null, panel_1, null);
		
		comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String log = comboBox_1.getSelectedItem().toString();
				if (log.contains("+")) {
					textField.setText(log.substring(0, log.indexOf("+")));
					textField_1.setText(log.substring(log.indexOf("+")+1,log.indexOf("=")));
					textField_2.setText(log.substring(log.indexOf("=")+1));
				}else if (log.contains("-")) {
					textField.setText(log.substring(0, log.indexOf("-")));
					textField_1.setText(log.substring(log.indexOf("-")+1,log.indexOf("=")));
					textField_2.setText(log.substring(log.indexOf("=")+1));
				}else if (log.contains("*")) {
					textField.setText(log.substring(0, log.indexOf("*")));
					textField_1.setText(log.substring(log.indexOf("*")+1,log.indexOf("=")));
					textField_2.setText(log.substring(log.indexOf("=")+1));
				}else if (log.contains("/")) {
					textField.setText(log.substring(0, log.indexOf("/")));
					textField_1.setText(log.substring(log.indexOf("/")+1,log.indexOf("=")));
					textField_2.setText(log.substring(log.indexOf("=")+1));
				}
				
			}
		});
		panel_1.add(comboBox_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Graph", null, panel_2, null);
		
		txtFunktion = new JTextField();
		txtFunktion.setText(lang("Funktion"));
		panel_2.add(txtFunktion);
		txtFunktion.setColumns(10);
		
		JButton btnPlot = new JButton(lang("Plot"));
		panel_2.add(btnPlot);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab(lang("Convert"), null, panel_3, null);
		
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
				}else if (comboBox.getSelectedIndex() == 2) {
					textField_4.setText(Integer.toOctalString(Integer.parseInt(textField_3.getText())));
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Binary", "Hex","Octal"}));
		panel_3.add(comboBox);
		
		textField_4 = new JTextField();
		panel_3.add(textField_4);
		textField_4.setColumns(10);
	}

}
