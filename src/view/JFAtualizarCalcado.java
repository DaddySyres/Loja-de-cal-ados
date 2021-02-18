package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.bean.Calcado;
import model.dao.CalcadoDAO;
import view.JFAtualizarCalcado.SwingAction;
import view.JFAtualizarCalcado.SwingAction_1;
import view.JFAtualizarCalcado.SwingAction_2;

public class JFAtualizarCalcado extends JFrame {

	private JPanel contentPane;
	private JTextField textModelo;
	private JTextField textMarca;
	private JTextField textPreço;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private static int cId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFAtualizarCalcado frame = new JFAtualizarCalcado(cId);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param cId 
	 */
	public JFAtualizarCalcado(int cId) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 747, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		CalcadoDAO cdao = new CalcadoDAO();
		Calcado c = cdao.read(cId);
		
		JLabel lblNewLabel = new JLabel("Cadastrar Atualizar");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(10, 10, 300, 31);
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
		
		
		JLabel lblNewLabel_2 = new JLabel("ID: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(378, 24, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblId = new JLabel("0");
		lblId.setBounds(426, 24, 45, 13);
		contentPane.add(lblId);
		
		lblId.setText(String.valueOf(c.getCalcadoId()));
		textModelo.setText(c.getCalcadoModelo());
		textMarca.setText(c.getCalcadoMarca());
		String str = String.valueOf(c.getCalcadoPreço());
		textPreço.setText(str);
		spinnerTamanho.setValue(c.getCalcadoTamanho());
		if(c.isCalcadoEstoque() == true) {
			rdbtnSim.setSelected(true);
		}else{
			rdbtnNao.setSelected(true);
		}
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Calcado c = new Calcado();
				CalcadoDAO cdao = new CalcadoDAO();
				c.setCalcadoId(cId);
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
				cdao.update(c);
			}
		});
		btnAtualizar.setAction(action);
		btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizar.setBounds(10, 373, 106, 31);
		contentPane.add(btnAtualizar);
		
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
	public class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Atualizar");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	public class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Limpar");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	public class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Cancelar");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
