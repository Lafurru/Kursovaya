package com.example.deenoffice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "groupsss")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "gr_name")
    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private DeanOfficeEntity deanOffice;
    @OneToMany(cascade = CascadeType.ALL)
    private List<StudentEntity> grStudents = new ArrayList<>();
}
