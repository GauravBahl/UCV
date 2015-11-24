package com.gaurav.testing;
public class MatrixRecreate
{
   public static void main(String[] args)
   {
      int[][] matrix = create();
      int[] rowcount = new int[matrix.length];
      int[] colcount = new int[matrix[0].length];
      count(matrix, rowcount, colcount);
      display(matrix, rowcount, colcount);
      re_create(rowcount, colcount);
   }
   
   public static int[][] create()
   {
      int rowsrandom = 2 + (int)(Math.random()*6); 
      int colrandom = 2 + (int)(Math.random()*6); 
      int [][] matrix = new int [rowsrandom] [colrandom] ;  
      for(int x=0;x<rowsrandom;x++)
      {
         for(int y=0;y<colrandom;y++)
         {
            matrix[x][y] = (int)(Math.random()*2);
        	// matrix[x][y] = 1;
         
         }
      }
      return matrix;
      
   
   }
   public static void count(int[][] matrix, int[] rowcount, int[] colcount)
   {
      
      
      int rowSize = matrix.length;
      int colSize = matrix[0].length;
   
      for(int row=0;row<rowSize;row++)
      {
    	  
    	 int counterRows=0;
    	  
         for(int col=0;col<colSize;col++){
            if(matrix[row][col]==1){
            	counterRows++;
            }
         
         }
         
         rowcount[row] = counterRows;
         
      }
      
   //   System.out.println(rowcount.length);
      
      
      for(int i=0;i<rowSize;i++){
    	  int counterCols = 0;
    	  for(int j=0;j<colSize;j++){
    		  if(matrix[i][j]==1 && i==j){
              	counterCols++;
              }else{
            	  continue;
              }
    		}
    	  
    	  colcount[i] = counterCols;
      }
      
     for(int k=0;k<colcount.length;k++){
    	 System.out.print(colcount[k] + "-");
     }
    
     System.out.println();
   }
   public static void display(int[][] matrix, int[] rowcount, int[] colcount)
   {
      int rows=matrix.length;
      int col=matrix[0].length;
   
      int x=0;
      /*while(x<rows)
      {
         for(int i=0;i<col;i++)
         {
            System.out.print(matrix[x][i]);
         
         }
         System.out.println();
         x++;
      }
      for(int i=0;i<col;i++)
      {
         if(matrix[i][0]==1)
         {
        	 
         }
      }*/
      
      
      for(int i=0;i<rows;i++){
    	  for(int j=0;j<col;j++){
    		  System.out.print(matrix[i][j]);
    	  }
    	  System.out.println();
      }
   }
   
   public static void re_create(int[] rowcount, int[] colcount)
   {
	
	   
	   
   }
   
   private static void recur(int[][] m, int[] rowcount, int[] colcount, int row, int col) //recursive helper method
   {
      if(compare(m, rowcount, colcount))    //base case: if new matrix works
      {
         display(m, rowcount, colcount);    //we're done!
         System.exit(0);
      }
   }
   
   
   private static boolean compare(int[][] m, int[] rowcount, int[] colcount)
   {
	   
	   return true;
   }
}

 



// if(row<array.length)
// {
// if(col<array[row].length)
//    {
//    array[row][col]=false;
//    fillWithFalse(array,row, col+1)
//    }
//    else{
//    fillWithFalse(array,row+1,0)
//    }
//  }