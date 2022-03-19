package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class DemoApplicationTests {
	Calculator underTest = new Calculator();

	@Test
	void itShouldAddNumbers() {
		//given
		int a = 20;
		int b = 30;

		//when
		int res = underTest.add(a, b);

		//then
		int expected = 50;
		assertThat(res).isEqualTo(expected);
	}

	class Calculator{
		int add(int a, int b){
			return a + b;
		}
	}
}
