package com.wimc.uidesign;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity implements OnClickListener{
	
	EditText t1;
	EditText t2;
	TextView v1;
	Button b1;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		 t1=(EditText) findViewById(R.id.editText1);
		 t2=(EditText) findViewById(R.id.editText2);
		 b1=(Button) findViewById(R.id.button1);
		 v1=(TextView) findViewById(R.id.textView3);
		 b1.setOnClickListener(this);

}


	@Override
	public void onClick(View v) {
	System.out.println("in onclivk");
	
		String s1=t1.getText().toString();
		String s2=t2.getText().toString();
		int age=Integer.parseInt(s2);
		if(age>17)
		{
			v1.setText("Yes "+s1+" can vote");	
	}
		else
			v1.setText("you cannot vote");
	
	}
}