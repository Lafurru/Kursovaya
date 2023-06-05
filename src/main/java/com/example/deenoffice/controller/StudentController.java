package com.example.deenoffice.controller;

import com.example.deenoffice.dto.StudentDto;
import com.example.deenoffice.entity.StudentEntity;
import com.example.deenoffice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public ResponseEntity<List<StudentDto>> getStudents() {
        return ResponseEntity.ok().body(studentService.getStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok().body(studentService.getStudentById(id));
    }

    //сложный метод
    @GetMapping("/age")
    public ResponseEntity<List<StudentDto>> getStudentWithSomeAge(@RequestParam Long age) {
        return ResponseEntity.ok().body(studentService.getStudentWithSomeAge(age));
    }

    @PostMapping("/add/{doId}/{grId}")
    public ResponseEntity<StudentDto> addStudent(@RequestBody StudentEntity student, @PathVariable Long doId, @PathVariable Long grId) {
        return ResponseEntity.ok().body(studentService.addStudent(student, doId, grId));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudentById(@RequestBody StudentEntity student, @PathVariable Long id) {
        return ResponseEntity.ok().body(studentService.updateStudentById(student, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Long id) {
        return ResponseEntity.ok().body(studentService.deleteStudentById(id));
    }

}
