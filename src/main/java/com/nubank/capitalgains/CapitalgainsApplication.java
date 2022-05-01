package com.nubank.capitalgains;

import com.nubank.capitalgains.business.TaxService;
import com.nubank.capitalgains.exceptions.InputStreamException;
import com.nubank.capitalgains.utils.FileReaderUtil;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.FileSystemResource;

@SpringBootApplication
public class CapitalgainsApplication implements CommandLineRunner {
	private static final Logger logger = LogManager.getLogger(CapitalgainsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CapitalgainsApplication.class, args);
	}

	@Override
	public void run(String... args) {
		if(args.length > 0) {
			FileSystemResource file = new FileSystemResource(args[0]);
			FileReaderUtil fileReaderUtil;
			try {
				fileReaderUtil = new FileReaderUtil(file.getInputStream());
			} catch (IOException e) {
				throw new InputStreamException("InputStream could not be obtained!",e);
			}
			TaxService taxService = new TaxService(fileReaderUtil);
			logger.info(taxService.process());
		} else {
			logger.error("No parameter found!");
		}
	}
}
