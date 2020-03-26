package ui.controllers;

import database.DatabaseConnection;
import database.tables.Team;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import stats.StatsBreakdown;
import stats.Stats;
import ui.Launcher;

import java.net.URL;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class StatsController implements Initializable {

    @FXML private Label team1_name;
    @FXML private Label team2_name;

    @FXML private TextField d_t1_record;
    @FXML private TextField d_t1_runs;
    @FXML private TextField d_t1_plateAppearances;
    @FXML private TextField d_t1_atBats;
    @FXML private TextField d_t1_walks;
    @FXML private TextField d_t1_strikeouts;
    @FXML private TextField d_t1_fieldouts;
    @FXML private TextField d_t1_hits;
    @FXML private TextField d_t1_singles;
    @FXML private TextField d_t1_doubles;
    @FXML private TextField d_t1_triples;
    @FXML private TextField d_t1_homeruns;
    @FXML private TextField d_t1_cycleGames;
    @FXML private TextField d_t1_cycleInnings;
    @FXML private TextField d_t1_shutouts;
    @FXML private TextField d_t1_savedThird;
    @FXML private TextField d_t1_blownThird;
    @FXML private TextField d_t1_noHitters;
    @FXML private TextField d_t1_perfectGames;
    @FXML private TextField c_t1_record;
    @FXML private TextField c_t1_battingAverage;
    @FXML private TextField c_t1_onBasePercentage;
    @FXML private TextField c_t1_slugging;
    @FXML private TextField c_t1_runs;
    @FXML private TextField c_t1_plateAppearances;
    @FXML private TextField c_t1_atBats;
    @FXML private TextField c_t1_walks;
    @FXML private TextField c_t1_strikeouts;
    @FXML private TextField c_t1_fieldouts;
    @FXML private TextField c_t1_hits;
    @FXML private TextField c_t1_singles;
    @FXML private TextField c_t1_doubles;
    @FXML private TextField c_t1_triples;
    @FXML private TextField c_t1_homeruns;

    @FXML private TextField d_t2_record;
    @FXML private TextField d_t2_runs;
    @FXML private TextField d_t2_plateAppearances;
    @FXML private TextField d_t2_atBats;
    @FXML private TextField d_t2_walks;
    @FXML private TextField d_t2_strikeouts;
    @FXML private TextField d_t2_fieldouts;
    @FXML private TextField d_t2_hits;
    @FXML private TextField d_t2_singles;
    @FXML private TextField d_t2_doubles;
    @FXML private TextField d_t2_triples;
    @FXML private TextField d_t2_homeruns;
    @FXML private TextField d_t2_cycleGames;
    @FXML private TextField d_t2_cycleInnings;
    @FXML private TextField d_t2_shutouts;
    @FXML private TextField d_t2_savedThird;
    @FXML private TextField d_t2_blownThird;
    @FXML private TextField d_t2_noHitters;
    @FXML private TextField d_t2_perfectGames;
    @FXML private TextField c_t2_record;
    @FXML private TextField c_t2_battingAverage;
    @FXML private TextField c_t2_onBasePercentage;
    @FXML private TextField c_t2_slugging;
    @FXML private TextField c_t2_runs;
    @FXML private TextField c_t2_plateAppearances;
    @FXML private TextField c_t2_atBats;
    @FXML private TextField c_t2_walks;
    @FXML private TextField c_t2_strikeouts;
    @FXML private TextField c_t2_fieldouts;
    @FXML private TextField c_t2_hits;
    @FXML private TextField c_t2_singles;
    @FXML private TextField c_t2_doubles;
    @FXML private TextField c_t2_triples;
    @FXML private TextField c_t2_homeruns;

    @FXML private Button back_button;

    private DatabaseConnection databaseConnection;
    private StatsBreakdown t1StatsBreakdown;
    private StatsBreakdown t2StatsBreakdown;
    private static DecimalFormat dfPercentage = new DecimalFormat("0.00%"); //used for record percentage
    private static DecimalFormat df = new DecimalFormat("0.00");
    private static DecimalFormat df2 = new DecimalFormat("0.000"); // used for BA/OBP/SLG

    public StatsController()
    {
        databaseConnection = Launcher.databaseConnection;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            for(Team team : databaseConnection.getTeamList())
            {
                if(team.getTeam_name().equalsIgnoreCase(team1_name.getText()))
                    t1StatsBreakdown = new StatsBreakdown(team.getId());
                else if(team.getTeam_name().equalsIgnoreCase(team2_name.getText()))
                    t2StatsBreakdown = new StatsBreakdown(team.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        fillFields();
    }

    private void fillFields()
    {
        Stats t1StatsAllTime = t1StatsBreakdown.getStatsAllTime();
        d_t1_record.textProperty().setValue(t1StatsAllTime.getTotalWins() + "-" + t1StatsAllTime.getTotalLosses() + "-" + t1StatsAllTime.getTotalTies());
        d_t1_runs.textProperty().set(String.valueOf(t1StatsAllTime.getTotalRuns()));
        d_t1_plateAppearances.textProperty().set(String.valueOf(t1StatsAllTime.getTotalPlateAppearances()));
        d_t1_atBats.textProperty().set(String.valueOf(t1StatsAllTime.getTotalAtBats()));
        d_t1_walks.textProperty().set(String.valueOf(t1StatsAllTime.getTotalWalks()));
        d_t1_strikeouts.textProperty().set(String.valueOf(t1StatsAllTime.getTotalStrikeouts()));
        d_t1_fieldouts.textProperty().set(String.valueOf(t1StatsAllTime.getTotalFieldouts()));
        d_t1_hits.textProperty().set(String.valueOf(t1StatsAllTime.getTotalHits()));
        d_t1_singles.textProperty().set(String.valueOf(t1StatsAllTime.getTotalSingles()));
        d_t1_doubles.textProperty().set(String.valueOf(t1StatsAllTime.getTotalDoubles()));
        d_t1_triples.textProperty().set(String.valueOf(t1StatsAllTime.getTotalTriples()));
        d_t1_homeruns.textProperty().set(String.valueOf(t1StatsAllTime.getTotalHomeruns()));
        d_t1_cycleGames.textProperty().set(String.valueOf(t1StatsAllTime.getTotalCycleGames()));
        d_t1_cycleInnings.textProperty().set(String.valueOf(t1StatsAllTime.getTotalCycleInnings()));
        d_t1_shutouts.textProperty().set(String.valueOf(t1StatsAllTime.getTotalShutouts()));
        d_t1_savedThird.textProperty().set(String.valueOf(t1StatsAllTime.getTotalSavedThirds()));
        d_t1_blownThird.textProperty().set(String.valueOf(t1StatsAllTime.getTotalBlownThirds()));
        d_t1_noHitters.textProperty().set(String.valueOf(t1StatsAllTime.getTotalNoHitters()));
        d_t1_perfectGames.textProperty().set(String.valueOf(t1StatsAllTime.getTotalPerfectGames()));

        c_t1_record.textProperty().setValue(dfPercentage.format(t1StatsAllTime.getWinPercentage()) + "-" + dfPercentage.format(t1StatsAllTime.getLossPercentage()) + "-" + dfPercentage.format(t1StatsAllTime.getTiePercentage()));
        c_t1_battingAverage.textProperty().set(df2.format(t1StatsAllTime.getBattingAverage()));
        c_t1_onBasePercentage.textProperty().set(df2.format(t1StatsAllTime.getOnBasePercentage()));
        c_t1_slugging.textProperty().set(df2.format(t1StatsAllTime.getSlugging()));
        c_t1_runs.textProperty().set(df.format(t1StatsAllTime.getRunsPerGame()));
        c_t1_plateAppearances.textProperty().set(df.format(t1StatsAllTime.getPlateAppearancesPerGame()));
        c_t1_atBats.textProperty().set(df.format(t1StatsAllTime.getAtBatsPerGame()));
        c_t1_walks.textProperty().set(df.format(t1StatsAllTime.getWalksPerGame()));
        c_t1_strikeouts.textProperty().set(df.format(t1StatsAllTime.getStrikeoutsPerGame()));
        c_t1_fieldouts.textProperty().set(df.format(t1StatsAllTime.getFieldoutsPerGame()));
        c_t1_hits.textProperty().set(df.format(t1StatsAllTime.getHitsPerGame()));
        c_t1_singles.textProperty().set(df.format(t1StatsAllTime.getSinglesPerGame()));
        c_t1_doubles.textProperty().set(df.format(t1StatsAllTime.getDoublesPerGame()));
        c_t1_triples.textProperty().set(df.format(t1StatsAllTime.getTriplesPerGame()));
        c_t1_homeruns.textProperty().set(df.format(t1StatsAllTime.getHomerunsPerGame()));

        Stats t2StatsAllTime = t2StatsBreakdown.getStatsAllTime();
        d_t2_record.textProperty().setValue(t2StatsAllTime.getTotalWins() + "-" + t2StatsAllTime.getTotalLosses() + "-" + t2StatsAllTime.getTotalTies());
        d_t2_runs.textProperty().set(String.valueOf(t2StatsAllTime.getTotalRuns()));
        d_t2_plateAppearances.textProperty().set(String.valueOf(t2StatsAllTime.getTotalPlateAppearances()));
        d_t2_atBats.textProperty().set(String.valueOf(t2StatsAllTime.getTotalAtBats()));
        d_t2_walks.textProperty().set(String.valueOf(t2StatsAllTime.getTotalWalks()));
        d_t2_strikeouts.textProperty().set(String.valueOf(t2StatsAllTime.getTotalStrikeouts()));
        d_t2_fieldouts.textProperty().set(String.valueOf(t2StatsAllTime.getTotalFieldouts()));
        d_t2_hits.textProperty().set(String.valueOf(t2StatsAllTime.getTotalHits()));
        d_t2_singles.textProperty().set(String.valueOf(t2StatsAllTime.getTotalSingles()));
        d_t2_doubles.textProperty().set(String.valueOf(t2StatsAllTime.getTotalDoubles()));
        d_t2_triples.textProperty().set(String.valueOf(t2StatsAllTime.getTotalTriples()));
        d_t2_homeruns.textProperty().set(String.valueOf(t2StatsAllTime.getTotalHomeruns()));
        d_t2_cycleGames.textProperty().set(String.valueOf(t2StatsAllTime.getTotalCycleGames()));
        d_t2_cycleInnings.textProperty().set(String.valueOf(t2StatsAllTime.getTotalCycleInnings()));
        d_t2_shutouts.textProperty().set(String.valueOf(t2StatsAllTime.getTotalShutouts()));
        d_t2_savedThird.textProperty().set(String.valueOf(t2StatsAllTime.getTotalSavedThirds()));
        d_t2_blownThird.textProperty().set(String.valueOf(t2StatsAllTime.getTotalBlownThirds()));
        d_t2_noHitters.textProperty().set(String.valueOf(t2StatsAllTime.getTotalNoHitters()));
        d_t2_perfectGames.textProperty().set(String.valueOf(t2StatsAllTime.getTotalPerfectGames()));

        c_t2_record.textProperty().setValue(dfPercentage.format(t2StatsAllTime.getWinPercentage()) + "-" + dfPercentage.format(t2StatsAllTime.getLossPercentage()) + "-" + dfPercentage.format(t2StatsAllTime.getTiePercentage()));
        c_t2_battingAverage.textProperty().set(df2.format(t2StatsAllTime.getBattingAverage()));
        c_t2_onBasePercentage.textProperty().set(df2.format(t2StatsAllTime.getOnBasePercentage()));
        c_t2_slugging.textProperty().set(df2.format(t2StatsAllTime.getSlugging()));
        c_t2_runs.textProperty().set(df.format(t2StatsAllTime.getRunsPerGame()));
        c_t2_plateAppearances.textProperty().set(df.format(t2StatsAllTime.getPlateAppearancesPerGame()));
        c_t2_atBats.textProperty().set(df.format(t2StatsAllTime.getAtBatsPerGame()));
        c_t2_walks.textProperty().set(df.format(t2StatsAllTime.getWalksPerGame()));
        c_t2_strikeouts.textProperty().set(df.format(t2StatsAllTime.getStrikeoutsPerGame()));
        c_t2_fieldouts.textProperty().set(df.format(t2StatsAllTime.getFieldoutsPerGame()));
        c_t2_hits.textProperty().set(df.format(t2StatsAllTime.getHitsPerGame()));
        c_t2_singles.textProperty().set(df.format(t2StatsAllTime.getSinglesPerGame()));
        c_t2_doubles.textProperty().set(df.format(t2StatsAllTime.getDoublesPerGame()));
        c_t2_triples.textProperty().set(df.format(t2StatsAllTime.getTriplesPerGame()));
        c_t2_homeruns.textProperty().set(df.format(t2StatsAllTime.getHomerunsPerGame()));
    }

    public void backButtonClicked(ActionEvent actionEvent) {
        Stage stage = (Stage) back_button.getScene().getWindow();
        stage.close();
        Launcher.stg.show();
    }
}
