package edu.bsu.cs222;

public class ConnectionErrorHandler {
    public void checkForValidConnection (String triviaData){
        if (triviaData.isEmpty()) {
            System.err.println("A network error has occurred");
            System.exit(1);
        }
    }
}
