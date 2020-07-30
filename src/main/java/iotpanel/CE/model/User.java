package iotpanel.CE.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "User_app")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Integer id;

    @Column(name = "username")
    String username;

    @Column(name = "firstname")
    String firstname;

    @Column(name = "lastname")
    String lastname;

    @Column(name = "password")
    String password;

    @Column(name = "fingerprint")
    String fingerprint;

    @Column(name = "email")
    @Email
    String email;

    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private Set<LastLogin> lastlogins;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Sensor> subSensor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", password='" + password + '\'' +
                ", fingerprint='" + fingerprint + '\'' +
                ", lastlogins=" + lastlogins +
                ", subSensor=" + subSensor +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public Set<LastLogin> getLastlogins() {
        return lastlogins;
    }

    public void setLastlogins(Set<LastLogin> lastlogins) {
        this.lastlogins = lastlogins;
    }

    public Set<Sensor> getSubSensor() {
        return subSensor;
    }

    public void setSubSensor(Set<Sensor> subSensor) {
        this.subSensor = subSensor;
    }
}