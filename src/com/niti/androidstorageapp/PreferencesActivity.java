package com.niti.androidstorageapp;

import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PreferencesActivity extends Activity {

	Button mClose;
	Button mSaveButton;
	EditText mBookNameInput;
	EditText mBookAuthorInput;
	EditText mDescriptionInput;
	public static final String BOOK_AUTHOR = "book_author";
	public static final String BOOK_NAME = "book_name";
	public static final String BOOK_DESCRIPTION = "book_description";
	public static final String COUNTER = "counter";
	public static int counter = 1;
	private SharedPreferences mPrefs;
	
	public static final String PREFS_NAME = "PreferencesFile";
	public static final String MESSAGE = "message";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mPrefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
		setContentView(R.layout.activity_preferences);
		mBookAuthorInput = (EditText) findViewById(R.id.bookauthor_edit);
		mBookNameInput = (EditText) findViewById(R.id.bookname_edit);
		mDescriptionInput = (EditText) findViewById(R.id.book_description);
		mClose = (Button) findViewById(R.id.close_preference);
		mClose.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				PreferencesActivity.this.finish();
				
			}
		});
		
		mSaveButton = (Button) findViewById(R.id.save);
		mSaveButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				SharedPreferences.Editor editor = mPrefs.edit();
				
				editor.putString(BOOK_NAME, mBookNameInput.getText().toString());
				editor.putString(BOOK_AUTHOR, mBookAuthorInput.getText().toString());
				editor.putString(BOOK_DESCRIPTION, mDescriptionInput.getText().toString());
				editor.putInt(COUNTER, counter);
				editor.commit();
				
				Toast.makeText(getBaseContext(), "Saved Successfully!", Toast.LENGTH_SHORT).show();
				
				Intent resultIntent = new Intent();
				resultIntent.putExtra(MESSAGE, "Save Preference " + counter + ", " + 
				    java.text.DateFormat.getDateTimeInstance().format(new Date()));
				setResult(Activity.RESULT_OK, resultIntent);
				counter++;
				finish();
				
			}
		});
		
		
	}
}
