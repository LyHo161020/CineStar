package com.cg.cinestar.repository;

import com.cg.cinestar.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    @Query("SELECT b.rooms FROM Branch AS b WHERE b.id = :id")
    List<Room> findAllRoomByBranchId(@Param("id") Long id);
}
