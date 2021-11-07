package edu.bsu.cs222;

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
            return "";
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        StringBuilder triviaData = new StringBuilder();
        while(true) {
            String line = in.readLine();
            if(line == null){
                break;
            }
            triviaData.append(line);
        }
        in.close();
        return triviaData.toString();
    }

    public void checkForValidConnection (String triviaData){
        if (triviaData.isEmpty()) {
            System.err.println("A network error has occurred");
            System.exit(1);
        }
    }
}
