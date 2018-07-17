package com.qa.util;

import org.json.JSONObject;
import org.json.XML;

import com.google.gson.Gson;

public class JSONUtil {

	private Gson gson;

	public JSONUtil() {
		this.gson = new Gson();
	}
	public String JSONtoXML(String json) {
		String xml = XML.toString(json);
		return xml;
	}
	
	public String XMLtoJSON(String xml) {
		JSONObject soapDatainJsonObject = XML.toJSONObject(xml);
		return soapDatainJsonObject.toString();
	}

	public String getJSONForObject(Object obj) {
		return gson.toJson(obj);
	}

	public <T> T getObjectForJSON(String jsonString, Class<T> clazz) {
		return gson.fromJson(jsonString, clazz);
	}

}