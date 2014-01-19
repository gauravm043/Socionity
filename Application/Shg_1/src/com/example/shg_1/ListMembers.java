package com.example.shg_1;


import android.content.Intent;

import android.view.View;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.shg_1.model.Member;
import com.example.shg_1.sqlite.MySQLiteHelper;


public class ListMembers extends Activity{
	
	// Declare the UI components
		private ListView songsListView;
	    // Declare an array to store data to fill the list
		private String[] songsArray ;
		
		 MySQLiteHelper db = new MySQLiteHelper(this);
		 
		 
		
		private ArrayAdapter<String> arrayAdapter;
		
	    /** Called when the activity is first created. */
	
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
	        setContentView(R.layout.list_schedule);
	        
	        
	    //   db.chutiya();
	        
	      //ndb.execSQL("DROP TABLE IF EXISTS members");       // add Books
	      //db.onCreate(ndb);
	      //  db.addMember(new Member("9919898989","Maju maju","Android Application Development Cookbook"));   
	       // db.addMember(new Member("9919898289","vikram","Android Development Cookbook"));  
	       // db.addMember(new Member("9919898389","udyan","Application Development Cookbook"));  
	     
	      // get all books
	       
	      List<Member> list = db.getAllMembers();
	      
	      int size = list.size();
	     
	        songsListView = (ListView) findViewById(R.id.songsListView);
	        
	        songsArray = new String[size];
	      
	        for(int i=0; i < size; i++){
	        	
	        	songsArray[i] = ("Member:"+(i+1)+"\nName:" + list.get(i).getName()+"\n"+"Phone :" + list.get(i).getPhone_number()+"\nAddress:"+list.get(i).getAddress());
	        }
	     
	        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, songsArray);
	        
	        songsListView.setAdapter(arrayAdapter);
	        
	        
	    }
	    
	 
	 
	 
	 
	 
	 
	 public void addMember(View view) {
	        // Do something in response to button
	    	Intent intent = new Intent(this,NewMember.class);
	        startActivity(intent);
	    }
}
