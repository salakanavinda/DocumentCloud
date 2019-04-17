package com.navinda.document.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private Document document;
	@OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    private List<Section> sections;
	
	public Document getDocument() {
		return document;
	}
	public void setDocument(Document document) {
		this.document = document;
	}
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
	public List<Section> getSections() {
		return sections;
	}
	public void setSections(List<Section> sections) {
		this.sections = sections;
	}
}
