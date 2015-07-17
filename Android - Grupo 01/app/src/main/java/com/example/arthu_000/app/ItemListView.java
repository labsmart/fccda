package com.example.arthu_000.app;

/**
 * Created by arthu_000 on 11/05/2015.
 */
public class ItemListView {

    private String texto;
    private int id;
    private int iconeRid;

    public ItemListView() {
    }

    public ItemListView(String texto, int iconeRid) {
        this.texto = texto;
        this.iconeRid = iconeRid;
    }
    public ItemListView(String texto, int iconeRid, int id) {
        this.texto = texto;
        this.iconeRid = iconeRid;
        this.id = id;
    }

    public int getIconeRid() {
        return iconeRid;
    }

    public void setIconeRid(int iconeRid) {
        this.iconeRid = iconeRid;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getId() {
        return id;
    }

    public void setTexto2(int id) {
        this.id = id;
    }
}
