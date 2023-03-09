package telran.io.copying;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FilesCopy extends Copy {
	
	public static void main(String[] args) {

	}

	public FilesCopy(String srcFilePath, String destFilePath, boolean overwrite) {
		super(srcFilePath, destFilePath, overwrite);
	}

	public FilesCopy(String srcFilePath, String destFilePath) {
		super(srcFilePath, destFilePath);
	}

	public long copy() {
		try {
			Files.copy(Path.of(srcFilePath), Path.of(destFilePath), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Path.of(destFilePath).toFile().length();
	}

	@Override
	public DisplayResult getDisplayResult(long copyTime, long fileSize) {
		return new DisplayResult(getCopyTime(copyTime), fileSize);
	}
}
