package com.cg.guestmanagement.repository;



import com.cg.guestmanagement.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GuestRepository extends JpaRepository<Guest, Long> {
    //Guest findByMemberCode(String memberCode);
    Optional<Guest> findByMemberCode(String memberCode);
}