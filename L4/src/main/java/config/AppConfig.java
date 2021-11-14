package config;

import java.io.InputStream;
import java.sql.SQLOutput;
import java.util.Properties;

//Ler o arquivo properties
public class AppConfig {
    public static Properties PROPS = null;

    static {
        try{
            Properties prop = new Properties();
            InputStream ip = AppConfig.class.getResourceAsStream("/config.properties");
            System.out.println(ip);
            prop.load(ip);
            PROPS = prop;
            System.out.println(PROPS);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
