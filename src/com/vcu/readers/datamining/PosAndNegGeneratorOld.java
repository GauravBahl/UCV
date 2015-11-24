package com.vcu.readers.datamining;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;

public class PosAndNegGeneratorOld {

	private static final String OUTPUT_CSV_PATH = "C:/Users/Gaurav Bahl/Downloads/clean_output17.csv";

	private static final String TEMP_FILE_PATH = "C:/Users/Gaurav Bahl/Downloads/compared4.txt";

	private static String FILE_NAME = "C:/Users/Gaurav Bahl/Downloads/musk1-10-1tra-Discrete.arff";
	
	public static void main(String[] args) {
		posAndNegGenerator(OUTPUT_CSV_PATH);
		//readMuskFile();
	}

	private static void posAndNegGenerator(String outputCsvPath) {

		try {
			CSVReader reader = new CSVReader(new FileReader(outputCsvPath));

			// Read CSV line by line and use the string array as you want
			String[] nextLine;
			int count = 0;
			while ((nextLine = reader.readNext()) != null) {
				if (nextLine != null) {
					// Verifying the read data here

					count++;
					// System.out.println(count);

					if (count <= 3) {
						continue;
					}

					String string = Arrays.toString(nextLine);
					
					if(string.contains("1 ]") || string.contains("1]")){
						
		//				System.out.println(string);
						createPOS(string);
						
					}else if(string.contains("0 ]") || string.contains("0]")){
						
	//					System.out.println(string);
						createNEG(string);
					}
					
					
					
				}
			}
			
			//System.out.println("POS : "+ positiveList.size());
			//System.out.println("NEG : " + negativeList.size());
			//System.out.println(count-3);
			
			System.out.println(positiveList);
			
			// Testing POS
			
			reducePOS(positiveList, 5);
			
			//processPOS(positiveList);
			
			//processNEG(negativeList);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	/*
	 * Data Reducer for positive list
	 * */
	private static void reducePOS(ArrayList<String> positiveList2, int k) {
		
		List<List<String>> G = new ArrayList<List<String>>();
		//List<String> G = new ArrayList<String>();
		
		int i = 1;
		List<String> temp = new java.util.ArrayList<String>();
		String gk1Value = "1";
		
		if(positiveList2.size()>0){
		
			String string = positiveList2.get(0);
			String[] smallArray = string.split(",");
			temp = convertArrayToListCustom(smallArray);
			temp.add(gk1Value);
			G.add(temp);
		   
			
			// processing of remaing POS
			
			int flag = 0;
			
			for(int j=1;j<temp.size();j++){
				
				String secondRow = positiveList2.get(j);
				String[] d = secondRow.split(",");
				
				if(flag == 2){
					/*String string1 = positiveList2.get(j);
					String[] smallArray1 = string.split(",");*/
					temp = convertArrayToListCustom(d);
					temp.add(gk1Value);
				}
				
				
				
				int counterNonStar = 0;
				
				for(int kk=0;kk<k-1;kk++){
					//|| replacer(d[kk]) == "*"
					if(!replacer(d[kk]).equals(temp.get(kk)) || replacer(d[kk]) == "*"){
						temp.set(kk, "*");
						//G.get(j-1).set(kk, "*");
					}else{
						 counterNonStar++;
					}
				}
				
				
				
				if(counterNonStar>=2){
					int size = G.size();
					int internalSize = G.get(size-1).size();
					String toBeReplaced = G.get(size-1).get(internalSize-1);
					int replacedLast = Integer.valueOf(replacer(toBeReplaced));
					G.get(size-1).set(internalSize-1, String.valueOf(++replacedLast));
					flag = 1;
				//	System.out.println(G);
				}else{
					flag = 2;
					int getCurrentSize = G.size();
					getCurrentSize = getCurrentSize++;
					G.add(getCurrentSize,Arrays.asList(positiveList2.get(j).split(",")));
					//temp = G.get(getCurrentSize);
					//temp = positiveList2.get(j);
					
				}
				
			}
			
			System.out.println(G);
		}
		
	}
	
	
	


	private static List<String> convertArrayToListCustom(String[] smallArray) {
			
		String[] tempArray = new String[smallArray.length-1];
		List<String> returnList = new ArrayList<String>();
		if(smallArray.length>0){
			
			for(int i=0;i<smallArray.length-1;i++){
				tempArray[i] = replacer(smallArray[i]);
			}
				
		}
		
		returnList = Arrays.asList(tempArray);
		return new ArrayList<>(returnList);
	}





	private static ArrayList<String> negativeList = new ArrayList<String>();
	
	private static void createNEG(String string) {
		negativeList.add(string);
		
	}

	private static ArrayList<String> positiveList = new ArrayList<String>();;
	
	private static void createPOS(String string) {
		
		positiveList.add(string);	
		
	}

	
	private static void processNEG(ArrayList<String> negativeList2) throws IOException {

		FileWriter writer = new FileWriter(TEMP_FILE_PATH);
		int negSize = negativeList2.size();
		
		for(int i=0;i<negSize-1;i++){
			String toBeCompared = negativeList2.get(i);
			for(int j=0;j<negSize-1;j++){
				if(i==j){
					continue;
				}else{
					String comparedWith = negativeList2.get(j);
					
					String[] eachValue = toBeCompared.split(",");
					String[] iteratedValue = comparedWith.split(",");
					
					for(int k =0;k<eachValue.length;k++){
						StringBuilder builder = new StringBuilder();
						//for(int p=0;p<iteratedValue.length;p++){
							//System.out.println("EACH VALUE : "+eachValue[k].trim() + "------" + "ITERATED VALUE : " + iteratedValue[p].trim());
							
							
							
							
							eachValue[k] = replacer(eachValue[k].trim());
							iteratedValue[k] = replacer(iteratedValue[k].trim());
							
							if(eachValue[k].trim().equals(iteratedValue[k].trim())){
								//System.out.print("true ----");
								builder.append("true");
							}else{
								builder.append("false");
								//System.out.print("false -----");
							}
							
							builder.append("---");
						//}
/*						if(i>1){
							return;
						}*/
							//System.out.print(builder.toString());
					  writer.write(builder.toString());
					}
					
					writer.write("\n");
				}
			}
			
			writer.write("********************************************************************************************************************");
		}
		
	}

	private static String replacer(String toBeReplaced) {
		
		if(toBeReplaced.contains("[")){
			toBeReplaced = toBeReplaced.replace("[", "");
		}else if(toBeReplaced.contains("]")){
			toBeReplaced = toBeReplaced.replace("]", "");
		}
		
		return toBeReplaced.trim();
	}

	private static void processPOS(ArrayList<String> positiveList2) throws IOException {
		
		FileWriter writer = new FileWriter(TEMP_FILE_PATH);
		int posSize = positiveList2.size();
		
		for(int i=0;i<posSize-1;i++){
			String toBeCompared = positiveList2.get(i);
			for(int j=0;j<posSize-1;j++){
				if(i==j){
					continue;
				}else{
					String comparedWith = positiveList2.get(j);
					
					String[] eachValue = toBeCompared.split(",");
					String[] iteratedValue = comparedWith.split(",");
					
					for(int k =0;k<eachValue.length;k++){
						StringBuilder builder = new StringBuilder();
						//for(int p=0;p<iteratedValue.length;p++){
							//System.out.println("EACH VALUE : "+eachValue[k].trim() + "------" + "ITERATED VALUE : " + iteratedValue[p].trim());
							
							
							
							
							eachValue[k] = replacer(eachValue[k].trim());
							iteratedValue[k] = replacer(iteratedValue[k].trim());
							
							if(eachValue[k].trim().equals(iteratedValue[k].trim())){
								//System.out.print("true ----");
								builder.append(eachValue[k] + " ");
							}else{
								builder.append("*");
								//System.out.print("false -----");
							}
							
							builder.append("---");
						//}
/*						if(i>1){
							return;
						}*/
					  //System.out.print(builder.toString());
					  writer.write(builder.toString());
					}
					 
					writer.write("\n");
				}
			}
			
			writer.write("********************************************************************************************************************");
		}

		
		
		
	}

	
	public static void readMuskFile() {
		
        try{
            BufferedReader fileReader = new BufferedReader(new FileReader(FILE_NAME));
           
            String line = null;
            while((line = fileReader.readLine() ) != null){
                processLine(line);
            }
        } catch(Exception ex){
            ex.printStackTrace();
        }
       
        int posSize = positiveList.size();
        
        reducePOS(positiveList, posSize);
        //System.out.println(muskOne.size());
        //System.out.println(muskZero.size());
    }

    /**
     *
     * @param line
     */
    private static void processLine(String line) {
    	
        if(line.startsWith("MUSK") || line.startsWith("NON-MUSK")){
            myTry(line);
           
            /*if("0".equals(muskLine[2])){
                muskZero.add(muskLine[1]);
            } else if("1".equals(muskLine[2])){
                muskOne.add(muskLine[1]);
            }*/
        }
    }


    private static void myTry(String line){
    	
    	if(line.contains("MUSK")){
    		String[] split = line.split(",\",");
    		if("1".equals(split[1])){
    			String[] split2 = split[0].split(",\"");
    			negativeList.add(split2[1]);
    			//muskOne.add(split2[1]);
    			//System.out.println(muskOne);
    		
    		}else if("0".equals(split[1])){
        			String[] split2 = split[0].split(",\"");
        			positiveList.add(split2[1]);
    			}	
    		}else if(line.contains("NON-MUSK")){
    			String[] split = line.split(",\",");
    			String[] split2 = split[0].split(",\"");
    			positiveList.add(split2[1]);
    			//muskZero.add(split2[1]);
    			//System.out.println(muskZero);
    		}
    		
    	}
    	
    }
    

