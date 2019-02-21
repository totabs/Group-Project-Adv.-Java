/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessPackage.board;

import chessPackage.pieces.Piece;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author tonip
 */
public abstract class Tile {

    
    
   protected static int tileCoordenate;
    
   private static final Map<Integer, EmptyTile> EMPTY_TILES_CACHE = createAllPossibleEmptyTiles();
    
   private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles() {
        
       final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();
       
       for (int i = 0; i < BoardUtilities.NUM_TILES; i++){
           emptyTileMap.put(i, new EmptyTile(i));
       }
       
       return Collections.unmodifiableMap(emptyTileMap); 
    }
   
   public static Tile createTile(final int tileCoordinate, final Piece piece){
       return piece != null ? new OccupiedTile(tileCoordenate, piece) : EMPTY_TILES_CACHE.get(tileCoordinate);
   }
   
    protected Tile(final int tileCoordinate) {
       this.tileCoordenate = tileCoordinate;
    }
    
    public abstract boolean isTileOccupied();
    
    public abstract Piece getPiece();
    
  
   
}
