package com.vcu.readers.datamining;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MuskParser {

    List<String> muskZero = new ArrayList();
    List<String> muskOne = new ArrayList();
   
    private String FILE_NAME = "C:/Users/Gaurav Bahl/Downloads/musk1-Discrete_2.arff";
   
    public static void main(String[] args) {
        new MuskParser();
    }
   
    public MuskParser() {
        try{
            BufferedReader fileReader = new BufferedReader(new FileReader(FILE_NAME));
           
            String line = null;
            while((line = fileReader.readLine() ) != null){
                processLine(line);
            }
        } catch(Exception ex){
            ex.printStackTrace();
        }
       
        System.out.println(muskOne.size());
        System.out.println(muskZero.size());
    }

    /**
     *
     * @param line
     */
    private void processLine(String line) {
    	
        if(line.startsWith("MUSK") || line.startsWith("NON-MUSK")){
            myTry(line);
           
            /*if("0".equals(muskLine[2])){
                muskZero.add(muskLine[1]);
            } else if("1".equals(muskLine[2])){
                muskOne.add(muskLine[1]);
            }*/
        }
    }


    private void myTry(String line){
    	
    	if(line.contains("MUSK")){
    		String[] split = line.split(",\",");
    		if("1".equals(split[1])){
    			String[] split2 = split[0].split(",\"");
    			muskOne.add(split2[1]);
    			//System.out.println(muskOne);
    		}else if(line.contains("NON-MUSK")){
    			String[] split2 = split[0].split(",\"");
    			muskZero.add(split2[1]);
    			//System.out.println(muskZero);
    		}
    		
    	}
    	
    }
    
    private String[] splitMuskLine(String line) {
        Pattern pattern = Pattern.compile("^(?<muskId>MUSK-\\p{Alnum}*),\"(?<muskList>.*)\",(?<flag>[01]+)$");
        Matcher matcher = pattern.matcher(line);
       
        if(matcher.matches()){
            String muskid = matcher.group("muskId");
            String muskList = matcher.group("muskList");
            String flag = matcher.group("flag");
           
            return new String[]{ muskid, muskList, flag};
        }

        return new String[]{};
    }
   
   
}