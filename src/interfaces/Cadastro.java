package interfaces;

import java.awt.Color;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Year;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Cadastro extends JFrame implements ActionListener {
	
	JButton btnMensagem = new JButton("Mensagem");
	JButton btnLimparNome = new JButton("Limpar Campos");
	JButton btnSair = new JButton("X");
	TextField textNome = new TextField();
	TextField textAnoNascimento = new TextField();
	Label lblNome = new Label("Nome");
	Label lblAnoDeNascimento = new Label("Ano de Nascimento");

	String name;
	String birth;

	LocalDate dataAtual = LocalDate.now();
	int anoAtual = dataAtual.getYear();
	
//	Calendar calendario = Calendar.getInstance();

	public Cadastro() {

		setTitle("Cadastro de Aniversário");
		setSize(500, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);
		btnMensagem.addActionListener(this);
		btnMensagem.setBounds(100, 400, 100, 30);
		btnMensagem.setBackground(Color.pink);
		btnMensagem.setBorder(BorderFactory.createLineBorder(Color.black));
		btnMensagem.setForeground(Color.black);

		btnLimparNome.addActionListener(this);
		btnLimparNome.setBounds(300, 400, 100, 30);
		btnLimparNome.setBackground(Color.pink);
		btnLimparNome.setBorder(BorderFactory.createLineBorder(Color.black));
		btnLimparNome.setForeground(Color.black);

		btnSair.addActionListener(this);
		btnSair.setBounds(100, 100, 30, 30);
		btnSair.setBackground(Color.red);
		btnSair.setBorder(BorderFactory.createLineBorder(Color.black));
		btnSair.setForeground(Color.white);

		textNome.setBackground(Color.LIGHT_GRAY);
		textNome.setBounds(150, 200, 200, 30);

		lblNome.setBounds(150, 170, 200, 30);

		textAnoNascimento.setBackground(Color.LIGHT_GRAY);
		textAnoNascimento.setBounds(150, 300, 200, 30);

		lblAnoDeNascimento.setBounds(150, 270, 400, 30);

		add(btnMensagem);
		add(btnLimparNome);
		add(btnSair);
		add(textNome);
		add(lblNome);
		add(textAnoNascimento);
		add(lblAnoDeNascimento);

	}

	// ação do botão --> e = evento
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnSair) {
			System.exit(0);
		}
		if (e.getSource() == btnLimparNome) {
			textNome.setText("");
			textAnoNascimento.setText("");
		}
		if (e.getSource() == btnMensagem) {

			name = textNome.getText();
			birth = textAnoNascimento.getText();

			if (!name.equals("") && !birth.equals("")) {
				try {
					int idade = anoAtual - Integer.parseInt(birth);
					if(idade < 0) {
						JOptionPane.showMessageDialog(null, "Olá, " + name + ", se é que esse é seu nome mesmo.... \nAno " + birth + "? Você é um viajante do tempo ou algo assim?");
					}else if(idade > 130) {
						JOptionPane.showMessageDialog(null, "Olá, " + name + "! Você nasceu em " + birth + " e tem " + idade + " anos? Um tanto suspeito, mas parabéns por viver tanto assim...");
					}else {
						JOptionPane.showMessageDialog(null, "Olá, " + name + "! Você nasceu em " + birth + " e tem " + idade + " anos.");
					}

				}catch(Exception err){
				}
				finally {
					
				}

		}
		}
	}

	public static void main(String[] args) {
		new Cadastro();
	}
}
