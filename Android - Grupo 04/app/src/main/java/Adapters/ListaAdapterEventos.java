package Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Classes.Eventos;
import Classes.PontoCultural;
import br.com.luiz.AgendaFCCDA_01.R;

/**
 * Created by luiz on 08/05/2015.
 */

public class ListaAdapterEventos extends ArrayAdapter<Eventos> implements Filterable {
    private Context context;


    //Itens de exibição / filtrados
    private ArrayList<Eventos> lista_exibicao;
    //Essa lista contem todos os itens.
    private ArrayList<Eventos> lista;
    private LayoutInflater layoutInflater;


    public ListaAdapterEventos(Context context, ArrayList<Eventos> lista) {
        super(context, 0, lista);
        this.context = context;
        this.lista = lista;
        this.lista_exibicao = lista;
        layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return this.lista_exibicao.size();
    }

    @Override
    public Eventos getItem(int position) {
        return this.lista_exibicao.get(position);
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }


    @Override

    public View getView(int position, View convertView, ViewGroup parent) {
        Eventos eventoPos = this.lista_exibicao.get(position);

        convertView = LayoutInflater.from(this.context).inflate(R.layout.evento_item, null);


        TextView textView11 = (TextView) convertView.findViewById(R.id.textView2);
        textView11.setText(eventoPos.getNome());


        Typeface my_Fonte = Typeface.createFromAsset(context.getAssets(), "fonts/fonte1.ttf");
        TextView textView22 = (TextView) convertView.findViewById(R.id.textView3);
        textView22.setText(eventoPos.getData_escrita());
        textView22.setTypeface(my_Fonte);


        TextView textView33 = (TextView) convertView.findViewById(R.id.textView5);
        textView33.setText(eventoPos.getLocal());

        TextView textView44 = (TextView) convertView.findViewById(R.id.textView4);
        textView44.setText(eventoPos.getHora());
        // textView44.setTypeface(my_Fonte);

        TextView textView55 = (TextView) convertView.findViewById(R.id.textView6);
        textView55.setText(eventoPos.getValor());


        ImageView img = (ImageView) convertView.findViewById(R.id.img_class_item);
        ImageView img1 = (ImageView) convertView.findViewById(R.id.imagem_classificacao);

        LinearLayout cabeca = (LinearLayout) convertView.findViewById(R.id.layout_cabeca);


        if (eventoPos.getCategoria().toString().equalsIgnoreCase("musica"))  //condition to check its text
        {
            //     convertView.setBackgroundColor(Color.parseColor("#FFDAB9"));
            img1.setImageResource(R.drawable.musica_cat);
            //    cabeca.setBackgroundColor(Color.parseColor("#FF0000"));
            //     textView22.setBackgroundColor(Color.parseColor("#FF0000"));
            //textView22.setTextColor(Color.parseColor("#4682B4"));
            // textView22.setBackgroundColor(Color.parseColor("#088A08"));
            //textView22.setBackgroundColor("#4682B4");
            //  textView11.setTextColor(Color.parseColor("#4682B4"));
            //  textView22.setTextColor(Color.BLACK);
        } else if (eventoPos.getCategoria().toString().equalsIgnoreCase("teatro")) {
            //   convertView.setBackgroundColor(Color.parseColor("#FFFFE0"));
            img1.setImageResource(R.drawable.teatro_cat);
            //  cabeca.setBackgroundColor(Color.parseColor("#FFD700"));
            // textView22.setBackgroundColor(Color.parseColor("#FFD700"));
            // textView22.setTextColor(Color.parseColor("#ffffff"));
            // textView22.setBackgroundColor(Color.parseColor("#088A08"));
            // textView11.setTextColor(Color.parseColor("#FFD700"));
            //  textView22.setTextColor(Color.BLACK);
        } else if (eventoPos.getCategoria().toString().equalsIgnoreCase("oficina")) {
            // convertView.setBackgroundColor(Color.parseColor("#CEF6CE"));
            //textView22.setBackgroundColor(Color.parseColor("#32CD32"));
            // img.setImageResource(R.drawable.oficina_cat);
            //  textView22.setTextColor(Color.parseColor("#ffffff"));
            // textView22.setBackgroundColor(Color.parseColor("#088A08"));
            // textView11.setTextColor(Color.parseColor("#FF8C00"));
            // cabeca.setBackgroundColor(Color.parseColor("#32CD32"));
            img1.setImageResource(R.drawable.oficina_cat);

            // textView22.setTextColor(Color.BLACK);
        } else if (eventoPos.getCategoria().toString().equalsIgnoreCase("cultura")) {
            //  convertView.setBackgroundColor(Color.parseColor("#FFE4E1"));
            //  textView22.setBackgroundColor(Color.parseColor("#FF00FF"));
            // img.setImageResource(R.drawable.cultura_cat);
            // textView22.setTextColor(Color.RED);
            // textView22.setBackgroundColor(Color.parseColor("#088A08"));
            img1.setImageResource(R.drawable.cultura_cat);
            //  cabeca.setBackgroundColor(Color.parseColor("#FF00FF"));
            //  textView11.setTextColor(Color.RED);
            //textView22.setTextColor(Color.BLACK);#32CD32#CD853F
        } else if (eventoPos.getCategoria().toString().equalsIgnoreCase("cinema")) {
            //   convertView.setBackgroundColor(Color.parseColor("#E0FFFF"));
            img1.setImageResource(R.drawable.cinema_cat);
            //    textView22.setBackgroundColor(Color.parseColor("#00BFFF"));
            //    cabeca.setBackgroundColor(Color.parseColor("#00BFFF"));
            // textView22.setTextColor(Color.BLACK);
            //textView22.setBackgroundColor(Color.parseColor("#088A08"));
            // textView11.setTextColor(Color.BLACK);
        }


        if (eventoPos.getFaixa_etaria().toString().equalsIgnoreCase("10"))  //condition to check its text
        {
            img.setImageResource(R.drawable.class10);
            //textView22.setTextColor(Color.parseColor("#4682B4"));
            // textView22.setBackgroundColor(Color.parseColor("#088A08"));
            //textView22.setBackgroundColor("#4682B4");
            //  textView11.setTextColor(Color.parseColor("#4682B4"));
            //  textView22.setTextColor(Color.BLACK);
        } else if (eventoPos.getFaixa_etaria().toString().equalsIgnoreCase("12")) {
            //convertView.setBackgroundColor(Color.parseColor("#F0E68C"));
            img.setImageResource(R.drawable.class12);
            //textView22.setTextColor(Color.parseColor("#FFD700"));
            // textView22.setBackgroundColor(Color.parseColor("#088A08"));
            // textView11.setTextColor(Color.parseColor("#FFD700"));
            //  textView22.setTextColor(Color.BLACK);
        } else if (eventoPos.getFaixa_etaria().toString().equalsIgnoreCase("14")) {
            // convertView.setBackgroundColor(Color.parseColor("#FF8C00"));
            img.setImageResource(R.drawable.class14);
            // textView22.setTextColor(Color.parseColor("#FF8C00"));
            // textView22.setBackgroundColor(Color.parseColor("#088A08"));
            // textView11.setTextColor(Color.parseColor("#FF8C00"));

            // textView22.setTextColor(Color.BLACK);
        } else if (eventoPos.getFaixa_etaria().toString().equalsIgnoreCase("16")) {
            // convertView.setBackgroundColor(Color.parseColor("#FF8C00"));
            img.setImageResource(R.drawable.class16);
            // textView22.setTextColor(Color.RED);
            // textView22.setBackgroundColor(Color.parseColor("#088A08"));
            //  textView11.setTextColor(Color.RED);
            //textView22.setTextColor(Color.BLACK);
        } else if (eventoPos.getFaixa_etaria().toString().equalsIgnoreCase("18")) {
            //convertView.setBackgroundColor(Color.parseColor("#9ACD32"));
            img.setImageResource(R.drawable.class18);
            // textView22.setTextColor(Color.BLACK);
            //textView22.setBackgroundColor(Color.parseColor("#088A08"));
            // textView11.setTextColor(Color.BLACK);
        } else if (eventoPos.getFaixa_etaria().toString().equalsIgnoreCase("0")) {
            //convertView.setBackgroundColor(Color.parseColor("#9ACD32"));
            img.setImageResource(R.drawable.class_livre);
            //textView22.setBackgroundColor(Color.parseColor("#088A08"));
            //textView22.setTextColor(Color.parseColor("#228B22"));
            //   textView11.setTextColor(Color.parseColor("#228B22"));
            // textView22.setTextColor(Color.BLACK);
        }


        return convertView;
    }


