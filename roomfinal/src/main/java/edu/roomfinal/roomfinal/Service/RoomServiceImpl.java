package edu.roomfinal.roomfinal.Service;

import edu.roomfinal.roomfinal.Model.Room;
import edu.roomfinal.roomfinal.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {

    @Autowired
    RoomRepository roomRepository;

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Room getRoomById(String roomNo) {
        return roomRepository.getOne(roomNo);
    }

    @Override
    public void saveOrUpdate(Room room) {
     roomRepository.save(room);
    }

    @Override
    public void removeRoom(String roomNo) {
       roomRepository.deleteById(roomNo);
    }
}
