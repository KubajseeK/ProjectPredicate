package sk.itsovy.kutka;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.json.*;
import com.google.gson.*;

public class Main {

    private static List<City> cityList;
    private static final String dataUrl = "http://itsovy.sk:5000/data";

    public static void main(String[] args) throws IOException {

        URL url = new URL(dataUrl);

        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();

        /*
         * https://stackoverflow.com/questions/4308554/simplest-way-to-read-json-from-a-url-in-java/4308662
         */


        JsonObject rootObject = JsonParser.parseReader(new InputStreamReader((InputStream) urlConnection.getContent())).getAsJsonObject();
        JsonArray worldXArray = rootObject.get("world_x").getAsJsonArray();

        if (cityList == null) {
            cityList = new ArrayList<>();
            for (int i = 0; i < worldXArray.size(); i++) {
                City city = new City(

                        ((JsonObject) worldXArray.get(i)).get("pop").getAsInt(),
                        ((JsonObject) worldXArray.get(i)).get("code").getAsString(),
                        ((JsonObject) worldXArray.get(i)).get("district").getAsString(),
                        ((JsonObject) worldXArray.get(i)).get("name").getAsString());

                cityList.add(city);
            }
        }

        PredicateFromNLD<String> predicateFromNLD = new PredicateFromNLD<>();
        Predicate<City> lambdaPredicate = city -> city.getPop() > 100000;

        /*
         * Predicate chaining/composing
         */
        cityList.stream().filter(predicateFromNLD.and(lambdaPredicate)).forEach(System.out::println);

    }
}
