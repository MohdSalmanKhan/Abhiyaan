package com.abhiyaaan;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

/**
 * The Main Activity.
 * 
 * This activity starts up the RegisterActivity immediately, which communicates
 * with your App Engine backend using Cloud Endpoints. It also receives push
 * notifications from backend via Google Cloud Messaging (GCM).
 * 
 * Check out RegisterActivity.java for more details.
 */
public class MainActivity extends Activity {

	
	
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public static String Images = "com.example.myfirstapp.MESSAGE";

    public String ImagePlace = null ;
    
    public static int RESULT_LOAD_IMAGE = 1;
    
	public void sendMessage(View view)
	{
		
		Intent intent = new Intent(this ,DisplayMessageActivity.class );
		
		Bundle extras = new Bundle();
		
		EditText editText1 = (EditText) findViewById(R.id.text1);
		String message1 = editText1.getText().toString();

		//		intent.putExtra(EXTRA_MESSAGE, message);		
		// assert(ImagePlace != null);
		 //Log.d("App_khan" ,message1 );
        // i.putExtra(Images, ImagePlace) ;
       //  i.putExtra(EXTRA_MESSAGE, message); 
         
         
         
        
         
		EditText editText2 = (EditText) findViewById(R.id.text2);
		String message2 = editText2.getText().toString();

         
		EditText editText3 = (EditText) findViewById(R.id.text3);
		String message3 = editText3.getText().toString();

 		 
 		 
 		 
 		 extras.putString("Images",ImagePlace);
         extras.putString("text1",message1);
         extras.putString("text2",message2);
         extras.putString("text3",message3);
//        
// 		 
         intent.putExtras(extras);
//        
		Log.d("App_khan" ,message3 );
	    startActivity(intent);
//	   
	}
	

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        
        Bitmap  selectedphoto = null;
        if (requestCode == MainActivity.RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            
        	Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
 
            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();
 
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            
            
            Log.d("jjj","jjj");
            cursor.close();
            
            ImagePlace = picturePath ;
            Log.d("jjj",ImagePlace);
        }
     
     
    }

	public void LoadImages(View view)
	{
        
        Intent i = new Intent(
                Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
         
        startActivityForResult(i, RESULT_LOAD_IMAGE);
        
	}
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Start up RegisterActivity right away
//		Intent intent = new Intent(this, RegisterActivity.class);
//		startActivity(intent);
		// Since this is just a wrapper to start the main activity,
		// finish it after launching RegisterActivity
	//	finish();
	}
	
}