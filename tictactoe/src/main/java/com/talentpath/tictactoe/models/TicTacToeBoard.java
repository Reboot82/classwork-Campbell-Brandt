package com.talentpath.tictactoe.models;

import java.util.List;

public class TicTacToeBoard {
    Integer gameId;
    List<TicTacToeMove> moves;
    Boolean isGameOver;
    String winner;

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public Boolean getGameOver() {
        return isGameOver;
    }

    public void setGameOver(Boolean gameOver) {
        isGameOver = gameOver;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public List<TicTacToeMove> getMoves() {
        return moves;
    }

    public void setMoves(List<TicTacToeMove> moves) {
        this.moves = moves;
    }

}
