package com.group.rent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public abstract class Main_Panel extends JFrame {
	public int switchKey = 0;
	public double TARIF_HOT_WATER = 27.5;
	public double TARIF_COLD_WATER = 25.43;
	public double TARIF_GAS = 7.1;
	public double TARIF_SVET = 3.06;
	public double tarrif_hot_water = 0;
	public double tarrif_cold_water = 0;
	public double tarrif_gas = 0;
	public double tarrif_svet = 0;
	public double normativ = 0;
	public double area = 0;
	public double v_gas = 0;
	public double v_cold_water = 0;
	public double v_hot_water = 0;
	public double v_svet = 0;
	public double dolg = 0;
	public double pereplata = 0;
	public double itog = 0;
	public double sumcoldwater = 0;
	public double sumhotwater = 0;
	public double sumgas = 0;
	public double sumsvet = 0;
	protected JPanel panel;
	public int buttons_number = 2;
	public JButton[] buttons = new JButton[buttons_number];
	public String buttons_name[] = { "ExitButton", "CalculateButton" };
	public String buttons_text[] = { "Сброс", "Расчет" };
	public int buttons_size[] = { 178, 380, 89, 23, 10, 380, 89, 23 };
	public int radiobuttons_number = 2;
	public JRadioButton[] radiobuttons = new JRadioButton[radiobuttons_number];
	public String radiobuttons_name[] = { "ApartmentRadioButton", "HouseRadioButton" };
	public String radiobuttons_text[] = { "Квартира", "Частный дом" };
	public int radiobuttons_size[] = { 6, 25, 100, 23, 6, 43, 150, 23 };
	public int user_textfields_number = 13;
	public JTextField[] user_textfields = new JTextField[user_textfields_number];
	public String user_textfields_name[] = { "textField_area", "textField_normativ", "textField_v_cold_water",
			"textField_v_hot_water", "textField_v_svet", "textField_v_gas", "textField_dolg", "textField_pereplata",
			"textField_sumcoldwater", "textField_sumhotwater", "textField_sumgas", "textField_sumsvet",
			"textField_itog" };
	public int user_textfields_size[] = { 270, 25, 86, 20, 250, 67, 86, 20, 250, 92, 86, 20, 250, 117, 86, 20, 250, 142,
			86, 20, 250, 167, 86, 20, 250, 192, 86, 20, 250, 217, 86, 20, 250, 242, 86, 20, 250, 267, 86, 20, 250, 292,
			86, 20, 250, 317, 86, 20, 250, 342, 86, 20 };
	public int accountant_textfields_number = 17;
	public JTextField[] accountant_textfields = new JTextField[accountant_textfields_number];
	public String accountant_textfields_name[] = { "textField_area", "textField_normativ", "textField_v_cold_water",
			"textField_v_hot_water", "textField_v_svet", "textfield_v_gas", "textfield_dolg", "textfield_pereplata",
			"textfield_sumcoldwater", "textfield_sumhotwater", "textField_sumgas", "textField_sumsvet",
			"textField_itog", "textfield_tarrif_cold_water", "textfield_tarrif_hot water", "textField_tarrif_svet",
			"textfield_tarrif_gas" };
	public int accountant_textfields_size[] = { 270, 25, 86, 20, 250, 67, 86, 20, 250, 92, 86, 20, 250, 117, 86, 20,
			250, 142, 86, 20, 250, 167, 86, 20, 250, 192, 86, 20, 250, 217, 86, 20, 250, 242, 86, 20, 250, 267, 86, 20,
			250, 292, 86, 20, 600, 73, 86, 20, 600, 98, 86, 20, 600, 123, 86, 20, 600, 148, 86, 20, 250, 317, 86, 20,
			250, 342, 86, 20 };
	public int labels_number = 14;
	public JLabel[] labels = new JLabel[labels_number];
	public String labels_text[] = { "Тип жилья:", "Итог:", "Отапливаемая площадь=", "Норматив отопления:",
			"Объем потраченной холодной воды:", "Объем потраченной горячей воды:", "Объем потраченного света:",
			"Объем потраченного газа:", "Долг за прошлый месяц:", "Переплата:", "Подсчет холодной воды:",
			"Подсчет горячей воды:", "Подсчет газа:", "Подсчет света:" };
	public int labels_size[] = { 10, 11, 150, 14, 10, 348, 270, 14, 120, 25, 270, 23, 10, 73, 270, 14, 10, 98, 270, 14,
			10, 123, 270, 14, 10, 148, 270, 14, 10, 173, 270, 14, 10, 198, 270, 14, 10, 223, 270, 14, 10, 248, 270, 14,
			10, 273, 270, 14, 10, 298, 270, 14, 10, 323, 270, 14 };
	public int accountant_labels_number = 4;
	public JLabel[] accountant_labels = new JLabel[accountant_labels_number];
	public String accountant_labels_text[] = { "Тариф на холодную воду:", "Тариф на горячую воду:", "Тариф на свет:",
			"Тариф на газ:", };
	public int accountant_labels_size[] = { 400, 73, 270, 14, 400, 98, 270, 14, 400, 123, 270, 14, 400, 148, 270, 14 };

	public Main_Panel() {
		getContentPane().setLayout(new CardLayout());
		panel = new JPanel();
		panel.setLayout(null);
		buttons_add(buttons_name, buttons_text, buttons_size, panel);
		labels_add(labels_number, labels_text, labels_size, panel);
		radiobuttons_add(radiobuttons_name, radiobuttons_text, radiobuttons_size, panel);
		radiobuttons[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radiobuttons[0].isSelected()) {
					radiobuttons[1].setSelected(false);
				}
			}
		});
		radiobuttons[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radiobuttons[1].isSelected()) {
					radiobuttons[0].setSelected(false);
				}
			}
		});
	}

	public void radiobuttons_add(String radiobuttons_name[], String radiobuttons_text[], int radiobuttons_size[],
			JPanel panel) {
		for (int i = 0; i < radiobuttons_number; i++) {
			radiobuttons[i] = new JRadioButton();
			radiobuttons[i].setText(radiobuttons_text[i]);
			radiobuttons[i].setName(radiobuttons_name[i]);
			radiobuttons[i].setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
			radiobuttons[i].setBounds(radiobuttons_size[i * 4], radiobuttons_size[i * 4 + 1],
					radiobuttons_size[i * 4 + 2], radiobuttons_size[i * 4 + 3]);
			panel.add(radiobuttons[i]);
		}
	}

	public void textfields_add(int user_textfields_number, String user_textfields_name[], int user_textfields_size[],
			JPanel panel) {
		for (int i = 0; i < user_textfields_number; i++) {
			user_textfields[i] = new JTextField();
			user_textfields[i].setText("0");
			user_textfields[i].setName(user_textfields_name[i]);
			user_textfields[i].setBounds(user_textfields_size[i * 4], user_textfields_size[i * 4 + 1],
					user_textfields_size[i * 4 + 2], user_textfields_size[i * 4 + 3]);
			panel.add(user_textfields[i]);
		}
	}

	public void labels_add(int labels_number, String labels_text[], int labels_size[], JPanel panel) {
		for (int i = 0; i < labels_number; i++) {
			labels[i] = new JLabel();
			labels[i].setText(labels_text[i]);
			labels[i].setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
			labels[i].setBounds(labels_size[i * 4], labels_size[i * 4 + 1], labels_size[i * 4 + 2],
					labels_size[i * 4 + 3]);
			panel.add(labels[i]);
		}
	}

	public void buttons_add(String buttons_name[], String buttons_text[], int buttons_size[], JPanel panel) {
		for (int i = 0; i < buttons_number; i++) {
			buttons[i] = new JButton();
			buttons[i].setName(buttons_name[i]);
			buttons[i].setText(buttons_text[i]);
			buttons[i].setBounds(buttons_size[i * 4], buttons_size[i * 4 + 1], buttons_size[i * 4 + 2],
					buttons_size[i * 4 + 3]);
			buttons[i].setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
			panel.add(buttons[i]);
		}
	}

	public void killFrame() {
		this.dispose();
	}

	abstract public void makeCalc();
}