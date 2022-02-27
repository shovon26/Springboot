package edu.roomfinal.roomfinal.Controller;

import edu.roomfinal.roomfinal.Model.Room;
import edu.roomfinal.roomfinal.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/rooms")
@Controller
public class RoomController {

    @Autowired
    private RoomService roomService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ModelAndView showAllRoom(){
        ModelAndView allRooms=new ModelAndView("Room.html");
        List<Room> list= roomService.getAllRooms();
        allRooms.addObject("rooms",list);
        allRooms.setViewName("Room");

        return allRooms;
    }

    @RequestMapping(value = "/addNew",method = RequestMethod.GET)
    public ModelAndView addNewRoom(){
        ModelAndView allRooms=new ModelAndView("RoomForm.html");
        Room room=new Room();
        allRooms.addObject("room",room);
        allRooms.setViewName("RoomForm");
        return allRooms;
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ModelAndView saveRoom(@ModelAttribute("room") Room room){
        System.out.println(room.toString());
        roomService.saveOrUpdate(room);
        return new ModelAndView("redirect:/rooms");
    }
    @RequestMapping(value = "/edit/{roomNo}",method = RequestMethod.GET)
    public ModelAndView updateRoom(@PathVariable("roomNo") String roomN){
        ModelAndView mv=new ModelAndView("RoomForm.html");
        Room room=roomService.getRoomById(roomN);
        mv.addObject(room);
        mv.setViewName("RoomForm");
        roomService.removeRoom(roomN);
        return mv;
    }

    @RequestMapping(value = "/remove/{roomNo}",method = RequestMethod.GET)
    public ModelAndView removeRoom(@PathVariable("roomNo") String roomN){
        roomService.removeRoom(roomN);
        return new ModelAndView("redirect:/rooms");
    }


}
