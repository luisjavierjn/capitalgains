package com.nubank.capitalgains;

import com.nubank.capitalgains.business.TaxValidator;
import com.nubank.capitalgains.model.State;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CapitalgainsApplication.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CapitalgainsApplicationTests {
	private State state;
	private TaxValidator taxValidator;

	@BeforeAll
	void contextLoads() {
		state = new State();
		taxValidator = new TaxValidator(state);
	}

	@Test
	public void testBuyValidation() {
		String info = "info";
		taxValidator.validate(info);
		assertEquals(taxValidator.getTaxResult(),"[{\"tax\":0.00}]");
	}
}
