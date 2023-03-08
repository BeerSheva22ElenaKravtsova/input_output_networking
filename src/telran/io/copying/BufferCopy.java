package telran.io.copying;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferCopy extends Copy {
	private static final int BUFFER_SIZE = 1_000_000;
	long bufferSize;
	
	public static void main(String[] args) {
	}

	public BufferCopy(String srcFilePath, String destFilePath, boolean overwrite, long bufferSize) {
		super(srcFilePath, destFilePath, overwrite);
		this.bufferSize = bufferSize;
	}

	public BufferCopy(String srcFilePath, String destFilePath, boolean overwrite) {
		super(srcFilePath, destFilePath, overwrite);
		this.bufferSize = BUFFER_SIZE;
	}

	public BufferCopy(String srcFilePath, String destFilePath) {
		super(srcFilePath, destFilePath);
		this.bufferSize = BUFFER_SIZE;
	}

	public void setBufferSize(long bufferSize) {
		this.bufferSize = bufferSize;
	}

	public long getBufferSize() {
		return bufferSize;
	}

	public long copy() {
		long sizeDestFile = 0;
		try (FileInputStream fileInputStream = new FileInputStream(srcFilePath);
				FileOutputStream fileOutputStream = new FileOutputStream(destFilePath)) {
			int sizeSrcFile = fileInputStream.available();
			byte[] buffer = new byte[(int) bufferSize];
			while ((sizeSrcFile != sizeDestFile)) {
				sizeDestFile += fileInputStream.read(buffer);
				fileOutputStream.write(buffer);
				if ((sizeSrcFile - sizeDestFile) < buffer.length) {
					buffer = new byte[(int) (sizeSrcFile - sizeDestFile)];
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sizeDestFile;
	}

	@Override
	public DisplayResult getDisplayResult(long copyTime, long fileSize) {
		return new DisplayResultBuffer(copyTime, fileSize, bufferSize);
	}
}
