package com.android.settingslib.bluetooth;

import android.content.Context;
import android.os.Handler;
import android.os.UserHandle;
import com.GlobalProxyLancet;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class LocalBluetoothManager {
    private static final String TAG = "LocalBluetoothManager";
    private static LocalBluetoothManager sInstance;
    private final CachedBluetoothDeviceManager mCachedDeviceManager;
    private final Context mContext;
    private final BluetoothEventManager mEventManager;
    private WeakReference<Context> mForegroundActivity;
    private final LocalBluetoothAdapter mLocalAdapter;
    private final LocalBluetoothProfileManager mProfileManager;

    public interface BluetoothManagerCallback {
        void onBluetoothManagerInitialized(Context r1, LocalBluetoothManager r2);
    }

    public static synchronized LocalBluetoothManager getInstance(Context r4, BluetoothManagerCallback r5) {
        monitor-enter(LocalBluetoothManager.class);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L14;
        LocalBluetoothAdapter r1 = LocalBluetoothAdapter.getInstance();     // Catch: Throwable -> L17
        if (r1 != null) goto L11;
        monitor-exit(LocalBluetoothManager.class);
        return null;
    L11:
        sInstance = new LocalBluetoothManager(r1, r4, null, null);     // Catch: Throwable -> L17
        if (r5 == null) goto L14;
        r5.onBluetoothManagerInitialized(r4.getApplicationContext(), sInstance);     // Catch: Throwable -> L17
    L14:
        LocalBluetoothManager r6 = sInstance;     // Catch: Throwable -> L17
        monitor-exit(LocalBluetoothManager.class);
        return r6;
    }

    public static LocalBluetoothManager create(Context r3, Handler r4) {
        LocalBluetoothAdapter r0 = LocalBluetoothAdapter.getInstance();
        if (r0 != null) goto L6;
        return null;
    L6:
        return new LocalBluetoothManager(r0, r3, r4, null);
    }

    public static LocalBluetoothManager create(Context r2, Handler r3, UserHandle r4) {
        LocalBluetoothAdapter r0 = LocalBluetoothAdapter.getInstance();
        if (r0 != null) goto L7;
        return null;
    L7:
        return new LocalBluetoothManager(r0, r2, r3, r4);
    }

    private LocalBluetoothManager(LocalBluetoothAdapter r10, Context r11, Handler r12, UserHandle r13) {
        Context r14 = r11.getApplicationContext();
        this.mContext = r14;
        this.mLocalAdapter = r10;
        CachedBluetoothDeviceManager r7 = new CachedBluetoothDeviceManager(r14, this);
        this.mCachedDeviceManager = r7;
        BluetoothEventManager r8 = new BluetoothEventManager(r10, this, r7, r14, r12, r13);
        this.mEventManager = r8;
        LocalBluetoothProfileManager r15 = new LocalBluetoothProfileManager(r14, r10, r7, r8);
        this.mProfileManager = r15;
        r15.updateLocalProfiles();
        r8.readPairedDevices();
    }

    public LocalBluetoothAdapter getBluetoothAdapter() {
        return this.mLocalAdapter;
    }

    public Context getContext() {
        return this.mContext;
    }

    public Context getForegroundActivity() {
        WeakReference<Context> r0 = this.mForegroundActivity;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.get();
    }

    public boolean isForegroundActivity() {
        WeakReference<Context> r0 = this.mForegroundActivity;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.get() == null) goto L7;
        return true;
    }

    public synchronized void setForegroundActivity(Context r3) {
        monitor-enter(this);
        if (r3 == null) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "setting foreground activity to non-null context");     // Catch: Throwable -> L10
        this.mForegroundActivity = new WeakReference(r3);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return;
    L6:
        if (this.mForegroundActivity == null) goto L8;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "setting foreground activity to null");     // Catch: Throwable -> L10
        this.mForegroundActivity = null;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CachedBluetoothDeviceManager getCachedDeviceManager() {
        return this.mCachedDeviceManager;
    }

    public BluetoothEventManager getEventManager() {
        return this.mEventManager;
    }

    public LocalBluetoothProfileManager getProfileManager() {
        return this.mProfileManager;
    }
}
