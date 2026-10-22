package com.obric.oui.common;

import android.app.Application;
import com.obric.common.oea.foundation.util.OEALogger;
import com.obric.oui.OUISdk;
import com.obric.oui.utils.log.L;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SdkInit {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f195a;

    @Metadata
    public static final class Companion {
    }

    public SdkInit() {
        if (f195a != 0) goto L21;
        L.a("SDK_INIT", "BUILD_NO: [20260113-16:37:56|1|2b41e1df|20260113-16:36:44_Feature: OUI2.0  acceptance9]");
        OUISdk r8 = OUISdk.c;
    L15:
        e = move-exception;
        L.c("OUISdk", "init failed", e);
        goto L21
    L6:
        if (OUISdk.b == true) goto L18;
        long r3 = System.currentTimeMillis();     // Catch: Exception -> L15
        Application r5 = null;
        r5 = (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", null).invoke(null, null);     // Catch: Exception -> L11
    L13:
        if (r5 == null) goto L17;
        r5.registerComponentCallbacks(r8);     // Catch: Exception -> L15
    L17:
        OEALogger.f149a = OEALogger.b;     // Catch: Exception -> L15
        OUISdk.b = true;     // Catch: Exception -> L15
        L.a("OUISdk", "init success, cost: " + (System.currentTimeMillis() - r3) + " ms");     // Catch: Exception -> L15
        goto L21
    L11:
        e = move-exception;
        L.c("OUISdk", "getApplicationReflect failed", e);     // Catch: Exception -> L15
        goto L13
    L18:
        L.a("OUISdk", "init already");     // Catch: Exception -> L15
    L21:
        f195a++;
    }
}
