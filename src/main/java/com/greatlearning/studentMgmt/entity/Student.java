package com.greatlearning.studentMgmt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
@Data
public class Student {

    @Id
    @Column(name = "studentID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentID;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "course")
    private String course;

    @Column(name = "country")
    private String country;
}
