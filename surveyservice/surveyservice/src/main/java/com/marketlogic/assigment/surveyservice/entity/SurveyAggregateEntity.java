package com.marketlogic.assigment.surveyservice.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SURVEY")
public class SurveyAggregateEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String surveyDesc;
	
	@OneToMany(cascade=CascadeType.ALL)
	List<SurveyQuestions> surveyQuestions; 
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSurveyDesc() {
		return surveyDesc;
	}
	public void setSurveyDesc(String surveyDesc) {
		this.surveyDesc = surveyDesc;
	}
	public List<SurveyQuestions> getSurveyQuestions() {
		return surveyQuestions;
	}
	public void setSurveyQuestions(List<SurveyQuestions> surveyQuestions) {
		this.surveyQuestions = surveyQuestions;
	}
	
	
	
	
	
	
	
	
	
	

}
