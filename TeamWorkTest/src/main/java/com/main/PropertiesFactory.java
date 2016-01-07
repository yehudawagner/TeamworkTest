package com.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFactory {
static private Properties properties;
static public Properties getProperties(String path_name) throws IOException{
	if(null==properties){
		properties = new Properties();
		properties.load(new FileInputStream(path_name));
	}
	return properties;
}
}
