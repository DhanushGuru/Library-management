
package com.Library.Library_management.service;

import java.util.List;
import java.util.stream.Collectors;

import com.Library.Library_management.dto.MemberRequestDTO;
import com.Library.Library_management.dto.MemberResponseDTO;
import com.Library.Library_management.entity.Member;
import com.Library.Library_management.repository.MemberRepository;
import com.Library.Library_management.exception.MemberNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService{
    @Autowired
    public MemberRepository memberRepository;

    private Member toEntity(MemberRequestDTO dto){
        Member member = new Member();
        member.setName(dto.getName());
        member.setEmail(dto.getEmail());
        member.setPhone(dto.getPhone());
        member.setMembershipDate(dto.getMembershipDate());
        member.setStatus(dto.getStatus());
        return member;
    }
    private MemberResponseDTO toResponseDTO(Member member){
        return new MemberResponseDTO(
            member.getId(),
            member.getName(),
            member.getEmail(),
            member.getPhone(),
            member.getMembershipDate(),
            member.getStatus()
        );
    }

    public List<MemberResponseDTO> getAllMembers(){
        return memberRepository.findAll()
        .stream()
        .map(this :: toResponseDTO)
        .collect(Collectors.toList());
    }

    public MemberResponseDTO getMemberById(Long id){
        Member member = memberRepository.findById(id).orElseThrow(() -> new MemberNotFoundException(id));
        return toResponseDTO(member);
    }

    public MemberResponseDTO addMember(MemberRequestDTO dto){
        Member member = toEntity(dto);
        return toResponseDTO(memberRepository.save(member));
    }

    public MemberResponseDTO updateMember(Long id, MemberRequestDTO dto){
        Member existing = memberRepository.findById(id).orElseThrow(() -> new MemberNotFoundException(id));
        existing.setName(dto.getName());
        existing.setEmail(dto.getEmail());
        existing.setPhone(dto.getPhone());
        existing.setMembershipDate(dto.getMembershipDate());
        existing.setStatus(dto.getStatus());
        return toResponseDTO(memberRepository.save(existing));
    }

    public void deleteMember(Long id){
       if(!memberRepository.existsById(id)){
            throw new MemberNotFoundException(id);
       }
       memberRepository.deleteById(id);
    }
}