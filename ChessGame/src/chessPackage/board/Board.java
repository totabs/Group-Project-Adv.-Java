/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessPackage.board;

import chessPackage.Alliance;
import chessPackage.pieces.Bishop;
import chessPackage.pieces.King;
import chessPackage.pieces.Knight;
import chessPackage.pieces.Pawn;
import chessPackage.pieces.Piece;
import chessPackage.pieces.Queen;
import chessPackage.pieces.Rook;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tonip
 */
public class Board {
    
    private final List<Tile> chessBoard;
    private final Collection<Piece> whitePieces;
    private final Collection<Piece> blackPieces;
    
    private Board(Builder builder){
        this.chessBoard = createChessBoard(builder);
        this.whitePieces = calculateActivePieces(this.chessBoard, Alliance.WHITE);
        this.blackPieces = calculateActivePieces(this.chessBoard, Alliance.BLACK);
        
        final Collection<Moves> whiteLegalMoves = calculateLegalMoves(this.whitePieces);
        final Collection<Moves> blackLegalMoves = calculateLegalMoves(this.blackPieces);
    }
    
    @Override
    public String toString(){
        final StringBuilder builder = new StringBuilder();
        for(int i=0; i < BoardUtils.NUM_TILES; i++){
            final String tileText = prettyPrint(this.chessBoard.get(i));
            builder.append
        }
    }
    
    
    private Collection<Moves> calculateLegalMoves(final Collection<Piece> pieces){
       
       final List<Moves> legalMoves = new ArrayList<>();
       
       for(final Piece piece : pieces) {
           
           legalMoves.addAll(piece.calculateLegalMoves(this));
       }
        
        return Collections.unmodifiableList(legalMoves);
    }
    
    
    private static Collection<Piece> calculateActivePieces(List<Tile> chessBoard, final Alliance alliance) {
        
        final List<Piece> activePieces = new ArrayList<>();
        for(final Tile tile : chessBoard){
            if(tile.isTileOccupied()){
                final Piece piece = tile.getPiece();
                if(piece.getPieceAlliance() == alliance){
                    activePieces.add(piece);
                }
            }
        }
        return Collections.unmodifiableList(activePieces);
    }
    
    
    public Tile getTile(final int tileCoordinate){
        return chessBoard.get(tileCoordinate);
    }
    
    private List<Tile> createChessBoard(Builder builder){
        Tile[] tiles = new Tile[BoardUtilities.NUM_TILES];
        for(int i = 0; i < BoardUtilities.NUM_TILES; i++){
            tiles[i] = Tile.createTile(i, builder.boardSetup.get(i));
        }
        List<Tile>tilesList = Arrays.asList(tiles);
        
        return tilesList;
    }
    
    // Create Standard Board
     private Board createBoard() {
        final Builder builder = new Builder();
        // Black Layout
        builder.setPiece(new Rook(Alliance.BLACK, 0));
        builder.setPiece(new Knight(Alliance.BLACK, 1));
        builder.setPiece(new Bishop(Alliance.BLACK, 2));
        builder.setPiece(new Queen(Alliance.BLACK, 3));
        builder.setPiece(new King(Alliance.BLACK, 4));
        builder.setPiece(new Bishop(Alliance.BLACK, 5));
        builder.setPiece(new Knight(Alliance.BLACK, 6));
        builder.setPiece(new Rook(Alliance.BLACK, 7));
        builder.setPiece(new Pawn(Alliance.BLACK, 8));
        builder.setPiece(new Pawn(Alliance.BLACK, 9));
        builder.setPiece(new Pawn(Alliance.BLACK, 10));
        builder.setPiece(new Pawn(Alliance.BLACK, 11));
        builder.setPiece(new Pawn(Alliance.BLACK, 12));
        builder.setPiece(new Pawn(Alliance.BLACK, 13));
        builder.setPiece(new Pawn(Alliance.BLACK, 14));
        builder.setPiece(new Pawn(Alliance.BLACK, 15));
        // White Layout
        builder.setPiece(new Pawn(Alliance.WHITE, 48));
        builder.setPiece(new Pawn(Alliance.WHITE, 49));
        builder.setPiece(new Pawn(Alliance.WHITE, 50));
        builder.setPiece(new Pawn(Alliance.WHITE, 51));
        builder.setPiece(new Pawn(Alliance.WHITE, 52));
        builder.setPiece(new Pawn(Alliance.WHITE, 53));
        builder.setPiece(new Pawn(Alliance.WHITE, 54));
        builder.setPiece(new Pawn(Alliance.WHITE, 55));
        builder.setPiece(new Rook(Alliance.WHITE, 56));
        builder.setPiece(new Knight(Alliance.WHITE, 57));
        builder.setPiece(new Bishop(Alliance.WHITE, 58));
        builder.setPiece(new Queen(Alliance.WHITE, 59));
        builder.setPiece(new King(Alliance.WHITE, 60));
        builder.setPiece(new Bishop(Alliance.WHITE, 61));
        builder.setPiece(new Knight(Alliance.WHITE, 62));
        builder.setPiece(new Rook(Alliance.WHITE, 63));
        //white to move
        builder.setMoveMaker(Alliance.WHITE);
        //build the board
        return builder.build();
    }
    
   
    public static Board createStdBoard(){
        return null;
    }

    
    
    public static class Builder{
        
        Map<Integer, Piece> boardSetup;
        Alliance nextMove;
        
        public Builder(){
            
        }
        
        public Builder setPiece(final Piece piece){
            this.boardSetup.put(piece.getPiecePosition(), piece);
            return this;
        }
        
        public Builder setMoveMaker(final Alliance nextMove) {
            this.nextMove = nextMove;
            return this;
        }
        
        public Board build(){
            return new Board(this);
        }
    }
    
}
