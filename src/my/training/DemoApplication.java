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

	public void saveUser(User u) {
		SharedPreferences settings = getSharedPreferences("userPrefs", 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putString("userName", user.getName());
		editor.putString("userProff", user.getProff());
		editor.putString("userMail", user.getMail());
		editor.putString("userPhone", user.getPhone());
		editor.putString("userUniversity", user.getUniversity());
		editor.putString("userSpeciality", user.getSpeciality());
		editor.putString("userSkype", user.getSkype());
		
		String[] userSkills = this.user.getSkills();
		editor.putString("userSkill_1", userSkills[0]);
		editor.putString("userSkill_2", userSkills[1]);
		editor.putString("userSkill_3", userSkills[2]);
		editor.putString("userSkill_4", userSkills[3]);
		editor.commit();
	}

	public User loadUser() {
		User newUser = null;
		SharedPreferences settings = getSharedPreferences("userPrefs", 0);
		String name = settings.getString("userName", null);
		String proffesion = settings.getString("userProff", null);
		String mail = settings.getString("userMail", null);
		String university = settings.getString("userUniversity", null);
		String speciality = settings.getString("userSpeciality", null);
		String phone = settings.getString("userPhone", null);
		String skype = settings.getString("userSkype", null);

		String skill_1 = settings.getString("userSkill_1", null);
		String skill_2 = settings.getString("userSkill_2", null);
		String skill_3 = settings.getString("userSkill_3", null);
		String skill_4 = settings.getString("userSkill_4", null);

		ArrayList<String> skills = new ArrayList<String>();
		skills.add(skill_1);
		skills.add(skill_2);
		skills.add(skill_3);
		skills.add(skill_4);

		if (name == null || proffesion == null) {
			return null;
		}
		newUser = new User(name, proffesion);
		newUser.setMail(mail);
		newUser.setPhone(phone);
		newUser.setSkype(skype);
		newUser.setSpeciality(speciality);
		newUser.setUniversity(university);
		newUser.setSkills(skills);

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

		user.setSkype("Sheptykin Rostislav");
		user.setPhone("098.296.09.00");
		user.setMail("sheptykin.rostislav@gmail.com");
		return user;
	}

}
