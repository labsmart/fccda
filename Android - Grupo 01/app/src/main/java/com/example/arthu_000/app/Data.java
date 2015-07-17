package com.example.arthu_000.app;

import java.util.List;

/**
 * Created by arthu_000 on 24/06/2015.
 */
public class Data {
    private int Data;
    private List<EventListView> eventos;

    public int getData() {
        return Data;
    }

    public void setData(int data) {
        Data = data;
    }

    public List<EventListView> getEventos() {
        return eventos;
    }

    public void setEventos(List<EventListView> eventos) {
        this.eventos = eventos;
    }
    public String dataToString(){
        int d= Data%100;
        int m= Data%10000-d;
        int a= (Data-m-d)/10000;
        String saida="";
        if (d<10)
            saida+=0;
        saida+=d+"/";
        if (m<1000)
            saida+=0;
        saida+=m/100+"/";
        saida+=a;
        return saida;
    }
}
