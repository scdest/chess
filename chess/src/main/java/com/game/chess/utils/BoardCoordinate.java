package com.game.chess.utils;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class BoardCoordinate {
    private final int numberPosition;
    private final char charPosition;
}
