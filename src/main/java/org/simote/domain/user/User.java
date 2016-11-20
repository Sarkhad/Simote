package org.simote.domain.user;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.simote.domain.content.Award;
import org.simote.domain.content.Creative;

@Entity
@Table( name = "user" )
public class User {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int id;
					
	@Column( unique = true , nullable = false )
	private String email;
	
	@Column( unique = true, nullable = false )
	private String nickname;
	
	@Column( name = "first_name", unique = false, nullable = false )
	private String firstName = "Anonym";
	
	@Column( name = "last_name", unique = false, nullable = false )
	private String lastName = "Anonymous";
	
	@Column( unique = false, nullable = false ) 
	private String password;
	
	@Column
	private boolean banned = false;
	
    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
	
	@OneToOne
	@JoinColumn(name="settings_id", unique = true, nullable = false)
	private UserSettings settings;
	
	@Column
	private Date registered;
	
	@OneToMany( fetch = FetchType.EAGER, mappedBy = "user" )
	private Set<Award> awards;
	
	@OneToMany( fetch = FetchType.LAZY, mappedBy = "author" )
	private Set<Creative> creatives;
	
	public void setId( int id ) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setEmail( String email ) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}

	public void setNickname( String nickname ) {
		this.nickname = nickname;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setFirstName( String firstName ) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName( String lastName ) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setPassword( String password ) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void ban( boolean banned ) {
		this.banned = banned;
	}
	
	public boolean isBanned() {
		return banned;
	}
	
	
	public void setRoles( Set<Role> roles ) {
		this.roles = roles;
	}
		

    public Set<Role> getRoles() {
        return roles;
    }
	
	public void setUserSettings( UserSettings settings ) {
		this.settings = settings;
	}
	
	public UserSettings getUserSettings() {
		return settings;
	}
	
	public void setRegistrationDate( Date registered ) {
		this.registered = registered;
	}
	
	public Date getRegistrationDate() {
		return registered;
	}
	
	public void setAwards( Set<Award> awards ) {
		this.awards = awards;
	}
	
	public Set<Award> getAwards() {
		return awards;
	}
	
	public void setCreatives( Set<Creative> creatives ) {
		this.creatives = creatives;
	}
	
	public Set<Creative> getCreatives() {
		return creatives;
	}
	
}
