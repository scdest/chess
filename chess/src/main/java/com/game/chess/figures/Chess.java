package com.game.chess.figures;

import com.game.chess.utils.BoardCoordinate;
import com.game.chess.utils.Party;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Chess {
    private Party party;
    private ChessType chessType;
    private BoardCoordinate currentCoordinate;

    public Chess(Party party, ChessType chessType) {
        this.party = party;
        this.chessType = chessType;
    }
}
