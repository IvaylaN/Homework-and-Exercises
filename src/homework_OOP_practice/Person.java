package homework_OOP_practice;

import java.time.LocalDate;

public class Person {
    private String name;
    private String sex;
    private String religion;
    private String languageSpoken;
    private boolean hasJob;
    private String nationality;
    private long EGN;
    private String birthDate;
    private long age;
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
        if (EGNLength == 10) {
            this.EGN = EGN;
        } else {
            throw new RuntimeException("The provided EGN is not valid. The EGN must contain exactly 10 digits.");
        }
    }

    private void setBirthDate(long EGN) {
        String date = Long.toString(EGN).substring(4, 6);
        String month = Long.toString(EGN).substring(2, 4);
        String year = Long.toString(EGN).substring(0, 2);
        this.birthDate = month + "-" + date + "-" + year;
    }

    private void setAge(long age) {
        String birthYear = "19" + Long.toString(EGN).substring(0, 2);
        int currentYear = LocalDate.now().getYear();
        this.age = currentYear - Integer.parseInt(birthYear);
    }

    private void setSex(String sex) {
        try {
            validateSex(sex);
            this.sex = sex;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void validateSex(String sex) throws Exception {
        String male = "Male";
        String female = "Female";

        if (!sex.equalsIgnoreCase(male) && !sex.equalsIgnoreCase(female)) {
            throw new Exception("Please provide a valid value for sex. Valid options are 'male' or 'female'");
        }
    }

    public void setCountryOfResidence(String countryOfResidence) {
        this.countryOfResidence = countryOfResidence;
    }

    public void setHasJob(boolean hasJob) {
        this.hasJob = hasJob;
    }

    public void sayHello() {
        switch (languageSpoken) {
            case "Bulgarian":
                System.out.println("Здравейте");
                break;
            case "Italian":
                System.out.println("Ciao");
                break;
            default:
                System.out.println("Hello");
        }

    }

    public void celebrateEaster() {
        if (religion.equalsIgnoreCase("orthodox") || religion.equalsIgnoreCase("catholic")) {
            System.out.println("I am celebrating Easter");
        } else {
            System.out.println("I am not celebrating Easter");
        }
    }

    public boolean isAdult() {
        switch (countryOfResidence) {
            case "Bulgaria":
            case "Italy":
                return age >= 18;
            case "USA":
                return age >= 21;
            default:
                throw new RuntimeException("We don't have information about country: " + countryOfResidence);
        }
    }

    public boolean canTakeLoan() {
        return hasJob;
    }
}