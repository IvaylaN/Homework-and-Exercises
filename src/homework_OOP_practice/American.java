package homework_OOP_practice;

public class American extends Person{
    public American(String name, String sex, String religion, String languageSpoken, boolean hasJob, String nationality, long EGN, String countryOfResidence) {
        super(name, sex, religion, languageSpoken, hasJob, nationality, EGN, countryOfResidence);
    }

    public void celebrateSpecialCountryDays(){
        System.out.println("We are celebrating our national day");
    }
}
