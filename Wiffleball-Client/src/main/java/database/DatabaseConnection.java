package database;

import database.tables.*;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DatabaseConnection {
    private static final String DATABASE_DRIVER = "org.postgresql.Driver";
    private static DatabaseConnection instance = new DatabaseConnection();
    private DriverManagerDataSource dataSource;
    private Connection connection;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private DatabaseConnection() {
        try {
            List<String> dbConnectionFileLines = Files.readAllLines(Paths.get("./db_connection.pass"));

            dataSource = new DriverManagerDataSource();
            dataSource.setUrl(dbConnectionFileLines.get(0));
            dataSource.setUsername(dbConnectionFileLines.get(1));
            dataSource.setPassword(dbConnectionFileLines.get(2));
            dataSource.setDriverClassName(DATABASE_DRIVER);

            namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

            connection = dataSource.getConnection();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Only the Main class should call this for sake of speed.
     * @return The Singleton instance of the class.
     */
    public static DatabaseConnection getInstance() {
        return instance;
    }

    /**
     * Used by Main class to check when the instance is made.
     * @return True if the instance is created
     */
    public boolean operate()
    {
        return instance != null;
    }

    public void insert(Team team) {
        String queryTemplate = "INSERT INTO team"
                + "(" + Team.NAME_COLUMN_NAME + ") "
                + "VALUES(:team_name)";

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("team_name", team.getTeam_name());

        List<Map<String, Object>> keyList = new ArrayList<>();

        KeyHolder keyHolder = new GeneratedKeyHolder(keyList);

        int rowsEffected = namedParameterJdbcTemplate.update(queryTemplate, parameters, keyHolder);

        Map<String, Object> keyMap = keyHolder.getKeys();

        int id = (int) keyMap.get(Team.ID_COLUMN_NAME);

        team.setId(id);
    }

    public int insert(Season season)
    {
        String queryTemplate = "INSERT INTO Season DEFAULT VALUES";

        MapSqlParameterSource parameters = new MapSqlParameterSource();

        List<Map<String, Object>> keyList = new ArrayList<>();

        KeyHolder keyHolder = new GeneratedKeyHolder(keyList);

        int rowsEffected = namedParameterJdbcTemplate.update(queryTemplate, parameters, keyHolder);

        Map<String, Object> keyMap = keyHolder.getKeys();

        int id = (int) keyMap.get(Season.ID_COLUMN_NAME);

        season.setId(id);

        return rowsEffected;

    }

    public int insert(Game game) {
        String queryTemplate = "INSERT INTO Game"
                + "(" + Game.SEASON_ID_COLUMN_NAME + ", " + Game.DATE_OF_GAME_COLUMN_NAME + ") "
                + "VALUES(:season_id, :date_of_game)";

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("season_id", game.getSeason_id());
        parameters.addValue("date_of_game", game.getDate_of_game());

        List<Map<String, Object>> keyList = new ArrayList<>();

        KeyHolder keyHolder = new GeneratedKeyHolder(keyList);

        int rowsEffected = namedParameterJdbcTemplate.update(queryTemplate, parameters, keyHolder);

        Map<String, Object> keyMap = keyHolder.getKeys();

        int id = (int) keyMap.get(Game.ID_COLUMN_NAME);

        game.setId(id);

        return rowsEffected;
    }

    public int insert(Inning inning) {
        String queryTemplate = "INSERT INTO inning"
                + "(" + Inning.GAME_ID_COLUMN_NAME + ", " + Inning.INNING_NUMBER_COLUMN_NAME + ", " + Inning.TEAM1_ID_COLUMN_NAME + ", " + Inning.TEAM2_ID_COLUMN_NAME + ", " + Inning.TEAM1_RUNS_COLUMN_NAME + ", " + Inning.TEAM2_RUNS_COLUMN_NAME + ") "
                + "VALUES(:game_id, :inning_number, :team1_id, :team2_id, :team1_runs, :team2_runs)";

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("game_id", inning.getGame_id());
        parameters.addValue("inning_number", inning.getInning_number());
        parameters.addValue("team1_id", inning.getTeam1_id());
        parameters.addValue("team2_id", inning.getTeam2_id());
        parameters.addValue("team1_runs", inning.getTeam1_runs());
        parameters.addValue("team2_runs", inning.getTeam2_runs());

        List<Map<String, Object>> keyList = new ArrayList<>();

        KeyHolder keyHolder = new GeneratedKeyHolder(keyList);

        int rowsEffected = namedParameterJdbcTemplate.update(queryTemplate, parameters, keyHolder);

        Map<String, Object> keyMap = keyHolder.getKeys();

        int id = (int) keyMap.get(Inning.ID_COLUMN_NAME);

        inning.setId(id);

        return rowsEffected;
    }

    public int insert(Plate_Appearance plateAppearance) {
        String queryTemplate = "INSERT INTO plate_appearance"
                + "(" + Plate_Appearance.INNING_ID_COLUMN_NAME + ", " + Plate_Appearance.GAME_ID_COLUMN_NAME + ", " + Plate_Appearance.SEASON_ID_COLUMN_NAME + ", " + Plate_Appearance.PITCHER_ID_COLUMN_NAME + ", " + Plate_Appearance.BATTER_ID_COLUMN_NAME + ", " + Plate_Appearance.RESULT_ID_COLUMN_NAME + ") "
                + "VALUES(:inning_id, :game_id, :season_id, :pitcher_id, :batter_id, :result_id)";

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("inning_id", plateAppearance.getInning_id());
        parameters.addValue("game_id", plateAppearance.getGame_id());
        parameters.addValue("season_id", plateAppearance.getSeason_id());
        parameters.addValue("pitcher_id", plateAppearance.getPitcher_id());
        parameters.addValue("batter_id", plateAppearance.getBatter_id());
        parameters.addValue("result_id", plateAppearance.getResult_id());

        List<Map<String, Object>> keyList = new ArrayList<>();

        KeyHolder keyHolder = new GeneratedKeyHolder(keyList);

        int rowsEffected = namedParameterJdbcTemplate.update(queryTemplate, parameters, keyHolder);

        Map<String, Object> keyMap = keyHolder.getKeys();

        int id = (int) keyMap.get(Plate_Appearance.ID_COLUMN_NAME);

        plateAppearance.setId(id);

        return rowsEffected;
    }

    public int insert(Game_Stats game_stats) {
        String queryTemplate = "INSERT INTO game_stats"
                + "(" + Game_Stats.GAME_ID_COLUMN_NAME + ", " + Game_Stats.SEASON_ID_COLUMN_NAME + ", " + Game_Stats.TEAM_ID_COLUMN_NAME + ", " + Game_Stats.H_RUNS_COLUMN_NAME + ", " + Game_Stats.H_STRIKEOUTS_COLUMN_NAME + ", " + Game_Stats.H_FIELDOUTS_COLUMN_NAME + ", " + Game_Stats.H_WALKS_COLUMN_NAME + ", " + Game_Stats.H_SINGLES_COLUMN_NAME + ", " + Game_Stats.H_DOUBLES_COLUMN_NAME + ", " + Game_Stats.H_TRIPLES_COLUMN_NAME + ", " + Game_Stats.H_HOMERUNS_COLUMN_NAME + ", " + Game_Stats.P_RUNS_COLUMN_NAME + ", " + Game_Stats.P_STRIKEOUTS_COLUMN_NAME + ", " + Game_Stats.P_FIELDOUTS_COLUMN_NAME + ", " + Game_Stats.P_WALKS_COLUMN_NAME + ", " + Game_Stats.P_SINGLES_COLUMN_NAME + ", " + Game_Stats.P_DOUBLES_COLUMN_NAME + ", " + Game_Stats.P_TRIPLES_COLUMN_NAME + ", " + Game_Stats.P_HOMERUNS_COLUMN_NAME + ") "
                + "VALUES(:game_id, :season_id, :team_id, :h_runs, :h_strikeouts, :h_fieldouts, :h_walks, :h_singles, :h_doubles, :h_triples, :h_homeruns, :p_runs, :p_strikeouts, :p_fieldouts, :p_walks, :p_singles, :p_doubles, :p_triples, :p_homeruns)";

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("game_id", game_stats.getGame_id());
        parameters.addValue("season_id", game_stats.getSeason_id());
        parameters.addValue("team_id", game_stats.getTeam_id());
        parameters.addValue("h_runs", game_stats.getH_runs());
        parameters.addValue("h_strikeouts", game_stats.getH_strikeouts());
        parameters.addValue("h_fieldouts", game_stats.getH_fieldouts());
        parameters.addValue("h_walks", game_stats.getH_walks());
        parameters.addValue("h_singles", game_stats.getH_singles());
        parameters.addValue("h_doubles", game_stats.getH_doubles());
        parameters.addValue("h_triples", game_stats.getH_triples());
        parameters.addValue("h_homeruns", game_stats.getH_homeruns());
        parameters.addValue("p_runs", game_stats.getP_runs());
        parameters.addValue("p_strikeouts", game_stats.getP_strikeouts());
        parameters.addValue("p_fieldouts", game_stats.getP_fieldouts());
        parameters.addValue("p_walks", game_stats.getP_walks());
        parameters.addValue("p_singles", game_stats.getP_singles());
        parameters.addValue("p_doubles", game_stats.getP_doubles());
        parameters.addValue("p_triples", game_stats.getP_triples());
        parameters.addValue("p_homeruns", game_stats.getP_homeruns());

        List<Map<String, Object>> keyList = new ArrayList<>();

        KeyHolder keyHolder = new GeneratedKeyHolder(keyList);

        int rowsEffected = namedParameterJdbcTemplate.update(queryTemplate, parameters, keyHolder);

        Map<String, Object> keyMap = keyHolder.getKeys();

        int id = (int) keyMap.get(Game_Stats.ID_COLUMN_NAME);

        game_stats.setId(id);

        return rowsEffected;
    }

    public int insert(Season_Stats season_stats) {
        String queryTemplate = "INSERT INTO season_stats"
                + "(" + Season_Stats.SEASON_ID_COLUMN_NAME + ", " + Season_Stats.LAST_GAME_ID_COLUMN_NAME + ", " + Season_Stats.TEAM_ID_COLUMN_NAME + ", " + Season_Stats.WINS_COLUMN_NAME + ", " + Season_Stats.LOSSES_COLUMN_NAME + ", " + Season_Stats.TIES_COLUMN_NAME + ", " + Season_Stats.H_RUNS_COLUMN_NAME + ", " + Season_Stats.H_STRIKEOUTS_COLUMN_NAME + ", " + Season_Stats.H_FIELDOUTS_COLUMN_NAME + ", " + Season_Stats.H_WALKS_COLUMN_NAME + ", " + Season_Stats.H_SINGLES_COLUMN_NAME + ", " + Season_Stats.H_DOUBLES_COLUMN_NAME + ", " + Season_Stats.H_TRIPLES_COLUMN_NAME + ", " + Season_Stats.H_HOMERUNS_COLUMN_NAME + ", " + Season_Stats.P_RUNS_COLUMN_NAME + ", " + Season_Stats.P_STRIKEOUTS_COLUMN_NAME + ", " + Season_Stats.P_FIELDOUTS_COLUMN_NAME + ", " + Season_Stats.P_WALKS_COLUMN_NAME + ", " + Season_Stats.P_SINGLES_COLUMN_NAME + ", " + Season_Stats.P_DOUBLES_COLUMN_NAME + ", " + Season_Stats.P_TRIPLES_COLUMN_NAME + ", " + Season_Stats.P_HOMERUNS_COLUMN_NAME + ") "
                + "VALUES(:season_id, :last_game_id, :team_id, :wins, :losses, :ties, :h_runs, :h_strikeouts, :h_fieldouts, :h_walks, :h_singles, :h_doubles, :h_triples, :h_homeruns, :p_runs, :p_strikeouts, :p_fieldouts, :p_walks, :p_singles, :p_doubles, :p_triples, :p_homeruns)";

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("season_id", season_stats.getSeason_id());
        parameters.addValue("last_game_id", season_stats.getLast_game_id());
        parameters.addValue("team_id", season_stats.getTeam_id());
        parameters.addValue("wins", season_stats.getWins());
        parameters.addValue("losses", season_stats.getLosses());
        parameters.addValue("ties", season_stats.getTies());
        parameters.addValue("h_runs", season_stats.getH_runs());
        parameters.addValue("h_strikeouts", season_stats.getH_strikeouts());
        parameters.addValue("h_fieldouts", season_stats.getH_fieldouts());
        parameters.addValue("h_walks", season_stats.getH_walks());
        parameters.addValue("h_singles", season_stats.getH_singles());
        parameters.addValue("h_doubles", season_stats.getH_doubles());
        parameters.addValue("h_triples", season_stats.getH_triples());
        parameters.addValue("h_homeruns", season_stats.getH_homeruns());
        parameters.addValue("p_runs", season_stats.getP_runs());
        parameters.addValue("p_strikeouts", season_stats.getP_strikeouts());
        parameters.addValue("p_fieldouts", season_stats.getP_fieldouts());
        parameters.addValue("p_walks", season_stats.getP_walks());
        parameters.addValue("p_singles", season_stats.getP_singles());
        parameters.addValue("p_doubles", season_stats.getP_doubles());
        parameters.addValue("p_triples", season_stats.getP_triples());
        parameters.addValue("p_homeruns", season_stats.getP_homeruns());

        List<Map<String, Object>> keyList = new ArrayList<>();

        KeyHolder keyHolder = new GeneratedKeyHolder(keyList);

        int rowsEffected = namedParameterJdbcTemplate.update(queryTemplate, parameters, keyHolder);

        Map<String, Object> keyMap = keyHolder.getKeys();

        int id = (int) keyMap.get(Season_Stats.ID_COLUMN_NAME);

        season_stats.setId(id);

        return rowsEffected;
    }

    public int update(Season_Stats season_stats) {
        String queryTemplate = "UPDATE season_stats "
                + "SET " + Season_Stats.LAST_GAME_ID_COLUMN_NAME + " = " + ":last_game_id, "
                + Season_Stats.TEAM_ID_COLUMN_NAME + " = " + ":team_id, "
                + Season_Stats.WINS_COLUMN_NAME + " = " + ":wins, "
                + Season_Stats.LOSSES_COLUMN_NAME + " = " + ":losses, "
                + Season_Stats.TIES_COLUMN_NAME + " = " + ":ties, "
                + Season_Stats.H_RUNS_COLUMN_NAME + " = " + ":h_runs, "
                + Season_Stats.H_STRIKEOUTS_COLUMN_NAME + " = " + ":h_strikeouts, "
                + Season_Stats.H_FIELDOUTS_COLUMN_NAME + " = " + ":h_fieldouts, "
                + Season_Stats.H_WALKS_COLUMN_NAME + " = " + ":h_walks, "
                + Season_Stats.H_SINGLES_COLUMN_NAME + " = " + ":h_singles, "
                + Season_Stats.H_DOUBLES_COLUMN_NAME + " = " + ":h_doubles, "
                + Season_Stats.H_TRIPLES_COLUMN_NAME + " = " + ":h_triples, "
                + Season_Stats.H_HOMERUNS_COLUMN_NAME + " = " + ":h_homeruns, "
                + Season_Stats.P_RUNS_COLUMN_NAME + " = " + ":p_runs, "
                + Season_Stats.P_STRIKEOUTS_COLUMN_NAME + " = " + ":p_strikeouts, "
                + Season_Stats.P_FIELDOUTS_COLUMN_NAME + " = " + ":p_fieldouts, "
                + Season_Stats.P_WALKS_COLUMN_NAME + " = " + ":p_walks, "
                + Season_Stats.P_SINGLES_COLUMN_NAME + " = " + ":p_singles, "
                + Season_Stats.P_DOUBLES_COLUMN_NAME + " = " + ":p_doubles, "
                + Season_Stats.P_TRIPLES_COLUMN_NAME + " = " + ":p_triples, "
                + Season_Stats.P_HOMERUNS_COLUMN_NAME + " = " + ":p_homeruns "
                + "WHERE " + Season_Stats.ID_COLUMN_NAME + " = " + ":id;";
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("last_game_id", season_stats.getLast_game_id());
        parameters.addValue("team_id", season_stats.getTeam_id());
        parameters.addValue("wins", season_stats.getWins());
        parameters.addValue("losses", season_stats.getLosses());
        parameters.addValue("ties", season_stats.getTies());
        parameters.addValue("h_runs", season_stats.getH_runs());
        parameters.addValue("h_strikeouts", season_stats.getH_strikeouts());
        parameters.addValue("h_fieldouts", season_stats.getH_fieldouts());
        parameters.addValue("h_walks", season_stats.getH_walks());
        parameters.addValue("h_singles", season_stats.getH_singles());
        parameters.addValue("h_doubles", season_stats.getH_doubles());
        parameters.addValue("h_triples", season_stats.getH_triples());
        parameters.addValue("h_homeruns", season_stats.getH_homeruns());
        parameters.addValue("p_runs", season_stats.getP_runs());
        parameters.addValue("p_strikeouts", season_stats.getP_strikeouts());
        parameters.addValue("p_fieldouts", season_stats.getP_fieldouts());
        parameters.addValue("p_walks", season_stats.getP_walks());
        parameters.addValue("p_singles", season_stats.getP_singles());
        parameters.addValue("p_doubles", season_stats.getP_doubles());
        parameters.addValue("p_triples", season_stats.getP_triples());
        parameters.addValue("p_homeruns", season_stats.getP_homeruns());
        parameters.addValue("id", season_stats.getId());

        List<Map<String, Object>> keyList = new ArrayList<>();

        KeyHolder keyHolder = new GeneratedKeyHolder(keyList);

        int rowsEffected = namedParameterJdbcTemplate.update(queryTemplate, parameters, keyHolder);

        Map<String, Object> keyMap = keyHolder.getKeys();

        int id = (int) keyMap.get(Season_Stats.ID_COLUMN_NAME);

        season_stats.setId(id);

        return rowsEffected;
    }

    public void clearAlltimeStats() throws SQLException {
        String queryTemplate = "TRUNCATE alltime_stats RESTART IDENTITY";
        PreparedStatement preparedStatement = connection.prepareStatement(queryTemplate);
        preparedStatement.executeUpdate();
    }

    public List<Team> getTeamList() throws SQLException {
        String queryTemplate = "SELECT * FROM Team";
        PreparedStatement preparedStatement = connection.prepareStatement(queryTemplate);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Team> teamList = new ArrayList<>();
        while (resultSet.next()) {
            Team team = new Team(resultSet.getInt(Team.ID_COLUMN_NAME), resultSet.getString(Team.NAME_COLUMN_NAME));
            teamList.add(team);
        }

        return teamList;
    }

    public List<Game> getGameList() throws SQLException {
        String queryTemplate = "SELECT * FROM Game";
        PreparedStatement preparedStatement = connection.prepareStatement(queryTemplate);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Game> gameList = new ArrayList<>();
        while (resultSet.next()) {
            Game game = new Game(resultSet.getInt(Game.ID_COLUMN_NAME), resultSet.getInt(Game.SEASON_ID_COLUMN_NAME), resultSet.getDate(Game.DATE_OF_GAME_COLUMN_NAME));
            gameList.add(game);
        }

        return gameList;
    }

    public List<Season> getSeasonList() throws SQLException {
        String queryTemplate = "SELECT * FROM Season";
        PreparedStatement preparedStatement = connection.prepareStatement(queryTemplate);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Season> seasonList = new ArrayList<>();
        while (resultSet.next()) {
            Season season = new Season(resultSet.getInt(Season.ID_COLUMN_NAME));
            seasonList.add(season);
        }

        return seasonList;
    }

    public List<Inning> getInningList() throws SQLException {
        String queryTemplate = "SELECT * FROM Inning";
        PreparedStatement preparedStatement = connection.prepareStatement(queryTemplate);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Inning> inningList = new ArrayList<>();
        while (resultSet.next()) {
            Inning inning = new Inning(resultSet.getInt(Inning.ID_COLUMN_NAME), resultSet.getInt(Inning.GAME_ID_COLUMN_NAME), resultSet.getInt(Inning.INNING_NUMBER_COLUMN_NAME), resultSet.getInt(Inning.TEAM1_ID_COLUMN_NAME), resultSet.getInt(Inning.TEAM2_ID_COLUMN_NAME), resultSet.getInt(Inning.TEAM1_RUNS_COLUMN_NAME), resultSet.getInt(Inning.TEAM2_RUNS_COLUMN_NAME));
            inningList.add(inning);
        }

        return inningList;
    }

    public List<Plate_Appearance> getPlateAppearanceList() throws SQLException {
        String queryTemplate = "SELECT * FROM plate_appearance";
        PreparedStatement preparedStatement = connection.prepareStatement(queryTemplate);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Plate_Appearance> plateAppearanceList = new ArrayList<>();
        while (resultSet.next()) {
            Plate_Appearance plateAppearance = new Plate_Appearance(resultSet.getInt(Plate_Appearance.ID_COLUMN_NAME), resultSet.getInt(Plate_Appearance.INNING_ID_COLUMN_NAME), resultSet.getInt(Plate_Appearance.GAME_ID_COLUMN_NAME), resultSet.getInt(Plate_Appearance.SEASON_ID_COLUMN_NAME), resultSet.getInt(Plate_Appearance.PITCHER_ID_COLUMN_NAME), resultSet.getInt(Plate_Appearance.BATTER_ID_COLUMN_NAME), resultSet.getInt(Plate_Appearance.RESULT_ID_COLUMN_NAME));
            plateAppearanceList.add(plateAppearance);
        }

        return plateAppearanceList;
    }

    public List<Game_Stats> getGameStatsList() throws SQLException {
        String queryTemplate = "SELECT * FROM game_stats";
        PreparedStatement preparedStatement = connection.prepareStatement(queryTemplate);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Game_Stats> game_statsList = new ArrayList<>();
        while (resultSet.next()) {
            Game_Stats game_stats = new Game_Stats(resultSet.getInt(Game_Stats.ID_COLUMN_NAME), resultSet.getInt(Game_Stats.GAME_ID_COLUMN_NAME), resultSet.getInt(Game_Stats.SEASON_ID_COLUMN_NAME), resultSet.getInt(Game_Stats.TEAM_ID_COLUMN_NAME), resultSet.getInt(Game_Stats.H_RUNS_COLUMN_NAME), resultSet.getInt(Game_Stats.H_STRIKEOUTS_COLUMN_NAME), resultSet.getInt(Game_Stats.H_FIELDOUTS_COLUMN_NAME), resultSet.getInt(Game_Stats.H_WALKS_COLUMN_NAME), resultSet.getInt(Game_Stats.H_SINGLES_COLUMN_NAME), resultSet.getInt(Game_Stats.H_DOUBLES_COLUMN_NAME), resultSet.getInt(Game_Stats.H_TRIPLES_COLUMN_NAME), resultSet.getInt(Game_Stats.H_HOMERUNS_COLUMN_NAME), resultSet.getInt(Game_Stats.P_RUNS_COLUMN_NAME), resultSet.getInt(Game_Stats.P_STRIKEOUTS_COLUMN_NAME), resultSet.getInt(Game_Stats.P_FIELDOUTS_COLUMN_NAME), resultSet.getInt(Game_Stats.P_WALKS_COLUMN_NAME), resultSet.getInt(Game_Stats.P_SINGLES_COLUMN_NAME), resultSet.getInt(Game_Stats.P_DOUBLES_COLUMN_NAME), resultSet.getInt(Game_Stats.P_TRIPLES_COLUMN_NAME), resultSet.getInt(Game_Stats.P_HOMERUNS_COLUMN_NAME));
            game_statsList.add(game_stats);
        }

        return game_statsList;
    }

    public List<Season_Stats> getSeasonStatsList() throws SQLException {
        String queryTemplate = "SELECT * FROM season_stats";
        PreparedStatement preparedStatement = connection.prepareStatement(queryTemplate);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Season_Stats> season_statsList = new ArrayList<>();
        while (resultSet.next()) {
            Season_Stats season_stats = new Season_Stats(resultSet.getInt(Season_Stats.ID_COLUMN_NAME), resultSet.getInt(Season_Stats.SEASON_ID_COLUMN_NAME), resultSet.getInt(Season_Stats.LAST_GAME_ID_COLUMN_NAME), resultSet.getInt(Season_Stats.TEAM_ID_COLUMN_NAME), resultSet.getInt(Season_Stats.WINS_COLUMN_NAME), resultSet.getInt(Season_Stats.LOSSES_COLUMN_NAME), resultSet.getInt(Season_Stats.TIES_COLUMN_NAME), resultSet.getInt(Season_Stats.H_RUNS_COLUMN_NAME), resultSet.getInt(Season_Stats.H_STRIKEOUTS_COLUMN_NAME), resultSet.getInt(Season_Stats.H_FIELDOUTS_COLUMN_NAME), resultSet.getInt(Season_Stats.H_WALKS_COLUMN_NAME), resultSet.getInt(Season_Stats.H_SINGLES_COLUMN_NAME), resultSet.getInt(Season_Stats.H_DOUBLES_COLUMN_NAME), resultSet.getInt(Season_Stats.H_TRIPLES_COLUMN_NAME), resultSet.getInt(Season_Stats.H_HOMERUNS_COLUMN_NAME), resultSet.getInt(Season_Stats.P_RUNS_COLUMN_NAME), resultSet.getInt(Season_Stats.P_STRIKEOUTS_COLUMN_NAME), resultSet.getInt(Season_Stats.P_FIELDOUTS_COLUMN_NAME), resultSet.getInt(Season_Stats.P_WALKS_COLUMN_NAME), resultSet.getInt(Season_Stats.P_SINGLES_COLUMN_NAME), resultSet.getInt(Season_Stats.P_DOUBLES_COLUMN_NAME), resultSet.getInt(Season_Stats.P_TRIPLES_COLUMN_NAME), resultSet.getInt(Season_Stats.P_HOMERUNS_COLUMN_NAME));
            season_statsList.add(season_stats);
        }

        return season_statsList;
    }
}
