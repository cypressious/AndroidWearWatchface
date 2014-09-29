package com.google.android.clockwork.watchfaces;

import android.content.ComponentName;
import android.content.Intent;

public class WatchFaceIntents
{
  public static final Intent BIND_HOME_INTENT = new Intent("com.google.android.clockwork.home.action.BIND_HOME").setComponent(new ComponentName("com.google.android.wearable.app", "com.google.android.clockwork.home.watchfaces.HomeBackgroundService"));
}

/* Location:           Z:\Dropbox\Tools\APKtoJava\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.clockwork.watchfaces.WatchFaceIntents
 * JD-Core Version:    0.6.0
 */