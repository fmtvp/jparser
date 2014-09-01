package javancss;

import java.io.File;

public class Main
{
	public static void main(String[] asArgs) throws Exception
	{
		Javancss pJavancss = new Javancss();
		
		System.out.print("{");
		for(int i = 0; i < asArgs.length; ++i) {
			final String filename = asArgs[i];
			final File file = new File(filename);
			if(file.exists()) {
				final FileMetrics metrics = pJavancss.measure(filename);
				if(metrics != null) {
					System.out.print(metrics.toString());
					if(i < asArgs.length - 1) {
						System.out.print(",");
					}
				} else {
					System.err.println("failed to measure file [" + filename + ']');
				}
			}
		}
		System.out.println("}");
		System.exit(0);
	}
}
