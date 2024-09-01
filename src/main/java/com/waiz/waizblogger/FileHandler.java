package com.waiz.waizblogger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class FileHandler {
    
    public static File createDir(String name) {
        File newDir = new File(name);
		if(newDir.mkdirs()) {
			System.out.println("Directory" +name +"created successfully");
    		} 
		else {
			System.err.println("Project with "+name +" already exists");
		}

        return newDir;
    } 

    public static void copyDir(File source, File destination) {
        if(!destination.exists()) {
            destination.mkdir();
        }

        for(String f: source.list()) {
            copyDirRec(new File(source, f), new File(destination, f));
        }
    }

    private static void copyDirRec(File source, File destination) {
        if(source.isDirectory()) 
            copyDir(source, destination);
        else
            copyFile(source, destination);

    }

    public static void copyFile(File source, File destination) {
        try (InputStream in = new FileInputStream(source);
            OutputStream out = new FileOutputStream(destination)) {
                byte[] buf = new byte[1024];
                int len;
                while((len = in.read(buf)) > 0) 
                    out.write(buf,0, len);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFile(InputStream source, File destination) {
        try(OutputStream out = new FileOutputStream(destination)) {
            byte[] buf = new byte[1024];
            int len;
            while((len = source.read(buf)) > 0)
                out.write(buf,0,len);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFile(InputStream source, String destination) {
        copyFile(source , new File(destination));
    }

    public static void copyDir(String source, String destination) {
        File src = new File(source);
        File dest = new File(destination);

        copyDir(src, dest);
    }

    public static InputStream getResourceInputStream(String file) {
        InputStream in = FileHandler.class.getResourceAsStream(file);


        if(in == null) 
            throw new IllegalArgumentException("File " +file +" not found");
        else 
            return in;

    }

    public static void copyFileFromResource(String source, String destination) {
       InputStream in = getResourceInputStream(source);
       copyFile(in, destination); 
    }
   
}
