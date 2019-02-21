/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessPackage.pieces;

import chessPackage.Alliance;
import chessPackage.board.Board;
import chessPackage.board.Moves;
import java.util.Collection;


import java.util.List;

/**
 *
 * @author tonip
 */
public abstract class Piece {
    
    protected int piecePosition;
    protected Alliance pieceAlliance;
    protected boolean isFirstMove;
    
    
    Piece(Alliance pieceAlliance, final int piecePosition){
    this.pieceAlliance = pieceAlliance;
    this.piecePosition = piecePosition;
    //.....
    this.isFirstMove = false;
}
    
    public Integer getPiecePosition(){
        return this.piecePosition;
    }
    
    
    public Alliance getPieceAlliance(){
        return this.pieceAlliance;
    }

    public boolean isFirstMove(){
        return this.isFirstMove;
    }
    
    public abstract List<Moves> calculateAllowedMoves(final Board board);

    public Collection<? extends Moves> calculateLegalMoves(Board aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
