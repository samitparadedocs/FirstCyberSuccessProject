package com.cybersuccess.demo.firstcybersuccessproject.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import com.cybersuccess.demo.firstcybersuccessproject.R;

public class MyService extends Service {
    MediaPlayer mediaPlayer;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "Service Created", Toast.LENGTH_LONG).show();

        mediaPlayer = MediaPlayer.create(this, R.raw.sample_1);
        mediaPlayer.setLooping(false); // Set looping
    }

    @Override
    public void onStart(Intent intent, int startid) {
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        mediaPlayer.start();
    }
    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service Stopped", Toast.LENGTH_LONG).show();
        mediaPlayer.stop();
    }
}
