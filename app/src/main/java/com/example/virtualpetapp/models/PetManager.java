package com.example.virtualpetapp.models;

import java.io.*;
import java.time.LocalDateTime;

public class PetManager {
    private static final String FILE_PATH = "pet_data.dat";
    private static Pet pet;

    public static Pet getPet() {
        return pet;
    }

    public static void setPet(Pet newPet) {
        pet = newPet;
        savePetToFile();
    }

    public static boolean hasPet() {
        return pet != null;
    }

    public static void loadPetFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            pet = (Pet) ois.readObject();
            if (pet != null) {
                pet.decayNeeds(); // Decay needs based on the time elapsed
            }
        } catch (IOException | ClassNotFoundException e) {
            pet = null; // No pet data found or error loading
        }
    }

    public static void savePetToFile() {
        if (pet != null) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
                oos.writeObject(pet);
            } catch (IOException e) {
                //noinspection CallToPrintStackTrace
                e.printStackTrace();
            }
        }
    }
}
