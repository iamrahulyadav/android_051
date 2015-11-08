package com.wimc.basiccontrols;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ToggleButton;


public class MainActivity extends ActionBarActivity {

	
	EditText editName;
	RadioButton radiomale,radiofemale;
	CheckBox chkBE,chkMBA,chkMTech;
	Button btsave;
	ToggleButton toggleMarried;
	
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        editName=(EditText)findViewById(R.id.editText1);
        radiomale=(RadioButton)findViewById(R.id.radioButton1);
        radiofemale=(RadioButton)findViewById(R.id.radioButton2);
        chkBE=(CheckBox)findViewById(R.id.checkBox1);
        chkMBA=(CheckBox)findViewById(R.id.checkBox2);
        chkMTech=(CheckBox)findViewById(R.id.checkBox3);
        btsave=(Button)findViewById(R.id.button1);
        toggleMarried=(ToggleButton)findViewById(R.id.toggle1);
        
        
        btsave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				String name=editName.getText().toString();
				String gen="";
				
				if(radiomale.isChecked())
					gen="Male";
				
				 if(radiofemale.isChecked())
				 gen="Female";

				String edu="";
				
				if(chkBE.isChecked())
					edu="BE,";
				if(chkMBA.isChecked())
					edu=edu+"MBA,";
				if(chkMTech.isChecked())
					edu=edu+"MTech";
				
				String status="";
				if(toggleMarried.isChecked())
					status="married";
				else
					status="unmarried";
				String data=name+" "+gen+" "+edu+" "+status;
				
				Toast t=Toast.makeText(MainActivity.this, data, Toast.LENGTH_LONG);
				t.show();
				
				
			}
		});
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
