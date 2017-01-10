package daos;

import banco.ConnectionException;
import banco.ConnectionFactory;
import usuario.Jogador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jogo.Personagem;

public class JogadorDao implements Dao<Jogador>{
   
    private final Connection connection;

    public JogadorDao() throws ConnectionException, ClassNotFoundException, SQLException {
        this.connection = ConnectionFactory.getIntance().getConnection();
    }
    
    @Override
    public boolean add(Jogador elemento) throws SQLException {
        //adciona jogador
        PreparedStatement stmt = connection.prepareStatement("insert into jogador (nome, login, senha) values(?,?,?)");        
        stmt.setString(1, elemento.getNome());
        stmt.setString(2, elemento.getLogin());
        stmt.setString(3, elemento.getSenha());
        
        return stmt.executeUpdate() > 0; 

    }
    
    public boolean addp(Personagem p, Jogador j) throws SQLException {
        //adiciona o personagem desse jogador
        PreparedStatement stmt = connection.prepareStatement("insert into jogador_personagem (idj, nomep, dadop) values(?,?,?)");        
        stmt.setInt(1, j.getId());
        stmt.setString(2, p.getNome());
        stmt.setString(3, p.getDes());
        
        return stmt.executeUpdate() > 0; 

    }
    
    public List<Personagem> listP(Jogador j)  throws SQLException {
        //lista os personagens desse jogador
        PreparedStatement stmt = connection.prepareStatement("select nomep, dadop from jogador_personagem where idj = ?");
        stmt.setInt(1, j.getId());
        ResultSet rs = stmt.executeQuery();
        
        List<Personagem> mestres = new ArrayList<>();
        while(rs.next()) {
            Personagem personagem = new Personagem();
            personagem.setNome(rs.getString(1));
            personagem.setDes(rs.getString(2));
            
            mestres.add(personagem);
        }
        
        return mestres;

    }
    
    public Integer ultimoId() throws SQLException {
        //Captura o  ultimo id usado
        PreparedStatement stmt = connection.prepareStatement("select MAX(id) from jogador");
        ResultSet rs = stmt.executeQuery();
        Integer valor = null;
        
        if(rs.next()){
        valor = rs.getInt(1);
        }

        return valor;

    }  
    
    //Não usado
    @Override
    public boolean delete(Jogador elemento)  throws SQLException {
        Jogador jogador = new Jogador();
        PreparedStatement stmt = connection.prepareStatement("delete from jogador where id = ?");            
        stmt.setInt(1, jogador.getId());
        
        return stmt.executeUpdate() > 0;
    }

    //Não usado
    @Override
    public boolean update(Jogador elemento) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("UPDATE jogador SET nome = ?, usuario = ?, senha = ? WHERE id = ?");
        stmt.setInt(4, elemento.getId());
        stmt.setString(1, elemento.getNome());
        stmt.setString(2, elemento.getLogin());        
        stmt.setString(3, elemento.getSenha());

        return stmt.executeUpdate()>0;

    }

    //Não usado
    @Override
    public List<Jogador> list()  throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("select * from jogador");
        ResultSet rs = stmt.executeQuery();
        
        List<Jogador> mestres = new ArrayList<>();
        while(rs.next()) {
            Jogador jogador = new Jogador();
            jogador.setId(rs.getInt(1));
            jogador.setNome(rs.getString(2));
            jogador.setLogin(rs.getString(3));
            jogador.setSenha(rs.getString(4));
            
            mestres.add(jogador);
        }
        
        return mestres;

    }

    //Não usado
    @Override
    public Jogador getElement(int index) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("select * from jogador where id = ?");
        stmt.setInt(1, index);
        ResultSet rs = stmt.executeQuery();
        
       Jogador jogador = new Jogador();
        
        if(rs.next()){ 
            jogador.setId(rs.getInt(1));
            jogador.setNome(rs.getString(2));
            jogador.setLogin(rs.getString(3));
            jogador.setSenha(rs.getString(4));           
        }            
        return jogador;        
        
    }
    
    //Verifica se existe o login e a senha, se sim loga
    public boolean login(String login, String password)  throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("select * from jogador where login = ? AND senha = ?");
        stmt.setString(1, login);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();
        boolean retorno = false;
        
       Jogador jogador = new Jogador();
        
        if(rs.next()){ 
            jogador.setId(rs.getInt(1));
            jogador.setNome(rs.getString(2));
            jogador.setLogin(rs.getString(3));
            jogador.setSenha(rs.getString(4));           
            retorno = true;
        }            
        return retorno;
    }    
    
}

