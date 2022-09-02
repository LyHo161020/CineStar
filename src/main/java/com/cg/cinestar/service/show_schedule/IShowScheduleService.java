package com.cg.cinestar.service.show_schedule;

import com.cg.cinestar.model.ShowSchedule;
import com.cg.cinestar.model.User;
import com.cg.cinestar.model.dto.ShowScheduleDTO;
import com.cg.cinestar.service.IGeneralService;
import org.springframework.data.repository.query.Param;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

public interface IShowScheduleService extends IGeneralService<ShowSchedule> {
    List<ShowScheduleDTO> findAllShowScheduleDTO();

    Optional<ShowScheduleDTO> findShowScheduleDTOById(Long id);

    ShowSchedule setInfoShowSchedule(ShowSchedule showSchedule, ShowScheduleDTO showScheduleDTO);

    BindingResult checkValidShowSchedule(BindingResult bindingResult, ShowScheduleDTO showScheduleDTO);

    void deleteShowScheduleById(Long id);

    List<ShowScheduleDTO> search(String searchInput);
}
