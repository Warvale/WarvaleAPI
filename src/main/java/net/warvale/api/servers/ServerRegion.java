package net.warvale.api.servers;

public enum ServerRegion {

    NA("NA", "na"),
    EU("EU", "eu"),
    AU("AU", "au"),
    SA("SA", "sa"),
    AS("AS", "as"),
    DE("DE", "de"),
    BE("BE", "be"),
    UNKNOWN("UNKNOWN", "unknown");

    private String name;
    private String internalName;

    ServerRegion(String name, String internalName) {
        this.name = name;
        this.internalName = internalName;
    }

    public String getName() {
        return this.name;
    }

    public String getInternalName() {
        return this.internalName;
    }

}
