package com.talentpath.tictactoe.dao;

import com.talentpath.tictactoe.exceptions.InvalidIdException;
import com.talentpath.tictactoe.models.TicTacToeBoard;
import com.talentpath.tictactoe.models.TicTacToeGuess;
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
        List<Integer> insertedIds = template.query(
                "INSERT INTO \"Games\" (\"possibleMoves\") " +
                        "VALUES ('"+toAdd.getMoves()+"') returning \"gameId\";", new IdMapper() );




        toAdd.setGameId( insertedIds.get(0));

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
    public List<Integer> getMovesForGame(Integer gameId) {
        return template.query(
                "SELECT \"move\" FROM \"Moves\" WHERE \"gameId\" = '"+gameId+"' ",
                new MoveMapper());
    }

    @Override
    public void addMove(TicTacToeGuess move) {

    }

    class GameMapper implements RowMapper<TicTacToeBoard> {

        @Override
        public TicTacToeBoard mapRow(ResultSet resultSet, int i) throws SQLException {
            TicTacToeBoard toReturn = new TicTacToeBoard();
            toReturn.setGameId(resultSet.getInt("gameId"));
            toReturn.setMoves(resultSet.getInt("moves"));
            toReturn.setGuessesO((List<Integer>) resultSet.getArray("guessesO"));
            toReturn.setGuessesX((List<Integer>) resultSet.getArray("guessesX"));

            return toReturn;
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
