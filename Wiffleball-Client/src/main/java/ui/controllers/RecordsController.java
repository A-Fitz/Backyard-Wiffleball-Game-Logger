package ui.controllers;

import database.DatabaseConnection;
import database.tables.Game;
import database.tables.Team;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import stats.RecordsBreakdown;
import stats.Records;
import ui.Main;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.StringJoiner;

public class RecordsController implements Initializable {
    @FXML private Label team1_name;
    @FXML private Label team2_name;
    @FXML private TextField t1_record_max_runs;
    @FXML private TextField t1_count_max_runs;
    @FXML private TextField t1_dates_max_runs;
    @FXML private TextField t1_record_max_plateAppearances;
    @FXML private TextField t1_count_max_plateAppearances;
    @FXML private TextField t1_dates_max_plateAppearances;
    @FXML private TextField t1_record_max_atBats;
    @FXML private TextField t1_count_max_atBats;
    @FXML private TextField t1_dates_max_atBats;
    @FXML private TextField t1_record_max_walks;
    @FXML private TextField t1_count_max_walks;
    @FXML private TextField t1_dates_max_walks;
    @FXML private TextField t1_record_max_strikeouts;
    @FXML private TextField t1_count_max_strikeouts;
    @FXML private TextField t1_dates_max_strikeouts;
    @FXML private TextField t1_record_max_fieldouts;
    @FXML private TextField t1_count_max_fieldouts;
    @FXML private TextField t1_dates_max_fieldouts;
    @FXML private TextField t1_record_max_hits;
    @FXML private TextField t1_count_max_hits;
    @FXML private TextField t1_dates_max_hits;
    @FXML private TextField t1_record_max_singles;
    @FXML private TextField t1_count_max_singles;
    @FXML private TextField t1_dates_max_singles;
    @FXML private TextField t1_record_max_doubles;
    @FXML private TextField t1_count_max_doubles;
    @FXML private TextField t1_dates_max_doubles;
    @FXML private TextField t1_record_max_triples;
    @FXML private TextField t1_count_max_triples;
    @FXML private TextField t1_dates_max_triples;
    @FXML private TextField t1_record_max_homeruns;
    @FXML private TextField t1_count_max_homeruns;
    @FXML private TextField t1_dates_max_homeruns;
    @FXML private TextField t2_record_max_runs;
    @FXML private TextField t2_count_max_runs;
    @FXML private TextField t2_dates_max_runs;
    @FXML private TextField t2_record_max_plateAppearances;
    @FXML private TextField t2_count_max_plateAppearances;
    @FXML private TextField t2_dates_max_plateAppearances;
    @FXML private TextField t2_record_max_atBats;
    @FXML private TextField t2_count_max_atBats;
    @FXML private TextField t2_dates_max_atBats;
    @FXML private TextField t2_record_max_walks;
    @FXML private TextField t2_count_max_walks;
    @FXML private TextField t2_dates_max_walks;
    @FXML private TextField t2_record_max_strikeouts;
    @FXML private TextField t2_count_max_strikeouts;
    @FXML private TextField t2_dates_max_strikeouts;
    @FXML private TextField t2_record_max_fieldouts;
    @FXML private TextField t2_count_max_fieldouts;
    @FXML private TextField t2_dates_max_fieldouts;
    @FXML private TextField t2_record_max_hits;
    @FXML private TextField t2_count_max_hits;
    @FXML private TextField t2_dates_max_hits;
    @FXML private TextField t2_record_max_singles;
    @FXML private TextField t2_count_max_singles;
    @FXML private TextField t2_dates_max_singles;
    @FXML private TextField t2_record_max_doubles;
    @FXML private TextField t2_count_max_doubles;
    @FXML private TextField t2_dates_max_doubles;
    @FXML private TextField t2_record_max_triples;
    @FXML private TextField t2_count_max_triples;
    @FXML private TextField t2_dates_max_triples;
    @FXML private TextField t2_record_max_homeruns;
    @FXML private TextField t2_count_max_homeruns;
    @FXML private TextField t2_dates_max_homeruns;
    @FXML private TextField t1_record_min_runs;
    @FXML private TextField t1_count_min_runs;
    @FXML private TextField t1_dates_min_runs;
    @FXML private TextField t1_record_min_plateAppearances;
    @FXML private TextField t1_count_min_plateAppearances;
    @FXML private TextField t1_dates_min_plateAppearances;
    @FXML private TextField t1_record_min_atBats;
    @FXML private TextField t1_count_min_atBats;
    @FXML private TextField t1_dates_min_atBats;
    @FXML private TextField t1_record_min_walks;
    @FXML private TextField t1_count_min_walks;
    @FXML private TextField t1_dates_min_walks;
    @FXML private TextField t1_record_min_strikeouts;
    @FXML private TextField t1_count_min_strikeouts;
    @FXML private TextField t1_dates_min_strikeouts;
    @FXML private TextField t1_record_min_fieldouts;
    @FXML private TextField t1_count_min_fieldouts;
    @FXML private TextField t1_dates_min_fieldouts;
    @FXML private TextField t1_record_min_hits;
    @FXML private TextField t1_count_min_hits;
    @FXML private TextField t1_dates_min_hits;
    @FXML private TextField t1_record_min_singles;
    @FXML private TextField t1_count_min_singles;
    @FXML private TextField t1_dates_min_singles;
    @FXML private TextField t1_record_min_doubles;
    @FXML private TextField t1_count_min_doubles;
    @FXML private TextField t1_dates_min_doubles;
    @FXML private TextField t1_record_min_triples;
    @FXML private TextField t1_count_min_triples;
    @FXML private TextField t1_dates_min_triples;
    @FXML private TextField t1_record_min_homeruns;
    @FXML private TextField t1_count_min_homeruns;
    @FXML private TextField t1_dates_min_homeruns;
    @FXML private TextField t2_record_min_runs;
    @FXML private TextField t2_count_min_runs;
    @FXML private TextField t2_dates_min_runs;
    @FXML private TextField t2_record_min_plateAppearances;
    @FXML private TextField t2_count_min_plateAppearances;
    @FXML private TextField t2_dates_min_plateAppearances;
    @FXML private TextField t2_record_min_atBats;
    @FXML private TextField t2_count_min_atBats;
    @FXML private TextField t2_dates_min_atBats;
    @FXML private TextField t2_record_min_walks;
    @FXML private TextField t2_count_min_walks;
    @FXML private TextField t2_dates_min_walks;
    @FXML private TextField t2_record_min_strikeouts;
    @FXML private TextField t2_count_min_strikeouts;
    @FXML private TextField t2_dates_min_strikeouts;
    @FXML private TextField t2_record_min_fieldouts;
    @FXML private TextField t2_count_min_fieldouts;
    @FXML private TextField t2_dates_min_fieldouts;
    @FXML private TextField t2_record_min_hits;
    @FXML private TextField t2_count_min_hits;
    @FXML private TextField t2_dates_min_hits;
    @FXML private TextField t2_record_min_singles;
    @FXML private TextField t2_count_min_singles;
    @FXML private TextField t2_dates_min_singles;
    @FXML private TextField t2_record_min_doubles;
    @FXML private TextField t2_count_min_doubles;
    @FXML private TextField t2_dates_min_doubles;
    @FXML private TextField t2_record_min_triples;
    @FXML private TextField t2_count_min_triples;
    @FXML private TextField t2_dates_min_triples;
    @FXML private TextField t2_record_min_homeruns;
    @FXML private TextField t2_count_min_homeruns;
    @FXML private TextField t2_dates_min_homeruns;
    @FXML private Button back_button;

