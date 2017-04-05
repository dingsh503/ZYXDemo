package net.iclassmate.zyxdemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

/**
 * Created by xydbj on 2017.3.21.
 */

public class VideoDownService extends Service {

    SimpleBinder simpleBinder;

    @Override
    public void onCreate() {
        super.onCreate();
        simpleBinder = new SimpleBinder();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return simpleBinder;
    }

    public class SimpleBinder extends Binder{

    }

}
