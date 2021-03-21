package com.game.chess.utils;

import java.util.HashMap;
import java.util.Map;

public class IndexToBoardCoordinateMapper {
    private static final Map<Integer, Character> charsByIndex = new HashMap<>();

    static {
        charsByIndex.put(0, 'a');
        charsByIndex.put(1, 'b');
        charsByIndex.put(2, 'c');
        charsByIndex.put(3, 'd');
        charsByIndex.put(4, 'e');
        charsByIndex.put(5, 'f');
        charsByIndex.put(6, 'g');
        charsByIndex.put(7, 'h');
    }

    public static BoardCoordinate getBoardCoordinateByIndex(int x, int y) {
        return new BoardCoordinate(x + 1, charsByIndex.get(y));
    }

    public static Character getCharByIndex(int index) {
        return charsByIndex.get(index);
    }
}
