package sudoku.GUI;

import java.io.IOException;
import java.util.Scanner;

import org.SudokuGame.Sudoku;

import com.indvd00m.ascii.render.Render;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContextBuilder;
import com.indvd00m.ascii.render.elements.Table;
import com.indvd00m.ascii.render.elements.Text;

import sudoku.IO.IO;

public class GUI 
{
	public void displaySudoku(int[][] sudokuTable) {

       	Render sudokuR = new Render();
    		IContextBuilder builder = sudokuR.newBuilder();
    		builder.width(80).height(37);
    		Table table = new Table(10,10);
    			    		
    		// On ajoute le numéro des lignes / colomnes
    		table.setElement(1, 1, new Text("Num"));
    		for (int i = 2; i<=10; i++) {
    			table.setElement(1, i, new Text(Integer.toString(i-1)), true);
    		}
    		for (int i = 2; i<=10; i++) {
    			table.setElement(i, 1, new Text(Integer.toString(i-1)), true);
    		}
    		
    		//On remplit le tableau avec les valeurs aléatoires corrigées
    		int Ti = 0, Tj = 0; //Variables pour parcourir notre data Table
	        for (int Ei = 2;Ei <= 10; Ei++) {
	            for (int Ej = 2;Ej <= 10;Ej++) {
	            	if(sudokuTable[Ti][Tj] == 0 )
	            		table.setElement(Ei, Ej, new Text(" "));
	            	else
	            		table.setElement(Ei, Ej, new Text(Integer.toString(sudokuTable[Ti][Tj])));
		    		Ti++;
	            }
	            Ti = 0;
	            Tj++;
	        }    
	        
    		builder.element(table);
    		ICanvas canvas = sudokuR.render(builder.build());
    		String s = canvas.getText();
    		System.out.println(s);
    }

    public void play(IO io, Sudoku sudoku)
    {
    	System.out.println();
    	System.out.println( "Pour jouer, rentrez la colomne, la ligne puis le chiffre voulu" );
    	System.out.println( "Pour sauvegarder : save nomSauvegarde" );
    	System.out.println( "Pour charger une partie : load nomSauvegarde" );
    	System.out.println( "Pour quitter : quit" );
    	
        Scanner sc = new Scanner(System.in);
        String result = sc.nextLine();
             
        //save / load case
        if(result.length() > 3) {
            if(result.substring(0,4).equals("save")){
            	try {
					io.save(sudoku.sudokuTable, result.substring(5,result.length()));
					play(io, sudoku);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
            else if (result.substring(0,4).equals("load")){
            	sudoku.sudokuTable = io.load(result.substring(5,result.length()));
            	displaySudoku(sudoku.sudokuTable);
            	play(io, sudoku);
            } else if (result.substring(0,4).equals("quit")){
            	return; 
            } else {
            	System.out.println( "Erreure ! Avez vous bien écrit save ou load ?" );
            	play(io, sudoku);
            }
        }
        //The user is probably trying to play
        else if(result.length() == 3) {
            try {
            	if (Character.isDigit(result.charAt(0)) & Character.isDigit(result.charAt(1)) & Character.isDigit(result.charAt(2))) {
            		int line = Character.getNumericValue(result.charAt(0));	
                    int column = Character.getNumericValue(result.charAt(1));	
                    int value = Character.getNumericValue(result.charAt(2));
                    //If add() is a success, we can display the sudoku again
                    if(sudoku.addValue(column,line,value)) {
                    	displaySudoku(sudoku.sudokuTable);
                    	if(!sudoku.hasWin())
                    		play(io, sudoku);
                    	else {
                        	System.out.println( "Hourra ! Vous avez gagné !" );
                    	}
                    }
                    	
            	} else {
            		throw new IllegalArgumentException("Les trois valeurs doivent être des chiffres");
            	}
              } catch (Exception e) {
            	System.out.println("Erreure lors de l'ajout : " + e.getMessage());
            	play(io, sudoku);
              }

        //No command exists for this case
        } else { 
        	System.out.println( "Erreure ! Il faut taper au minimum 3 charactères" );
        	play(io, sudoku);
        }
    }
}
