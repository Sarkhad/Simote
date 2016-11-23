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
	private float rating = 0;
	
	@Column
	private int viewed = 0; 

	@ManyToMany( cascade = CascadeType.ALL )
	@JoinTable(name="creative_tag",
	        joinColumns = @JoinColumn(name="creative_id", referencedColumnName="id"),
	        inverseJoinColumns = @JoinColumn(name="tag_id", referencedColumnName="id")
	)
	private Set<Tag> tags;

	
	@OneToMany( fetch = FetchType.EAGER, mappedBy = "parentCreative", cascade = CascadeType.ALL )
	private Set<Chapter> chapters;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public User getAuthor() {
		return author;
	}


	public void setAuthor(User author) {
		this.author = author;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getCreated() {
		return created;
	}


	public void setCreated(Date created) {
		this.created = created;
	}


	public Date getEdited() {
		return edited;
	}


	public void setEdited(Date edited) {
		this.edited = edited;
	}


	public float getRating() {
		return rating;
	}


	public void setRating(float rating) {
		this.rating = rating;
	}


	public int getViewed() {
		return viewed;
	}


	public void setViewed(int viewed) {
		this.viewed = viewed;
	}


	public Set<Tag> getTags() {
		return tags;
	}


	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}


	public Set<Chapter> getChapters() {
		return chapters;
	}


	public void setChapters(Set<Chapter> chapters) {
		this.chapters = chapters;
	}
	
}
