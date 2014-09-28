package com.niti.androidstorageapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SqlActivity extends Activity {
	Button mClose;
	private Button mSaveButton;
	private EditText mMessageInput;
	private SqlDatabaseHelper mDatabaseHelper;
	public static final String MESSAGE = "message";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		mDatabaseHelper = new SqlDatabaseHelper(this);
		setContentView(R.layout.activity_sql);
		mClose = (Button) findViewById(R.id.close_sql);
		mClose.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				SqlActivity.this.finish();
				
			}
		});
		mMessageInput = (EditText) findViewById(R.id.blog_text);
		mSaveButton = (Button) findViewById(R.id.save);
		mSaveButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Blog blog = new Blog();
				blog.setMessage(mMessageInput.getText().toString());
				blog.setId(mDatabaseHelper.insertBlog(blog));
				Toast.makeText(getBaseContext(), "Saved Successfully!", Toast.LENGTH_SHORT).show();
				
				Intent resultIntent = new Intent();
				resultIntent.putExtra(MESSAGE, "SQLite " + blog.getId() + ", " + 
				    java.text.DateFormat.getDateTimeInstance().format(blog.getDate()));
				setResult(Activity.RESULT_OK, resultIntent);
				finish();
			}
		});
	}
	
}
