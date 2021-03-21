package com.game.chess;

import com.game.chess.game.Game;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChessApplication {
    public static void main(String[] args) {
        Game game = new Game();
        game.printCurrentPositions();
        //SpringApplication.run(ChessApplication.class, args);
    }
}