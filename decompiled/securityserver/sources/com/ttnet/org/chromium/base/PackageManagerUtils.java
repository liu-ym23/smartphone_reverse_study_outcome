package com.ttnet.org.chromium.base;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.TransactionTooLargeException;
import com.bytedance.frameworks.baselib.network.http.util.HttpHost;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PackageManagerUtils {
    public static final Intent BROWSER_INTENT = null;
    private static final String TAG = "PackageManagerUtils";

    static {
        BROWSER_INTENT = new Intent().setAction("android.intent.action.VIEW").addCategory("android.intent.category.BROWSABLE").setData(Uri.fromParts(HttpHost.DEFAULT_SCHEME_NAME, "", null));
    }

    public PackageManagerUtils() {
    }

    public static boolean canResolveActivity(Intent r0, int r1) {
        return !queryIntentActivities(r0, r1).isEmpty();
    }

    public static Intent getQueryInstalledHomeLaunchersIntent() {
        return new Intent("android.intent.action.MAIN").addCategory("android.intent.category.HOME");
    }

    private static void handleExpectedExceptionsOrRethrow(RuntimeException r2, Intent r3) {
        if ((r2 instanceof NullPointerException) == false) goto L5;
    L8:
        Log.e(TAG, "Could not resolve Activity for intent " + r3.toString(), new Object[]{r2});
        return;
    L5:
        if ((r2.getCause() instanceof TransactionTooLargeException) == true) goto L8;
        throw r2;
    }

    public static List<ResolveInfo> queryAllLaunchersInfo() {
        return queryIntentActivities(getQueryInstalledHomeLaunchersIntent(), 131072);
    }

    public static List<ResolveInfo> queryAllWebBrowsersInfo() {
        return queryIntentActivities(BROWSER_INTENT, 983040);
    }

    public static List<ResolveInfo> queryIntentActivities(Intent r2, int r3) {
        StrictModeContext r0 = StrictModeContext.allowDiskReads();     // Catch: RuntimeException -> L7
        List<ResolveInfo> r4 = ContextUtils.getApplicationContext().getPackageManager().queryIntentActivities(r2, r3);     // Catch: Throwable -> L10
        if (r0 == null) goto L9;
        r0.close();     // Catch: RuntimeException -> L7
    L9:
        return r4;
    L10:
        th = move-exception;
        if (r0 != null) goto L19;
    L16:
        throw th;     // Catch: RuntimeException -> L7
    L19:
        r0.close();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.addSuppressed(th);     // Catch: RuntimeException -> L7
    L7:
        e = move-exception;
        handleExpectedExceptionsOrRethrow(e, r2);
        return Collections.emptyList();
    }

    public static ResolveInfo resolveActivity(Intent r2, int r3) {
        StrictModeContext r0 = StrictModeContext.allowDiskWrites();     // Catch: RuntimeException -> L7
        ResolveInfo r4 = ContextUtils.getApplicationContext().getPackageManager().resolveActivity(r2, r3);     // Catch: Throwable -> L10
        if (r0 == null) goto L9;
        r0.close();     // Catch: RuntimeException -> L7
    L9:
        return r4;
    L10:
        th = move-exception;
        if (r0 != null) goto L19;
    L16:
        throw th;     // Catch: RuntimeException -> L7
    L19:
        r0.close();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.addSuppressed(th);     // Catch: RuntimeException -> L7
    L7:
        e = move-exception;
        handleExpectedExceptionsOrRethrow(e, r2);
        return null;
    }

    public static ResolveInfo resolveDefaultWebBrowserActivity() {
        return resolveActivity(BROWSER_INTENT, 65536);
    }

    public static boolean canResolveActivity(Intent r1) {
        return canResolveActivity(r1, 0);
    }
}
