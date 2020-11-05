package com.talentpath.tictactoe.dao;

import com.talentpath.tictactoe.exceptions.InvalidIdException;
import com.talentpath.tictactoe.models.TicTacToeBoard;
import com.talentpath.tictactoe.models.TicTacToeGuess;

import java.util.List;

public interface TicTacToeDao {
    List<TicTacToeBoard> getAllGames();

    List<Integer> getAllPossibleMoves();

    TicTacToeBoard addGame(TicTacToeBoard toAdd);
    TicTacToeBoard getGameById(Integer gameId) throws InvalidIdException;

    void reset();

    List<Integer> getMovesForGame(Integer gameId);

    void addMove(TicTacToeGuess move);
}
