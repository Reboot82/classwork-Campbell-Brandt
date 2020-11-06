package com.talentpath.tictactoe.dao;

import com.talentpath.tictactoe.exceptions.InvalidIdException;
import com.talentpath.tictactoe.exceptions.NullArgumentException;
import com.talentpath.tictactoe.models.TicTacToeBoard;
import com.talentpath.tictactoe.models.TicTacToeMove;

import java.util.List;

public interface TicTacToeDao {
    List<TicTacToeBoard> getAllGames();

    TicTacToeBoard addGame(TicTacToeBoard toAdd) throws NullArgumentException;
    TicTacToeBoard getGameById(Integer gameId) throws InvalidIdException;

    void reset();

    List<TicTacToeMove> getMovesForGame(Integer gameId);

    void addMove(TicTacToeMove move);
}
