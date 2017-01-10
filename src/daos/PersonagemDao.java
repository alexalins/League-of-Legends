package daos;

import banco.ConnectionException;
import banco.ConnectionFactory;
import jogo.Personagem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import usuario.Jogador;

public class PersonagemDao implements Dao<Personagem>{
   
    private final Connection connection;

    public PersonagemDao() throws ConnectionException, ClassNotFoundException, SQLException {
        this.connection = ConnectionFactory.getIntance().getConnection();
    }
    
    @Override
    public boolean add(Personagem elemento) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("insert into personagem (nome, des) values(?,?)");        
        stmt.setString(1, elemento.getNome());
        stmt.setString(2, elemento.getDes());
        
        return stmt.executeUpdate() > 0;         

    }

    @Override
    public boolean delete(Personagem elemento)  throws SQLException {
        Personagem personagem = new Personagem();
        PreparedStatement stmt = connection.prepareStatement("delete from personagem where id = ?");            
        stmt.setInt(1, personagem.getId());
        
        return stmt.executeUpdate() > 0;
    }

    @Override
    public boolean update(Personagem elemento) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("UPDATE personagem SET nome = ?, des = ? WHERE nome = ?");
        stmt.setString(3, elemento.getNome());
        stmt.setString(1, elemento.getNome());
        stmt.setString(2, elemento.getDes());

        return stmt.executeUpdate()>0;

    }

    @Override
    public List<Personagem> list()  throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("select * from personagem");
        ResultSet rs = stmt.executeQuery();
        
        List<Personagem> mestres = new ArrayList<>();
        while(rs.next()) {
            Personagem personagem = new Personagem();
            personagem.setId(rs.getInt(1));
            personagem.setNome(rs.getString(2));
            personagem.setDes(rs.getString(3));
            
            mestres.add(personagem);
        }
        
        return mestres;

    }
    
   

    @Override
    public Personagem getElement(int index) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("select * from personagem where id = ?");
        stmt.setInt(1, index);
        ResultSet rs = stmt.executeQuery();
        
       Personagem personagem = new Personagem();
        
        if(rs.next()){ 
            personagem.setId(rs.getInt(1));
            personagem.setNome(rs.getString(2));
            personagem.setDes(rs.getString(3));          
        }            
        return personagem;        
        
    }
    
    public boolean login(String login, String password)  throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("select * from personagem where usuario = ? AND senha = ?");
        stmt.setString(1, login);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();
        boolean retorno = false;
        
       Personagem personagem = new Personagem();
        
        if(rs.next()){ 
            personagem.setId(rs.getInt(1));
            personagem.setNome(rs.getString(2));
            personagem.setDes(rs.getString(3));         
            retorno = true;
        }            
        return retorno;
    }    
    
}
