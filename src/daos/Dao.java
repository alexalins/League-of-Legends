package daos;

import java.sql.SQLException;
import java.util.List;
/**
 * 
 * @author Ricarte&Alexa
 * @param <T> 
 */
public interface Dao <T>{
    /**
     * 
     * @param elemento
     * @return a adição, a remoção e/ou a lista dos personagens
     * @throws java.sql.SQLException
     */
    boolean add(T elemento) throws SQLException;
    boolean delete(T elemento) throws SQLException;
    boolean update(T elemento) throws SQLException;
    T getElement(int index) throws SQLException;
    List<T> list() throws SQLException;
}
