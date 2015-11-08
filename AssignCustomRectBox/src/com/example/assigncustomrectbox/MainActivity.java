package com.example.assigncustomrectbox;




import android.support.v7.app.ActionBarActivity;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

	
	MyView myView;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        myView=(com.example.assigncustomrectbox.MyView) findViewById(R.id.view1);
        
        
        
        myView.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {

				int x = (int) event.getX();
				int y = (int) event.getY();
				
				int num=0;
				
				Toast.makeText(MainActivity.this, x + ":" + y, 1).show();

				Rect rPlus = new Rect(280, 50,320,150);
				Rect rMinus = new Rect(340,50,380,150);

				if (rPlus.contains(x, y)) {
					Toast.makeText(MainActivity.this, "plus", 1).show();
					
					num=num+10;
					
					
				}

				if (rMinus.contains(x, y)) {
					Toast.makeText(MainActivity.this, "minus", 1).show();
				}

				return false;
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
