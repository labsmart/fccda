package com.example.arthu_000.app;

import java.sql.Time;

/**
 * Created by arthu_000 on 10/06/2015.
 */
public class ObjetoEvento {

    private String nome;
    private String desc;
    private String horario;
    private int img;
    private int faixa;
    private int preco;
    private String tipo;
    private String local;


    ObjetoEvento(String tipo,String nome, String desc, String horario, String local, int img, int faixa, int preco){


        this.tipo = tipo;
        this.nome = nome;
        this.desc = desc;
        this.horario = horario;
        this.local = local;
        this.img = img;
        this.faixa = faixa;
        this.preco = preco;
    }


    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getFaixa() {
        return faixa;
    }

    public void setFaixa(int faixa) {
        this.faixa = faixa;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }
}
