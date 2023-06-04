package homework_OOP_practice;

public class Person {
    private String name;
    private  String sex;
    private String religion;
    private String languageSpoken;
    private boolean hasJob;
    private String nationality;
    private long EGN;
    private String birthDate;
    private byte age;
    private String countryOfResidence;

    public Person(String name, String sex, String religion, String languageSpoken, boolean hasJob, String nationality, long EGN, String countryOfResidence) {
        this.name = name;
        this.sex = sex;
        this.religion = religion;
        this.languageSpoken = languageSpoken;
        this.hasJob = hasJob;
        this.nationality = nationality;
        setEGN(EGN);
        this.countryOfResidence = countryOfResidence;
        setBirthDate(EGN);
    }

    private void setEGN(long EGN) {
        int EGNLength = Long.toString(EGN).length();
        if(EGNLength == 10) {
            this.EGN = EGN;
        }else{
            throw new RuntimeException("The provided EGN is not valid. The EGN must contain exactly 10 digits.");
        }
    }

    private void setBirthDate(long EGN) {
        String date = Long.toString(EGN).substring(4, 6);
        String month = Long.toString(EGN).substring(2, 4);
        String year = Long.toString(EGN).substring(0, 2);
        this.birthDate = month + "-" + date+ "-" + year;
    }

    private void setAge(byte age) {
        String year = "19" + Long.toString(EGN).substring(0, 2);

    }
}
