package com.example.primitiva;

import android.support.v7.app.ActionBarActivity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/*
 * @staruml
 * 
 * 
 */
public class MainActivity extends ActionBarActivity {
	Button btn;
	TextView txV;
	String numeros, n1, n2;
	RadioButton r1, r2;
	RadioGroup rg;
	SharedPreferences sdp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn = (Button) findViewById(R.id.button1);
		txV = (TextView) findViewById(R.id.textView2);
		rg = (RadioGroup) findViewById(R.id.radioGroup1);
		rg.check(R.id.radioSi);
		r1 = (RadioButton) findViewById(R.id.radioSi);
		r2 = (RadioButton) findViewById(R.id.radioNo);
		sdp = getSharedPreferences("preferences", MODE_PRIVATE);

		if (sdp.contains("Val1")) {
			txV.setText(sdp.getString("Val1", ""));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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

	public void pulsaBoton(View v) {
		numeros = Primitiva.getNumeros();
		txV.setText(numeros);
		// guardarDatos();
	}
	
	public void LimpiarCaja(View v) {
		txV.setText("");
		borraDatos();
	}

	private void guardarDatos() {
		if (r1.isChecked() == true) {
			guardaResult();
			Log.i("Main", "Números guardados");
		} else {
			Log.i("Main", "No se guardaron los números");
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		guardarDatos();
	}

	private void guardaResult() {
		Editor edit = sdp.edit();
		edit.putString("Val1", txV.getText().toString());
		edit.commit();
	}

	private void borraDatos() {
		Editor edit = sdp.edit();
		edit.clear();
		edit.commit();
	}

}
