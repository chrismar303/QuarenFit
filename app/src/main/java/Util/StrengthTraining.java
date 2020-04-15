package Util;

public class StrengthTraining extends Workout {

    private int weight;
    private int sets;
    private int reps;

    public StrengthTraining(String name, String intensity, String notes, int weight, int sets, int reps) {
        super(name, intensity, notes);
        this.weight = weight;
        this.sets = sets;
        this.reps = reps;
    }

    public int getWeight() { return weight; }

    public int getSets() { return sets; }

    public int getReps() { return reps; }

}
