package homework_Lecture9_OOPpractice;

public class Bulgarian extends Person{


    public Bulgarian(String name, String sex, String religion, boolean hasJob, long EGN, String countryOfResidence) {
        super(name, sex, religion, "Bulgarian", hasJob, "Bulgarian", EGN, countryOfResidence);
    }

    @Override
    public void sayHello() {
        System.out.println("Здравейте");
    }

    public void playSport(){
        System.out.println("Практикувам спорт");
    }
}
