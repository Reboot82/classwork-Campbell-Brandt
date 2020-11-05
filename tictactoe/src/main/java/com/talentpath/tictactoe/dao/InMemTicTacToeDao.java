package com.talentpath.tictactoe.dao;


import com.talentpath.tictactoe.models.TicTacToeBoard;
import com.talentpath.tictactoe.models.TicTacToeGuess;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Profile({"servicetesting", "inmemtesting"})
public class InMemTicTacToeDao implements TicTacToeDao {

    List<TicTacToeBoard> allGames = new ArrayList<>();
    List<Integer> possibleMoves = new ArrayList<>();

    public InMemTicTacToeDao() { reset(); }

    @Override
    public void reset() {
        possibleMoves.clear();
        allGames.clear();

        possibleMoves.add(1);
        possibleMoves.add(2);
        possibleMoves.add(3);
        possibleMoves.add(4);
        possibleMoves.add(5);
        possibleMoves.add(6);
        possibleMoves.add(7);
        possibleMoves.add(8);
        possibleMoves.add(9);

        TicTacToeBoard easy = new TicTacToeBoard();
        easy.setGameId(1);
        easy.setGuessesO(Arrays.asList(1,2,3));
        easy.setGuessesX(new ArrayList<>());

        allGames.add(easy);

        TicTacToeBoard medium = new TicTacToeBoard();
        easy.setGameId(2);
        easy.setGuessesO(Arrays.asList(1,3,5,9));
        easy.setGuessesX(Arrays.asList(2,4,6,7));

        allGames.add(medium);

        TicTacToeBoard hard = new TicTacToeBoard();
        easy.setGameId(3);
        easy.setGuessesO(Arrays.asList(1,2,3,9));
        easy.setGuessesX(Arrays.asList(5,6,7,8));

        allGames.add(hard);
    }

    @Override
    public List<TicTacToeBoard> getAllGames() {
        return null;
    }

    @Override
    public List<Integer> getAllPossibleMoves() {
        return null;
    }

    @Override
    public TicTacToeBoard addGame(TicTacToeBoard toAdd) {
        return null;
    }

    @Override
    public TicTacToeBoard getGameById(Integer gameId) {
        return null;
    }

    @Override
    public List<Integer> getMovesForGame(Integer gameId){
        return allGames.get(gameId).getGuessesX();
    }

    @Override
    public void addMove(TicTacToeGuess move) {

    }

}
