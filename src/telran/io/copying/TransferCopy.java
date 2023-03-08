package telran.io.copying;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TransferCopy extends Copy {// for copying big files

	public static void main(String[] args) {

	}

	public TransferCopy(String srcFilePath, String destFilePath, boolean overwrite) {
		super(srcFilePath, destFilePath, overwrite);
	}

	public TransferCopy(String srcFilePath, String destFilePath) {
		super(srcFilePath, destFilePath);
	}

	@Override
	long copy() {
		long res = 0;
		try (FileInputStream inputStream = new FileInputStream(srcFilePath);
				FileOutputStream outputStream = new FileOutputStream(destFilePath, overwrite);) {
			res = inputStream.transferTo(outputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public DisplayResult getDisplayResult(long copyTime, long fileSize) {
		return new DisplayResult(getCopyTime(copyTime), fileSize);
	}
}
