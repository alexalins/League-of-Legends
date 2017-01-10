package usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import jogo.Personagem;

public class Jogador {
    public static int num;
    private int id;
    private String nome;
    private String login;
    private String senha;
    private List<Personagem> personagens;
    
    public Jogador(int id, String nome, String login, String senha){
        this.id = num++;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.personagens = new ArrayList<>();
    }
    
    public Jogador(){
        
    }
    
     public Jogador(int id){
        this.id = id;
    }
    public Jogador(String login){
        this.login = login;
    }
    public Jogador(String login, String senha){
        this.login = login;
        this.senha = senha;
    }
    
    public List<Personagem> getPersonagens() {
        return personagens;
    }

    public void setPersonagens(List<Personagem> personagens) {
        this.personagens = personagens;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getLogin(){
        return login;
    }
    
    public void setLogin(String login){
        this.login = login;
    }
    
    public String getSenha(){
        return senha;
    }
    
    public void setSenha(String senha){
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.id;
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
        final Jogador other = (Jogador) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        return true;
    }

   

    @Override
    public String toString() {
        return "jogador{" + "id=" + id + ", nome=" + nome + ", login=" + login + ", senha=" + senha + '}';
    }
}
