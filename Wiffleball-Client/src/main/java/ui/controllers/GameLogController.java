package ui.controllers;

import database.DatabaseConnection;
import database.tables.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import ui.GameLogItem;
import ui.Launcher;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class GameLogController implements Initializable {
    @FXML private VBox vbox;
    @FXML private Button back_button;
    @FXML private ScrollPane scrollpane;

    private List<Plate_Appearance> plateAppearanceList;
    private List<Inning> inningList;
    private List<Game> gameList;
    private List<Game_Stats> game_statsList;
    private List<Team> teamList;
    private DatabaseConnection databaseConnection;

    public GameLogController()
    {
        databaseConnection = Launcher.databaseConnection;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            plateAppearanceList = databaseConnection.getPlateAppearanceList();
            inningList = databaseConnection.getInningList();
            gameList = databaseConnection.getGameList();
            game_statsList = databaseConnection.getGameStatsList();
            teamList = databaseConnection.getTeamList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        fill();
    }

    private void fill()
    {
        for(Game game : gameList)
        {
            Team[] teams = getTeamsForGame(game.getId());
            GameLogItem gameLogItem = new GameLogItem(game, getGameStatsForGame(game.getId(), teams), getAtBatsForGame(game.getId()), getInningsForGame(game.getId()), teams);
            vbox.getChildren().add(gameLogItem.getGridPane());
        }
    }

    private Team[] getTeamsForGame(int gameId)
    {
        Team[] teams = new Team[2];
        for(Inning inning : inningList)
        {
            if(inning.getGame_id().equals(gameId))
            {
                for(Team team : teamList)
                {
                    if(team.getId().equals(inning.getTeam1_id()))
                        teams[0] = team;
                    else if(team.getId().equals(inning.getTeam2_id()))
                        teams[1] = team;
                }
            }
        }
        return teams;
    }

    private Game_Stats[] getGameStatsForGame(int gameId, Team[] teams)
    {
        Game_Stats[] game_statsArr = new Game_Stats[2];
        int team1Id = teams[0].getId();
        int team2Id = teams[1].getId();

        for(Game_Stats game_stats : game_statsList)
        {
            if(game_stats.getGame_id().equals(gameId) && game_stats.getTeam_id().equals(team1Id))
                game_statsArr[0] = game_stats;
            else if(game_stats.getGame_id().equals(gameId) && game_stats.getTeam_id().equals(team2Id))
                game_statsArr[1] = game_stats;
        }
        return game_statsArr;
    }

    private List<Plate_Appearance> getAtBatsForGame(int gameId)
    {
        List<Plate_Appearance> atBats = new ArrayList<>();
        for(Plate_Appearance plateAppearance : plateAppearanceList)
        {
            if(plateAppearance.getGame_id().equals(gameId))
                atBats.add(plateAppearance);
        }
        return atBats;
    }

    private List<Inning> getInningsForGame(int gameId)
    {
        List<Inning> innings = new ArrayList<>();
        for(Inning inning : inningList)
        {
            if(inning.getGame_id().equals(gameId))
                innings.add(inning);
        }
        return innings;
    }

    public void backButtonClicked(ActionEvent actionEvent) {
        Stage stage = (Stage) back_button.getScene().getWindow();
        stage.close();
        Launcher.stg.show();
    }
}
