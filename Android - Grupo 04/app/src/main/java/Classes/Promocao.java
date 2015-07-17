package Classes;

import java.io.Serializable;

/**
 * Created by luiz on 09/05/2015.
 */
public class Promocao implements Serializable {

    private int _id;
    private String nome;
    private String descricao;
    private String detalhe;
    String imagem;

    public Promocao(int _id, String nome, String descricao, String detalhe, String imagem) {
        this._id = _id;
        this.nome = nome;
        this.descricao = descricao;
        this.detalhe = detalhe;
        this.imagem = imagem;
    }

    public Promocao() {
    }


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(String detalhe) {
        this.detalhe = detalhe;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }


}

