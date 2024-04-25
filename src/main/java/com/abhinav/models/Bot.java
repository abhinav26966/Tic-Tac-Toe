package com.abhinav.models;

import java.util.List;

public class Bot extends Player{
    private BotDifficulty botDifficultyLevel;

    public Bot(String name, Symbol symbol, PlayerType playerType, BotDifficulty botDifficultyLevel) {
        super(name, symbol, playerType);
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Move makeMove(Board board) {
        //Find the first empty cell and make the move there.
        for (List<Cell> row : board.getBoard()) {
            for (Cell cell : row) {
                if (cell.getCellState().equals(CellState.EMPTY)) {
                    return new Move(cell, this);
                }
            }
        }
        return null;
    }
}
