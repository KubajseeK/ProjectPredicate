package sk.itsovy.kutka;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class Main {

    private static List<City> cityList;
    private static final String dataUrl = "http://itsovy.sk:5000/data";

    public static void main(String[] args) throws IOException {

        URL url = new URL(dataUrl);
        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();


    }
}
