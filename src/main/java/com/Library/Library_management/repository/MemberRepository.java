package com.Library.Library_management.repository;
import com.Library.Library_management.entity.Member;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long>{
    Optional<Member> findByEmail(String email);   
    boolean existsByEmail(String email); 
}
