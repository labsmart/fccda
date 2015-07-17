package Classes;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by luiz on 07/05/2015.
 */
public class Eventos implements Serializable {

    private int _id;
    private String nome;
    private String data_escrita;
    private String faixa_etaria;
    private String local;
    private String hora;
    private String informacoes;
    private String vagas;
    private String valor;
    private String categoria;
    private String data;
    private String imagem;
  //  Date data;

    public Eventos(int id, String nome, String data_escrita, String faixa_etaria, String local, String hora, String informacoes, String vagas, String valor, String categoria, String data, String imagem) {
        this._id = id;
        this.nome = nome;
        this.data_escrita = data_escrita;
        this.faixa_etaria = faixa_etaria;
        this.local = local;
        this.hora = hora;
        this.informacoes = informacoes;
        this.vagas = vagas;
        this.valor = valor;
        this.categoria = categoria;
        this.data = data;
        this.imagem = imagem;
    }

    public Eventos() {

    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData_escrita() {
        return data_escrita;
    }

    public void setData_escrita(String data_escrita) {
        this.data_escrita = data_escrita;
    }

    public String getFaixa_etaria() {
        return faixa_etaria;
    }

    public void setFaixa_etaria(String faixa_etaria) {
        this.faixa_etaria = faixa_etaria;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getInformacoes() {
        return informacoes;
    }

    public void setInformacoes(String informacoes) {
        this.informacoes = informacoes;
    }

    public String getVagas() {
        return vagas;
    }

    public void setVagas(String vagas) {
        this.vagas = vagas;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}