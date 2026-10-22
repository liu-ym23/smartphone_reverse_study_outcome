package com.obric.matrix.r.e;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/matrix/common_utils/utils/PowerUtils;", "", "()V", "TAG", "", "getPowerManager", "Landroid/os/PowerManager;", "isDozeMode", "", "isScreenOn", "common_utils_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f9943a = null;

    static {
        f9943a = new j();
    }

    private j() {
    }

    private final PowerManager a() {
        Context r1 = com.obric.matrix.r.a.c();
        if (r1 == null) goto L5;
        Object r2 = r1.getSystemService("power");
    L7:
        return (PowerManager) r2;
    L5:
        r2 = null;
        goto L7
    }

    public static final boolean b() {
        PowerManager r0 = f9943a.a();
        if (r0 != null) goto L6;
        com.obric.matrix.r.c.c.f("PowerUtils", "isDozeMode, powerManager is null");
        return false;
    L6:
        if (Build.VERSION.SDK_INT < 33) goto L13;
        if (r0.isDeviceLightIdleMode() == false) goto L10;
    L11:
        return true;
    L10:
        if (r0.isDeviceIdleMode() == true) goto L11;
        return false;
    L13:
        return r0.isDeviceIdleMode();
    }

    public static final boolean c() {
        PowerManager r0 = f9943a.a();
        if (r0 != null) goto L6;
        com.obric.matrix.r.c.c.f("PowerUtils", "isScreenOn, powerManager is null");
        return false;
    L6:
        return r0.isInteractive();
    }
}
