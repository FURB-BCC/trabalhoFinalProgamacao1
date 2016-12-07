package src.view;

import src.model.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JList;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Tela {

	private JFrame frmGestoDeNegcios;
	private JTextField jtfNome;
	private JTextField jtfEmpresa;
	private JTextField jtfDataDeNascimento;
	private JButton jtbnCadastrar;
	private JButton jbtnEmprestimo;
	private JButton jbtnPago;
	private JComboBox jcbProfissao;
	private JLabel lblEmpresa;
	private ArrayList<Pessoa> cadastro;

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
		
		cadastro = new ArrayList<>();
		
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
		
		jtbnCadastrar = new JButton("Cadastrar");
		jtbnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jbtnCadastrarActionPerformed(arg0);
			}
		});
		jtbnCadastrar.setBounds(357, 195, 141, 35);
		panel.add(jtbnCadastrar);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Pessoas cadastradas", null, panel_1, null);
		panel_1.setLayout(null);
		
		jbtnEmprestimo = new JButton("Empr\u00E9stimo");
		jbtnEmprestimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnEmprestimoActionPerformed(e);
			}
		});
		jbtnEmprestimo.setBounds(341, 183, 157, 35);
		panel_1.add(jbtnEmprestimo);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(21, 21, 477, 141);
		panel_1.add(scrollPane_1);
		
		DefaultListModel pessoasCadastradas = new DefaultListModel();
		
		JList jlistPessoasCadastradas = new JList(pessoasCadastradas);
		scrollPane_1.setViewportView(jlistPessoasCadastradas);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Empr\u00E9stimos atuais", null, panel_2, null);
		panel_2.setLayout(null);
		
		JComboBox jcbEmprestimosAtuais = new JComboBox();
		jcbEmprestimosAtuais.setBounds(21, 21, 477, 32);
		panel_2.add(jcbEmprestimosAtuais);
		
		jbtnPago = new JButton("Pago");
		jbtnPago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnPagoActionPerformed(e);
			}
		});
		jbtnPago.setBounds(357, 183, 141, 35);
		panel_2.add(jbtnPago);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 70, 477, 92);
		panel_2.add(scrollPane);
		
		DefaultListModel emprestimosAtuais = new DefaultListModel();
		
		JList jlistEmprestimosAtuais = new JList(emprestimosAtuais);
		scrollPane.setViewportView(jlistEmprestimosAtuais);
		
			
	}

	protected void jbtnPagoActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	protected void jbtnEmprestimoActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	protected void jbtnCadastrarActionPerformed(ActionEvent arg0) {
		try {
		if(jcbProfissao.getSelectedItem() == Profissao.Estudante)
			cadastro.add(new Estudante(jtfNome.getText(), Profissao.Estudante, jtfDataDeNascimento.getText(), jtfEmpresa.getText()));
		else if(jcbProfissao.getSelectedItem() == Profissao.Aposentado)
			cadastro.add(new Aposentado(jtfNome.getText(), Profissao.Aposentado, jtfDataDeNascimento.getText()));
		else if(jcbProfissao.getSelectedItem() == Profissao.Empresario)
			cadastro.add(new Empresario(jtfNome.getText(), Profissao.Estudante, jtfDataDeNascimento.getText(), jtfEmpresa.getText()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void jcbProfissaoActionPerformed(ActionEvent arg0) {
		if(jcbProfissao.getSelectedItem() == Profissao.Estudante){
			jtfEmpresa.setVisible(true);
			lblEmpresa.setText("Instituição:");
		}
		else if(jcbProfissao.getSelectedItem() == Profissao.Empresario){
			jtfEmpresa.setVisible(true);
			lblEmpresa.setText("Empresa:");
		}
		else if(jcbProfissao.getSelectedItem() == Profissao.Aposentado){
			jtfEmpresa.setVisible(false);
			lblEmpresa.setText("");
		}
		
	}


}
