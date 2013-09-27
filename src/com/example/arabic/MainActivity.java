package com.example.arabic;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText mCharSet;
	private EditText mASet;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mCharSet = (EditText)findViewById(R.id.charset);
		mASet = (EditText)findViewById(R.id.achar);
		mASet.addTextChangedListener(mTextWatcher);
	}

	private TextWatcher mTextWatcher = new TextWatcher() {

		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			// TODO Auto-generated method stub
			if(s!=null&&s.length()>0&&before==1){
				Log.v("onTextChanged", ": " + s.toString()+" "+start+" "+before+" "+count);
				char inputchar = s.charAt(s.length()-1);
				int aint = (int)inputchar;
				if(aint != 32){
					mCharSet.append(String.valueOf(inputchar));
					mCharSet.append(" ");
					mCharSet.append(Integer.toHexString((int)inputchar));
					mCharSet.append("     ");
				}
			}
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			//mASet.setText("");
		}

		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
