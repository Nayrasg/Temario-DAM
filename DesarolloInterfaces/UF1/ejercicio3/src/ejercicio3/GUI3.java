package ejercicio3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI3 {

	private JFrame frame;
	private JTextField numUno;
	private JTextField numDos;
	private JTextField etiResul;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI3 window = new GUI3();
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
	public GUI3() {
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
		
		JLabel lblNewLabel = new JLabel("N\u00BA 1");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(40, 46, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		numUno = new JTextField();
		numUno.setBounds(104, 41, 113, 28);
		frame.getContentPane().add(numUno);
		numUno.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("N\u00BA 2");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(40, 104, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		numDos = new JTextField();
		numDos.setBounds(104, 98, 113, 28);
		frame.getContentPane().add(numDos);
		numDos.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Resultado");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(21, 179, 74, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		etiResul = new JTextField();
		etiResul.setEditable(false);
		etiResul.setBounds(104, 174, 113, 28);
		frame.getContentPane().add(etiResul);
		etiResul.setColumns(10);
		
		JButton bSumar = new JButton("+");
		bSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int operando1 = Integer.parseInt(numUno.getText()); //convierto en int la cadena de texto extraida
				int operando2 = Integer.parseInt(numDos.getText());
				int resultado = operando1 + operando2;
				etiResul.setText(String.valueOf(resultado));
			}
		});
		bSumar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		bSumar.setBounds(270, 37, 46, 31);
		frame.getContentPane().add(bSumar);
		
		JButton bRestar = new JButton("-");
		bRestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int operando1 = Integer.parseInt(numUno.getText()); //convierto en int la cadena de texto extraida
				int operando2 = Integer.parseInt(numDos.getText());
				int resultado = operando1 - operando2;
				etiResul.setText(String.valueOf(resultado));
			}
		});
		bRestar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bRestar.setBounds(346, 37, 46, 31);
		frame.getContentPane().add(bRestar);
		
		JButton bMulti = new JButton("*");
		bMulti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int operando1 = Integer.parseInt(numUno.getText()); //convierto en int la cadena de texto extraida
				int operando2 = Integer.parseInt(numDos.getText());
				int resultado = operando1 * operando2;
				etiResul.setText(String.valueOf(resultado));
			}
		});
		bMulti.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bMulti.setBounds(270, 98, 46, 31);
		frame.getContentPane().add(bMulti);
		
		JButton bDividir = new JButton("/");
		bDividir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int operando1 = Integer.parseInt(numUno.getText()); //convierto en int la cadena de texto extraida
				int operando2 = Integer.parseInt(numDos.getText());
				int resultado = operando1 / operando2;
				etiResul.setText(String.valueOf(resultado));
			}
		});
		bDividir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bDividir.setBounds(346, 98, 46, 31);
		frame.getContentPane().add(bDividir);
		
		JButton bBorrar = new JButton("Borrar");
		bBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				numUno.setText("");
				numDos.setText("");
				etiResul.setText("");
			}
		});
		bBorrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bBorrar.setBounds(270, 171, 122, 31);
		frame.getContentPane().add(bBorrar);
	}

}
