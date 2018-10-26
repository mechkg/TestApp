package com.xrbpowered.testapp;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

	public static final String EXTRA_MESSAGE = "com.xrbpowered.testapp.MESSAGE";
	public static final String KEY_EDIT_TEXT = "editText";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(myToolbar);

		Log.w("TEST", "onCreate");
	}

	public void sendMessage(View view) {
		Intent intent = new Intent(this, DisplayMessageActivity.class);
		EditText editText = (EditText) findViewById(R.id.editText);
		String message = editText.getText().toString();
		intent.putExtra(EXTRA_MESSAGE, message);
		startActivity(intent);
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		savedInstanceState.putString(KEY_EDIT_TEXT, ((EditText) findViewById(R.id.editText)).getText().toString());
		super.onSaveInstanceState(savedInstanceState);
		Log.w("TEST", "onSaveInstanceState");
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		((EditText) findViewById(R.id.editText)).setText(savedInstanceState.getString(KEY_EDIT_TEXT, getString(R.string.edit_message)));
		Log.w("TEST", savedInstanceState.getString(KEY_EDIT_TEXT, "--- no value ---"));
	}
}
