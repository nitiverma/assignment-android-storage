package com.niti.androidstorageapp;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	Button mClose;
	Button mSqllite;
	Button mPreferences;
	private TextView mShowResultsTextView;
	public static final String TAG = "MainActivity";
	public static final int SQL_LITE_ACTIVITY = 1;
	public static final int PREFERENCES_ACTIVITY = 2;
	
	@Override 
	public void onActivityResult(int requestCode, int resultCode, Intent data) {     
	  super.onActivityResult(requestCode, resultCode, data); 
	  switch(requestCode) { 
	    case (SQL_LITE_ACTIVITY) : { 
	      if (resultCode == Activity.RESULT_OK) { 
			  String currentText = mShowResultsTextView.getText().toString();
	    	  String newText = data.getStringExtra(SqlActivity.MESSAGE);
			  mShowResultsTextView.setText(currentText + "\n" + newText);	
	      } 
	      break;
	    }
	    case (PREFERENCES_ACTIVITY) : {
	    	if (resultCode == Activity.RESULT_OK) { 
				  String currentText = mShowResultsTextView.getText().toString();
		    	  String newText = data.getStringExtra(PreferencesActivity.MESSAGE);
				  mShowResultsTextView.setText(currentText + "\n" + newText);	
		      } 
		      break;
	    } 
	  } 
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mSqllite = (Button) findViewById(R.id.sqlite);
		mClose = (Button) findViewById(R.id.close);
		mClose.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				MainActivity.this.finish();
				
			}
		});
		mSqllite.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MainActivity.this,SqlActivity.class);
				startActivityForResult(i, SQL_LITE_ACTIVITY);	
			}
		});
		
		mPreferences = (Button) findViewById(R.id.preferences);
		mPreferences.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(MainActivity.this, PreferencesActivity.class);
				startActivityForResult(i, PREFERENCES_ACTIVITY);
				
			}
		});
		mShowResultsTextView = (TextView) findViewById(R.id.show_results);
	}
}
