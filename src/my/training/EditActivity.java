package my.training;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
	        
	        this.initTextEdits();}
	     	/*     	      	        
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
		    // аппгрейд этого метода
		            EditText name = (EditText)this.findViewById(R.id.editName);
		            String value1 = name.getText().toString();
		            this.app.user.name = value1;
		            
		            EditText proff = (EditText)this.findViewById(R.id.editProffession);
		            String value2 = proff.getText().toString();
		            this.app.user.proffession = value2;
		            
		            EditText mail = (EditText)this.findViewById(R.id.editMail);
		            String value3 = mail.getText().toString();
		            this.app.user.setMail(value3);
		        
		    }*/
	
	 		public void initTextEdits(){
	 			Intent i = this.getIntent();
		        int layoutId = i.getIntExtra("currentLayout", 0);
	 			 
		        switch (layoutId)
	 	        {
	 	        case R.layout.back_main:
	 	        	EditText university = (EditText)this.findViewById(R.id.editUniversity);
	 	        	university.setText(app.user.getUniversity());
	 	        	
	 	        	EditText speciality = (EditText)this.findViewById(R.id.editSpeciality);
	 	        	speciality.setText(app.user.getSpeciality());
	 	        	
	 	        	int[] skills = 
	 	        		{
	 	        			R.id.skill_1,
	 	        			R.id.skill_2,
	 	        			R.id.skill_3,
	 	        			R.id.skill_4
	 	        		};
	 	        	
	 	        	String [] userSkills = app.user.getSkills();
	 	        	
	 	        	int n =java.lang.Math.min(skills.length,userSkills.length);
	 	        	for (int k=0; k<n; k++)
		 	        	{
	 	        		EditText skill = (EditText)this.findViewById(skills[k]);
	 	        		skill.setText(userSkills[k]);
		 	        	}
	 	   	 	    break;
	 	        	
	 	        case R.layout.third_main:
	 	        	EditText vk = (EditText)this.findViewById(R.id.editVk);
		            vk.setText(app.user.getVk()); 
		            
		            EditText facebook = (EditText)this.findViewById(R.id.editFacebook);
		            facebook.setText(app.user.getFacebook()); 
		            
		            EditText photoes = (EditText)this.findViewById(R.id.editPhotoes);
		            photoes.setText(app.user.getPhotoes()); 
		            
		            EditText skype = (EditText)this.findViewById(R.id.editSkype);
		            skype.setText(app.user.getSkype()); 
		            
		            EditText phone = (EditText)this.findViewById(R.id.editPhone);
		            phone.setText(app.user.getPhone()); 
	 	        	break;
	 	        
	 	        default:
	 	        case R.layout.activity_main:
 	        	 	EditText name = (EditText)this.findViewById(R.id.editName);
		            name.setText(app.user.getName()); 
		            
		            EditText proff = (EditText)this.findViewById(R.id.editProffession);
		            proff.setText(app.user.getProff()); 
		            
		            EditText mail = (EditText)this.findViewById(R.id.editMail);
		            mail.setText(app.user.getMail()); 
	 	        	break;
	 	        }
		     
		           
	   }
	    
	}


