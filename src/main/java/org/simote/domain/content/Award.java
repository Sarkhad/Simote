package org.simote.domain.content;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.simote.domain.user.User;
import org.simote.service.AwardType;
 
@Entity
@Table( name = "award" )
public class Award {

	@Id
	@GeneratedValue
	@Column( name = "award_id" )
	private int id;

    @ManyToMany(mappedBy = "awards", cascade = CascadeType.ALL)
	private Set<User> users;
	
	private String name;
	
	private String codename;
	
	private String description;
	
	private Date awarded;

	public Award() {}
	
	public Award( AwardType type ) {
		name = type.getName();
		codename = type.getCodename();
		description = type.getDescription();
	
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCodename() {
		return codename;
	}

	public void setCodename(String codename) {
		this.codename = codename;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getAwarded() {
		return awarded;
	}

	public void setAwarded(Date awarded) {
		this.awarded = awarded;
	}
	
	
}