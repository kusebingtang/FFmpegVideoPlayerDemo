package com.darren.media;

import android.content.Context;
import android.graphics.PixelFormat;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.darren.media.listener.MediaPreparedListener;

/**
 * Created by hcDarren on 2019/6/30.
 */
public class DZVideoView extends SurfaceView implements MediaPreparedListener{
    private DarrenPlayer mPlayer;

    public DZVideoView(Context context) {
        this(context, null);
    }

    public DZVideoView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DZVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        // 设置显示的像素格式
        SurfaceHolder holder = getHolder();
        holder.setFormat(PixelFormat.RGBA_8888);
        mPlayer = new DarrenPlayer();
        mPlayer.setOnPreparedListener(this);
    }

    public void play(String uri) {
        stop();
        mPlayer.setDataSource(uri);
        mPlayer.prepareAsync();
    }

    /**
     * 停止方法，释放上一个视频的内存
     */
    public void stop(){

    }

    @Override
    public void onPrepared() {
        mPlayer.play();
    }
}
