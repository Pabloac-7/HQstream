package hqstream.model;

/**
 * @author Pablo
 */
public class cliente {
    
   public int id; 
   private String nome;
   private int cpf;
   private String email;
   private String senha;
   
   
   public cliente() {
   }
   
   public cliente(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }
   public cliente(String nome,int cpf, String email) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }
   
   public cliente(int cod,String nome,int cpf, String email) {
        this.id = cod;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }
    public cliente(String nome, int cpf, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
