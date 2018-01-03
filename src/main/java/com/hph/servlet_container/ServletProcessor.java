package com.hph.servlet_container;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ServletProcessor {  
	  
    private static Log log = LogFactory.getLog(ServletProcessor.class);  
  
    public static void processServletRequest(BaseRequest request,  
            BaseResponse response) {  
        String uri = request.getUri();  
        String servletName = MappingHelper.resolve(uri);  
        log.info("Processing servlet: " + servletName);  
  
        HttpServlet servlet = loadServlet(servletName);  
  
        callService(servlet, request, response);  
  
    }  
  
    private static URLClassLoader createUrlClassLoader() {  
  
        URLClassLoader loader = null;  
        try {  
            URL[] urls = new URL[1];  
            URLStreamHandler streamHandler = null;  
            File classPath = new File(Constant.RESOURCE_ROOT);  
  
            // org.apache.catalina.startup.ClassLoaderFactory  
            String repository = (new URL("file", null,  
                    classPath.getCanonicalPath() + File.separator)).toString();  
            urls[0] = new URL(null, repository, streamHandler);  
            loader = new URLClassLoader(urls);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return loader;  
    }  
  
    private static HttpServlet loadServlet(String servletName) {  
        URLClassLoader loader = createUrlClassLoader();  
        HttpServlet servlet = null;  
        try {  
            @SuppressWarnings("unchecked")  
            Class<Servlet> servletClass = (Class<Servlet>) loader  
                    .loadClass(servletName);  
            servlet = (HttpServlet) servletClass.newInstance();  
        } catch (ClassNotFoundException e) {  
            e.printStackTrace();  
        } catch (InstantiationException e) {  
            e.printStackTrace();  
        } catch (IllegalAccessException e) {  
            e.printStackTrace();  
        }  
        return servlet;  
    }  
  
	private static void callService(HttpServlet servlet, HttpServletRequest request,  
            HttpServletResponse response) {  
        try {  
            servlet.service(request, response);  
        } catch (ServletException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
  
    }  
  
}  
