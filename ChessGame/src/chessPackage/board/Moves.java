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
public abstract class Moves {
    
    
    final Board board;
    final Piece movedPiece;
    final int destinationCoordinate;
   
    private Moves(final Board board,
          final Piece movedPiece,
          final int destinationCoordinate) {
        this.board = board;
        this.movedPiece = movedPiece;
        this.destinationCoordinate = destinationCoordinate;
    }
    
    public static final class MajorMove extends Moves{
        
       public MajorMove(Board board, Piece movedPiece, int destinationCoordenate) {
            super(board, movedPiece, destinationCoordenate);
        }
    }
    
    public static final class AttackMove extends Moves{
    
    final Piece attackedPiece;
    
   public AttackMove(final Board board, 
               final Piece movedPiece,
               final int destinationCoordenate,
               final Piece attackedPiece) {
            super(board, movedPiece, destinationCoordenate);
            this.attackedPiece = attackedPiece;
}
}
}