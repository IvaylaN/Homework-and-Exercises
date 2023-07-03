package homework_Lecture9_OOPpractice;

public class Child extends Person{
    public Child(String name, String sex, String religion, String languageSpoken, boolean hasJob, String nationality, long EGN, String countryOfResidence) {
        super(name, sex, religion, languageSpoken, hasJob, nationality, EGN, countryOfResidence);
    }

    public static void goToChildrenClub(){
        System.out.println("I am playing with children");
    }

    @Override
    public void setHasJob(boolean hasJob) {
        try {
            throw new IllegalAccessException("Children do not work");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
