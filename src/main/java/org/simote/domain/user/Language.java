package org.simote.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "language" )
public class Language {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column( unique = true, nullable = false )
	private String name;
	
	@Column( unique = true, nullable = false )
	private String code;
	
	public Language() {}
	
	public int getId() {
		return id;
	}
	
	public void setId( int id ) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName( String name ) {
		this.name = name;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode( String code ) {
		this.code = code;
	}
	
}
