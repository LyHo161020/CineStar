package com.cg.cinestar.repository;

import com.cg.cinestar.model.ShowSchedule;
import com.cg.cinestar.model.dto.ShowScheduleDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShowScheduleRepository extends JpaRepository<ShowSchedule, Long> {
    @Query("SELECT NEW com.cg.cinestar.model.dto.ShowScheduleDTO (" +
            "s.id," +
            "s.movie.id," +
            "s.movie.title," +
            "s.room.id," +
            "s.room.name," +
            "s.branch.id," +
            "s.branch.name," +
            "s.showDate," +
            "s.showTimeSlot" +
            ") " +
            "FROM ShowSchedule AS s " +
            "WHERE s.deleted = false ")
    List<ShowScheduleDTO> findAllShowScheduleDTO();

    @Query("SELECT NEW com.cg.cinestar.model.dto.ShowScheduleDTO (" +
            "s.id," +
            "s.movie.id," +
            "s.movie.title," +
            "s.room.id," +
            "s.room.name," +
            "s.branch.id," +
            "s.branch.name," +
            "s.showDate," +
            "s.showTimeSlot" +
            ") " +
            "FROM ShowSchedule AS s WHERE s.id = :id")
    Optional<ShowScheduleDTO> findShowScheduleDTOById(@Param("id") Long id);

    @Modifying
    @Query("UPDATE ShowSchedule AS s SET s.deleted = 1 WHERE s.id= :id")
    void deleteShowScheduleById(@Param("id") Long id);
}
