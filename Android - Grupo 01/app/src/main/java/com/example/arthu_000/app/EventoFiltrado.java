package com.example.arthu_000.app;

/**
 * Created by arthu_000 on 12/05/2015.
 */


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

import android.graphics.Color;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import android.widget.ListView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EventoFiltrado extends ActionBarActivity implements OnItemClickListener {
    private String load(String fileName) {
        String res = null;
        File file = new File(getAppRootDir(), fileName);
        if (!file.exists()) {
            Log.e("", "file " + file.getAbsolutePath() + " not found");
            return null;
        }
        FileInputStream fis = null;
        BufferedReader inputReader = null;
        try {
            fis = new FileInputStream(file);
            inputReader = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
            StringBuilder strBuilder = new StringBuilder();
            String line;
            while ((line = inputReader.readLine()) != null) {
                strBuilder.append(line + "\n");
            }
            res = strBuilder.toString();
        } catch (Throwable e) {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ignored) {
                }
            }
            if (inputReader != null) {
                try {
                    inputReader.close();
                } catch (IOException ignored) {
                }
            }
        }
        return res;
    }

    public File getAppRootDir() {
        File appRootDir;
        boolean externalStorageAvailable;
        boolean externalStorageWriteable;
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            externalStorageAvailable = externalStorageWriteable = true;
        } else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            externalStorageAvailable = true;
            externalStorageWriteable = false;
        } else {
            externalStorageAvailable = externalStorageWriteable = false;
        }
        if (externalStorageAvailable && externalStorageWriteable) {
            appRootDir = getExternalFilesDir(null);
        } else {
            appRootDir = getDir("appRootDir", MODE_PRIVATE);
        }
        if (!appRootDir.exists()) {
            appRootDir.mkdir();
        }
        return appRootDir;
    }
    private ListView listView;
    private AdapterListViewEventos adapterListView;
    private ArrayList<EventListView> itens;
    private ArrayList<EventListView> eventos;

    @Override
    public void onCreate(Bundle savedInstanceState) {


        Intent i = getIntent();
        final int data1 = i.getIntExtra("valor_data1", 0);
        final int data2 = i.getIntExtra("valor_data2", 0);
        final int preco = i.getIntExtra("checkvalor", 0);
        final int idade = i.getIntExtra("checkidade", 0);
        super.onCreate(savedInstanceState);
        //carrega o layout onde contem o ListView
        setContentView(R.layout.eventos);

        //Pega a referencia do ListView
        listView = (ListView) findViewById(R.id.list_eventos);
        //Define o Listener quando alguem clicar no item.
        listView.setOnItemClickListener(this);
        createListView(data1,data2,preco,idade);
    }


    private void createListView(int data1,int data2, int preco, int idade) {
        //Criamos nossa lista que preenchera o ListView

        ArrayList<EventListView> itens= new ArrayList<EventListView>();
        Gson gson = new Gson();
        String reader = load("arquivo.json");
        Datas retorno = gson.fromJson(reader, Datas.class);
        for (Data datas : retorno.getDatas())
        if(data1==0 ||  (data1<= datas.getData()&& data2>=datas.getData()))
        for (EventListView item : datas.getEventos()) {
                if(item.getValor()<=preco || preco==0) {
                    if(item.getIconeClass()<=idade || idade==0)
                        itens.add(item);
            }
        }
        //Cria o adapter
        adapterListView = new AdapterListViewEventos(this, itens);

        //Define o Adapter
        listView.setAdapter(adapterListView);
        //Cor quando a lista é selecionada para ralagem.
        listView.setCacheColorHint(Color.TRANSPARENT);
    }

    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {


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
            return true;
        }

        if (id == R.id.fundacao) {
            Intent troca = new Intent(EventoFiltrado.this, Sobre.class);
            EventoFiltrado.this.startActivity(troca);
        }
        if (id == R.id.pesquisa) {
            Intent troca = new Intent(EventoFiltrado.this, Pesquisa.class);
            EventoFiltrado.this.startActivity(troca);
        }
        return super.onOptionsItemSelected(item);
    }

}
