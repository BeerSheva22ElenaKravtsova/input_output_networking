package telran.io.test;

import java.io.*;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class InputOutputTest {
	String fileName = "myFile";
	String directoryName = "myDirectory1/myDirectory2";

	private static final String SYMBOL = " ";
	private static final int NUMBER_SYMBOLS_PER_LEVEL = 3;

	@BeforeEach
	void setUp() throws Exception {
		new File(fileName).delete();
		new File(directoryName).delete();
	}

	@Test
	@Disabled
	void testFile() throws IOException {
		File f1 = new File(fileName);
		assertTrue(f1.createNewFile());
		File dir1 = new File(directoryName);
		assertTrue(dir1.mkdirs());
		System.out.println(dir1.getAbsolutePath());
	}

	@Test
	void printDirectoryFileTest() {
		printDirectoryFile("/Users/elena/eclipse-workspace/BS_input_output_networking", 4);
	}

	void printDirectoryFile(String path, int maxLevel) {
		File file = new File(path);
		if (file.exists()) {
			printDirectoryFile(file, maxLevel, 0);
		}
	}

	void printDirectoryFile(File file, int maxLevel, int printingLevel) {
		printing(file, printingLevel);
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			if (maxLevel < 1 || maxLevel > files.length) {
				maxLevel = files.length;
			}
			for (int i = 0; i < maxLevel; i++)
				printDirectoryFile(files[i], maxLevel, printingLevel + NUMBER_SYMBOLS_PER_LEVEL);
		}
	}

	private void printing(File file, int printingLevel) {
		System.out.printf("%s%s\n", SYMBOL.repeat((NUMBER_SYMBOLS_PER_LEVEL) + printingLevel),
				"<" + file.getName().replaceFirst("[.]", "") + ">" + (file.isDirectory() ? " - dir" : " - file"));
	}

	@Test
	@Disabled
	void testFiles() {
		Path path = Path.of(".");
		System.out.println(path.toAbsolutePath().getNameCount());
	}

	@Test
	void printDirectoryFilesTest() throws IOException {
		printDirectoryFiles("/Users/elena/eclipse-workspace/BS_input_output_networking", 1);
	}

	void printDirectoryFiles(String strPath, int maxLevel) throws IOException {
		Path directory = Path.of(strPath);
		if (Files.isDirectory(directory)) {
			directory = directory.toAbsolutePath().normalize();
			int directoryLevel = directory.getNameCount();
			Files.walk(directory, maxLevel).forEach(node -> {
				System.out.printf("%s%s - %s\n", " ".repeat((node.getNameCount() - directoryLevel) * NUMBER_SYMBOLS_PER_LEVEL),
						node.getFileName(), Files.isDirectory(node) ? "dir" : "file");
			});
		}
	}
}
