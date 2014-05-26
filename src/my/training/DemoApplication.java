package my.training;

import android.app.Application;

public class DemoApplication extends Application {
	public User user;
	@Override
	    public void onCreate() {
	        super.onCreate();
	      user = new User("Rostislav Sheptykin","android developer (trainee)"); 
	       }
	 
}
