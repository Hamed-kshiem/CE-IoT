package iotpanel.CE.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="RFID")
public class RFID {


    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name="id")
    Integer id;

    @Column(name="name")
    String name;

    @Column(name="userid")
    Integer userid;

    @Column(name="insertdate")
    Date insertdate;

    public RFID() {
    }

    @PersistenceConstructor
    public RFID(Integer id,String name, Date insertdate) {
        this.name = name;
        this.insertdate = insertdate;
        this.userid = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getInsertdate() {
        return insertdate;
    }

    public void setInsertdate(Date insertdate) {
        this.insertdate = insertdate;
    }
}
