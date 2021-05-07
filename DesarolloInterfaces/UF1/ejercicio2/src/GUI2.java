import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JButton;

public class GUI2 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI2 window = new GUI2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Modelo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(41, 41, 74, 21);
		frame.getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Arosa", "Le\u00F3n", "Ibiza", "Arona"}));
		comboBox.setSelectedIndex(0);
		comboBox.setToolTipText("Arosa,\r\nLe\u00F3n,\r\nIbiza,\r\nArona,");
		comboBox.setBounds(136, 36, 205, 31);
		frame.getContentPane().add(comboBox);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Como nuevo");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton.setBounds(41, 116, 155, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Bueno");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton_1.setBounds(41, 142, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Alg\u00FAn desperfecto");
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton_2.setBounds(41, 168, 155, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_2);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_1);
		bg.add(rdbtnNewRadioButton_2);
		JLabel lblNewLabel_1 = new JLabel("Kilometros:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(56, 241, 94, 14);
		frame.getContentPane().add(lblNewLabel_1);
		JLabel etiValor = new JLabel("");
		JSlider slDeslizador = new JSlider();
		slDeslizador.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				etiValor.setText("KM: " +slDeslizador.getValue());
			}
		});
		slDeslizador.setMajorTickSpacing(5000);
		slDeslizador.setValue(0);
		slDeslizador.setPaintLabels(true);
		slDeslizador.setPaintTicks(true);
		slDeslizador.setMaximum(50000);
		slDeslizador.setBounds(24, 285, 436, 45);
		frame.getContentPane().add(slDeslizador);
		
		
		etiValor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		etiValor.setBounds(201, 364, 109, 31);
		frame.getContentPane().add(etiValor);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(353, 405, 107, 31);
		frame.getContentPane().add(btnNewButton);
	}
}
