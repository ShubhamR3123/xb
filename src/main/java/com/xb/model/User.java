package com.xb.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
public class User {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userIdd;
    private String mobileNo;

//    private String firstName;
//
//    private String middleName;
//
//    private String lastName;
//
//    private String vehicleType;
//
//    private String panNum;

}
