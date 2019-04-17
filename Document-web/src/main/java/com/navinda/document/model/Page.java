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
public class Page {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private Section section;
	public Section getSection() {
		return section;
	}
	public void setSection(Section section) {
		this.section = section;
	}
	@OneToMany(cascade = CascadeType.ALL)
	private List<Paragraph> paragraphs;
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
	public List<Paragraph> getParagraphs() {
		return paragraphs;
	}
	public void setParagraphs(List<Paragraph> paragraphs) {
		this.paragraphs = paragraphs;
	}
}
