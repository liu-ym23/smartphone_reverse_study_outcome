package com.bytedance.boost_multidex;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import java.io.File;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes.dex */
public class BoostMultiDex {
    public BoostMultiDex() {
    }

    public static Result install(Context r1) {
        return install(r1, null);
    }

    public static Result install(Context r4, Monitor r5) {
        Monitor.init(r5);
        Monitor r6 = Monitor.get();
        r6.logInfo("BoostMultiDex is installing, version is 1.0.2");
        if (isVMCapable(System.getProperty("java.vm.version")) == false) goto L7;
        String r7 = "BoostMultiDex support library is disabled for VM capable";
    L5:
        r6.logInfo(r7);
        return null;
    L7:
        int r0 = Build.VERSION.SDK_INT;
        if (r0 >= 14) goto L10;
        r7 = "BoostMultiDex installation failed. SDK " + r0 + " is unsupported. Min SDK version is 14.";
        goto L5
    L10:
        Result r1 = Result.get();
        ApplicationInfo r2 = r4.getApplicationInfo();     // Catch: Throwable -> L23
        if (r2 == null) goto L22;
        File r3 = new File(r2.sourceDir);     // Catch: Throwable -> L23
        String r8 = r6.getProcessName();     // Catch: Throwable -> L23
        if (r8 != null) goto L17;
        r8 = Utility.getCurProcessName(r4);     // Catch: Throwable -> L23
    L17:
        if (Utility.isOptimizeProcess(r8) == false) goto L20;
        new DexInstallProcessor().doInstallationInOptProcess(r4, r3);     // Catch: Throwable -> L23
        return null;
    L20:
        new DexInstallProcessor().doInstallation(r4, r3, r1);     // Catch: Throwable -> L23
    L25:
        r6.logInfo("install done");
        return r1;
    L22:
        throw new RuntimeException("ApplicationInfo is NULL.");     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        r6.logError("BoostMultiDex installation failure", th);
        r1.setFatalThrowable(th);
        goto L25
    }

    public static boolean isOptimizeProcess(String r0) {
        return Utility.isOptimizeProcess(r0);
    }

    private static boolean isVMCapable(String r5) {
        boolean r0 = false;
        if (r5 == null) goto L19;
        StringTokenizer r1 = new StringTokenizer(r5, ".");
        String r3 = null;
        if (r1.hasMoreTokens() == false) goto L7;
        String r2 = r1.nextToken();
    L9:
        if (r1.hasMoreTokens() == false) goto L11;
        r3 = r1.nextToken();
    L11:
        if (r2 == null) goto L19;
        if (r3 == null) goto L19;
        int r4 = Integer.parseInt(r2);     // Catch: NumberFormatException -> L25
        int r6 = Integer.parseInt(r3);     // Catch: NumberFormatException -> L25
        if (r4 > 2) goto L18;
        if (r4 != 2) goto L19;
        if (r6 < 1) goto L19;
    L18:
        r0 = true;
        goto L19
    L7:
        r2 = null;
    L19:
        Monitor r7 = Monitor.get();
        StringBuilder r8 = new StringBuilder();
        r8.append("VM with version ");
        r8.append(r5);
        if (r0 == false) goto L22;
        String r9 = " has support";
    L23:
        r8.append(r9);
        r7.logInfo(r8.toString());
        return r0;
    L22:
        r9 = " does not have support";
        goto L23
    }
}
