package br.com.luiz.AgendaFCCDA_01;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.TextView;


public class SobreActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);
       // ActionBar actionBar = this.getActionBar();
       // actionBar.setDisplayHomeAsUpEnabled(true);

        String data = getApplication().getString(R.string.sobre_inf_fccda);
        String text = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">"
                + "<html>  <head>  <meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\">"
                + "</head>  <body>";
        String FOOTERHTML = "<html><body style=\"text-align:justify\">  </body></Html>";
        WebView txt2 = (WebView) findViewById(R.id.web2);
        txt2.loadData(text + data + FOOTERHTML, "text/html; charset=UTF-8", null);
        Typeface my_Fonte = Typeface.createFromAsset(this.getAssets(), "fonts/fonte1.ttf");
        TextView txt1 = (TextView) findViewById(R.id.sobre_titulo);
        txt1.setText(" Sobre o Aplicativo ");
        txt1.setTypeface(my_Fonte);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sobre, menu);
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
