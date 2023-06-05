package com.example.deenoffice.dto;

import com.example.deenoffice.entity.GroupEntity;
import com.example.deenoffice.entity.StudentEntity;
import lombok.Data;

import java.util.List;

@Data
public class GroupDto {
    private Long id;
    private String name;
    private Long deanOfficeId;
    private List<Long> grStudentsId;

    public GroupDto(Long id, String name, Long deanOfficeId, List<Long> grStudentsId) {
        this.id = id;
        this.name = name;
        this.deanOfficeId = deanOfficeId;
        this.grStudentsId = grStudentsId;
    }

    public static GroupDto toGroupDto(GroupEntity group) {
        return new GroupDto(group.getId(), group.getName(), group.getDeanOffice() == null ? 0L : group.getDeanOffice().getId(),
                group.getGrStudents().stream().map(StudentEntity::getId).toList());
    }
}
