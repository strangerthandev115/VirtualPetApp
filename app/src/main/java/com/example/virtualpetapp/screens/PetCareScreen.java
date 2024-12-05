package com.example.virtualpetapp.screens;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import com.example.virtualpetapp.models.Pet;

public class PetCareScreen {
    private Scene scene;

    public PetCareScreen(Stage primaryStage, Pet pet) {
        Label petLabel = new Label("Meet " + pet.getName() + ", your new " + pet.getType() + "!");
        petLabel.setStyle("-fx-font-size: 24; -fx-font-weight: bold;");

        Label happinessLabel = new Label("Happiness: " + (int) (pet.calculateHappiness() * 100) + "%");
        happinessLabel.setStyle("-fx-font-size: 18;");

        ProgressBar hungerBar = new ProgressBar(pet.getHungerLevel());
        ProgressBar energyBar = new ProgressBar(pet.getEnergyLevel());
        ProgressBar cleanlinessBar = new ProgressBar(pet.getCleanlinessLevel());

        Button feedButton = new Button("Feed");
        feedButton.setOnAction(e -> {
            pet.adjustNeed("hunger", 0.1);
            hungerBar.setProgress(pet.getHungerLevel());
            updateHappiness(pet, happinessLabel);
        });

        Button playButton = new Button("Play");
        playButton.setOnAction(e -> {
            pet.adjustNeed("energy", 0.1);
            energyBar.setProgress(pet.getEnergyLevel());
            updateHappiness(pet, happinessLabel);
        });

        Button cleanButton = new Button("Clean");
        cleanButton.setOnAction(e -> {
            pet.adjustNeed("cleanliness", 0.1);
            cleanlinessBar.setProgress(pet.getCleanlinessLevel());
            updateHappiness(pet, happinessLabel);
        });

        Button backButton = new Button("Back to Selection");
        backButton.setOnAction(e -> primaryStage.setScene(new PetSelectionScreen(primaryStage).getScene()));

        VBox layout = new VBox(20, petLabel, happinessLabel, hungerBar, feedButton,
                energyBar, playButton, cleanlinessBar, cleanButton, backButton);
        layout.setAlignment(Pos.CENTER);

        this.scene = new Scene(layout, 375, 667);

        startTimeline(pet, hungerBar, energyBar, cleanlinessBar, happinessLabel);
    }

    private void updateHappiness(Pet pet, Label happinessLabel) {
        double happiness = pet.calculateHappiness();
        happinessLabel.setText("Happiness: " + (int) (happiness * 100) + "%");
    }

    private void startTimeline(Pet pet, ProgressBar hungerBar, ProgressBar energyBar, ProgressBar cleanlinessBar, Label happinessLabel) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), e -> {
            pet.adjustNeed("hunger", -0.01);
            pet.adjustNeed("energy", -0.01);
            pet.adjustNeed("cleanliness", -0.01);
            hungerBar.setProgress(pet.getHungerLevel());
            energyBar.setProgress(pet.getEnergyLevel());
            cleanlinessBar.setProgress(pet.getCleanlinessLevel());
            updateHappiness(pet, happinessLabel);
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public Scene getScene() {
        return scene;
    }
}