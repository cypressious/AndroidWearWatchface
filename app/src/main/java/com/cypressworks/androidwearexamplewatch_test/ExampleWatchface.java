package com.cypressworks.androidwearexamplewatch_test;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.google.android.clockwork.watchfaces.IHomeBackgroundService;
import com.google.android.clockwork.watchfaces.WatchFaceStyle;

public class ExampleWatchface extends Activity {

    public static final Intent BIND_HOME_INTENT = new Intent(
            "com.google.android.clockwork.home.action.BIND_HOME").setComponent(
            new ComponentName("com.google.android.wearable.app",
                              "com.google.android.clockwork.home.watchfaces.HomeBackgroundService"));

    private final ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(final ComponentName name, final IBinder service) {

            IHomeBackgroundService localIHomeBackgroundService = IHomeBackgroundService.Stub.asInterface(
                    service);

            try {
                localIHomeBackgroundService.setStyle(buildStyle());
            } catch (RemoteException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void onServiceDisconnected(final ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("WatchFace", "onCreate();");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        boolean hasPermission = checkCallingOrSelfPermission(
                "com.google.android.permission.PROVIDE_BACKGROUND") == PackageManager.PERMISSION_GRANTED;
        Log.d("WatchFace", "Permission: " + hasPermission);

        if (hasPermission) {
            if (!bindService(BIND_HOME_INTENT, this.mServiceConnection, BIND_AUTO_CREATE)) {
                Log.e("ExampleWatchface",
                      "unable to connect to home background service, watch face will look weird");
            }
        }

    }

    public void onDestroy() {
        unbindService(this.mServiceConnection);
        super.onDestroy();
    }

    protected WatchFaceStyle buildStyle() {
        return WatchFaceStyle.Builder.forActivity(this).setCardPeekMode(1).setCardProgressMode(
                0).setBackgroundVisibility(0).setShowSystemUiTime(false).build();

    }

}
