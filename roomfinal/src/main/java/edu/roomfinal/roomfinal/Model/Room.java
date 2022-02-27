package edu.roomfinal.roomfinal.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tblRoom")
public class Room {

    @Id
    @Column(name = "room_no")
    @NotNull(message = "This field Can Not be NULL")
    private String roomNo;

    @Column(name = "no_of_row")
    private int noOfRow;

    @Column(name = "Bench_per_row")
    private int benchPerRow;

    @Column(name = "bench_capacity")
    private int benchCapacity;

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public int getNoOfRow() {
        return noOfRow;
    }

    public void setNoOfRow(int noOfRow) {
        this.noOfRow = noOfRow;
    }

    public int getBenchPerRow() {
        return benchPerRow;
    }

    public void setBenchPerRow(int benchPerRow) {
        this.benchPerRow = benchPerRow;
    }

    public int getBenchCapacity() {
        return benchCapacity;
    }

    public void setBenchCapacity(int benchCapacity) {
        this.benchCapacity = benchCapacity;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNo='" + roomNo + '\'' +
                ", noOfRow=" + noOfRow +
                ", benchPerRow=" + benchPerRow +
                ", benchCapacity=" + benchCapacity +
                '}';
    }

    public Room()
    {
        roomNo="";
        noOfRow=1;
        benchPerRow=1;
        benchCapacity=1;
    }
}
