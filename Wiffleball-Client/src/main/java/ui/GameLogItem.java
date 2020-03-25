package ui;

import database.PlateAppearanceResultEnums;
import database.tables.*;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import java.util.List;

public class GameLogItem {
    private List<Plate_Appearance> plateAppearanceList;
    private List<Inning> inningList;
    private Team team1;
    private Team team2;
    private Game game;
    private Game_Stats team1Game_Stats;
    private Game_Stats team2Game_Stats;
    private GridPane innerGridPane;
    private GridPane outerGridPane;

    private Region t1_team_region;
    private Region t2_team_region;

    private final int NUM_ROWS = 9;
    private final int NUM_COLUMNS = 8;

    public GameLogItem(Game game, Game_Stats[] game_StatsArr, List<Plate_Appearance> plateAppearanceList, List<Inning> inningList, Team[] teams)
    {
        this.game = game;
        this.team1Game_Stats = game_StatsArr[0];
        this.team2Game_Stats = game_StatsArr[1];
        this.plateAppearanceList = plateAppearanceList;
        this.inningList = inningList;
        this.team1 = teams[0];
        this.team2 = teams[1];
        this.innerGridPane = new GridPane();
        this.outerGridPane = new GridPane();
        this.innerGridPane.setGridLinesVisible(true);
        GridPane.setHgrow(this.innerGridPane, Priority.ALWAYS);
        GridPane.setVgrow(this.innerGridPane, Priority.ALWAYS);
        this.outerGridPane.setStyle("-fx-border-color: black; -fx-border-insets: 5; -fx-border-width: 3;");

        createRows();
        createColumns();

        fillLabels();
        fillTeams();

        boolean didTeam2BatInThird = didTeamBatInThird(team2.getId());
        fillRuns(didTeam2BatInThird);
        fillWalks(didTeam2BatInThird);
        fillStrikeouts(didTeam2BatInThird);
        fillSingles(didTeam2BatInThird);
        fillDoubles(didTeam2BatInThird);
        fillTriples(didTeam2BatInThird);
        fillHomeruns(didTeam2BatInThird);
    }

    public GridPane getGridPane()
    {
        GridPane.setConstraints(innerGridPane,1, 1, NUM_COLUMNS, NUM_ROWS);
        outerGridPane.getChildren().add(innerGridPane);
        return outerGridPane;
    }

    private void fillLabels()
    {
        // setConstraints(columnIndex, rowIndex, columnSpan, rowSpan)
        Label gameNumber = new Label("Game #: " + String.valueOf(game.getId()));
        gameNumber.setStyle("-fx-font-weight: bold;");
        GridPane.setConstraints(gameNumber,1,0,2,1);

        Label seasonNumber = new Label("Season: " + String.valueOf(game.getSeason_id()));
        seasonNumber.setStyle("-fx-font-weight: bold;");
        GridPane.setConstraints(seasonNumber, 3, 0, 2, 1);

        Label gameDate = new Label("Date: " + game.getDate_of_game().toString());
        gameDate.setStyle("-fx-font-weight: bold;");
        GridPane.setConstraints(gameDate, 5, 0, 2, 1);

        Label teamLabel = new Label("Team");
        teamLabel.setStyle("-fx-font-style: italic;");
        GridPane.setConstraints(teamLabel, 0, 0, 1, 1);

        Label runsLabel = new Label("Runs");
        runsLabel.setStyle("-fx-font-style: italic;");
        GridPane.setConstraints(runsLabel, 1, 0, 1, 1);

        Label walksLabel = new Label("Walks");
        walksLabel.setStyle("-fx-font-style: italic;");
        GridPane.setConstraints(walksLabel, 2, 0, 1, 1);

        Label strikeoutsLabel = new Label("Strikeouts");
        strikeoutsLabel.setStyle("-fx-font-style: italic;");
        GridPane.setConstraints(strikeoutsLabel, 3, 0, 1, 1);

        Label singlesLabel = new Label("Singles");
        singlesLabel.setStyle("-fx-font-style: italic;");
        GridPane.setConstraints(singlesLabel, 4, 0, 1, 1);

        Label doublesLabel = new Label("Doubles");
        doublesLabel.setStyle("-fx-font-style: italic;");
        GridPane.setConstraints(doublesLabel, 5, 0, 1, 1);

        Label triplesLabel = new Label("Triples");
        triplesLabel.setStyle("-fx-font-style: italic;");
        GridPane.setConstraints(triplesLabel, 6, 0, 1, 1);

        Label homerunsLabel = new Label("Homeruns");
        homerunsLabel.setStyle("-fx-font-style: italic;");
        GridPane.setConstraints(homerunsLabel, 7, 0, 1, 1);

        Label firstInningLabel = new Label("1");
        firstInningLabel.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(firstInningLabel, HPos.CENTER);
        GridPane.setValignment(firstInningLabel, VPos.CENTER);
        GridPane.setConstraints(firstInningLabel, 0, 1, 1, 2);

        Label secondInningLabel = new Label("2");
        secondInningLabel.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(secondInningLabel, HPos.CENTER);
        GridPane.setValignment(secondInningLabel, VPos.CENTER);
        GridPane.setConstraints(secondInningLabel, 0, 3, 1, 2);

        Label thirdInningLabel = new Label("3");
        thirdInningLabel.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(thirdInningLabel, HPos.CENTER);
        GridPane.setValignment(thirdInningLabel, VPos.CENTER);
        GridPane.setConstraints(thirdInningLabel, 0, 5, 1, 2);

        Label totalLabel = new Label("Total");
        totalLabel.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(totalLabel, HPos.CENTER);
        GridPane.setValignment(totalLabel, VPos.CENTER);
        GridPane.setConstraints(totalLabel, 0, 7, 1, 2);

        innerGridPane.getChildren().addAll(teamLabel, runsLabel, walksLabel, strikeoutsLabel, singlesLabel, doublesLabel, triplesLabel, homerunsLabel);
        outerGridPane.getChildren().addAll(gameNumber, seasonNumber, gameDate, firstInningLabel, secondInningLabel, thirdInningLabel, totalLabel);
    }

