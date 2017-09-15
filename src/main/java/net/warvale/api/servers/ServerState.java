package net.warvale.api.servers;

public enum ServerState {

    LOADING("LOADING", "Loading"),
    WORLD_GENERATION("WORLD_GENERATION", "World Generation"),
    CONFIG("CONFIG", "Config"),
    SPAWN_GENERATION("SPAWN_GENERATION", "Spawn Generation"),
    PREWHITELIST("PREWHITELIST", "PreWhitelist"),
    LOBBY("LOBBY", "Lobby"),
    JOINABLE("JOINABLE", "Joinable"),
    PRE_START("PRE_START", "PreStart"),
    STARTING("STARTING", "Starting"),
    COUNTDOWN("COUNTDOWN", "Countdown"),
    INGAME("INGAME", "InGame"),
    STARTED("STARTED", "Started"),
    DEATHMATCH("DEATHMATCH", "Deathmatch"),
    ENDED("ENDED", "Ended"),
    RESTARTING("RESTARTING", "Restarting"),
    OFFLINE("OFFLINE", "Offline");

    private String name;
    private String internalName;

    ServerState(String name, String internalName) {
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
