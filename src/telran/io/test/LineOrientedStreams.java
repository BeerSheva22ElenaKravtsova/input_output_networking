package telran.io.test;

import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LineOrientedStreams {
	static final String fileNamePrintStream = "lines-stream.txt";
	static final String fileNamePrintWrites = "lines-writer.txt";
	static final String line = "Hello world";
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void printStreamTest() throws Exception{
		PrintStream printStream = new PrintStream(fileNamePrintStream);
		printStream.println(line);
			}

	@Test
	void printWriterTest() throws Exception{
		try (PrintWriter printWriter = new PrintWriter(fileNamePrintWrites)) {
			printWriter.println(line);
		}
	}
}
