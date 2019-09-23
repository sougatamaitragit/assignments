package com.marketlogic.assigment.surveyservice.serviceimpl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketlogic.assigment.surveyservice.entity.SurveyAggregateEntity;
import com.marketlogic.assigment.surveyservice.exception.ResourceNotFoundException;
import com.marketlogic.assigment.surveyservice.repository.SurveyRepository;
import com.marketlogic.assigment.surveyservice.service.SurveyService;
import com.marketlogic.assigment.surveyservice.util.ServiceUtil;
/**
 * This service class is responsible for interacting with Survey Repository
 * @author Sougata Maitra
 *
 */
@Service
@Transactional
public class ServeyServiceImpl implements SurveyService{
	
	@Autowired
	SurveyRepository surveyRepository; 
	
	public SurveyAggregateEntity store(SurveyAggregateEntity survey) {
		
		return surveyRepository.save(survey);
		
	}
	public SurveyAggregateEntity get(Long id) throws ResourceNotFoundException {
		Optional<SurveyAggregateEntity> surveyAggregateOptional =  surveyRepository.findById(id);
		SurveyAggregateEntity surveyEntity = surveyAggregateOptional.get();
		if(surveyEntity==null) {
			throw new ResourceNotFoundException(ServiceUtil.INVALID_QUESTION_EX_CODE,ServiceUtil.INVALID_QUESTION_DESC);
		}
		return surveyEntity;
	}
	

}
