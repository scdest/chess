package com.game.chess.game;

import com.game.chess.figures.Chess;
import com.game.chess.utils.BoardCoordinate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ChessField {
    private Chess presentChess;
    private BoardCoordinate boardCoordinate;
}
