package models;

import lombok.Data;

@Data
public class CameraModel {

    private Integer id;
    private String name;
    private Integer rover_id;
    private String full_name;

    //    public CameraModel(Integer id, String names, Integer roverId, String fullName) {
//        this.id = id;
//        this.name = names;
//        this.roverId = roverId;
//        this.fullName = fullName;
//    }
}
