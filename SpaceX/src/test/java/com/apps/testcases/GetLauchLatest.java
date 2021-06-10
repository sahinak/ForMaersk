package com.apps.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.ITest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.apps.GenericMethods.LauchUtils;
import com.apps.base.TestBase;
import com.space.testDefs.ServiceBoard;

public class GetLauchLatest extends TestBase implements ITest {
	private Map<String, String> responseFromApi = new HashMap<>();
	private ServiceBoard sChannel = new ServiceBoard();
	private LauchUtils cUtils = new LauchUtils();
	
	private String statusCodeActual="200";
	private ArrayList<String> launchIDsArray;
	private ArrayList<String> lauchNameArray;


	



	@BeforeClass
	public void initializePreRequisite() {
		
		launchIDsArray = new ArrayList<String>();
		lauchNameArray = new ArrayList<String>();

	}

	
	@AfterClass
	
	 public void teardown() throws IOException {
	 
	  }
	 

	   @Test
		public void GetLatestlaunches() throws IOException, JSONException {
		
		String STATUS_CODE_EXPECTED ="200";

		responseFromApi = sChannel.GetLatetLaunches();
		statusCodeActual = responseFromApi.get("status");
		printResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), responseFromApi.get("response"));
		Assert.assertEquals(statusCodeActual, STATUS_CODE_EXPECTED, "Status Code does not match");
		if (STATUS_CODE_EXPECTED.equalsIgnoreCase("200")) {
			cUtils.verifyGetLatestLaunches(responseFromApi);
			JSONObject response_json = new JSONObject(responseFromApi.get("response"));
			String lauchId = response_json.getString("id");
			String lauchName = response_json.getString("name");
			Assert.assertEquals(lauchName,"SXM-8");
			launchIDsArray.add(lauchId);
			lauchNameArray.add(lauchName);
			System.out.println("The lauch ID's are"  + launchIDsArray);
			System.out.println("The lauch name are" + lauchName);
		}

	}
	   
	
	  
	 

	@Override
	public String getTestName() {
		// TODO Auto-generated method stub
		return null;
	}




}


























