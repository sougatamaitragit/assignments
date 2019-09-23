package com.marketlogic.assigment.surveyservice.service;

import com.marketlogic.assigment.surveyservice.entity.SurveyAggregateEntity;
import com.marketlogic.assigment.surveyservice.exception.ResourceNotFoundException;

public interface SurveyService {
	
	public SurveyAggregateEntity store(SurveyAggregateEntity survey);
	public SurveyAggregateEntity get(Long id) throws ResourceNotFoundException;

}
