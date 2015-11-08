package com.wimc.customadapter;

import java.io.Serializable;
import java.util.ArrayList;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class ItemListActivity extends ListActivity{

	ListView listViewItems;
	ArrayList<Item> listItems = new ArrayList<Item>();
	ItemAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		listViewItems = getListView();
		// add some items to arraylist
		Item item1 = new Item("Burger", 50, 3, "food");
		Item item2 = new Item("Jeans", 999, 2, "cloth");
		listItems.add(item1);
		listItems.add(item2);
		listItems.add(new Item("Book", 350, 2, "stationary"));
		listItems.add(new Item("Moto G", 6999, 1, "electronics"));

		// create adapter
		adapter = new ItemAdapter(ItemListActivity.this, R.layout.item_view,
				listItems);
		listViewItems.setAdapter(adapter);
	}
}// eof activity

// create adapter definition

class ItemAdapter extends BaseAdapter {
	Context context;
	int resource;
	ArrayList<Item> listItems;

	public ItemAdapter(Context context, int resource, ArrayList<Item> lisItems) {
		super();
		this.context = context;
		this.resource = resource;
		this.listItems = lisItems;
	}

	// 1.should return count of objects stored in data store
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listItems.size();
	}

	// 2. should return object stored in data store in given position
	@Override
	public Item getItem(int position) {
		// TODO Auto-generated method stub
		return listItems.get(position);
	}

	// 3. should return unique value for the object position
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	// 4. to return a view representing all the information of ith object in
	// data store.
	// This method executes no of times returned by getCount().
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		final Item item = listItems.get(position);
		// load xml layout into a view object
		// use layout inflator service
		LayoutInflater inflator = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View itemView = inflator.inflate(resource, null);

		// store item info in itemview
		TextView textName = (TextView) itemView.findViewById(R.id.textView1);
		TextView textPrice=(TextView)itemView.findViewById(R.id.textView2);
		Button btDetail=(Button) itemView.findViewById(R.id.button1);
		textName.setText(item.getName());
		textPrice.setText(item.getPrice() +"");
		
		//button Listener
		btDetail.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				
				Intent intent=new Intent(context,DetailActivity.class);
				
				//attach data with Intent
				intent.putExtra("myinfo", item);
				
				//send intent to OS
				//startActivity(intent);
				context.startActivity(intent);
				
			}
		});
		return itemView;
	}

}