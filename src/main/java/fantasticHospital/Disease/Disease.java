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

}
