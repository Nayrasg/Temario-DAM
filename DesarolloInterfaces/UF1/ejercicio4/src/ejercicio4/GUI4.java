package ejercicio4;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class GUI4 {

	private JFrame frame;
	private JTextField cantidad;
	private JTextField etiResul;
	private JButton convertir;
	private JComboBox divUno;
	private JComboBox divDos;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI4 window = new GUI4();
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
	public GUI4() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cantidad");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(21, 50, 101, 20);
		frame.getContentPane().add(lblNewLabel);
		
		cantidad = new JTextField();
		cantidad.setBounds(103, 47, 159, 31);
		frame.getContentPane().add(cantidad);
		cantidad.setColumns(10);
		
		ButtonGroup bg = new ButtonGroup();
		
		
		etiResul = new JTextField();
		etiResul.setEditable(false);
		etiResul.setBounds(141, 153, 159, 31);
		frame.getContentPane().add(etiResul);
		etiResul.setColumns(10);
		
		convertir = new JButton("Convertir");
		convertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double monedas = Double.parseDouble(cantidad.getText());
				int divisa = divUno.getSelectedIndex();
				int divisa2 = divDos.getSelectedIndex();
				
				if (divisa==0 && divisa2==0)
				{
					double resultado = monedas * 1.19;
					etiResul.setText(String.valueOf(resultado));
					
				}else if (divisa==1 && divisa2==1)
						{
								double resultado = monedas * 0.84;
								etiResul.setText(String.valueOf(resultado));

						}else if (divisa==0 && divisa2==1)
								{
									double resultado =monedas;
									etiResul.setText(String.valueOf(resultado));
								}else if (divisa==1 && divisa2==0)
										
									{
									double resultado =monedas;
									etiResul.setText(String.valueOf(resultado));
									}
							
					
					
				
			}
		});
		convertir.setFont(new Font("Tahoma", Font.PLAIN, 16));
		convertir.setBounds(160, 206, 122, 31);
		frame.getContentPane().add(convertir);
		
		JLabel lblNewLabel_1 = new JLabel("a");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(214, 107, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		divUno = new JComboBox();
		divUno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		divUno.setModel(new DefaultComboBoxModel(new String[] {"EUR", "USD"}));
		divUno.setSelectedIndex(0);
		divUno.setBounds(79, 99, 73, 31);
		frame.getContentPane().add(divUno);
		
		divDos = new JComboBox();
		divDos.setModel(new DefaultComboBoxModel(new String[] {"USD", "EUR"}));
		divDos.setSelectedIndex(0);
		divDos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		divDos.setBounds(276, 99, 73, 31);
		frame.getContentPane().add(divDos);
		
		lblNewLabel_2 = new JLabel("Convertidor de divisas");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel_2.setBounds(113, 0, 260, 28);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
