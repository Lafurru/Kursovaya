package com.example.deenoffice.service;

import com.example.deenoffice.dto.DeanOfficeDto;
import com.example.deenoffice.dto.GroupDto;
import com.example.deenoffice.entity.DeanOfficeEntity;
import com.example.deenoffice.entity.GroupEntity;
import com.example.deenoffice.repo.DeanOfficeRepo;
import com.example.deenoffice.repo.GroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    @Autowired
    private GroupRepo groupRepo;
    @Autowired
    private DeanOfficeRepo deanOfficeRepo;

    public List<GroupDto> getGroups() {
        return groupRepo.findAll().stream().map(GroupDto::toGroupDto).toList();
    }

    public GroupDto getGroupById(Long id) {
        return GroupDto.toGroupDto(groupRepo.findById(id).orElseThrow());
    }

    public GroupDto createGroup(GroupEntity group, Long id) {
        DeanOfficeEntity deanOffice = deanOfficeRepo.findById(id).orElseThrow();
        deanOffice.getDoGroups().add(group);
        group.setDeanOffice(deanOffice);
        return GroupDto.toGroupDto(groupRepo.save(group));
    }

    public GroupDto updateGroupById(GroupEntity chGroup, Long id) {
        GroupEntity group = groupRepo.findById(id).orElseThrow();
        if(chGroup.getName() != null) {
            group.setName(chGroup.getName());
        }
        return GroupDto.toGroupDto(groupRepo.save(group));
    }

    public String deleteGroupById(Long id) {
        GroupEntity group = groupRepo.findById(id).orElseThrow();
        group.getDeanOffice().getDoGroups().remove(group);
        group.getDeanOffice().getDoStudents().removeAll(group.getGrStudents());
        groupRepo.delete(group);
        return "Удаление группы с id = " + id + " прошло успешно!";
    }
}
