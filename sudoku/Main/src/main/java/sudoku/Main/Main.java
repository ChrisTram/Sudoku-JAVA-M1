package sudoku.Main;

import org.SudokuGame.Sudoku;

import sudoku.GUI.*;
import sudoku.IO.*;

public class Main
{
	public static Sudoku sudoku = new Sudoku();
	public static IO io = new IO();
	public static GUI gui = new GUI();
    public static void main( String[] args )
    {
    	if(args.length == 0) {
        	start("fromResources");
    	} else {
    		start(args[0]);
    	}
    }
    
    public static void start(String strTableSource) {

    	if(strTableSource.equals("Random")) {
        	sudoku.initSudokuTable();
        	gui.displaySudoku(sudoku.sudokuTable);
        	gui.play(io, sudoku);
    	} else if (strTableSource.equals("fromResources")) {
    		sudoku.sudokuTable = io.getTableFromResources();
        	gui.displaySudoku(sudoku.sudokuTable);
        	gui.play(io, sudoku);
    	} else { //In this case the user asked for a path 
    		sudoku.sudokuTable = io.getTableFromPath(strTableSource);
    		gui.displaySudoku(sudoku.sudokuTable);
    		gui.play(io, sudoku);
    	}

    }
    
    

}