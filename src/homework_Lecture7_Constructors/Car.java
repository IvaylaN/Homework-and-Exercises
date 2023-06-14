package homework_Lecture7_Constructors;

public class Car {
    private String name;
    private String color;
    private int releaseYear;
    private int horsePower;
    private boolean secondHand;

    public Car(String name, String color, int releaseYear, int horsePower, boolean secondHand) {
        this.name = name;
        this.color = color;
        this.releaseYear = releaseYear;
        this.horsePower = horsePower;
        this.secondHand = secondHand;
    }

    public Car(String name, String color, boolean secondHand) {
        this.name = name;
        this.color = color;
        this.horsePower = - 1;
        this.releaseYear = -1;
        this.secondHand = secondHand;
    }

    public Car(String name, String color, int releaseYear, int horsePower) {
        this(name, color, releaseYear, horsePower, false);
    }

    public Car(String name, int releaseYear, int horsePower, boolean secondHand) {
        this(name, "N/A", releaseYear, horsePower, secondHand);
    }

    public Car() {
    }
}
