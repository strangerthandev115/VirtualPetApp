package com.example.virtualpetapp.screens;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import com.example.virtualpetapp.models.Pet;

public class PetNamingScreen {
    private Scene scene;

    public PetNamingScreen(Stage primaryStage, Pet pet) {
        Label nameLabel = new Label("What do you want to name your " + pet.getType() + "?");
        nameLabel.setStyle("-fx-font-size: 20; -fx-font-weight: bold;");

        TextField nameInput = new TextField();
        nameInput.setPromptText("Enter pet name");
        nameInput.setPrefWidth(100);

        Label errorLabel = new Label();
        errorLabel.setStyle("-fx-text-fill: red;");

        Button confirmButton = new Button("Confirm Name");
        confirmButton.setStyle("-fx-font-size: 18;");
        confirmButton.setOnAction(e -> {
            if (nameInput.getText().trim().isEmpty()) {
                errorLabel.setText("Please enter a name and try again.");
            } else {
                pet.setName(nameInput.getText());
                primaryStage.setScene(new PetCareScreen(primaryStage, pet).getScene());
            }
        });

        VBox layout = new VBox(15, nameLabel, nameInput, confirmButton, errorLabel);
        layout.setAlignment(Pos.CENTER);

        this.scene = new Scene(layout, 375, 667);
    }

    public Scene getScene() {
        return scene;
    }
}