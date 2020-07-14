package com.compsci702.compsci702app.Tools;

import android.media.SoundPool;
import android.os.CountDownTimer;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.compsci702.compsci702app.Activity.GameActivity;
import com.compsci702.compsci702app.R;

public class Timer {

    private ProgressBar progressBar;
    private CountDownTimer timer;
    private int millisLeft;
    private int countdownMillis;
    private boolean playing = false;
    private int id;
    private SoundPool soundpool;

    public Timer(ProgressBar progressBar, int countdownMillis){
        this.progressBar = progressBar;
        this.progressBar.setProgress(100);
        this.countdownMillis = countdownMillis;
    }

    public void startTimer(final GameActivity gameActivity, final SoundPool soundPool, final int clockSound){
        soundpool = soundPool;
        timer = new CountDownTimer(countdownMillis, 1000) {
            public void onTick(long millisUntilFinished) {
                millisLeft = (int)millisUntilFinished;
                if(millisLeft > countdownMillis*0.5){
                    progressBar.setProgressDrawable(gameActivity.getDrawable(R.drawable.progress_bar_green));
                }else if(millisLeft > countdownMillis*0.25){
                    progressBar.setProgressDrawable(gameActivity.getDrawable(R.drawable.progress_bar_orange));
                }else{
                    progressBar.setProgressDrawable(gameActivity.getDrawable(R.drawable.progress_bar_red));
                    if (!playing) {
                        playing = true;
                        id = soundPool.play(clockSound, 1, 1, 0, 0, 1);
                    }
                }
                progressBar.setProgress((int)((millisUntilFinished*100)/countdownMillis));
            }
            public void onFinish() {
                progressBar.setProgress(0);
                gameActivity.timerhasFinished();
                soundPool.stop(id);
            }
        }.start();
    }

    public int stopTimer(){
        soundpool.stop(id);
        if(timer != null){
            timer.cancel();
        }
        return millisLeft;
    }

    public int getTimePerPhrase(){
        return countdownMillis;
    }
}