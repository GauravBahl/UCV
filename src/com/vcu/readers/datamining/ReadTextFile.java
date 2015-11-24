package com.vcu.readers.datamining;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class ReadTextFile {

	private static final String FILE_PATH= "C:/Users/Gaurav Bahl/Downloads/input_file.txt";
	
	private static final String CSV_PATH_INPUT = "C:/Users/Gaurav Bahl/Downloads/clean3.csv";
	
	private static final String CSV_PATH_OUTPUT = "C:/Users/Gaurav Bahl/Downloads/clean_output17.csv";
	
	public static void main(String[] args) {
		
		 Map<String, String> featureMap = readTextFile(FILE_PATH);
		 
		 readAndReplaceCSV(featureMap, CSV_PATH_INPUT, CSV_PATH_OUTPUT);
		 
		 System.out.println("File Created");
		  
	}

	private static void readAndReplaceCSV(Map<String, String> featureMap, String csvPathRead, String csvPathWrite) {
		try {
			
			CSVReader reader = new CSVReader(new FileReader(csvPathRead));
			CSVWriter writer = new CSVWriter(new FileWriter(csvPathWrite));
			
			 //Read CSV line by line and use the string array as you want
		      String[] nextLine;
		      int count=0;
		      while ((nextLine = reader.readNext()) != null) {
		         if (nextLine != null) {
		            //Verifying the read data here
		        	 
		        	count++;
		        	//System.out.println(count);
		        	
		        	
		        	
		        	if(count<=3){
		        		writer.writeNext(nextLine);
		        		continue;
		        	}
		        	
		            String string = Arrays.toString(nextLine);
		        	String[] finalStr = string.split(",");
		        	String[] replacedRecord;
		        	String replacedString = "";
		        	
		            //System.out.println(finalStr);
		        	for(int i=0;i<finalStr.length;i++){
		        		
		        		String selectedFeature = finalStr[i].trim();
		        		if(selectedFeature.contains("[")){
		        			selectedFeature = selectedFeature.replace("[", "").trim();
		        		}else if(selectedFeature.contains("]")){
		        			selectedFeature = selectedFeature.replace("]", "").trim();
		        		}
		        		
		        		/*if((i+1) == finalStr.length){
		        			replacedString = replacedString + selectedFeature+",";
		        		}*/
		        		
		        		//System.out.println(selectedFeature);
		        		
		        		if((i+1)==finalStr.length){
		        			replacedString = replacedString + selectedFeature+",";
		        		}
		        		
		        		if((i+1)>finalStr.length-1){
		        			continue;
		        		}
		        		
		        		
		        		
		        		String range = featureMap.get("F"+(i+1));
		        		//System.out.println("F"+(i+1) + "::::"+range);
		        		String pattern = "([\\[\\(].*[\\)\\]])([\\[\\(].*[\\)\\]])";
		        		Pattern r = Pattern.compile(pattern);
		        		
		        		 Matcher m = r.matcher(range);
		        	      if (m.find()) {
		        	        String group1 = m.group(1);
		        	        String group2 = m.group(2);
		        	        
		        	        String[] range1 = group1.split(",");
		        	        
		        	        if(range1[0].contains("[")   || range1[0].contains("(")){
		        	        	range1[0] = range1[0].replace("[", "");
		        	        }else if(range1[0].contains("]")){
		        	        	range1[0] = range1[0].replace("]","");
		        	        }else if(range1[0].contains(")")){
		        	        	range1[0] = range1[0].replace(")", "");
		        	        }else if(range1[0].contains("(")){
		        	        	range1[0] = range1[0].replace("(", "");
		        	        }
		        	        
		        	        
		        	        if(range1[1].contains("[")   || range1[1].contains("(")){
		        	        	range1[1] = range1[1].replace("[", "");
		        	        }else if(range1[1].contains("]")){
		        	        	range1[1] = range1[1].replace("]","");
		        	        }else if(range1[1].contains(")")){
		        	        	range1[1] = range1[1].replace(")", "");
		        	        }else if(range1[1].contains("(")){
		        	        	range1[1] = range1[1].replace("(", "");
		        	        }
		        	        
		        	        String[] range2 = group2.split(",");
		        	        
		        	        if(range2[0].contains("[")   || range2[0].contains("(")){
		        	        	range2[0] = range2[0].replace("[", "");
		        	        }else if(range2[0].contains("]")){
		        	        	range2[0] = range2[0].replace("]","");
		        	        }else if(range2[0].contains(")")){
		        	        	range2[0] = range2[0].replace(")", "");
		        	        }else if(range2[0].contains("(")){
		        	        	range2[0] = range2[0].replace("(", "");
		        	        }
		        	        
		        	        if(range2[1].contains("[")   || range2[1].contains("(")){
		        	        	range2[1] = range2[1].replace("[", "");
		        	        }else if(range2[1].contains("]")){
		        	        	range2[1] = range2[1].replace("]","");
		        	        }else if(range2[1].contains(")")){
		        	        	range2[1]= range2[1].replace(")", "");
		        	        }else if(range2[1].contains("(")){
		        	        	range2[1]= range2[1].replace("(", "");
		        	        }
		        	        
		        	        if(Double.valueOf(selectedFeature)>=Double.valueOf(range1[0]) && Double.valueOf(selectedFeature)<Double.valueOf(range1[1])){
		        	        //	System.out.println("Gaurav");
		        	        	//selectedFeature = "Gaurav";
		        	        
		        	        	//System.out.println(selectedFeature + "GAURAV");
		        	        	//System.out.println(group1);
		        	        	
		        	        	//replacedString = replacedString + "("+range1[0] + " TO " + range1[1]+")"+",";
		        	        	
		        	        	replacedString = replacedString + " 0 " + ",";
		        	        }else if(Double.valueOf(selectedFeature)>=Double.valueOf(range2[0]) && Double.valueOf(selectedFeature)<=Double.valueOf(range2[1])){
		        	        //	System.out.println("Montu");
		        	        	//selectedFeature = "Montu";
		        	        	//System.out.println(selectedFeature + "MONTU");
		        	        	//System.out.println(group2);
		        	        	//replacedString = replacedString + "("+range2[0] + " TO " + range2[1]+")"+",";
		        	        	replacedString = replacedString + " 1 " + ",";
		        	        }
		        	        
		        	      } else {
		        	         System.out.println("Match Not Found");
		        	      }
		        		
		        		
		        	}
		        	//System.out.println(replacedString);
		        	replacedRecord = replacedString.split(",");
		        	writer.writeNext(replacedRecord);
		         }
		       }
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static Map<String,String> readTextFile(String FILE_PATH) {
		
		Map<String,String> map = new HashMap<String, String>();
		
		BufferedReader br = null;

		try {

			String currentLine;

			br = new BufferedReader(new FileReader(FILE_PATH));

			String key = ""; 
			
			while ((currentLine = br.readLine()) != null) {
				
				if(currentLine.contains("Feautre:")){
					key = currentLine.split(":")[1].trim();
					map.put(key,"");
				}
				
				if(currentLine.contains(")[")){
					map.put(key, currentLine);
				}
				
				
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		return map;

	}
	
}
