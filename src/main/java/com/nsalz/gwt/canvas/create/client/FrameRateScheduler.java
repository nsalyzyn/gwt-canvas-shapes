package com.nsalz.gwt.canvas.create.client;

import java.util.LinkedHashSet;
import java.util.Set;

import com.google.gwt.core.client.Duration;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Timer;

public class FrameRateScheduler
{
    public static final int DEFAULT_FRAME_RATE = 30;
    private static final int MILLIS_PER_SECOND = 1000;
    private static final int FRAMES_UNTIL_CALCULATE_FRAME_RATE = 10;

    private static FrameRateScheduler scheduler = null;

    public static FrameRateScheduler get()
    {
        if (scheduler == null) {
            scheduler = new FrameRateScheduler();
        }
        return scheduler;
    }

    private final Timer timer;
    private final LinkedHashSet<Command> commands;
    private boolean timerRunning = false;
    private int targetTiming;
    private double startTime = 0.0;
    private int frameCount = 0;
    private int currentFrameTiming = 0;

    private FrameRateScheduler()
    {
        timer = new Timer(){
            @Override
            public void run()
            {
                doNextFrame();
            }
        };
        commands = new LinkedHashSet<Command>();
        setFrameRate(DEFAULT_FRAME_RATE);
    }

    public void addToNextFrame(Command command)
    {
        if (timerRunning) {
            commands.add(command);
        } else {
            // Do a new frame right now and wait for the next frame to do
            // anything

            startTime = Duration.currentTimeMillis();
            frameCount = 0;
            timer.scheduleRepeating(targetTiming);
            timerRunning = true;
            command.execute();
        }
    }

    public void setFrameRate(int frameRate)
    {
        if (frameRate <= 0)
            return;
        targetTiming = MILLIS_PER_SECOND / frameRate;
    }

    public int getTargetFrameRate()
    {
        return MILLIS_PER_SECOND / targetTiming;
    }

    public int getCurrentFrameRate()
    {
        if (currentFrameTiming <= 0)
            return 0;
        return MILLIS_PER_SECOND * FRAMES_UNTIL_CALCULATE_FRAME_RATE / currentFrameTiming;
    }

    @SuppressWarnings("unchecked")
    private void doNextFrame()
    {
        if (commands.isEmpty()) {
            timer.cancel();
            timerRunning = false;
        } else {
            if (++frameCount > FRAMES_UNTIL_CALCULATE_FRAME_RATE) {
                double endTime = Duration.currentTimeMillis();
                currentFrameTiming = uncheckedConversion(endTime - startTime);
                startTime = endTime;
                frameCount = 0;
            }
            for (Command command : (Set<Command>) commands.clone()) {
                command.execute();
            }
            commands.clear();
        }
    }

    private static native int uncheckedConversion(double elapsed) /*-{
        return elapsed;
    }-*/;

}
