package telran.io.copying;

public class DisplayResultBuffer extends DisplayResult {
	long bufferSize;

	public DisplayResultBuffer(long copyTime, long fileSize, long bufferSize) {
		super(copyTime, fileSize);
		this.bufferSize = bufferSize;
	}

	@Override
	public String toString() {
		return super.toString() + ", bufferSize=" + bufferSize;
	}
	
	

}
