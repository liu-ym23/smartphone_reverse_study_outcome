package com.ttnet.org.chromium.net;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.core.app.NotificationManagerCompat;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace(ApmTrafficStats.KEY_TRAFFIC_STATUS_NET)
public class TTSocketAccelerate {
    private static final int ACCELERATE_ERROR_CALLBACK_EXCEPTION = -1001;
    private static final int ACCELERATE_ERROR_RESULT_CODE_ERROR = -1002;
    private static final int ACCELERATE_ERROR_TIMEOUT = -1003;
    private static final int ACCELERATE_NOTIFY_EXCEPTION = -1000;
    private static final int ACCELERATE_NOTIFY_SUCC = 0;
    private static final int ACC_DEFAULT = 3;
    private static final int MSG_TYPE_ACC_INFO = 16;
    private static final int MSG_TYPE_SCENE_INFO = 1;
    private static final int MSG_TYPE_SUB_SCENE_INFO = 32;
    private static final int REGIST_ANDROID_VERSION_ERROR = -1003;
    private static final int REGIST_BRAND_ERROR = -1002;
    private static final int REGIST_EXCEPTION = -1001;
    private static final int REGIST_SUCC = 0;
    private static final int REGIST_UNKNOWN = -1000;
    private static final int SCENE_SHORT_VIDEO = 16;
    private static final int STATUS_SCENE_ENTER = 1;
    private static final int SUB_SCENE_HTTP_DNS = 1;
    private static final String TAG = "TTSocketAccelerate";
    private static final String sEmcomManagerExClass = "com.hihonor.android.emcom.EmcomManagerEx";
    private static final String sNotifyAppInfoMethod = "notifyAppInfo";
    private long nativeDelegate;

    public interface Natives {
        @NativeClassQualifiedName("TTSocketAccelerateDelegateAndroid")
        void OnCheckSystemAvailableResult(long r1, TTSocketAccelerate r3, int r4);

        @NativeClassQualifiedName("TTSocketAccelerateDelegateAndroid")
        void OnNotifyAccelerateResult(long r1, TTSocketAccelerate r3, int r4, int r5);
    }

    public TTSocketAccelerate() {
        this.nativeDelegate = 0;
    }

    @CalledByNative
    public static TTSocketAccelerate init() {
        return new TTSocketAccelerate();
    }

    @CalledByNative
    public void checkSystemAvailable() {
        if (this.nativeDelegate != 0) goto L6;
        return;
    L6:
        if (Build.MANUFACTURER.toLowerCase().contains("honor") == false) goto L8;
    L11:
        TTSocketAccelerateJni.get().OnCheckSystemAvailableResult(this.nativeDelegate, this, 0);
        return;
    L8:
        if (Build.BRAND.toLowerCase().contains("honor") == true) goto L11;
        TTSocketAccelerateJni.get().OnCheckSystemAvailableResult(this.nativeDelegate, this, -1002);
    }

    @CalledByNative
    public void notifyAccelerate(int r10, int r11, int r12) {
        Method r2 = Class.forName(sEmcomManagerExClass).getMethod(sNotifyAppInfoMethod, new Class[]{Bundle.class});     // Catch: Throwable -> L5
        Log.e("SA", "notify scene:" + r10 + " value: " + r11 + " fd:" + r12);     // Catch: Throwable -> L5
        Bundle r1 = new Bundle();     // Catch: Throwable -> L5
        r1.putInt("msgType", 49);     // Catch: Throwable -> L5
        r1.putInt("scene", 16);     // Catch: Throwable -> L5
        r1.putInt("subscene", r11);     // Catch: Throwable -> L5
        r1.putInt("status", 1);     // Catch: Throwable -> L5
        r1.putInt("accStatus", 3);     // Catch: Throwable -> L5
        r1.putString("KFD", "" + r12);     // Catch: Throwable -> L5
        r2.invoke(null, new Object[]{r1});     // Catch: Throwable -> L5
        TTSocketAccelerateJni.get().OnNotifyAccelerateResult(this.nativeDelegate, this, r10, 0);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        TTSocketAccelerateJni.get().OnNotifyAccelerateResult(this.nativeDelegate, this, r10, NotificationManagerCompat.IMPORTANCE_UNSPECIFIED);
    }

    @CalledByNative
    public void setNativeDelegate(long r1) {
        this.nativeDelegate = r1;
    }
}
