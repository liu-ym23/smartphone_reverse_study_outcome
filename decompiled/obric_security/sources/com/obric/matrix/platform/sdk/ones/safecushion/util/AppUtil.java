package com.obric.matrix.platform.sdk.ones.safecushion.util;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AppUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0002J\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/safecushion/util/AppUtil;", "", "()V", "sCurProcessName", "", "getCurProcessName", "context", "Landroid/content/Context;", "isMainOrSafeProcess", "", "isMainProcess", "isProcessConsideredBackground", "importance", "", "isProcessInBackground", "isSafeModeProcess", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AppUtil {
    public static final AppUtil INSTANCE = null;
    private static String sCurProcessName;

    static {
        INSTANCE = new AppUtil();
    }

    private AppUtil() {
    }

    public final boolean isMainProcess(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        String r5 = getCurProcessName(r6);
        if (r5 != null) goto L5;
    L7:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(r5, r6.getPackageName()) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (StringsKt.contains$default(r5, ":", false, 2, null) == false) goto L7;
        return false;
    }

    public final boolean isMainOrSafeProcess(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        String r2 = getCurProcessName(r3);
        if (r2 != null) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r2, r3.getPackageName()) == false) goto L8;
    L9:
        return true;
    L8:
        if (Intrinsics.areEqual(r2, r3.getPackageName() + ":safecushion") == true) goto L9;
        return false;
    }

    public final boolean isSafeModeProcess(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        String r1 = getCurProcessName(r2);
        if (r1 != null) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(r1, r2.getPackageName() + ":safecushion");
    }

    public final boolean isProcessInBackground(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        String r0 = getCurProcessName(r5);
        if (r0 != null) goto L5;
        return true;
    L5:
        Object r6 = r5.getSystemService("activity");
        if ((r6 instanceof ActivityManager) == false) goto L8;
        ActivityManager r7 = (ActivityManager) r6;
    L9:
        if (r7 != null) goto L11;
        return true;
    L11:
        List<ActivityManager.RunningAppProcessInfo> r8 = r7.getRunningAppProcesses();
        if (r8 != null) goto L14;
        return true;
    L14:
        Iterator<ActivityManager.RunningAppProcessInfo> r9 = r8.iterator();
    L16:
        if (r9.hasNext() == false) goto L21;
        ActivityManager.RunningAppProcessInfo r2 = r9.next();
        if (Intrinsics.areEqual(r2.processName, r0) == false) goto L16;
        return isProcessConsideredBackground(r2.importance);
    L21:
        return true;
    L8:
        r7 = null;
        goto L9
    }

    private final boolean isProcessConsideredBackground(int r6) {
        if (Build.VERSION.SDK_INT < 35) goto L9;
        if (r6 == 100) goto L13;
        if (r6 == 200) goto L13;
        if (r6 == 125) goto L13;
        return true;
    L13:
        return false;
    L9:
        if (r6 == 100) goto L13;
        if (r6 == 200) goto L13;
        return true;
    }

    public final String getCurProcessName(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        String r3 = sCurProcessName;
        String r0 = r3;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        return r3;
    L11:
        String r5 = Application.getProcessName();
        sCurProcessName = r5;
        String r6 = r5;
        if (r6 != null) goto L14;
    L15:
        r1 = true;
    L16:
        if (r1 == true) goto L38;
        return sCurProcessName;
    L38:
        int r7 = Process.myPid();     // Catch: Exception -> L35
        Object r8 = r4.getSystemService("activity");     // Catch: Exception -> L35
        if ((r8 instanceof ActivityManager) == false) goto L23;
        ActivityManager r9 = (ActivityManager) r8;     // Catch: Exception -> L35
    L24:
        if (r9 != null) goto L26;
        return null;
    L26:
        Iterator<ActivityManager.RunningAppProcessInfo> r10 = r9.getRunningAppProcesses().iterator();     // Catch: Exception -> L35
    L28:
        if (r10.hasNext() == false) goto L33;
        ActivityManager.RunningAppProcessInfo r11 = r10.next();     // Catch: Exception -> L35
        if (r11.pid != r7) goto L28;
        MLog.i$default("Process", "processName = " + r11.processName, null, 4, null);     // Catch: Exception -> L35
        String r12 = r11.processName;     // Catch: Exception -> L35
        sCurProcessName = r12;     // Catch: Exception -> L35
        return r12;
    L33:
        String r13 = (String) null;     // Catch: Exception -> L35
    L37:
        return null;
    L23:
        r9 = null;
    L35:
        e = move-exception;
        e.printStackTrace();
        String r14 = (String) null;
        goto L37
    L14:
        if (r6.length() != 0) goto L16;
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L9
    }
}
