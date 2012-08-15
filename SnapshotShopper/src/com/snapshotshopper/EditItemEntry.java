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

//Modified from Android Training tutorial on
// http://developer.android.com/training/basics/firstapp/starting-activity.html


package com.snapshotshopper;

import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class EditItemEntry extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item_entry);
        //getActionBar().setDisplayHomeAsUpEnabled(true);
        
        //Get message from intent
        Intent intent = getIntent();
        String message = intent.getStringExtra(SnapshotShopper.EXTRA_MESSAGE);
        
        //create the text view
        //TextView textView = new TextView(this);
        //textView.setTextSize(24);
        //textView.setText(message);
        
        //set text in textbox
        EditText editText = (EditText) findViewById(R.id.edit_item_name);
        editText.setText(message);
        
        //change the text in list
        EditText enteredText = (EditText) findViewById(R.id.edit_message);
        //enteredText.setText("oranges");
        
    }

    public void callCamera (View view){
    	//Call the camera
    	Intent cameraintent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    	startActivityForResult(cameraintent, 0);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_add_new_item, menu);
        return true;
    }

    
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                NavUtils.navigateUpFromSameTask(this);
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    

}
