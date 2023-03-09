package telran.io.copying;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public abstract class Copy {
	String srcFilePath;
	String destFilePath;
	boolean overwrite;

	public Copy(String srcFilePath, String destFilePath, boolean overwrite) {
		this.srcFilePath = srcFilePath;
		this.destFilePath = destFilePath;
		this.overwrite = overwrite;
	}

	public Copy(String srcFilePath, String destFilePath) {
		this.srcFilePath = srcFilePath;
		this.destFilePath = destFilePath;
		this.overwrite = false;
	}

	public String getSrcFilePath() {
		return srcFilePath;
	}

	public String getDestFilePath() {
		return destFilePath;
	}

	public boolean isOverwrite() {
		return overwrite;
	}

	public void setOverwrite(boolean overwrite) {
		this.overwrite = overwrite;
	}

	public void copyRun() throws Exception {
		long startTime = System.currentTimeMillis();
		if (!new File(srcFilePath).exists()) {
			throw new Exception("Source file does not exist");
		}
		if (overwrite == false && new File(destFilePath).exists()) {
			throw new Exception("Destination File cannot be overwritten");
		}
		long fileSize = copy();
		long copyTime = getCopyTime(startTime);
		System.out.println(this.getClass().getName().toString().substring(18) + ":" + getDisplayResult(copyTime, fileSize).toString());
	}

	public long getCopyTime(long startTime) {
		return System.currentTimeMillis() - startTime;
	}

	abstract long copy();

	abstract DisplayResult getDisplayResult(long copyTime, long fileSize);
}
