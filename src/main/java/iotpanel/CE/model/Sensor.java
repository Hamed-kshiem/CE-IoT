package iotpanel.CE.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 *
 */
@Entity
@Table(name="Sensor")
public class Sensor {


    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="id")
    String id;

    @Column(name="name")
    String name;

    @Column(name="Location")
    String location;

    @Column(name="Type")
    String type;

    @Column(name="active")
    boolean active;

    @Column(name="Release")
    Date release;

    @Column(name="Value")
    String value;

    @Column(name="nfc")
    String nfc;

    public Set<iotpanel.CE.model.SensorValues> getSensorValues() {
        return SensorValues;
    }

    public void setSensorValues(Set<iotpanel.CE.model.SensorValues> sensorValues) {
        SensorValues = sensorValues;
    }

    @OneToMany(mappedBy="sensor")
    @JsonIgnore
    private Set<SensorValues> SensorValues;

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
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getRelease() {
        return release;
    }

    public void setRelease(Date release) {
        this.release = release;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", Location='" + location + '\'' +
                ", Type='" + type + '\'' +
                ", active=" + active +
                ", Release=" + release +
                ", Value='" + value + '\'' +
                ", nfc='" + nfc + '\'' +
                ", SensorValues=" + SensorValues +
                '}';
    }
}
