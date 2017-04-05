package net.iclassmate.zyxdemo.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import net.iclassmate.zyxdemo.R;


/**
 * Created by xydbj on 2017.3.21.
 */

public class MusicService extends Service {

    String TAG = "MusicService";
    MediaPlayer mPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(this, "MusicService onBind()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "MusicService onBind()");
        mPlayer.start();
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Toast.makeText(this, "MusicService onUnBind()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "MusicService onUnBind()");
        mPlayer.stop();
        return false;
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "MusicService onCreate()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "MusicService onCreate()");
        mPlayer = MediaPlayer.create(getApplicationContext(), R.raw.tillworldend);
        mPlayer.setLooping(true);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "MusicService onStartCommand()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "MusicService onStartCommand()");
        mPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "MusicService onDestory()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "MusicService onDestory()");
        mPlayer.stop();
        super.onDestroy();
    }
}
