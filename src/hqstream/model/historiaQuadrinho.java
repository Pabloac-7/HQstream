package hqstream.model;

import java.time.LocalDate;

/**
 * @author Pablo
 */
public class historiaQuadrinho {
    
    public int codigo;
    public String nome;
    public LocalDate data;
    public String empresa;
    public int pag;
    public String dataLista;

    public historiaQuadrinho(String nome, LocalDate data, String empresa, int pag) {
        this.nome = nome;
        this.data = data;
        this.empresa = empresa;
        this.pag = pag;
    }
    
    public historiaQuadrinho(int cod, String nome, LocalDate data, String empresa, int pag) {
        this.codigo = cod;
        this.nome = nome;
        this.data = data;
        this.empresa = empresa;
        this.pag = pag;
    }
    
     public historiaQuadrinho(int cod, String nome, String dataLista, String empresa, int pag) {
        this.codigo = cod;
        this.nome = nome;
        this.dataLista = dataLista;
        this.empresa = empresa;
        this.pag = pag;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public int getPag() {
        return pag;
    }

    public void setPag(int pag) {
        this.pag = pag;
    }
    
    
    
}
