package hqstream.model;

/**
 *
 * @author Pablo
 */
public class plano {
    
    private String tipo;
    private String descricao;
    private float mensalidade;

     public plano(String tipo, String descricao) {
        this.tipo = tipo;
        this.descricao = descricao;
    }
    
    public plano(String tipo, String descricao, float mensalidade) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.mensalidade = mensalidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(float mensalidade) {
        this.mensalidade = mensalidade;
    }
    
    
    
}
