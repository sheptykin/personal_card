package my.training;

import java.util.ArrayList;

public class User {
	String name, proffession, mail, university, speciality, vk, facebook, photoes, skype, phone;
	ArrayList <String> skills  = new ArrayList <String> () ;
	
	
	public User (String userName, String userProff)
	{
		name = userName;
		proffession = userProff; 
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getProff()
	{
		return proffession;
	}
	
	public String setMail(String userMail)
	{
		mail = userMail ;
		return mail;
	}
	
	public String getMail()
	{
		
		return mail;
	}
	
	public String setUniversity(String userUniversity)
	{
		university = userUniversity ;
		return university;
	}
	
	public String getUniversity()
	{
		
		return university;
	}
	
	public String setSpeciality(String userSpeciality)
	{
		speciality = userSpeciality ;
		return speciality;
	}
	
	public String getSpeciality()
	{
		
		return speciality;
	}
	
	public void setSkills (ArrayList <String> userSkills)
	{
		skills.addAll(userSkills);
	}
	
	public  String[] getSkills() 
	{
		return (String[]) skills.toArray(new String[skills.size()]);
	}
	

	
	public String setSkype(String userSkype)
	{
		skype = userSkype ;
		return skype;
	}
	
	public String getSkype()
	{
		
		return skype;
	}
	
	public String setPhone(String userPhone)
	{
		phone = userPhone ;
		return phone;
	}
	
	public String getPhone()
	{
		
		return phone;
	}
	
	
	
	

}
