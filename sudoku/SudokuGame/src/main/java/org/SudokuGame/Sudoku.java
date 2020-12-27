package org.SudokuGame;

public class Sudoku {
	public int[][] sudokuTable = new int[9][9];
	
	 
	    
	    public void initSudokuTable() {
	        for (int i = 0;i < sudokuTable.length; i++) {
	            for (int j = 0;j < sudokuTable[i].length;j++) {
	            	
	            	//33% of chances to put a number instead of blank field
	         	   if((int)(Math.random() * ((3 - 1) + 1)) == 1 )
	         		   sudokuTable[i][j] = 1 + (int)(Math.random() * ((9 - 1) + 1));
	         	   else 
	         		  sudokuTable[i][j] = 0; 
	         	   
	            }
	            //We test the line
	            if(!checkLine(sudokuTable, i))
	            	i = i - 1 ;//If the line is incorrect, we're remaking it
	         }
	         
	         if(!checkAllColumns(sudokuTable))
	            initSudokuTable();
	        
	         if(!checkAllRegions(sudokuTable))
	        	 initSudokuTable();
	        	 
	    }
	    
	    //Function that test if I can add a number to a field
	    public boolean addValue(int columnNb, int lineNb, int value) {
	    	int column = columnNb-1;
	    	int line = lineNb-1;
	    	
	    	if(sudokuTable[column][line] == 0) {
	    		sudokuTable[column][line] = value;
	    		if (checkAllLines(sudokuTable) & checkAllRegions(sudokuTable) & checkAllColumns(sudokuTable)) {
	    			sudokuTable[column][line] = value;
		            System.out.println("Ajout réussi");
	    			return true;
	    		}
	    		else 
	    			// If the number is a bad answer, we remove it
	    			sudokuTable[column][line] = 0;
	    			throw new IllegalArgumentException("Faux ! Réessayez ! ");
	    	} else {
	    		throw new IllegalArgumentException("Erreure ! Il y a déjà une valeur dans cette case là");
	    	}
		}
	    	   

		public boolean checkLine(int[][] sudokuTable, int lineNumber) { //We check the line
	    	
	    	int [] arrayToCheck = sudokuTable[lineNumber];
	    	boolean [] activeNumbers = new boolean [10]; //Each field has an unique field, by default everything is false
	    				    	
	    	for (int i = 0;i < arrayToCheck.length; i++) {
	    		
	    		if(arrayToCheck[i] == 0) { //0 is an empty field
	    			continue;
	    		}
	    		if(activeNumbers[arrayToCheck[i]]) { //If the number was already find, then we return false
	    			return false;
	    		}
	    		else {
	    			activeNumbers[arrayToCheck[i]] = true;
	    		}
	    	}
	    	//If we didn't encountered any problem, then the line is correct
	    	return true;
	    }
	    
	    public boolean checkColumn(int[][] sudokuTable, int columnNumber) { //We check a column
	    	
	    	
	    	int [] arrayToCheck = new int[9];
	    	for (int i = 0;i < 9; i++) {
	    	
	    		arrayToCheck [i]= sudokuTable[i][columnNumber];
	    	}
	    	
	    	
	    	
	    	boolean [] activeNumbers = new boolean [10]; //Each field has an unique field, by default everything is false
	    				    	
	    	for (int i = 0;i < arrayToCheck.length; i++) {
	    		
	    		if(arrayToCheck[i] == 0) { //0 is an empty field
	    			continue;
	    		}
	    		if(activeNumbers[arrayToCheck[i]]) { //If the number was already find, then we return false
	    			return false;
	    		}
	    		else {
	    			activeNumbers[arrayToCheck[i]] = true;
	    		}
	    	}
	    	//If we didn't encountered any problem, then the column is fine
	    	return true;
	    	
	    }
	    
