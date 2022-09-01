import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.PhotoModel;
import models.PhotosModel;
import org.junit.jupiter.api.*;
import services.NasaPhotosService;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import utils.Utils;

import java.util.*;
import java.util.stream.Collectors;

public class NasaPhotoTest {

    private static String earthDate="";
    private static PhotosModel photos = new PhotosModel();
    private static List<PhotoModel> solPhotoList = new ArrayList<>();
    private static List<PhotoModel> earthDatePhotoList = new ArrayList<>();

    @BeforeAll
    public static void beforeTests(){
        Response resp = NasaPhotosService.getPhotos(earthDate,"Curiosity");
        assertThat(resp.statusCode(), is(200));
        photos = Utils.photoDeserializer(resp);
        earthDate = photos.getPhotos().get(0).getEarth_date();
    }

    @Test
    @Order(1)
    @DisplayName("Retrieve the first 10 Mars photos made by \"Curiosity\" on 1000 Martian sol.")
    public void scenario1(){
        solPhotoList = new ArrayList<>(photos.getPhotos()).stream().limit(10).collect(Collectors.toList());
        assertThat(solPhotoList.stream().allMatch(p -> p.getSol().equals(1000)),is(true));

    }

    @Test()
    @Order(2)
    @DisplayName("Retrieve the first 10 Mars photos made by \"Curiosity\" on Earth date equal to 1000 Martian sol.")
    public void scenario2(){
        System.out.println(solPhotoList.toString());
        Response resp = NasaPhotosService.getPhotos(earthDate, "Curiosity");
        photos = Utils.photoDeserializer(resp);
        earthDatePhotoList = new ArrayList<>(photos.getPhotos().stream().limit(10).collect(Collectors.toList()));
        assertThat(earthDatePhotoList.stream().allMatch(p -> p.getEarth_date().equals(earthDate)), is(true));
        System.out.println(earthDate);
    }

    @Test()
    @Order(3)
    @DisplayName("Retrieve and compare the first 10 Mars photos made by \"Curiosity\" on 1000 sol and on Earth date equal to 1000 Martian sol.")
    public void scenario3(){
        System.out.println(solPhotoList.toString());
        System.out.println(earthDatePhotoList.toString());
        Assertions.assertEquals(solPhotoList,earthDatePhotoList);
    }

    @Test
    @Order(4)
    @DisplayName("Validate that the amounts of pictures that each \"Curiosity\" camera took on 1000 Mars sol is not greater than 10 times the amount taken by other cameras on the same date.\n")
    public void scenario4(){
        Map<String, Integer> map = new HashMap<>();
        List<String> cameras = solPhotoList.stream().map(x -> x.getCamera().getName()).distinct().collect(Collectors.toList());
        for (String camera : cameras){
            map.put(camera, 0);
        }
        for (PhotoModel p : solPhotoList) {
            map.put(p.getCamera().getName(), map.get(p.getCamera().getName()) +1);
        }
        List<Integer> photosByCameraCount = new ArrayList<>(map.values());

        int greaterPhotosAmount = Collections.max(photosByCameraCount);
        assertThat(photosByCameraCount.stream().allMatch(c -> c < greaterPhotosAmount * 10 ),is(true));
    }

}
