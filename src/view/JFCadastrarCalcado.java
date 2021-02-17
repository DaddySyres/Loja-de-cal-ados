package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import model.bean.Calcado;
import model.dao.CalcadoDAO;

import javax.swing.JLabel;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;

public class JFCadastrarCalcado extends JFrame {

	private JPanel contentPane;
	private JTextField textModelo;
	private JTextField textMarca;
	private JTextField textPreço;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFCadastrarCalcado frame = new JFCadastrarCalcado();
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
	public JFCadastrarCalcado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 747, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastrar Cal\u00E7ado");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(10, 10, 179, 31);
		contentPane.add(lblNewLabel);
		
		textModelo = new JTextField();
		textModelo.setBounds(10, 105, 345, 25);
		contentPane.add(textModelo);
		textModelo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Modelo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 75, 93, 20);
		contentPane.add(lblNewLabel_1);
		
		textMarca = new JTextField();
		textMarca.setColumns(10);
		textMarca.setBounds(378, 105, 345, 25);
		contentPane.add(textMarca);
		
		JLabel lblNewLabel_1_1 = new JLabel("Marca");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(378, 75, 93, 20);
		contentPane.add(lblNewLabel_1_1);
		
		JSpinner spinnerTamanho = new JSpinner();
		spinnerTamanho.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinnerTamanho.setBounds(133, 200, 99, 31);
		contentPane.add(spinnerTamanho);
		
		JLabel lblNewLabel_1_2 = new JLabel("Pre\u00E7o");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(10, 170, 93, 20);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Tamanho");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(133, 170, 93, 20);
		contentPane.add(lblNewLabel_1_3);
		
		textPreço = new JTextField();
		textPreço.setBounds(10, 200, 106, 31);
		contentPane.add(textPreço);
		textPreço.setColumns(10);
		
		JRadioButton rdbtnSim = new JRadioButton("Sim");
		rdbtnSim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnSim.setBounds(378, 204, 49, 21);
		contentPane.add(rdbtnSim);
		
		JRadioButton rdbtnNao = new JRadioButton("N\u00E3o");
		rdbtnNao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNao.setBounds(429, 204, 57, 21);
		contentPane.add(rdbtnNao);
		
		ButtonGroup estoque = new ButtonGroup();
		estoque.add(rdbtnSim);
		estoque.add(rdbtnNao);
		
		JLabel lblNewLabel_1_4 = new JLabel("Em estoque?");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_4.setBounds(378, 170, 93, 20);
		contentPane.add(lblNewLabel_1_4);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Calcado c = new Calcado();
				CalcadoDAO dao = new CalcadoDAO();
				c.setCalcadoModelo(textModelo.getText());
				c.setCalcadoMarca(textMarca.getText());
				c.setCalcadoPreço(Double.parseDouble(textPreço.getText()));
				c.setCalcadoTamanho(Integer.parseInt(spinnerTamanho.getValue().toString()));
				
				if(rdbtnNao.isSelected()) {
					c.setCalcadoEstoque(false);
				}
				else if (rdbtnSim.isSelected()) {
					c.setCalcadoEstoque(true);
				}
				dao.create(c);
			}
		});
		btnNewButton.setAction(action);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(10, 373, 106, 31);
		contentPane.add(btnNewButton);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textModelo.setText(null);
				textMarca.setText(null);
				textPreço.setText(null);
				spinnerTamanho.setValue(0);
				estoque.clearSelection();
			}
		});
		btnLimpar.setAction(action_1);
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(501, 373, 106, 31);
		contentPane.add(btnLimpar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setAction(action_2);
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(617, 373, 106, 31);
		contentPane.add(btnCancelar);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Cadastrar");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Limpar");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Cancelar");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
