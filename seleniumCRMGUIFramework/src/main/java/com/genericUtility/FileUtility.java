package com.genericUtility;

import java.io.InputStream;
import java.util.Properties;

public class FileUtility {
	public String getDatafromProperty(String key) throws Exception {
		InputStream fis = FileUtility.class.getClassLoader().getResourceAsStream("commonData.properties");
		Properties property_object = new Properties();
		property_object.load(fis);
		return property_object.get(key).toString();
	}
}
