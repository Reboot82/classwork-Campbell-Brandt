package com.talentpath.tictactoe.dao;

import com.talentpath.tictactoe.exceptions.InvalidIdException;
import com.talentpath.tictactoe.models.TicTacToeBoard;
import com.talentpath.tictactoe.models.TicTacToeMove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
@Profile({"production", "daotesting"})
public class PostgresTicTacToeDao implements TicTacToeDao{

    @Autowired
    private JdbcTemplate template;

    @Override
    public List<TicTacToeBoard> getAllGames() {
        return template.query( "SELECT * FROM \"Games\"", new GameMapper() );
    }

    @Override
    public List<Integer> getAllPossibleMoves() {
        List<Integer> allMoves = template.query( "SELECT * FROM \"Moves\"",
        new MoveMapper());

        return allMoves;
    }

    @Override
    public TicTacToeBoard addGame(TicTacToeBoard toAdd) {
        Integer insertedId = template.queryForObject(
                "INSERT INTO \"Games\" (\"isGameOver\") " +
                        "VALUES ('false') RETURNING \"gameId\"", new IdMapper() );


        toAdd.setGameId( insertedId );

        return toAdd;
    }

    @Override
    public TicTacToeBoard getGameById(Integer gameId) throws InvalidIdException {

        try {
            TicTacToeBoard retrievedGame = template.queryForObject("SELECT * FROM \"Games\" WHERE \"gameId\" = '" + gameId + "'",
                    new GameMapper());
            return retrievedGame;
        } catch (DataAccessException ex){
            throw new InvalidIdException("Error retrieving game id: " + gameId, ex);
        }
    }

    @Override
    public void reset() {

        template.update("TRUNCATE \"Moves\" RESTART IDENTITY");
        template.update("DELETE FROM \"Moves\"");
        template.update( "INSERT INTO \"Moves\" (\"gameId\", \"player\", \"location\") VALUES ('1', '1', '1'),('1', '1', '2')('1', '1', '3')");

    }

    @Override
    public List<TicTacToeMove> getMovesForGame(Integer gameId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addMove(TicTacToeMove move) {
        throw new UnsupportedOperationException();
    }

    class GameMapper implements RowMapper<TicTacToeBoard> {

        @Override
        public TicTacToeBoard mapRow(ResultSet resultSet, int i) throws SQLException {
            throw new UnsupportedOperationException();
        }
    }

    class MoveMapper implements RowMapper<Integer> {

        @Override
        public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
            return resultSet.getInt("move");
        }
    }

    class IdMapper implements RowMapper<Integer> {

        @Override
        public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
            return resultSet.getInt("gameId");
        }
    }

}
