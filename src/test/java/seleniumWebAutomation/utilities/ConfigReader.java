package seleniumWebAutomation.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    // 1- properties objesioluşturalım
    //her yerden çağırmak için static
    // class dışından müdahale olmasın diye private

    static private Properties properties;


    // her seyden önce çalışır
    static {
        String path="configuration.properties";  //src/configuration.properties
        try {
            FileInputStream fileInputStream=new FileInputStream(path);
            properties=new Properties();
            properties.load(fileInputStream);


            fileInputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getProperty(String key){
        String value=properties.getProperty(key);
        return  value;
    }

}