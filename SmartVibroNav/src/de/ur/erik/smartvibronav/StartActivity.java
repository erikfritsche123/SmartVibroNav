package de.ur.erik.smartvibronav;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StartActivity extends ActionBarActivity {
	
	private String testNummerString;
	private String nameString;
	private String alterString;
	private String routeString;
	private String modusString;
	
	private EditText testNummer;
	private EditText name;
	private EditText alter;
	private EditText route;
	private EditText modus;
	
	private Button start;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		
		testNummer = (EditText) findViewById(R.id.txtNummer);
		name = (EditText) findViewById(R.id.txtName);
		alter = (EditText) findViewById(R.id.txtAlter);
		route = (EditText) findViewById(R.id.txtRoute);
		modus = (EditText) findViewById(R.id.txtModus);
		
		start = (Button) findViewById(R.id.buttonStart);
		
		start.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				collectInformation();
				startCorrectNavigationActivity(modusString);
				
			}

			private void collectInformation() {
				testNummerString = testNummer.getText().toString();
				nameString = name.getText().toString();
				alterString = alter.getText().toString();
				modusString= modus.getText().toString();
				routeString= route.getText().toString();
				
			}

			private void startCorrectNavigationActivity(String modus) {
				Log.d(modus, "inStartCorrectNavigationActivity");
				if (modus.equals("1")){
					Log.d(modus, "in Kompass");
					Intent intent = new Intent (StartActivity.this, KompassActivity.class);
					addExtras(intent);
					startActivity(intent);
				}else if(modus.equals("2")){
					Log.d(modus, "in Route");
					Intent intent = new Intent (StartActivity.this, RouteActivity.class);
					addExtras(intent);
					startActivity(intent);
				}else if (modus.equals("3")){
					Log.d(modus, "in Karte");
					Intent intent = new Intent (StartActivity.this, MapActivity.class);
					addExtras(intent);
					startActivity(intent);
				}else {
					Context context = getApplicationContext();
					CharSequence text = "Modus inkorrekt!";
					int duration = Toast.LENGTH_LONG;

					Toast toast = Toast.makeText(context, text, duration);
					toast.show();
				}
				return;
			}

			private void addExtras(Intent intent) {
				intent.putExtra("Nummer", testNummerString);
				intent.putExtra("Name", nameString);
				intent.putExtra("Alter", alterString);
				intent.putExtra("Route", routeString);
				intent.putExtra("Modus", modusString);
				
			}
		});
		
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	
}
