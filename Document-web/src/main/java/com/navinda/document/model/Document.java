package com.navinda.document.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Document {
	@Id
	private Integer id;
	private String name;
	@OneToMany(mappedBy = "document",cascade = CascadeType.ALL)
	private List<Card> cards;
	public List<Card> getCards() {
		return cards;
	}
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name="document_publishers",
			joinColumns = @JoinColumn(name="did",referencedColumnName = "id"),
			inverseJoinColumns =  @JoinColumn(name="pid",referencedColumnName = "id")
			)
	private List<Publisher> publishers;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Publisher> getPublishers() {
		return publishers;
	}
	public void setPublishers(List<Publisher> publishers) {
		this.publishers = publishers;
	}

}
