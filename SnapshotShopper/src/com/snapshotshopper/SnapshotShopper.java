//***********************************************************************************
// Copyright (C) 2012  Aya Yakura
//
 /* This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>. */
//
// Contact information:
// email: aya2@pdx.edu

//Portions of this page are modifications based on work created and shared by 
//the Android Open Source Project and used according to terms described in the 
//Creative Commons 2.5 Attribution License. 
//***********************************************************************************

package com.snapshotshopper;

import java.util.ArrayList;

import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.support.v4.app.NavUtils;

public class SnapshotShopper extends Activity {
	//public constant for the next activity to query the extra data
	public final static String EXTRA_MESSAGE = "com.snapshotshopper.MESSAGE";
	
	//Intent intent = new Intent(this, DisplayMessageActivity.class);
	//EditText editText = (EditText) findViewById(R.id.edit_message);
	//String message = editText.getText().toString();
	//intent.putExtra(EXTRA_MESSAGE, message);
	//startActivity(intent);listItems contains the items for the list

        ArrayList<String> ShoppingListItems = new ArrayList<String>();
        //make a string adapter for notifying list got changed
        ArrayAdapter<String> listAdapter;
        //int dummy = 1;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snapshot_shopper);
        
        ListView ShoppingListView = (ListView)findViewById(R.id.ShoppingList);
        
      //**************************************************************************************************
      //Modified from following source:
      //Source: http://stackoverflow.com/questions/454075enteredText.;4/add-dynamically-elements-to-a-listview-android
      //Author: Shardul
      //Author's profile page: http://stackoverflow.com/users/514553/shardul
        listAdapter = new ArrayAdapter<String>(this,
        		android.R.layout.simple_list_item_multiple_choice, ShoppingListItems);
        ShoppingListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        ShoppingListView.setItemsCanFocus(false);
        ShoppingListView.setAdapter(listAdapter);
        
        
        	//**************************************************************************************************
        	//Modified from following source:
        	//Source: http://stackoverflow.com/questions/6205808/how-to-handle-long-tap-on-listview-item
            //Author: Aleadam
        	//Author's profile page: http://stackoverflow.com/users/542701/aleadam
        	ShoppingListView.setOnItemLongClickListener(new OnItemLongClickListener(){
        		public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        			String dummy = "edit item entry here";
        			takePicture(view, dummy);
        			return false;
        		}
        	});
        	//**************************************************************************************************

      //**************************************************************************************************
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_snapshot_shopper, menu);
        return true;
    }
    
//**************************************************************************************************
//called when the user clicks the Send button
//Add the item to the list when the button is clicked  
//Modified from following source:
//Source: http://stackoverflow.com/questions/4540754/add-dynamically-elements-to-a-listview-android
//Author: Shardul
//Author's profile page: http://stackoverflow.com/users/514553/shardul

    public void addToList(View view){
    	
    	//to use the textbox
    	EditText enteredText = (EditText) findViewById(R.id.edit_message);
    	//holds the entry by the user
    	String entry = "";
    	entry = enteredText.getText().toString(); //get the text entered	
    		
    	//if the text box was not empty
    	if (!entry.equals("") && !entry.equals("\n")){ //if the entry is not empty or a newline
    		ShoppingListItems.add(entry);
    		//notify that list got updated so it can refresh the list on screen
    		listAdapter.notifyDataSetChanged();
    		enteredText.setText(""); //clear the text box after updating the list
    	}
    	
    }
//**************************************************************************************************
    
//**************************************************************************************************
    //clear the list when user clicks the Clear List button
    //Alerts the user with a confirmation window before clearing the list.
    //Modified from the following source:
    //Source: http://stackoverflow.com/questions/5127407/android-preference-confirm-dialog
    //Author: Maaalte
    //Author's profile page: http://stackoverflow.com/users/453895/maaalte
    public void clearList(View view){
    	new AlertDialog.Builder(this)
    		.setMessage("Do you really want to clear this list?")
    		.setTitle("Confirmation")
    		.setIcon(android.R.drawable.ic_dialog_alert)
    		.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener(){
    			public void onClick(DialogInterface dialog, int button){
    				//clear list
    				ShoppingListItems.clear();
    				//notify that list got updated so it can refresh the list on screen
    				listAdapter.notifyDataSetChanged();
    				}
    			})
    			.setNegativeButton(android.R.string.no, null).show(); 	
    }
//**************************************************************************************************
    
    //Calls a new activity for adding in a picture.
    public void takePicture(View view, String entry){
    	Intent intent = new Intent(this, EditItemEntry.class);
    	
    	intent.putExtra(EXTRA_MESSAGE, entry);
    	startActivity(intent); //start the new activity
    }
    
    
    //Calls the camera to take pictures before adding item to list
    public void callCamera (View view){
    	//Call the camera
    	Intent cameraintent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    	startActivityForResult(cameraintent, 0);
    }

}

