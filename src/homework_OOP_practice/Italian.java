package homework_OOP_practice;

public class Italian extends Person{


    public Italian(String name, String sex, String religion, String languageSpoken, boolean hasJob, String nationality, long EGN, String countryOfResidence) {
        super(name, sex, religion, languageSpoken, hasJob, nationality, EGN, countryOfResidence);
    }

    @Override
    public void sayHello() {
        System.out.println("Ciao");
    }
}
