package com.example.deenoffice.dto;

import com.example.deenoffice.entity.StudentEntity;
import lombok.Data;

@Data
public class StudentDto {
    private Long id;
    private String fio;
    private Long age;
    private String info;
    private Long groupId;
    private Long deanOffId;

    public StudentDto(Long id, String fio, Long age, String info, Long groupId, Long deanOffId) {
        this.id = id;
        this.fio = fio;
        this.age = age;
        this.info = info;
        this.groupId = groupId;
        this.deanOffId = deanOffId;
    }

    public static StudentDto toStudentDto(StudentEntity student) {
        return new StudentDto(student.getId(), student.getFio(), student.getAge(), student.getInfo(),
                student.getGroup() == null ? 0L : student.getGroup().getId(), student.getDeanOffice() == null ? 0L : student.getDeanOffice().getId());
    }
}
