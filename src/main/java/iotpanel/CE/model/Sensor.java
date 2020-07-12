package iotpanel.CE.model;

import javax.persistence.*;
import java.util.Date;

/**
 *
 */
@Entity
@Table(name="Sensor")
public class Sensor {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    String id;

    @Column(name="name")
    String name;

    @Column(name="Location")
    String Location;

    @Column(name="Type")
    String Type;

    @Column(name="active")
    boolean active;

    @Column(name="Release")
    Date Release;

    @Column(name="Value")
    String Value;

    @Column(name="nfc")
    String nfc;

    public String getNfc() {
        return nfc;
    }

    public void setNfc(String nfc) {
        this.nfc = nfc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getRelease() {
        return Release;
    }

    public void setRelease(Date release) {
        Release = release;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }
}
