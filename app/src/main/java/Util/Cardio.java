package Util;

public class Cardio extends Workout {

    private int duration;

    public Cardio(String name, String intensity, String notes, int duration)
    {
        super(name, intensity, notes);
        this.duration = duration;
    }
    public int getDuration() { return duration; }

}
