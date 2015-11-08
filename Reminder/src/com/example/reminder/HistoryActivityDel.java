package com.example.reminder;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.reminder.HistoryActivity;
import com.example.reminder.R;
import com.example.reminder.controller.ReminderController;
import com.example.reminder.model.Reminder;

public class HistoryActivityDel extends ListActivity {

	ListView listHistory;

	Reminder rem = new Reminder();
	ArrayList<Reminder> listRem = new ArrayList<Reminder>();
	HistoryAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		listHistory = getListView();
		ReminderController rc = new ReminderController(this);
		listRem = rc.showReminder();

		adapter = new HistoryAdapter(this, R.layout.historydel, listRem);

		listHistory.setAdapter(adapter);

	}

}

class HistoryAdapter extends BaseAdapter {
	Context context;
	int resource;
	ArrayList<Reminder> listHistory;

	public HistoryAdapter(Context context, int resource,
			ArrayList<Reminder> lisItems) {
		super();
		this.context = context;
		this.resource = resource;
		this.listHistory = lisItems;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listHistory.size();
	}

	@Override
	public Reminder getItem(int position) {
		// TODO Auto-generated method stub
		return listHistory.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		final Reminder rem = listHistory.get(position);
		final ArrayAdapter<Reminder> ArrayList;

		// load xml layout into a view object
		// use layout inflator service
		LayoutInflater inflator = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View itemView = inflator.inflate(resource, null);

		TextView textDetail = (TextView) itemView.findViewById(R.id.textView1);
		Button btDel = (Button) itemView.findViewById(R.id.button1);

		textDetail.setText(rem.getRemTitle() + " " + rem.getRemDate() + " "
				+ rem.getRemType());

		btDel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				ReminderController remCont = new ReminderController(context);

				Reminder rem = new Reminder();

				remCont.deleteRem(rem);

				listHistory.remove(position);

				notifyDataSetChanged();

			}

		});
		return itemView;
	}

}
