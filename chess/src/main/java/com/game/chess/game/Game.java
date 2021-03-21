package com.game.chess.game;

import com.game.chess.figures.Chess;
import com.game.chess.figures.ChessType;
import com.game.chess.utils.BoardCoordinate;
import com.game.chess.utils.Constants;
import com.game.chess.utils.IndexToBoardCoordinateMapper;
import com.game.chess.utils.Party;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Game {
    private final ChessField[][] board = new ChessField[Constants.BOARD_LENGHT][Constants.BOARD_LENGHT];
    private Party partyMove = Party.WHITE;
    private static final Map<BoardCoordinate, Chess> initialBoardCoordinatesToChessMap = new HashMap<>();

    public ChessField[][] getBoard() {
        return board;
    }

    public Party getPartyMove() {
        return partyMove;
    }

    public void switchMove() {
        if(partyMove == Party.WHITE) {
            partyMove = Party.BLACK;
        } else {
            partyMove = Party.WHITE;
        }
    }

    static {
        initPawns();
        initRooks();
        initHorses();
        initKnights();
        initKings();
        initQueens();
    }

    public Game() {
        initializeChessOnTheBoard();
    }

    private void initializeChessOnTheBoard() {
        for(int i = 0;i < Constants.BOARD_LENGHT; i++) {
            for(int j = 0;j < Constants.BOARD_LENGHT; j++) {
                BoardCoordinate boardCoordinate = IndexToBoardCoordinateMapper.getBoardCoordinateByIndex(j, i);
                Chess chess = initialBoardCoordinatesToChessMap.get(boardCoordinate);
                chess.setCurrentCoordinate(boardCoordinate);
                board[i][j] = new ChessField(chess, boardCoordinate);
            }
        }
    }

    private static void initPawns() {
        int pawnsWhiteInitPositionY = 2;
        int pawnsBlackInitPositionY = 7;
        for(int i = 0; i < Constants.BOARD_LENGHT; i++) {
            initialBoardCoordinatesToChessMap.put(new BoardCoordinate(pawnsWhiteInitPositionY, IndexToBoardCoordinateMapper.getCharByIndex(i)), new Chess(Party.WHITE, ChessType.PAWN));
            initialBoardCoordinatesToChessMap.put(new BoardCoordinate(pawnsBlackInitPositionY, IndexToBoardCoordinateMapper.getCharByIndex(i)), new Chess(Party.BLACK, ChessType.PAWN));
        }
    }

    private static void initRooks() {
        initialBoardCoordinatesToChessMap.put(new BoardCoordinate(1, 'a'), new Chess(Party.WHITE, ChessType.ROOK));
        initialBoardCoordinatesToChessMap.put(new BoardCoordinate(1, 'h'), new Chess(Party.WHITE, ChessType.ROOK));
        initialBoardCoordinatesToChessMap.put(new BoardCoordinate(8, 'a'), new Chess(Party.BLACK, ChessType.ROOK));
        initialBoardCoordinatesToChessMap.put(new BoardCoordinate(8, 'h'), new Chess(Party.BLACK, ChessType.ROOK));
    }

    private static void initHorses() {
        initialBoardCoordinatesToChessMap.put(new BoardCoordinate(1, 'b'), new Chess(Party.WHITE, ChessType.HORSE));
        initialBoardCoordinatesToChessMap.put(new BoardCoordinate(1, 'g'), new Chess(Party.WHITE, ChessType.HORSE));
        initialBoardCoordinatesToChessMap.put(new BoardCoordinate(8, 'b'), new Chess(Party.BLACK, ChessType.HORSE));
        initialBoardCoordinatesToChessMap.put(new BoardCoordinate(8, 'g'), new Chess(Party.BLACK, ChessType.HORSE));
    }

    private static void initKnights() {
        initialBoardCoordinatesToChessMap.put(new BoardCoordinate(1, 'c'), new Chess(Party.WHITE, ChessType.KNIGHT));
        initialBoardCoordinatesToChessMap.put(new BoardCoordinate(1, 'f'), new Chess(Party.WHITE, ChessType.KNIGHT));
        initialBoardCoordinatesToChessMap.put(new BoardCoordinate(8, 'c'), new Chess(Party.BLACK, ChessType.KNIGHT));
        initialBoardCoordinatesToChessMap.put(new BoardCoordinate(8, 'f'), new Chess(Party.BLACK, ChessType.KNIGHT));
    }

    private static void initKings() {
        initialBoardCoordinatesToChessMap.put(new BoardCoordinate(1, 'c'), new Chess(Party.WHITE, ChessType.KING));
        initialBoardCoordinatesToChessMap.put(new BoardCoordinate(8, 'c'), new Chess(Party.BLACK, ChessType.KING));
    }

    private static void initQueens() {
        initialBoardCoordinatesToChessMap.put(new BoardCoordinate(1, 'd'), new Chess(Party.WHITE, ChessType.QUEEN));
        initialBoardCoordinatesToChessMap.put(new BoardCoordinate(8, 'd'), new Chess(Party.BLACK, ChessType.QUEEN));
    }

    public void printCurrentPositions() {
        for(int i = 0;i < Constants.BOARD_LENGHT; i++) {
            for(int j = 0;j < Constants.BOARD_LENGHT; j++) {
                String toPrint = Optional.ofNullable(board[j][i].getPresentChess()).map(f -> f.getChessType().getLabel()).orElse("X");
                System.out.print(toPrint);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
