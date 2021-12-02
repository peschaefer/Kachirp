package edu.bsu.cs222.GUIControllers;

import edu.bsu.cs222.Question;
//import edu.bsu.cs222.SoundPlayer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Main extends Application {

    private Scene scene;
    private Parent root;

    @Override
    public void start(Stage primaryStage){
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("MainMenu.fxml")));
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void switchToMainMenu(ActionEvent event){
        try {
            FXMLLoader loader  = new FXMLLoader(Objects.requireNonNull(getClass().getClassLoader().getResource("MainMenu.fxml")));

            root = loader.load();

        }
        catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void switchToQuestionPrompt(javafx.event.ActionEvent event,ArrayList<Question> questionArrayList){
        try {
            FXMLLoader loader  = new FXMLLoader(Objects.requireNonNull(getClass().getClassLoader().getResource("QuestionPrompt.fxml")));

            root = loader.load();

            GameController gameController = loader.getController();

            gameController.setMain(this);
            gameController.setQuestionArrayList(questionArrayList);

        }
        catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void switchToQuestionCreator(javafx.event.ActionEvent event) {
        try {
            FXMLLoader loader  = new FXMLLoader(Objects.requireNonNull(getClass().getClassLoader().getResource("QuestionCreator.fxml")));

            root = loader.load();

            QuestionCreatorController controller = loader.getController();

            controller.setMain(this);
        }
        catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToCategorySelection(javafx.event.ActionEvent event) {
        try {
            FXMLLoader loader  = new FXMLLoader(Objects.requireNonNull(getClass().getClassLoader().getResource("CategorySelect.fxml")));

            root = loader.load();

            CategoryController categoryController = loader.getController();

            categoryController.setMain(this);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            categoryController.setScene(scene);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
    }

    public void switchToBankSelection(javafx.event.ActionEvent event) {
        try {
            FXMLLoader loader  = new FXMLLoader(Objects.requireNonNull(getClass().getClassLoader().getResource("BankSelect.fxml")));

            root = loader.load();

            BankSelectController bankSelectController = loader.getController();

            bankSelectController.setMain(this);
            bankSelectController.setBankComboBox();
        }
        catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToEndScreen(ActionEvent event,int score) {
        try {
            FXMLLoader loader  = new FXMLLoader(Objects.requireNonNull(getClass().getClassLoader().getResource("EndScreen.fxml")));

            root = loader.load();

            EndScreenController endScreenController = loader.getController();

            endScreenController.setMain(this);
            endScreenController.setScoreLabel(score);
        }
        catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}