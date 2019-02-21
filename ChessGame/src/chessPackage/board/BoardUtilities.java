/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessPackage.board;

/**
 *
 * @author tonip
 */
public class BoardUtilities {
    
    public static final int NUM_TILES = 64;
    public static final int NUM_TILES_PER_ROW = 8;
    
private static boolean[] initialColumn(int columnNumber) {     
        final boolean[] column = new boolean[NUM_TILES];
        do{
            column[columnNumber] = true;
            columnNumber += NUM_TILES_PER_ROW;
        }while(columnNumber < 64);
        return column;
    }

    public static final boolean[] FIRST_COLUMN = initialColumn(0);
    public static final boolean[] SECOND_COLUMN = initialColumn(1);
    public static final boolean[] SEVENTH_COLUMN = initialColumn(6);
    public static final boolean[] EIGHTH_COLUMN = initialColumn(7);
    
    public static final boolean[] SECOND_ROW = null;
    public static final boolean[] SEVENTH_ROW = null;
    
    
    private BoardUtilities(){
        throw new RuntimeException("Cannot be instantiated!");
    }
    
    
    /**
     *
     * @param coordinate the value of coordinate
     * @return the boolean
     */
    public static boolean isValidTileCoordinate(final int coordinate) {
        return coordinate >= 0 && coordinate < 64;
    }
    
}
