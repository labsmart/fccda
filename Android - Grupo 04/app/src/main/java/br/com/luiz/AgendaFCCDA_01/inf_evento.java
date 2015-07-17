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


public class inf_evento extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inf_evento);
      //  ActionBar actionBar = this.getActionBar();
        //actionBar.setDisplayHomeAsUpEnabled(true);



        String nome = "";
        // int [] imagem;
        String local = "";
        String hora = "";
        String valor = "";
        String informacoes = "";
        String vagas = "";
        int id = 0;

        Intent intent = getIntent();
        int imagem = 0;
        if (null != intent) {
            id = intent.getIntExtra("id", id);
            nome = intent.getStringExtra("nome");
            informacoes = intent.getStringExtra("informacoes");
            imagem = intent.getIntExtra("imagem", imagem);
            local = intent.getStringExtra("local");
            hora = intent.getStringExtra("hora");
            valor = intent.getStringExtra("valor");
            vagas = intent.getStringExtra("vagas");

        }


        String data = informacoes;
        String text = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">"
                + "<html>  <head>  <meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\">"
                + "</head>  <body>";
        String FOOTERHTML = "<html><body style=\"text-align:justify\">  </body></Html>";

        Typeface my_Fonte = Typeface.createFromAsset(this.getAssets(), "fonts/fonte1.ttf");
        TextView txt1 = (TextView) findViewById(R.id.titulo_evento);
        txt1.setText(nome);
        txt1.setTypeface(my_Fonte);


        ImageView img1 = (ImageView) findViewById(R.id.imagemEvento);
        img1.setImageResource(imagem);

        WebView txt2 = (WebView) findViewById(R.id.inf_evento);
        txt2.loadData(text + data + FOOTERHTML, "text/html; charset=UTF-8", null);


        TextView inf_textView33 = (TextView) findViewById(R.id.textView8);
        inf_textView33.setText(local);

        TextView inf_textView44 = (TextView) findViewById(R.id.textView10);
        inf_textView44.setText(hora);

        TextView textView66 = (TextView) findViewById(R.id.textView12);
        textView66.setText(vagas);

        TextView textView77 = (TextView) findViewById(R.id.textView14);
        textView77.setText(valor);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inf_evento, menu);
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
