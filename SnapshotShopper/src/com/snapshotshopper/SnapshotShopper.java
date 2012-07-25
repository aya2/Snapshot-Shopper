package com.snapshotshopper;

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
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snapshot_shopper);
        
        String[] ShoppingListItems={"apple", "pear", "grape", "chicken", "milk"};
        
        ListView ShoppingListView = (ListView)findViewById(R.id.ShoppingList);
        
        ShoppingListView.setAdapter(new ArrayAdapter<String>(this,
        		android.R.layout.simple_list_item_multiple_choice, ShoppingListItems));
        ShoppingListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        ShoppingListView.setItemsCanFocus(false);
        
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
    public void sendMessage(View view){
    	//Do something in response to button
    	Intent intent = new Intent(this, DisplayMessageActivity.class);
    	EditText editText = (EditText) findViewById(R.id.edit_message);
    	String message = editText.getText().toString();
    	intent.putExtra(EXTRA_MESSAGE, message);
    	startActivity(intent);
    }
}

