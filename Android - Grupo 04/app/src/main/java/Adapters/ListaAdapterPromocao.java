package Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

import Classes.Promocao;
import br.com.luiz.AgendaFCCDA_01.R;

/**
 * Created by luiz on 09/05/2015.
 */


public class ListaAdapterPromocao extends ArrayAdapter<Promocao> {
    private Context context1;
    private ArrayList<Promocao> lista1;


    public ListaAdapterPromocao(Context context1, ArrayList<Promocao> lista1) {
        super(context1, 0, lista1);
        this.context1 = context1;
        this.lista1 = lista1;

    }


    @Override

    public View getView(int position, View convertView, ViewGroup parent) {
        Promocao promocaoPos = this.lista1.get(position);
        //String fontPath = "fonts/Fonte1.ttf";

        convertView = LayoutInflater.from(this.context1).inflate(R.layout.promocao_item, null);
        Typeface my_Fonte = Typeface.createFromAsset(getContext().getAssets(), "fonts/fonte1.ttf");
        TextView textView55 = (TextView) convertView.findViewById(R.id.nome_promocao);
        textView55.setText(promocaoPos.getNome());
        textView55.setTypeface(my_Fonte);


        TextView textView66 = (TextView) convertView.findViewById(R.id.descricao_promocao);
        textView66.setText(promocaoPos.getDescricao());

        String mDrawableName = promocaoPos.getImagem();

        int auxImg = getContext().getResources().getIdentifier(mDrawableName, "drawable", getContext().getPackageName());
        ImageView imageView22 = (ImageView) convertView.findViewById(R.id.img_promocao);
        imageView22.setImageResource(auxImg);


        return convertView;
    }


}
