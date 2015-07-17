package com.example.arthu_000.app;

/**
 * Created by arthu_000 on 13/05/2015.
 */

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Pesquisa extends ActionBarActivity {

    private ListView listView;
    private AdapterListViewEventos adapterListView;
    private ArrayList<EventListView> itens;
    private ArrayList<EventListView> eventos;
    private Calendar calendariode = Calendar.getInstance();
    private Calendar calendarioate = Calendar.getInstance();
    private TextView textde ;
    private TextView textate ;
    private ImageView datade ;
    private ImageView dataate;
    private DatePickerDialog.OnDateSetListener date;
    private boolean op = true;
    @Override
    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        //carrega o layout onde contem o ListView
        setContentView(R.layout.pesquisa);
        textde = (TextView) findViewById(R.id.textViewDe);
        textate = (TextView) findViewById(R.id.textViewAte);
        datade = (ImageView) findViewById(R.id.imageViewDe);
        dataate = (ImageView) findViewById(R.id.imageViewAte);
        final CheckBox checkdata = (CheckBox) findViewById(R.id.checkdata);
        final CheckBox checkvalor = (CheckBox) findViewById(R.id.checkValor);
        final CheckBox checkidade = (CheckBox) findViewById(R.id.checkIdade);
        final RadioGroup radiogroup = (RadioGroup) findViewById(R.id.radioGroup);
        final RadioGroup radiogroup2 = (RadioGroup) findViewById(R.id.radioGroup2);
        final Button button = (Button) findViewById(R.id.button);
        
        updateLabel();
        date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                if(op){
                    calendariode.set(Calendar.YEAR, year);
                    calendariode.set(Calendar.MONTH, monthOfYear);
                    calendariode.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                }
                else{
                    calendarioate.set(Calendar.YEAR, year);
                    calendarioate.set(Calendar.MONTH, monthOfYear);
                    calendarioate.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                }
                updateLabel();
            }

        };
        datade.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                op = true;
                // TODO Auto-generated method stub
                new DatePickerDialog(Pesquisa.this, date, calendariode
                        .get(Calendar.YEAR), calendariode.get(Calendar.MONTH),
                        calendariode.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        dataate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                op = false;
                // TODO Auto-generated method stub
                new DatePickerDialog(Pesquisa.this, date, calendarioate
                        .get(Calendar.YEAR), calendarioate.get(Calendar.MONTH),
                        calendarioate.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent troca = new Intent(Pesquisa.this, EventoFiltrado.class);
                int cd = 0, cv = 0, ci = 0,data1=0, data2=0;
                if (checkdata.isChecked())
                    cd = 1;
                if (checkidade.isChecked()) {
                    if(radiogroup.getCheckedRadioButtonId()==R.id.radioButton_L)
                        ci=1;
                    else if(radiogroup.getCheckedRadioButtonId()==R.id.radioButton_10)
                        ci=2;
                    else if(radiogroup.getCheckedRadioButtonId()==R.id.radioButton_12)
                        ci=3;
                    else if(radiogroup.getCheckedRadioButtonId()==R.id.radioButton_14)
                        ci=4;
                    else if(radiogroup.getCheckedRadioButtonId()==R.id.radioButton_16)
                        ci=5;
                }
                if (checkvalor.isChecked()) {
                    if (radiogroup2.getCheckedRadioButtonId() == R.id.radioButton_R0)
                        cv = 1;
                    else if (radiogroup2.getCheckedRadioButtonId() == R.id.radioButton_R10)
                        cv = 2;
                    else if (radiogroup2.getCheckedRadioButtonId() == R.id.radioButton_R20)
                        cv = 3;
                    else if (radiogroup2.getCheckedRadioButtonId() == R.id.radioButton_R50)
                        cv = 4;
                    else if (radiogroup2.getCheckedRadioButtonId() == R.id.radioButton_R100)
                        cv = 5;

                }
                if (checkdata.isChecked()) {
                    data1=calendariode.getTime().getYear()*10000;
                    data1+=calendariode.getTime().getMonth()*100;
                    data1+=calendariode.getTime().getDay();
                    data2=calendarioate.getTime().getYear()*10000;
                    data2+=calendarioate.getTime().getMonth()*100;
                    data2+=calendarioate.getTime().getDay();
                }
                if (checkidade.isChecked() || checkvalor.isChecked() || checkdata.isChecked()) {
                   troca.putExtra("valor_data1", data1);
                   troca.putExtra("valor_data2", data2);
                    troca.putExtra("checkvalor", cv);
                    troca.putExtra("checkidade", ci);
                    Pesquisa.this.startActivity(troca);
                }
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    private void updateLabel() {

        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat);

        if(calendariode.after(calendarioate) && op)
            calendarioate.setTime(calendariode.getTime());
        else if(calendarioate.before(calendariode) && !op)
            calendariode.setTime(calendarioate.getTime());
        textde.setText("De:"+sdf.format(calendariode.getTime()));
        textate.setText("Até:"+sdf.format(calendarioate.getTime()));
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.calendario) {
            Intent troca = new Intent(Pesquisa.this, MainActivity.class);
            Pesquisa.this.startActivity(troca);
        }
        if (id == R.id.fundacao) {
            Intent troca = new Intent(Pesquisa.this, Sobre.class);
            Pesquisa.this.startActivity(troca);
        }
        if (id == R.id.calendario) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
