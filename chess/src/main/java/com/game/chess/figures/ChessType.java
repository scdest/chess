package com.game.chess.figures;

public enum ChessType {
    KING("K"),
    QUEEN("Q"),
    KNIGHT("K"),
    HORSE("H"),
    ROOK("R"),
    PAWN("P");

    private String label;

    ChessType(String label) {
        this.label = label;
    }

    public String getLabel(){
        return label;
    }
}
