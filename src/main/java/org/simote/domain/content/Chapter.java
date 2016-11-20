package org.simote.domain.content;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "chapter" )
public class Chapter {

	@Id
	@GeneratedValue
	private int id;
	
	private int chapterOrder;
	
	private String title;
	
	private String content;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL )
	@JoinColumn(name = "creative_id", nullable = false)
	private Creative parentCreative;
	
	public int getOrder() {
		return chapterOrder;
	}

	public void setOrder(int order) {
		this.chapterOrder = order;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public Creative getParentCreative() {
		return parentCreative;
	}

	public void setParentCreative( Creative parentCreative ) {
		this.parentCreative = parentCreative;
	}
	
}
