package com.hph.servlet_container1;

import java.io.File;

public class Constants {
    public static final String WEB_ROOT = System.getProperty("user.dir")
            + File.separator + "/src/main/resources";
    public static final String WEB_SERVLET_ROOT = System.getProperty("user.dir")
            + File.separator + "target" + File.separator + "classes";
            
}
