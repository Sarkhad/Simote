package org.simote.service;

public enum AwardType {
	
	SUCCESSFUL_REGISTRATION( "award.registration.name" ,"award.registration.codename", "award.registration.description" );
	
	private final String name, codename, description; 
	
	private AwardType( String name, String codename, String description ) {
		this.name = name;
		this.codename = codename;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public String getCodename() {
		return codename;
	}

	public String getDescription() {
		return description;
	}
	
}
