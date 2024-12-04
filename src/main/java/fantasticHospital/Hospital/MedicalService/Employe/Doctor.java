package fantasticHospital.Hospital.MedicalService.Employe;

import fantasticHospital.Disease.TypeOfPatient.CreatureSickness;
import fantasticHospital.Hospital.Behavior.healer;
import fantasticHospital.Tools.Randomizer;

public class Doctor implements healer<CreatureSickness> , Randomizer {

    private String name;
    private boolean gender;
    private int age;
    @Override
    public String toString() {
        return "Doctor{name='" + name + "', gender=" + (gender ? "Male" : "Female") + ", age=" + age + "}";
    }


    public Doctor(String name, boolean gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public boolean getGender() {
        return gender;
    }
    protected void setGender(boolean gender) {
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
    protected Doctor() {
        this.name = generateRandomName(generateRandomNumber(3, 10));
        this.gender = generateRandomBoolean();
        this.age = generateRandomNumber(25, 60);
    }


}