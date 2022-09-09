package com.cg.cinestar.repository;

import com.cg.cinestar.model.ShowSchedule;
import com.cg.cinestar.model.dto.ShowScheduleDTO;
import com.cg.cinestar.model.dto.ShowScheduleDetailsDTO;
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

    @Query("SELECT NEW com.cg.cinestar.model.dto.ShowScheduleDetailsDTO (" +
            "s.id, " +
            "s.movie, " +
            "s.room.id, " +
            "s.room.name, " +
            "s.branch.id, " +
            "s.branch.name, " +
            "s.branch.address, " +
            "s.showDate, " +
            "s.showTimeSlot " +
            ") " +
            "FROM ShowSchedule AS s " +
            "WHERE s.deleted = false " +
            "AND s.branch.id = :branchId " +
            "GROUP BY s.movie "

    )
    List<ShowScheduleDetailsDTO> findAllShowScheduleDetailsDTOByBranchId(Long branchId);


    @Query("SELECT NEW com.cg.cinestar.model.dto.ShowScheduleDetailsDTO (" +
            "s.id, " +
            "s.movie, " +
            "s.showDate " +
            ") " +
            "FROM ShowSchedule AS s " +
            "WHERE s.deleted = false " +
            "AND s.branch.id = :branchId " +
            "AND s.movie.id = :movieId " +
            "GROUP BY s.movie, s.showDate "

    )
    List<ShowScheduleDetailsDTO> findByBranchAndMovieGroupByMovieAndShowDate(Long branchId, String movieId);


    @Query("SELECT NEW com.cg.cinestar.model.dto.ShowScheduleDetailsDTO (" +
            "s.id, " +
            "s.movie, " +
            "s.room.id, " +
            "s.showDate, " +
            "s.showTimeSlot " +
            ") " +
            "FROM ShowSchedule AS s " +
            "WHERE s.deleted = false " +
            "AND s.branch.id = :branchId " +
            "AND s.movie.id = :movieId " +
            "AND s.showDate = :showDate " +
            "GROUP BY s.movie, s.showDate, s.showTimeSlot "

    )
    List<ShowScheduleDetailsDTO> findSCGroupByMovieAndShowDateAndShowTimeSlot(Long branchId, String movieId, String showDate);

    @Query("SELECT NEW com.cg.cinestar.model.dto.ShowScheduleDetailsDTO (" +
            "s.id, " +
            "s.movie, " +
            "s.room.id, " +
            "s.showDate, " +
            "s.showTimeSlot " +
            ") " +
            "FROM ShowSchedule AS s " +
            "WHERE s.deleted = false " +
            "AND s.room.id = :roomId " +
            "AND s.showDate = :showDate " +
            "ORDER BY s.showTimeSlot"

    )
    List<ShowScheduleDetailsDTO> findALlScheduleByRoomAndShowDate(Long roomId, String showDate);


}
