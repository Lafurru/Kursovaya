package com.example.deenoffice.controller;

import com.example.deenoffice.dto.GroupDto;
import com.example.deenoffice.entity.GroupEntity;
import com.example.deenoffice.service.GroupService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping("/")
    public ResponseEntity<List<GroupDto>> getGroups() {
        return ResponseEntity.ok().body(groupService.getGroups());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupDto> getGroupById(@PathVariable Long id) {
        return ResponseEntity.ok().body(groupService.getGroupById(id));
    }

    @PostMapping("/add/{id}")
    public ResponseEntity<GroupDto> createGroup(@RequestBody GroupEntity group, @PathVariable Long id) {
        return ResponseEntity.ok().body(groupService.createGroup(group, id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<GroupDto> updateGroupById(@RequestBody GroupEntity group, @PathVariable Long id) {
        return ResponseEntity.ok().body(groupService.updateGroupById(group, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGroupById(@PathVariable Long id) {
        return ResponseEntity.ok().body(groupService.deleteGroupById(id));
    }

}
