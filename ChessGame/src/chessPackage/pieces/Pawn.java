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
import chessPackage.board.Moves.MajorMove;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tonip
 */
public class Pawn extends Piece{

    
    private final static int[] POSSIBLE_MOVE_COORDINATE = {8, 16, 7, 9};
    
    public Pawn(final Alliance pieceAlliance, final int piecePosition) {
        super(pieceAlliance, piecePosition);
    }

    @Override
    public List<Moves> calculateAllowedMoves(final Board board) {

        final List<Moves> legalMoves = new ArrayList<>();

        for (final int currentPossibleMove : POSSIBLE_MOVE_COORDINATE) {

            final int possibleDestinationCoordinate = this.piecePosition + (this.getPieceAlliance().getDirection()) * currentPossibleMove;

            if (!BoardUtilities.isValidTileCoordinate(possibleDestinationCoordinate)) {
                continue;
            }

            if (currentPossibleMove == 8 && !board.getTile(possibleDestinationCoordinate).isTileOccupied()) {
                //.........
                legalMoves.add(new MajorMove(board, this, possibleDestinationCoordinate));
            } else if (currentPossibleMove == 16 && this.isFirstMove()
                    && ((BoardUtilities.SECOND_ROW[this.piecePosition] && this.getPieceAlliance().isBlack())
                    || (BoardUtilities.SEVENTH_ROW[this.piecePosition] && this.getPieceAlliance().isWhite()))) {
                final int behindPossibleDestinationCoordinate = this.piecePosition + (this.pieceAlliance.getDirection() * 8);
                if (!board.getTile(behindPossibleDestinationCoordinate).isTileOccupied()
                        && !board.getTile(possibleDestinationCoordinate).isTileOccupied()) {
                    legalMoves.add(new MajorMove(board, this, possibleDestinationCoordinate));
                }
            } else if (currentPossibleMove == 7
                    && !((BoardUtilities.EIGHTH_COLUMN[this.piecePosition] && this.pieceAlliance.isWhite()
                    || (BoardUtilities.FIRST_COLUMN[this.piecePosition] && this.pieceAlliance.isBlack())))) {
                if (board.getTile(possibleDestinationCoordinate).isTileOccupied()) {
                    final Piece pieceOnPossible = board.getTile(possibleDestinationCoordinate).getPiece();
                    if (this.pieceAlliance != pieceOnPossible.getPieceAlliance()) {
                        //........
                        legalMoves.add(new MajorMove(board, this, possibleDestinationCoordinate));
                    }
                } else if (currentPossibleMove == 9
                        && !((BoardUtilities.EIGHTH_COLUMN[this.piecePosition] && this.pieceAlliance.isWhite()
                        || (BoardUtilities.FIRST_COLUMN[this.piecePosition] && this.pieceAlliance.isBlack())))) {
                    if (board.getTile(possibleDestinationCoordinate).isTileOccupied()) {
                        final Piece pieceOnPossible = board.getTile(possibleDestinationCoordinate).getPiece();
                        if (this.pieceAlliance != pieceOnPossible.getPieceAlliance()) {
                            //........
                            legalMoves.add(new MajorMove(board, this, possibleDestinationCoordinate));
                        }
                    }
                }
                }
            }
            return legalMoves;
        }
}
