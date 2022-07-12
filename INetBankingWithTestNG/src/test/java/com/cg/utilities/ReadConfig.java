package com.cg.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {
	
	public Properties pro;
	public ReadConfig() {
		
		File src=new File("./Configurations/Config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
			
		} catch (Exception e) {
			System.out.println("Exception is:"+e.getMessage());
		}		
		
	}
	
	public String getURL() {
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	public String getUsername() {
		String username=pro.getProperty("username");
		return username;
	}
	
	public String gePassword() {
		String password=pro.getProperty("password");
		return password;
	}
	

}
