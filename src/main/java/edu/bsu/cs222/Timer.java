/*Delete these comments after you read them. They are only for explaining what I did if you have questions

First, run the main statement I have in this class to see how the timer works.
it's a timer ¯\_('-')_/¯

This is the ScheduledExecutorService class. Its only used method call is scheduleAtFixedRate, which does a timer thing :)
        Here is its documentation:
        https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ScheduledExecutorService.html

The Executor class is also imported. It is used to execute a Runnable (a rarely used dataType!)
        Here is its documentation:
        https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/Executors.html

The Runnable uses its own run method
to start the timer and check when the time runs out.

It currently prints to the console every second, but deleting
the print statements will stop that, while having the timer still run in the background.

Delete the main method and the static modifier, then call the runTimer() method in the Console class to see
if they can run in tandem. I hope they can, as I did not have enough time to test it.
 */

package edu.bsu.cs222;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Timer {


    //public static void main(String[] args) {runTimer();}

    public void runTimer(){
        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        final Runnable timerRunner = new Runnable() {
            int timerStart = 30;

            @Override
            public void run() {
                System.out.println(timerStart);
                timerStart--;

                if(timerStart<0){
                    System.out.println("You ran out of time!");
                    scheduler.shutdown();
                }
            }
        };
        scheduler.scheduleAtFixedRate(timerRunner, 0, 1, SECONDS);
    }
}
