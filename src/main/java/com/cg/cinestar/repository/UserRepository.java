package com.cg.cinestar.repository;

import com.cg.cinestar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Modifying
    @Query("UPDATE User AS u SET u.status.id = 2 WHERE u.id = :id")
    void blockUser(@Param("id") Long id);

    @Modifying
    @Query("UPDATE User AS u SET u.status.id = 1 WHERE u.id = :id")
    void unlockUser(@Param("id") Long id);
}
