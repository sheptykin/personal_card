package my.training;

public class User {
	String name, proffession, mail;
	
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
	
	
	

}
