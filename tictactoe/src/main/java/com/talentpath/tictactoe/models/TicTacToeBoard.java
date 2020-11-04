package com.talentpath.tictactoe.models;

import java.util.List;

public class TicTacToeBoard {
    Integer gameId;
    List<Integer> guessesX;
    List<Integer> guessesO;

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public List<Integer> getGuessesX() {
        return guessesX;
    }

    public void setGuessesX(List<Integer> guessesX) {
        this.guessesX = guessesX;
    }

    public List<Integer> getGuessesO() {
        return guessesO;
    }

    public void setGuessesO(List<Integer> guessesO) {
        this.guessesO = guessesO;
    }
}
