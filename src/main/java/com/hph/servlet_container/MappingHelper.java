package com.hph.servlet_container;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class MappingHelper {  
	  
    public static Properties requestMapping;  
    static {  
        requestMapping = new Properties();  
        try {  
            requestMapping.load(new FileInputStream(Constant.MAPPING_FILE));  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
  
    public static String resolve(String requestPath) {  
        return requestMapping.getProperty(requestPath);  
    }  
  
}  
