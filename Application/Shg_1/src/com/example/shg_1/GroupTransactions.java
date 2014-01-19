package com.example.shg_1;


	
import com.example.shg_1.model.Transaction;

import com.example.shg_1.sqlite.MySQLiteHelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class GroupTransactions extends Activity{
		@Override
		   protected void onCreate(Bundle savedInstanceState) {
		   super.onCreate(savedInstanceState);
		   setContentView(R.layout.group_transactions);
		    }
		
		
		
		public void addgrouptransaction(View view) {
	        // Do something in response to button
	    	 // Get the name of person
	    	
	    	 EditText text1 = (EditText)findViewById(R.id.editText1);
	         String from = text1.getText().toString();
	    	
	         EditText text3 = (EditText)findViewById(R.id.editText3);
	         String why = text3.getText().toString();
	        
	         EditText text2 = (EditText)findViewById(R.id.editText2);
	         String money = text2.getText().toString();
	      
	         Log.d("ADebugTag", "Value: " + from);
	         Log.d("ADebugTag", "Value: " + money);
	         Log.d("ADebugTag", "Value: " + why);
	         
	         // Writing the data values to the database
	         
	         MySQLiteHelper db = new MySQLiteHelper(this);
	         db.addTransaction(new Transaction(from,"group",money,why));   
	         
	    	 
	         Intent intent = new Intent(this,NextActivity.class);
	         startActivity(intent);
	    }
		
	}