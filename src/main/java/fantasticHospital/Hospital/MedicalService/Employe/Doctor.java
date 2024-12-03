package fantasticHospital.Hospital.MedicalService.Employe;

public class Doctor {

    private String name;
    private boolean gender;
    private int age;

    public Doctor(String name, boolean gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void examineMedicalService() {

    }
    public static void healCreaturesInMedicalService() {

    }
    public static void reviewBudgetOfMedicalService() {

    }
    public static void transferCreatureToAnotherMedicalService() {

    }
}
