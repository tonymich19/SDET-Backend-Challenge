package models;

import lombok.Data;

@Data
public class PhotoModel {

    private Integer id;
    private Integer sol;
    private CameraModel camera;
    private String img_src;
    private String earth_date;
    private RoverModel rover;



    //    public PhotoModel(Integer id, Integer sol, CameraModel camera, String imgSrc, String earthDate, RoverModel rover){
//        this.id = id;
//        this.sol = sol;
//        this.camera = camera;
//        this.imgSrc = imgSrc;
//        this.earthDate = earthDate;
//        this.rover = rover;
//    }
}
