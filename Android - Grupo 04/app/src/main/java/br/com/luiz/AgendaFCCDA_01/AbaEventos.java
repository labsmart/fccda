package br.com.luiz.AgendaFCCDA_01;

import android.annotation.TargetApi;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import Adapters.ListaAdapterEventos;
import BdAdapters.Util;
import Classes.Eventos;


public class AbaEventos extends Fragment {

    String tableName = "eventos";
    Cursor eventos;
    private static String DB_PATH = "/data/data/br.com.luiz.AgendaFCCDA_01/databases/";
    private SQLiteDatabase myDataBase;
    private EditText editTextFilter;
    final ArrayList<Eventos> lista = new ArrayList<Eventos>();
    final ArrayList<Eventos> lista_bkp = new ArrayList<Eventos>();


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.activity_abaeventos, container,
                false);




        Typeface my_Fonte = Typeface.createFromAsset(this.getActivity().getAssets(), "fonts/fonte1.ttf");

        TextView txt_fest = (TextView) rootView.findViewById(R.id.titulo_festival_inverno);
        txt_fest.setTypeface(my_Fonte);

        final ListaAdapterEventos adapterEventos = new ListaAdapterEventos(getActivity(), (ArrayList<Eventos>) lista);

        Util.copiaBanco(getActivity(), "bd_test.sqlite");

        try {
            String myPath = DB_PATH + "bd_test.sqlite";
            myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

        } catch (Exception e) {
            throw new Error("Unable to create database");
        }
        eventos = myDataBase.rawQuery("SELECT * FROM " + tableName, null);

        int col1 = eventos.getColumnIndex("_id");
        int col2 = eventos.getColumnIndex("nome");
        int col3 = eventos.getColumnIndex("data_escrita");
        int col4 = eventos.getColumnIndex("faixa_etaria");
        int col5 = eventos.getColumnIndex("local");
        int col6 = eventos.getColumnIndex("hora");
        int col7 = eventos.getColumnIndex("informacoes");
        int col8 = eventos.getColumnIndex("vagas");
        int col9 = eventos.getColumnIndex("valor");
        int col10 = eventos.getColumnIndex("categoria");
        int col11 = eventos.getColumnIndex("data");
        int col12 = eventos.getColumnIndex("imagem");

        if (eventos != null) {
            eventos.moveToFirst();
            while (eventos.moveToNext()) {
                Eventos evento = new Eventos();
                evento.setId(eventos.getInt(col1));
                evento.setNome(eventos.getString(col2));
                evento.setData_escrita(eventos.getString(col3));
                evento.setFaixa_etaria(eventos.getString(col4));
                evento.setLocal(eventos.getString(col5));
                evento.setHora(eventos.getString(col6));
                evento.setInformacoes(eventos.getString(col7));
                evento.setVagas(eventos.getString(col8));
                evento.setValor(eventos.getString(col9));
                evento.setCategoria(eventos.getString(col10));
                evento.setData(eventos.getString(col11));
                evento.setImagem(eventos.getString(col12));
                lista.add(evento);
            }
            myDataBase.close();
        }

        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date data_atual = new Date();
         df.format(data_atual);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date convertedDate = new Date();



        for(int i=0;i<lista.size();i++) {
            try {
                convertedDate = dateFormat.parse(lista.get(i).getData());
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
                if (data_atual.after(convertedDate)) {
                    lista.remove(i);
                }
        }

        Collections.sort(lista, new Comparator<Eventos>() {
            public int compare(Eventos s1, Eventos s2) {
                return s1.getData().compareToIgnoreCase(s2.getData());
            }
        });
        lista.addAll(lista_bkp);

        final ListView listView = (ListView) rootView.findViewById(R.id.lista_evento);
        listView.setAdapter(adapterEventos);

        editTextFilter = (EditText) rootView.findViewById(R.id.edit_text_texto);

        editTextFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                //quando o texto � alterado chamamos o filtro.
                adapterEventos.getFilter().filter(s.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Eventos item = (Eventos) adapterEventos.getItem(position);

                Intent extras = new Intent(getActivity(),
                        inf_evento.class);
                extras.putExtra("id", item.get_id());
                extras.putExtra("nome", item.getNome());
                extras.putExtra("informacoes", item.getInformacoes());
                String mDrawableName = item.getImagem();
                int auxImg = getActivity().getResources().getIdentifier(mDrawableName, "drawable", getActivity().getPackageName());

                extras.putExtra("imagem", auxImg);
                extras.putExtra("local", item.getLocal());
                extras.putExtra("hora", item.getHora());
                extras.putExtra("valor", item.getValor());
                extras.putExtra("vagas", item.getVagas());
                startActivity(extras);

            }
        });


        final RadioButton bt_idade = (RadioButton) rootView.findViewById(R.id.radio_idade);
        final RadioButton bt_data = (RadioButton) rootView.findViewById(R.id.radio_data);
        final RadioGroup radioGroup = (RadioGroup) rootView.findViewById(R.id.radio_grupo);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

                if (bt_data.isChecked()) {
                    Log.v(" get", "Chose Chicken");
                    Collections.sort(lista, new Comparator<Eventos>() {
                        public int compare(Eventos s1, Eventos s2) {
                            return s1.getData().compareToIgnoreCase(s2.getData());
                        }
                    });
                    adapterEventos.notifyDataSetChanged();


                } else if (bt_idade.isChecked()) {

                    Collections.sort(lista, new Comparator<Eventos>() {
                        public int compare(Eventos s1, Eventos s2) {
                            return s1.getFaixa_etaria().compareToIgnoreCase(s2.getFaixa_etaria());
                        }
                    });
                    adapterEventos.notifyDataSetChanged();


                }


            }
        });


        return rootView;
    }


}
