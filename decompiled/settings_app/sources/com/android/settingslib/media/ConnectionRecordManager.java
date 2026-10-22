package com.android.settingslib.media;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
public class ConnectionRecordManager {
    private static final String KEY_LAST_SELECTED_DEVICE = "last_selected_device";
    private static final String SHARED_PREFERENCES_NAME = "seamless_transfer_record";
    private static final String TAG = "ConnectionRecordManager";
    private static ConnectionRecordManager sInstance;
    private static final Object sInstanceSync = null;
    private String mLastSelectedDevice;

    public ConnectionRecordManager() {
    }

    static {
        sInstanceSync = new Object();
    }

    public static ConnectionRecordManager getInstance() {
        Object r0 = sInstanceSync;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new ConnectionRecordManager();     // Catch: Throwable -> L10
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return sInstance;
    }

    private SharedPreferences getSharedPreferences(Context r2) {
        return r2.getSharedPreferences(SHARED_PREFERENCES_NAME, 0);
    }

    public synchronized int fetchConnectionRecord(Context r2, String r3) {
        monitor-enter(this);
        int r4 = getSharedPreferences(r2).getInt(r3, 0);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r4;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void fetchLastSelectedDevice(Context r3) {
        monitor-enter(this);
        this.mLastSelectedDevice = getSharedPreferences(r3).getString(KEY_LAST_SELECTED_DEVICE, null);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void setConnectionRecord(Context r1, String r2, int r3) {
        monitor-enter(this);
        SharedPreferences.Editor r4 = getSharedPreferences(r1).edit();     // Catch: Throwable -> L6
        this.mLastSelectedDevice = r2;     // Catch: Throwable -> L6
        r4.putInt(r2, r3);     // Catch: Throwable -> L6
        r4.putString(KEY_LAST_SELECTED_DEVICE, this.mLastSelectedDevice);     // Catch: Throwable -> L6
        r4.apply();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized String getLastSelectedDevice() {
        monitor-enter(this);
        String r0 = this.mLastSelectedDevice;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }
}
