package com.space.testDefs;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import com.space.base.ServiceBase;
import com.space.utils.CommonUtils;
import com.space.utils.GenericRESTHandler;
import com.space.utils.TNRESTEndPoints;

public class ServiceBoard extends ServiceBase {
	private Map<String, String> responseFromApi = new HashMap<>();
	private String URI = "";

	public Map<String, String> GetLatetLaunches()
			throws UnsupportedEncodingException {
		URI = CommonUtils.getBaseURI() + TNRESTEndPoints.GET_latest_launches;
		System.out.println("REST END POINT: GET:: " + URI);
		responseFromApi = genRESTHandler.ExecuteAPI(GenericRESTHandler.HTTPMethod.GET, URI, null, null, null);
		return responseFromApi;
	}
	
	public Map<String, String> GetOneLaunch(String launchId)
			throws UnsupportedEncodingException {
		URI = CommonUtils.getBaseURI() + TNRESTEndPoints.GET_One_launch.replace("{launch_id}", launchId);
		System.out.println("REST END POINT: GET:: " + URI);
		responseFromApi = genRESTHandler.ExecuteAPI(GenericRESTHandler.HTTPMethod.GET, URI, null, null, null);
		return responseFromApi;
	}
	
	public Map<String, String> GetAllLaunch()
			throws UnsupportedEncodingException {
		URI = CommonUtils.getBaseURI() + TNRESTEndPoints.GET_All_launch;
		System.out.println("REST END POINT: GET:: " + URI);
		responseFromApi = genRESTHandler.ExecuteAPI(GenericRESTHandler.HTTPMethod.GET, URI, null, null, null);
		return responseFromApi;
	}

	
	 
	/*
	 * public Map<String, String> getBoardDetails(String boardId) throws
	 * UnsupportedEncodingException
	 * 
	 * { URI = CommonUtils.getBaseURI() + TNRESTEndPoints.GET_BOARDS.replace("{ID}",
	 * boardId); System.out.println("REST END POINT: GET:: " + URI); responseFromApi
	 * = genRESTHandler.ExecuteAPI(GenericRESTHandler.HTTPMethod.GET, URI,
	 * null,null, null); return responseFromApi; }
	 * 
	 * public Map<String, String> getCardDetails(String cardId,String listId) throws
	 * UnsupportedEncodingException
	 * 
	 * { URI = CommonUtils.getBaseURI() +
	 * TNRESTEndPoints.GET_CARD.replace("{CARD_ID}", cardId).replace("{LIST_ID}",
	 * listId); System.out.println("REST END POINT: GET:: " + URI); responseFromApi
	 * = genRESTHandler.ExecuteAPI(GenericRESTHandler.HTTPMethod.GET, URI,
	 * null,null, null); return responseFromApi; }
	 * 
	 * public Map<String, String> deleteBoard( String boardId) throws
	 * UnsupportedEncodingException { URI = CommonUtils.getBaseURI() +
	 * TNRESTEndPoints.DELETE_BOARD.replace("{ID}", boardId);
	 * System.out.println("REST END POINT: DELETE:: " + URI); responseFromApi =
	 * genRESTHandler.ExecuteAPI(GenericRESTHandler.HTTPMethod.DELETE,
	 * URI,null,null, null); return responseFromApi; }
	 */
}
