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
public class King extends Piece{

    private final static int[] POSSIBLE_MOVE_COORDINATE = {-9, -8, -7, -1, 1, 7, 8, 9};

    public King(Alliance pieceAlliance, int piecePosition) {
        super(pieceAlliance, piecePosition);
    }
    
    

    @Override
    public List<Moves> calculateAllowedMoves(Board board) {
       
        final List<Moves> legalMoves = new ArrayList<>();
        
        for(final int currentPossibleMove : POSSIBLE_MOVE_COORDINATE){
            final int possibleDestinationCoordinate = this.piecePosition + currentPossibleMove;
            if(isFirstColumnExclusion(this.piecePosition, currentPossibleMove) || 
                 isEighthColumnExclusion(this.piecePosition, currentPossibleMove)) {
                continue;
            }   
            if(BoardUtilities.isValidTileCoordinate(possibleDestinationCoordinate)){
                final Tile possibleDestinationTile = board.getTile(possibleDestinationCoordinate);
            } else{
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
            return BoardUtilities.FIRST_COLUMN[currentPosition] && (possiblePosition == -9 || possiblePosition == -1 ||
                    possiblePosition == 7);
        }
     
     private static boolean isEighthColumnExclusion(final int currentPosition, final int possiblePosition) {
         return BoardUtilities.EIGHTH_COLUMN[currentPosition] && (possiblePosition == -7 || possiblePosition == 1 || possiblePosition == 9);
     }
}
