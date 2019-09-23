package com.marketlogic.assigment.surveyservice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.marketlogic.assigment.surveyservice.entity.SurveyAggregateEntity;
import com.marketlogic.assigment.surveyservice.entity.SurveyQuestions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class IntegrationTestController {
	
	@LocalServerPort
    int port;
	
	@Before
    public void setUp() {
        RestAssured.port = port;
    } 
	@Test
	public void test_addQuestions() {
		
		SurveyAggregateEntity surveyAggregate = new SurveyAggregateEntity();
		surveyAggregate.setSurveyDesc("F1 Best Driver Survey");
		
		List<SurveyQuestions> surveyQuestionsList = new ArrayList<SurveyQuestions>();
		SurveyQuestions surveyQn1 = new SurveyQuestions();
		surveyQn1.setQuestionid(1l);
		surveyQuestionsList.add(surveyQn1);
		surveyAggregate.setSurveyQuestions(surveyQuestionsList);
		 given().contentType(ContentType.JSON).body(surveyAggregate)
		.when()
        .post("/survey")
        .then()
        .statusCode(201).and().assertThat().body("id", greaterThan(0));
		 
	}
	
	@Test
	public void test_getSurvey() {
		 given()
	      .when().get("/survey/1") 
	      .then().statusCode(200).and().assertThat().body("surveyDesc", equalTo("F1 Best Driver Survey"));;
		
	}
 
}
