package edu.bsu.cs222.GUIControllers;

import edu.bsu.cs222.GUIControllers.GameController;
import edu.bsu.cs222.Question;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class Main extends Application {

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
        try {
            FXMLLoader loader  = new FXMLLoader(Objects.requireNonNull(getClass().getClassLoader().getResource("CategorySelect.fxml")));

            root = loader.load();

            CategoryController categoryController = loader.getController();

            categoryController.setMain(this);
        }
        catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToABunchAButtons(){
        //Creating a Button
        ArrayList<Button> buttons = new ArrayList<>();
        Button button = new Button();
        button.setText("Wambo");
        buttons.add(button);
        Button button2 = new Button();
        button2.setText("Wimbo");
        button2.setTranslateX(0);
        button2.setTranslateY(60);
        buttons.add(button2);
        System.out.println(buttons);
        VBox vbox = new VBox();
        for(Button button1 : buttons){
            vbox.getChildren().add(button1);
        }
        //Setting the stage
        Group root = new Group(vbox);
        Scene scene = new Scene(root, 595, 150, Color.CORNFLOWERBLUE);
        Stage stage = new Stage();
        stage.setTitle("Button Example");
        stage.setScene(scene);
        stage.show();
    }
}