    /**
     * Created by luiz on 09/05/2015.
     */


    public static class ListaAdapterPonto extends ArrayAdapter<PontoCultural> {
        private Context context2;
        private ArrayList<PontoCultural> lista2;


        public ListaAdapterPonto(Context context2, ArrayList<PontoCultural> lista2) {
            super(context2, 0, lista2);
            this.context2 = context2;
            this.lista2 = lista2;

        }


        @Override

        public View getView(int position, View convertView, ViewGroup parent) {
            PontoCultural pontoPos = this.lista2.get(position);
            //String fontPath = "fonts/Fonte1.ttf";

            convertView = LayoutInflater.from(this.context2).inflate(R.layout.ponto_cultural_item, null);
            Typeface my_Fonte = Typeface.createFromAsset(context2.getAssets(), "fonts/fonte1.ttf");
            TextView textView77 = (TextView) convertView.findViewById(R.id.nome_pontoCultural);
            textView77.setText(pontoPos.getNome());
            textView77.setTypeface(my_Fonte);

            TextView textView88 = (TextView) convertView.findViewById(R.id.informacao_pontoCultural);
            textView88.setText(pontoPos.getTelefone());

            TextView textView99 = (TextView) convertView.findViewById(R.id.local_pontoCultural);
            textView99.setText(pontoPos.getLocal());

            TextView textView111 = (TextView) convertView.findViewById(R.id.horario_pontoCultural);
            textView111.setText(pontoPos.getHorario());


              /*  String mDrawableName = "myImageName";
                int id = mContext.getResources().getIdentifier(mDrawableName , "drawable", mContext.getPackageName());*/
            String mDrawableName = pontoPos.getImagem();
            int auxImg = context2.getResources().getIdentifier(mDrawableName, "drawable", context2.getPackageName());
            ImageView imageView1 = (ImageView) convertView.findViewById(R.id.imagem_pontoCultural);
//                imageView1.setImageResource(Integer.parseInt(pontoPos.getImagem()));
            imageView1.setImageResource(auxImg);


            return convertView;
        }


    }


