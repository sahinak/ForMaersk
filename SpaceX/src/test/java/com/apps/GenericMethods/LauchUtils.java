package com.apps.GenericMethods;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import com.apps.base.TestBase;
import com.space.testDefs.ServiceBoard;


public class LauchUtils extends TestBase {
	private Map<String, String> responseFromApiGet = new HashMap<>();
	
	private ServiceBoard sChannel = new ServiceBoard();
	
	public String listID="";


	public boolean verifyGetLatestLaunches( Map<String, String> responseFromAPI)
			throws UnsupportedEncodingException {
		boolean verified = false;
		
		
		JSONObject response_json = new JSONObject(responseFromAPI.get("response"));
		String launchId = response_json.getString("id");
		responseFromApiGet = sChannel.GetOneLaunch(launchId);
		

		Assert.assertEquals("200", responseFromApiGet.get("status"), "Response code for Get Call doesn't match");
		printResponse(Thread.currentThread().getStackTrace()[1].getMethodName(), responseFromApiGet.get("response"));
		
		Assert.assertEquals(launchId,response_json.getString("id"));
		
	
		
		  
		 
    
		verified = true;
		return verified;

	}

	/*
	 * public boolean verifyCreateCard( Map<String, String> responseFromAPI) throws
	 * UnsupportedEncodingException { boolean verified = false;
	 * 
	 * 
	 * JSONObject response_json = new JSONObject(responseFromAPI.get("response"));
	 * String cardId = response_json.getString("id"); responseFromApiGet =
	 * sChannel.getCardDetails(cardId,listID);
	 * 
	 * Assert.assertEquals("200", responseFromApiGet.get("status"),
	 * "Response code for Get Call doesn't match");
	 * printResponse(Thread.currentThread().getStackTrace()[1].getMethodName(),
	 * responseFromApiGet.get("response"));
	 * 
	 * Assert.assertEquals(listID,response_json.getString("idList"));
	 * 
	 * 
	 * 
	 * 
	 * 
	 * verified = true; return verified;
	 * 
	 * }
	 * 
	 */
	}











