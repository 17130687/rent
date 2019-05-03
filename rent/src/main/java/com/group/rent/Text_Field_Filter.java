/**Указываем, в каком пакете находится класс 
*/
package com.group.rent;

/**
* Импортирование библиотек, описывающих работу текстовыми полями
*/
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class Text_Field_Filter {
	private static void TextFilter(JTextField TextField, final int length) {
		/**
		 * Создание нового пустого документа
		 */
		TextField.setDocument(new PlainDocument() {
			/**
			 * Задание строки символов, разрешенных для записи в последующее поле
			 */
			String chars = "0123456789.";

			/**
			 * Вставка символов в пустой документ
			 */
			public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
				if (chars.indexOf(str) != -1) {
					if (getLength() < length) {
						super.insertString(offs, str, a);
					}
				}
			}
		});
	}

	/**
	 * Метод для применения фильтра к текстовому полю
	 * 
	 * @param TextField текстовое поле для изменения
	 * @param length    устанавливаемая длинна в текстовом поле
	 */
	public static void filterField(JTextField TextField, final int length) {
		TextFilter(TextField, length);
	}

}
