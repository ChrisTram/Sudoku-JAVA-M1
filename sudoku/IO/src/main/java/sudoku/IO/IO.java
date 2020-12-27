package sudoku.IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IO 
{
    public boolean save(int[][] sudokuTable, String saveName) throws IOException {
    	
    	String strToWrite = new String();
    	String strBackToLine = System.getProperty("line.separator");

        for (int i = 0;i < sudokuTable.length; i++) {
            for (int j = 0;j < sudokuTable[i].length;j++) {
            	strToWrite += sudokuTable[i][j];
            }
        	strToWrite += strBackToLine;
        }

        BufferedWriter writer = new BufferedWriter (new OutputStreamWriter(new FileOutputStream(saveName)));
        writer.write(strToWrite);
         
        writer.close();
        System.out.println( "La grille " + saveName + " est sauvegardée !" );
        return true;	
    }
    
    
    public int[][] load(String saveName) {
    	  	
        BufferedReader reader = null;
        int[][] table = new int[9][9];
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(saveName)));
            String line;
            int j = 0;
            while ((line = reader.readLine()) != null) {
                for(int i = 0; i < 9 ; i++) {
                	 table[j][i]= Character.getNumericValue(line.charAt(i));
                }
                j++;
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            	System.out.println( "La table " + saveName + " est chargée !" );
                return table;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        return table;
    	
    }
    //Uses at launch
    private InputStreamReader getFileFromResources(String fileName) {
    	System.out.println( "1" );

        ClassLoader classLoader = getClass().getClassLoader();

        InputStream resource = classLoader.getResourceAsStream(fileName);
    	System.out.println( "2" );
    	System.out.println( "resource URL : " + resource);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new InputStreamReader(resource);
        }
        

    }


	public int[][] getTableFromResources() {

		int randomNb = 1 + (int)(Math.random() * ((9 - 1) + 1));
    	System.out.println( "0" );

    	System.out.println( "3" );

        BufferedReader reader = null;
        int[][] table = new int[9][9];
        try {
        	reader = new BufferedReader(this.getFileFromResources("table" + randomNb));
            String line;
            int j = 0;
            while ((line = reader.readLine()) != null) {
                for(int i = 0; i < 9 ; i++) {
                	 table[j][i]= Character.getNumericValue(line.charAt(i));
                }
                j++;
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            	System.out.println( "La table numero " + randomNb +  " des ressources est chargée !" );
                return table;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        return table;
    	
	}


	public int[][] getTableFromPath(String strPath) {
		BufferedReader reader = null;
        int[][] table = new int[9][9];
        try {
            reader = new BufferedReader(new FileReader(strPath));
            String line;
            int j = 0;
            while ((line = reader.readLine()) != null) {
                for(int i = 0; i < 9 ; i++) {
                	 table[j][i]= Character.getNumericValue(line.charAt(i));
                }
                j++;
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            	System.out.println( "Le chemin " + strPath + " est chargée !" );
                return table;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        return table;
	}
}
