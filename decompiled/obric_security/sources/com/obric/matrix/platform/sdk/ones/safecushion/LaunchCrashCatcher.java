package com.obric.matrix.platform.sdk.ones.safecushion;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import com.obric.matrix.platform.sdk.ones.safecushion.crashcatcher.ActivityThreadHelper;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: LaunchCrashCatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0016J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0016J\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/safecushion/LaunchCrashCatcher;", "Lcom/obric/matrix/platform/sdk/ones/safecushion/crashcatcher/ActivityThreadHelper$AppCallback;", "()V", "TAG", "", "attached", "", "attach", "detach", "fillThrowableToStr", "e", "", "onHandleException", "", "type", SafeCushionConstant.CRASH_INFO_FILE_NAME_PREFIX, "throwable", "openMarketDetails", "context", "Landroid/content/Context;", "startActivityIfExist", "intent", "Landroid/content/Intent;", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LaunchCrashCatcher implements ActivityThreadHelper.AppCallback {
    public static final LaunchCrashCatcher INSTANCE = null;
    private static final String TAG = "SafeModeCrashHandler";
    private static volatile boolean attached;

    static {
        INSTANCE = new LaunchCrashCatcher();
    }

    @Override // com.obric.matrix.platform.sdk.ones.safecushion.crashcatcher.ActivityThreadHelper.AppCallback
    public void onHandleException(String r1) {
        Intrinsics.checkNotNullParameter(r1, "type");
    }

    @Override // com.obric.matrix.platform.sdk.ones.safecushion.crashcatcher.ActivityThreadHelper.AppCallback
    public void onHandleException(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "type");
    }

    private LaunchCrashCatcher() {
    }

    public final boolean attach() {
        if (attached == false) goto L6;
        MLog.i$default(TAG, "Attach failed, already attached.", null, 4, null);
        return false;
    L6:
        boolean r5 = ActivityThreadHelper.INSTANCE.setAppCallback(this);
        if (r5 == false) goto L9;
        attached = true;
    L9:
        MLog.i$default(TAG, "attach via ActivityThread AppCallback, success=" + r5, null, 4, null);
        return r5;
    }

    public final boolean detach() {
        if (attached == true) goto L6;
        MLog.i$default(TAG, "Detach failed, not attach or has already detached.", null, 4, null);
        return false;
    L6:
        boolean r4 = ActivityThreadHelper.INSTANCE.removeAppCallback();
        if (r4 == false) goto L9;
        attached = false;
    L9:
        return r4;
    }

    @Override // com.obric.matrix.platform.sdk.ones.safecushion.crashcatcher.ActivityThreadHelper.AppCallback
    public void onHandleException(String r4, Throwable r5) {
        Intrinsics.checkNotNullParameter(r4, "type");
        if (r5 == null) goto L5;
        String r0 = INSTANCE.fillThrowableToStr(r5);
    L6:
        MLog.i$default(TAG, "onHandleException type=" + r4 + " throwable=" + r5, null, 4, null);
        SafeCushionCrashCounter.INSTANCE.onCrash(r4, r0, Thread.currentThread());
        return;
    L5:
        r0 = null;
        goto L6
    }

    public final boolean openMarketDetails(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Toast.makeText(r6, "修复后进程重启，依旧抓到了崩溃\n没办法了，现在引导去商店升级应用版本", 0).show();     // Catch: Exception -> L5
        Intent r2 = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + MatrixCushionManager.Companion.getInstance().getConfig().getPkgName()));     // Catch: Exception -> L5
        r2.setFlags(268435456);     // Catch: Exception -> L5
        r6.startActivity(r2);     // Catch: Exception -> L5
        return true;
    L5:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    private final String fillThrowableToStr(Throwable r5) {
    L3:
        if (r5.getCause() == null) goto L5;
        r5 = r5.getCause();
        Intrinsics.checkNotNull(r5);
        goto L3
    L5:
        JSONArray r4 = new JSONArray();
        int r0 = 0;
    L6:
        String r1 = "";
        if (r0 >= 3) goto L16;
        StackTraceElement[] r2 = r5.getStackTrace();
        Intrinsics.checkNotNullExpressionValue(r2, "throwable.stackTrace");
        StackTraceElement r3 = (StackTraceElement) ArraysKt.getOrNull(r2, r0);
        if (r3 == null) goto L11;
        String r6 = r3.toString();
    L12:
        if (r6 == null) goto L15;
        r1 = r6;
    L15:
        r4.put(r1);
        r0 = r0 + 1;
        goto L6
    L11:
        r6 = null;
        goto L12
    L16:
        JSONObject r7 = new JSONObject();
        r7.put("crash_class", r5.getClass().getName());
        String r8 = r5.getMessage();
        if (r8 == null) goto L20;
        r1 = r8;
    L20:
        r7.put(SafeCushionConstant.KEY_CRASH_MSG, r1);
        r7.put("top_3_stacktrace", r4);
        String r9 = r7.toString();
        Intrinsics.checkNotNullExpressionValue(r9, "JSONObject().apply {\n   …ray)\n        }.toString()");
        return r9;
    }

    private final void startActivityIfExist(Context r2, Intent r3) {
        if (r2.getPackageManager().resolveActivity(r3, 65536) == null) goto L6;
        r2.startActivity(r3);
        return;
    }
}