    private List<Game> gameList;
    private DatabaseConnection databaseConnection;
    private RecordsBreakdown t1RecordsBreakdown;
    private RecordsBreakdown t2RecordsBreakdown;

    public RecordsController()
    {
        databaseConnection = Main.databaseConnection;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            gameList = databaseConnection.getGameList();

            for(Team team : databaseConnection.getTeamList())
            {
                if(team.getTeam_name().equalsIgnoreCase(team1_name.getText()))
                    t1RecordsBreakdown = new RecordsBreakdown(team.getId());
                else if(team.getTeam_name().equalsIgnoreCase(team2_name.getText()))
                    t2RecordsBreakdown = new RecordsBreakdown(team.getId());
            }
            t1RecordsBreakdown.calculate();
            t2RecordsBreakdown.calculate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        fillFields();
    }

    private void fillFields()
    {
        /* team 1 max */
        Records t1SingleGameRecords = t1RecordsBreakdown.getSingleGameRecords();
        t1_record_max_runs.textProperty().set(String.valueOf(t1SingleGameRecords.getMaxTotalRuns()));
        t1_count_max_runs.textProperty().set(String.valueOf(t1SingleGameRecords.getCount_maxTotalRuns()));
        t1_dates_max_runs.textProperty().set(gameIdListToString(t1SingleGameRecords.getGameIdList_maxTotalRuns()));
        t1_record_max_plateAppearances.textProperty().set(String.valueOf(t1SingleGameRecords.getMaxTotalPlateAppearances()));
        t1_count_max_plateAppearances.textProperty().set(String.valueOf(t1SingleGameRecords.getCount_maxTotalPlateAppearances()));
        t1_dates_max_plateAppearances.textProperty().set(gameIdListToString(t1SingleGameRecords.getGameIdList_maxTotalPlateAppearances()));
        t1_record_max_atBats.textProperty().set(String.valueOf(t1SingleGameRecords.getMaxTotalAtBats()));
        t1_count_max_atBats.textProperty().set(String.valueOf(t1SingleGameRecords.getCount_maxTotalAtBats()));
        t1_dates_max_atBats.textProperty().set(gameIdListToString(t1SingleGameRecords.getGameIdList_maxTotalAtBats()));
        t1_record_max_walks.textProperty().set(String.valueOf(t1SingleGameRecords.getMaxTotalWalks()));
        t1_count_max_walks.textProperty().set(String.valueOf(t1SingleGameRecords.getCount_maxTotalWalks()));
        t1_dates_max_walks.textProperty().set(gameIdListToString(t1SingleGameRecords.getGameIdList_maxTotalWalks()));
        t1_record_max_walks.textProperty().set(String.valueOf(t1SingleGameRecords.getMaxTotalWalks()));
        t1_count_max_walks.textProperty().set(String.valueOf(t1SingleGameRecords.getCount_maxTotalWalks()));
        t1_dates_max_walks.textProperty().set(gameIdListToString(t1SingleGameRecords.getGameIdList_maxTotalWalks()));
        t1_record_max_strikeouts.textProperty().set(String.valueOf(t1SingleGameRecords.getMaxTotalStrikeouts()));
        t1_count_max_strikeouts.textProperty().set(String.valueOf(t1SingleGameRecords.getCount_maxTotalStrikeouts()));
        t1_dates_max_strikeouts.textProperty().set(gameIdListToString(t1SingleGameRecords.getGameIdList_maxTotalStrikeouts()));
        t1_record_max_fieldouts.textProperty().set(String.valueOf(t1SingleGameRecords.getMaxTotalFieldouts()));
        t1_count_max_fieldouts.textProperty().set(String.valueOf(t1SingleGameRecords.getCount_maxTotalFieldouts()));
        t1_dates_max_fieldouts.textProperty().set(gameIdListToString(t1SingleGameRecords.getGameIdList_maxTotalFieldouts()));
        t1_record_max_hits.textProperty().set(String.valueOf(t1SingleGameRecords.getMaxTotalHits()));
        t1_count_max_hits.textProperty().set(String.valueOf(t1SingleGameRecords.getCount_maxTotalHits()));
        t1_dates_max_hits.textProperty().set(gameIdListToString(t1SingleGameRecords.getGameIdList_maxTotalHits()));
        t1_record_max_singles.textProperty().set(String.valueOf(t1SingleGameRecords.getMaxTotalSingles()));
        t1_count_max_singles.textProperty().set(String.valueOf(t1SingleGameRecords.getCount_maxTotalSingles()));
        t1_dates_max_singles.textProperty().set(gameIdListToString(t1SingleGameRecords.getGameIdList_maxTotalSingles()));
        t1_record_max_doubles.textProperty().set(String.valueOf(t1SingleGameRecords.getMaxTotalDoubles()));
        t1_count_max_doubles.textProperty().set(String.valueOf(t1SingleGameRecords.getCount_maxTotalDoubles()));
        t1_dates_max_doubles.textProperty().set(gameIdListToString(t1SingleGameRecords.getGameIdList_maxTotalDoubles()));
        t1_record_max_triples.textProperty().set(String.valueOf(t1SingleGameRecords.getMaxTotalTriples()));
        t1_count_max_triples.textProperty().set(String.valueOf(t1SingleGameRecords.getCount_maxTotalTriples()));
        t1_dates_max_triples.textProperty().set(gameIdListToString(t1SingleGameRecords.getGameIdList_maxTotalTriples()));
        t1_record_max_homeruns.textProperty().set(String.valueOf(t1SingleGameRecords.getMaxTotalHomeruns()));
        t1_count_max_homeruns.textProperty().set(String.valueOf(t1SingleGameRecords.getCount_maxTotalHomeruns()));
        t1_dates_max_homeruns.textProperty().set(gameIdListToString(t1SingleGameRecords.getGameIdList_maxTotalHomeruns()));
        /* team 1 min */
        t1_record_min_runs.textProperty().set(String.valueOf(t1SingleGameRecords.getMinTotalRuns()));
        t1_count_min_runs.textProperty().set(String.valueOf(t1SingleGameRecords.getCount_minTotalRuns()));
        t1_dates_min_runs.textProperty().set(gameIdListToString(t1SingleGameRecords.getGameIdList_minTotalRuns()));
        t1_record_min_plateAppearances.textProperty().set(String.valueOf(t1SingleGameRecords.getMinTotalPlateAppearances()));
        t1_count_min_plateAppearances.textProperty().set(String.valueOf(t1SingleGameRecords.getCount_minTotalPlateAppearances()));
        t1_dates_min_plateAppearances.textProperty().set(gameIdListToString(t1SingleGameRecords.getGameIdList_minTotalPlateAppearances()));
        t1_record_min_atBats.textProperty().set(String.valueOf(t1SingleGameRecords.getMinTotalAtBats()));
        t1_count_min_atBats.textProperty().set(String.valueOf(t1SingleGameRecords.getCount_minTotalAtBats()));
        t1_dates_min_atBats.textProperty().set(gameIdListToString(t1SingleGameRecords.getGameIdList_minTotalAtBats()));
        t1_record_min_walks.textProperty().set(String.valueOf(t1SingleGameRecords.getMinTotalWalks()));
        t1_count_min_walks.textProperty().set(String.valueOf(t1SingleGameRecords.getCount_minTotalWalks()));
        t1_dates_min_walks.textProperty().set(gameIdListToString(t1SingleGameRecords.getGameIdList_minTotalWalks()));
        t1_record_min_walks.textProperty().set(String.valueOf(t1SingleGameRecords.getMinTotalWalks()));
        t1_count_min_walks.textProperty().set(String.valueOf(t1SingleGameRecords.getCount_minTotalWalks()));
        t1_dates_min_walks.textProperty().set(gameIdListToString(t1SingleGameRecords.getGameIdList_minTotalWalks()));
        t1_record_min_strikeouts.textProperty().set(String.valueOf(t1SingleGameRecords.getMinTotalStrikeouts()));
        t1_count_min_strikeouts.textProperty().set(String.valueOf(t1SingleGameRecords.getCount_minTotalStrikeouts()));
        t1_dates_min_strikeouts.textProperty().set(gameIdListToString(t1SingleGameRecords.getGameIdList_minTotalStrikeouts()));
        t1_record_min_fieldouts.textProperty().set(String.valueOf(t1SingleGameRecords.getMinTotalFieldouts()));
        t1_count_min_fieldouts.textProperty().set(String.valueOf(t1SingleGameRecords.getCount_minTotalFieldouts()));
        t1_dates_min_fieldouts.textProperty().set(gameIdListToString(t1SingleGameRecords.getGameIdList_minTotalFieldouts()));
        t1_record_min_hits.textProperty().set(String.valueOf(t1SingleGameRecords.getMinTotalHits()));
        t1_count_min_hits.textProperty().set(String.valueOf(t1SingleGameRecords.getCount_minTotalHits()));
        t1_dates_min_hits.textProperty().set(gameIdListToString(t1SingleGameRecords.getGameIdList_minTotalHits()));
        t1_record_min_singles.textProperty().set(String.valueOf(t1SingleGameRecords.getMinTotalSingles()));
        t1_count_min_singles.textProperty().set(String.valueOf(t1SingleGameRecords.getCount_minTotalSingles()));
        t1_dates_min_singles.textProperty().set(gameIdListToString(t1SingleGameRecords.getGameIdList_minTotalSingles()));
        t1_record_min_doubles.textProperty().set(String.valueOf(t1SingleGameRecords.getMinTotalDoubles()));
        t1_count_min_doubles.textProperty().set(String.valueOf(t1SingleGameRecords.getCount_minTotalDoubles()));
        t1_dates_min_doubles.textProperty().set(gameIdListToString(t1SingleGameRecords.getGameIdList_minTotalDoubles()));
        t1_record_min_triples.textProperty().set(String.valueOf(t1SingleGameRecords.getMinTotalTriples()));
        t1_count_min_triples.textProperty().set(String.valueOf(t1SingleGameRecords.getCount_minTotalTriples()));
        t1_dates_min_triples.textProperty().set(gameIdListToString(t1SingleGameRecords.getGameIdList_minTotalTriples()));
        t1_record_min_homeruns.textProperty().set(String.valueOf(t1SingleGameRecords.getMinTotalHomeruns()));
        t1_count_min_homeruns.textProperty().set(String.valueOf(t1SingleGameRecords.getCount_minTotalHomeruns()));
        t1_dates_min_homeruns.textProperty().set(gameIdListToString(t1SingleGameRecords.getGameIdList_minTotalHomeruns()));
        
        /* team 2 max */
        Records t2SingleGameRecords = t2RecordsBreakdown.getSingleGameRecords();
        t2_record_max_runs.textProperty().set(String.valueOf(t2SingleGameRecords.getMaxTotalRuns()));
        t2_count_max_runs.textProperty().set(String.valueOf(t2SingleGameRecords.getCount_maxTotalRuns()));
        t2_dates_max_runs.textProperty().set(gameIdListToString(t2SingleGameRecords.getGameIdList_maxTotalRuns()));
        t2_record_max_plateAppearances.textProperty().set(String.valueOf(t2SingleGameRecords.getMaxTotalPlateAppearances()));
        t2_count_max_plateAppearances.textProperty().set(String.valueOf(t2SingleGameRecords.getCount_maxTotalPlateAppearances()));
        t2_dates_max_plateAppearances.textProperty().set(gameIdListToString(t2SingleGameRecords.getGameIdList_maxTotalPlateAppearances()));
        t2_record_max_atBats.textProperty().set(String.valueOf(t2SingleGameRecords.getMaxTotalAtBats()));
        t2_count_max_atBats.textProperty().set(String.valueOf(t2SingleGameRecords.getCount_maxTotalAtBats()));
        t2_dates_max_atBats.textProperty().set(gameIdListToString(t2SingleGameRecords.getGameIdList_maxTotalAtBats()));
        t2_record_max_walks.textProperty().set(String.valueOf(t2SingleGameRecords.getMaxTotalWalks()));
        t2_count_max_walks.textProperty().set(String.valueOf(t2SingleGameRecords.getCount_maxTotalWalks()));
        t2_dates_max_walks.textProperty().set(gameIdListToString(t2SingleGameRecords.getGameIdList_maxTotalWalks()));
        t2_record_max_walks.textProperty().set(String.valueOf(t2SingleGameRecords.getMaxTotalWalks()));
        t2_count_max_walks.textProperty().set(String.valueOf(t2SingleGameRecords.getCount_maxTotalWalks()));
        t2_dates_max_walks.textProperty().set(gameIdListToString(t2SingleGameRecords.getGameIdList_maxTotalWalks()));
        t2_record_max_strikeouts.textProperty().set(String.valueOf(t2SingleGameRecords.getMaxTotalStrikeouts()));
        t2_count_max_strikeouts.textProperty().set(String.valueOf(t2SingleGameRecords.getCount_maxTotalStrikeouts()));
        t2_dates_max_strikeouts.textProperty().set(gameIdListToString(t2SingleGameRecords.getGameIdList_maxTotalStrikeouts()));
        t2_record_max_fieldouts.textProperty().set(String.valueOf(t2SingleGameRecords.getMaxTotalFieldouts()));
        t2_count_max_fieldouts.textProperty().set(String.valueOf(t2SingleGameRecords.getCount_maxTotalFieldouts()));
        t2_dates_max_fieldouts.textProperty().set(gameIdListToString(t2SingleGameRecords.getGameIdList_maxTotalFieldouts()));
        t2_record_max_hits.textProperty().set(String.valueOf(t2SingleGameRecords.getMaxTotalHits()));
        t2_count_max_hits.textProperty().set(String.valueOf(t2SingleGameRecords.getCount_maxTotalHits()));
        t2_dates_max_hits.textProperty().set(gameIdListToString(t2SingleGameRecords.getGameIdList_maxTotalHits()));
        t2_record_max_singles.textProperty().set(String.valueOf(t2SingleGameRecords.getMaxTotalSingles()));
        t2_count_max_singles.textProperty().set(String.valueOf(t2SingleGameRecords.getCount_maxTotalSingles()));
        t2_dates_max_singles.textProperty().set(gameIdListToString(t2SingleGameRecords.getGameIdList_maxTotalSingles()));
        t2_record_max_doubles.textProperty().set(String.valueOf(t2SingleGameRecords.getMaxTotalDoubles()));
        t2_count_max_doubles.textProperty().set(String.valueOf(t2SingleGameRecords.getCount_maxTotalDoubles()));
        t2_dates_max_doubles.textProperty().set(gameIdListToString(t2SingleGameRecords.getGameIdList_maxTotalDoubles()));
        t2_record_max_triples.textProperty().set(String.valueOf(t2SingleGameRecords.getMaxTotalTriples()));
        t2_count_max_triples.textProperty().set(String.valueOf(t2SingleGameRecords.getCount_maxTotalTriples()));
        t2_dates_max_triples.textProperty().set(gameIdListToString(t2SingleGameRecords.getGameIdList_maxTotalTriples()));
        t2_record_max_homeruns.textProperty().set(String.valueOf(t2SingleGameRecords.getMaxTotalHomeruns()));
        t2_count_max_homeruns.textProperty().set(String.valueOf(t2SingleGameRecords.getCount_maxTotalHomeruns()));
        t2_dates_max_homeruns.textProperty().set(gameIdListToString(t2SingleGameRecords.getGameIdList_maxTotalHomeruns()));
        /* team 2 min */
        t2_record_min_runs.textProperty().set(String.valueOf(t2SingleGameRecords.getMinTotalRuns()));
        t2_count_min_runs.textProperty().set(String.valueOf(t2SingleGameRecords.getCount_minTotalRuns()));
        t2_dates_min_runs.textProperty().set(gameIdListToString(t2SingleGameRecords.getGameIdList_minTotalRuns()));
        t2_record_min_plateAppearances.textProperty().set(String.valueOf(t2SingleGameRecords.getMinTotalPlateAppearances()));
        t2_count_min_plateAppearances.textProperty().set(String.valueOf(t2SingleGameRecords.getCount_minTotalPlateAppearances()));
        t2_dates_min_plateAppearances.textProperty().set(gameIdListToString(t2SingleGameRecords.getGameIdList_minTotalPlateAppearances()));
        t2_record_min_atBats.textProperty().set(String.valueOf(t2SingleGameRecords.getMinTotalAtBats()));
        t2_count_min_atBats.textProperty().set(String.valueOf(t2SingleGameRecords.getCount_minTotalAtBats()));
        t2_dates_min_atBats.textProperty().set(gameIdListToString(t2SingleGameRecords.getGameIdList_minTotalAtBats()));
        t2_record_min_walks.textProperty().set(String.valueOf(t2SingleGameRecords.getMinTotalWalks()));
        t2_count_min_walks.textProperty().set(String.valueOf(t2SingleGameRecords.getCount_minTotalWalks()));
        t2_dates_min_walks.textProperty().set(gameIdListToString(t2SingleGameRecords.getGameIdList_minTotalWalks()));
        t2_record_min_walks.textProperty().set(String.valueOf(t2SingleGameRecords.getMinTotalWalks()));
        t2_count_min_walks.textProperty().set(String.valueOf(t2SingleGameRecords.getCount_minTotalWalks()));
        t2_dates_min_walks.textProperty().set(gameIdListToString(t2SingleGameRecords.getGameIdList_minTotalWalks()));
        t2_record_min_strikeouts.textProperty().set(String.valueOf(t2SingleGameRecords.getMinTotalStrikeouts()));
        t2_count_min_strikeouts.textProperty().set(String.valueOf(t2SingleGameRecords.getCount_minTotalStrikeouts()));
        t2_dates_min_strikeouts.textProperty().set(gameIdListToString(t2SingleGameRecords.getGameIdList_minTotalStrikeouts()));
        t2_record_min_fieldouts.textProperty().set(String.valueOf(t2SingleGameRecords.getMinTotalFieldouts()));
        t2_count_min_fieldouts.textProperty().set(String.valueOf(t2SingleGameRecords.getCount_minTotalFieldouts()));
        t2_dates_min_fieldouts.textProperty().set(gameIdListToString(t2SingleGameRecords.getGameIdList_minTotalFieldouts()));
        t2_record_min_hits.textProperty().set(String.valueOf(t2SingleGameRecords.getMinTotalHits()));
        t2_count_min_hits.textProperty().set(String.valueOf(t2SingleGameRecords.getCount_minTotalHits()));
        t2_dates_min_hits.textProperty().set(gameIdListToString(t2SingleGameRecords.getGameIdList_minTotalHits()));
        t2_record_min_singles.textProperty().set(String.valueOf(t2SingleGameRecords.getMinTotalSingles()));
        t2_count_min_singles.textProperty().set(String.valueOf(t2SingleGameRecords.getCount_minTotalSingles()));
        t2_dates_min_singles.textProperty().set(gameIdListToString(t2SingleGameRecords.getGameIdList_minTotalSingles()));
        t2_record_min_doubles.textProperty().set(String.valueOf(t2SingleGameRecords.getMinTotalDoubles()));
        t2_count_min_doubles.textProperty().set(String.valueOf(t2SingleGameRecords.getCount_minTotalDoubles()));
        t2_dates_min_doubles.textProperty().set(gameIdListToString(t2SingleGameRecords.getGameIdList_minTotalDoubles()));
        t2_record_min_triples.textProperty().set(String.valueOf(t2SingleGameRecords.getMinTotalTriples()));
        t2_count_min_triples.textProperty().set(String.valueOf(t2SingleGameRecords.getCount_minTotalTriples()));
        t2_dates_min_triples.textProperty().set(gameIdListToString(t2SingleGameRecords.getGameIdList_minTotalTriples()));
        t2_record_min_homeruns.textProperty().set(String.valueOf(t2SingleGameRecords.getMinTotalHomeruns()));
        t2_count_min_homeruns.textProperty().set(String.valueOf(t2SingleGameRecords.getCount_minTotalHomeruns()));
        t2_dates_min_homeruns.textProperty().set(gameIdListToString(t2SingleGameRecords.getGameIdList_minTotalHomeruns()));
    }

    private String gameIdListToString(List<Integer> gameIdList)
    {
        StringJoiner joiner = new StringJoiner(", ");
        //TODO efficiency
        for(Integer gameId : gameIdList)
        {
            for(Game game : gameList)
            {
                if(game.getId().equals(gameId))
                {
                    joiner.add(game.getDate_of_game().toString());
                }
            }
        }
        return joiner.toString();
    }

    public void backButtonClicked(ActionEvent actionEvent) {
        Stage stage = (Stage) back_button.getScene().getWindow();
        stage.close();
        Main.stg.show();
    }
}
