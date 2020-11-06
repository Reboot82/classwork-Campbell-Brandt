package com.talentpath.tictactoe.daos;

import com.talentpath.tictactoe.dao.PostgresTicTacToeDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("daotesting")
public class PostgresTicTacToeDaoTest {

    @Autowired
    PostgresTicTacToeDao daoToTest;

    @Autowired
    JdbcTemplate template;

    @BeforeEach
    void setUp() {
        daoToTest.reset();
    }

    @Test
    void getAllGames() {

    }

}
