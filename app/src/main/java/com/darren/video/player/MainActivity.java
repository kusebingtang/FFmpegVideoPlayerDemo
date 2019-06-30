package com.darren.video.player;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import com.darren.media.DarrenPlayer;
import com.darren.media.listener.MediaPreparedListener;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private File mVideoFile = new File(Environment.getExternalStorageDirectory(), "BaiduNetdisk/我的资源/01.mp4");
    private DarrenPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlayer = new DarrenPlayer();
        mPlayer.setDataSource(mVideoFile.getAbsolutePath());
        mPlayer.setOnPreparedListener(new MediaPreparedListener() {
            @Override
            public void onPrepared() {
                mPlayer.play();
            }
        });
        mPlayer.prepareAsync();
    }
}
