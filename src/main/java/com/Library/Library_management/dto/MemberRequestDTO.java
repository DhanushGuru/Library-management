package com.Library.Library_management.dto;

import com.Library.Library_management.entity.Member.MemberStatus;
import java.time.LocalDate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class MemberRequestDTO{
    @NotBlank(message = "Name must not be empty...")
    @Size(min = 1, max = 255, message = "Name must be between 1 to 255 characters")
    private String name;

    @NotBlank(message = "Email must not be empty...")
    @Email(message = "Please provide valid email")
    private String email;

    private String phone;

    @NotNull(message = "Date must not be null")
    private LocalDate membershipDate;

    @NotNull(message = "Status must not be null")
    private MemberStatus status;    

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }

    public LocalDate getMembershipDate(){
        return membershipDate;
    }
    public void setMembershipDate(LocalDate membershipDate){
        this.membershipDate = membershipDate;
    }

    public MemberStatus getStatus(){
        return status;
    }
    public void setStatus(MemberStatus status){
        this.status = status;
    }

}