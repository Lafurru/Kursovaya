package com.example.deenoffice.service;

import com.example.deenoffice.dto.StudentDto;
import com.example.deenoffice.entity.DeanOfficeEntity;
import com.example.deenoffice.entity.GroupEntity;
import com.example.deenoffice.entity.StudentEntity;
import com.example.deenoffice.repo.DeanOfficeRepo;
import com.example.deenoffice.repo.GroupRepo;
import com.example.deenoffice.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private DeanOfficeRepo deanOfficeRepo;
    @Autowired
    private GroupRepo groupRepo;

    public List<StudentDto> getStudents() {
        return studentRepo.findAll().stream().map(StudentDto::toStudentDto).toList();
    }

    public StudentDto getStudentById(Long id) {
        return StudentDto.toStudentDto(studentRepo.findById(id).orElseThrow());
    }

    public List<StudentDto> getStudentWithSomeAge(Long age) {
        return studentRepo.findAll().stream().filter(student -> student.getAge() >= age).map(StudentDto::toStudentDto).toList();
    }

    public StudentDto addStudent(StudentEntity student, Long doId, Long grId) {
        DeanOfficeEntity deanOffice = deanOfficeRepo.findById(doId).orElseThrow();
        GroupEntity group = groupRepo.findById(grId).orElseThrow();

        deanOffice.getDoStudents().add(student);
        group.getGrStudents().add(student);

        student.setGroup(group);
        student.setDeanOffice(deanOffice);

        return StudentDto.toStudentDto(studentRepo.save(student));
    }

    public StudentDto updateStudentById(StudentEntity chStudent, Long id) {
        StudentEntity student = studentRepo.findById(id).orElseThrow();
        if(chStudent.getFio() != null) {
            student.setFio(chStudent.getFio());
        }
        if(chStudent.getAge() != null) {
            student.setAge(chStudent.getAge());
        }
        if(chStudent.getInfo() != null) {
            student.setInfo(chStudent.getInfo());
        }
        return StudentDto.toStudentDto(studentRepo.save(student));
    }

    public String deleteStudentById(Long id) {
        StudentEntity student = studentRepo.findById(id).orElseThrow();

        student.getGroup().getGrStudents().remove(student);
        student.getDeanOffice().getDoStudents().remove(student);

        studentRepo.delete(student);
        return "Удаление студента с id = " + id + " прошло успешно!";
    }
}