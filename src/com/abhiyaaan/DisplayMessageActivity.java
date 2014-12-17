package com.abhiyaaan;

import java.io.InputStream;
import android.location.Location;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayMessageActivity extends Activity {

	public HttpClient httpclient = null;
	public HttpGet httpGet = null;
	public HttpResponse response = null;
	public HttpEntity urlEntity = null;
	public InputStream in = null;

	@Override
	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_message);
		Intent intent = getIntent();
		Bundle extras = intent.getExtras();

		String Images = extras.getString("Images");
		ImageView imageView = (ImageView) findViewById(R.id.ImageView01);
		imageView.setImageBitmap(BitmapFactory.decodeFile(Images));

		String message1 = extras.getString("text1");
		TextView textView1 = (TextView) findViewById(R.id.TextView01);
		textView1.setText("Location : " + message1);

		String message2 = extras.getString("text2");
		TextView textView2 = (TextView) findViewById(R.id.TextView02);
		textView2.setText("Dirt Type :" + message2);

		String message3 = extras.getString("text3");
		TextView textView3 = (TextView) findViewById(R.id.TextView03);
		textView3.setText("Rating :" + message3);

		
		


		
		LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		locationManager.requestLocationUpdates(
				LocationManager.NETWORK_PROVIDER,
				0,
				100,
               new MyLocationListener()
				);

		Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
		
		//String message = String.format(
        //       "Current Location \n Longitude: %1$s \n Latitude: %2$s",
         //      location.getLongitude(), location.getLatitude()
       //);
		//String.valueOf(location.getLongitude());
		
		
		// message 1 ,2 , 3
		try {
			Log.d("salman", "ssss");
			// URL myURL = new URL(
			// "http://1-dot-supple-design-766.appspot.com/resources/psend/loc/"
			// + message1 + "/" + message2 + "/" + message3);
			// Log.d("hello", myURL.toString());
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
					.permitAll().build();
			StrictMode.setThreadPolicy(policy);

			Toast.makeText(
					getApplicationContext(),
					new RequestTask().doInBackground(Images, message1, message2, message3, String.valueOf(location.getLongitude()), String.valueOf(location.getLatitude())), Toast.LENGTH_LONG).show();

		/*	String respo = new RequestTask().doInBackground( "gg");
			Log.d("response",respo);
			Toast.makeText(
					getApplicationContext(),
					respo, Toast.LENGTH_LONG).show();
			
			*/
			//new GetRequest().doInBackground( "gg");
			
		} catch (Exception e) {
			Log.d("rishi", "hhhh");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_message, menu);
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
