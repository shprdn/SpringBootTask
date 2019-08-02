package com.stackroute.muzix.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//using lombok we donot need to add constructor , toString or any setters and getters
//it helps to reduce the time of writing these codes
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Track {

    //data variables for databases
    // id to be generated on its own
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String name;
    @Column
    private String comment;

    public Track(String name, String comment) {
        this.name = name;
        this.comment = comment;
    }
}
