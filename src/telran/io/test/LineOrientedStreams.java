package telran.io.test;

import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class LineOrientedStreams {
	static final String fileNamePrintStream = "lines-stream.txt";
	static final String fileNamePrintWrites = "lines-writer.txt";
	static final String line = "Hello world !!!";
	static final String helloFileName = "lines-writer.txt";
	private static final int N_RECORDS = 1_000_000_00;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@Disabled
	void printStreamTest() throws Exception {
		PrintStream printStream = new PrintStream(fileNamePrintStream);
		IntStream.range(0, N_RECORDS).forEach(printStream::println);
		printStream.println(line);
	}

	@Test
	@Disabled
	void printWriterTest() throws Exception {
		try (PrintWriter printWriter = new PrintWriter(fileNamePrintWrites)) {
			IntStream.range(0, N_RECORDS).forEach(printWriter::println);

			printWriter.println(line);
		}
	}

	@Test
	void bufferedReaderTest() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(helloFileName));

		// Var1
//		while(true) {
//			String nextLine = reader.readLine();
//			if(nextLine == null) {
//				break;
//			}
//			assertEquals(line, nextLine);

		// Var 2
//		reader.lines().forEach(l -> assertEquals(line, l));

		// Var3
		reader.lines().parallel().forEach(l -> assertEquals(line, l));
	}
}