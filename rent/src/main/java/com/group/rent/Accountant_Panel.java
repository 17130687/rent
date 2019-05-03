package com.group.rent;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.group.rent.Main_Panel;
import com.group.rent.Calc;
import com.group.rent.Text_Field_Filter;

public class Accountant_Panel extends Main_Panel {
	public Accountant_Panel() {
		getContentPane().add(panel, "Accountant");
		textfields_add(accountant_textfields_number, accountant_textfields_name, accountant_textfields_size, panel);
		Text_Field_Filter filter = new Text_Field_Filter();
		for (int i = 0; i < 17; i++) {
			if (i < 8 || i > 10 & i <= 14) {
				filter.filterField(accountant_textfields[i], 7);
			} else if (i > 7 && i < 11 || i < 17 && i > 14) {
				accountant_textfields[i].setEditable(false);
			}
		}
		labels_add(accountant_labels_number, accountant_labels_text, accountant_labels_size, panel);
		buttons[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				makeCalc();
			}
		});
		buttons[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) getContentPane().getLayout();
				Authorization_Panel af = new Authorization_Panel();
				af.setVisible(true);
				af.setSize(500, 500);
				killFrame();
			}
		});
	}

	@Override
	public void makeCalc() {
		if (radiobuttons[0].isSelected()) {
			switchKey = 1;
		} else if (radiobuttons[1].isSelected()) {
			switchKey = 2;
		}
		Calc a = new Calc(Double.valueOf(accountant_textfields[0].getText()),
				Double.valueOf(accountant_textfields[1].getText()), Double.valueOf(accountant_textfields[2].getText()),
				Double.valueOf(accountant_textfields[3].getText()), Double.valueOf(accountant_textfields[4].getText()),
				Double.valueOf(accountant_textfields[5].getText()), Double.valueOf(accountant_textfields[6].getText()),
				Double.valueOf(accountant_textfields[7].getText()), switchKey,
				Double.valueOf(accountant_textfields[12].getText()),
				Double.valueOf(accountant_textfields[11].getText()),
				Double.valueOf(accountant_textfields[14].getText()),
				Double.valueOf(accountant_textfields[13].getText()));
		a.Calculate();
		accountant_textfields[8].setText(String.valueOf(a.getsumcoldwater()));
		accountant_textfields[9].setText(String.valueOf(a.getsumhotwater()));
		accountant_textfields[10].setText(String.valueOf(a.getsumgas()));
		accountant_textfields[15].setText(String.valueOf(a.getsumsvet()));
		accountant_textfields[16].setText(String.valueOf(a.getitog()));
	}

	@Override
	public void textfields_add(int accountant_textfields_number, String accountant_textfields_name[],
			int accountant_textfields_size[], JPanel panel) {
		for (int i = 0; i < accountant_textfields_number; i++) {
			accountant_textfields[i] = new JTextField();
			accountant_textfields[i].setText("0");
			accountant_textfields[i].setName(accountant_textfields_name[i]);
			accountant_textfields[i].setBounds(accountant_textfields_size[i * 4], accountant_textfields_size[i * 4 + 1],
					accountant_textfields_size[i * 4 + 2], accountant_textfields_size[i * 4 + 3]);
			panel.add(accountant_textfields[i]);
		}
	}
}