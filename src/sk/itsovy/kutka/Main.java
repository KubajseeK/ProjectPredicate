package sk.itsovy.kutka;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import org.json.*;
import com.google.gson.*;

public class Main {

    private static List<City> cityList;
    private static final String dataUrl = "http://itsovy.sk:5000/data";

    public static void main(String[] args) throws IOException {

        URL url = new URL(dataUrl);
        JsonParser jsonParser = new JsonParser();

        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();

        /*
         * https://stackoverflow.com/questions/4308554/simplest-way-to-read-json-from-a-url-in-java/4308662
         */

        JsonElement rootElement = jsonParser.parse(new InputStreamReader((InputStream) urlConnection.getContent()));
        JsonObject rootObject = rootElement.getAsJsonObject();
        JsonArray worldXArray = rootObject.get("world_x").getAsJsonArray();

        System.out.println(worldXArray.get(1));



    }
}
