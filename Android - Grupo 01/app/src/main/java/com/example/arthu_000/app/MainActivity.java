package com.example.arthu_000.app;


import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.URI;
import java.util.ArrayList;

import android.graphics.Color;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.example.arthu_000.app.ItemListView;
import com.google.gson.Gson;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {
    private ListView listView;
    private AdapterListView adapterListView;
    private ArrayList<ItemListView> itens;
    private ArrayList<EventListView> ObjetoEventos;
    private ArrayList<Data> data;
    private int id;
    private int s;
    private Datas retorno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*ConnectivityManager conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        if (conMgr.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED
                || conMgr.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTING) {
            getJson();*/
        // notify user you are online

        //  }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list);
        listView.setOnItemClickListener(this);
        s=0;
        getJson();
        while(s==0){
           int a=1;
        }
        createListView();

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
            Intent troca = new Intent(MainActivity.this, Sobre.class);
            MainActivity.this.startActivity(troca);
        }
        if (id == R.id.pesquisa) {
            Intent troca = new Intent(MainActivity.this, Pesquisa.class);
            MainActivity.this.startActivity(troca);
        }

        return super.onOptionsItemSelected(item);
    }


    private void getJson() {

        new Thread(new Runnable() {
            @Override
            public void run() {


                try {
                    HttpClient httpclient = new DefaultHttpClient();

                    HttpGet request = new HttpGet();

                    request.setURI(new URI("http://eco044.net84.net/arquivo.json"));
                    HttpResponse response = httpclient.execute(request);
                    HttpEntity entity = response.getEntity();

                    InputStream content = entity.getContent();

                    byte[] bytes = new byte[1024];
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    int lidos;
                    while ((lidos = content.read(bytes)) > 0) {
                        baos.write(bytes, 0, lidos);
                    }
                    String reader = new String(baos.toByteArray());


                    Gson gson = new Gson();
                    save(reader.toString(), "arquivo.json");
                    retorno = gson.fromJson(reader, Datas.class);
                    Log.e("tag", retorno.getDatas().toString());
                    s=1;
                    content.close();

                } catch (Exception e) {
                    s=1;
                    Gson gson = new Gson();
                    String reader = load("arquivo.json");
                    retorno = gson.fromJson(reader, Datas.class);

                }
            }

        }).start();

    }

    private void save(String content, String fileName) {
        FileOutputStream fos = null;
        Writer out = null;
        try {
            File file = new File(getAppRootDir(), fileName);
            fos = new FileOutputStream(file);
            out = new OutputStreamWriter(fos, "UTF-8");

            out.write(content);
            out.flush();
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ignored) {
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException ignored) {
                }
            }
        }
    }

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


    private void createListView() {
        //Criamos nossa lista que preenchera o ListView
        itens = new ArrayList<ItemListView>();

        Calendar hoje = Calendar.getInstance();
        int atual=hoje.getTime().getYear()*10000+hoje.getTime().getMonth()*100+hoje.getTime().getDay();
        if (retorno != null)
            for (Data item : retorno.getDatas()) {
                ItemListView item1 = new ItemListView(item.dataToString(), R.drawable.nova, item.getData());
                if(item.getData()>=atual)
                    itens.add(item1);

            }


        //Cria o adapter
        adapterListView = new AdapterListView(this, itens);

        //Define o Adapter
        listView.setAdapter(adapterListView);
        //Cor quando a lista é selecionada para ralagem.
        listView.setCacheColorHint(Color.CYAN);
    }

    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        //Pega o item que foi selecionado.
        //DemostraçãoIntent troca = new
        int dat = itens.get(arg2).getId();
        Log.e("Tag1",""+dat);
        Intent troca = new Intent(MainActivity.this, Eventos.class);
        troca.putExtra("data", dat);
        MainActivity.this.startActivity(troca);
    }

}
