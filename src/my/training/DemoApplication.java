package my.training;

import java.util.ArrayList;

import android.app.Application;

public class DemoApplication extends Application {
	public User user;
	@Override
	    public void onCreate() {
	        super.onCreate();
	      user = new User("Rostislav Sheptykin","android developer (trainee)"); 
	      //2. http://developer.android.com/guide/topics/data/data-storage.html (çàïîìèíàòü çíà÷åíèÿ).
	      
	      user.setUniversity("Oles Honchar Dnipropetrovsk National University");
	      user.setSpeciality("2006 - 2012	Specialist Degree in “Equipment of radio transmission, broadcasting and television”.");
	      
	      ArrayList <String> skills = new ArrayList <String> (); 
	      skills.add("•	android programming basic");
	      skills.add("•	HTML/CSS/XML/XSL fundamentals");
	      skills.add("•	object oriented programming (Java)");
	      skills.add("•	experienced user of Windows XP/7/8 OS");
	      user.setSkills(skills);
	      
	      user.setVk("Sheptykin Rostislav");
	      user.setFacebook("Sheptykin Rostislav");
	      user.setPhotoes("500px.com/juki_haruki");
	      user.setSkype("Sheptykin Rostislav");
	      user.setPhone("098.296.09.00");
	      user.setMail("sheptykin.rostislav@gmail.com");
	      
	}
	 
}
