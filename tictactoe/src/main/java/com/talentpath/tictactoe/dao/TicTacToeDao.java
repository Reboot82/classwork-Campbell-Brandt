package com.talentpath.tictactoe.dao;

import com.talentpath.tictactoe.models.TicTacToeBoard;
import com.talentpath.tictactoe.models.TicTacToeGuess;

import java.util.List;

public interface TicTacToeDao {
    List<TicTacToeBoard> getAllGames();

    List<Integer> getAllPossibleMoves();

    TicTacToeBoard addGame(TicTacToeBoard toAdd);
    TicTacToeBoard getGameById(Integer gameId);

    void reset();

    List<Integer> getXMovesForGame(Integer gameId);
    List<Integer> getOMovesForGame(Integer gameId);

    void addXGuess(TicTacToeGuess xGuess);
    void addOGuess(TicTacToeGuess oGuess);
}
