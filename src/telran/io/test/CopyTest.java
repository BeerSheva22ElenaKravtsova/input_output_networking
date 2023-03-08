package telran.io.test;

import static org.junit.Assert.assertThrows;

import java.nio.file.Files;
import java.nio.file.Path;

import telran.io.copying.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CopyTest {
	static String srcFilePath = "/Users/elena/Downloads/TELRAN 2022 BeerSheva/2. Git (second lesson)/GMT20221020-105805_Recording_1920x1020.mp4";
	static String destFilePath = "/Users/elena/Downloads/TELRAN 2022 BeerSheva/2. Git (second lesson)/GMT20221020-105805_Recording_1920x1020 (Copy).mp4";
	static String[] args = new String[] { srcFilePath, destFilePath };
	
	@BeforeEach
	void setUp() throws Exception {
		Files.deleteIfExists(Path.of(destFilePath));
	}

	@Test
	void testFilesCopy() {
		try {
			FilesCopy filesCoppy = (FilesCopy) FilesCopyBuilder.build("FilesCopy", args);
			filesCoppy.copyRun();
			assertThrows(Exception.class, () -> filesCoppy.copyRun());
			
			filesCoppy.setOverwrite(true);
			filesCoppy.copyRun();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testFransferCopy() {
		try {
			TransferCopy transferCopy = (TransferCopy) FilesCopyBuilder.build("TransferCopy", args);
			transferCopy.copyRun();
			assertThrows(Exception.class, () -> transferCopy.copyRun());
			
			transferCopy.setOverwrite(true);
			transferCopy.copyRun();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testBufferCopy() {
		try {
			BufferCopy bufferCopy = (BufferCopy) FilesCopyBuilder.build("BufferCopy", args);
			bufferCopy.copyRun();

			assertThrows(Exception.class, () -> bufferCopy.copyRun());
			bufferCopy.setOverwrite(true);

			bufferCopy.setBufferSize(104857600);
			bufferCopy.copyRun();

			bufferCopy.setBufferSize(Runtime.getRuntime().totalMemory());
			bufferCopy.copyRun();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
