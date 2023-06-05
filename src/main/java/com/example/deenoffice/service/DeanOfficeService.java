package com.example.deenoffice.service;

import com.example.deenoffice.dto.DeanOfficeDto;
import com.example.deenoffice.entity.DeanOfficeEntity;
import com.example.deenoffice.entity.GroupEntity;
import com.example.deenoffice.entity.StudentEntity;
import com.example.deenoffice.repo.DeanOfficeRepo;
import com.example.deenoffice.repo.GroupRepo;
import com.example.deenoffice.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeanOfficeService {

    @Autowired
    private DeanOfficeRepo deanOfficeRepo;
    @Autowired
    private GroupRepo groupRepo;
    @Autowired
    private StudentRepo studentRepo;

    public List<DeanOfficeDto> getDeanOffices() {
        return deanOfficeRepo.findAll().stream().map(DeanOfficeDto::toDeanOfficeDto).toList();
    }

    public DeanOfficeDto getDeanOfficeById(Long id) {
        return DeanOfficeDto.toDeanOfficeDto(deanOfficeRepo.findById(id).orElseThrow());
    }

    public String getNumStudentOfDOById(Long id) {
        return "Общее количество студентов деканата равно " + deanOfficeRepo.findAll().stream().map(DeanOfficeEntity::getDoStudents).count();

    }

    public DeanOfficeDto createDeanOffice(DeanOfficeEntity deanOffice) {
        return DeanOfficeDto.toDeanOfficeDto(deanOfficeRepo.save(deanOffice));
    }

    public DeanOfficeDto updateDeanOfficeById(DeanOfficeEntity chDeanOffice, Long id) {
        DeanOfficeEntity deanOffice = deanOfficeRepo.findById(id).orElseThrow();
        if(chDeanOffice.getName() != null) {
            deanOffice.setName(chDeanOffice.getName());
        }
        if(chDeanOffice.getNumber() != null) {
            deanOffice.setName(chDeanOffice.getNumber());
        }
        return DeanOfficeDto.toDeanOfficeDto(deanOfficeRepo.save(deanOffice));
    }

    public String deleteDeanOfficeById(Long id) {
        DeanOfficeEntity deanOffice = deanOfficeRepo.findById(id).orElseThrow();
        deanOfficeRepo.delete(deanOffice);
        return "Удаление деканата с id = " + id + " прошло успешно!";
    }
}
