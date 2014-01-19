package com.example.shg_1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class See extends Activity{
	// Declare the UI components
			private ListView songsListView;
		    // Declare an array to store data to fill the list
			private String[] songsArray ;
			
			private ArrayAdapter<String> arrayAdapter;
			
		    /** Called when the activity is first created. */
		
		 @Override
		    protected void onCreate(Bundle savedInstanceState) {
			 super.onCreate(savedInstanceState);
		        setContentView(R.layout.seeit);
		      
		        songsListView = (ListView) findViewById(R.id.songsListView);
		        
		        songsArray = new String[2];
		        
		        //String [] bakwas=new String["yogi","kanav","lancy","fadu","ghanta"];
		        
		        for(int i=0;i<2;i++)
		       
		        	songsArray[i] = "Transaction: 1 \nFrom: Union Bank \n To : Gaurav  \nAmmount: 5000";
		       
		     
		        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, songsArray);
		        
		        songsListView.setAdapter(arrayAdapter);
		        
		        
		    }
		 
}
