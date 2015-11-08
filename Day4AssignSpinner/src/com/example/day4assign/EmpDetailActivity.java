package com.example.day4assign;

import java.util.ArrayList;
import com.example.day4assign.R;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class EmpDetailActivity extends ListActivity {
	ListView listViewEmp;
	ArrayList<Employee> listEmp = new ArrayList<Employee>();
	EmpAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		listViewEmp = getListView();
		// add some items to arraylist
		Employee emp1 = new Employee(101, "Bhaskar", 20000, "HR");
		Employee emp2 = new Employee(102, "yogi", 20000, "QA");
		listEmp.add(emp1);
		listEmp.add(emp2);
		adapter = new EmpAdapter(EmpDetailActivity.this, R.layout.details_view,
				listEmp);
		listViewEmp.setAdapter(adapter);

	}

	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==101 && resultCode==RESULT_OK)
		{
			
			Bundle mybundle=new Bundle(data.getExtras());
			
			String name=data.getStringExtra("name");
			String dept=data.getStringExtra("dept");
			
			int id=data.getIntExtra("id", 0);
			int sal=data.getIntExtra("salary",0);
			
			listEmp.add(new Employee(id,name,sal,dept));
			adapter.notifyDataSetChanged();
			
		}		
		}
	


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		switch (id) {
		case R.id.menuAdd:

			Intent intent = new Intent(EmpDetailActivity.this,
					AddEmpActivity.class);
			//startActivity(intent);
			startActivityForResult(intent, 101);
			break;

		case R.id.menuSet:

			break;

		case R.id.menuExit:
			finish();
			break;

		default:
			break;

		}
		return super.onOptionsItemSelected(item);
	}

}

class EmpAdapter extends BaseAdapter {
	Context context;
	int resource;
	ArrayList<Employee> listEmp;

	public EmpAdapter(Context context, int resource, ArrayList<Employee> listEmp) {
		super();
		this.context = context;
		this.resource = resource;
		this.listEmp = listEmp;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listEmp.size();
	}

	@Override
	public Employee getItem(int position) {
		// TODO Auto-generated method stub
		return listEmp.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		final Employee emp = listEmp.get(position);
		// load xml layout into a view object
		// use layout inflator service
		LayoutInflater inflator = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View empView = inflator.inflate(resource, null);

		// store item info in itemview
		TextView textEmp = (TextView) empView.findViewById(R.id.textView1);
		Button btDetail = (Button) empView.findViewById(R.id.button1);
		Button btDelete = (Button) empView.findViewById(R.id.button2);
		textEmp.setText(emp.getName() + "(" + emp.getId() + ")");

		// button Listener
		btDetail.setOnClickListener(new OnClickListener() {
			String[] dept={"HR","Employee","Developer","Manager"};
			ArrayAdapter<String> spinAdapter;
			@Override
			public void onClick(View v) {
				
				final Dialog d = new Dialog(context);
				d.setTitle("detail");
				d.setContentView(R.layout.dialog_details);
				
				final EditText editName = (EditText) d
						.findViewById(R.id.editText1);
				final EditText editId = (EditText) d
						.findViewById(R.id.editText2);
				final EditText editSalary = (EditText) d
						.findViewById(R.id.editText3);
				final Spinner spinDept = (Spinner) d
						.findViewById(R.id.dspinner1);
				final Button btDone = (Button) d.findViewById(R.id.button1);

				editName.setText(emp.getName());

				String id = String.valueOf(emp.getId());

				editId.setText(id);
				String sal = String.valueOf(emp.getSalary());

				editSalary.setText(sal);
				
				spinAdapter = new ArrayAdapter<String>(context,
						android.R.layout.simple_spinner_item,dept);
				spinDept.setAdapter(spinAdapter);

				btDone.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {

						emp.setName(editName.getText().toString());
						emp.setId(Integer.parseInt(editId.getText().toString()));
						emp.setSalary( Integer.parseInt(editSalary.getText().toString()));
						emp.setDept( (String) spinDept.getItemAtPosition(position));
						
						d.dismiss();
						notifyDataSetChanged();

					}

				});
				d.show();
			}
		});
		btDelete.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				listEmp.remove(emp);
				notifyDataSetChanged();
			}
		});
		return empView;
	}

}
