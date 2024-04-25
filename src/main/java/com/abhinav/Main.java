package com.abhinav;

import com.abhinav.Controllers.GameController;
import com.abhinav.Exceptions.InvalidMoveException;
import com.abhinav.models.*;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InvalidMoveException {//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = scanner.nextLine();
        GameController gameController = new GameController();

        int dimension = 3;
        List<Player> players = List.of(
                new Player(name, new Symbol('X'), PlayerType.HUMAN),
                new Bot("BOT", new Symbol('O'), PlayerType.BOT, BotDifficulty.EASY)
        );

        Game game = gameController.startGame(dimension, players);
        while (game.getGameState().equals(GameState.IN_PROGRESS)) {
            gameController.printBoard(game);

            gameController.makeMove(game);
        }

        if (!gameController.checkState(game).equals(GameState.ENDED)) {
            game.setGameState(GameState.DRAW);
            System.out.println("Game DRAW");
        } else {
            gameController.printBoard(game);
            System.out.println("Player " + gameController.getWinner(game).getName() + " is the winner");
        }

    }
}