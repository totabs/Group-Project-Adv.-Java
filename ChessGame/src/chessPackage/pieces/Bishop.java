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
public class Bishop extends Piece{

     private final static int[] POSSIBLE_MOVE_VECTOR_COORDINATES = {-9, -7, 7, 9};
    
    public Bishop(Alliance pieceAlliance, final int piecePosition) {
        super(pieceAlliance, piecePosition);
    }

    @Override
    public List<Moves> calculateAllowedMoves(final Board board) {
 
        final List<Moves> legalMoves = new ArrayList<>();
        
        for(final int possibleCoordinateOffset : POSSIBLE_MOVE_VECTOR_COORDINATES){
            int possibleDestinationCoordinate = this.piecePosition;
            while(BoardUtilities.isValidTileCoordinate(possibleDestinationCoordinate)){ 
                if(isFirstColumnExclusion(possibleDestinationCoordinate, possibleCoordinateOffset) ||
                        isEighthColumnExclusion(possibleDestinationCoordinate, possibleCoordinateOffset)) {
                    break;
                }  
                 possibleDestinationCoordinate += possibleCoordinateOffset;
                if(BoardUtilities.isValidTileCoordinate(possibleDestinationCoordinate)){ 
                
                final Tile possibleDestinationTile = board.getTile(possibleDestinationCoordinate);
                if(possibleDestinationTile.isTileOccupied()){
                    legalMoves.add(new MajorMove(board, this, possibleDestinationCoordinate));
                } else{
                    final Piece pieceAtDestination = possibleDestinationTile.getPiece();
                    final Alliance pieceAlliance = pieceAtDestination.getPieceAlliance();
                    if(this.pieceAlliance != pieceAlliance){
                        legalMoves.add(new AttackMove(board, this, possibleDestinationCoordinate, pieceAtDestination));
                    }
                    break;
                } 
            }
         }
      }
        return legalMoves;
    }
     private static boolean isFirstColumnExclusion(final int currentPosition, final int possiblePosition){
            return BoardUtilities.FIRST_COLUMN[currentPosition] && (possiblePosition == -9 || possiblePosition == 7);
        }
     
     private static boolean isEighthColumnExclusion(final int currentPosition, final int possiblePosition){
         return BoardUtilities.EIGHTH_COLUMN[currentPosition] && (possiblePosition == -7 || possiblePosition == 9);
     }
    
}
