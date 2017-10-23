/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tone
 */
public class Config {
    private String connectionString;
    private String destination;
    private String dir;
    private String ext;
    private String handler;
    private String location;
    private String remove;
    private String subDirectory;
    private String unit;

    public Config() {
   
    }
    
    public Config(String connectionString, String destination, String dir, String ext, String handler, String location, String remove, String subDirectory, String unit) {
        this.connectionString = connectionString;
        this.destination = destination;
        this.dir = dir;
        this.ext = ext;
        this.handler = handler;
        this.location = location;
        this.remove = remove;
        this.subDirectory = subDirectory;
        this.unit = unit;
    }

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRemove() {
        return remove;
    }

    public void setRemove(String remove) {
        this.remove = remove;
    }

    public String getSubDirectory() {
        return subDirectory;
    }

    public void setSubDirectory(String subDirectory) {
        this.subDirectory = subDirectory;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
    
    
    
}
