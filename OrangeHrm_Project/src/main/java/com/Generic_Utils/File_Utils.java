package com.Generic_Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class File_Utils {

	public String getdata(String key) throws IOException
	{
		FileInputStream fi=new FileInputStream(Iframeconstant.propertyfilepath);
		
		Properties prop=new Properties();
		
		prop.load(fi);
		
		String data=prop.getProperty(key);
		
		return data;

	}

}
