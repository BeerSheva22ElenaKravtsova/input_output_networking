package telran.util;

import java.io.PrintStream;

public class SimpleStreamHandler implements Handler {
	PrintStream stream;

	public SimpleStreamHandler(PrintStream stream) {
		this.stream = stream;
	}

	@Override
	public void publish(LoggerRecord loggerRecord) {
		stream.printf("%s%s%s%s%s\n", "timestamp: " + loggerRecord.getTimestamp(),
				", getZoneId: " + loggerRecord.getZoneId(), ", level: " + loggerRecord.getLevel(),
				", loggerName: " + loggerRecord.getLoggerName(), ", message : " + loggerRecord.getMessage());
	}
}
