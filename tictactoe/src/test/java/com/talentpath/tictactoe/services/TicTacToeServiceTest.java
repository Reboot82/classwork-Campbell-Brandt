package com.talentpath.tictactoe.services;

import com.talentpath.tictactoe.dao.TicTacToeDao;
import com.talentpath.tictactoe.models.TicTacToeBoard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("servicetesting")
public class TicTacToeServiceTest {

    @Autowired
    TicTacToeService serviceToTest;

    @Autowired
    TicTacToeDao dao;

    @BeforeEach
    void setUp() {
        serviceToTest = new TicTacToeService(dao);
        dao.reset();
    }

    @Test
    void beginGame() {
//        List<TicTacToeBoard> gamesBeforeStart = serviceToTest.g();
//
//
//        //Assert
//        try {
//
//            //Act
//            Integer gameId = serviceToTest.beginGame();
//
//
//            HangmanBoard matchingGame = serviceToTest.getGameById(gameId);
//            assertEquals( gameId, matchingGame.getGameId() );
//
//            List<HangmanBoard> gamesAfterStart = serviceToTest.getGames();
//
//            assertEquals( gamesBeforeStart.size() + 1, gamesAfterStart.size() );
//
//        } catch ( InvalidIdException | NullArgumentException ex ){
//            fail( "Hit exception during golden path test: " + ex.getMessage());
//        }
    }

}
