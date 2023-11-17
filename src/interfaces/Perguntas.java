package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Perguntas extends JFrame implements ActionListener {
	JButton btnPerguntar = new JButton("Pergunte alguma coisa...");
	JButton btnSair = new JButton("X");
	TextField textVar1 = new TextField();
	TextField textVar2 = new TextField();
	Label lblPolvo = new Label("");
	Label lblOr = new Label("ou");

	String var1;
	String var2;

	Random escolha = new Random();

	public Perguntas() {

		setTitle("PERGUNTE ALGUMA COISA...");
		setSize(500, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);

		btnPerguntar.addActionListener(this);
		btnPerguntar.setBounds(100, 400, 200, 30);
		btnPerguntar.setBackground(Color.blue);
		btnPerguntar.setBorder(BorderFactory.createLineBorder(Color.black));
		btnPerguntar.setForeground(Color.black);

		btnSair.addActionListener(this);
		btnSair.setBounds(50, 100, 30, 30);
		btnSair.setBackground(Color.red);
		btnSair.setBorder(BorderFactory.createLineBorder(Color.black));
		btnSair.setForeground(Color.white);

		textVar1.setBackground(Color.LIGHT_GRAY);
		textVar1.setBounds(100, 250, 200, 30);
		textVar2.setBackground(Color.LIGHT_GRAY);
		textVar2.setBounds(100, 310, 200, 30);

//		lblPolvo.setBounds(240, 200, 200, 30);
//		lblPolvo.setBackground(null);
		lblOr.setBounds(190, 280, 20, 30);

		try {
			URL url = new URL("https://static.wikia.nocookie.net/omori/images/c/cc/Basil_door_something.png");
			Image image = ImageIO.read(url);
			Image img = image.getScaledInstance(50, 200, Image.SCALE_SMOOTH);
			JLabel lblImg = new JLabel(new ImageIcon(img));

			lblImg.setBounds(280, 80, 50, 200);
			lblImg.setBackground(Color.pink);
			add(lblImg);

		} catch (Exception err) {
		}

		add(btnPerguntar);
		add(btnSair);
		add(textVar1);
		add(lblOr);
		add(textVar2);

	}

	public void actionPerformed(ActionEvent e) {
		var1 = textVar1.getText();
		var2 = textVar2.getText();
		if (e.getSource() == btnSair) {
			System.exit(0);
		}
		if (e.getSource() == btnPerguntar) {
			int number = escolha.nextInt((2 - 1) + 1) + 1;

			if (!var1.equals("") && !var2.equals("")) {
				if (number == 1)
					JOptionPane.showMessageDialog(null, "O polvo disse: " + var1);
				else
					JOptionPane.showMessageDialog(null, "O polvo disse: " + var2);
			} else {

			}
		}
	}

	public static void main(String[] args) {
		new Perguntas();
	}
}
