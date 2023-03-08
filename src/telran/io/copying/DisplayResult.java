package telran.io.copying;

public class DisplayResult {
	long copyTime;
	long fileSize;
	
	public DisplayResult(long copyTime, long fileSize) {
		this.copyTime = copyTime;
		this.fileSize = fileSize;
	}

	@Override
	public String toString() {
		return  " copyTime = " + copyTime + ", fileSize = " + fileSize;
	}
}
