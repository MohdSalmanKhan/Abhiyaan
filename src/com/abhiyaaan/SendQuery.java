//package com.abhiyaaan;
//
//import android.support.v7.app.ActionBarActivity;
//import android.annotation.SuppressLint;
//import android.annotation.TargetApi;
//import android.content.Intent;
//import android.graphics.BitmapFactory;
//import android.os.Build;
//import android.os.Bundle;
//import android.os.StrictMode;
//import android.util.Log;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//@TargetApi(Build.VERSION_CODES.GINGERBREAD)
//public class SendQuery extends ActionBarActivity {
//
//	@SuppressLint("NewApi")
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_send_query);
//		
//		
//		Intent intent = getIntent();
//		Bundle extras = intent.getExtras();
//
//		
//		//String message1 = extras.getString("text1");
//		//TextView textView1 = (TextView) findViewById(R.id.TextView01);
//		//textView1.setText("Location : " + message1);
//
//		
//		try {
//			Log.d("SalmanJIII", "hii");
//			// URL myURL = new URL(
//			// "http://1-dot-supple-design-766.appspot.com/resources/psend/loc/"
//			// + message1 + "/" + message2 + "/" + message3);
//			// Log.d("hello", myURL.toString());
//			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
//					.permitAll().build();
//			StrictMode.setThreadPolicy(policy);
//
//			Toast.makeText(
//					getApplicationContext(),
//					new GetRequest().doInBackground( "Hello"), Toast.LENGTH_LONG).show();
//
//		} catch (Exception e) {
//			Log.d("naveen", "doIT");
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//
//		
//		
//		
//	}
//
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.send_query, menu);
//		return true;
//	}
//
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		// Handle action bar item clicks here. The action bar will
//		// automatically handle clicks on the Home/Up button, so long
//		// as you specify a parent activity in AndroidManifest.xml.
//		int id = item.getItemId();
//		if (id == R.id.action_settings) {
//			return true;
//		}
//		return super.onOptionsItemSelected(item);
//	}
//}
