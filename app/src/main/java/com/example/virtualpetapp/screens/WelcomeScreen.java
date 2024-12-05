package com.example.virtualpetapp.screens;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import com.example.virtualpetapp.models.PetManager;

public class WelcomeScreen {
    final private Stage primaryStage;
    private Scene scene;

    public WelcomeScreen(Stage primaryStage) {
        this.primaryStage = primaryStage;

        // Welcome Screen UI Elements
        Button startButton = new Button("Start Game");
        startButton.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
        startButton.setOnAction(e -> {
            // Proceed to pet selection or pet care screen
            if (PetManager.hasPet()) {
                primaryStage.setScene(new PetCareScreen(primaryStage, PetManager.getPet()).getScene());
            } else {
                primaryStage.setScene(new PetSelectionScreen(primaryStage).getScene());
            }
        });

        VBox layout = new VBox(20, startButton);
        layout.setAlignment(Pos.CENTER);

        scene = new Scene(layout, 375, 667);
    }

    public Scene getScene() {
        return scene;
    }
}
