package com.example.shg_1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.example.shg_1.model.Member;
import com.example.shg_1.sqlite.MySQLiteHelper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class NewMember extends Activity {

	private static final int CAMERA_REQUEST = 1888; 
    private ImageView imageView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_member);
        
       
        this.imageView = (ImageView)this.findViewById(R.id.imageView1);
        Button photoButton = (Button) this.findViewById(R.id.button1);
        
        // Get the values from the edit text fields
        
        photoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE); 
                startActivityForResult(cameraIntent, CAMERA_REQUEST); 
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {  
            Bitmap photo = (Bitmap) data.getExtras().get("data"); 
            imageView.setImageBitmap(photo);
        }  
    } 
    
    // Add a new Member Here from Add Member Function
    /** Called when the user clicks the Send button */
    public void save_member(View view) {
        // Do something in response to button
    	 // Get the name of person
    	
    	 EditText text1 = (EditText)findViewById(R.id.EditText01);
         String name = text1.getText().toString();
    	
         EditText text3 = (EditText)findViewById(R.id.editText3);
         String phone = text3.getText().toString();
        
         EditText text2 = (EditText)findViewById(R.id.editText2);
         String address = text2.getText().toString();
      
         Log.d("ADebugTag", "Value: " + name);
         Log.d("ADebugTag", "Value: " + address);
         Log.d("ADebugTag", "Value: " + phone);
         
         // Writing the data values to the database
         
         MySQLiteHelper db = new MySQLiteHelper(this);
         db.addMember(new Member(phone,name,address));   
         
    	 
         Intent intent = new Intent(this,NextActivity.class);
         startActivity(intent);
    }
}
