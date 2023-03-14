package telran.io.test;

import java.io.File;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.Logger;
import telran.util.Logger.Level;
import telran.util.SimpleStreamHandler;

class LoggerTest {
	static final String fileName = "logger.txt";
	File file = new File(fileName);
	Logger logger;

	@BeforeEach
	void setUp() throws Exception {
		file.delete();
		try (PrintStream printStream = new PrintStream(file)) {
			logger = new Logger(new SimpleStreamHandler(printStream), "Logger");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void testLoggerDefaultLevel() throws Exception {
		
		logger.runLogger();
	}

	@Test
	void testLoggerErrorLevel() throws Exception {
		logger.setLevel(Level.ERROR);
		logger.runLogger();
	}

	@Test
	void testLoggerWarnLevel() throws Exception {
		logger.setLevel(Level.WARN);
		logger.runLogger();
	}

	@Test
	void testLoggerInfoLevel() throws Exception {
		logger.setLevel(Level.INFO);
		logger.runLogger();
	}

	@Test
	void testLoggerDebugLevel() throws Exception {
		logger.setLevel(Level.DEBUG);
		logger.runLogger();
	}

	@Test
	void testLoggerTraceLevel() throws Exception {
		logger.setLevel(Level.TRACE);
		logger.runLogger();
	}

}
