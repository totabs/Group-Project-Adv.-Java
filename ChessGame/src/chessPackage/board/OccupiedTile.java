/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessPackage.board;

import chessPackage.pieces.Piece;

/**
 *
 * @author tonip
 */
public class OccupiedTile extends Tile{
    
    private final Piece pieceOnTile;
        
       protected OccupiedTile(int tileCoordinate, final Piece pieceOnTile) {
            super(tileCoordinate);
            this.pieceOnTile= pieceOnTile;
        }
        
        @Override
        public boolean isTileOccupied(){
            return true;
        }
        
        @Override
        public Piece getPiece(){
            return this.pieceOnTile;
        }
}
