package org.simote.domain.content;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table( name = "tag" )
public class Tag {

	@Id
	@GeneratedValue
	private int id;
	
	@Column( unique = true, nullable = false )
	private String name;
	
	@Column( unique = true, nullable = true )
	private String address;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "tags", cascade = CascadeType.ALL)
	private Set<Creative> creatives;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "tags", cascade = CascadeType.ALL)
	private Set<Chapter> chapters;
	
	public Tag() {}
	
}
