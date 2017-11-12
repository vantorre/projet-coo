package mapper.objetMetier.virtualProxy;

import mapper.mapper.PlayerMapper;
import mapper.objetMetier.Player;

import java.sql.SQLException;

/**
 * Created by vantorre on 12/11/17.
 */
public class PlayerFactory implements  Factory<String,Player>{

    public Player create(String id) throws SQLException {
        return PlayerMapper.getInstance().findById(id);
    }
}
