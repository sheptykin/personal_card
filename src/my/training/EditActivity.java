package my.training;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends Activity {
	
	// globally accessible application class
    protected DemoApplication app;
   
     
	@Override
	    	protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        this.app = (DemoApplication)this.getApplication();
	        Intent i = this.getIntent();
	        int layoutId = i.getIntExtra("currentLayout", 0);
	       
	        switch (layoutId)
	        {
	        case R.layout.back_main:
	        	this.setContentView(R.layout.edit_back);
	        	break;
	        	
	        case R.layout.third_main:
	        	this.setContentView(R.layout.edit_third);
	        	break;
	        
	        default:
	        case R.layout.activity_main:
	        	this.setContentView(R.layout.edit_main);
	        	break;
	        }
	        
	        this.initTextEdits();
	     	     	      	        
	        Button saveButton = (Button) this.findViewById(R.id.save);
	        saveButton.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View view) {
	                // updating values
	                EditActivity.this.updateStringNames();
	                // returning to the previous activity
	                EditActivity.this.finish();
	            }
	        });
	 
	    }
	
			public void updateStringNames(){
		    
		            EditText name = (EditText)this.findViewById(R.id.editName);
		            String value1 = name.getText().toString();
		            this.app.user.name = value1;
		            
		            EditText proff = (EditText)this.findViewById(R.id.editProffession);
		            String value2 = proff.getText().toString();
		            this.app.user.proffession = value2;
		            
		            EditText mail = (EditText)this.findViewById(R.id.editMail);
		            String value3 = mail.getText().toString();
		            this.app.user.setMail(value3);
		        
		    }
	
	 		public void initTextEdits(){
	 			
	 			Intent i = this.getIntent();
		        int layoutId = i.getIntExtra("currentLayout", 0);
	 			 
		        switch (layoutId)
	 	        {
	 	        case R.layout.edit_back:
	 	        	EditText university = (EditText)this.findViewById(R.id.editUniversity);
	 	        	university.setText(app.user.setUniversity("Oles Honchar Dnipropetrovsk National University"));
	 	        	
	 	        	EditText speciality = (EditText)this.findViewById(R.id.editSpeciality);
	 	        	speciality.setText(app.user.setSpeciality("2006 - 2012	Specialist Degree in “Equipment of radio transmission, broadcasting and television”."));
	 	        	
	 	        	int[] skills = 
	 	        		{
	 	        			R.id.skill_1,
	 	        			R.id.skill_2,
	 	        			R.id.skill_3,
	 	        			R.id.skill_4
	 	        		};
	 	        	app.user.setSkills("•	android programming basic", "•	HTML/CSS/XML/XSL fundamentals", "•	object oriented programming (Java)", "•	experienced user of Windows XP/7/8 OS"); 
	 	        	User userSkills [] = app.user.getSkills();
	 	        	
	 	        	for (int k=0; k<skills.length;k++)
		 	        	{
	 	        		EditText skill = (EditText)this.findViewById(skills[k]);
	 	        		
	 	        		skill.setText(userSkills[k]);
		 	        	}
	 	   	 	    break;
	 	        	
	 	        case R.layout.edit_third:
	 	        	EditText vk = (EditText)this.findViewById(R.id.editVk);
		            vk.setText(app.user.setVk("Sheptykin Rostislav")); 
		            
		            EditText facebook = (EditText)this.findViewById(R.id.editFacebook);
		            facebook.setText(app.user.setFacebook("Sheptykin Rostislav")); 
		            
		            EditText photoes = (EditText)this.findViewById(R.id.editPhotoes);
		            photoes.setText(app.user.setPhotoes("500px.com/juki_haruki")); 
		            
		            EditText skype = (EditText)this.findViewById(R.id.editSkype);
		            skype.setText(app.user.setSkype("Sheptykin Rostislav")); 
		            
		            EditText phone = (EditText)this.findViewById(R.id.editPhone);
		            phone.setText(app.user.setPhone("098.296.09.00")); 
	 	        	break;
	 	        
	 	        default:
	 	        case R.layout.edit_main:
 	        	 	EditText name = (EditText)this.findViewById(R.id.editName);
		            name.setText(app.user.getName()); 
		            
		            EditText proff = (EditText)this.findViewById(R.id.editProffession);
		            proff.setText(app.user.getProff()); 
		            
		            EditText mail = (EditText)this.findViewById(R.id.editMail);
		            mail.setText(app.user.setMail("sheptykin.rostislav@gmail.com")); 
	 	        	break;
	 	        }
		     
		           
	   }
	    
	}


