package com.ttnet.org.chromium.base.compat;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.hardware.biometrics.BiometricManager;
import android.net.NetworkCapabilities;
import android.net.TransportInfo;
import android.net.Uri;
import android.os.FileUtils;
import android.os.PowerManager;
import android.provider.MediaStore;
import android.telephony.CellInfo;
import android.telephony.TelephonyManager;
import android.view.MotionEvent;
import androidx.annotation.RequiresApi;
import com.ttnet.org.chromium.base.Callback;
import com.ttnet.org.chromium.base.task.AsyncTask;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(29)
public final class ApiHelperForQ {
    private ApiHelperForQ() {
    }

    public static boolean bindIsolatedService(Context r0, Intent r1, int r2, String r3, Executor r4, ServiceConnection r5) {
        return r0.bindIsolatedService(r1, r2, r3, r4, r5);
    }

    public static int canAuthenticate(BiometricManager r0) {
        return r0.canAuthenticate();
    }

    public static long copy(InputStream r0, OutputStream r1) {
        return FileUtils.copy(r0, r1);
    }

    public static BiometricManager getBiometricManagerSystemService(Context r1) {
        return (BiometricManager) r1.getSystemService(BiometricManager.class);
    }

    public static int getClassification(MotionEvent r0) {
        return r0.getClassification();
    }

    public static int getCurrentThermalStatus(PowerManager r0) {
        return r0.getCurrentThermalStatus();
    }

    public static Set<String> getExternalVolumeNames(Context r0) {
        return MediaStore.getExternalVolumeNames(r0);
    }

    public static TransportInfo getTransportInfo(NetworkCapabilities r0) {
        return r0.getTransportInfo();
    }

    public static void requestCellInfoUpdate(TelephonyManager r2, final Callback<List<CellInfo>> r3) {
        r2.requestCellInfoUpdate(AsyncTask.THREAD_POOL_EXECUTOR, new AnonymousClass1(r3));
    }

    public static Uri setIncludePending(Uri r0) {
        return MediaStore.setIncludePending(r0);
    }

    public static void startForeground(Service r0, int r1, Notification r2, int r3) {
        r0.startForeground(r1, r2, r3);
    }

    public static void updateServiceGroup(Context r0, ServiceConnection r1, int r2, int r3) {
        r0.updateServiceGroup(r1, r2, r3);
    }
}
