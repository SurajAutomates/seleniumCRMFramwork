package com.genericUtility;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	public Object getDataFromJson(String key) throws IOException, ParseException {
		InputStream fis = JsonUtility.class.getClassLoader().getResourceAsStream("commonDatausingJson.json");
		JSONParser parser = new JSONParser();
		Object object = parser.parse(new InputStreamReader(fis));
		JSONObject json_object = (JSONObject) object;
		return json_object.get(key);
	}
}
