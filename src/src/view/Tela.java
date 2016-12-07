package src.view;

import src.model.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JList;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela {

	private JFrame frmGestoDeNegcios;
	private JTextField jtfNome;
	private JTextField jtfEmpresa;
	private JTextField jtfDataDeNascimento;
	private JComboBox jcbProfissao;
	private JLabel lblEmpresa;

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
		frmGestoDeNegcios.setBounds(100, 100, 550, 349);
		frmGestoDeNegcios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestoDeNegcios.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 524, 279);
		frmGestoDeNegcios.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Cadastro", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(21, 21, 92, 26);
		panel.add(lblNome);
		
		JLabel lblProfisso = new JLabel("Profiss\u00E3o:");
		lblProfisso.setBounds(21, 63, 92, 26);
		panel.add(lblProfisso);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento:");
		lblDataDeNascimento.setBounds(21, 104, 193, 26);
		panel.add(lblDataDeNascimento);
		
		lblEmpresa = new JLabel("Empresa:");
		lblEmpresa.setBounds(21, 145, 92, 26);
		panel.add(lblEmpresa);
		
		jtfNome = new JTextField();
		jtfNome.setBounds(134, 18, 364, 32);
		panel.add(jtfNome);
		jtfNome.setColumns(10);
		
		jtfEmpresa = new JTextField();
		jtfEmpresa.setBounds(134, 142, 364, 32);
		panel.add(jtfEmpresa);
		jtfEmpresa.setColumns(10);
		
		jtfDataDeNascimento = new JTextField();
		jtfDataDeNascimento.setBounds(227, 101, 271, 32);
		panel.add(jtfDataDeNascimento);
		jtfDataDeNascimento.setColumns(10);
		
		jcbProfissao = new JComboBox(Profissao.values());
		jcbProfissao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jcbProfissaoActionPerformed(arg0);
			}
		});
		jcbProfissao.setBounds(134, 60, 364, 32);
		panel.add(jcbProfissao);
		
		JButton jtbnCadastrar = new JButton("Cadastrar");
		jtbnCadastrar.setBounds(357, 195, 141, 35);
		panel.add(jtbnCadastrar);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Pessoas cadastradas", null, panel_1, null);
		panel_1.setLayout(null);
		
		JButton jbtnEmprstimo = new JButton("Empr\u00E9stimo");
		jbtnEmprstimo.setBounds(341, 183, 157, 35);
		panel_1.add(jbtnEmprstimo);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(21, 21, 477, 141);
		panel_1.add(scrollPane_1);
		
		JList jlistPessoaCadastradas = new JList();
		scrollPane_1.setViewportView(jlistPessoaCadastradas);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Empr\u00E9stimos atuais", null, panel_2, null);
		panel_2.setLayout(null);
		
		JComboBox jcbEmprestimosAtuais = new JComboBox();
		jcbEmprestimosAtuais.setBounds(21, 21, 477, 32);
		panel_2.add(jcbEmprestimosAtuais);
		
		JButton jbtnPago = new JButton("Pago");
		jbtnPago.setBounds(357, 183, 141, 35);
		panel_2.add(jbtnPago);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 70, 477, 92);
		panel_2.add(scrollPane);
		
		JList jlistEmprestimosAtuais = new JList();
		scrollPane.setViewportView(jlistEmprestimosAtuais);
		
			
	}

	protected void jcbProfissaoActionPerformed(ActionEvent arg0) {
		if(jcbProfissao.getSelectedItem() == Profissao.Estudante)
			lblEmpresa.setText("Instituição:");
		else
			lblEmpresa.setText("Empresa:");
		
	}


}
