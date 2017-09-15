package net.warvale.api.servers;

public enum ServerType {

    LOBBY("Lobby", "lobby"),
    CURSE("CURSE", "curse"),
    DOOM("FFA", "doom"),
    OTIQ("OTIQ", "otiq"),
    UHC("UHC", "uhc"),
    SPEEDUHC("SpeedUHC", "speeduhc"),
    PROXY("PROXY", "proxy"),
    UNKNOWN("UNKNOWN", "unknown");

    private String name;
    private String internalName;

    ServerType(String name, String internalName) {
        this.name = name;
        this.internalName = internalName;
    }

    public String getName() {
        return name;
    }

    public String getInternalName() {
        return internalName;
    }

}
