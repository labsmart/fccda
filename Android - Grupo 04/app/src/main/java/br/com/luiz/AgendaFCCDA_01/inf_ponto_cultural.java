package br.com.luiz.AgendaFCCDA_01;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;


public class inf_ponto_cultural extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inf_ponto_cultural);
       // ActionBar actionBar = this.getActionBar();
        //actionBar.setDisplayHomeAsUpEnabled(true);

        String nome = "";

        String detalhes = "";

        Intent intent = getIntent();
        int imagem = 0;
        if (null != intent) {
            nome = intent.getStringExtra("teste");
            detalhes = intent.getStringExtra("teste1");
            imagem = intent.getIntExtra("teste2", imagem);
        }


        String data = detalhes;
        String text = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">"
                + "<html>  <head>  <meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\">"
                + "</head>  <body>";
        String FOOTERHTML = "<html><body style=\"text-align:justify\">  </body></Html>";

        Typeface my_Fonte = Typeface.createFromAsset(this.getAssets(), "fonts/fonte1.ttf");
        TextView txt1 = (TextView) findViewById(R.id.titulo_pc_item);
        txt1.setText(nome);
        txt1.setTypeface(my_Fonte);
        ImageView img1 = (ImageView) findViewById(R.id.imagem_pc_item);
        img1.setImageResource(imagem);
        WebView txt2 = (WebView) findViewById(R.id.detalhe_pc_item);
        txt2.loadData(text + data + FOOTERHTML, "text/html; charset=UTF-8", null);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inf_ponto_cultural, menu);
        return true;
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
