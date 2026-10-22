package com.bytedance.securityserver.robotspolicy;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.securityserver.adapter.SecurityLibFactory;
import com.bytedance.securityserver.adapter.api.ISecurityConfig;
import com.bytedance.securityserver.policy.RobotsPolicy;
import com.bytedance.securityserver.policy.RobotsPolicyData;
import com.bytedance.securityserver.utils.GlobalContext;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

/* JADX INFO: loaded from: classes.dex */
public final class RobotsPolicyUtils {
    private static final int DEFAULT_ROBOTS_STATUS = -1;
    static final String KEY_ROBOTS_ENABLED = "robots_protocol_enabled";
    private static final int MAX_RETRY_COUNT = 3;
    private static final int RETRY_DELAY_MS = 5000;
    private static final int ROBOTS_STATUS_DISABLED = 0;
    private static final int ROBOTS_STATUS_ENABLED = 1;
    private static final String TAG = "RobotsPolicyUtils";

    private RobotsPolicyUtils() {
    }

    public static /* synthetic */ void a(String r0, int r1, int r2) {
        lambda$updateToFramework$0(r0, r1, r2);
    }

    public static boolean isRobotsEnbled(Context r2) {
        if (r2 != null) goto L6;
        return true;
    L6:
        if (Settings.Secure.getInt(r2.getContentResolver(), KEY_ROBOTS_ENABLED, 1) == 1) goto L10;
        return false;
    L10:
        return true;
    }

    private static /* synthetic */ void lambda$updateToFramework$0(String r0, int r1, int r2) {
        updateToFramework(r0, r1, r2 + 1);
    }

    private static boolean matchesIgnoreCase(String[] r4, String r5) {
        if (r4 == null) goto L15;
        if (r5 == null) goto L15;
        int r1 = r4.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L15;
        String r3 = r4[r2];
        if (r3 == null) goto L14;
        if (r3.equalsIgnoreCase(r5) == false) goto L14;
        return true;
    L14:
        r2 = r2 + 1;
    L15:
        return false;
    }

    public static boolean parseRobotsEnabled(String r2) {
        return parseRobotsEnabled(r2, Build.BRAND, Build.DEVICE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean updateRobotsPolicyConfig(String r7) {
        Context r3 = GlobalContext.f82a;
        if (r3 != null) goto L32;
        Log.w(TAG, "updateRobotsPolicyConfig: context is null");
        return false;
    L32:
        boolean r8 = parseRobotsEnabled(r7);     // Catch: Exception -> L18 JsonSyntaxException -> L20
        String r5 = TAG;     // Catch: Exception -> L18 JsonSyntaxException -> L20
        Log.d(r5, "updateRobotsPolicyConfig: parsed robotsEnabled=" + r8);     // Catch: Exception -> L18 JsonSyntaxException -> L20
        int r2 = Settings.Secure.getInt(r3.getContentResolver(), KEY_ROBOTS_ENABLED, -1);     // Catch: Exception -> L18 JsonSyntaxException -> L20
        if (r2 == (-1)) goto L9;
        Object[] r4 = true;
    L10:
        if (r2 != 1) goto L12;
        boolean r6 = true;
    L13:
        if (r4 == false) goto L22;
        if (r8 != r6) goto L22;
        Log.d(r5, "applyRobotsPolicy: status unchanged, skip update");     // Catch: Exception -> L18 JsonSyntaxException -> L20
        return true;
    L22:
        StringBuilder r9 = new StringBuilder("applyRobotsPolicy: status changed from ");     // Catch: Exception -> L18 JsonSyntaxException -> L20
        if (r4 == false) goto L25;
        Object r1 = Boolean.valueOf(r6);     // Catch: Exception -> L18 JsonSyntaxException -> L20
    L26:
        r9.append(r1);     // Catch: Exception -> L18 JsonSyntaxException -> L20
        r9.append(" to ");     // Catch: Exception -> L18 JsonSyntaxException -> L20
        r9.append(r8);     // Catch: Exception -> L18 JsonSyntaxException -> L20
        r9.append(", updating...");     // Catch: Exception -> L18 JsonSyntaxException -> L20
        Log.i(r5, r9.toString());     // Catch: Exception -> L18 JsonSyntaxException -> L20
        return updateToFramework(KEY_ROBOTS_ENABLED, r8 ? 1 : 0);
    L25:
        r1 = "unset";
        goto L26
    L12:
        r6 = false;
        goto L13
    L9:
        r4 = false;
    L20:
        e = move-exception;
        Log.e(TAG, "applyRobotsPolicy: failed to parse robots policy", e);
        return false;
    L18:
        e = move-exception;
        Log.e(TAG, "applyRobotsPolicy: unexpected error", e);
        return false;
    }

    private static boolean updateToFramework(String r1, int r2) {
        return updateToFramework(r1, r2, 0);
    }

    public static boolean parseRobotsEnabled(String r5, String r6, String r7) {
        RobotsPolicy r8 = (RobotsPolicy) new Gson().fromJson(r5, RobotsPolicy.class);
        if (r8 == null) goto L15;
        RobotsPolicyData r1 = r8.robotsPolicy;
        if (r1 == null) goto L15;
        String r2 = TAG;
        Log.d(r2, "parseRobotsEnabled: policy=" + r8 + ", localBrand=" + r6 + ", localDevice=" + r7);
        if (matchesIgnoreCase(r1.enabledBrands, r6) == false) goto L12;
        Log.i(r2, "parseRobotsEnabled: brand matched [" + r6 + "], enabled");
        return true;
    L12:
        if (matchesIgnoreCase(r1.enabledDevices, r7) == false) goto L15;
        Log.i(r2, "parseRobotsEnabled: device matched [" + r7 + "], enabled");
        return true;
    L15:
        return false;
    }

    private static boolean updateToFramework(final String r8, final int r9, final int r10) {
        ISecurityConfig r7 = SecurityLibFactory.b();     // Catch: Throwable -> L7
        if (r7 != null) goto L9;
        Log.w(TAG, "SecurityConfig unavailable (securitylib not detected), key=" + r8);     // Catch: Throwable -> L7
        return false;
    L9:
        int r5 = r7.a(r9, r8);     // Catch: Throwable -> L7
        if (r5 != 0) goto L14;
        Log.i(TAG, "updateToFramework success, key=" + r8 + ", value=" + r9);     // Catch: Throwable -> L7
        return true;
    L14:
        if (r5 == (-4)) goto L16;
    L19:
        Log.w(TAG, "updateToFramework failed, key=" + r8 + ", value=" + r9 + ", result=" + r5);     // Catch: Throwable -> L7
        return false;
    L16:
        if (r10 >= 3) goto L19;
        Log.w(TAG, "updateToFramework service not ready, retry " + (r10 + 1) + "/3, key=" + r8);     // Catch: Throwable -> L7
        new Handler(Looper.getMainLooper()).postDelayed(new a(r8, r9, r10), PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS);     // Catch: Throwable -> L7
        return false;
    L7:
        th = move-exception;
        Log.e(TAG, "updateToFramework: unexpected error, key=" + r8 + ", value=" + r9, th);
        return false;
    }
}
