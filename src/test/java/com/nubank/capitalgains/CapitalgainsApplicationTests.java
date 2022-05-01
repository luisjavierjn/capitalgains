package com.nubank.capitalgains;

import com.nubank.capitalgains.business.TaxService;
import com.nubank.capitalgains.exceptions.ReadLineException;
import com.nubank.capitalgains.model.State;
import com.nubank.capitalgains.utils.FileReaderUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
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
	private static final String EXAMPLE_INPUT = "example_input.data";
	private static final String EXAMPLE_OUTPUT = "example_output.data";
	private StringBuilder exampleOutput;
	private TaxService taxService;

	private StringBuilder loadJsonFile(String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();
		StringBuilder stringBuilder = new StringBuilder();
		try (InputStream inputStream = classLoader.getResourceAsStream(fileName);
			 InputStreamReader streamReader =
					 new InputStreamReader(inputStream, StandardCharsets.UTF_8);
			 BufferedReader reader = new BufferedReader(streamReader)) {

			String line;
			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line).append("\n");
			}
		} catch (IOException e) {
			throw new ReadLineException("BufferedReader failed while reading line!",e);
		}
		return stringBuilder;
	}

	@BeforeAll
	void contextLoads() {
		exampleOutput = loadJsonFile(EXAMPLE_OUTPUT);
	}

	@Test
	public void testExampleBuyValidation() {
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream(EXAMPLE_INPUT);
		FileReaderUtil fileReaderUtil = new FileReaderUtil(inputStream);
		taxService = new TaxService(fileReaderUtil);
		assertEquals(taxService.process(), exampleOutput.toString());
	}
}
