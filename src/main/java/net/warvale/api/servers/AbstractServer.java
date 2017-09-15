package net.warvale.api.servers;

import net.warvale.api.servers.ServerRegion;
import net.warvale.api.servers.ServerState;
import net.warvale.api.servers.ServerType;

import java.util.UUID;

public abstract class AbstractServer {

    private UUID uuid;
    private String name;
    private String address;
    private net.warvale.api.servers.ServerRegion region;
    private net.warvale.api.servers.ServerType type;
    private net.warvale.api.servers.ServerState state;
    private int online;
    private int maxPlayers;

    protected AbstractServer(UUID uuid) {
        this.uuid = uuid;
    }

    //Setters

    /**
     * Sets the uuid of the server
     * @param uuid the server uuid
     */
    public void setUUID(UUID uuid) {
        this.uuid = uuid;
    }

    /**
     * Sets the name of the server
     * @param name the name of the server
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the address of the server
     * @param address the address of the server
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Sets the region of the server
     * @param region the server region
     */
    public void setRegion(net.warvale.api.servers.ServerRegion region) {
        this.region = region;
    }

    /**
     * Sets the server type
     * @param type the server type
     */
    public void setType(net.warvale.api.servers.ServerType type) {
        this.type = type;
    }

    /**
     * Sets the server state
     * @param state the server state
     */
    public void setState(net.warvale.api.servers.ServerState state) {
        this.state = state;
    }

    /**
     * Sets the number of people online on the server
     * @param online the number of people on the server
     */
    public void setOnline(int online) {
        this.online = online;
    }

    /**
     * Sets the max players the server can handle
     * @param maxPlayers the max players the server can handle
     */
    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    //Getters

    /**
     * Gets the uuid of the server
     * @return the uuid of the server
     */
    public UUID getUUID() {
        return this.uuid;
    }

    /**
     * Gets the name of the server
     * @return the name of the server
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the address of the server
     * @return the address of the server
     */
    public String getAddress() {
        return address;
    }

    /**
     * Gets the server region
     * @return the region of the server
     */
    public ServerRegion getRegion() {
        return this.region;
    }

    /**
     * Gets the server type
     * @return the type of server
     */
    public ServerType getType() {
        return this.type;
    }

    /**
     * Gets the state of the server
     * @return the state of the server
     */
    public ServerState getState() {
        return this.state;
    }

    /**
     * The number of players on the server
     * @return the number of players on the server
     */
    public int getOnline() {
        return this.online;
    }

    /**
     * The max number of players the server can support
     * @return the max number of players the server can support
     */
    public int getMaxPlayers() {
        return this.maxPlayers;
    }

}
