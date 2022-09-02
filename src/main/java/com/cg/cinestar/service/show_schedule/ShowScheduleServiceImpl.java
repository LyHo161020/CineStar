package com.cg.cinestar.service.show_schedule;

import com.cg.cinestar.model.*;
import com.cg.cinestar.model.dto.ShowScheduleDTO;
import com.cg.cinestar.repository.BranchRepository;
import com.cg.cinestar.repository.MovieRepository;
import com.cg.cinestar.repository.RoomRepository;
import com.cg.cinestar.repository.ShowScheduleRepository;
import com.cg.cinestar.service.branch.IBranchService;
import com.cg.cinestar.service.movie.IMovieService;
import com.cg.cinestar.service.room.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class ShowScheduleServiceImpl implements IShowScheduleService{
    @Autowired
    private IMovieService movieService;

    @Autowired
    private IRoomService roomService;

    @Autowired IBranchService branchService;

    @Autowired
    private MovieRepository  movieRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private ShowScheduleRepository showScheduleRepository;

    @Override
    public List<ShowSchedule> findAll() {
        return showScheduleRepository.findAll();
    }

    @Override
    public List<ShowScheduleDTO> findAllShowScheduleDTO() {
        return showScheduleRepository.findAllShowScheduleDTO();
    }

    @Override
    public Optional<ShowScheduleDTO> findShowScheduleDTOById(Long id) {
        return showScheduleRepository.findShowScheduleDTOById(id);
    }

    @Override
    public Optional<ShowSchedule> findById(Long id) {
        return showScheduleRepository.findById(id);
    }

    @Override
    public ShowSchedule getById(Long id) {
        return null;
    }

    @Override
    public ShowSchedule save(ShowSchedule showSchedule) {
        return showScheduleRepository.save(showSchedule);
    }

    @Override
    public void remove(Long id) {
        showScheduleRepository.deleteById(id);
    }

    @Override
    public void deleteShowScheduleById(Long id) {
        showScheduleRepository.deleteShowScheduleById(id);
    }

    @Override
    public ShowSchedule setInfoShowSchedule(ShowSchedule showSchedule, ShowScheduleDTO showScheduleDTO) {

        Optional<Movie> movie = movieRepository.findById(showScheduleDTO.getMovieId());
        Optional<Branch> branch = branchRepository.findById(Long.parseLong(showScheduleDTO.getBranchId()));
        Optional<Room> room = roomRepository.findById(Long.parseLong(showScheduleDTO.getRoomId()));

        return new ShowSchedule()
                .setId(showSchedule.getId())
                .setMovie(movie.get())
                .setBranch(branch.get())
                .setRoom(room.get())
                .setShowDate(showSchedule.getShowDate())
                .setShowTimeSlot(showSchedule.getShowTimeSlot());
    }

    @Override
    public BindingResult checkValidShowSchedule(BindingResult bindingResult, ShowScheduleDTO showScheduleDTO) {

        if(movieService.checkValidMovieId(showScheduleDTO.getMovieId())) {
            bindingResult.addError(new FieldError("movie","movie","Thông tên phim không hợp lê!"));
        }

        if(branchService.checkValidBranchId(showScheduleDTO.getBranchId())){
            bindingResult.addError(new FieldError("branch","branch","Thông tin chi nhánh không hợp lê!"));
        }

        if(roomService.checkValidRoomId(showScheduleDTO.getRoomId())){
            bindingResult.addError(new FieldError("room","room","Thông tin phòng không hợp lệ!"));
        }

        return  bindingResult;
    }

    @Override
    public List<ShowScheduleDTO> search(String searchInput) {
        List<ShowScheduleDTO> showScheduleDTOS = findAllShowScheduleDTO();
        List<ShowScheduleDTO> listSearch = new ArrayList<>();

        for(ShowScheduleDTO showScheduleDTO : showScheduleDTOS){
            if(showScheduleDTO.toString().contains(searchInput)){
                listSearch.add(showScheduleDTO);
            }
        }

        return listSearch;
    }


}