    private void fillTeams()
    {
        Label t1_team_1 = new Label(team1.getTeam_name());
        GridPane.setHalignment(t1_team_1, HPos.CENTER);
        GridPane.setValignment(t1_team_1, VPos.CENTER);
        GridPane.setConstraints(t1_team_1, 0, 1, 1, 1);
        Label t2_team_1 = new Label(team2.getTeam_name());
        GridPane.setHalignment(t2_team_1, HPos.CENTER);
        GridPane.setValignment(t2_team_1, VPos.CENTER);
        GridPane.setConstraints(t2_team_1, 0, 2, 1, 1);
        Label t1_team_2 = new Label(team1.getTeam_name());
        GridPane.setHalignment(t1_team_2, HPos.CENTER);
        GridPane.setValignment(t1_team_2, VPos.CENTER);
        GridPane.setConstraints(t1_team_2, 0, 3, 1, 1);
        Label t2_team_2 = new Label(team2.getTeam_name());
        GridPane.setHalignment(t2_team_2, HPos.CENTER);
        GridPane.setValignment(t2_team_2, VPos.CENTER);
        GridPane.setConstraints(t2_team_2, 0, 4, 1, 1);
        Label t1_team_3 = new Label(team1.getTeam_name());
        GridPane.setHalignment(t1_team_3, HPos.CENTER);
        GridPane.setValignment(t1_team_3, VPos.CENTER);
        GridPane.setConstraints(t1_team_3, 0, 5, 1, 1);
        Label t2_team_3 = new Label(team2.getTeam_name());
        GridPane.setHalignment(t2_team_3, HPos.CENTER);
        GridPane.setValignment(t2_team_3, VPos.CENTER);
        GridPane.setConstraints(t2_team_3, 0, 6, 1, 1);
        t1_team_region = new Region();
        GridPane.setConstraints(t1_team_region, 0, 7, 1, 1);
        t2_team_region = new Region();
        GridPane.setConstraints(t2_team_region, 0, 8, 1, 1);
        Label t1_team_total = new Label(team1.getTeam_name());
        t1_team_total.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(t1_team_total, HPos.CENTER);
        GridPane.setValignment(t1_team_total, VPos.CENTER);
        GridPane.setConstraints(t1_team_total, 0, 7, 1, 1);
        Label t2_team_total = new Label(team2.getTeam_name());
        t2_team_total.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(t2_team_total, HPos.CENTER);
        GridPane.setValignment(t2_team_total, VPos.CENTER);
        GridPane.setConstraints(t2_team_total, 0, 8, 1, 1);

        innerGridPane.getChildren().addAll(t1_team_1, t2_team_1, t1_team_2, t2_team_2, t1_team_3, t2_team_3, t1_team_region, t2_team_region, t1_team_total, t2_team_total);
    }

