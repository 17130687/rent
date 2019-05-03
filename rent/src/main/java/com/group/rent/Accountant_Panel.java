/**
 * *Указываем, в каком пакете находится класс 
 */
package com.group.rent;

/** 
 * Импортируем оконную библиотеку графического интерфейса, необходимые для функционирования класса. 
 */
import java.awt.*;
/** 
* Импортируем интерфейсы и классы для того, чтобы иметь дело с различными типами событий, 
* запущенных компонентами AWT. 
*/
import java.awt.event.*;

/** 
* Импортируем все классы из пакета для работы с графическими 
* элементами интерфейса 
*/
import javax.swing.*;
/** 
* Импортируем классы проекта, необходимые для функционирования класса 
*/
import com.group.rent.Main_Panel;
import com.group.rent.Calc;
import com.group.rent.Text_Field_Filter;

/**
 * Создаем класс-потомок, который будет выполнять расчет для администратора; он
 * наследуется от класса-родителя (шаблона квартплатного калькулятора)
 */
public class Accountant_Panel extends Main_Panel {

	/**
	 * Создаем конструктор калькулятора администратора
	 */
	public Accountant_Panel() {
		/**
		 * Обращаемся к панели содержимого апплета и добавляем компонент (панель)
		 */
		getContentPane().add(panel, "Accountant");
		/**
		 * Добавляем текстовые поля для ввода показателей для расчета итоговой
		 * квартплаты; используем для этого переопределенный в данном классе метод
		 * класса-родителя.
		 */
		textfields_add(accountant_textfields_number, accountant_textfields_name, accountant_textfields_size, panel);
		/**
		 * Инициализация текстового фильтратора
		 */
		Text_Field_Filter filter = new Text_Field_Filter();
		for (int i = 0; i < 17; i++) {
			/**
			 * Применение фильтра к текстовым полям
			 */
			if (i < 8 || i > 10 & i <= 14) {
				filter.filterField(accountant_textfields[i], 7);
			} else if (i > 7 && i < 11 || i < 17 && i > 14) {
				/**
				 * Отключение возможности редактирования для полей вывода
				 */
				accountant_textfields[i].setEditable(false);
			}
		}
		/**
		 * Добавляем метки администраторского калькулятора; используем для этого метод
		 * класса-родителя.
		 */
		labels_add(accountant_labels_number, accountant_labels_text, accountant_labels_size, panel);
		/**
		 * Обрабатываем нажатие на кнопку расчета; обращаемся к кнопке по индексу и
		 * переопределяем метод обработки нажатия на данную кнопку;
		 */
		buttons[1].addActionListener(new ActionListener() {
			/**
			 * Аннотация, указывающая на то, что мы собираемся переопределить метод
			 * обработки класса-родителя
			 */
			@Override
			/**
			 * Метод обработки нажатия на кнопку
			 */
			public void actionPerformed(ActionEvent e) {
				/**
				 * Вызываем переопределенный в данном классе метод расчета для администратора
				 */
				makeCalc();
			}
		});
		/**
		 * Обрабатываем нажатие на кнопку выхода; обращаемся к кнопке по индексу и
		 * переопределяем метод обработки нажатия на данную кнопку; открываем стартовую
		 * панель авторизации.
		 */
		buttons[0].addActionListener(new ActionListener() {
			/**
			 * Аннотация, указывающая на то, что мы собираемся переопределить метод
			 * класса-родителя
			 */
			@Override
			/**
			 * Метод обработки нажатия на кнопку
			 */
			public void actionPerformed(ActionEvent e) {
				/**
				 * Создаем экземпляр менеджера компоновки для карточного размещения компонентов
				 */
				CardLayout cl = (CardLayout) getContentPane().getLayout();
				/**
				 * Создаем экземпляр класса авторизации
				 */
				Authorization_Panel af = new Authorization_Panel();
				/**
				 * Добавляем экземпляр класса авторизации, как новую карточку, устанавливаем имя
				 * карточки
				 */

				af.setVisible(true);
				af.setSize(500, 500);
				/**
				 * Указываем менеджеру компоновки, что нужно показать карточку авторизации
				 */
				killFrame();
			}
		});
	}

	/**
	 * Аннотация, указывающая на то, что мы собираемся переопределить метод
	 * класса-родителя
	 */
	@Override
	/**
	 * Переопределяем абстрактный метод класса-родителя, то есть создаем конкретный
	 * метод расчета квартплаты для администратора
	 */
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

	/**
	 * Аннотация, указывающая на то, что мы собираемся переопределить метод
	 * класса-родителя
	 */
	@Override
	/**
	 * Метод для создания текстовых полей их редактирования и добавления на панель
	 */
	public void textfields_add(int accountant_textfields_number, String accountant_textfields_name[],
			int accountant_textfields_size[], JPanel panel) {
		/**
		 * Создаем цикл, в котором обрабатываются элементы массива текстовых полей
		 */
		for (int i = 0; i < accountant_textfields_number; i++) {
			/**
			 * Создаем экземпляр текстового поля
			 */
			accountant_textfields[i] = new JTextField();
			/**
			 * Устанавливаем начальное значение для текстового поля (0)
			 */
			accountant_textfields[i].setText("0");
			/**
			 * Устанавливаем имя для текстового поля
			 */
			accountant_textfields[i].setName(accountant_textfields_name[i]);
			/**
			 * Устанавливаем размеры текстового поля
			 */
			accountant_textfields[i].setBounds(accountant_textfields_size[i * 4], accountant_textfields_size[i * 4 + 1],
					accountant_textfields_size[i * 4 + 2], accountant_textfields_size[i * 4 + 3]);
			/**
			 * Добавляем текстовое поле на панель
			 */
			panel.add(accountant_textfields[i]);
		}
	}
}