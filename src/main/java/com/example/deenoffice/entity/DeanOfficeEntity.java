package com.example.deenoffice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "deenoffices")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeanOfficeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "do_name")
    private String name;
    @Column(name = "do_number")
    private String number;

    @OneToMany(cascade = CascadeType.ALL)
    private List<StudentEntity> doStudents = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    private List<GroupEntity> doGroups = new ArrayList<>();
}
