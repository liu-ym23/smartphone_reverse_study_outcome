package com.obric.matrix.r.e;

import android.os.Build;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006J\u0018\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Lcom/obric/matrix/common_utils/utils/SystemUtils;", "", "()V", "getSerialNumber", "", "getSystemProperties", "", "key", "defaultValue", "getSystemPropertiesStr", "isBDevicesByRoProp", "", "common_utils_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f9946a = null;

    static {
        f9946a = new n();
    }

    private n() {
    }

    public final String a() {
        String r1 = Build.getSerial();     // Catch: Throwable -> L4
        kotlin.n0.d.o.e(r1, "{\n            android.os…ild.getSerial()\n        }");     // Catch: Throwable -> L4
        return r1;
    L4:
        return "pico_sn_err";
    }

    public final int b(String r7, int r8) {
        kotlin.n0.d.o.f(r7, "key");
        Object r6 = Class.forName("android.os.SystemProperties").getMethod("getInt", new Class[]{String.class, Integer.TYPE}).invoke(null, new Object[]{r7, Integer.valueOf(r8)});     // Catch: Exception -> L9
        if (r6 == null) goto L7;
        return ((Integer) r6).intValue();
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");     // Catch: Exception -> L9
    L11:
        return r8;
    }

    public final boolean c() {
        int r3 = b("ro.pxr.externalfunc", 0);
        com.obric.matrix.r.c.c.a("isBDevicesByRoProp ： " + r3);
        if (r3 == 1) goto L5;
        return false;
    L5:
        return true;
    }
}
