package br.com.luiz.AgendaFCCDA_01;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import Adapters.ListaAdapterPromocao;
import Classes.Promocao;


public class PromocoesActivity extends Activity {

    String tableName = "promocoes";
    Cursor promocoes;
    private static String DB_PATH = "/data/data/br.com.luiz.AgendaFCCDA_01/databases/";
    private SQLiteDatabase myDataBase1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promocoes);
       // ActionBar actionBar = this.getActionBar();
       // actionBar.setDisplayHomeAsUpEnabled(true);

        ArrayList<Promocao> lista1 = new ArrayList<Promocao>();


        try {
            String myPath = DB_PATH + "bd_test.sqlite";
            myDataBase1 = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

        } catch (Exception e) {
            throw new Error("Unable to create database");
        }
        promocoes = myDataBase1.rawQuery("SELECT * FROM " + tableName, null);

        int col1 = promocoes.getColumnIndex("_id");
        int col2 = promocoes.getColumnIndex("nome");
        int col3 = promocoes.getColumnIndex("descricao");
        int col4 = promocoes.getColumnIndex("detalhe");
        int col5 = promocoes.getColumnIndex("imagem");


        if (promocoes != null) {
            promocoes.moveToFirst();


            while (promocoes.moveToNext()) {
                Promocao promo = new Promocao();
                promo.set_id(promocoes.getInt(col1));
                promo.setNome(promocoes.getString(col2));
                promo.setDescricao(promocoes.getString(col3));
                promo.setDetalhe(promocoes.getString(col4));
                promo.setImagem(promocoes.getString(col5));

                lista1.add(promo);

            }

            myDataBase1.close();
        }


        final ListaAdapterPromocao adapterPromocao = new ListaAdapterPromocao(this, lista1);
        ListView listView = (ListView) findViewById(R.id.lista_promocao);

        listView.setAdapter(adapterPromocao);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Promocao item = (Promocao) adapterPromocao.getItem(position);
                Intent extras = new Intent(getApplicationContext(), inf_promocao.class);
                extras.putExtra("teste", item.getDetalhe());
                extras.putExtra("teste1", item.getNome());

                startActivity(extras);

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_promocoes, menu);
        return true;
    }


    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
