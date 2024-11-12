package com.example.virtualpetapp;

public class Pet {

    // Base Attributes
    private String name;
    private int hunger;
    private int cleanliness;
    private int energy;
    private int happiness;
    // Constructor
    Pet(String name){
        this.name = name;
    }
    // Getters
    String getName(){
        return name;
    }
    int getHunger(){
        return hunger;
    }
    int getCleanliness(){
        return cleanliness;
    }
    int getEnergy(){
        return energy;
    }
    int getHappiness(){
        return happiness;
    }
    // Setters
    void setName(String name){
       this.name = name;
    }
    void setHunger(int hunger){
        this.hunger = hunger;
    }
    void setCleanliness(int cleanliness){
        this.cleanliness = cleanliness;
    }
    void setEnergy(int energy){
        this.energy = energy;
    }
    void setHappiness(int happiness){
        this.happiness = happiness;
    }
    // Actions?
    
}
