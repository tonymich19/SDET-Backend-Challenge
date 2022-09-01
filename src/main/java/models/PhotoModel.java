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

}
