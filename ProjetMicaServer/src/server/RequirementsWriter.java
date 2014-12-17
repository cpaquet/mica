package server;

import org.jdom2.Element;


public class RequirementsWriter extends RequirementsFileHandler {
		
	public void saveRequirement (Requirement toSave) {
		Element requirement = new Element("requirement");
		root.addContent(requirement);
		
		Element reqId = new Element("id");
		reqId.setText(toSave.getId().toString());
		
		Element description = new Element("description");
		description.setText(toSave.getDescription());
		
		requirement.addContent(reqId);
		requirement.addContent(description);
		
		this.saveFile();      
	}	
	
}