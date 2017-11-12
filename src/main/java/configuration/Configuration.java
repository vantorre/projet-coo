package configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created by vantorre on 09/11/17.
 */
public class Configuration extends Properties{
    private static Configuration DATABASE_CONF = new Configuration("src/main/resources/configuration/database.properties");
    private static Configuration LIBELLE_CONF = new Configuration("src/main/resources/configuration/libelle.properties");
    private static Configuration GAME_CONF = new Configuration("src/main/resources/configuration/game.properties");

    public static Configuration getDatabaseConf() {
        return DATABASE_CONF;
    }

    public static Configuration getGameConf() {
        return GAME_CONF;
    }

    public static Configuration getLibelleConf() {
        return LIBELLE_CONF;
    }

    private Configuration(String filePath){
        try {
            super.load(new InputStreamReader(new FileInputStream(filePath),"UTF-8" ));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Integer getIntProperty(String key) {
        String stringValue = this.getProperty(key);
        if (stringValue == null) {
            return null;
        }
        return Integer.parseInt(stringValue);
    }

    public int getIntProperty(String key, int defaultValue) {
        Integer value = getIntProperty(key);
        return value == null ? defaultValue : value;
    }
}
