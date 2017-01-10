package jogo;

import java.util.Objects;

public class Personagem {
    public static int num;
    private int id;
    private String nome;
    private String des;

    public Personagem(int id, String nome, String des) {
        this.id = num++;
        this.nome = nome;
        this.des = des;
    }
    
    public Personagem(String nome, String des) {
        this.nome = nome;
        this.des = des;
    }
    
    public Personagem(){
        
    }

    public Personagem(String nome) {
        this.nome = nome;
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

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Personagem other = (Personagem) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "personagem{" + "id=" + id + ", nome=" + nome + ", desc=" + des + '}';
    }
}
