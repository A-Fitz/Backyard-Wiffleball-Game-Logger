package ui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import ui.DisplayConstants;
import ui.Launcher;

public class StartController {
    @FXML private Button graphs_button;
    @FXML private Button new_game_button;
    @FXML private Button game_log_button;
    @FXML private Button stats_button;
    @FXML private Button records_button;

    public void newGameButtonClick(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/NewGame.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root, DisplayConstants.NEWGAME_SCREEN_WIDTH, DisplayConstants.NEWGAME_SCREEN_HEIGHT));
            stage.show();
            stage.setTitle("Wiffleball Gamekeeper - New Game");
            Launcher.stg.close();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Issue loading the New Game screen.", ButtonType.OK);
            alert.show();
            e.printStackTrace();
        }
    }

    public void gameLogButtonClick(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GameLog.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root, DisplayConstants.GAMELOG_SCREEN_WIDTH, DisplayConstants.GAMELOG_SCREEN_HEIGHT));
            stage.show();
            stage.setTitle("Wiffleball Gamekeeper - Game Log");
            Launcher.stg.close();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Issue loading the Game Log screen.", ButtonType.OK);
            alert.show();
            e.printStackTrace();
        }
    }

    public void statsButtonClick(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Stats.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root, DisplayConstants.STATS_SCREEN_WIDTH, DisplayConstants.STATS_SCREEN_HEIGHT));
            stage.show();
            stage.setTitle("Wiffleball Gamekeeper - Raw Stats");
            Launcher.stg.close();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Issue loading the Raw Stats screen.", ButtonType.OK);
            alert.show();
            e.printStackTrace();
        }
    }

    public void graphsButtonClick(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Graphs.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root, DisplayConstants.GRAPHS_SCREEN_WIDTH, DisplayConstants.GRAPHS_SCREEN_HEIGHT));
            stage.show();
            stage.setTitle("Wiffleball Gamekeeper - Graphical Stats");
            Launcher.stg.close();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Issue loading the Graphical Stats screen.", ButtonType.OK);
            alert.show();
            e.printStackTrace();
        }
    }

    public void recordsButtonClick(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Records.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root, DisplayConstants.RECORDS_SCREEN_WIDTH, DisplayConstants.RECORDS_SCREEN_HEIGHT));
            stage.show();
            stage.setTitle("Wiffleball Gamekeeper - Records");
            Launcher.stg.close();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Issue loading the Records screen.", ButtonType.OK);
            alert.show();
            e.printStackTrace();
        }
    }
}
