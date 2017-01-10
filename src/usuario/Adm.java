package usuario;

public class Adm{
    public static int num;
    private int id;
    private String nome;
    private String login;
    private String senha;

    public Adm(int id, String nome, String login, String senha) {
        this.id = num++;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }
    
    public Adm(String login, String senha){
        this.login = login;
        this.senha = senha;
    }
    
    public Adm(){
        
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Adm other = (Adm) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "adm{" + "id=" + id + ", nome=" + nome + ", login=" + login + ", senha=" + senha + '}';
    }
    
    
}
