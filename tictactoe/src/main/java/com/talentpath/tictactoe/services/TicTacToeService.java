package com.talentpath.tictactoe.services;

import com.talentpath.tictactoe.dao.TicTacToeDao;
import com.talentpath.tictactoe.models.TicTacToeBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicTacToeService {

    @Autowired
    TicTacToeDao dao;

    public TicTacToeService( TicTacToeDao dao ) {this.dao = dao;}

    public Integer beginGame() {

        List<Integer> x = new ArrayList<Integer>();
        x.add(1);
        x.add(2);
        x.add(3);

        List<Integer> o = new ArrayList<Integer>();
        o.add(4);
        o.add(5);
        o.add(7);

        List<Integer> possibleMoves = dao.getAllPossibleMoves();
        TicTacToeBoard toAdd = new TicTacToeBoard();
        toAdd.setGuessesX(x);
        toAdd.setGuessesO(o);

        toAdd = dao.addGame(toAdd);

        return toAdd.getGameId();
    }

    private String getWinner(TicTacToeBoard gameId){
        List<Integer> x = gameId.getGuessesX();
        List<Integer> o = gameId.getGuessesO();

        if(x.toString().equals("123")){
            return "Player One wins!";
        } else if(o.toString().equals("123")){
            return "Player Two wins!";
        } else {
            return null;
        }
    }

}
