package com.Library.Library_management.controller;

import com.Library.Library_management.dto.MemberRequestDTO;
import com.Library.Library_management.dto.MemberResponseDTO;
import com.Library.Library_management.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController{
    @Autowired
    private MemberService memberService;

    @GetMapping
    public ResponseEntity<List<MemberResponseDTO>> getAllMembers(){
        return ResponseEntity.ok(memberService.getAllMembers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponseDTO> getMemberById(@PathVariable Long id){
        return ResponseEntity.ok(memberService.getMemberById(id));
    }

    @PostMapping
    public ResponseEntity<MemberResponseDTO> addMember(@Valid @RequestBody MemberRequestDTO dto){
        MemberResponseDTO savedMember = memberService.addMember(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMember);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberResponseDTO> updateMember(@PathVariable Long id,@Valid @RequestBody MemberRequestDTO dto){
        return ResponseEntity.ok(memberService.updateMember(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id){
        memberService.deleteMember(id);
        return ResponseEntity.noContent().build();
    }
}