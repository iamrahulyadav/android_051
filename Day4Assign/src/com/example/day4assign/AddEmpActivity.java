package com.example.day4assign;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AddEmpActivity extends Activity {

	EditText editName, editId, editSal, editDept;
	Button btAdd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_emp);
		editName = (EditText) findViewById(R.id.editText1);
		btAdd = (Button) findViewById(R.id.button1);
		
		editId = (EditText) findViewById(R.id.editText2);
		editSal = (EditText) findViewById(R.id.editText3);
		editDept = (EditText) findViewById(R.id.editText4);

		btAdd.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String name = editName.getText().toString();
				String sid = editId.getText().toString();
				String ssal = editSal.getText().toString();
				String dept = editDept.getText().toString();
				int id = Integer.parseInt(sid);
				int sal = Integer.parseInt(ssal);

				// Bundle to store data
				Bundle bundle = new Bundle();
				bundle.putString("name", name);
				bundle.putString("dept", dept);
				bundle.putInt("salary", sal);
				bundle.putInt("id", id);

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
