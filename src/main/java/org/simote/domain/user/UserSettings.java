package org.simote.domain.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table( name = "user_settings" )
public class UserSettings {
	
	@Id
	@GeneratedValue
	private int id;
	
	@OneToOne
	@JoinColumn( name = "theme", nullable = false )
	private Theme theme;
	
	@OneToOne
	@JoinColumn( name = "language", nullable = false )
	private Language language;
	
}
