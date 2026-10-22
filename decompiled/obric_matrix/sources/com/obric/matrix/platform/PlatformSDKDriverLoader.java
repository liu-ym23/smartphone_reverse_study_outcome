package com.obric.matrix.platform;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class PlatformSDKDriverLoader {
    private static final String PLATFORM_SDK_BINARY = "platformsdk";
    private static final String TAG = "PlatformSDK";
    private static final String VOLCENGINERTC_BINARY = "volcenginertc";

    public PlatformSDKDriverLoader() {
    }

    public static long load64(Context r0, Context r1, int r2, int r3, int r4, int r5, int r6) {
        return loadInternal(r0, r1, r2, r3, r4, r5, r6);
    }

    private static long loadInternal(Context r0, Context r1, int r2, int r3, int r4, int r5, int r6) {
        c r7 = c.f9489a;
        r7.b();
        loadLib(r1);
        long r8 = nativeGetFunctionAccessor();
        r7.a();
        return r8;
    }

    private static void loadLib(Context r4) {
        boolean r0 = Process.is64Bit();     // Catch: Throwable -> L7
        Log.d(TAG, "loadLib: is64Bit = " + r0);     // Catch: Throwable -> L7
        if (r0 == true) goto L5;
        a.f9484a.b(r4);     // Catch: Throwable -> L7
    L5:
        System.loadLibrary(VOLCENGINERTC_BINARY);     // Catch: Throwable -> L7
        System.loadLibrary(PLATFORM_SDK_BINARY);     // Catch: Throwable -> L7
        onJniLoader(true, "");     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        onJniLoader(false, th.getMessage());
    }

    public static native long nativeGetFunctionAccessor();

    private static void onJniLoader(boolean r4, String r5) {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L13
        String r2 = LocationInfoConst.ALLOW_USE_LOCATION;
        if (r4 == false) goto L6;
        Object r6 = LocationInfoConst.ALLOW_USE_LOCATION;
    L7:
        r0.put("result", r6);     // Catch: Exception -> L13
        r0.put("error_msg", r5);     // Catch: Exception -> L13
        if (Process.is64Bit() == true) goto L11;
        r2 = BDLocationException.ERROR_TIMEOUT;
    L11:
        r0.put("is_64_bits", r2);     // Catch: Exception -> L13
        com.obric.matrix.server.t.a.c.f10010a.m("ppf_jni_onload", r0);     // Catch: Exception -> L13
        return;
    L6:
        r6 = BDLocationException.ERROR_TIMEOUT;
    }
}
