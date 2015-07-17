package br.com.luiz.AgendaFCCDA_01;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import Adapters.GmailSender;


public class inf_promocao extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inf_promocao);
      //  ActionBar actionBar = this.getActionBar();
      //  actionBar.setDisplayHomeAsUpEnabled(true);

        String detalhe = "";
        String nome = "";


        Intent intent = getIntent();
        if (null != intent) {
            detalhe = intent.getStringExtra("teste");
            nome = intent.getStringExtra("teste1");

        }
        Typeface my_Fonte = Typeface.createFromAsset(this.getAssets(), "fonts/fonte1.ttf");
        TextView txt1 = (TextView) findViewById(R.id.detalhe_promocao_tv);
        txt1.setText(detalhe);
        TextView txt3 = (TextView) findViewById(R.id.titulo_promocao);
        txt3.setText(nome);
        txt3.setTypeface(my_Fonte);
        final EditText email=(EditText)findViewById(R.id.edt_email);
       // msg = (EditText)findViewById(R.id.edt_email);
      final Button sendBtn = (Button)findViewById(R.id.cadastro);
        final Button limpa = (Button)findViewById(R.id.limpa_texto);
        limpa.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                email.setText("");

            }
        });

       /* sendBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Properties props = new Properties();
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.socketFactory.port", "465");
                props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.port", "465");

                Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("luizotavionunes@gmail.com", "Pdcszndn882941.");
                    }
                });

                try {
                    MimeMessage message = new MimeMessage(session);
                    message.setFrom(new InternetAddress("luizotavionunes@gmail.com"));
                    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("luizotavionunes@gmail.com"));
                    message.setSubject("Testing Subject");
                    message.setContent("Hi Dipak Keshariya (Android Developer)", "text/html; charset=utf-8");

                    Transport.send(message);

                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }
            }
        });*/



       // sub = nome;
        sendBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                final GmailSender sender = new GmailSender("luizotavionunes@gmail.com",       "pass");
                new AsyncTask<Void, Void, Void>() {
                    @Override public Void doInBackground(Void... arg) {
                        try {
                            sender.sendMail("This is Subject",
                                    "This is Body",
                                    "luizotavionunes@gmail.com",
                                    "luizotavionunes@gmail.com");
                            Log.i("Status", "funcionando carai");
                        } catch (Exception e) {
                            Log.i("Status", "Not Working");
                            Log.e("SendMail", e.getMessage(), e);
                        }
                        return null;}
                }.execute();
            }
        });

    }



    /*
    *
    *                 final GmailSender sender = new GmailSender("luizotavionunes@gmail.com",       "pass");
                new AsyncTask<Void, Void, Void>() {
                    @Override public Void doInBackground(Void... arg) {
                        try {
                            sender.sendMail("This is Subject",
                                    "This is Body",
                                    "luizotavionunes@gmail.com",
                                    "luizotavionunes@gmail.com");
                       Log.i("Status", "funcionando carai");
                } catch (Exception e) {
                    Log.i("Status", "Not Working");
                    Log.e("SendMail", e.getMessage(), e);
                        }
                        return null;}
                }.execute();
    *
    * */

    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inf_promocao, menu);
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
