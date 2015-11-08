package com.example.webviewdemo;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {

	EditText editUrl;
	Button btGo;
	WebView myWebView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		editUrl = (EditText) findViewById(R.id.editText1);

		btGo = (Button) findViewById(R.id.button1);

		myWebView = (WebView) findViewById(R.id.webView1);

		myWebView.setWebViewClient(new MyWebClient());

		btGo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				String url = editUrl.getText().toString();

				myWebView.loadUrl(url);

			}
		});

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub

		if (keyCode == KeyEvent.KEYCODE_BACK) {

			if (myWebView.canGoBack()) // there is history
			{

				myWebView.goBack();
				return false;
			}

		}

		return super.onKeyDown(keyCode, event);
	}

	class MyWebClient extends WebViewClient {
		ProgressDialog d = null;

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {

			view.loadUrl(url);

			// TODO Auto-generated method stub
			return super.shouldOverrideUrlLoading(view, url);
		}

		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			// TODO Auto-generated method stub
			super.onPageStarted(view, url, favicon);

			d = new ProgressDialog(MainActivity.this);
			// d.setTitle(url);
			// d.setMessage("Loading Br");
			// d.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			// d.show();
		}

		@Override
		public void onPageFinished(WebView view, String url) {
			// TODO Auto-generated method stub
			super.onPageFinished(view, url);
			d.dismiss();

		}
	}

}
