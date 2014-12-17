package requirements;

import java.util.UUID;
public class Requirement {

	private UUID id;
	private String description;
	
	public Requirement(String description, String id) {
		super();
		this.description = description;
		this.id = makeUuid(id);
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
	
	public String toString() {
		return this.getDescription();
	}
	
/*	
 * UUID chez Android != UUID chez Java.
 * OOKKKKKKKKKKKKKKKKK
 * 	http://stackoverflow.com/questions/18871980/uuid-fromstring-returns-an-invalid-uuid
 */
	
	private UUID makeUuid(String uuidString) {
		String[] parts = {
	            uuidString.substring(0, 7),
	            uuidString.substring(9, 12),
	            uuidString.substring(14, 17),
	            uuidString.substring(19, 22),
	            uuidString.substring(24, 35)
	    };
	    long m1 = Long.parseLong(parts[0], 16);
	    long m2 = Long.parseLong(parts[1], 16);
	    long m3 = Long.parseLong(parts[2], 16);
	    long lsb1 = Long.parseLong(parts[3], 16);
	    long lsb2 = Long.parseLong(parts[4], 16);
	    long msb = (m1 << 32) | (m2 << 16) | m3;
	    long lsb = (lsb1 << 48) | lsb2;
	    return new UUID(msb, lsb);
	}
}
