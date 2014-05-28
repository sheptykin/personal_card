package my.training;

import java.util.ArrayList;

import android.app.Application;
import android.content.SharedPreferences;

public class DemoApplication extends Application {
	public User user;

	@Override
	public void onCreate() {
		super.onCreate();
		this.user = this.loadUser();
		if (this.user == null) {
			this.user = this.createUser();
		}

	}

	@Override
	public void onTerminate() {
		this.saveUser(this.user);
		super.onTerminate();

	}
	
	public void saveUser (User u)
	{
		SharedPreferences settings = getSharedPreferences("userPrefs", 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putString("userName", user.getName());
		editor.putString("userProff", user.getProff());
		editor.commit();
	}

	public User loadUser() {
		User newUser = null;
		SharedPreferences settings = getSharedPreferences("userPrefs", 0);
		String name = settings.getString("userName", null);
		String proffesion = settings.getString("userProff", null);
		if (name == null || proffesion == null) {
			return null;
		}
		newUser = new User(name, proffesion);
		return newUser;
	}

	public User createUser() {
		User user = new User("Rostislav Sheptykin",
				"android developer (trainee)");
		

		user.setUniversity("Oles Honchar Dnipropetrovsk National University");
		user.setSpeciality("2006 - 2012	Specialist Degree in “Equipment of radio transmission, broadcasting and television”.");

		ArrayList<String> skills = new ArrayList<String>();
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
		return user;
	}

}
