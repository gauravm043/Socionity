package com.example.shg_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SelectTransaction extends Activity{
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.select_transaction);
	    }
	 
	 public void individual_transactions(View view) {
	        // Do something in response to button
	    	Intent intent = new Intent(this,IndividualTransactions.class);
	        startActivity(intent);
	    }
	 
	 public void  group_transactions(View view) {
	        // Do something in response to button
	    	Intent intent = new Intent(this,GroupTransactions.class);
	        startActivity(intent);
	    }
	 
	 public void  see_function(View view) {
	        // Do something in response to button
		 
		 
		 Log.d("ADebugTag", "Value: " + "helloooooooooooooooooooooooooooooo");
	    	Intent intent = new Intent(this,See.class);
	        startActivity(intent);
	    }
	 
	 
	 
	 
}