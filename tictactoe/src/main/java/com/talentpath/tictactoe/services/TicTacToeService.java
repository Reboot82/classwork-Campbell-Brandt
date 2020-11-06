package com.talentpath.tictactoe.services;

import com.talentpath.tictactoe.dao.TicTacToeDao;
import com.talentpath.tictactoe.exceptions.InvalidIdException;
import com.talentpath.tictactoe.models.TicTacToeBoard;
import com.talentpath.tictactoe.models.TicTacToeMove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicTacToeService {

    @Autowired
    TicTacToeDao dao;

    @Autowired
    public TicTacToeService( TicTacToeDao dao ) {this.dao = dao;}

    public Integer beginGame() {

        TicTacToeBoard toAdd = new TicTacToeBoard();
        toAdd.setMoves(new ArrayList<>());
        toAdd.setGameOver(false);

        toAdd = dao.addGame(toAdd);

        return toAdd.getGameId();
    }

    public List<TicTacToeBoard> getGames(){
        List<TicTacToeBoard> allGames = dao.getAllGames();

        return allGames;
    }

    public TicTacToeBoard getGameById(Integer gameId) throws InvalidIdException {

        TicTacToeBoard toReturn = dao.getGameById(gameId);
        dao.
    }


}
