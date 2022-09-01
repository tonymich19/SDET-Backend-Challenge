package utils;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.PhotoModel;
import models.PhotosModel;

import java.lang.reflect.Type;

public class Utils {

    public static PhotosModel photoDeserializer(Response resp) {
        JsonPath jsonPath = JsonPath.from(resp.asString());
        return jsonPath.getObject("", PhotosModel.class);
    }
}
