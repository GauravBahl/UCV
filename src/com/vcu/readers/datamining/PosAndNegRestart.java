package com.vcu.readers.datamining;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PosAndNegRestart {

    private static final int threshold = 166;

    //private static final int threshold = 6;

    //SMALL
    private static String FILE_NAME = "C:/Users/Gaurav Bahl/Downloads/musk1-10-1tra-Discrete.arff";

    private static String TEST_FILE = "C:/Users/Gaurav Bahl/Desktop/TestFile.txt";

 
    
    //LARGE
    private static String FILE_NAME_UPDATED = "C:/Users/Gaurav Bahl/Downloads/musk1-Discrete_1.arff";

    private static ArrayList<String> positiveList = new ArrayList<String>();

    private static ArrayList<String> negativeList = new ArrayList<String>();

	private static String TEMP_FILE_PATH = "C:/Users/Gaurav Bahl/Downloads/montu1.txt";

	public static void main(String[] args) throws IOException {
    	
    	   
        //System.out.println(replaceBackSlash("\n33"));
        readMuskFile();

        //String data = "[\\n32, 6, 12, 1, 0, 0, 42, 44, 42, 17, 87, 78, 47, 45, 45, 29, 76, 38, 99, 61, 72, 17, 94, 14, 6, 73, 85, 82, 0, 8, 1, 12, 16, 19, 10, 3, 0, 77, 1, 51, 15, 18, 25, 77, 71, 97, 37, 78, 60, 30, 49, 37, 58, 101, 0, 51, 62, 40, 0, 12, 1, 0, 43, 5, 3, 29, 1, 38, 1, 21, 12, 2, 81, 56, 42, 4, 44, 81, 82, 74, 100, 24, 60, 0, 13, 52, 42, 59, 0, 3, 0, 1, 3, 43, 56, 17, 0, 61, 4, 51, 14, 16, 67, 75, 47, 67, 20, 76, 39, 64, 34, 114, 103, 83, 46, 72, 11, 94, 67, 75, 7, 0, 0, 3, 11, 9, 21, 17, 29, 1, 53, 2, 44, 26, 39, 55, 96, 66, 82, 49, 71, 53, 44, 31, 2, 6, 9, 23, 31, 63, 21, 2, 0, 2, 29, 2, 10, 50, 3, 10, 37, 18, 9, 15, 45, 42, \n34, 0, 0, 14, 0, 112, 8, 88, 6, 101, 47, 35, 28, 71, 51, 31, 4, 78, 72, 70, 6, 5, 24, 97, 31, 34, 0, 8, 27, 51, 1, 14, 13, 76, 9, 4, 12, 0, 1, 0, 2, 20, 48, 64, 57, 45, 2, 13, 98, 82, 17, 4, 18, 31, 58, 61, 4, 0, 80, 80, 0, 0, 43, 88, 31, 31, 2, 0, 1, 0, 2, 0, 31, 65, 60, 5, 7, 102, 37, 25, 9, 6, 21, 67, 86, 15, 0, 33, 10, 91, 0, 2, 6, 56, 55, 16, 95, 7, 1, 1, 1, 16, 32, 40, 44, 110, 20, 16, 88, 39, 35, 13, 8, 13, 105, 60, 59, 19, 11, 1, 44, 82, 98, 2, 12, 12, 90, 77, 88, 1, 51, 2, 24, 49, 98, 0, 0, 0, 32, 77, 49, 0, 5, 5, 2, 5, 11, 0, 0, 0, 20, 5, 1, 0, 33, 0, 10, 48, 76, 10, 38, 18, 9, 14, 43, 42, 1]";
        //kuckKarnaPadega(data);
    }


    public static void readMuskFile() throws IOException {

    	
    	
            try{
                BufferedReader fileReader = new BufferedReader(new FileReader(FILE_NAME_UPDATED));

                String line = null;
                while((line = fileReader.readLine() ) != null){
                    processLine(line);
                }


            /*int posSize = positiveList.size();

            reducePOS(positiveList, 5);*/
            //System.out.println(muskOne.size());
            //System.out.println(muskZero.size());

            //System.out.println(positiveList);
           // System.out.println(negativeList);

                
            System.out.println("List of Positive Cases : "+positiveList.size());
            System.out.println("List of Negative Cases : " + negativeList.size());
            
            List<ArrayList<String>> Gpos = reducePOS(positiveList, threshold);
            List<ArrayList<String>> Gneg = reducePOS(negativeList, threshold);

            System.out.println("Gpos Size : " + Gpos.size());
            System.out.println("Gneg Size : " + Gneg.size());

            
            System.out.println("Gpos List : " + Gpos);
            System.out.println("Gneg List : " + Gneg);

            
            System.out.println("Check File created at location : " + TEMP_FILE_PATH);
            //System.out.println("GPOS : "+Gpos);
            //System.out.println("GNEG : "+Gneg);
            //rulesCreation(Gpos);

            
            
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }


     private static void rulesCreation(List<ArrayList<String>> gpos) {

         List<ArrayList<String>> rules = new ArrayList<ArrayList<String>>();
         int i = 1;

         int numberOfColumns = gpos.size();

         List<String> LIST = new ArrayList<String>();

         for (int j = 0; j <= numberOfColumns; j++) {
            LIST.add(String.valueOf(j));
         }


         HashMap<String, String> uniqueEachRowMap = new HashMap<String, String>();

         int nor = positiveList.size();
         int noc = positiveList.get(0).split(",").length-1;

         // uniqueness finder

         for(int w=0;w<noc;w++){
             for(int h=0;h<nor;h++){

             }
         }


         uniqueEachRowMap.put("0", "3");
         uniqueEachRowMap.put("1", "4");
         uniqueEachRowMap.put("2", "3");
         uniqueEachRowMap.put("3", "5");


         List<ArrayList<String>> sumOfTable = new ArrayList<ArrayList<String>>();

         System.out.println(gpos);

         if(gpos.size()>0){

             int lastColumn = gpos.get(0).size()-1;


            for(int y=0;y<gpos.size();y++){
                ArrayList<String> arrayList = gpos.get(y);
                String gkValue = arrayList.get(lastColumn);

                List<String> eachST = new ArrayList<String>();

                for(int h=0;h<arrayList.size()-1;h++){
                    String eachElement = arrayList.get(h);

                    if(!"*".equalsIgnoreCase(eachElement)){
                        String uniqueVal = uniqueEachRowMap.get(String.valueOf(h));
                        String multipliedValue = String.valueOf(Integer.valueOf(uniqueVal) * Integer.valueOf(gkValue));
                        eachST.add(multipliedValue);
                    }else{
                        eachST.add("*");
                    }
                }

                sumOfTable.add((ArrayList<String>) eachST);
            }



            //2.4 STEP

            System.out.println(selectMaxOfList(sumOfTable));



         }

    }


    private static int selectMaxOfList(List<ArrayList<String>> sumOfTable) {


        int max = 0;
        int positioni;
        int positionj=0;

        for(int i=0;i<sumOfTable.size();i++){
            for(int j=0;j<sumOfTable.get(i).size();i++){
                String string = sumOfTable.get(i).get(j);

                if(!"*".equals(string)){
                    max = Math.max(Integer.valueOf(string),max);
                    positioni = i;
                    positionj = j;
                }
            }

        }
        return max;

    }


    private static List<ArrayList<String>> reducePOS(ArrayList<String> positiveList2, int k) throws IOException {

    	
    	FileWriter writer = new FileWriter(TEMP_FILE_PATH);
    	
         List<ArrayList<String>> G = new ArrayList<ArrayList<String>>();
         int i = 0;

         String gk1Value = "1";

         List<String> temp = new ArrayList<String>();

         List<String> temp2 = new ArrayList<String>();
         //positiveList2.get(i);

         if(positiveList2.size()>0){
        	 
         String string = positiveList2.get(0);
         String[] smallArray = string.split(",");

         // temp = d1
         //temp = convertArrayToListCustom(smallArray);

         temp = new ArrayList<>(Arrays.asList(smallArray));

         G.add(i, new ArrayList<>(Arrays.asList(smallArray)));

         int size = G.get(i).size();

         ArrayList<String> GK1 = G.get(i);
         GK1.add(gk1Value);


        // G.add(i,GK1);

         /*String[] updateArray = GK1.split(",");
         G.add(i, (ArrayList<String>) convertArrayToListCustom(updateArray));*/

         G.set(i,GK1);


         int numberOfRows = positiveList2.size();
         int numberOfColumn = k-1;
         //System.out.print(numberOfColumn + " " +  numberOfRows + " ");
         int lastW = 0;

         try{
         for(int j=1;j<numberOfRows;j++){

             //numberOfColumn = positiveList2.get(i).length();

             int counterNonStar = 0;

             for(int kk=0;kk<numberOfColumn;kk++){


                 String dj = positiveList2.get(j);
                 String[] djk = dj.split(",");
                 lastW = kk;

            //  System.out.print(convertArrayToListCustom(smallArray).size() + " " + djk.length + " " + numberOfColumn + " ");

                // System.out.println("Size djk : " + djk.length);
                // System.out.println("Small Array : " + convertArrayToListCustom(smallArray).size());
                // System.out.println("numberOfColumn : " + (numberOfColumn-1));

           if(!replaceBackSlash(replacer(djk[kk])).trim().equals(replaceBackSlash(replacer(new ArrayList<>(Arrays.asList(smallArray)).get(kk))).trim()) || replaceBackSlash(replacer(djk[kk])).trim() == "*"){
                    //temp2 = temp;
                    //String string2 = temp.get(kk);
        	   
        	        if(kk<=temp.size()-1){
        	        	temp.set(kk, "*");
        	        	//continue;
        	        }else{
        	        	continue;
        	        }
        	        
        	        
                    //temp2.set(kk,string2);
                 }else{
                     counterNonStar++;
                 }
             }

             //writer.write("\n");
             
             if(counterNonStar>=2){

                    int oldSize = G.size();
                    int internalSize = G.get(oldSize-1).size();
                    String toBeReplaced = G.get(oldSize-1).get(internalSize-1);
                    int replacedLast = Integer.valueOf(toBeReplaced);
                    G.get(oldSize-1).set(internalSize-1, String.valueOf(++replacedLast));

                    ArrayList<String> arrayList = G.get(i);
                    String string2 = arrayList.get(arrayList.size()-1);

                    List<String> interTemp = new ArrayList<>(temp);
                    if(interTemp.size()<=k-1){
                        interTemp.add(string2);
                        G.set(i, (ArrayList<String>) interTemp);
                    }
                    
                    writer.write(G.toString());
                    writer.write("\n");
             }else{
                 i++;
                 String[] splitValue = positiveList2.get(j).split(",");
                 ArrayList<String> convertArrayToListCustom = new ArrayList<>(Arrays.asList(splitValue));
                 G.add(i,convertArrayToListCustom);

            //     int size1 = G.get(i).size();

                 ArrayList<String> GKi = G.get(i);
                 GKi.add(gk1Value);
                 G.set(i,GKi);

                 temp = convertArrayToListCustom(positiveList2.get(j).split(","));
                 
                 writer.write(G.toString());
                 writer.write("\n");

             }
         }}catch(Exception e){
             System.out.println(numberOfColumn-1);
             System.out.println(lastW);
             e.printStackTrace();
     }

         }
         return G;
     }


     private static ArrayList<String> convertArrayToListCustom(String[] smallArray) {

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


     private static String replacer(String toBeReplaced) {

            if(toBeReplaced.contains("[")){
                toBeReplaced = toBeReplaced.replace("[", "");
            }else if(toBeReplaced.contains("]")){
                toBeReplaced = toBeReplaced.replace("]", "");
            }

            return toBeReplaced.trim();
        }

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

         if(line.contains("NON-MUSK")){
            /*String[] split = line.split(",\",");
             String[] split2 = split[0].split(",\"");
             split2[1]+=",0";
             if(split2[1].length()>threshold){
                 int parts = split2[1].length()/threshold;
                 int start = 0;
                 for(int i=0;i<parts;i++){

                     int end = start + threshold - 1;
                     positiveList.add(split2[1].substring(start, end));
                     start += threshold;
                 }
             }else{
                 positiveList.add(split2[1]);
             }*/

            String[] split = line.split(",\",");
            String[] split2 = split[0].split(",\"");
             split2[1]+=",1";
             String[] split3 = split2[1].split(",");
             if(split3.length>threshold){
                 int parts = split3.length/threshold;
                 int start = 0;
                 for(int i=0;i<parts;i++){

                     int end = start + threshold - 1;

positiveList.add(replaceBackSlash(Arrays.asList(split3).subList(start, end).toString()));
                     start += threshold;
                 }
             }else{
                 positiveList.add(split2[1]);
             }


             //muskZero.add(split2[1]);
             //System.out.println(muskZero);
         }else if(line.contains("MUSK")){
                String[] split = line.split(",\",");
                if("1".equals(split[1])){
                    String[] split2 = split[0].split(",\"");
                    split2[1]+=",1";
                    String[] split3 = split2[1].split(",");
                    if(split3.length>threshold){
                        int parts = split3.length/threshold;
                        int start = 0;
                        for(int i=0;i<parts;i++){

                            int end = start + threshold - 1;

negativeList.add(replaceBackSlash(Arrays.asList(split3).subList(start, end).toString()));
                            start += threshold;
                        }
                    }else{
negativeList.add(replaceBackSlash(split2[1]));
                    }

                    //muskOne.add(split2[1]);
                    //System.out.println(muskOne);

                }else if("0".equals(split[1])){/*
                        String[] split2 = split[0].split(",\"");
                        split2[1]+=",0";
                        if(split2[1].length()>threshold){
                            int parts = split2[1].length()/threshold;
                            int start = 0;
                            for(int i=0;i<parts;i++){

                                int end = start + threshold - 1;
positiveList.add(split2[1].substring(start, end));
                                start += threshold;
                            }
                        }else{
                            positiveList.add(split2[1]);
                        }
                    */

                    //String[] split = line.split(",\",");
                    String[] split2 = split[0].split(",\"");
                     split2[1]+=",1";
                     String[] split3 = split2[1].split(",");
                     if(split3.length>threshold){
                         int parts = split3.length/threshold;
                         int start = 0;
                         for(int i=0;i<parts;i++){

                             int end = start + threshold - 1;

positiveList.add(replaceBackSlash(Arrays.asList(split3).subList(start, end).toString()));
                             start += threshold;
                         }
                     }else{
positiveList.add(replaceBackSlash(split2[1]));
                     }

                }
                }

            }


     public static String replaceBackSlash(String str){

         if(str.contains("\\n")){
            str =  str.replace("\\n", "");
         }

         return str;

     }

}

