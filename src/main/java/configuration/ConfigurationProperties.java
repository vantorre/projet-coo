package configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by vantorre on 09/11/17.
 */
public class ConfigurationProperties extends Properties{
    private static ConfigurationProperties INSTANCE = new ConfigurationProperties();
    private ConfigurationProperties() {
        load();
    }
    public static ConfigurationProperties getInstance(){
        return INSTANCE;
    }

    public void load(){
        try {
            super.load(new FileInputStream("ressources/conf.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
