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
public class EmptyTile extends Tile{
    
    protected EmptyTile(final int coordinate) {
            super(coordinate);
        }
        
        @Override
        public boolean isTileOccupied(){
            return false;
        }
        
        @Override
        public Piece getPiece(){
            return null;
        }
}
