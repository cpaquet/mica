package server;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class RequirementsFileHandler {
	private Document document;
	private static String FILENAME = "./requirements_save.xml";
	static Element root = new Element("requirements");
	
	public RequirementsFileHandler() {	
		makeBuilder();	     
	    this.root = document.getRootElement();
	}
	
	private void makeBuilder() {
		SAXBuilder sxb = new SAXBuilder();
		try {
			document = sxb.build(new File(FILENAME));
		} 
		catch (JDOMException e) {} 
		catch (IOException e) {
			document = new Document(root);
    		this.saveFile();		
		}
	}
	
	protected void saveFile() {	
	   try
	   {
	      XMLOutputter xmlOutput = new XMLOutputter(Format.getPrettyFormat());
	      xmlOutput.output(document, new FileOutputStream(FILENAME));
	   }
	   catch (java.io.IOException e){}
	}

}
