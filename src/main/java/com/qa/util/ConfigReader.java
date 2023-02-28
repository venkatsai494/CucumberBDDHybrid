package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties properties;//Making it specific to only this class hence making it private and if outside class wants to access it. let them use the below methods which would be public

    /*
    This method loads the properties from the property file
     */

    public Properties init_properties(){
        properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream(".src/test/resources/config/config.properties");
            properties.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  properties;
    }

}
