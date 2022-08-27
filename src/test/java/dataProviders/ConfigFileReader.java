package dataProviders;

import java.io.*;
import java.util.Properties;

public class ConfigFileReader {
    private static Properties properties = new Properties();
    private static String projectPath = System.getProperty("user.dir");
    private static String configFilePath = "/config.properties";

    public ConfigFileReader(){
        try {
            InputStream input = new FileInputStream(projectPath + configFilePath);
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getBrowserType(){
        return properties.getProperty("browser");
    }

    public static void setBrowserType(String browser){
        try {
            OutputStream output = new FileOutputStream(projectPath+configFilePath);
            properties.setProperty("browser",browser);
            properties.store(output,"setting browser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getApplicationUrl(){
        String url = properties.getProperty("url");
        if(url!=null) return url;
        else throw new RuntimeException("url is not specified in config file");
    }

}
