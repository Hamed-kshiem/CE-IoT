/*
 * Copyright (c) 2020. Hamed  CE
 *
 */

package iotpanel.CE.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
@Entity
@Table(name="lastlogin")
public class LastLogin {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name="id")
    String id;

    @Column(name="name")
    String name;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="user_app")//, nullable=false
    private User user;

}
