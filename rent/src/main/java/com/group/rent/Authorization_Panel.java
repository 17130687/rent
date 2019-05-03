package com.group.rent;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.group.rent.Authorization_Panel;
import com.group.rent.Accountant_Panel;
import com.group.rent.User_Panel;

public class Authorization_Panel extends JFrame {
	private User_Panel uf;
	private Accountant_Panel af;
	private JPasswordField pass;
	private JTextField JTextField_Login;
	private JPanel panel;
	public int auth_labels_number = 3;
	public JLabel[] auth_labels = new JLabel[auth_labels_number];
	public String auth_labels_text[] = { "Авторизация", "Имя пользователя", "Пароль", };
	public int auth_labels_size[] = { 190, 25, 230, 42, 175, 88, 150, 24, 205, 145, 55, 24 };

	public Authorization_Panel() {
		getContentPane().setLayout(new CardLayout());
		panel = new JPanel();
		panel.setLayout(null);
		getContentPane().add(panel, "Auth");
		auth_labels_add(auth_labels_number, auth_labels_text, auth_labels_size, panel);
		JTextField_Login = new JTextField();
		JTextField_Login.setColumns(10);
		JTextField_Login.setBounds(180, 113, 94, 20);
		panel.add(JTextField_Login);
		pass = new JPasswordField();
		pass.setBounds(180, 170, 94, 20);
		panel.add(pass);
		JButton JButton_Enter = new JButton("Вход");
		JButton_Enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) getContentPane().getLayout();
				if (auth(JTextField_Login.getText(), pass.getText()) == 1) {
					killFrame();
					uf = new User_Panel();
					uf.setSize(600, 500);
					uf.setVisible(true);
				} else if (auth(JTextField_Login.getText(), pass.getText()) == 2) {
					killFrame();
					af = new Accountant_Panel();
					af.setSize(800, 500);
					af.setVisible(true);
				} else if (auth(JTextField_Login.getText(), pass.getText()) == 0) {
					JOptionPane.showMessageDialog(panel, "Проверьте правильность введенных логина и/или пароля",
							"Неправильный логин или пароль", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		JButton_Enter.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
		JButton_Enter.setBounds(180, 210, 94, 31);
		panel.add(JButton_Enter);
	}

	private int access;

	public void killFrame() {
		this.dispose();
	}

	public int auth(String login, String pass) {
		if ((login.equals("Эльвина")) || (login.equals("Евгения"))
				|| (login.equals("Маргарита")) && pass.equals("123")) {
			access = 1;
		} else if (login.equals("Дарья") && pass.equals("123")) {
			access = 2;
		} else {
			access = 0;
		}
		return access;
	}

	public void auth_labels_add(int auth_labels_number, String auth_labels_text[], int auth_labels_size[],
			JPanel panel) {
		for (int i = 0; i < auth_labels_number; i++) {
			auth_labels[i] = new JLabel();
			auth_labels[i].setText(auth_labels_text[i]);
			auth_labels[i].setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
			auth_labels[i].setBounds(auth_labels_size[i * 4], auth_labels_size[i * 4 + 1], auth_labels_size[i * 4 + 2],
					auth_labels_size[i * 4 + 3]);
			panel.add(auth_labels[i]);
		}
	}

	public static void main(String[] args) {
		Authorization_Panel frame = new Authorization_Panel();
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}
}