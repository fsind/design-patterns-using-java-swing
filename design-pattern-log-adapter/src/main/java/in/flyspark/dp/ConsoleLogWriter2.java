package in.flyspark.dp;

public class ConsoleLogWriter2 extends ConsoleWriter implements LogWriter {

	public void out(String text) {
		writeConsole(text);
	}

}