	    public boolean checkRegion(int[][] sudokuTable, int regionNumber) { //9 possibles regions
	    	int [] arrayToCheck = new int[9];
	    	
	    	
	    	switch(regionNumber) {
	    	

	    	  case 1:
	    		  arrayToCheck [0] = sudokuTable[0][0];
	    		  arrayToCheck [1] = sudokuTable[0][1];
	    		  arrayToCheck [2] = sudokuTable[0][2];
	    		  arrayToCheck [3] = sudokuTable[1][0];
	    		  arrayToCheck [4] = sudokuTable[1][1];
	    		  arrayToCheck [5] = sudokuTable[1][2];
	    		  arrayToCheck [6] = sudokuTable[2][0];
	    		  arrayToCheck [7] = sudokuTable[2][1];
	    		  arrayToCheck [8] = sudokuTable[2][2];
	    	    break;
	    	  case 2:
	    		  arrayToCheck [0] = sudokuTable[0][3];
	    		  arrayToCheck [1] = sudokuTable[0][4];
	    		  arrayToCheck [2] = sudokuTable[0][5];
	    		  arrayToCheck [3] = sudokuTable[1][3];
	    		  arrayToCheck [4] = sudokuTable[1][4];
	    		  arrayToCheck [5] = sudokuTable[1][5];
	    		  arrayToCheck [6] = sudokuTable[2][3];
	    		  arrayToCheck [7] = sudokuTable[2][4];
	    		  arrayToCheck [8] = sudokuTable[2][5];
	    	    break;
	    	  case 3:
	    		  arrayToCheck [0] = sudokuTable[0][6];
	    		  arrayToCheck [1] = sudokuTable[0][7];
	    		  arrayToCheck [2] = sudokuTable[0][8];
	    		  arrayToCheck [3] = sudokuTable[1][6];
	    		  arrayToCheck [4] = sudokuTable[1][7];
	    		  arrayToCheck [5] = sudokuTable[1][8];
	    		  arrayToCheck [6] = sudokuTable[2][6];
	    		  arrayToCheck [7] = sudokuTable[2][7];
	    		  arrayToCheck [8] = sudokuTable[2][8];
	    	    break;
	    	  case 4:
	    		  arrayToCheck [0] = sudokuTable[3][0];
	    		  arrayToCheck [1] = sudokuTable[3][1];
	    		  arrayToCheck [2] = sudokuTable[3][2];
	    		  arrayToCheck [3] = sudokuTable[4][0];
	    		  arrayToCheck [4] = sudokuTable[4][1];
	    		  arrayToCheck [5] = sudokuTable[4][2];
	    		  arrayToCheck [6] = sudokuTable[5][2];
	    		  arrayToCheck [7] = sudokuTable[5][1];
	    		  arrayToCheck [8] = sudokuTable[5][2];
	    	    break;
	    	  case 5:
	    		  arrayToCheck [0] = sudokuTable[3][3];
	    		  arrayToCheck [1] = sudokuTable[3][4];
	    		  arrayToCheck [2] = sudokuTable[3][5];
	    		  arrayToCheck [3] = sudokuTable[4][3];
	    		  arrayToCheck [4] = sudokuTable[4][4];
	    		  arrayToCheck [5] = sudokuTable[4][5];
	    		  arrayToCheck [6] = sudokuTable[5][3];
	    		  arrayToCheck [7] = sudokuTable[5][4];
	    		  arrayToCheck [8] = sudokuTable[5][5];
	    	    break;
	    	  case 6:
	    		  arrayToCheck [0] = sudokuTable[3][6];
	    		  arrayToCheck [1] = sudokuTable[3][7];
	    		  arrayToCheck [2] = sudokuTable[3][8];
	    		  arrayToCheck [3] = sudokuTable[4][6];
	    		  arrayToCheck [4] = sudokuTable[4][7];
	    		  arrayToCheck [5] = sudokuTable[4][8];
	    		  arrayToCheck [6] = sudokuTable[5][6];
	    		  arrayToCheck [7] = sudokuTable[5][7];
	    		  arrayToCheck [8] = sudokuTable[5][8];
	    	    break;
	    	  case 7:
	    		  arrayToCheck [0] = sudokuTable[6][0];
	    		  arrayToCheck [1] = sudokuTable[6][1];
	    		  arrayToCheck [2] = sudokuTable[6][2];
	    		  arrayToCheck [3] = sudokuTable[7][0];
	    		  arrayToCheck [4] = sudokuTable[7][1];
	    		  arrayToCheck [5] = sudokuTable[7][2];
	    		  arrayToCheck [6] = sudokuTable[8][2];
	    		  arrayToCheck [7] = sudokuTable[8][1];
	    		  arrayToCheck [8] = sudokuTable[8][2];
	    	    break;
	    	  case 8:
	    		  arrayToCheck [0] = sudokuTable[6][3];
	    		  arrayToCheck [1] = sudokuTable[6][4];
	    		  arrayToCheck [2] = sudokuTable[6][5];
	    		  arrayToCheck [3] = sudokuTable[7][3];
	    		  arrayToCheck [4] = sudokuTable[7][4];
	    		  arrayToCheck [5] = sudokuTable[7][5];
	    		  arrayToCheck [6] = sudokuTable[8][3];
	    		  arrayToCheck [7] = sudokuTable[8][4];
	    		  arrayToCheck [8] = sudokuTable[8][5];
	    	    break;
	    	  case 9:
	    		  arrayToCheck [0] = sudokuTable[6][6];
	    		  arrayToCheck [1] = sudokuTable[6][7];
	    		  arrayToCheck [2] = sudokuTable[6][8];
	    		  arrayToCheck [3] = sudokuTable[7][6];
	    		  arrayToCheck [4] = sudokuTable[7][7];
	    		  arrayToCheck [5] = sudokuTable[7][8];
	    		  arrayToCheck [6] = sudokuTable[8][6];
	    		  arrayToCheck [7] = sudokuTable[8][7];
	    		  arrayToCheck [8] = sudokuTable[8][8];
	    	    break;
	    	  default:
	    	    // code block
	    	}

	        
	    	boolean [] activeNumbers = new boolean [10]; //Each field has an unique field, by default everything is false
	    			
	    	
	    	for (int i = 0;i < arrayToCheck.length; i++) {
	    		
	    		if(arrayToCheck[i] == 0) { //0 is an empty field
	    			continue;
	    		}
	    		if(activeNumbers[arrayToCheck[i]]) { //If the number was already find, then we return false
	    			return false;
	    		}
	    		else {
	    			activeNumbers[arrayToCheck[i]] = true;
	    		}
	    	}
	    	//If we didn't encountered any problem, then the region is good
	    	return true;
	    }
	    
	    public boolean checkAllRegions(int[][] sudokuTable) {
			for (int i = 1;i < 10; i++) {
				if (!checkRegion(sudokuTable,i))
					return false;
			}
			return true;
		}

		public boolean checkAllColumns(int[][] sudokuTable) {
			for (int i = 0;i < 9; i++) {
				if (!checkColumn(sudokuTable,i))
					return false;
			}
			return true;
		}
		public boolean checkAllLines(int[][] sudokuTable) {
			for (int i = 0;i < 9; i++) {
				if (!checkLine(sudokuTable,i))
					return false;
			}
			return true;
		}

		public boolean hasWin() {
	        for (int i = 0;i < sudokuTable.length; i++) {
	            for (int j = 0;j < sudokuTable[i].length;j++) {
	            	if(sudokuTable[i][j] == 0)
	            		return false;
	            }
	        }    
			return true;
		}



		
}
