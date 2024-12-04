package fantasticHospital.Creature;


public  abstract class CreatureSexualised extends Creature {

    private boolean gender;
    public CreatureSexualised(String name,boolean gender ,double weight, double height, int age) {
        super(name,weight, height, age);
        this.gender = gender;
        //this.diseasesList = diseasesList;
    }
    public boolean isGender() {return gender;}
    public void setGender(boolean gender) {this.gender = gender;}

}
