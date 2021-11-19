package edu.bsu.cs222;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SceneController extends Application {
    private Scene scene;
    private Parent root;
    private Stage stage;

    @Override
    public void start(Stage primaryStage){
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("MainMenu.fxml")));
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void switchToCustomGame(javafx.event.ActionEvent event) {
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("CustomGame.fxml")));
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToQuestionCreator(javafx.event.ActionEvent event) {
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("QuestionCreator.fxml")));
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToVanillaGame(javafx.event.ActionEvent event) {
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("VanillaGame.fxml")));
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
