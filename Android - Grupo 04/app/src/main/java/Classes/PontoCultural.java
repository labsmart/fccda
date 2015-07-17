package Classes;

/**
 * Created by luiz on 09/05/2015.
 */
public class PontoCultural {


    private int _id_pc;
    private String nome;
    private String telefone;
    private String local;
    private String horario;
    private String imagem;
    private String imagem1;
    private String detalhe;

    public PontoCultural(int _id_pc, String nome, String telefone, String local, String horario, String imagem, String imagem1, String detalhe) {
        this._id_pc = _id_pc;
        this.nome = nome;
        this.telefone = telefone;
        this.local = local;
        this.horario = horario;
        this.imagem = imagem;
        this.imagem1 = imagem1;
        this.detalhe = detalhe;
    }

    public PontoCultural(){


    }

    public int get_id_pc() {
        return _id_pc;
    }

    public void set_id_pc(int _id_pc) {
        this._id_pc = _id_pc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getImagem1() {
        return imagem1;
    }

    public void setImagem1(String imagem1) {
        this.imagem1 = imagem1;
    }

    public String getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(String detalhe) {
        this.detalhe = detalhe;
    }
}