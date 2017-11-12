package mapper.objetMetier.virtualProxy;

import java.sql.SQLException;

/**
 * Created by vantorre on 12/11/17.
 */
public interface Factory <K,V>{
    V create(K id) throws SQLException;
}
