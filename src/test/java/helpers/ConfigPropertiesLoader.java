package helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

/**
 * Created by dell on 11.02.2015.
 */
public class ConfigPropertiesLoader {
    private final static Logger log = LoggerFactory.getLogger(ConfigPropertiesLoader.class);


    protected String loginbaseUrl;
    protected String hubIP;
    protected String hubPort;
    protected String chromeDriverPath;


    public ConfigPropertiesLoader() {

        try {
            environmentInit();


//            init class-helpers instances
        } catch (IOException e) {
            log.info(e.getMessage());
        }

    }


    //    method resposible for parsing ENVIRONMENT   config from  .properties  file
    public void environmentInit() throws IOException {
        Properties prop = new Properties();
        String propFileName = "config.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        if (inputStream == null) {
            throw new FileNotFoundException("Property File '" + propFileName + "' not found in the classpath");
        }
        prop.load(inputStream);
        Date time = new Date(System.currentTimeMillis());
        // get the property value and print it out
        loginbaseUrl = prop.getProperty("loginbaseUrl");
        hubIP = prop.getProperty("hubIP");
        hubPort = prop.getProperty("hubPort");
        chromeDriverPath = prop.getProperty("chromeDriverPath");

        inputStream.close();

    }

// a list of getters for properties


    public String getLoginbaseUrl() {
        return loginbaseUrl;
    }


    public String getHubIP() {
        return hubIP;
    }

    public String getHubPort() {
        return hubPort;
    }


    public String getChromeDriverPath() {
        return chromeDriverPath;
    }


}
