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
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="id")
    String id;

    @Column(name="name")
    String name;

    @Column(name="lat")
    Double lat;

    @Column(name="lng")
    Double lng;

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

    public Set<SensorValues> getSensorValues() {
        return SensorValues;
    }

    public void setSensorValues(Set<SensorValues> sensorValues) {
        SensorValues = sensorValues;
    }

    @OneToMany(mappedBy="sensor", fetch = FetchType.EAGER)
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

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", Type='" + type + '\'' +
                ", active=" + active +
                ", Release=" + release +
                ", Value='" + value + '\'' +
                ", nfc='" + nfc + '\'' +
                ", SensorValues=" + SensorValues +
                '}';
    }
}
