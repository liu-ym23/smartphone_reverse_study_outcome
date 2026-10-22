package com.bytedance.securityserver.securitylog;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.securityserver.adapter.SecurityLibFactory;
import com.bytedance.securityserver.adapter.api.ISecurityConfig;
import com.bytedance.securityserver.robotspolicy.RobotsPolicyContract;
import com.bytedance.securityserver.utils.GlobalContext;
import d.a;
import d.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class SecurityLogConfigUtils {
    public static boolean a(Context r2) {
        if (r2 != null) goto L6;
        return true;
    L6:
        if (Settings.Secure.getInt(r2.getContentResolver(), "security_log_enabled", 1) == 1) goto L10;
        return false;
    L10:
        return true;
    }

    public static SecurityLogConfig b(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L22;
        return null;
    L22:
        JSONObject r2 = new JSONObject(r5);     // Catch: Exception -> L14
        if (r2.has("security_log_enabled") == true) goto L8;
    L18:
        Log.w("SecurityLogConfigUtils", "parse: missing security_log_enabled");     // Catch: Exception -> L14
        return null;
    L8:
        if (r2.isNull("security_log_enabled") == true) goto L18;
        String r6 = r2.optString(RobotsPolicyContract.COL_VERSION, "");     // Catch: Exception -> L14
        if (TextUtils.isEmpty(r6) == false) goto L16;
        Log.w("SecurityLogConfigUtils", "parse: missing version");     // Catch: Exception -> L14
        return null;
    L16:
        SecurityLogConfig r4 = new SecurityLogConfig();     // Catch: Exception -> L14
        r4.f64a = r6;     // Catch: Exception -> L14
        r4.b = c(r2.get("security_log_enabled"));     // Catch: Exception -> L14
        return r4;
    L14:
        e = move-exception;
        Log.e("SecurityLogConfigUtils", "parse failed", e);
        return null;
    }

    public static boolean c(Object r4) {
        if ((r4 instanceof Boolean) == false) goto L7;
        return ((Boolean) r4).booleanValue();
    L7:
        if ((r4 instanceof Number) == false) goto L13;
        if (((Number) r4).intValue() != 0) goto L11;
        return false;
    L11:
        return true;
    L13:
        if ((r4 instanceof String) == false) goto L26;
        String r0 = ((String) r4).trim();
        if ("1".equals(r0) == false) goto L17;
    L24:
        return true;
    L17:
        if ("true".equalsIgnoreCase(r0) == true) goto L24;
        if ("0".equals(r0) == false) goto L22;
    L23:
        return false;
    L22:
        if ("false".equalsIgnoreCase(r0) == true) goto L23;
    L26:
        throw new IllegalArgumentException(b.a(r4, "Unsupported security_log_enabled value: "));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean d(SecurityLogConfig r5) {
        Context r0 = GlobalContext.f82a;
        if (r0 != null) goto L6;
        Log.w("SecurityLogConfigUtils", "updateSecurityLogConfig: context is null");
        return false;
    L6:
        if (r5 != null) goto L9;
        Log.w("SecurityLogConfigUtils", "updateSecurityLogConfig: config is null");
        return false;
    L9:
        int r1 = Settings.Secure.getInt(r0.getContentResolver(), "security_log_enabled", -1);
        if (r1 == (-1)) goto L12;
        Object[] r4 = true;
    L13:
        if (r1 != 1) goto L15;
        boolean r2 = true;
    L16:
        if (r4 == false) goto L23;
        if (r2 != r5.b) goto L23;
        Log.d("SecurityLogConfigUtils", "updateSecurityLogConfig: status unchanged, skip update");
        return true;
    L23:
        return e(r5.b ? 1 : 0, 0);
    L15:
        r2 = false;
        goto L16
    L12:
        r4 = false;
        goto L13
    }

    public static boolean e(final int r8, final int r9) {
        ISecurityConfig r7 = SecurityLibFactory.b();     // Catch: Throwable -> L7
        if (r7 != null) goto L9;
        Log.w("SecurityLogConfigUtils", "SecurityConfig unavailable (securitylib not detected), key=security_log_enabled");     // Catch: Throwable -> L7
        return false;
    L9:
        int r3 = r7.a(r8, "security_log_enabled");     // Catch: Throwable -> L7
        if (r3 != 0) goto L14;
        Log.i("SecurityLogConfigUtils", "updateToFramework success, key=security_log_enabled, value=" + r8);     // Catch: Throwable -> L7
        return true;
    L14:
        if (r3 == (-4)) goto L16;
    L19:
        Log.w("SecurityLogConfigUtils", "updateToFramework failed, key=security_log_enabled, value=" + r8 + ", result=" + r3);     // Catch: Throwable -> L7
        return false;
    L16:
        if (r9 >= 3) goto L19;
        Log.w("SecurityLogConfigUtils", "updateToFramework service not ready, retry " + (r9 + 1) + "/3, key=security_log_enabled");     // Catch: Throwable -> L7
        new Handler(Looper.getMainLooper()).postDelayed(new a(r8, r9), PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS);     // Catch: Throwable -> L7
        return false;
    L7:
        th = move-exception;
        Log.e("SecurityLogConfigUtils", "updateToFramework: unexpected error, key=security_log_enabled, value=" + r8, th);
        return false;
    }
}
