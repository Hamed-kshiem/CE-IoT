/*
 * Copyright (c) 2020. Hamed  CE
 *
 */

package iotpanel.CE.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
@Entity
public class LastLogin {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="id")
    String id;

    @Column(name="name")
    String name;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="user_app")//, nullable=false
    private User user;

}
