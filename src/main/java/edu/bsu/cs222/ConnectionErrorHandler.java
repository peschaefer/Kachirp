package edu.bsu.cs222;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class ConnectionErrorHandler {
    public Boolean checkForConnectionError(String triviaData){
        return triviaData.isEmpty();
    }
    public Boolean checkForConnectError(){
        try {
            URL url = new URL("http://www.google.com");
            URLConnection connection = url.openConnection();
            connection.connect();
            return false;
        } catch(Exception e){
            return true;
        }
    }
}
