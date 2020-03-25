package ui.controllers;

import database.DatabaseConnection;
import database.tables.*;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import database.PlateAppearanceResultEnums;
import javafx.stage.Stage;
import ui.IntegerTextField;
import ui.Main;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class NewGameController implements Initializable {
    @FXML private TextField team1_name;
    @FXML private TextField team2_name;
    @FXML private IntegerTextField first_inning_t1_runs;
    @FXML private IntegerTextField first_inning_t1_walks;
    @FXML private IntegerTextField first_inning_t1_strikeouts;
    @FXML private IntegerTextField first_inning_t1_singles;
    @FXML private IntegerTextField first_inning_t1_doubles;
    @FXML private IntegerTextField first_inning_t1_triples;
    @FXML private IntegerTextField first_inning_t1_homeruns;
    @FXML private IntegerTextField first_inning_t2_runs;
    @FXML private IntegerTextField first_inning_t2_walks;
    @FXML private IntegerTextField first_inning_t2_strikeouts;
    @FXML private IntegerTextField first_inning_t2_singles;
    @FXML private IntegerTextField first_inning_t2_doubles;
    @FXML private IntegerTextField first_inning_t2_triples;
    @FXML private IntegerTextField first_inning_t2_homeruns;
    @FXML private IntegerTextField second_inning_t1_runs;
    @FXML private IntegerTextField second_inning_t1_walks;
    @FXML private IntegerTextField second_inning_t1_strikeouts;
    @FXML private IntegerTextField second_inning_t1_singles;
    @FXML private IntegerTextField second_inning_t1_doubles;
    @FXML private IntegerTextField second_inning_t1_triples;
    @FXML private IntegerTextField second_inning_t1_homeruns;
    @FXML private IntegerTextField second_inning_t2_runs;
    @FXML private IntegerTextField second_inning_t2_walks;
    @FXML private IntegerTextField second_inning_t2_strikeouts;
    @FXML private IntegerTextField second_inning_t2_singles;
    @FXML private IntegerTextField second_inning_t2_doubles;
    @FXML private IntegerTextField second_inning_t2_triples;
    @FXML private IntegerTextField second_inning_t2_homeruns;
    @FXML private IntegerTextField third_inning_t1_runs;
    @FXML private IntegerTextField third_inning_t1_walks;
    @FXML private IntegerTextField third_inning_t1_strikeouts;
    @FXML private IntegerTextField third_inning_t1_singles;
    @FXML private IntegerTextField third_inning_t1_doubles;
    @FXML private IntegerTextField third_inning_t1_triples;
    @FXML private IntegerTextField third_inning_t1_homeruns;
    @FXML private IntegerTextField third_inning_t2_runs;
    @FXML private IntegerTextField third_inning_t2_walks;
    @FXML private IntegerTextField third_inning_t2_strikeouts;
    @FXML private IntegerTextField third_inning_t2_singles;
    @FXML private IntegerTextField third_inning_t2_doubles;
    @FXML private IntegerTextField third_inning_t2_triples;
    @FXML private IntegerTextField third_inning_t2_homeruns;
    @FXML private IntegerTextField season_textfield;
    @FXML private IntegerTextField totalT1Runs;
    @FXML private IntegerTextField totalT1Walks;
    @FXML private IntegerTextField totalT1Strikeouts;
    @FXML private IntegerTextField totalT1Singles;
    @FXML private IntegerTextField totalT1Doubles;
    @FXML private IntegerTextField totalT1Triples;
    @FXML private IntegerTextField totalT1Homeruns;
    @FXML private IntegerTextField totalT2Runs;
    @FXML private IntegerTextField totalT2Walks;
    @FXML private IntegerTextField totalT2Strikeouts;
    @FXML private IntegerTextField totalT2Singles;
    @FXML private IntegerTextField totalT2Doubles;
    @FXML private IntegerTextField totalT2Triples;
    @FXML private IntegerTextField totalT2Homeruns;
    @FXML private DatePicker date;
    @FXML private Button done_button;
    @FXML private Button back_button;

    private DatabaseConnection databaseConnection;

    public NewGameController() {
        databaseConnection = Main.databaseConnection;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setupComponentBindings();
    }

    private void setupComponentBindings() {
        done_button.disableProperty().bind(
                first_inning_t1_runs.textProperty().isEmpty()
                        .or(first_inning_t1_walks.textProperty().isEmpty())
                        .or(first_inning_t1_strikeouts.textProperty().isEmpty())
                        .or(first_inning_t1_singles.textProperty().isEmpty())
                        .or(first_inning_t1_doubles.textProperty().isEmpty())
                        .or(first_inning_t1_triples.textProperty().isEmpty())
                        .or(first_inning_t1_homeruns.textProperty().isEmpty())
                        .or(first_inning_t2_runs.textProperty().isEmpty())
                        .or(first_inning_t2_walks.textProperty().isEmpty())
                        .or(first_inning_t2_strikeouts.textProperty().isEmpty())
                        .or(first_inning_t2_singles.textProperty().isEmpty())
                        .or(first_inning_t2_doubles.textProperty().isEmpty())
                        .or(first_inning_t2_triples.textProperty().isEmpty())
                        .or(first_inning_t2_homeruns.textProperty().isEmpty())
                        .or(second_inning_t1_runs.textProperty().isEmpty())
                        .or(second_inning_t1_walks.textProperty().isEmpty())
                        .or(second_inning_t1_strikeouts.textProperty().isEmpty())
                        .or(second_inning_t1_singles.textProperty().isEmpty())
                        .or(second_inning_t1_doubles.textProperty().isEmpty())
                        .or(second_inning_t1_triples.textProperty().isEmpty())
                        .or(second_inning_t1_homeruns.textProperty().isEmpty())
                        .or(second_inning_t2_runs.textProperty().isEmpty())
                        .or(second_inning_t2_walks.textProperty().isEmpty())
                        .or(second_inning_t2_strikeouts.textProperty().isEmpty())
                        .or(second_inning_t2_singles.textProperty().isEmpty())
                        .or(second_inning_t2_doubles.textProperty().isEmpty())
                        .or(second_inning_t2_triples.textProperty().isEmpty())
                        .or(second_inning_t2_homeruns.textProperty().isEmpty())
                        .or(third_inning_t1_runs.textProperty().isEmpty())
                        .or(third_inning_t1_walks.textProperty().isEmpty())
                        .or(third_inning_t1_strikeouts.textProperty().isEmpty())
                        .or(third_inning_t1_singles.textProperty().isEmpty())
                        .or(third_inning_t1_doubles.textProperty().isEmpty())
                        .or(third_inning_t1_triples.textProperty().isEmpty())
                        .or(third_inning_t1_homeruns.textProperty().isEmpty())
                        .or(season_textfield.textProperty().isEmpty())
                        .or(date.valueProperty().isNull())
        );

        totalT1Runs.textProperty().bind(Bindings.add(first_inning_t1_runs.valueProperty(), Bindings.add(second_inning_t1_runs.valueProperty(), third_inning_t1_runs.valueProperty())).asString());
        totalT1Walks.textProperty().bind(Bindings.add(first_inning_t1_walks.valueProperty(), Bindings.add(second_inning_t1_walks.valueProperty(), third_inning_t1_walks.valueProperty())).asString());
        totalT1Strikeouts.textProperty().bind(Bindings.add(first_inning_t1_strikeouts.valueProperty(), Bindings.add(second_inning_t1_strikeouts.valueProperty(), third_inning_t1_strikeouts.valueProperty())).asString());
        totalT1Singles.textProperty().bind(Bindings.add(first_inning_t1_singles.valueProperty(), Bindings.add(second_inning_t1_singles.valueProperty(), third_inning_t1_singles.valueProperty())).asString());
        totalT1Doubles.textProperty().bind(Bindings.add(first_inning_t1_doubles.valueProperty(), Bindings.add(second_inning_t1_doubles.valueProperty(), third_inning_t1_doubles.valueProperty())).asString());
        totalT1Triples.textProperty().bind(Bindings.add(first_inning_t1_triples.valueProperty(), Bindings.add(second_inning_t1_triples.valueProperty(), third_inning_t1_triples.valueProperty())).asString());
        totalT1Homeruns.textProperty().bind(Bindings.add(first_inning_t1_homeruns.valueProperty(), Bindings.add(second_inning_t1_homeruns.valueProperty(), third_inning_t1_homeruns.valueProperty())).asString());
        totalT2Runs.textProperty().bind(Bindings.add(first_inning_t2_runs.valueProperty(), Bindings.add(second_inning_t2_runs.valueProperty(), third_inning_t2_runs.valueProperty())).asString());
        totalT2Walks.textProperty().bind(Bindings.add(first_inning_t2_walks.valueProperty(), Bindings.add(second_inning_t2_walks.valueProperty(), third_inning_t2_walks.valueProperty())).asString());
        totalT2Strikeouts.textProperty().bind(Bindings.add(first_inning_t2_strikeouts.valueProperty(), Bindings.add(second_inning_t2_strikeouts.valueProperty(), third_inning_t2_strikeouts.valueProperty())).asString());
        totalT2Singles.textProperty().bind(Bindings.add(first_inning_t2_singles.valueProperty(), Bindings.add(second_inning_t2_singles.valueProperty(), third_inning_t2_singles.valueProperty())).asString());
        totalT2Doubles.textProperty().bind(Bindings.add(first_inning_t2_doubles.valueProperty(), Bindings.add(second_inning_t2_doubles.valueProperty(), third_inning_t2_doubles.valueProperty())).asString());
        totalT2Triples.textProperty().bind(Bindings.add(first_inning_t2_triples.valueProperty(), Bindings.add(second_inning_t2_triples.valueProperty(), third_inning_t2_triples.valueProperty())).asString());
        totalT2Homeruns.textProperty().bind(Bindings.add(first_inning_t2_homeruns.valueProperty(), Bindings.add(second_inning_t2_homeruns.valueProperty(), third_inning_t2_homeruns.valueProperty())).asString());
    }

    /**
     * Finds the value of the id column in the Team table where the team name is equal to the one provided
     * @return An int array which always has team1Id in the first index and team2Id in the second index
     * @throws SQLException
     */
    private int[] getTeamIds() throws SQLException {
        List<Team> teamList = databaseConnection.getTeamList();
        Integer team1Id = null;
        Integer team2Id = null;
        for(Team team : teamList)
        {
            if(team.getTeam_name().equalsIgnoreCase(team1_name.textProperty().toString()))
                team1Id = team.getId();
            else if (team.getTeam_name().equalsIgnoreCase(team2_name.textProperty().toString()))
                team2Id = team.getId();
        }
        if(team1Id == null)
        {
            Team team = new Team(team1_name.textProperty().getValue());
            databaseConnection.insert(team);
            team1Id = team.getId();
        }
        if(team2Id == null)
        {
            Team team = new Team(team2_name.textProperty().getValue());
            databaseConnection.insert(team);
            team2Id = team.getId();
        }

        return new int[] {team1Id, team2Id};
    }

    public void done_button_fired(ActionEvent actionEvent) throws SQLException {
        /* Get Team IDs */
        int[] teamIds = getTeamIds();
        int team1Id = teamIds[0];
        int team2Id = teamIds[1];

        /* Get Season ID */
        int seasonId = season_textfield.getValue();
        createSeasonIfNeeded(seasonId);

        /* Create Game */
        Game game = new Game();
        game.setSeason_id(seasonId);
        game.setDate_of_game(Date.valueOf(date.getValue()));
        databaseConnection.insert(game);

        /* Create Innings */
        Inning inning1 = createInning(game, 1, team1Id, team2Id);
        databaseConnection.insert(inning1);
        Inning inning2 = createInning(game, 2, team1Id, team2Id);
        databaseConnection.insert(inning2);
        Inning inning3 = createInning(game, 3, team1Id, team2Id);
        databaseConnection.insert(inning3);

        /* Create AtBats */
        createAtBats(game, inning1, inning2, inning3, team1Id, team2Id);

        /* Update Stats */
        try {
            fillGameStats();
            fillSeasonStats();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        clearFields();
    }

    private void createSeasonIfNeeded(int seasonId) throws SQLException {
        boolean makeNewSeason = true;
        List<Season> seasonList;
        seasonList = databaseConnection.getSeasonList();
        for(Season season : seasonList)
        {
            if (season.getId().equals(seasonId)) {
                makeNewSeason = false;
                break;
            }
        }
        if(makeNewSeason)
        {
            for(int i = seasonList.size() + 1; i <= seasonId; i++)
            {
                Season season = new Season();
                databaseConnection.insert(season);
            }
        }
    }

    private Inning createInning(Game game, int inningNumber, int team1Id, int team2Id)
    {
        Inning inning = new Inning();
        inning.setGame_id(game.getId());
        inning.setInning_number(inningNumber);
        inning.setTeam1_id(team1Id);
        inning.setTeam2_id(team2Id);

        if(inningNumber == 1)
        {
            inning.setTeam1_runs(first_inning_t1_runs.getValue());
            inning.setTeam2_runs(first_inning_t2_runs.getValue());
        }
        else if(inningNumber == 2)
        {
            inning.setTeam1_runs(second_inning_t1_runs.getValue());
            inning.setTeam2_runs(second_inning_t2_runs.getValue());
        }
        else if(inningNumber == 3)
        {
            inning.setTeam1_runs(third_inning_t1_runs.getValue());
            if (!third_inning_t2_runs.textProperty().isEmpty().get()) // allow non-played bottom half of the third
                inning.setTeam2_runs(third_inning_t2_runs.getValue());
        }

        return inning;
    }

    private void createAtBats(Game game, Inning inning1, Inning inning2, Inning inning3, int team1Id, int team2Id) {
        /* First inning at bats */
        for (int i = 0; i < first_inning_t1_walks.getValue(); i++) {
            insertAtBat(PlateAppearanceResultEnums.WALK, game, inning1, team1Id, team2Id);
        }
        for (int i = 0; i < first_inning_t2_walks.getValue(); i++) {
            insertAtBat(PlateAppearanceResultEnums.WALK, game, inning1, team2Id, team1Id);
        }

        for (int i = 0; i < first_inning_t1_strikeouts.getValue(); i++) {
            insertAtBat(PlateAppearanceResultEnums.STRIKEOUT, game, inning1, team1Id, team2Id);
        }
        for (int i = 0; i < first_inning_t2_strikeouts.getValue(); i++) {
            insertAtBat(PlateAppearanceResultEnums.STRIKEOUT, game, inning1, team2Id, team1Id);
        }
        if (first_inning_t1_strikeouts.getValue() != 3) {
            for (int i = 0; i < 3 - first_inning_t1_strikeouts.getValue(); i++)
                insertAtBat(PlateAppearanceResultEnums.FIELDOUT, game, inning1, team1Id, team2Id);
        }
        if (first_inning_t2_strikeouts.getValue() != 3) {
            for (int i = 0; i < 3 - first_inning_t2_strikeouts.getValue(); i++)
                insertAtBat(PlateAppearanceResultEnums.FIELDOUT, game, inning1, team2Id, team1Id);
        }

        for (int i = 0; i < first_inning_t1_singles.getValue(); i++) {
            insertAtBat(PlateAppearanceResultEnums.SINGLE, game, inning1, team1Id, team2Id);
        }
        for (int i = 0; i < first_inning_t2_singles.getValue(); i++) {
            insertAtBat(PlateAppearanceResultEnums.SINGLE, game, inning1, team2Id, team1Id);
        }

        for (int i = 0; i < first_inning_t1_doubles.getValue(); i++) {
            insertAtBat(PlateAppearanceResultEnums.DOUBLE, game, inning1, team1Id, team2Id);
        }
        for (int i = 0; i < first_inning_t2_doubles.getValue(); i++) {
            insertAtBat(PlateAppearanceResultEnums.DOUBLE, game, inning1, team2Id, team1Id);
        }

        for (int i = 0; i < first_inning_t1_triples.getValue(); i++) {
            insertAtBat(PlateAppearanceResultEnums.TRIPLE, game, inning1, team1Id, team2Id);
        }
        for (int i = 0; i < first_inning_t2_triples.getValue(); i++) {
            insertAtBat(PlateAppearanceResultEnums.TRIPLE, game, inning1, team2Id, team1Id);
        }

        for (int i = 0; i < first_inning_t1_homeruns.getValue(); i++) {
            insertAtBat(PlateAppearanceResultEnums.HOMERUN, game, inning1, team1Id, team2Id);
        }
        for (int i = 0; i < first_inning_t2_homeruns.getValue(); i++) {
            insertAtBat(PlateAppearanceResultEnums.HOMERUN, game, inning1, team2Id, team1Id);
        }

        /* Second inning at bats */
        for (int i = 0; i < second_inning_t1_walks.getValue(); i++) {
            insertAtBat(PlateAppearanceResultEnums.WALK, game, inning2, team1Id, team2Id);
        }
        for (int i = 0; i < second_inning_t2_walks.getValue(); i++) {
            insertAtBat(PlateAppearanceResultEnums.WALK, game, inning2, team2Id, team1Id);
        }

        for (int i = 0; i < second_inning_t1_strikeouts.getValue(); i++) {
            insertAtBat(PlateAppearanceResultEnums.STRIKEOUT, game, inning2, team1Id, team2Id);
        }
        for (int i = 0; i < second_inning_t2_strikeouts.getValue(); i++) {
            insertAtBat(PlateAppearanceResultEnums.STRIKEOUT, game, inning2, team2Id, team1Id);
        }
        if (second_inning_t1_strikeouts.getValue() != 3) {
            for (int i = 0; i < 3 - second_inning_t1_strikeouts.getValue(); i++)
                insertAtBat(PlateAppearanceResultEnums.FIELDOUT, game, inning2, team1Id, team2Id);
        }
        if (second_inning_t2_strikeouts.getValue() != 3) {
            for (int i = 0; i < 3 - second_inning_t2_strikeouts.getValue(); i++)
                insertAtBat(PlateAppearanceResultEnums.FIELDOUT, game, inning2, team2Id, team1Id);
        }

        for (int i = 0; i < second_inning_t1_singles.getValue(); i++) {
            insertAtBat(PlateAppearanceResultEnums.SINGLE, game, inning2, team1Id, team2Id);
        }
        for (int i = 0; i < second_inning_t2_singles.getValue(); i++) {
            insertAtBat(PlateAppearanceResultEnums.SINGLE, game, inning2, team2Id, team1Id);
        }

        for (int i = 0; i < second_inning_t1_doubles.getValue(); i++) {
            insertAtBat(PlateAppearanceResultEnums.DOUBLE, game, inning2, team1Id, team2Id);
        }
        for (int i = 0; i < second_inning_t2_doubles.getValue(); i++) {
            insertAtBat(PlateAppearanceResultEnums.DOUBLE, game, inning2, team2Id, team1Id);
        }

        for (int i = 0; i < second_inning_t1_triples.getValue(); i++) {
            insertAtBat(PlateAppearanceResultEnums.TRIPLE, game, inning2, team1Id, team2Id);
        }
        for (int i = 0; i < second_inning_t2_triples.getValue(); i++) {
            insertAtBat(PlateAppearanceResultEnums.TRIPLE, game, inning2, team2Id, team1Id);
        }

        for (int i = 0; i < second_inning_t1_homeruns.getValue(); i++) {
            insertAtBat(PlateAppearanceResultEnums.HOMERUN, game, inning2, team1Id, team2Id);
        }
        for (int i = 0; i < second_inning_t2_homeruns.getValue(); i++) {
            insertAtBat(PlateAppearanceResultEnums.HOMERUN, game, inning2, team2Id, team1Id);
        }

        /* Third inning at bats */
        for (int i = 0; i < third_inning_t1_walks.getValue(); i++) {
            insertAtBat(PlateAppearanceResultEnums.WALK, game, inning3, team1Id, team2Id);
        }
        for (int i = 0; i < third_inning_t2_walks.getValue(); i++) {
            insertAtBat(PlateAppearanceResultEnums.WALK, game, inning3, team2Id, team1Id);
        }

        for (int i = 0; i < third_inning_t1_strikeouts.getValue(); i++) {
            insertAtBat(PlateAppearanceResultEnums.STRIKEOUT, game, inning3, team1Id, team2Id);
        }
        for (int i = 0; i < third_inning_t2_strikeouts.getValue(); i++) {
            insertAtBat(PlateAppearanceResultEnums.STRIKEOUT, game, inning3, team2Id, team1Id);
        }
        if (third_inning_t1_strikeouts.getValue() != 3) {
            for (int i = 0; i < 3 - third_inning_t1_strikeouts.getValue(); i++)
                insertAtBat(PlateAppearanceResultEnums.FIELDOUT, game, inning3, team1Id, team2Id);
        }
        if (third_inning_t2_strikeouts.getValue() != 3 && !third_inning_t2_runs.textProperty().isEmpty().get()) {
            for (int i = 0; i < 3 - third_inning_t2_strikeouts.getValue(); i++)
                insertAtBat(PlateAppearanceResultEnums.FIELDOUT, game, inning3, team2Id, team1Id);
        }

        for (int i = 0; i < third_inning_t1_singles.getValue(); i++) {
            insertAtBat(PlateAppearanceResultEnums.SINGLE, game, inning3, team1Id, team2Id);
        }
        for (int i = 0; i < third_inning_t2_singles.getValue(); i++) {
            insertAtBat(PlateAppearanceResultEnums.SINGLE, game, inning3, team2Id, team1Id);
        }

        for (int i = 0; i < third_inning_t1_doubles.getValue(); i++) {
            insertAtBat(PlateAppearanceResultEnums.DOUBLE, game, inning3, team1Id, team2Id);
        }
        for (int i = 0; i < third_inning_t2_doubles.getValue(); i++) {
            insertAtBat(PlateAppearanceResultEnums.DOUBLE, game, inning3, team2Id, team1Id);
        }

        for (int i = 0; i < third_inning_t1_triples.getValue(); i++) {
            insertAtBat(PlateAppearanceResultEnums.TRIPLE, game, inning3, team1Id, team2Id);
        }
        for (int i = 0; i < third_inning_t2_triples.getValue(); i++) {
            insertAtBat(PlateAppearanceResultEnums.TRIPLE, game, inning3, team2Id, team1Id);
        }

        for (int i = 0; i < third_inning_t1_homeruns.getValue(); i++) {
            insertAtBat(PlateAppearanceResultEnums.HOMERUN, game, inning3, team1Id, team2Id);
        }
        for (int i = 0; i < third_inning_t2_homeruns.getValue(); i++) {
            insertAtBat(PlateAppearanceResultEnums.HOMERUN, game, inning3, team2Id, team1Id);
        }

    }

    private void insertAtBat(String result_type, Game game, Inning inning, int batter_id, int pitcher_id) {
        Plate_Appearance plateAppearance = new Plate_Appearance();
        plateAppearance.setSeason_id(game.getSeason_id());
        plateAppearance.setGame_id(game.getId());
        plateAppearance.setInning_id(inning.getId());
        plateAppearance.setBatter_id(batter_id);
        plateAppearance.setPitcher_id(pitcher_id);
        plateAppearance.setResult_id(PlateAppearanceResultEnums.RESULT_TYPE_TO_RESULT_ID_MAP.get(result_type));

        databaseConnection.insert(plateAppearance);
    }

    private void fillSeasonStats() throws SQLException {
        List<Season_Stats> season_statsList = databaseConnection.getSeasonStatsList();
        List<Season> seasonList = databaseConnection.getSeasonList();
        List<Game_Stats> game_statsList = databaseConnection.getGameStatsList();
        List<Team> teamList = databaseConnection.getTeamList();

        for (Team team : teamList) {
            int teamId = team.getId();
            for (Season season : seasonList) {
                int season_id = season.getId();
                boolean createNewSeasonStats = true;

                // does season_stats exist for that season, if so update it or leave it alone
                for (Season_Stats season_stats : season_statsList) {
                    // if stats do exist for the season, are they up to date?
                    if (season_stats.getSeason_id().equals(season_id) && season_stats.getTeam_id().equals(teamId)) {
                        createNewSeasonStats = false;
                        // check if season_stat's last_game_id is equal to newest game_id for the season
                        int last_game_id = season_stats.getLast_game_id();
                        int newestGameIdForSeason = getNewestGameIdForSeason(game_statsList, season_id);
                        if (last_game_id != newestGameIdForSeason) {

                            // update season_stats row
                            Season_Stats new_season_stats = newSeasonStats(game_statsList, season_id, teamId);
                            new_season_stats.setId(season_stats.getId());
                            databaseConnection.update(new_season_stats);
                        }
                        break;
                    }
                }

                if (createNewSeasonStats) {
                    // make entirely new season stats
                    Season_Stats new_season_stats = newSeasonStats(game_statsList, season_id, teamId);
                    databaseConnection.insert(new_season_stats);
                }
            }
        }
    }

    private Season_Stats newSeasonStats(List<Game_Stats> org_game_statsList, int season_id, int team_id) throws SQLException {
        List<Game_Stats> game_statsList = new ArrayList<>(org_game_statsList);

        int last_game_id = -1;
        int wins = 0;
        int losses = 0;
        int ties = 0;
        int h_runs = 0;
        int h_strikeouts = 0;
        int h_fieldouts = 0;
        int h_walks = 0;
        int h_singles = 0;
        int h_doubles = 0;
        int h_triples = 0;
        int h_homeruns = 0;
        int p_runs = 0;
        int p_strikeouts = 0;
        int p_fieldouts = 0;
        int p_walks = 0;
        int p_singles = 0;
        int p_doubles = 0;
        int p_triples = 0;
        int p_homeruns = 0;

        // remove unneeded game_stats
        game_statsList.removeIf(game_stats -> game_stats.getSeason_id() != season_id);

        for (Game_Stats game_stats : game_statsList) {
            if (game_stats.getTeam_id().equals(team_id)) {
                if (game_stats.getGame_id() > last_game_id)
                    last_game_id = game_stats.getGame_id();

                if (game_stats.getH_runs() > game_stats.getP_runs())
                    wins++;
                else if (game_stats.getH_runs().equals(game_stats.getP_runs()))
                    ties++;
                else if (game_stats.getH_runs() < game_stats.getP_runs())
                    losses++;

                h_runs += game_stats.getH_runs();
                h_strikeouts += game_stats.getH_strikeouts();
                h_fieldouts += game_stats.getH_fieldouts();
                h_walks += game_stats.getH_walks();
                h_singles += game_stats.getH_singles();
                h_doubles += game_stats.getH_doubles();
                h_triples += game_stats.getH_triples();
                h_homeruns += game_stats.getH_homeruns();

                p_runs += game_stats.getP_runs();
                p_strikeouts += game_stats.getP_strikeouts();
                p_fieldouts += game_stats.getP_fieldouts();
                p_walks += game_stats.getP_walks();
                p_singles += game_stats.getP_singles();
                p_doubles += game_stats.getP_doubles();
                p_triples += game_stats.getP_triples();
                p_homeruns += game_stats.getP_homeruns();
            }
        }

        return new Season_Stats(season_id, last_game_id, team_id, wins, losses, ties, h_runs, h_strikeouts, h_fieldouts, h_walks, h_singles, h_doubles, h_triples, h_homeruns, p_runs, p_strikeouts, p_fieldouts, p_walks, p_singles, p_doubles, p_triples, p_homeruns);
    }

    private int getNewestGameIdForSeason(List<Game_Stats> game_statsList, int season_id) throws SQLException {
        int newestGameId = -1;
        for (Game_Stats game_stats : game_statsList) {
            if (game_stats.getSeason_id().equals(season_id)) {
                if (game_stats.getGame_id() > newestGameId)
                    newestGameId = game_stats.getGame_id();
            }
        }
        return newestGameId;
    }

    private void fillGameStats() throws SQLException {
        List<Game_Stats> game_statsList = databaseConnection.getGameStatsList();
        List<Game> gameList = databaseConnection.getGameList();
        List<Plate_Appearance> plateAppearanceList = databaseConnection.getPlateAppearanceList();
        List<Inning> inningList = databaseConnection.getInningList();
        List<Team> teamList = databaseConnection.getTeamList();

        // don't fill game stats for ones we already have
        for (Game_Stats game_stats : game_statsList) {
            gameList.removeIf(game -> game_stats.getGame_id().equals(game.getId()));
        }

        for (Game game : gameList) {
            int game_id = game.getId();
            for (Team team : teamList) {
                int team_id = team.getId();

                int h_runs = 0;
                int h_strikeouts = 0;
                int h_fieldouts = 0;
                int h_walks = 0;
                int h_singles = 0;
                int h_doubles = 0;
                int h_triples = 0;
                int h_homeruns = 0;
                int p_runs = 0;
                int p_strikeouts = 0;
                int p_fieldouts = 0;
                int p_walks = 0;
                int p_singles = 0;
                int p_doubles = 0;
                int p_triples = 0;
                int p_homeruns = 0;


                for (Inning inning : inningList) {
                    if (inning.getGame_id().equals(game_id)) {
                        if (inning.getTeam1_id().equals(team_id)) {
                            h_runs += inning.getTeam1_runs();
                            p_runs += inning.getTeam2_runs();
                        } else if (inning.getTeam2_id().equals(team_id)) {
                            h_runs += inning.getTeam2_runs();
                            p_runs += inning.getTeam1_runs();
                        }
                    }
                }

                for (Plate_Appearance plateAppearance : plateAppearanceList) {
                    if (plateAppearance.getGame_id().equals(game_id)) {
                        if (plateAppearance.getBatter_id().equals(team_id)) {
                            switch (PlateAppearanceResultEnums.RESULT_ID_TO_RESULT_TYPE_MAP.get(plateAppearance.getResult_id())) {
                                case PlateAppearanceResultEnums.WALK:
                                    h_walks++;
                                    break;
                                case PlateAppearanceResultEnums.STRIKEOUT:
                                    h_strikeouts++;
                                    break;
                                case PlateAppearanceResultEnums.FIELDOUT:
                                    h_fieldouts++;
                                    break;
                                case PlateAppearanceResultEnums.SINGLE:
                                    h_singles++;
                                    break;
                                case PlateAppearanceResultEnums.DOUBLE:
                                    h_doubles++;
                                    break;
                                case PlateAppearanceResultEnums.TRIPLE:
                                    h_triples++;
                                    break;
                                case PlateAppearanceResultEnums.HOMERUN:
                                    h_homeruns++;
                                    break;
                            }
                        } else if (plateAppearance.getPitcher_id() == team_id) {
                            switch (PlateAppearanceResultEnums.RESULT_ID_TO_RESULT_TYPE_MAP.get(plateAppearance.getResult_id())) {
                                case PlateAppearanceResultEnums.WALK:
                                    p_walks++;
                                    break;
                                case PlateAppearanceResultEnums.STRIKEOUT:
                                    p_strikeouts++;
                                    break;
                                case PlateAppearanceResultEnums.FIELDOUT:
                                    p_fieldouts++;
                                    break;
                                case PlateAppearanceResultEnums.SINGLE:
                                    p_singles++;
                                    break;
                                case PlateAppearanceResultEnums.DOUBLE:
                                    p_doubles++;
                                    break;
                                case PlateAppearanceResultEnums.TRIPLE:
                                    p_triples++;
                                    break;
                                case PlateAppearanceResultEnums.HOMERUN:
                                    p_homeruns++;
                                    break;
                            }
                        }
                    }
                }

                Game_Stats game_stats = new Game_Stats(game_id, game.getSeason_id(), team_id, h_runs, h_strikeouts, h_fieldouts, h_walks, h_singles, h_doubles, h_triples, h_homeruns, p_runs, p_strikeouts, p_fieldouts, p_walks, p_singles, p_doubles, p_triples, p_homeruns);
                databaseConnection.insert(game_stats);
            }
        }
    }

    public void clearFields() {
        first_inning_t1_runs.clear();
        first_inning_t1_walks.clear();
        first_inning_t1_strikeouts.clear();
        first_inning_t1_singles.clear();
        first_inning_t1_doubles.clear();
        first_inning_t1_triples.clear();
        first_inning_t1_homeruns.clear();
        first_inning_t2_runs.clear();
        first_inning_t2_walks.clear();
        first_inning_t2_strikeouts.clear();
        first_inning_t2_singles.clear();
        first_inning_t2_doubles.clear();
        first_inning_t2_triples.clear();
        first_inning_t2_homeruns.clear();
        second_inning_t1_runs.clear();
        second_inning_t1_walks.clear();
        second_inning_t1_strikeouts.clear();
        second_inning_t1_singles.clear();
        second_inning_t1_doubles.clear();
        second_inning_t1_triples.clear();
        second_inning_t1_homeruns.clear();
        second_inning_t2_runs.clear();
        second_inning_t2_walks.clear();
        second_inning_t2_strikeouts.clear();
        second_inning_t2_singles.clear();
        second_inning_t2_doubles.clear();
        second_inning_t2_triples.clear();
        second_inning_t2_homeruns.clear();
        third_inning_t1_runs.clear();
        third_inning_t1_walks.clear();
        third_inning_t1_strikeouts.clear();
        third_inning_t1_singles.clear();
        third_inning_t1_doubles.clear();
        third_inning_t1_triples.clear();
        third_inning_t1_homeruns.clear();
        third_inning_t2_runs.clear();
        third_inning_t2_walks.clear();
        third_inning_t2_strikeouts.clear();
        third_inning_t2_singles.clear();
        third_inning_t2_doubles.clear();
        third_inning_t2_triples.clear();
        third_inning_t2_homeruns.clear();
    }

    public void backButtonClicked(ActionEvent actionEvent) {
        Stage stage = (Stage) back_button.getScene().getWindow();
        stage.close();
        Main.stg.show();
    }
}
