package in.flyspark.dp;

public class ConsoleLogWriter implements LogWriter {

	private ConsoleWriter consoleWriter = new ConsoleWriter();

	public void out(String text) {
		consoleWriter.writeConsole(text);
	}

}
