package server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.jdom2.*;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


public class RequirementReader extends RequirementsFileHandler{
	public String getAllRequirements () {
		XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
		return sortie.outputString(document);
	}

}
