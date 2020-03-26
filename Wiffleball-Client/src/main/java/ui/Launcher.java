package ui;

import database.DatabaseConnection;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Launcher extends Application {
    public static Stage stg;
    public static DatabaseConnection databaseConnection;

    private Task<Boolean> task = new Task<>() {
        @Override public Boolean call() {
            databaseConnection = DatabaseConnection.getInstance();
            return databaseConnection.operate();
        }
    };

    @Override
    public void start(Stage primaryStage) throws Exception{
        stg = primaryStage;
        Alert loadingDialog = new Alert(Alert.AlertType.INFORMATION);
        loadingDialog.setHeaderText(null);
        loadingDialog.setTitle("Wiffleball Gamekeeper");
        loadingDialog.setContentText("Wiffleball Gamekeeper is loading... Please Wait");
        loadingDialog.getDialogPane().lookupButton(ButtonType.OK).setVisible(false);
        loadingDialog.initStyle(StageStyle.UNDECORATED);

        task.setOnRunning((e) -> loadingDialog.show());
        task.setOnSucceeded((e) -> {
            loadingDialog.hide();
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/Start.fxml"));
                primaryStage.setTitle("Wiffleball Gamekeeper");
                primaryStage.setScene(new Scene(root, DisplayConstants.START_SCREEN_WIDTH, DisplayConstants.START_SCREEN_HEIGHT));
                primaryStage.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        task.setOnFailed((e) -> {
            task.getException().printStackTrace();
            System.exit(0);
        });
        new Thread(task).start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
