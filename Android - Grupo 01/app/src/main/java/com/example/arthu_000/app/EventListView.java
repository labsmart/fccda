package com.example.arthu_000.app;


/**
 * Created by arthu_000 on 12/05/2015.
 */
public class EventListView {
    private int id;
    private int iconeRid;
    private int iconeClass;
    private String nome;
    private String desc;
    private String data;
    private String horario;
    private float valor;
    private String local;

    public EventListView() {
    }
    public EventListView(String nome,String desc,String data,String horario,float valor, int iconeRid,int id, int iconeClass,String local) {
        this.nome = nome;
        this.iconeRid = iconeRid;
        this.desc = desc;
        this.data = data;
        this.horario = horario;
        this.id = id;
        this.iconeClass =iconeClass;
        this.valor = valor;
        this.local =local;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public void setData(String data) {
        this.data = data;
    }
    public String getData() {
        return data;
    }
    public String getHorario() {
        return horario;
    }

    public int getIconeClass() {
        return iconeClass;
    }

    public void setIconeClass(int iconeClass) {
        this.iconeClass = iconeClass;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIconeRid() {
        return iconeRid;
    }

    public void setIconeRid(int iconeRid) {
        this.iconeRid = iconeRid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
