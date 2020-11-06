package com.talentpath.tictactoe.dao;


import com.talentpath.tictactoe.models.TicTacToeBoard;
import com.talentpath.tictactoe.models.TicTacToeMove;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Profile({"servicetesting", "inmemtesting"})
public class InMemTicTacToeDao implements TicTacToeDao {

    List<TicTacToeBoard> allGames = new ArrayList<>();

    public InMemTicTacToeDao() {

    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<TicTacToeBoard> getAllGames() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Integer> getAllPossibleMoves() {
        throw new UnsupportedOperationException();
    }

    @Override
    public TicTacToeBoard addGame(TicTacToeBoard toAdd) {
        throw new UnsupportedOperationException();
    }

    @Override
    public TicTacToeBoard getGameById(Integer gameId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<TicTacToeMove> getMovesForGame(Integer gameId){
        throw new UnsupportedOperationException();
    }

    @Override
    public void addMove(TicTacToeMove move) {
        throw new UnsupportedOperationException();

    }

}
