package ui.controllers;

import database.DatabaseConnection;
import database.tables.Game_Stats;
import database.tables.Team;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import stats.StatsBreakdown;
import ui.Launcher;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class GraphsController implements Initializable {
    @FXML private HBox hbox;
    @FXML private ComboBox combobox;
    @FXML private Button back_button;
    private final String cboxBattingAverageOverTime = "Batting Average Over Time";
    private final String cboxHitsOverTime = "Hit Type Over Time";
    private final String cboxHomerunsPerGameOverTime = "Homeruns Per Game Over Time";
    private final String cboxPAResultOverTime = "Plate Appearance Result Over Time";

    private DatabaseConnection databaseConnection;
    private List<Team> teamList;
    private List<Game_Stats> game_statsList;
    private StatsBreakdown team1StatsBreakdown;
    private StatsBreakdown team2StatsBreakdown;
    private Team team1;
    private Team team2;

    public GraphsController() {
        databaseConnection = Launcher.databaseConnection;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            teamList = databaseConnection.getTeamList();
            game_statsList = databaseConnection.getGameStatsList();
            getDefaultTeams();
            team1StatsBreakdown = new StatsBreakdown(team1.getId());
            team2StatsBreakdown = new StatsBreakdown(team2.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        hbox.setFillHeight(true);

        fillCombobox();
    }

    private void fillCombobox() {
        combobox.getItems().add(cboxBattingAverageOverTime);
        combobox.getItems().add(cboxHitsOverTime);
        combobox.getItems().add(cboxHomerunsPerGameOverTime);
        combobox.getItems().add(cboxPAResultOverTime);
    }

    public void comboboxAction(ActionEvent actionEvent) {
        hbox.getChildren().clear();

        String selectedValue = (String) combobox.getValue();
        if (selectedValue.equals(cboxBattingAverageOverTime))
            createBattingAverageChart();
        else if (selectedValue.equals(cboxHitsOverTime)) {
            int yAxisUpperBound;
            // ceiling to nearest 10
            if (team1StatsBreakdown.getStatsAllTime().getTotalHits() > team2StatsBreakdown.getStatsAllTime().getTotalHits()) {
                yAxisUpperBound = ((team1StatsBreakdown.getStatsAllTime().getTotalHits() + 10) / 10) * 10;
            } else {
                yAxisUpperBound = ((team2StatsBreakdown.getStatsAllTime().getTotalHits() + 10) / 10) * 10;
            }
            createHitsOverTimeChart(team1, yAxisUpperBound);
            createHitsOverTimeChart(team2, yAxisUpperBound);
        } else if (selectedValue.equals(cboxHomerunsPerGameOverTime)) {
            createHomerunsPerGameOverTimeChart();
        } else if (selectedValue.equals(cboxPAResultOverTime)) {
            int yAxisUpperBound;
            // ceiling to nearest 10
            if (team1StatsBreakdown.getStatsAllTime().getTotalPlateAppearances() > team2StatsBreakdown.getStatsAllTime().getTotalPlateAppearances()) {
                yAxisUpperBound = ((team1StatsBreakdown.getStatsAllTime().getTotalPlateAppearances() + 10) / 10) * 10;
            } else {
                yAxisUpperBound = ((team2StatsBreakdown.getStatsAllTime().getTotalPlateAppearances() + 10) / 10) * 10;
            }
            createPlateApperanceResultsOverTimeChart(team1, yAxisUpperBound);
            createPlateApperanceResultsOverTimeChart(team2, yAxisUpperBound);
        }

    }

    private void createBattingAverageChart() {
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Games");
        xAxis.setTickLabelFormatter(gamesIntegerAxis);
        yAxis.setLabel("Batting Average");
        yAxis.forceZeroInRangeProperty().setValue(false);

        final LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Batting Average Over Time");

        XYChart.Series<Number, Number> team1Series = new XYChart.Series<>();
        team1Series.setName(team1.getTeam_name());
        XYChart.Series<Number, Number> team2Series = new XYChart.Series<>();
        team2Series.setName(team2.getTeam_name());

        int totalT1Games = 0;
        int totalT2Games = 0;
        int totalT1AtBats = 0;
        int totalT2AtBats = 0;
        int totalT1Hits = 0;
        int totalT2Hits = 0;
        for (Game_Stats game_stats : game_statsList) {
            if (game_stats.getTeam_id().equals(team1.getId())) {
                totalT1Games++;
                totalT1AtBats += game_stats.getH_singles() + game_stats.getH_doubles() + game_stats.getH_triples() + game_stats.getH_homeruns() + game_stats.getH_strikeouts() + game_stats.getH_fieldouts();
                totalT1Hits += game_stats.getH_singles() + game_stats.getH_doubles() + game_stats.getH_triples() + game_stats.getH_homeruns();
                team1Series.getData().add(new XYChart.Data<>(totalT1Games, (float) totalT1Hits / (float) totalT1AtBats));
            } else if (game_stats.getTeam_id().equals(team2.getId())) {
                totalT2Games++;
                totalT2AtBats += game_stats.getH_singles() + game_stats.getH_doubles() + game_stats.getH_triples() + game_stats.getH_homeruns() + game_stats.getH_strikeouts() + game_stats.getH_fieldouts();
                totalT2Hits += game_stats.getH_singles() + game_stats.getH_doubles() + game_stats.getH_triples() + game_stats.getH_homeruns();
                team2Series.getData().add(new XYChart.Data<>(totalT2Games, (float) totalT2Hits / (float) totalT2AtBats));
            }
        }
        lineChart.getData().add(team1Series);
        lineChart.getData().add(team2Series);

        lineChart.createSymbolsProperty().setValue(false);
        lineChart.prefWidthProperty().bind(hbox.widthProperty());

        hbox.getChildren().add(lineChart);
    }

    private void createHitsOverTimeChart(Team team, int yAxisUpperBound) {
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Games");
        xAxis.setTickLabelFormatter(gamesIntegerAxis);
        yAxis.setLabel("Hits");
        yAxis.setAutoRanging(false);
        yAxis.setUpperBound(yAxisUpperBound);

        final StackedAreaChart<Number, Number> areaChart = new StackedAreaChart<>(xAxis, yAxis);
        areaChart.setTitle("Hits Over Time For " + team.getTeam_name());

        XYChart.Series<Number, Number> singlesSeries = new XYChart.Series<>();
        singlesSeries.setName("Singles");
        XYChart.Series<Number, Number> doublesSeries = new XYChart.Series<>();
        doublesSeries.setName("Doubles");
        XYChart.Series<Number, Number> triplesSeries = new XYChart.Series<>();
        triplesSeries.setName("Triples");
        XYChart.Series<Number, Number> homerunsSeries = new XYChart.Series<>();
        homerunsSeries.setName("Homeruns");

        int totalGames = 0;
        int totalSingles = 0;
        int totalDoubles = 0;
        int totalTriples = 0;
        int totalHomeruns = 0;
        for (Game_Stats game_stats : game_statsList) {
            if (game_stats.getTeam_id().equals(team.getId())) {
                totalGames++;
                totalSingles += game_stats.getH_singles();
                totalDoubles += game_stats.getH_doubles();
                totalTriples += game_stats.getH_triples();
                totalHomeruns += game_stats.getH_homeruns();

                singlesSeries.getData().add(new XYChart.Data<>(totalGames, totalSingles));
                doublesSeries.getData().add(new XYChart.Data<>(totalGames, totalDoubles));
                triplesSeries.getData().add(new XYChart.Data<>(totalGames, totalTriples));
                homerunsSeries.getData().add(new XYChart.Data<>(totalGames, totalHomeruns));
            }
        }
        areaChart.getData().add(singlesSeries);
        areaChart.getData().add(doublesSeries);
        areaChart.getData().add(triplesSeries);
        areaChart.getData().add(homerunsSeries);

        areaChart.createSymbolsProperty().setValue(false);
        areaChart.prefWidthProperty().bind(hbox.widthProperty());

        hbox.getChildren().add(areaChart);
    }

    private void createHomerunsPerGameOverTimeChart() {
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Games");
        xAxis.setTickLabelFormatter(gamesIntegerAxis);
        yAxis.setLabel("Homeruns Per Game");

        final LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Homeruns Per Game Over Time");

        XYChart.Series<Number, Number> team1Series = new XYChart.Series<>();
        team1Series.setName(team1.getTeam_name());
        XYChart.Series<Number, Number> team2Series = new XYChart.Series<>();
        team2Series.setName(team2.getTeam_name());

        int totalT1Games = 0;
        int totalT2Games = 0;
        int totalT1Homeruns = 0;
        int totalT2Homeruns = 0;
        for (Game_Stats game_stats : game_statsList) {
            if (game_stats.getTeam_id().equals(team1.getId())) {
                totalT1Games++;
                totalT1Homeruns += game_stats.getH_homeruns();
                team1Series.getData().add(new XYChart.Data<>(totalT1Games, (float) totalT1Homeruns / (float) totalT1Games));
            } else if (game_stats.getTeam_id().equals(team2.getId())) {
                totalT2Games++;
                totalT2Homeruns += game_stats.getH_homeruns();
                team2Series.getData().add(new XYChart.Data<>(totalT2Games, (float) totalT2Homeruns / (float) totalT2Games));
            }
        }
        lineChart.getData().add(team1Series);
        lineChart.getData().add(team2Series);

        lineChart.createSymbolsProperty().setValue(false);
        lineChart.prefWidthProperty().bind(hbox.widthProperty());

        hbox.getChildren().add(lineChart);
    }

    private void createPlateApperanceResultsOverTimeChart(Team team, int yAxisUpperBound) {
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Games");
        xAxis.setTickLabelFormatter(gamesIntegerAxis);
        yAxis.setLabel("Plate Appearances");
        yAxis.setAutoRanging(false);
        yAxis.setUpperBound(yAxisUpperBound);

        final StackedAreaChart<Number, Number> areaChart = new StackedAreaChart<>(xAxis, yAxis);
        areaChart.setTitle("PA Result Over Time For " + team.getTeam_name());

        XYChart.Series<Number, Number> walksSeries = new XYChart.Series<>();
        walksSeries.setName("Walks");
        XYChart.Series<Number, Number> hitsSeries = new XYChart.Series<>();
        hitsSeries.setName("Hits");
        XYChart.Series<Number, Number> strikeoutsSeries = new XYChart.Series<>();
        strikeoutsSeries.setName("Strikeouts");
        XYChart.Series<Number, Number> fieldoutsSeries = new XYChart.Series<>();
        fieldoutsSeries.setName("Fieldouts");

        int totalGames = 0;
        int totalWalks = 0;
        int totalHits = 0;
        int totalStrikeouts = 0;
        int totalFieldouts = 0;
        for (Game_Stats game_stats : game_statsList) {
            if (game_stats.getTeam_id().equals(team.getId())) {
                totalGames++;
                totalWalks += game_stats.getH_walks();
                totalHits += game_stats.getH_singles() + game_stats.getH_doubles() + game_stats.getH_triples() + game_stats.getH_homeruns();
                totalStrikeouts += game_stats.getH_strikeouts();
                totalFieldouts += game_stats.getH_fieldouts();

                walksSeries.getData().add(new XYChart.Data<>(totalGames, totalWalks));
                hitsSeries.getData().add(new XYChart.Data<>(totalGames, totalHits));
                strikeoutsSeries.getData().add(new XYChart.Data<>(totalGames, totalStrikeouts));
                fieldoutsSeries.getData().add(new XYChart.Data<>(totalGames, totalFieldouts));
            }
        }
        areaChart.getData().add(walksSeries);
        areaChart.getData().add(hitsSeries);
        areaChart.getData().add(strikeoutsSeries);
        areaChart.getData().add(fieldoutsSeries);

        areaChart.createSymbolsProperty().setValue(false);
        areaChart.prefWidthProperty().bind(hbox.widthProperty());

        hbox.getChildren().add(areaChart);
    }

    private void getDefaultTeams() {
        for (Team team : teamList) {
            if (team.getTeam_name().equalsIgnoreCase("Austin"))
                team1 = team;
            else if (team.getTeam_name().equalsIgnoreCase("Colin"))
                team2 = team;
        }
    }

    public void backButtonClicked(ActionEvent actionEvent) {
        Stage stage = (Stage) back_button.getScene().getWindow();
        stage.close();
        Launcher.stg.show();
    }

    private StringConverter<Number> gamesIntegerAxis = new StringConverter<>() {
        @Override
        public String toString(Number number) {
            if (number.intValue() != number.doubleValue())
                return "";
            return "" + (number.intValue());
        }

        @Override
        public Number fromString(String s) {
            Number val = Double.parseDouble(s);
            return val.intValue();
        }
    };
}
