package com.android.settings.utils;

import android.net.ConnectivityManager;
import android.os.Handler;
import com.android.settings.NetworkSettingsFragment;
import com.obric.olog.OLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkTetherUtils {
    private static final String TAG = "NetworkTetherUtils";

    private static final class UsbTetheringCallback extends ConnectivityManager.OnStartTetheringCallback {
        private static final String TAG = "NetworkTetherUtils/Cb";
        final WeakReference<NetworkSettingsFragment> mTetherSettings;

        UsbTetheringCallback(NetworkSettingsFragment r2) {
            this.mTetherSettings = new WeakReference(r2);
        }

        public void onTetheringStarted() {
            OLog.d(TAG, "onTetheringStarted: ");
            NetworkSettingsFragment r2 = this.mTetherSettings.get();
            if (r2 == null) goto L6;
            r2.setUsbStarted(true);
            return;
        }

        public void onTetheringFailed() {
            OLog.d(TAG, "onTetheringFailed: ");
            NetworkSettingsFragment r0 = this.mTetherSettings.get();
            if (r0 == null) goto L6;
            r0.setUsbStarted(false);
            update();
            return;
        }

        private void update() {
            NetworkSettingsFragment r0 = this.mTetherSettings.get();
            if (r0 == null) goto L6;
            r0.updateState();
            return;
        }
    }

    public NetworkTetherUtils() {
    }

    public static int setUsbTethering(NetworkSettingsFragment r9, ConnectivityManager r10, boolean r11, Handler r12) {
        OLog.d(TAG, "setUsbTethering: new API");
        UsbTetheringCallback r0 = new UsbTetheringCallback(r9);
        Class<?> r2 = Class.forName("android.net.ConnectivityManager");     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchMethodException -> L12 ClassNotFoundException -> L14
        if (r11 == false) goto L6;
        r2.getDeclaredMethod("startTethering", new Class[]{Integer.TYPE, Boolean.TYPE, ConnectivityManager.OnStartTetheringCallback.class, Handler.class}).invoke(r10, new Object[]{1, true, r0, r12});     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchMethodException -> L12 ClassNotFoundException -> L14
    L7:
        return 0;
    L6:
        r2.getDeclaredMethod("stopTethering", new Class[]{Integer.TYPE}).invoke(r10, new Object[]{1});     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchMethodException -> L12 ClassNotFoundException -> L14
    L14:
        e = move-exception;
        e.printStackTrace();
    L16:
        return 1;
    L10:
        e = move-exception;
        e.printStackTrace();
    L12:
        e = move-exception;
        OLog.e(TAG, "setUsbTethering: " + e);
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }
}
