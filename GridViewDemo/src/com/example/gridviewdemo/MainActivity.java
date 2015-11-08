package com.example.gridviewdemo;

import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

	GridView gridStudent;
	ArrayList<Student> listStudents=new ArrayList<Student>();
	StudentAdapter adapter;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridStudent=(GridView)findViewById(R.id.gridView1);
        Student s1=new Student("Neeraj", R.drawable.i1);
        Student s2=new Student("Rohit", R.drawable.i2);
        Student s3=new Student("Deepak", R.drawable.i3);
        listStudents.add(s1);
        listStudents.add(s2);
        listStudents.add(s3);
        listStudents.add(new Student("Yogi", R.drawable.i4));
        listStudents.add(new Student("Bhaskar", R.drawable.i5));
        listStudents.add(new Student("Thakur", R.drawable.i6));
        listStudents.add(new Student("Akhil", R.drawable.i7));
        adapter=new StudentAdapter(MainActivity.this,R.layout.home_view,listStudents);
        gridStudent.setAdapter(adapter);
        
        
        gridStudent.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
			//	String name=Student.get;
				
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
    
    
    
    
}//eof activity

class StudentAdapter extends BaseAdapter{
	Context context;
	int resource;
	ArrayList<Student> listStudents;
	
	public StudentAdapter(Context context, int resource,
			ArrayList<Student> listStudents) {
		super();
		this.context = context;
		this.resource = resource;
		this.listStudents = listStudents;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listStudents.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return listStudents.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final Student student = listStudents.get(position);
		// load xml layout into a view object
		// use layout inflator service
		LayoutInflater inflator = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View itemView = inflator.inflate(resource, null);
		TextView textName = (TextView) itemView.findViewById(R.id.textView1);
		ImageView image=(ImageView) itemView.findViewById(R.id.imageView1);
		textName.setText(student.getName());
		image.setImageResource(student.getImageId());
		return itemView;
	}
	
}