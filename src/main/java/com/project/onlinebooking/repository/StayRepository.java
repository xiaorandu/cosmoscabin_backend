package com.project.onlinebooking.repository;

import com.project.onlinebooking.model.Stay;
import com.project.onlinebooking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//<model class, Id type>
//common methods like save, deleteById, findById are defined in the JpaRepository
public interface StayRepository extends JpaRepository<Stay, Long> {
    List<Stay> findByHost(User user);
    Stay findByIdAndHost(Long id, User host);
    List<Stay> findByIdInAndGuestNumberGreaterThanEqual(List<Long> ids, int guestNumber); //default
}
