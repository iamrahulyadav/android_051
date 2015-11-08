package com.example.day4assign;

import com.example.day4assign.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AddEmpActivity extends Activity {

	EditText editName, editId, editSal;
	Button btAdd;
	Spinner spinDept;
	ArrayAdapter<String> adapter1;
	String[] dept = { "HR", "Employee", "Developer", "Manager" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_emp);
		editName = (EditText) findViewById(R.id.editText1);
		btAdd = (Button) findViewById(R.id.button1);

		editId = (EditText) findViewById(R.id.editText2);
		editSal = (EditText) findViewById(R.id.editText3);
		spinDept = (Spinner) findViewById(R.id.spinner1);
		// instantiate adapter

		adapter1 = new ArrayAdapter<String>(AddEmpActivity.this,
				android.R.layout.simple_spinner_item, dept);

		// attach adapterb with view

		spinDept.setAdapter(adapter1);
		btAdd.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// Bundle to store data
				Bundle bundle = new Bundle();
				bundle.putString("name", editName.getText().toString());
				bundle.putString("dept", (String) spinDept.getSelectedItem());
				bundle.putInt("salary",
						Integer.parseInt(editSal.getText().toString()));
				bundle.putInt("id",
						Integer.parseInt(editId.getText().toString()));

				// create explicit Intent
				// Intent intent=new Intent(packageContext,cls);
				Intent intent = new Intent(AddEmpActivity.this,
						EmpDetailActivity.class);

				// attach data with Intent
				intent.putExtras(bundle);

				// send intent to OS
				setResult(RESULT_OK, intent); // -->OS
				finish();

			}
		});

	}

}
