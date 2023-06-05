package com.example.deenoffice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "studentsss")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "st_fio")
    private String fio;
    @Column(name = "st_age")
    private Long age;
    @Column(name = "st_info")
    private String info;


    @ManyToOne(cascade = CascadeType.PERSIST)
    private GroupEntity group;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private DeanOfficeEntity deanOffice;
}
