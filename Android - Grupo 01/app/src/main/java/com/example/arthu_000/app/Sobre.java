package com.example.arthu_000.app;

/**
 * Created by arthu_000 on 13/05/2015.
 */

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import android.widget.LinearLayout;
import android.widget.ListView;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Sobre extends ActionBarActivity  {

    private ListView listView;
    private AdapterListViewEventos adapterListView;
    private ArrayList<EventListView> itens;
    private ArrayList<EventListView> eventos;

    @Override
    public void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        //carrega o layout onde contem o ListView
        setContentView(R.layout.sobre);
        WebView view = new WebView(this);
        view.setVerticalScrollBarEnabled(false);

        view = (WebView) findViewById(R.id.webView);
        view.getSettings().setDefaultTextEncodingName("utf-8");
        view.setBackgroundColor(0xFF505050);

        view.loadDataWithBaseURL(null, getString(R.string.Sobre), "text/html", "UTF-8", null);
        //Pega a referencia do ListView
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.calendario) {
            Intent troca = new Intent(Sobre.this, MainActivity.class);
            Sobre.this.startActivity(troca);
        }
        if (id == R.id.fundacao) {
            return true;
        }
        if (id == R.id.pesquisa) {
            Intent troca = new Intent(Sobre.this, Pesquisa.class);
            Sobre.this.startActivity(troca);
        }

        return super.onOptionsItemSelected(item);
    }
}
