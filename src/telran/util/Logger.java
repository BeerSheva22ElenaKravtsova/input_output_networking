package telran.util;

import java.time.Instant;
import java.time.ZoneId;

public class Logger {
	public enum Level {
		TRACE, DEBUG, INFO, WARN, ERROR;
	}

	Level level = Level.INFO;
	Handler handler;
	String name;

	public Logger(Handler handler, String name) {
		this.handler = handler;
		this.name = name;
	}

	public void setLevel(Level level) throws Exception {
		this.level = level;
	}

	public Level getLevel() {
		return level;
	}

	void write(String message, Level methodsLevel) {
		if (level.ordinal() <= methodsLevel.ordinal()) {
			handler.publish(new LoggerRecord(Instant.now(), ZoneId.systemDefault().getId(), level, name, message));
		}
	}

	public void error(String message) {
		write(message, Level.ERROR);
	}

	public void warn(String message) {
		write(message, Level.WARN);
	}

	public void info(String message) {
		write(message, Level.INFO);
	}

	public void debug(String message) {
		write(message, Level.DEBUG);
	}

	public void trace(String message) {
		write(message, Level.TRACE);
	}

	public void runLogger() {
		error("Error");
		warn("Warn");
		info("Info");
		debug("Debug");
		trace("Trace");
	}

}
