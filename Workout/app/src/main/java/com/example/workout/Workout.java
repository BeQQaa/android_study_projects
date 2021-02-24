package com.example.workout;

public class Workout {
    private String name;
    private String description;

    public static final Workout[] WORKOUTS = {
            new Workout("Limbo", "Limb 10 times"),
            new Workout("Jumping", "Jumo 100 times"),
            new Workout("Pop up", "Popup at least 5 minutes")
    };

    public Workout(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
