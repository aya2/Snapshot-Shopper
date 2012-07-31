package com.snapshotshopper;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.support.v4.app.NavUtils;

public class SnapshotShopper extends Activity {
	//public constant for the next activity to query the extra data
	public final static String EXTRA_MESSAGE = "com.snapshotshopper.MESSAGE";
	
	//ShoppingListItems contains the items for the list
        ArrayList<String> ShoppingListItems = new ArrayList<String>();
        //make a string adapter for notifying list got changed
        ArrayAdapter<String> listAdapter;
        int dummy = 1;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snapshot_shopper);
        
        ListView ShoppingListView = (ListView)findViewById(R.id.ShoppingList);
        
        listAdapter = new ArrayAdapter<String>(this,
        		android.R.layout.simple_list_item_multiple_choice, ShoppingListItems);
        ShoppingListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        ShoppingListView.setItemsCanFocus(false);
        ShoppingListView.setAdapter(listAdapter);
        
        
//        ShoppingListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View view,
//                    int position, long id) {
//            	sendMessage(view);
//            }
//
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_snapshot_shopper, menu);
        return true;
    }
    

//    called when the user clicks the Send button
//Add the item to the list when the button is clicked    
    public void addToList(View view){
    	//Intent intent = new Intent(this, DisplayMessageActivity.class);
    	//EditText editText = (EditText) findViewById(R.id.edit_message);
    	//String message = editText.getText().toString();
    	//intent.putExtra(EXTRA_MESSAGE, message);
    	//startActivity(intent);

    	//to use the textbox
    	EditText enteredText = (EditText) findViewById(R.id.edit_message);
    	//holds the entry by the user
    	String entry = "";
    	entry = enteredText.getText().toString(); //get the text entered
    	//if the text box was not empty
    	if (!entry.equals("") && !entry.equals("\n")){
    		ShoppingListItems.add(entry);
    		//notify that list got updated so it can refresh the list on screen
    		listAdapter.notifyDataSetChanged();
    	}
    	

    	//clear the text box so the user can enter another item
    	//findViewById(R.id.edit_message)
    }
    
    //clear the list when user clicks the Clear List button
    public void clearList(View view){
    	//clear list
    	ShoppingListItems.clear();
    	//notify that list got updated so it can refresh the list on screen
    	listAdapter.notifyDataSetChanged();
    }
}

