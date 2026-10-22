package com.bytedance.boost_multidex;

import android.os.Build;
import java.io.File;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
final class BoostNative {
    private static volatile boolean alreadyInit;
    private static boolean supportFastLoadDex;

    static {
        Monitor.get().loadLibrary(Constants.BOOST_MULTIDEX_DIR_NAME);
    }

    BoostNative() {
    }

    private static void checkSupportFastLoad(Result r10) {
        Method r0 = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class, String.class});     // Catch: Throwable -> L19
        int r1 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L19
        if (r1 < 19) goto L9;
        String r2 = (String) r0.invoke(null, new Object[]{"persist.sys.dalvik.vm.lib", null});     // Catch: Throwable -> L19
        r10.vmLibName = r2;     // Catch: Throwable -> L19
        Monitor.get().logInfo("VM lib is " + r2);     // Catch: Throwable -> L19
        if ("libart.so".equals(r2) == false) goto L9;
        Monitor.get().logWarning("VM lib is art, skip!");     // Catch: Throwable -> L19
        return;
    L9:
        String r3 = (String) r0.invoke(null, new Object[]{"ro.yunos.version", null});     // Catch: Throwable -> L19
        if (r3 == null) goto L14;
        if (r3.isEmpty() == true) goto L14;
    L15:
        r10.isYunOS = true;     // Catch: Throwable -> L19
        Monitor.get().logWarning("Yun os is " + r3 + ", skip boost!");     // Catch: Throwable -> L19
        return;
    L14:
        if (new File(Constants.LIB_YUNOS_PATH).exists() == true) goto L15;
        boolean r4 = initialize(r1, RuntimeException.class);     // Catch: Throwable -> L19
        supportFastLoadDex = r4;     // Catch: Throwable -> L19
        r10.supportFastLoadDex = r4;     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        r10.addUnFatalThrowable(th);
        Monitor.get().logWarning("Fail to init", th);
    }

    private static native boolean initialize(int r0, Class<RuntimeException> r1);

    static synchronized boolean isSupportFastLoad() {
        monitor-enter(BoostNative.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (alreadyInit == true) goto L7;
        checkSupportFastLoad(Result.get());     // Catch: Throwable -> L10
        alreadyInit = true;     // Catch: Throwable -> L10
    L7:
        boolean r1 = supportFastLoadDex;     // Catch: Throwable -> L10
        monitor-exit(BoostNative.class);
        return r1;
    }

    static native Object loadDirectDex(String r0, byte[] r1);

    static native boolean makeOptDexFile(String r0, String r1);

    static native long obtainCheckSum(String r0);

    static native void recoverAction();
}
