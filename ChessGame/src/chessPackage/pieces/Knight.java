/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessPackage.pieces;

import chessPackage.Alliance;
import chessPackage.board.Board;
import chessPackage.board.BoardUtilities;
import chessPackage.board.Moves;
import chessPackage.board.Moves.AttackMove;
import chessPackage.board.Moves.MajorMove;
import chessPackage.board.Tile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tonip
 */
public class Knight extends Piece{
    
    
    private final static int[] POSSIBLE_MOVE_COORDINATES = {-17, -15, -10, -6, 6, 10, 15, 17};
    
   public Knight(final Alliance pieceAlliance, final int piecePosition){
        super(pieceAlliance, piecePosition); 
        
    }
    
    /**
     *
     * @param board
     * @return
     */
    
    
    @Override
    public List<Moves> calculateAllowedMoves(final Board board) {
 
        final List<Moves> legalMoves = new ArrayList<>();
        
        for(final int currentPossibleMove : POSSIBLE_MOVE_COORDINATES){
            
            final int possibleDestinationCoordinate = this.piecePosition + currentPossibleMove;
            
            if(BoardUtilities.isValidTileCoordinate(possibleDestinationCoordinate)){    
                if(isFirstColumnExclusion(this.piecePosition, currentPossibleMove) ||
                        isSecondColumnExclusion(this.piecePosition, currentPossibleMove) ||
                        isSeventhColumnExclusion(this.piecePosition, currentPossibleMove) ||
                        isEighthColumnExclusion(this.piecePosition, currentPossibleMove)) {
                    
                    continue;
                }  
                final Tile possibleDestinationTile = board.getTile(possibleDestinationCoordinate);
                if(possibleDestinationTile.isTileOccupied()){
                    legalMoves.add(new MajorMove(board, this, possibleDestinationCoordinate));
                } else{
                    final Piece pieceAtDestination = possibleDestinationTile.getPiece();
                    final Alliance pieceAlliance = pieceAtDestination.getPieceAlliance();
                    if(this.pieceAlliance != pieceAlliance){
                        legalMoves.add(new AttackMove(board, this, possibleDestinationCoordinate, pieceAtDestination));
                    }
                } 
            }
        }
        return legalMoves;
    }
    
     private static boolean isFirstColumnExclusion(final int currentPosition, final int possiblePosition){
            return BoardUtilities.FIRST_COLUMN[currentPosition] && (possiblePosition == -17 || possiblePosition == -10 ||
                    possiblePosition == 6 || possiblePosition == 15);
        }
     
     private static boolean isSecondColumnExclusion(final int currentPosition, final int possiblePosition) {
         return BoardUtilities.SECOND_COLUMN[currentPosition] && (possiblePosition == -10 || possiblePosition == 6);
     }
     
     private static boolean isSeventhColumnExclusion(final int currentPosition, final int possiblePosition) {
         return BoardUtilities.SEVENTH_COLUMN[currentPosition] && (possiblePosition == -6 || possiblePosition == 10);
     }
     
     private static boolean isEighthColumnExclusion(final int currentPosition, final int possiblePosition){
         return BoardUtilities.EIGHTH_COLUMN[currentPosition] && (possiblePosition == -15 || possiblePosition == -6 ||
                 possiblePosition == 10 || possiblePosition == 17);
     }
}
