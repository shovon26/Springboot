package edu.roomfinal.roomfinal.Repository;

import edu.roomfinal.roomfinal.Model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RoomRepository extends JpaRepository<Room,String> {

}
