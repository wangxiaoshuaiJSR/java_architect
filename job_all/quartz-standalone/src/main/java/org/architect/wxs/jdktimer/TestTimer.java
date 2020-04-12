package org.architect.wxs.jdktimer;

import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new TestTimerTask();
        timer.schedule(task, 5000L, 1000L);
    }
}