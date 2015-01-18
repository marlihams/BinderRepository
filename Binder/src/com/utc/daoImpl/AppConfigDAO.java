package com.utc.daoImpl;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class AppConfigDAO {
	
	private String xmlFile;
	
	public AppConfigDAO(){
		try{
			xmlFile = getClass().getClassLoader().getResource("/com/utc/config/conf.xml").toString();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println("le fichier est "+xmlFile);
	}
	
	public Map<String, String> getMailSettings(){
		Map<String, String> mailSettings  = new HashMap<String, String>();
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document dom = db.parse(xmlFile);
			String host = dom.getElementsByTagName("host").item(0).getTextContent();
			String port = dom.getElementsByTagName("port").item(0).getTextContent();
			String email = dom.getElementsByTagName("email").item(0).getTextContent();
			String password = dom.getElementsByTagName("password").item(0).getTextContent();
			String username = dom.getElementsByTagName("username").item(0).getTextContent();
			String protocol = dom.getElementsByTagName("protocol").item(0).getTextContent();
			mailSettings.put("host", host);
			mailSettings.put("port", port);
			mailSettings.put("email", email);
			mailSettings.put("username", username);
			mailSettings.put("password", password);
			mailSettings.put("protocol", protocol);
		} catch (Exception e) {
			System.out.println(e.getMessage());
	    }
		return mailSettings;
	}
	}