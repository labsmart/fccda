package com.example.lucas.appfinal;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public void buttonOnClick(View v) {
// do something when the button is clicked
        Button button=(Button) v;
        startActivity(new Intent(getApplicationContext(), SobreNos.class));
    }
    public void buttonOnClick1(View v) {
// do something when the button is clicked
        Button button=(Button) v;
        startActivity(new Intent(getApplicationContext(), Eventos.class));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(this, "Fernando Takenaka\n" +
                    "Lucas Abritta\n" +
                    "Lucas de Sá\n" +
                    "Rafael José dos Reis Macieiro\n" +
                    "William Araujo Braulio\n", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
