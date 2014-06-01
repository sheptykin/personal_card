package my.training;

import java.util.ArrayList;

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
		this.app = (DemoApplication) this.getApplication();
		Intent i = this.getIntent();
		int layoutId = i.getIntExtra("currentLayout", 0);

		switch (layoutId) {
		case R.layout.back_main:
			this.setContentView(R.layout.edit_back);
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

	public void updateStringNames() {
		Intent i = this.getIntent();
		int layoutId = i.getIntExtra("currentLayout", 0);

		switch (layoutId) {
		case R.layout.back_main:
			EditText university = (EditText) this
					.findViewById(R.id.editUniversity);
			this.app.user.setUniversity(university.getText().toString());

			EditText speciality = (EditText) this
					.findViewById(R.id.editSpeciality);
			this.app.user.setSpeciality(speciality.getText().toString());

			int[] skills = { R.id.skill_1, R.id.skill_2, R.id.skill_3,
					R.id.skill_4 };

			ArrayList<String> userSkills = new ArrayList<String>();
			for (int k = 0; k < skills.length; k++) {
				EditText skill = (EditText) this.findViewById(skills[k]);
				userSkills.add(skill.getText().toString());
			}
			this.app.user.setSkills(userSkills);

			EditText mail = (EditText) this.findViewById(R.id.editMail);
			this.app.user.setMail(mail.getText().toString());

			EditText skype = (EditText) this.findViewById(R.id.editSkype);
			this.app.user.setMail(skype.getText().toString());
			break;

		default:
		case R.layout.activity_main:
			EditText name = (EditText) this.findViewById(R.id.editName);
			this.app.user.name = name.getText().toString();

			EditText proff = (EditText) this.findViewById(R.id.editProffession);
			this.app.user.proffession = proff.getText().toString();

			EditText phone = (EditText) this.findViewById(R.id.editPhone);
			this.app.user.setMail(phone.getText().toString());
			break;
		}

	}

	public void initTextEdits() {
		Intent i = this.getIntent();
		int layoutId = i.getIntExtra("currentLayout", 0);

		switch (layoutId) {
		case R.layout.back_main:
			EditText university = (EditText) this
					.findViewById(R.id.editUniversity);
			university.setText(app.user.getUniversity());

			EditText speciality = (EditText) this
					.findViewById(R.id.editSpeciality);
			speciality.setText(app.user.getSpeciality());

			int[] skills = { R.id.skill_1, R.id.skill_2, R.id.skill_3,
					R.id.skill_4 };

			String[] userSkills = app.user.getSkills();

			int n = java.lang.Math.min(skills.length, userSkills.length);
			for (int k = 0; k < n; k++) {
				EditText skill = (EditText) this.findViewById(skills[k]);
				skill.setText(userSkills[k]);
			}

			EditText skype = (EditText) this.findViewById(R.id.editSkype);
			skype.setText(app.user.getSkype());

			EditText phone = (EditText) this.findViewById(R.id.editPhone);
			phone.setText(app.user.getPhone());
			break;

		default:
		case R.layout.activity_main:
			EditText name = (EditText) this.findViewById(R.id.editName);
			name.setText(app.user.getName());

			EditText proff = (EditText) this.findViewById(R.id.editProffession);
			proff.setText(app.user.getProff());

			EditText mail = (EditText) this.findViewById(R.id.editMail);
			mail.setText(app.user.getMail());
			break;
		}

	}

}
