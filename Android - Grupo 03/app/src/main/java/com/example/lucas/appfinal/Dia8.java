package com.example.lucas.appfinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


public class Dia8 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dia8);

        LinearLayout segundo = (LinearLayout) findViewById(R.id.evento2);

        segundo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), Banana.class);
                startActivity(i);

            }
        });

        LinearLayout terceiro = (LinearLayout) findViewById(R.id.evento3);

        terceiro.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), Genin.class);
                startActivity(i);

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dia8, menu);
        return true;
    }
    public void Dia6(View v) {
// do something when the button is clicked
        Button button=(Button) v;
        startActivity(new Intent(getApplicationContext(), Eventos.class));
    }
    public void Dia9(View v) {
// do something when the button is clicked
        Button button=(Button) v;
        startActivity(new Intent(getApplicationContext(), Dia9.class));
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
