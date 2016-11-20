package org.simote.domain.content;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.simote.domain.user.User;

@Entity
@Table( name = "creative" )
public class Creative {
	
	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne( fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@JoinColumn( name = "author_id", nullable = false )
	private User author;
	
	@Column
	private String name;
	
	@Column
	private Date created;
	
	@Column
	private Date edited;
	
	@Column
	private float rating;
	
	@Column
	private int viewed; 

	@ManyToMany
	@JoinTable(name="creative_tag",
	        joinColumns = @JoinColumn(name="creative_id", referencedColumnName="id"),
	        inverseJoinColumns = @JoinColumn(name="tag_id", referencedColumnName="id")
	)
	private Set<Tag> tags;

	
	@OneToMany( fetch = FetchType.EAGER, mappedBy = "parentCreative" )
	private Set<Chapter> chapters;
	
}
