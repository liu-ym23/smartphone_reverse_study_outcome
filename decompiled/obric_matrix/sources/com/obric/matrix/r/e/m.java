package com.obric.matrix.r.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.provider.Settings;
import java.lang.reflect.Method;
import java.util.TimeZone;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\t\u001a\u00020\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0003J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/matrix/common_utils/utils/SystemInfoUtils;", "", "()V", "KEY_PRODUCT_GLOBAL", "", "KEY_SYSTEM_COUNT_CODE", "TAG", "keyForSerialNumber", "getDeviceSN", "getLanguage", "getProperty", "propertyName", "getSystemCountryCode", "getTimestamp", "", "getZoneName", "systemIsOverSea", "", "common_utils_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f9945a = null;

    static {
        f9945a = new m();
    }

    private m() {
    }

    @SuppressLint({"PrivateApi"})
    private final String b(String r6) {
        Class<?> r5 = Class.forName("android.os.SystemProperties");     // Catch: Exception -> L4
        kotlin.n0.d.o.e(r5, "forName(\"android.os.SystemProperties\")");     // Catch: Exception -> L4
        Method r0 = r5.getMethod("get", new Class[]{String.class});     // Catch: Exception -> L4
        kotlin.n0.d.o.e(r0, "classType.getMethod(\"get\", String::class.java)");     // Catch: Exception -> L4
        return (String) r0.invoke(r5, new Object[]{r6});
    L4:
        return null;
    }

    public final String a() {
        return b("ro.serialno");
    }

    public final String c() {
        Context r0 = com.obric.matrix.r.a.c();
        if (r0 != null) goto L13;
        return "";
    L13:
        String r1 = Settings.Global.getString(r0.getContentResolver(), "user_settings_initialized");     // Catch: Exception -> L10
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        com.obric.matrix.r.c.c.b("SystemInfoUtils", "system country code = " + r1);     // Catch: Exception -> L10
        return r1;
    L10:
        e = move-exception;
        com.obric.matrix.r.c.c.f("SystemInfoUtils", "get system country exception = " + e.getMessage());
        return "";
    }

    public final long d() {
        return System.currentTimeMillis() / 1000;
    }

    public final String e() {
        return TimeZone.getDefault().getID();
    }

    public final boolean f() {
        String r2 = b("ro.pvr.product.global");
        com.obric.matrix.r.c.c.b("SystemInfoUtils", "getGlobalProperty = " + r2);
        return kotlin.n0.d.o.a(r2, "overseas");
    }
}
