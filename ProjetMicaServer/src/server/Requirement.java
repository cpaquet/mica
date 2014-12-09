package server;

import java.util.UUID;

public class Requirement {
	private UUID id;
	private String description;
	
	public Requirement(String description) {
		super();
		this.description = description;
		this.id = UUID.randomUUID();
	}

	public UUID getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}
	
	public String toXml() {
		String xmlRepresentation = "\n<requirement>";
		xmlRepresentation += "\n\t<uuid>" + this.getId().toString() + "</uuid>";
		xmlRepresentation += "\n\t<description>" + this.getDescription() + "</description>";
		return xmlRepresentation + "\n</requirement>";
	}
	
}
