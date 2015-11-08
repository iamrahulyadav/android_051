package com.example.fragmentdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class CityFragment extends Fragment {

	Spinner spnCity;

	String ar[] = { "pune", "mumbai", "delhi", "bhilai" };
	ArrayAdapter<String> adapter;

	Button btGo;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		// load ui for this fragment

		View fragView = inflater.inflate(R.layout.cityfrag, container, false);

		spnCity = (Spinner) fragView.findViewById(R.id.spinner1);
		btGo = (Button) fragView.findViewById(R.id.button1);

		final Activity act = getActivity();

		adapter = new ArrayAdapter<String>(act,
				android.R.layout.simple_spinner_item, ar);

		spnCity.setAdapter(adapter);

		btGo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				String city = spnCity.getSelectedItem().toString();

				Toast.makeText(act, city, 7).show();

				if (act instanceof CityListner) {
					CityListner cityListner = (CityListner) act;

					cityListner.setCity(city);

				}

			}
		});

		return fragView;
	}

}
