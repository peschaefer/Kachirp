package edu.bsu.cs222.GUIControllers;

import edu.bsu.cs222.GUIControllers.GameController;
import edu.bsu.cs222.Question;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SceneController extends Application {

    Question question = new Question("What is my middle name?","Edward",new String[]{"Richard","James","Niall"});
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
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    //VanillaGame and CustomGame should be one scene
    public void switchToCustomGame(javafx.event.ActionEvent event){
        try {
            FXMLLoader loader  = new FXMLLoader(Objects.requireNonNull(getClass().getClassLoader().getResource("CustomGame.fxml")));

            root = loader.load();

            GameController gameController = loader.getController();

            gameController.setQuestion(question);

            gameController.setQuestionText();
            gameController.setAnswerChoices(question.getAnswers());
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
        switchScene(event,"QuestionCreator.fxml");
    }
    //VanillaGame and CustomGame should be one scene
    public void switchToVanillaGame(javafx.event.ActionEvent event) {
        switchScene(event,"VanillaGame.fxml");
    }

    public void switchScene(ActionEvent event, String sceneName){
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource(sceneName)));
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToCategorySelection(javafx.event.ActionEvent event) {
        switchScene(event,"CategorySelect.fxml");
    }
}