package com.example.deenoffice.controller;

import com.example.deenoffice.dto.DeanOfficeDto;
import com.example.deenoffice.entity.DeanOfficeEntity;
import com.example.deenoffice.service.DeanOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deanoffice")
public class DeanOfficeController {

    @Autowired
    private DeanOfficeService deanOfficeService;

    @GetMapping("/")
    public ResponseEntity<List<DeanOfficeDto>> getDeanOffices() {
        return ResponseEntity.ok().body(deanOfficeService.getDeanOffices());
    }

    @GetMapping("/{doId}")
    public ResponseEntity<DeanOfficeDto> getDeanOffices(@PathVariable Long doId) {
        return ResponseEntity.ok().body(deanOfficeService.getDeanOfficeById(doId));
    }

    //вычисляемое поле
    @GetMapping("/numstud/{id}")
    public ResponseEntity<String> getNumStudentOfDOById(@PathVariable Long id) {
        return ResponseEntity.ok().body(deanOfficeService.getNumStudentOfDOById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<DeanOfficeDto> createDeanOffice(@RequestBody DeanOfficeEntity deanOffice) {
        return ResponseEntity.ok().body(deanOfficeService.createDeanOffice(deanOffice));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DeanOfficeDto> updateDeanOfficeById(@RequestBody DeanOfficeEntity deanOffice, @PathVariable Long id) {
        return ResponseEntity.ok().body(deanOfficeService.updateDeanOfficeById(deanOffice, id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDeanOffice(@PathVariable Long id) {
        return ResponseEntity.ok().body(deanOfficeService.deleteDeanOfficeById(id));
    }

}
