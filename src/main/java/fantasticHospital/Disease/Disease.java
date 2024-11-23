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

    public String getShortName() {
        return shortName;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

}
