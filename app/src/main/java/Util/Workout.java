package Util;

public abstract class Workout {

    protected String name;
    protected String intensity;
    protected String notes;


    public Workout(String name, String intensity, String notes)
    {
        this.name = name;
        this.intensity = intensity;
        this.notes = notes;
    }

    public String getName() { return name; }

    public String getNotes() { return notes; }

    public String getIntensity() { return intensity; }

}
