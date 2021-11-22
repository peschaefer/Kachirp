package edu.bsu.cs222;

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

public class SceneController extends Application {

    public ArrayList<Question> questionArrayList =  new ArrayList<>();
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
            FXMLLoader loader  = new FXMLLoader(Objects.requireNonNull(getClass().getClassLoader().getResource("QuestionPrompt.fxml")));

            root = loader.load();

            questionArrayList.add(new Question("What is my middle name?","Edward",new String[]{"Richard","James","Niall"}));
            questionArrayList.add(new Question("What is my last name?","Schaefer",new String[]{"Richard","James","Niall"}));

            GameController gameController = loader.getController();

            gameController.setQuestionArrayList(questionArrayList);

            //gameController.setQuestionProperties();

            //System.out.println(questionArrayList.get(0).getQuestionText());
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