package com.Library.Library_management.dto;

import java.time.LocalDate;

import com.Library.Library_management.entity.Member.MemberStatus;

public class MemberResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private LocalDate membershipDate;
    private MemberStatus status;

    public MemberResponseDTO(Long id, String name, String email, String phone, LocalDate membershipDate, MemberStatus status){
        this.id = id;
        this.name = name;
        this.email = email; 
        this.phone = phone;
        this.membershipDate = membershipDate;
        this.status = status;
    }
    public Long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getPhone(){
        return phone;
    }
    public LocalDate getMembershipDate(){
        return membershipDate;
    }
    public MemberStatus getStatus(){
        return status;
    }
}
