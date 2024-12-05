package com.example.virtualpetapp.screens;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import com.example.virtualpetapp.models.Pet;

public class PetSelectionScreen {
    private Scene scene;

    public PetSelectionScreen(Stage primaryStage) {
        Label selectLabel = new Label("Choose Your Pet");
        selectLabel.setStyle("-fx-font-size: 24; -fx-font-weight: bold;");

        Button dogButton = new Button("Dog");
        dogButton.setStyle("-fx-font-size: 18;");
        Button catButton = new Button("Cat");
        catButton.setStyle("-fx-font-size: 18;");

        dogButton.setOnAction(e -> {
            Pet pet = new Pet("Dog");
            primaryStage.setScene(new PetNamingScreen(primaryStage, pet).getScene());
        });

        catButton.setOnAction(e -> {
            Pet pet = new Pet("Cat");
            primaryStage.setScene(new PetNamingScreen(primaryStage, pet).getScene());
        });

        VBox layout = new VBox(20, selectLabel, dogButton, catButton);
        layout.setAlignment(Pos.CENTER);

        this.scene = new Scene(layout, 375, 667);
    }

    public Scene getScene() {
        return scene;
    }
}