    public Filter getFilter() {
        Filter filter = new Filter() {

            @Override
            protected FilterResults performFiltering(CharSequence filtro) {
                FilterResults results = new FilterResults();
                //se não foi realizado nenhum filtro insere todos os itens.
                if (filtro == null || filtro.length() == 0) {
                    results.count = lista.size();
                    results.values = lista;
                } else {
                    //cria um array para armazenar os objetos filtrados.
                    List<Eventos> itens_filtrados = new ArrayList<Eventos>();

                    //percorre toda lista verificando se contem a palavra do filtro na descricao do objeto.
                    for (int i = 0; i < lista.size(); i++) {
                        Eventos data = lista.get(i);

                        filtro = filtro.toString().toLowerCase();
                        String condicao = data.getNome().toLowerCase();

                        if (condicao.contains(filtro)) {
                            //se conter adiciona na lista de itens filtrados.
                            itens_filtrados.add(data);
                        }
                    }
                    // Define o resultado do filtro na variavel FilterResults
                    results.count = itens_filtrados.size();
                    results.values = itens_filtrados;


                }


                return results;
            }

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                lista_exibicao = (ArrayList<Eventos>) results.values; // Valores filtrados.
                notifyDataSetChanged();  // Notifica a lista de alteração
            }

        };
        return filter;

    }

/*
        public void filtroRadio(){
            View view = null;
            final ViewHolder viewHolder = new ViewHolder();
            viewHolder.radioGroup=(RadioGroup)view.findViewById(R.id.radio_grupo);
            viewHolder.bt_data=(RadioButton)view.findViewById(R.id.radio_data);
            viewHolder.bt_idade=(RadioButton)view.findViewById(R.id.radio_idade);


            viewHolder.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

                    if (viewHolder.bt_data.isChecked()) {
                        Collections.sort(lista_exibicao, new Comparator<Eventos>() {
                            public int compare(Eventos s1, Eventos s2) {
                                return s1.getData().compareToIgnoreCase(s2.getData());
                            }
                        });



                    } else if (viewHolder.bt_idade.isChecked()) {

                        Collections.sort(lista_exibicao, new Comparator<Eventos>() {
                            public int compare(Eventos s1, Eventos s2) {
                                return s1.getFaixa_etaria().compareToIgnoreCase(s2.getFaixa_etaria());
                            }
                        });



                    }


                }
            });
            notifyDataSetChanged();
        }
    */


}

