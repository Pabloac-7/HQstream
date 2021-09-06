package hqstream.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Pablo
 */
public class autor {
    
    public int codigo;
    public String nome;
    public LocalDate data;
    private String dataLista;
         //result.getDate("data_nascimento").toInstant().atZone(ZoneId.systemDefault()).toLocalDate()  <-- date to localdate
    
    public autor(String nome, LocalDate data) {
        this.nome = nome;
        this.data = data;
    }

     public autor(int cod,String nome, String data) {
        this.nome = nome;
        this.dataLista =  data;
        this.codigo = cod;
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

    public String getDataLista() {
        return dataLista;
    }

    public void setDataLista(String dataLista) {
        this.dataLista = dataLista;
    }
    
}
