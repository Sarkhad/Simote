package org.simote.domain.content;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.simote.domain.user.User;
 
@Entity
@Table( name = "award" )
public class Award {

	@Id
	@GeneratedValue
	@Column( name = "award_id" )
	private int id;

	@ManyToOne( fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@JoinColumn( name = "user_id", nullable = false )
	private User user;
	
	@Column
	private String name;
	
	@Column
	private String codename;
	
	@Column
	private String description;
	
	@Column
	private Date awarded;
	
	
}