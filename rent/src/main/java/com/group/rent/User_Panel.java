/**
 * Указываем, в каком пакете находится класс 
 */
package com.group.rent;

import java.awt.*;
import java.awt.event.*;
import com.group.rent.Main_Panel;
import com.group.rent.Authorization_Panel;
import com.group.rent.Calc;

public class User_Panel extends Main_Panel {
	public User_Panel() {
		getContentPane().add(panel, "User");
		textfields_add(user_textfields_number, user_textfields_name, user_textfields_size, panel);
		Text_Field_Filter filter = new Text_Field_Filter();
		for (int i = 0; i < 13; i++) {
			if (i < 8) {
				filter.filterField(user_textfields[i], 7);
			} else {
				user_textfields[i].setEditable(false);
			}
		}
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

	public void makeCalc() {
		if (radiobuttons[0].isSelected()) {
			switchKey = 1;
		} else if (radiobuttons[1].isSelected()) {
			switchKey = 2;
		}
		Calc a = new Calc(Double.valueOf(user_textfields[0].getText()), Double.valueOf(user_textfields[1].getText()),
				Double.valueOf(user_textfields[2].getText()), Double.valueOf(user_textfields[3].getText()),
				Double.valueOf(user_textfields[4].getText()), Double.valueOf(user_textfields[5].getText()),
				Double.valueOf(user_textfields[6].getText()), Double.valueOf(user_textfields[7].getText()), switchKey,
				TARIF_HOT_WATER, TARIF_COLD_WATER, TARIF_GAS, TARIF_SVET);
		a.Calculate();
		user_textfields[8].setText(String.valueOf(a.getsumcoldwater()));
		user_textfields[9].setText(String.valueOf(a.getsumhotwater()));
		user_textfields[10].setText(String.valueOf(a.getsumgas()));
		user_textfields[11].setText(String.valueOf(a.getsumsvet()));
		user_textfields[12].setText(String.valueOf(a.getitog()));
	}
}