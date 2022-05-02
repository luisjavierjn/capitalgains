package com.nubank.capitalgains;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import com.nubank.capitalgains.business.TaxService;
import com.nubank.capitalgains.exceptions.ReadLineException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CapitalgainsApplication.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CapitalgainsApplicationTests {
	private static final String EXAMPLE_INPUT = "example_input.data";
	private static final String EXAMPLE_OUTPUT = "example_output.data";
	private StringBuilder exampleOutput;

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
	public void testExampleInputValidation() {
		// get Logback Logger
		Logger logger = (Logger) LoggerFactory.getLogger(CapitalgainsApplication.class);

		// create and start a ListAppender
		ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
		listAppender.start();

		// add the appender to the logger
		// addAppender is outdated now
		logger.addAppender(listAppender);

		// call method under test
		CapitalgainsApplication.main(new String[] {"src/test/resources/" + EXAMPLE_INPUT});

		// JUnit assertions
		logger.detachAndStopAllAppenders();
		List<ILoggingEvent> logsList = listAppender.list;
		assertEquals(logsList.get(logsList.size()-1).getMessage(),exampleOutput.toString());
	}
}
