package com.example.virtualpetapp;

import javafx.application.Application;
import javafx.stage.Stage;
import com.example.virtualpetapp.models.PetManager;
import com.example.virtualpetapp.screens.PetCareScreen;
import com.example.virtualpetapp.screens.PetSelectionScreen;
import com.example.virtualpetapp.screens.WelcomeScreen;

public class MainApp extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        // Load pet data from file at startup
        PetManager.loadPetFromFile();

        this.primaryStage = primaryStage;

        // Show the Welcome Screen initially
        primaryStage.setScene(new WelcomeScreen(primaryStage).getScene());
        primaryStage.setTitle("Pet Palooza");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
