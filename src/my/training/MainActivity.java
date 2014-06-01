package my.training;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	protected DemoApplication app;

	int[] layouts = { R.layout.activity_main, R.layout.back_main};

	int layoutIndex = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.app = (DemoApplication) this.getApplication();

	}

	protected void switchLayout() {

		this.layoutIndex++;

		// loop from the beginning
		if (this.layoutIndex >= this.layouts.length) {
			this.layoutIndex = 0;
		}

		this.displayScreen(this.layouts[this.layoutIndex]);

	}

	protected void displayScreen(int id) {

		setContentView(id);

		switch (id) {
		case R.layout.back_main:
			TextView university = (TextView) this
					.findViewById(R.id.mainUniversity);
			university.setText(app.user.getUniversity());

			TextView speciality = (TextView) this
					.findViewById(R.id.mainSpeciality);
			speciality.setText(app.user.getSpeciality());

			int[] skills = { R.id.mainSkill_1, R.id.mainSkill_2,
					R.id.mainSkill_3, R.id.mainSkill_4 };

			String[] userSkills = app.user.getSkills();

			int n = java.lang.Math.min(skills.length, userSkills.length);
			for (int k = 0; k < n; k++) {
				TextView skill = (TextView) this.findViewById(skills[k]);
				skill.setText(userSkills[k]);
			}
			
			TextView skype = (TextView) this.findViewById(R.id.mainSkype);
			skype.setText(app.user.getSkype());

			TextView phone = (TextView) this.findViewById(R.id.mainPhone);
			phone.setText(app.user.getPhone());
			break;

		default:
		case R.layout.activity_main:
			TextView name = (TextView) this.findViewById(R.id.mainName);
			name.setText(app.user.getName());

			TextView proff = (TextView) this.findViewById(R.id.mainProffesion);
			proff.setText(app.user.getProff());

			TextView mail = (TextView) this.findViewById(R.id.mainMail);
			mail.setText(app.user.getMail());
			break;
		}

		Button b = (Button) this.findViewById(R.id.next);
		b.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				MainActivity.this.switchLayout();
			}
		});

	}

	@Override
	protected void onResume() {

		super.onResume();
		this.app.saveUser(this.app.user);
		this.displayScreen(this.layouts[this.layoutIndex]);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {

			Intent i = new Intent(this, EditActivity.class);
			i.putExtra("currentLayout", this.layouts[this.layoutIndex]);
			this.startActivity(i);

			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
