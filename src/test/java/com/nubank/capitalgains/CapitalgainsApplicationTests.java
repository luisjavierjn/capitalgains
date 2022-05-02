package com.nubank.capitalgains;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
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
	private static final String EXAMPLE_INPUT = "example_input.txt";
	private static final String EXAMPLE_OUTPUT = "example_output.txt";
	private static final String CASE1_INPUT = "case1_input.txt";
	private static final String CASE1_OUTPUT = "case1_output.txt";
	private static final String CASE2_INPUT = "case2_input.txt";
	private static final String CASE2_OUTPUT = "case2_output.txt";
	private static final String CASE1AND2_INPUT = "case1and2_input.txt";
	private static final String CASE1AND2_OUTPUT = "case1and2_output.txt";
	private static final String CASE3_INPUT = "case3_input.txt";
	private static final String CASE3_OUTPUT = "case3_output.txt";
	private static final String CASE4_INPUT = "case4_input.txt";
	private static final String CASE4_OUTPUT = "case4_output.txt";
	private static final String CASE5_INPUT = "case5_input.txt";
	private static final String CASE5_OUTPUT = "case5_output.txt";
	private static final String CASE6_INPUT = "case6_input.txt";
	private static final String CASE6_OUTPUT = "case6_output.txt";
	private static final String CASE7_INPUT = "case7_input.txt";
	private static final String CASE7_OUTPUT = "case7_output.txt";
	private static final String CASE8_INPUT = "case8_input.txt";
	private static final String CASE8_OUTPUT = "case8_output.txt";
	private StringBuilder exampleOutput;
	private StringBuilder case1Output;
	private StringBuilder case2Output;
	private StringBuilder case1and2Output;
	private StringBuilder case3Output;
	private StringBuilder case4Output;
	private StringBuilder case5Output;
	private StringBuilder case6Output;
	private StringBuilder case7Output;
	private StringBuilder case8Output;

	private StringBuilder loadJsonFile(String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();
		StringBuilder stringBuilder = new StringBuilder();
		try (InputStream inputStream = classLoader.getResourceAsStream(fileName)) {
			assert inputStream != null;
			try (InputStreamReader streamReader =
						 new InputStreamReader(inputStream, StandardCharsets.UTF_8);
				 BufferedReader reader = new BufferedReader(streamReader)) {

				String line;
				while ((line = reader.readLine()) != null) {
					stringBuilder.append(line).append("\n");
				}
			}
		} catch (IOException e) {
			throw new ReadLineException("BufferedReader failed while reading line!",e);
		}
		return stringBuilder;
	}

	@BeforeAll
	void contextLoads() {
		exampleOutput = loadJsonFile(EXAMPLE_OUTPUT);
		case1Output = loadJsonFile(CASE1_OUTPUT);
		case2Output = loadJsonFile(CASE2_OUTPUT);
		case1and2Output = loadJsonFile(CASE1AND2_OUTPUT);
		case3Output = loadJsonFile(CASE3_OUTPUT);
		case4Output = loadJsonFile(CASE4_OUTPUT);
		case5Output = loadJsonFile(CASE5_OUTPUT);
		case6Output = loadJsonFile(CASE6_OUTPUT);
		case7Output = loadJsonFile(CASE7_OUTPUT);
		case8Output = loadJsonFile(CASE8_OUTPUT);
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

	@Test
	public void testCase1() {
		// get Logback Logger
		Logger logger = (Logger) LoggerFactory.getLogger(CapitalgainsApplication.class);

		// create and start a ListAppender
		ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
		listAppender.start();

		// add the appender to the logger
		// addAppender is outdated now
		logger.addAppender(listAppender);

		// call method under test
		CapitalgainsApplication.main(new String[] {"src/test/resources/" + CASE1_INPUT});

		// JUnit assertions
		logger.detachAndStopAllAppenders();
		List<ILoggingEvent> logsList = listAppender.list;
		assertEquals(logsList.get(logsList.size()-1).getMessage(),case1Output.toString());
	}

	@Test
	public void testCase2() {
		// get Logback Logger
		Logger logger = (Logger) LoggerFactory.getLogger(CapitalgainsApplication.class);

		// create and start a ListAppender
		ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
		listAppender.start();

		// add the appender to the logger
		// addAppender is outdated now
		logger.addAppender(listAppender);

		// call method under test
		CapitalgainsApplication.main(new String[] {"src/test/resources/" + CASE2_INPUT});

		// JUnit assertions
		logger.detachAndStopAllAppenders();
		List<ILoggingEvent> logsList = listAppender.list;
		assertEquals(logsList.get(logsList.size()-1).getMessage(),case2Output.toString());
	}

	@Test
	public void testCase1and2() {
		// get Logback Logger
		Logger logger = (Logger) LoggerFactory.getLogger(CapitalgainsApplication.class);

		// create and start a ListAppender
		ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
		listAppender.start();

		// add the appender to the logger
		// addAppender is outdated now
		logger.addAppender(listAppender);

		// call method under test
		CapitalgainsApplication.main(new String[] {"src/test/resources/" + CASE1AND2_INPUT});

		// JUnit assertions
		logger.detachAndStopAllAppenders();
		List<ILoggingEvent> logsList = listAppender.list;
		assertEquals(logsList.get(logsList.size()-1).getMessage(),case1and2Output.toString());
	}

	@Test
	public void testCase3() {
		// get Logback Logger
		Logger logger = (Logger) LoggerFactory.getLogger(CapitalgainsApplication.class);

		// create and start a ListAppender
		ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
		listAppender.start();

		// add the appender to the logger
		// addAppender is outdated now
		logger.addAppender(listAppender);

		// call method under test
		CapitalgainsApplication.main(new String[] {"src/test/resources/" + CASE3_INPUT});

		// JUnit assertions
		logger.detachAndStopAllAppenders();
		List<ILoggingEvent> logsList = listAppender.list;
		assertEquals(logsList.get(logsList.size()-1).getMessage(),case3Output.toString());
	}

	@Test
	public void testCase4() {
		// get Logback Logger
		Logger logger = (Logger) LoggerFactory.getLogger(CapitalgainsApplication.class);

		// create and start a ListAppender
		ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
		listAppender.start();

		// add the appender to the logger
		// addAppender is outdated now
		logger.addAppender(listAppender);

		// call method under test
		CapitalgainsApplication.main(new String[] {"src/test/resources/" + CASE4_INPUT});

		// JUnit assertions
		logger.detachAndStopAllAppenders();
		List<ILoggingEvent> logsList = listAppender.list;
		assertEquals(logsList.get(logsList.size()-1).getMessage(),case4Output.toString());
	}

	@Test
	public void testCase5() {
		// get Logback Logger
		Logger logger = (Logger) LoggerFactory.getLogger(CapitalgainsApplication.class);

		// create and start a ListAppender
		ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
		listAppender.start();

		// add the appender to the logger
		// addAppender is outdated now
		logger.addAppender(listAppender);

		// call method under test
		CapitalgainsApplication.main(new String[] {"src/test/resources/" + CASE5_INPUT});

		// JUnit assertions
		logger.detachAndStopAllAppenders();
		List<ILoggingEvent> logsList = listAppender.list;
		assertEquals(logsList.get(logsList.size()-1).getMessage(),case5Output.toString());
	}

	@Test
	public void testCase6() {
		// get Logback Logger
		Logger logger = (Logger) LoggerFactory.getLogger(CapitalgainsApplication.class);

		// create and start a ListAppender
		ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
		listAppender.start();

		// add the appender to the logger
		// addAppender is outdated now
		logger.addAppender(listAppender);

		// call method under test
		CapitalgainsApplication.main(new String[] {"src/test/resources/" + CASE6_INPUT});

		// JUnit assertions
		logger.detachAndStopAllAppenders();
		List<ILoggingEvent> logsList = listAppender.list;
		assertEquals(logsList.get(logsList.size()-1).getMessage(),case6Output.toString());
	}

	@Test
	public void testCase7() {
		// get Logback Logger
		Logger logger = (Logger) LoggerFactory.getLogger(CapitalgainsApplication.class);

		// create and start a ListAppender
		ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
		listAppender.start();

		// add the appender to the logger
		// addAppender is outdated now
		logger.addAppender(listAppender);

		// call method under test
		CapitalgainsApplication.main(new String[] {"src/test/resources/" + CASE7_INPUT});

		// JUnit assertions
		logger.detachAndStopAllAppenders();
		List<ILoggingEvent> logsList = listAppender.list;
		assertEquals(logsList.get(logsList.size()-1).getMessage(),case7Output.toString());
	}

	@Test
	public void testCase8() {
		// get Logback Logger
		Logger logger = (Logger) LoggerFactory.getLogger(CapitalgainsApplication.class);

		// create and start a ListAppender
		ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
		listAppender.start();

		// add the appender to the logger
		// addAppender is outdated now
		logger.addAppender(listAppender);

		// call method under test
		CapitalgainsApplication.main(new String[] {"src/test/resources/" + CASE8_INPUT});

		// JUnit assertions
		logger.detachAndStopAllAppenders();
		List<ILoggingEvent> logsList = listAppender.list;
		assertEquals(logsList.get(logsList.size()-1).getMessage(),case8Output.toString());
	}
}
