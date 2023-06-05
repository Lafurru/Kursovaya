package com.example.deenoffice.dto;

import com.example.deenoffice.entity.DeanOfficeEntity;
import com.example.deenoffice.entity.GroupEntity;
import com.example.deenoffice.entity.StudentEntity;
import lombok.Data;

import java.util.List;

@Data
public class DeanOfficeDto {
    private Long id;
    private String name;
    private String number;
    private List<Long> groupsId;
    private List<Long> studentsId;

    public DeanOfficeDto(Long id, String name, String number, List<Long> groupsId, List<Long> studentsId) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.groupsId = groupsId;
        this.studentsId = studentsId;
    }

    public static DeanOfficeDto toDeanOfficeDto(DeanOfficeEntity deanOffice) {
        return new DeanOfficeDto(deanOffice.getId(), deanOffice.getName(), deanOffice.getNumber(),
                deanOffice.getDoGroups().stream().map(GroupEntity::getId).toList(), deanOffice.getDoStudents().stream().map(StudentEntity::getId).toList());
    }
}
