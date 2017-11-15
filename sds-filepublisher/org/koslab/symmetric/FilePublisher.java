package org.koslab.symmetric;

import org.jumpmind.util.Context;
import org.jumpmind.symmetric.integrate.IPublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilePublisher implements IPublisher {

	static final Logger log = LoggerFactory.getLogger(FilePublisher.class);
        private String outputPath = "/tmp/";

	@Override
	public void publish(Context context, String text) {
		String fileName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(
			new java.util.Date());
                fileName = Paths.get(outputPath, fileName + ".xml").toString();
		boolean wrote = false;

		while (wrote == false) {
			try {
				FileWriter fileWriter = new FileWriter(fileName);
				PrintWriter printWriter = new PrintWriter(fileWriter);
				printWriter.print(text);
				printWriter.close();
				wrote = true;
			} catch (IOException exc) {
				wrote = false;
			}
		}
		log.info("Wrote {}", fileName);
	}

	public void setOutputPath(String outputPath) {
		this.outputPath = outputPath;
        } 
}
