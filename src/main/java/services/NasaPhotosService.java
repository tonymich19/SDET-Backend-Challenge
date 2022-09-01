package services;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.SneakyThrows;
import utils.PropertiesManagement;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static  io.restassured.RestAssured.given;

public class NasaPhotosService {

    @SneakyThrows
    public static Response getPhotos(String earthDate, String rover){
        PropertiesManagement props = new PropertiesManagement();
        Map<String, Object > params = new HashMap<>();

        if(earthDate.equals("")){
                params.put("sol", props.getKey("SOL"));
        } else {
            params.put("earth_date", earthDate);
        }
        params.put("api_key", props.getKey("API_KEY"));

        RequestSpecification reqSpec = new RequestSpecBuilder().addParams(params).build().log().all();
        return given()
                .pathParam("rover", rover)
                .header("accept","application/json")
                .header("Content-Type", "application/json")
                .spec(reqSpec)
                .when()
                .get(props.getKey("NASA_PHOTOS_ENDPOINP"));

    }
}
