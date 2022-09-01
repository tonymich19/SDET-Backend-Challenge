package models;

import lombok.Data;

@Data
public class RoverModel {

    private Integer id;
    private String name;
    private String landing_date;
    private String launch_date;
    private String status;
}
