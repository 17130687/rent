package com.group.rent;

/**
 * Импортирование класса, содержащего набор методов сравнения
 */
import static org.junit.Assert.*;

public class Test7 {

	@org.junit.Test
	public void test() {
		/**
		 * Входными данными является метод, производящий расчета квартплаты и
		 * предполагаемый результат данного расчета
		 */
		Calc a = new Calc(36, 68, 34, 65, 44, 80, 71, 51, 1, 78, 70, 99, 53);
		a.Calculate();
		/**
		 * Сравнение результата и ожидаемого значения
		 */
		assertEquals(String.valueOf(a.getitog()), "20170.0");
	}
}
