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
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	private ArrayList<Pessoa> pessoas;
	private ArrayList<String> nomesNoComboBox;
	private JList jlistEmprestimosAtuais;
	private JList jlistPessoasCadastradas;
	private DefaultListModel emprestimosAtuais;
	private DefaultListModel pessoasCadastradas;
	private JComboBox jcbEmprestimosAtuais;

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
	public void initialize() {
		frmGestoDeNegcios = new JFrame();
		frmGestoDeNegcios.setTitle("Gest\u00E3o de Neg\u00F3cios");
		frmGestoDeNegcios.setBounds(100, 100, 550, 349);
		frmGestoDeNegcios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestoDeNegcios.getContentPane().setLayout(null);

		pessoas = new ArrayList<>();
		nomesNoComboBox = new ArrayList<String>();

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
		jtfDataDeNascimento.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				validaData();
			}

		});
		jtfDataDeNascimento.setToolTipText("DD/MM/AAAA");
		jtfDataDeNascimento.addKeyListener(new KeyAdapter() {

		});
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
		jbtnEmprestimo.setEnabled(false);
		jbtnEmprestimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarEmprestimo();
			}

		});
		jbtnEmprestimo.setBounds(341, 183, 157, 35);
		panel_1.add(jbtnEmprestimo);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(21, 21, 477, 141);
		panel_1.add(scrollPane_1);

		pessoasCadastradas = new DefaultListModel();

		jlistPessoasCadastradas = new JList(pessoasCadastradas);
		jlistPessoasCadastradas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exibePessoa();
			}

		});
		scrollPane_1.setViewportView(jlistPessoasCadastradas);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Empr\u00E9stimos atuais", null, panel_2, null);
		panel_2.setLayout(null);

		jcbEmprestimosAtuais = new JComboBox();
		jcbEmprestimosAtuais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adicionaPessoaListEmprestimos();
			}
		});
		jcbEmprestimosAtuais.setBounds(21, 21, 477, 32);
		panel_2.add(jcbEmprestimosAtuais);
		jcbEmprestimosAtuais.addItem("Selecione a pessoa");

		jbtnPago = new JButton("Pago");
		jbtnPago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeEmprestimo();
			}

		});
		jbtnPago.setBounds(357, 183, 141, 35);
		panel_2.add(jbtnPago);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 70, 477, 92);
		panel_2.add(scrollPane);

		emprestimosAtuais = new DefaultListModel();

		jlistEmprestimosAtuais = new JList(emprestimosAtuais);
		scrollPane.setViewportView(jlistEmprestimosAtuais);

	}

	protected void jbtnCadastrarActionPerformed(ActionEvent arg0) {
		
		try {
			if (jcbProfissao.getSelectedItem() == Profissao.Estudante) {
				Estudante es = new Estudante(jtfNome.getText(), Profissao.Estudante, jtfDataDeNascimento.getText(),
						jtfEmpresa.getText());
				pessoas.add(es);
				pessoasCadastradas.addElement(es.getNome());

			} else if (jcbProfissao.getSelectedItem() == Profissao.Aposentado) {
				Aposentado p = new Aposentado(jtfNome.getText(), Profissao.Aposentado, jtfDataDeNascimento.getText());
				pessoas.add(p);
				pessoasCadastradas.addElement(p.getNome());

			} else if (jcbProfissao.getSelectedItem() == Profissao.Empresario) {
				Empresario em = new Empresario(jtfNome.getText(), Profissao.Empresario, jtfDataDeNascimento.getText(),
						jtfEmpresa.getText());
				pessoas.add(em);
				pessoasCadastradas.addElement(em.getNome());
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
		limpaCampos();
	}
	public void limpaCampos(){
		jtfNome.setText("");
		jtfDataDeNascimento.setText("");
		jtfEmpresa.setText("");
	}
	
	protected void jcbProfissaoActionPerformed(ActionEvent arg0) {
		if (jcbProfissao.getSelectedItem() == Profissao.Estudante) {
			jtfEmpresa.setVisible(true);
			lblEmpresa.setText("Instituição:");
		} else if (jcbProfissao.getSelectedItem() == Profissao.Empresario) {
			jtfEmpresa.setVisible(true);
			lblEmpresa.setText("Empresa:");
		} else if (jcbProfissao.getSelectedItem() == Profissao.Aposentado) {
			jtfEmpresa.setVisible(false);
			lblEmpresa.setText("");
		}

	}

	private void validaData() {
		if (!jtfDataDeNascimento.getText().matches("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((?:19|20)\\d\\d)")) {
			JOptionPane.showMessageDialog(null, "Data incorreta. DD/MM/AAAA");
			jtfDataDeNascimento.requestFocus();
			jtfDataDeNascimento.setText("");
		}
	}

	private void exibePessoa() {
		if (jlistPessoasCadastradas.getSelectedIndex() >= 0) {
			int i = jlistPessoasCadastradas.getSelectedIndex();
			JOptionPane.showMessageDialog(null, pessoas.get(i).toString());
			jbtnEmprestimo.setEnabled(true);
		}
	}

	private void adicionarEmprestimo() {

		int posicaoSelecionada = jlistPessoasCadastradas.getSelectedIndex();
		Pessoa p = pessoas.get(posicaoSelecionada);
		// Garante que, se feito mais que um emprestimo em mesmo nome, é
		// adicionado corretamente.

		for (int i = 0; i < pessoas.size(); i++) {

			Pessoa pessoa = pessoas.get(i);
			if (pessoa.getNome().equals(p.getNome()))
				p = pessoa;
			pessoas.remove(posicaoSelecionada);

		}

		int valor = Integer.parseInt(JOptionPane.showInputDialog("Informe o valor do empréstimo"));

		if (p instanceof Estudante) {
			if (valor != 1000) {
				JOptionPane.showMessageDialog(null, "Estudantes tem a quantia fixa de R$ 1000");
			} else if (p.getEmprestimos().size() >= 1) {
				JOptionPane.showMessageDialog(null, "Estudantes tem o limite de 1 empréstimo");
			} else {
				Emprestimo emprestimo = new Emprestimo(valor);
				p.getEmprestimos().add(emprestimo);
			}

		} else if (p instanceof Aposentado) {
			if (valor != 500 && valor != 1000) {
				JOptionPane.showMessageDialog(null, "Aposentados tem a quantia fixa de R$ 500, R$ 1000");
			} else if (p.getEmprestimos().size() >= 2) {
				JOptionPane.showMessageDialog(null, "Aposentados tem o limite de 2 empréstimos");
			} else {
				Emprestimo emprestimo = new Emprestimo(valor);
				p.getEmprestimos().add(emprestimo);
			}
		} else {
			Emprestimo emprestimo = new Emprestimo(valor);
			p.getEmprestimos().add(emprestimo);
		}
		adicionaComboBox(p);
		pessoas.add(posicaoSelecionada, p);
	}

	public void adicionaComboBox(Pessoa p) {

		if (!nomesNoComboBox.contains(p.getNome()))
			jcbEmprestimosAtuais.addItem(p.getNome());

		nomesNoComboBox.add(p.getNome());
	}

	private void adicionaPessoaListEmprestimos() {
	//	
		int posicao = jcbEmprestimosAtuais.getSelectedIndex();
	
		if (posicao != 0) {
			String nomeSelecionado = nomesNoComboBox.get(posicao);
			String texto = "Emprestimo: ";
			for (Pessoa p : pessoas) {

				if (p.getNome().equals(nomeSelecionado)) {
					if (p.getEmprestimos().size() > 0) {
						for (Emprestimo e : p.getEmprestimos()) {
							String valor = e.getValor() + "";
							emprestimosAtuais.addElement(texto + valor);
						}
					}
				}
			}
		}
	}

	private void removeEmprestimo() {

		String nome = (String) jcbEmprestimosAtuais.getSelectedItem();

		for (Pessoa p : pessoas) {
			if (nome.equals(p.getNome())) {
				p.getEmprestimos().remove(jlistEmprestimosAtuais.getSelectedIndex());
				emprestimosAtuais.remove(jlistEmprestimosAtuais.getSelectedIndex());
			}
		}
	}
}
