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

import Adapters.ListaAdapterEventos;
import Classes.PontoCultural;


public class PontosCulturaisActivity extends Activity {

    String tableName="pontos_culturais";
    Cursor pontos_culturais;
    private static String DB_PATH = "/data/data/br.com.luiz.AgendaFCCDA_01/databases/";
    private SQLiteDatabase myDataBase1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pontos_culturais);
       // ActionBar actionBar = this.getActionBar();
        //actionBar.setDisplayHomeAsUpEnabled(true);

        ListView expListView = (ListView) findViewById(R.id.lista_ponto);

        ArrayList<PontoCultural> lista2 = new ArrayList<PontoCultural>();




        try {
            String myPath = DB_PATH + "bd_test.sqlite";
            myDataBase1 = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

        }catch (Exception e) {
            throw new Error("Unable to create database");
        }
        pontos_culturais = myDataBase1.rawQuery("SELECT * FROM " + tableName,null);

        int col1 = pontos_culturais.getColumnIndex("_id_pc");
        int col2 = pontos_culturais.getColumnIndex("nome");
        int col3 = pontos_culturais.getColumnIndex("telefone");
        int col4 = pontos_culturais.getColumnIndex("local");
        int col5 = pontos_culturais.getColumnIndex("horario");
        int col6 = pontos_culturais.getColumnIndex("imagem");
        int col7 = pontos_culturais.getColumnIndex("imagem1");
        int col8 = pontos_culturais.getColumnIndex("detalhes");

        if (pontos_culturais != null) {
            pontos_culturais.moveToFirst();


            while (pontos_culturais.moveToNext()) {
                PontoCultural ponto_cultural = new PontoCultural();
                ponto_cultural.set_id_pc(pontos_culturais.getInt(col1));
                ponto_cultural.setNome(pontos_culturais.getString(col2));
                ponto_cultural.setTelefone(pontos_culturais.getString(col3));
                ponto_cultural.setLocal(pontos_culturais.getString(col4));
                ponto_cultural.setHorario(pontos_culturais.getString(col5));
                ponto_cultural.setImagem(pontos_culturais.getString(col6));
                ponto_cultural.setImagem1(pontos_culturais.getString(col7));
                ponto_cultural.setDetalhe(pontos_culturais.getString(col8));
                lista2.add(ponto_cultural);

            }


            myDataBase1.close();
        }




        final ListaAdapterEventos.ListaAdapterPonto adapterPonto  = new ListaAdapterEventos.ListaAdapterPonto(this,lista2);
        expListView.setAdapter(adapterPonto);


        expListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                PontoCultural item = (PontoCultural) adapterPonto.getItem(position);
                Intent extras = new Intent(getApplicationContext(), inf_ponto_cultural.class);
                String mDrawableName = item.getImagem1();
                int auxImg = getApplication().getResources().getIdentifier(mDrawableName , "drawable", getApplication().getPackageName());
                extras.putExtra("teste", item.getNome());
                extras.putExtra("teste1", item.getDetalhe());
                extras.putExtra("teste2", auxImg);

                startActivity(extras);


            }
        });

    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pontos_culturais, menu);
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
