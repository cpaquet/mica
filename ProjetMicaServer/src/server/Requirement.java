package server;

import java.util.UUID;

public class Requirement {

	private UUID id;
	private String description;
	
	public Requirement(String description, UUID id) {
		super();
		this.description = description;
		this.id =id;
	}
	
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
	
}
