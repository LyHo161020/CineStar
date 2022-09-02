package com.cg.cinestar.service.room;

import com.cg.cinestar.model.Movie;
import com.cg.cinestar.model.Room;
import com.cg.cinestar.repository.RoomRepository;
import com.cg.cinestar.utils.ValidDateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RoomServiceImpl implements IRoomService {
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public Optional<Room> findById(Long id) {
        return roomRepository.findById(id);
    }

    @Override
    public Room getById(Long id) {
        return null;
    }

    @Override
    public Room save(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public void remove(Long id) {
        roomRepository.deleteById(id);
    }

    @Override
    public List<Room> findAllRoomByBranchId(Long id) {
        return roomRepository.findAllRoomByBranchId(id);
    }

    @Override
    public boolean checkValidRoomId(String idStr) {
        if(!ValidDateUtils.isNumberValid(idStr)){
            return true;
        }else {
            List<Room> rooms = findAll();
            Long id = Long.parseLong(idStr);

            for (Room room : rooms) {
                if(room.getId().equals(id)) {
                    return false;
                }
            }
            return true;
        }

    }
}
