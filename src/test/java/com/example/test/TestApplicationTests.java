package com.example.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest

class TestApplicationTests {

	private final Calculator calculator = new Calculator();

	@Test
	void itShouldAddNumber() {
		//assertEquals(4,calculator.add(1,3));

		// given
		int numberOne = 20;
		int numberTwo = 30;

		//when
		int result = calculator.add(numberOne, numberTwo);

		//then
		int expected = 50;
		//assertThat(result).isEqualTo(expected);
		assertEquals(result,expected);


	}

	public class Calculator{

		public int add(int a, int b) {
			return a + b;
		}
	}




}
