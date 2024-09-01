package com.waiz.waizblogger;


public class ProjectManager {
	
	public static void newProject(String name) {
		FileHandler.createDir(name);
		FileHandler.createDir(name+"/public_html");
		FileHandler.createDir(name+"/posts");
		FileHandler.createDir(name+"/templates");

		//Copy default Template to template dir 
		FileHandler.createDir(name+"/templates/DefaultTemplate");
		FileHandler.createDir(name+"/templates/DefaultTemplate/public");

		FileHandler.copyFileFromResource("/DefaultTemplate/waizblog.toml", name +"/templates/DefaultTemplate/waizblog.toml");
		FileHandler.copyFileFromResource("/DefaultTemplate/public/index.html", name +"/templates/DefaultTemplate/public/index.html");
	}
}