    private boolean didTeamBatInThird(int teamId)
    {
        for(Inning inning : inningList)
        {
            if(inning.getInning_number().equals(3))
            {
                for (Plate_Appearance plateAppearance : plateAppearanceList)
                {
                    if (plateAppearance.getInning_id().equals(inning.getId()) && plateAppearance.getBatter_id().equals(teamId))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void fillRuns(boolean didTeam2BatInThird)
    {
        int t1_runs_1 = 0;
        int t2_runs_1 = 0;
        int t1_runs_2 = 0;
        int t2_runs_2 = 0;
        int t1_runs_3 = 0;
        Integer t2_runs_3 = null;
        int t1_runs_total = 0;
        int t2_runs_total = 0;
        for(Inning inning : inningList)
        {
            switch(inning.getInning_number())
            {
                case 1:
                    t1_runs_1 = inning.getTeam1_runs();
                    t2_runs_1 = inning.getTeam2_runs();
                    break;
                case 2:
                    t1_runs_2 = inning.getTeam1_runs();
                    t2_runs_2 = inning.getTeam2_runs();
                    break;
                case 3:
                    t1_runs_3 = inning.getTeam1_runs();
                    if(didTeam2BatInThird) {
                        t2_runs_3 = inning.getTeam2_runs();
                    }
                    break;
            }
        }
        t1_runs_total = team1Game_Stats.getH_runs();
        t2_runs_total = team2Game_Stats.getH_runs();

        Label t1_runs_1_label = new Label(String.valueOf(t1_runs_1));
        GridPane.setHalignment(t1_runs_1_label, HPos.CENTER);
        GridPane.setValignment(t1_runs_1_label, VPos.CENTER);
        GridPane.setConstraints(t1_runs_1_label, 1, 1, 1, 1);

        Label t2_runs_1_label = new Label(String.valueOf(t2_runs_1));
        GridPane.setHalignment(t2_runs_1_label, HPos.CENTER);
        GridPane.setValignment(t2_runs_1_label, VPos.CENTER);
        GridPane.setConstraints(t2_runs_1_label, 1, 2, 1, 1);

        Label t1_runs_2_label = new Label(String.valueOf(t1_runs_2));
        GridPane.setHalignment(t1_runs_2_label, HPos.CENTER);
        GridPane.setValignment(t1_runs_2_label, VPos.CENTER);
        GridPane.setConstraints(t1_runs_2_label, 1, 3, 1, 1);

        Label t2_runs_2_label = new Label(String.valueOf(t2_runs_2));
        GridPane.setHalignment(t2_runs_2_label, HPos.CENTER);
        GridPane.setValignment(t2_runs_2_label, VPos.CENTER);
        GridPane.setConstraints(t2_runs_2_label, 1, 4, 1, 1);

        Label t1_runs_3_label = new Label(String.valueOf(t1_runs_3));
        GridPane.setHalignment(t1_runs_3_label, HPos.CENTER);
        GridPane.setValignment(t1_runs_3_label, VPos.CENTER);
        GridPane.setConstraints(t1_runs_3_label, 1, 5, 1, 1);

        Label t2_runs_3_label;
        if(t2_runs_3 != null)
            t2_runs_3_label = new Label(String.valueOf(t2_runs_3));
        else
            t2_runs_3_label = new Label("");
        GridPane.setHalignment(t2_runs_3_label, HPos.CENTER);
        GridPane.setValignment(t2_runs_3_label, VPos.CENTER);
        GridPane.setConstraints(t2_runs_3_label, 1, 6, 1, 1);

        Label t1_runs_total_label = new Label(String.valueOf(t1_runs_total));
        t1_runs_total_label.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(t1_runs_total_label, HPos.CENTER);
        GridPane.setValignment(t1_runs_total_label, VPos.CENTER);
        GridPane.setConstraints(t1_runs_total_label, 1, 7, 1, 1);

        Label t2_runs_total_label = new Label(String.valueOf(t2_runs_total));
        t2_runs_total_label.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(t2_runs_total_label, HPos.CENTER);
        GridPane.setValignment(t2_runs_total_label, VPos.CENTER);
        GridPane.setConstraints(t2_runs_total_label, 1, 8, 1, 1);

        setResultsColors(t1_runs_total, t2_runs_total);

        innerGridPane.getChildren().addAll(t1_runs_1_label, t1_runs_2_label, t1_runs_3_label, t1_runs_total_label, t2_runs_1_label, t2_runs_2_label, t2_runs_3_label, t2_runs_total_label);
    }

    private void fillWalks(boolean didTeam2BatInThird)
    {
        int t1_walks_1 = 0;
        int t2_walks_1 = 0;
        int t1_walks_2 = 0;
        int t2_walks_2 = 0;
        int t1_walks_3 = 0;
        Integer t2_walks_3 = null;
        int t1_walks_total = 0;
        int t2_walks_total = 0;
        if(didTeam2BatInThird)
            t2_walks_3 = 0;
        for(Inning inning : inningList)
        {
            for(Plate_Appearance plateAppearance : plateAppearanceList)
            {
                if(plateAppearance.getGame_id().equals(game.getId()) && plateAppearance.getInning_id().equals(inning.getId()) && PlateAppearanceResultEnums.RESULT_ID_TO_RESULT_TYPE_MAP.get(plateAppearance.getResult_id()).equals(PlateAppearanceResultEnums.WALK))
                {
                    if(plateAppearance.getBatter_id().equals(team1.getId()))
                    {
                        switch(inning.getInning_number())
                        {
                            case 1:
                                t1_walks_1 ++;
                                break;
                            case 2:
                                t1_walks_2 ++;
                                break;
                            case 3:
                                t1_walks_3 ++;
                                break;
                        }
                    }
                    else if(plateAppearance.getBatter_id().equals(team2.getId()))
                    {
                        switch(inning.getInning_number())
                        {
                            case 1:
                                t2_walks_1 ++;
                                break;
                            case 2:
                                t2_walks_2 ++;
                                break;
                            case 3:
                                t2_walks_3 ++;
                                break;
                        }
                    }
                }
            }
        }
        t1_walks_total = team1Game_Stats.getH_walks();
        t2_walks_total = team2Game_Stats.getH_walks();

        Label t1_walks_1_label = new Label(String.valueOf(t1_walks_1));
        GridPane.setHalignment(t1_walks_1_label, HPos.CENTER);
        GridPane.setValignment(t1_walks_1_label, VPos.CENTER);
        GridPane.setConstraints(t1_walks_1_label, 2, 1, 1, 1);

        Label t2_walks_1_label = new Label(String.valueOf(t2_walks_1));
        GridPane.setHalignment(t2_walks_1_label, HPos.CENTER);
        GridPane.setValignment(t2_walks_1_label, VPos.CENTER);
        GridPane.setConstraints(t2_walks_1_label, 2, 2, 1, 1);

        Label t1_walks_2_label = new Label(String.valueOf(t1_walks_2));
        GridPane.setHalignment(t1_walks_2_label, HPos.CENTER);
        GridPane.setValignment(t1_walks_2_label, VPos.CENTER);
        GridPane.setConstraints(t1_walks_2_label, 2, 3, 1, 1);

        Label t2_walks_2_label = new Label(String.valueOf(t2_walks_2));
        GridPane.setHalignment(t2_walks_2_label, HPos.CENTER);
        GridPane.setValignment(t2_walks_2_label, VPos.CENTER);
        GridPane.setConstraints(t2_walks_2_label, 2, 4, 1, 1);

        Label t1_walks_3_label = new Label(String.valueOf(t1_walks_3));
        GridPane.setHalignment(t1_walks_3_label, HPos.CENTER);
        GridPane.setValignment(t1_walks_3_label, VPos.CENTER);
        GridPane.setConstraints(t1_walks_3_label, 2, 5, 1, 1);

        Label t2_walks_3_label;
        if(t2_walks_3 != null)
            t2_walks_3_label = new Label(String.valueOf(t2_walks_3));
        else
            t2_walks_3_label = new Label("");
        GridPane.setHalignment(t2_walks_3_label, HPos.CENTER);
        GridPane.setValignment(t2_walks_3_label, VPos.CENTER);
        GridPane.setConstraints(t2_walks_3_label, 2, 6, 1, 1);

        Label t1_walks_total_label = new Label(String.valueOf(t1_walks_total));
        t1_walks_total_label.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(t1_walks_total_label, HPos.CENTER);
        GridPane.setValignment(t1_walks_total_label, VPos.CENTER);
        GridPane.setConstraints(t1_walks_total_label, 2, 7, 1, 1);

        Label t2_walks_total_label = new Label(String.valueOf(t2_walks_total));
        t2_walks_total_label.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(t2_walks_total_label, HPos.CENTER);
        GridPane.setValignment(t2_walks_total_label, VPos.CENTER);
        GridPane.setConstraints(t2_walks_total_label, 2, 8, 1, 1);
        
        innerGridPane.getChildren().addAll(t1_walks_1_label, t1_walks_2_label, t1_walks_3_label, t1_walks_total_label, t2_walks_1_label, t2_walks_2_label, t2_walks_3_label, t2_walks_total_label);
    }

    private void fillStrikeouts(boolean didTeam2BatInThird)
    {
        int t1_strikeouts_1 = 0;
        int t2_strikeouts_1 = 0;
        int t1_strikeouts_2 = 0;
        int t2_strikeouts_2 = 0;
        int t1_strikeouts_3 = 0;
        Integer t2_strikeouts_3 = null;
        int t1_strikeouts_total = 0;
        int t2_strikeouts_total = 0;
        if(didTeamBatInThird(team2.getId()))
            t2_strikeouts_3 = 0;
        for(Inning inning : inningList)
        {
            for(Plate_Appearance plateAppearance : plateAppearanceList)
            {
                if(plateAppearance.getGame_id().equals(game.getId()) && plateAppearance.getInning_id().equals(inning.getId()) && PlateAppearanceResultEnums.RESULT_ID_TO_RESULT_TYPE_MAP.get(plateAppearance.getResult_id()).equals(PlateAppearanceResultEnums.STRIKEOUT))
                {
                    if(plateAppearance.getBatter_id().equals(team1.getId()))
                    {
                        switch(inning.getInning_number())
                        {
                            case 1:
                                t1_strikeouts_1 ++;
                                break;
                            case 2:
                                t1_strikeouts_2 ++;
                                break;
                            case 3:
                                t1_strikeouts_3 ++;
                                break;
                        }
                    }
                    else if(plateAppearance.getBatter_id().equals(team2.getId()))
                    {
                        switch(inning.getInning_number())
                        {
                            case 1:
                                t2_strikeouts_1 ++;
                                break;
                            case 2:
                                t2_strikeouts_2 ++;
                                break;
                            case 3:
                                t2_strikeouts_3 ++;
                                break;
                        }
                    }
                }
            }
        }
        t1_strikeouts_total = team1Game_Stats.getH_strikeouts();
        t2_strikeouts_total = team2Game_Stats.getH_strikeouts();

        Label t1_strikeouts_1_label = new Label(String.valueOf(t1_strikeouts_1));
        GridPane.setHalignment(t1_strikeouts_1_label, HPos.CENTER);
        GridPane.setValignment(t1_strikeouts_1_label, VPos.CENTER);
        GridPane.setConstraints(t1_strikeouts_1_label, 3, 1, 1, 1);

        Label t2_strikeouts_1_label = new Label(String.valueOf(t2_strikeouts_1));
        GridPane.setHalignment(t2_strikeouts_1_label, HPos.CENTER);
        GridPane.setValignment(t2_strikeouts_1_label, VPos.CENTER);
        GridPane.setConstraints(t2_strikeouts_1_label, 3, 2, 1, 1);

        Label t1_strikeouts_2_label = new Label(String.valueOf(t1_strikeouts_2));
        GridPane.setHalignment(t1_strikeouts_2_label, HPos.CENTER);
        GridPane.setValignment(t1_strikeouts_2_label, VPos.CENTER);
        GridPane.setConstraints(t1_strikeouts_2_label, 3, 3, 1, 1);

        Label t2_strikeouts_2_label = new Label(String.valueOf(t2_strikeouts_2));
        GridPane.setHalignment(t2_strikeouts_2_label, HPos.CENTER);
        GridPane.setValignment(t2_strikeouts_2_label, VPos.CENTER);
        GridPane.setConstraints(t2_strikeouts_2_label, 3, 4, 1, 1);

        Label t1_strikeouts_3_label = new Label(String.valueOf(t1_strikeouts_3));
        GridPane.setHalignment(t1_strikeouts_3_label, HPos.CENTER);
        GridPane.setValignment(t1_strikeouts_3_label, VPos.CENTER);
        GridPane.setConstraints(t1_strikeouts_3_label, 3, 5, 1, 1);

        Label t2_strikeouts_3_label;
        if(t2_strikeouts_3 != null)
            t2_strikeouts_3_label = new Label(String.valueOf(t2_strikeouts_3));
        else
            t2_strikeouts_3_label = new Label("");
        GridPane.setHalignment(t2_strikeouts_3_label, HPos.CENTER);
        GridPane.setValignment(t2_strikeouts_3_label, VPos.CENTER);
        GridPane.setConstraints(t2_strikeouts_3_label, 3, 6, 1, 1);

        Label t1_strikeouts_total_label = new Label(String.valueOf(t1_strikeouts_total));
        t1_strikeouts_total_label.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(t1_strikeouts_total_label, HPos.CENTER);
        GridPane.setValignment(t1_strikeouts_total_label, VPos.CENTER);
        GridPane.setConstraints(t1_strikeouts_total_label, 3, 7, 1, 1);

        Label t2_strikeouts_total_label = new Label(String.valueOf(t2_strikeouts_total));
        t2_strikeouts_total_label.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(t2_strikeouts_total_label, HPos.CENTER);
        GridPane.setValignment(t2_strikeouts_total_label, VPos.CENTER);
        GridPane.setConstraints(t2_strikeouts_total_label, 3, 8, 1, 1);

        innerGridPane.getChildren().addAll(t1_strikeouts_1_label, t1_strikeouts_2_label, t1_strikeouts_3_label, t1_strikeouts_total_label, t2_strikeouts_1_label, t2_strikeouts_2_label, t2_strikeouts_3_label, t2_strikeouts_total_label);
    }

    private void fillSingles(boolean didTeam2BatInThird)
    {
        int t1_singles_1 = 0;
        int t2_singles_1 = 0;
        int t1_singles_2 = 0;
        int t2_singles_2 = 0;
        int t1_singles_3 = 0;
        Integer t2_singles_3 = null;
        int t1_singles_total = 0;
        int t2_singles_total = 0;
        if(didTeam2BatInThird)
            t2_singles_3 = 0;
        for(Inning inning : inningList)
        {
            for(Plate_Appearance plateAppearance : plateAppearanceList)
            {
                if(plateAppearance.getGame_id().equals(game.getId()) && plateAppearance.getInning_id().equals(inning.getId()) && PlateAppearanceResultEnums.RESULT_ID_TO_RESULT_TYPE_MAP.get(plateAppearance.getResult_id()).equals(PlateAppearanceResultEnums.SINGLE))
                {
                    if(plateAppearance.getBatter_id().equals(team1.getId()))
                    {
                        switch(inning.getInning_number())
                        {
                            case 1:
                                t1_singles_1 ++;
                                break;
                            case 2:
                                t1_singles_2 ++;
                                break;
                            case 3:
                                t1_singles_3 ++;
                                break;
                        }
                    }
                    else if(plateAppearance.getBatter_id().equals(team2.getId()))
                    {
                        switch(inning.getInning_number())
                        {
                            case 1:
                                t2_singles_1 ++;
                                break;
                            case 2:
                                t2_singles_2 ++;
                                break;
                            case 3:
                                t2_singles_3 ++;
                                break;
                        }
                    }
                }
            }
        }
        t1_singles_total = team1Game_Stats.getH_singles();
        t2_singles_total = team2Game_Stats.getH_singles();

        Label t1_singles_1_label = new Label(String.valueOf(t1_singles_1));
        GridPane.setHalignment(t1_singles_1_label, HPos.CENTER);
        GridPane.setValignment(t1_singles_1_label, VPos.CENTER);
        GridPane.setConstraints(t1_singles_1_label, 4, 1, 1, 1);

        Label t2_singles_1_label = new Label(String.valueOf(t2_singles_1));
        GridPane.setHalignment(t2_singles_1_label, HPos.CENTER);
        GridPane.setValignment(t2_singles_1_label, VPos.CENTER);
        GridPane.setConstraints(t2_singles_1_label, 4, 2, 1, 1);

        Label t1_singles_2_label = new Label(String.valueOf(t1_singles_2));
        GridPane.setHalignment(t1_singles_2_label, HPos.CENTER);
        GridPane.setValignment(t1_singles_2_label, VPos.CENTER);
        GridPane.setConstraints(t1_singles_2_label, 4, 3, 1, 1);

        Label t2_singles_2_label = new Label(String.valueOf(t2_singles_2));
        GridPane.setHalignment(t2_singles_2_label, HPos.CENTER);
        GridPane.setValignment(t2_singles_2_label, VPos.CENTER);
        GridPane.setConstraints(t2_singles_2_label, 4, 4, 1, 1);

        Label t1_singles_3_label = new Label(String.valueOf(t1_singles_3));
        GridPane.setHalignment(t1_singles_3_label, HPos.CENTER);
        GridPane.setValignment(t1_singles_3_label, VPos.CENTER);
        GridPane.setConstraints(t1_singles_3_label, 4, 5, 1, 1);

        Label t2_singles_3_label;
        if(t2_singles_3 != null)
            t2_singles_3_label = new Label(String.valueOf(t2_singles_3));
        else
            t2_singles_3_label = new Label("");
        GridPane.setHalignment(t2_singles_3_label, HPos.CENTER);
        GridPane.setValignment(t2_singles_3_label, VPos.CENTER);
        GridPane.setConstraints(t2_singles_3_label, 4, 6, 1, 1);

        Label t1_singles_total_label = new Label(String.valueOf(t1_singles_total));
        t1_singles_total_label.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(t1_singles_total_label, HPos.CENTER);
        GridPane.setValignment(t1_singles_total_label, VPos.CENTER);
        GridPane.setConstraints(t1_singles_total_label, 4, 7, 1, 1);

        Label t2_singles_total_label = new Label(String.valueOf(t2_singles_total));
        t2_singles_total_label.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(t2_singles_total_label, HPos.CENTER);
        GridPane.setValignment(t2_singles_total_label, VPos.CENTER);
        GridPane.setConstraints(t2_singles_total_label, 4, 8, 1, 1);

        innerGridPane.getChildren().addAll(t1_singles_1_label, t1_singles_2_label, t1_singles_3_label, t1_singles_total_label, t2_singles_1_label, t2_singles_2_label, t2_singles_3_label, t2_singles_total_label);
    }

    private void fillDoubles(boolean didTeam2BatInThird)
    {
        int t1_doubles_1 = 0;
        int t2_doubles_1 = 0;
        int t1_doubles_2 = 0;
        int t2_doubles_2 = 0;
        int t1_doubles_3 = 0;
        Integer t2_doubles_3 = null;
        int t1_doubles_total = 0;
        int t2_doubles_total = 0;
        if(didTeam2BatInThird)
            t2_doubles_3 = 0;
        for(Inning inning : inningList)
        {
            for(Plate_Appearance plateAppearance : plateAppearanceList)
            {
                if(plateAppearance.getGame_id().equals(game.getId()) && plateAppearance.getInning_id().equals(inning.getId()) && PlateAppearanceResultEnums.RESULT_ID_TO_RESULT_TYPE_MAP.get(plateAppearance.getResult_id()).equals(PlateAppearanceResultEnums.DOUBLE))
                {
                    if(plateAppearance.getBatter_id().equals(team1.getId()))
                    {
                        switch(inning.getInning_number())
                        {
                            case 1:
                                t1_doubles_1 ++;
                                break;
                            case 2:
                                t1_doubles_2 ++;
                                break;
                            case 3:
                                t1_doubles_3 ++;
                                break;
                        }
                    }
                    else if(plateAppearance.getBatter_id().equals(team2.getId()))
                    {
                        switch(inning.getInning_number())
                        {
                            case 1:
                                t2_doubles_1 ++;
                                break;
                            case 2:
                                t2_doubles_2 ++;
                                break;
                            case 3:
                                t2_doubles_3 ++;
                                break;
                        }
                    }
                }
            }
        }
        t1_doubles_total = team1Game_Stats.getH_doubles();
        t2_doubles_total = team2Game_Stats.getH_doubles();

        Label t1_doubles_1_label = new Label(String.valueOf(t1_doubles_1));
        GridPane.setHalignment(t1_doubles_1_label, HPos.CENTER);
        GridPane.setValignment(t1_doubles_1_label, VPos.CENTER);
        GridPane.setConstraints(t1_doubles_1_label, 5, 1, 1, 1);

        Label t2_doubles_1_label = new Label(String.valueOf(t2_doubles_1));
        GridPane.setHalignment(t2_doubles_1_label, HPos.CENTER);
        GridPane.setValignment(t2_doubles_1_label, VPos.CENTER);
        GridPane.setConstraints(t2_doubles_1_label, 5, 2, 1, 1);

        Label t1_doubles_2_label = new Label(String.valueOf(t1_doubles_2));
        GridPane.setHalignment(t1_doubles_2_label, HPos.CENTER);
        GridPane.setValignment(t1_doubles_2_label, VPos.CENTER);
        GridPane.setConstraints(t1_doubles_2_label, 5, 3, 1, 1);

        Label t2_doubles_2_label = new Label(String.valueOf(t2_doubles_2));
        GridPane.setHalignment(t2_doubles_2_label, HPos.CENTER);
        GridPane.setValignment(t2_doubles_2_label, VPos.CENTER);
        GridPane.setConstraints(t2_doubles_2_label, 5, 4, 1, 1);

        Label t1_doubles_3_label = new Label(String.valueOf(t1_doubles_3));
        GridPane.setHalignment(t1_doubles_3_label, HPos.CENTER);
        GridPane.setValignment(t1_doubles_3_label, VPos.CENTER);
        GridPane.setConstraints(t1_doubles_3_label, 5, 5, 1, 1);

        Label t2_doubles_3_label;
        if(t2_doubles_3 != null)
            t2_doubles_3_label = new Label(String.valueOf(t2_doubles_3));
        else
            t2_doubles_3_label = new Label("");
        GridPane.setHalignment(t2_doubles_3_label, HPos.CENTER);
        GridPane.setValignment(t2_doubles_3_label, VPos.CENTER);
        GridPane.setConstraints(t2_doubles_3_label, 5, 6, 1, 1);

        Label t1_doubles_total_label = new Label(String.valueOf(t1_doubles_total));
        t1_doubles_total_label.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(t1_doubles_total_label, HPos.CENTER);
        GridPane.setValignment(t1_doubles_total_label, VPos.CENTER);
        GridPane.setConstraints(t1_doubles_total_label, 5, 7, 1, 1);

        Label t2_doubles_total_label = new Label(String.valueOf(t2_doubles_total));
        t2_doubles_total_label.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(t2_doubles_total_label, HPos.CENTER);
        GridPane.setValignment(t2_doubles_total_label, VPos.CENTER);
        GridPane.setConstraints(t2_doubles_total_label, 5, 8, 1, 1);

        innerGridPane.getChildren().addAll(t1_doubles_1_label, t1_doubles_2_label, t1_doubles_3_label, t1_doubles_total_label, t2_doubles_1_label, t2_doubles_2_label, t2_doubles_3_label, t2_doubles_total_label);
    }

    private void fillTriples(boolean didTeam2BatInThird)
    {
        int t1_triples_1 = 0;
        int t2_triples_1 = 0;
        int t1_triples_2 = 0;
        int t2_triples_2 = 0;
        int t1_triples_3 = 0;
        Integer t2_triples_3 = null;
        int t1_triples_total = 0;
        int t2_triples_total = 0;
        if(didTeam2BatInThird)
            t2_triples_3 = 0;
        for(Inning inning : inningList)
        {
            for(Plate_Appearance plateAppearance : plateAppearanceList)
            {
                if(plateAppearance.getGame_id().equals(game.getId()) && plateAppearance.getInning_id().equals(inning.getId()) && PlateAppearanceResultEnums.RESULT_ID_TO_RESULT_TYPE_MAP.get(plateAppearance.getResult_id()).equals(PlateAppearanceResultEnums.TRIPLE))
                {
                    if(plateAppearance.getBatter_id().equals(team1.getId()))
                    {
                        switch(inning.getInning_number())
                        {
                            case 1:
                                t1_triples_1 ++;
                                break;
                            case 2:
                                t1_triples_2 ++;
                                break;
                            case 3:
                                t1_triples_3 ++;
                                break;
                        }
                    }
                    else if(plateAppearance.getBatter_id().equals(team2.getId()))
                    {
                        switch(inning.getInning_number())
                        {
                            case 1:
                                t2_triples_1 ++;
                                break;
                            case 2:
                                t2_triples_2 ++;
                                break;
                            case 3:
                                t2_triples_3 ++;
                                break;
                        }
                    }
                }
            }
        }
        t1_triples_total = team1Game_Stats.getH_triples();
        t2_triples_total = team2Game_Stats.getH_triples();

        Label t1_triples_1_label = new Label(String.valueOf(t1_triples_1));
        GridPane.setHalignment(t1_triples_1_label, HPos.CENTER);
        GridPane.setValignment(t1_triples_1_label, VPos.CENTER);
        GridPane.setConstraints(t1_triples_1_label, 6, 1, 1, 1);

        Label t2_triples_1_label = new Label(String.valueOf(t2_triples_1));
        GridPane.setHalignment(t2_triples_1_label, HPos.CENTER);
        GridPane.setValignment(t2_triples_1_label, VPos.CENTER);
        GridPane.setConstraints(t2_triples_1_label, 6, 2, 1, 1);

        Label t1_triples_2_label = new Label(String.valueOf(t1_triples_2));
        GridPane.setHalignment(t1_triples_2_label, HPos.CENTER);
        GridPane.setValignment(t1_triples_2_label, VPos.CENTER);
        GridPane.setConstraints(t1_triples_2_label, 6, 3, 1, 1);

        Label t2_triples_2_label = new Label(String.valueOf(t2_triples_2));
        GridPane.setHalignment(t2_triples_2_label, HPos.CENTER);
        GridPane.setValignment(t2_triples_2_label, VPos.CENTER);
        GridPane.setConstraints(t2_triples_2_label, 6, 4, 1, 1);

        Label t1_triples_3_label = new Label(String.valueOf(t1_triples_3));
        GridPane.setHalignment(t1_triples_3_label, HPos.CENTER);
        GridPane.setValignment(t1_triples_3_label, VPos.CENTER);
        GridPane.setConstraints(t1_triples_3_label, 6, 5, 1, 1);

        Label t2_triples_3_label;
        if(t2_triples_3 != null)
            t2_triples_3_label = new Label(String.valueOf(t2_triples_3));
        else
            t2_triples_3_label = new Label("");
        GridPane.setHalignment(t2_triples_3_label, HPos.CENTER);
        GridPane.setValignment(t2_triples_3_label, VPos.CENTER);
        GridPane.setConstraints(t2_triples_3_label, 6, 6, 1, 1);

        Label t1_triples_total_label = new Label(String.valueOf(t1_triples_total));
        t1_triples_total_label.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(t1_triples_total_label, HPos.CENTER);
        GridPane.setValignment(t1_triples_total_label, VPos.CENTER);
        GridPane.setConstraints(t1_triples_total_label, 6, 7, 1, 1);

        Label t2_triples_total_label = new Label(String.valueOf(t2_triples_total));
        t2_triples_total_label.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(t2_triples_total_label, HPos.CENTER);
        GridPane.setValignment(t2_triples_total_label, VPos.CENTER);
        GridPane.setConstraints(t2_triples_total_label, 6, 8, 1, 1);

        innerGridPane.getChildren().addAll(t1_triples_1_label, t1_triples_2_label, t1_triples_3_label, t1_triples_total_label, t2_triples_1_label, t2_triples_2_label, t2_triples_3_label, t2_triples_total_label);
    }

    private void fillHomeruns(boolean didTeam2BatInThird)
    {
        int t1_homeruns_1 = 0;
        int t2_homeruns_1 = 0;
        int t1_homeruns_2 = 0;
        int t2_homeruns_2 = 0;
        int t1_homeruns_3 = 0;
        Integer t2_homeruns_3 = null;
        int t1_homeruns_total = 0;
        int t2_homeruns_total = 0;
        if(didTeam2BatInThird)
            t2_homeruns_3 = 0;
        for(Inning inning : inningList)
        {
            for(Plate_Appearance plateAppearance : plateAppearanceList)
            {
                if(plateAppearance.getGame_id().equals(game.getId()) && plateAppearance.getInning_id().equals(inning.getId()) && PlateAppearanceResultEnums.RESULT_ID_TO_RESULT_TYPE_MAP.get(plateAppearance.getResult_id()).equals(PlateAppearanceResultEnums.HOMERUN))
                {
                    if(plateAppearance.getBatter_id().equals(team1.getId()))
                    {
                        switch(inning.getInning_number())
                        {
                            case 1:
                                t1_homeruns_1 ++;
                                break;
                            case 2:
                                t1_homeruns_2 ++;
                                break;
                            case 3:
                                t1_homeruns_3 ++;
                                break;
                        }
                    }
                    else if(plateAppearance.getBatter_id().equals(team2.getId()))
                    {
                        switch(inning.getInning_number())
                        {
                            case 1:
                                t2_homeruns_1 ++;
                                break;
                            case 2:
                                t2_homeruns_2 ++;
                                break;
                            case 3:
                                t2_homeruns_3 ++;
                                break;
                        }
                    }
                }
            }
        }
        t1_homeruns_total = team1Game_Stats.getH_homeruns();
        t2_homeruns_total = team2Game_Stats.getH_homeruns();

        Label t1_homeruns_1_label = new Label(String.valueOf(t1_homeruns_1));
        GridPane.setHalignment(t1_homeruns_1_label, HPos.CENTER);
        GridPane.setValignment(t1_homeruns_1_label, VPos.CENTER);
        GridPane.setConstraints(t1_homeruns_1_label, 7, 1, 1, 1);

        Label t2_homeruns_1_label = new Label(String.valueOf(t2_homeruns_1));
        GridPane.setHalignment(t2_homeruns_1_label, HPos.CENTER);
        GridPane.setValignment(t2_homeruns_1_label, VPos.CENTER);
        GridPane.setConstraints(t2_homeruns_1_label, 7, 2, 1, 1);

        Label t1_homeruns_2_label = new Label(String.valueOf(t1_homeruns_2));
        GridPane.setHalignment(t1_homeruns_2_label, HPos.CENTER);
        GridPane.setValignment(t1_homeruns_2_label, VPos.CENTER);
        GridPane.setConstraints(t1_homeruns_2_label, 7, 3, 1, 1);

        Label t2_homeruns_2_label = new Label(String.valueOf(t2_homeruns_2));
        GridPane.setHalignment(t2_homeruns_2_label, HPos.CENTER);
        GridPane.setValignment(t2_homeruns_2_label, VPos.CENTER);
        GridPane.setConstraints(t2_homeruns_2_label, 7, 4, 1, 1);

        Label t1_homeruns_3_label = new Label(String.valueOf(t1_homeruns_3));
        GridPane.setHalignment(t1_homeruns_3_label, HPos.CENTER);
        GridPane.setValignment(t1_homeruns_3_label, VPos.CENTER);
        GridPane.setConstraints(t1_homeruns_3_label, 7, 5, 1, 1);

        Label t2_homeruns_3_label;
        if(t2_homeruns_3 != null)
            t2_homeruns_3_label = new Label(String.valueOf(t2_homeruns_3));
        else
            t2_homeruns_3_label = new Label("");
        GridPane.setHalignment(t2_homeruns_3_label, HPos.CENTER);
        GridPane.setValignment(t2_homeruns_3_label, VPos.CENTER);
        GridPane.setConstraints(t2_homeruns_3_label, 7, 6, 1, 1);

        Label t1_homeruns_total_label = new Label(String.valueOf(t1_homeruns_total));
        t1_homeruns_total_label.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(t1_homeruns_total_label, HPos.CENTER);
        GridPane.setValignment(t1_homeruns_total_label, VPos.CENTER);
        GridPane.setConstraints(t1_homeruns_total_label, 7, 7, 1, 1);

        Label t2_homeruns_total_label = new Label(String.valueOf(t2_homeruns_total));
        t2_homeruns_total_label.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(t2_homeruns_total_label, HPos.CENTER);
        GridPane.setValignment(t2_homeruns_total_label, VPos.CENTER);
        GridPane.setConstraints(t2_homeruns_total_label, 7, 8, 1, 1);

        innerGridPane.getChildren().addAll(t1_homeruns_1_label, t1_homeruns_2_label, t1_homeruns_3_label, t1_homeruns_total_label, t2_homeruns_1_label, t2_homeruns_2_label, t2_homeruns_3_label, t2_homeruns_total_label);
    }

    private void setResultsColors(Integer t1Runs, Integer t2Runs)
    {
        if(t1Runs > t2Runs)
        {
            t1_team_region.setStyle("-fx-background-color: #B7E1CD");
            t2_team_region.setStyle("-fx-background-color: #F4C7C3");
        }
        else if (t2Runs > t1Runs)
        {
            t1_team_region.setStyle("-fx-background-color: #F4C7C3");
            t2_team_region.setStyle("-fx-background-color: #B7E1CD");
        }
        else
        {
            t1_team_region.setStyle("-fx-background-color: #B7E1CD");
            t2_team_region.setStyle("-fx-background-color: #B7E1CD");
        }
    }

    private void createRows()
    {
        for(int i = 0; i < NUM_ROWS + 1; i++)
        {
            RowConstraints rowConstraints = new RowConstraints();
            float ROW_HEIGHT = (1.0f) / ((float) NUM_ROWS+1);
            rowConstraints.setPercentHeight(ROW_HEIGHT * 100);
            rowConstraints.setValignment(VPos.CENTER);
            outerGridPane.getRowConstraints().add(rowConstraints);
        }
        for(int i = 0; i < NUM_ROWS; i++)
        {
            RowConstraints rowConstraints = new RowConstraints();
            float ROW_HEIGHT = (1.0f) / ((float) NUM_ROWS);
            rowConstraints.setPercentHeight(ROW_HEIGHT * 100);
            rowConstraints.setValignment(VPos.CENTER);
            innerGridPane.getRowConstraints().add(rowConstraints);
        }
    }

    private void createColumns()
    {
        for(int i = 0; i < NUM_COLUMNS + 1; i++)
        {
            ColumnConstraints columnConstraints = new ColumnConstraints();
            float COLUMN_WIDTH = (1.0f) / ((float) NUM_COLUMNS+1);
            columnConstraints.setPercentWidth(COLUMN_WIDTH * 100);
            columnConstraints.setHalignment(HPos.CENTER);
            outerGridPane.getColumnConstraints().add(columnConstraints);
        }
        for(int i = 0; i < NUM_COLUMNS; i++)
        {
            ColumnConstraints columnConstraints = new ColumnConstraints();
            float COLUMN_WIDTH = (1.0f) / ((float) NUM_COLUMNS);
            columnConstraints.setPercentWidth(COLUMN_WIDTH * 100);
            columnConstraints.setHalignment(HPos.CENTER);
            innerGridPane.getColumnConstraints().add(columnConstraints);
        }
    }
}
