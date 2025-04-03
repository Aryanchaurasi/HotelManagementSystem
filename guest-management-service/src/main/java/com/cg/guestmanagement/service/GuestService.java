package com.cg.guestmanagement.service;

import com.cg.guestmanagement.exception.GuestNotFoundException;
import com.cg.guestmanagement.model.Guest;
import com.cg.guestmanagement.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    public Guest addGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    public Guest getGuestById(Long id) {
        return guestRepository.findById(id)
                .orElseThrow(() -> new GuestNotFoundException("Guest not found with id: " + id));
    }

    public Guest updateGuest(Long id, Guest guestDetails) {
        Guest guest = getGuestById(id);
        guest.setName(guestDetails.getName());
        guest.setEmail(guestDetails.getEmail());
        guest.setPhoneNumber(guestDetails.getPhoneNumber());
        // Update other fields as needed
        return guestRepository.save(guest);
    }

    public void deleteGuest(Long id) {
        Guest guest = getGuestById(id);
        guestRepository.delete(guest);
    }

    public Guest getGuestByMemberCode(String memberCode) {
        return guestRepository.findByMemberCode(memberCode)
                .orElseThrow(() -> new GuestNotFoundException("Guest not found with member code: " + memberCode));
    }
}