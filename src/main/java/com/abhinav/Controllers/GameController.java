package com.abhinav.Controllers;

import com.abhinav.Exceptions.InvalidMoveException;
import com.abhinav.models.Game;
import com.abhinav.models.GameState;
import com.abhinav.models.Player;

import java.util.List;

public class GameController {
    public Game startGame(int dimensions, List<Player> players) {
        return new Game(dimensions, players);
    }
    public void makeMove(Game game) throws InvalidMoveException{
        game.makeMove();
    }
    public GameState checkState(Game game) {
        return game.getGameState();
    }
    public Player getWinner(Game game) {
        return game.getWinner();
    }
    public void printBoard(Game game) {
        game.printBoard();
    }
}
