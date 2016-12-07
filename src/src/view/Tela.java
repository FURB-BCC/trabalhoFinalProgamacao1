package src.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class Tela {

	private JFrame frmGestoDeNegcios;
	private JTextField jtfNome;
	private JTextField jtfDataNascimento;
	private JTextField jtfEmpresa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela window = new Tela();
					window.frmGestoDeNegcios.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestoDeNegcios = new JFrame();
		frmGestoDeNegcios.setTitle("Gest\u00E3o de Neg\u00F3cios");
		frmGestoDeNegcios.setBounds(100, 100, 550, 501);
		frmGestoDeNegcios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestoDeNegcios.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(21, 21, 61, 26);
		frmGestoDeNegcios.getContentPane().add(lblNome);
		
		JLabel lblProfisso = new JLabel("Profiss\u00E3o:");
		lblProfisso.setBounds(21, 62, 92, 26);
		frmGestoDeNegcios.getContentPane().add(lblProfisso);
		
		jtfNome = new JTextField();
		jtfNome.setBounds(134, 18, 369, 32);
		frmGestoDeNegcios.getContentPane().add(jtfNome);
		jtfNome.setColumns(10);
		
		JComboBox jcbProfissao = new JComboBox();
		jcbProfissao.setBounds(134, 59, 369, 32);
		frmGestoDeNegcios.getContentPane().add(jcbProfissao);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setBounds(21, 103, 202, 26);
		frmGestoDeNegcios.getContentPane().add(lblDataDeNascimento);
		
		jtfDataNascimento = new JTextField();
		jtfDataNascimento.setBounds(244, 100, 259, 32);
		frmGestoDeNegcios.getContentPane().add(jtfDataNascimento);
		jtfDataNascimento.setColumns(10);
		
		JLabel lblEmpresa = new JLabel("Empresa:");
		lblEmpresa.setBounds(21, 144, 92, 26);
		frmGestoDeNegcios.getContentPane().add(lblEmpresa);
		
		jtfEmpresa = new JTextField();
		jtfEmpresa.setBounds(134, 141, 369, 32);
		frmGestoDeNegcios.getContentPane().add(jtfEmpresa);
		jtfEmpresa.setColumns(10);
		
		JButton jbtnCadastrar = new JButton("Cadastrar");
		jbtnCadastrar.setBounds(362, 194, 141, 35);
		frmGestoDeNegcios.getContentPane().add(jbtnCadastrar);
	}
}
