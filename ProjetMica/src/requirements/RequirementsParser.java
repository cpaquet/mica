package requirements;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class RequirementsParser {
	static org.jdom2.Document document;
	static Element root;

	public ArrayList <Requirement> createRequirementsFromXML(String requirementsXml) {
		ArrayList <Requirement> res = new ArrayList<Requirement>();
		List listEtudiants = null;
		
		initParser(requirementsXml);

		listEtudiants = root.getChildren("requirement");

		Iterator i = listEtudiants.iterator();
		
		while(i.hasNext())
		{
			Requirement currentReq = null;
			String currentDescription = "";
			String currentId = null;
			Element currentNode = null;
			
			currentNode  = (Element)i.next();
			
			currentId = currentNode.getChild("id").getText();
			currentDescription = currentNode.getChild("description").getText();
			currentReq = new Requirement(currentDescription, currentId);
			res.add(currentReq);
		}
		
		return res;
	}

	private void initParser(String requirementsXml) {
		SAXBuilder sxb = new SAXBuilder();
		try
		{
			document = sxb.build(new StringReader(requirementsXml));
		}
		catch(Exception e){
			e.printStackTrace();
		}

		root = document.getRootElement();
	}
}
