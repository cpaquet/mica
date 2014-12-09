package server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.*;

public class RequirementsWriter {
	private static String FILENAME = "./requirements_save.xml";
	

	public OutputStream openSavingFileIfExists() {
		Path filePath = Paths.get(FILENAME);	
		OutputStream out = null;
		
		try {
			out =  Files.newOutputStream(filePath, CREATE, APPEND);
		} catch (IOException x) {
			System.err.println(x);
		}
		
		return out;
	}
	
	public void saveRequirement (Requirement toSave) {
		Writer writer = null;
		
		try {
		    writer = new BufferedWriter(new OutputStreamWriter(
		    		openSavingFileIfExists(), "utf-8"));
		    writer.write(toSave.toXml());
		} catch (IOException ex) {
		  // report
		} finally {
		   try {
			   writer.close();
		   } catch (Exception ex) {}
		}
	}
}
