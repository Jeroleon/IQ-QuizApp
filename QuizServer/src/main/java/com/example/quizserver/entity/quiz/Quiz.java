package com.example.quizserver.entity.quiz;

import java.util.HashSet;
import java.util.Set;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Quiz {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long qid;
	
	private String title;
	
	private String description;
	
	private String numberOfQuestions;
	
	private String maxMarks;
	
	private boolean active=false;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Category category;
	
	@OneToMany(mappedBy="quiz",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JsonIgnore
	private Set<Question> question=new HashSet<>();

	public Long getQid() {
		return qid;
	}

	public void setQid(Long qid) {
		this.qid = qid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNumberOfQuestions() {
		return numberOfQuestions;
	}

	public void setNumberOfQuestions(String numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}

	public String getMaxMarks() {
		return maxMarks;
	}

	public void setMaxMarks(String maxMarks) {
		this.maxMarks = maxMarks;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Question> getQuestion() {
		return question;
	}

	public void setQuestion(Set<Question> question) {
		this.question = question;
	}

	public Quiz() {
	}

	public Quiz(Long qid, String title, String description, String numberOfQuestions, String maxMarks, boolean active,
			Category category, Set<Question> question) {
		super();
		this.qid = qid;
		this.title = title;
		this.description = description;
		this.numberOfQuestions = numberOfQuestions;
		this.maxMarks = maxMarks;
		this.active = active;
		this.category = category;
		this.question = question;
	}
	
	
	
	

}