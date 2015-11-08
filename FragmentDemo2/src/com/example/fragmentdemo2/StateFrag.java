package com.example.fragmentdemo2;



import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StateFrag extends Fragment {
	Button btGo;
	EditText editState;
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View fragView = inflater.inflate(R.layout.frag2, container, false);
		btGo = (Button) fragView.findViewById(R.id.button1);
		editState=(EditText) fragView.findViewById(R.id.editText1);
		final Activity act = getActivity();
		// TODO Auto-generated method stub
		btGo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String state=editState.getText().toString();

				Toast.makeText(act, state, 7).show();

				if (act instanceof Details) {
					Details stateListner = (Details) act;

					stateListner.setState(state);

				}

			}
		});
		return fragView;
	}

}
