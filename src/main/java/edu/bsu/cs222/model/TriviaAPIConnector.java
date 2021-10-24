package edu.bsu.cs222.model;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

public class TriviaAPIConnector {

    public String connectToApi(String urlDestination) throws IOException {
        URL userSearch = new URL(urlDestination);
        URLConnection connection = userSearch.openConnection();

        try {
            connection.connect();
        }
        catch (ConnectException | EOFException | UnknownHostException connectionException) {
//            Separate this edu.bsu.cs222.view code out of the edu.bsu.cs222.model code.
//            System.err.println("A network error has occurred");
//            System.exit(3);
            return "";
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String inputLine = in.readLine();
        in.close();
        return inputLine;
    }
}
