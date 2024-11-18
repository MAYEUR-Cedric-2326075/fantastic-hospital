package fantasticHospital.Disease;

public class Disease {

    private String name;
    private String shortName;
    private final int maxLevel;

    public Disease(String name, String shortName, int maxLevel) {
        this.name = name;
        this.shortName = shortName;
        this.maxLevel = maxLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void createDisease(){
        Disease MDC = new Disease("Maladie débilitante chronique", "MDC", 5);
        Disease FOMO = new Disease("fear of missing out", "FOMO", 5);
        Disease DRS = new Disease("Dépendance aux réseaux sociaux", "DRS", 5);
        Disease PEC = new Disease("Porphyrie érythropoïétique congénitale", "PEC", 5);
        Disease ZPL = new Disease("Zoopathie paraphrénique lycanthropique", "ZPL", 5);
        Disease BG = new Disease("Blight of Gloom", "BG", 5);
    }

}
