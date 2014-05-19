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
	        int layoutId = i.getIntExtra("curretLayout", 0);
	       
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
	        //cases of layout edits
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
		     
		            EditText name = (EditText)this.findViewById(R.id.editName);
		            name.setText(app.user.getName()); 
		            
		            EditText proff = (EditText)this.findViewById(R.id.editProffession);
		            proff.setText(app.user.getProff()); 
		            
		            EditText mail = (EditText)this.findViewById(R.id.editMail);
		            mail.setText(app.user.setMail("mail")); 
		        }
	    
	}


