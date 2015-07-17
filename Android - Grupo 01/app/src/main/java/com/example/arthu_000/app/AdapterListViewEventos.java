package com.example.arthu_000.app;

import com.example.arthu_000.app.ItemListView;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class AdapterListViewEventos extends BaseAdapter {

    private LayoutInflater mInflater;
    private ArrayList<EventListView> itens;

    public AdapterListViewEventos(Context context, ArrayList<EventListView> itens) {
        //Itens que preencheram o listview
        this.itens = itens;
        //responsavel por pegar o Layout do item.
        mInflater = LayoutInflater.from(context);
    }

    /**
     * Retorna a quantidade de itens
     *
     * @return
     */
    public int getCount() {
        return itens.size();
    }

    /**
     * Retorna o item de acordo com a posicao dele na tela.
     *
     * @param position
     * @return
     */
    public EventListView getItem(int position) {
        return itens.get(position);
    }

    /**
     * Sem implementação
     *
     * @param position
     * @return
     */
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View view, ViewGroup parent) {
        EventoSup itemHolder;
        //se a view estiver nula (nunca criada), inflamos o layout nela.
        if (view == null) {
            //infla o layout para podermos pegar as views
            view = mInflater.inflate(R.layout.item_eventos, null);

            //cria um item de suporte para não precisarmos sempre
            //inflar as mesmas informacoes
            itemHolder = new EventoSup();
            itemHolder.nome = ((TextView) view.findViewById(R.id.text_nome));
            itemHolder.desc = ((TextView) view.findViewById(R.id.text_desecricao));
            itemHolder.data = ((TextView) view.findViewById(R.id.text_data));
            itemHolder.local = ((TextView) view.findViewById(R.id.text_local));
            itemHolder.horario = ((TextView) view.findViewById(R.id.text_horario));
            itemHolder.imgIcon = ((ImageView) view.findViewById(R.id.imagemview_eventos));
            itemHolder.imgClass = ((ImageView) view.findViewById(R.id.imagemview_class));

            //define os itens na view;
            view.setTag(itemHolder);
        } else {
            //se a view já existe pega os itens.
            itemHolder = (EventoSup) view.getTag();
        }

        //pega os dados da lista
        //e define os valores nos itens.
        EventListView item = itens.get(position);
        itemHolder.nome.setText(item.getNome());
        itemHolder.local.setText("Local:"+item.getLocal());
        itemHolder.desc.setText(
                Html.fromHtml("Descri\u00e7\u00e3o" + ":" + item.getDesc()).toString());
        if(item.getValor()>0)
        itemHolder.data.setText("Valor:R$" + item.getValor());
        else

            itemHolder.data.setText("Valor:Gr\u00e1tis");
        itemHolder.horario.setText(
                Html.fromHtml(("Hor\u00e1rio:" + item.getHorario())).toString());
        int Rid = 0, Class = 0;
        if (item.getIconeClass() == 0)
            Class = R.drawable._l;
        if (item.getIconeClass() == 1)
            Class = R.drawable._10;
        if (item.getIconeClass() == 2)
            Class = R.drawable._12;
        if (item.getIconeClass() == 3)
            Class = R.drawable._14;
        if (item.getIconeClass() == 4)
            Class = R.drawable._16;

        if (item.getIconeRid() == 0)
            Rid = R.drawable.nova0;
        if (item.getIconeRid() == 2)
            Rid = R.drawable.nova1;
        if (item.getIconeRid() == 3)
            Rid = R.drawable.nova2;
        if (item.getIconeRid() == 4)
            Rid = R.drawable.nova3;
        if (item.getIconeRid() == 5)
            Rid = R.drawable.nova4;
        if (item.getIconeRid() == 6)
            Rid = R.drawable.nova5;
        if (item.getIconeRid() == 7)
            Rid = R.drawable.nova6;
        itemHolder.imgIcon.setImageResource(Rid);
        itemHolder.imgClass.setImageResource(Class);

        //retorna a view com as informações
        return view;
    }

    /**
     * Classe de suporte para os itens do layout.
     */
    private class EventoSup {

        ImageView imgIcon, imgClass;
        TextView nome, desc, data, horario,local;
    }

}