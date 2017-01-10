package daos;

import banco.ConnectionException;
import banco.ConnectionFactory;
import usuario.Adm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdmDao implements Dao<Adm>{
   
    private final Connection connection;

    public AdmDao() throws ConnectionException, ClassNotFoundException, SQLException {
        this.connection = ConnectionFactory.getIntance().getConnection();
    }
    
    @Override
    public boolean add(Adm elemento) throws SQLException {
        //Adicionando na tabela de adm
        PreparedStatement stmt = connection.prepareStatement("insert into adm (nome, login, senha) values(?,?,?)");        
        stmt.setString(1, elemento.getNome());
        stmt.setString(2, elemento.getLogin());
        stmt.setString(3, elemento.getSenha());
        
        return stmt.executeUpdate() > 0;         

    }
    // Não usado 
    @Override
    public boolean delete(Adm elemento)  throws SQLException {
        //Excluindo adm 
        Adm adm = new Adm();
        PreparedStatement stmt = connection.prepareStatement("delete from adm where id = ?");            
        stmt.setInt(1, adm.getId());
        
        return stmt.executeUpdate() > 0;
    }
    //Não usado
    @Override
    public boolean update(Adm elemento) throws SQLException {
        //atulizando
        PreparedStatement stmt = connection.prepareStatement("UPDATE adm SET nome = ?, usuario = ?, senha = ? WHERE id = ?");
        stmt.setInt(4, elemento.getId());
        stmt.setString(1, elemento.getNome());
        stmt.setString(2, elemento.getLogin());        
        stmt.setString(3, elemento.getSenha());

        return stmt.executeUpdate()>0;

    }
    //Não usado
    @Override
    public List<Adm> list()  throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("select * from adm");
        ResultSet rs = stmt.executeQuery();
        
        List<Adm> mestres = new ArrayList<>();
        while(rs.next()) {
            Adm mestre = new Adm();
            mestre.setId(rs.getInt(1));
            mestre.setNome(rs.getString(2));
            mestre.setLogin(rs.getString(3));
            mestre.setSenha(rs.getString(4));
            
            mestres.add(mestre);
        }
        
        return mestres;

    }
    //Não usado
    @Override
    public Adm getElement(int index) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("select * from adm where id = ?");
        stmt.setInt(1, index);
        ResultSet rs = stmt.executeQuery();
        
       Adm adm = new Adm();
        
        if(rs.next()){ 
            adm.setId(rs.getInt(1));
            adm.setNome(rs.getString(2));
            adm.setLogin(rs.getString(3));
            adm.setSenha(rs.getString(4));           
        }            
        return adm;        
        
    }
    
    public boolean login(String login, String password)  throws SQLException {
        //Verifica se tem o login e a senha no banco
        PreparedStatement stmt = connection.prepareStatement("select * from adm where login = ? AND senha = ?");
        stmt.setString(1, login);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();
        boolean retorno = false;
        
        Adm adm = new Adm();
        
        if(rs.next()){ 
            adm.setId(rs.getInt(1));
            adm.setNome(rs.getString(2));
            adm.setLogin(rs.getString(3));
            adm.setSenha(rs.getString(4));           
            retorno = true;
        }            
        return retorno;
    }    
    
}
