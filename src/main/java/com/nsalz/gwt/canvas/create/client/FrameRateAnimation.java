package com.nsalz.gwt.canvas.create.client;

import com.google.gwt.core.client.Duration;
import com.google.gwt.user.client.Command;

public abstract class FrameRateAnimation
{
    private final Command command = new Command(){
        @Override
        public void execute()
        {
            update(Duration.currentTimeMillis());
        }
    };

    /**
     * The duration of the {@link FrameRateAnimation} in milliseconds.
     */
    private int duration = -1;

    /**
     * Is the {@link FrameRateAnimation} running, even if {@link #onStart()} has not yet
     * been called.
     */
    private boolean running = false;

    /**
     * Has the {@link FrameRateAnimation} actually started.
     */
    private boolean started = false;

    /**
     * The start time of the {@link FrameRateAnimation}.
     */
    private double startTime = -1;

    /**
     * Immediately cancel this animation. If the animation is running or is
     * scheduled to run, {@link #onCancel()} will be called.
     */
    public void cancel()
    {
        // Ignore if the animation is not currently running
        if (!running) {
            return;
        }

        onCancel();
        started = false;
        running = false;
    }

    /**
     * Immediately run this animation. If the animation is already running, it
     * will be canceled first.
     * 
     * @param duration
     *            the duration of the animation in milliseconds
     */
    public void run(int duration)
    {
        run(duration, Duration.currentTimeMillis());
    }

    /**
     * Run this animation at the given startTime. If the startTime has already
     * passed, the animation will be synchronize as if it started at the
     * specified start time. If the animation is already running, it will be
     * canceled first.
     * 
     * @param duration
     *            the duration of the animation in milliseconds
     * @param startTime
     *            the synchronized start time in milliseconds
     */
    public void run(int duration, double startTime)
    {
        // Cancel the animation if it is running
        cancel();

        // Save the duration and startTime
        this.running = true;
        this.duration = duration;
        this.startTime = startTime;

        // Start synchronously if start time has passed
        update(Duration.currentTimeMillis());
    }

    /**
     * Interpolate the linear progress into a more natural easing function.
     * 
     * Depending on the {@link FrameRateAnimation}, the return value of this method can
     * be less than 0.0 or greater than 1.0.
     * 
     * @param progress
     *            the linear progress, between 0.0 and 1.0
     * @return the interpolated progress
     */
    protected double interpolate(double progress)
    {
        return (1 + Math.cos(Math.PI + progress * Math.PI)) / 2;
    }

    /**
     * Called immediately after the animation is canceled. The default
     * implementation of this method calls {@link #onComplete()} only if the
     * animation has actually started running.
     */
    protected void onCancel()
    {
        if (started) {
            onComplete();
        }
    }

    /**
     * Called immediately after the animation completes.
     */
    protected void onComplete()
    {
        onUpdate(interpolate(1.0));
    }

    /**
     * Called immediately before the animation starts.
     */
    protected void onStart()
    {
        onUpdate(interpolate(0.0));
    }

    /**
     * Called when the animation should be updated.
     * 
     * The value of progress is between 0.0 and 1.0 (inclusive) (unless you
     * override the {@link #interpolate(double)} method to provide a wider range
     * of values). You can override {@link #onStart()} and {@link #onComplete()}
     * to perform setup and tear down procedures.
     * 
     * @param progress
     *            a double, normally between 0.0 and 1.0 (inclusive)
     */
    protected abstract void onUpdate(double progress);

    /**
     * Update the {@link FrameRateAnimation}.
     * 
     * @param curTime
     *            the current time
     * @return true if the animation is complete, false if still running
     */
    private void update(double curTime)
    {
        if (!running) {
            return;
        }

        boolean finished = curTime >= startTime + duration;
        if (started && !finished) {
            // Animation is in progress.
            double progress = (curTime - startTime) / duration;
            onUpdate(interpolate(progress));
            FrameRateScheduler.get().addToNextFrame(command);
            return;
        }
        if (!started && curTime >= startTime) {
            // Start the animation.
            started = true;
            onStart();
            // Intentional fall through to possibly end the animation.
        }
        if (finished) {
            // Animation is complete.
            onComplete();
            started = false;
            running = false;
            return;
        }
        
        FrameRateScheduler.get().addToNextFrame(command);
    }
}
