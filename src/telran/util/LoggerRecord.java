package telran.util;

import java.time.Instant;

import telran.util.Logger.Level;

public class LoggerRecord {
	final Instant timestamp;
	final String zoneId;
	final Level level;
	final String loggerName;
	final String message;

	public LoggerRecord(Instant timestamp, String zoneId, Level level, String loggerName, String message) {
		this.timestamp = timestamp;
		this.zoneId = zoneId;
		this.level = level;
		this.loggerName = loggerName;
		this.message = message;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public String getZoneId() {
		return zoneId;
	}

	public Level getLevel() {
		return level;
	}

	public String getLoggerName() {
		return loggerName;
	}

	public String getMessage() {
		return message;
	}
	
	

}
