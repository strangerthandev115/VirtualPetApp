package com.example.virtualpetapp.models;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Pet implements Serializable {
    private String type;
    private String name;
    private double hungerLevel;
    private double energyLevel;
    private double cleanlinessLevel;
    private LocalDateTime lastUpdated; // Time of the last update

    public Pet(String type) {
        this.type = type;
        this.hungerLevel = 100; // Full initially
        this.energyLevel = 100;
        this.cleanlinessLevel = 100;
        this.lastUpdated = LocalDateTime.now();
    }

    // Getters and setters
    public String getType() { return type; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getHungerLevel() { return hungerLevel; }
    public double getEnergyLevel() { return energyLevel; }
    public double getCleanlinessLevel() { return cleanlinessLevel; }
    public void setLastUpdated(LocalDateTime lastUpdated) { this.lastUpdated = lastUpdated; }
    public LocalDateTime getLastUpdated() { return lastUpdated; }

    public void adjustNeed(String needType, double adjustment) {
        if (needType.equals("hunger")) {
            hungerLevel = Math.min(hungerLevel + adjustment, 1.0);
        } else if (needType.equals("energy")) {
            energyLevel = Math.min(energyLevel + adjustment, 1.0);
        } else if (needType.equals("cleanliness")) {
            cleanlinessLevel = Math.min(cleanlinessLevel + adjustment, 1.0);
        }
    }

    public double calculateHappiness() {
        return (hungerLevel + energyLevel + cleanlinessLevel) / 3;
    }
    public void decayNeeds() {
        LocalDateTime now = LocalDateTime.now();
        long hoursElapsed = java.time.Duration.between(lastUpdated, now).toHours();

        // Decay needs based on hours elapsed
        hungerLevel = Math.max(0, hungerLevel - hoursElapsed * 5); // Hunger decreases by 5 per hour
        energyLevel = Math.max(0, energyLevel - hoursElapsed * 3); // Energy decreases by 3 per hour
        cleanlinessLevel = Math.max(0, cleanlinessLevel - hoursElapsed * 2); // Cleanliness decreases by 2 per hour

        // Update lastUpdated to now
        lastUpdated = now;
    }
}
