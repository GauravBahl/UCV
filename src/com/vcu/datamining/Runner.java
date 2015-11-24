package com.vcu.datamining;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Runner {

	
	private static final String CAIM_JAR_LOCATION = "C:/Users/Gaurav Bahl/Downloads/CAIM-java/caim-java.jar";
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InterruptedException, MalformedURLException {
		
		File f = new File(CAIM_JAR_LOCATION);
		ClassLoader cl = new URLClassLoader(new URL[] { f.toURI().toURL() }, null);
		final Class<?> claxx = cl.loadClass("CRunner");
		final Method main = claxx.getMethod("main", String[].class);
		
		final Class<?> loader = cl.loadClass("DataLoader");
		final Method load = loader.getMethod("load", new Class[]{String.class}); 
		
		
		Thread th = new Thread(new Runnable() {
		    @Override
		    public void run() {
		        try {
		        //	System.out.println(load.invoke(loader, "C:/Users/Gaurav Bahl/Downloads/clean1.csv"));
		            main.invoke(claxx, new Object[] { new String[] { "Param1", "Param2" } });
		           
		        } catch (Throwable th) {
		            // TODO
		        }
		    }
		});

		th.setContextClassLoader(cl);
		th.start();

		th.join();
		
		
		
		
	}
	
}
