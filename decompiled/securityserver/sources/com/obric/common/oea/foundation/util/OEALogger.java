package com.obric.common.oea.foundation.util;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OEALogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static OEALogger$defaultLogger$1 f149a;
    public static final OEALogger$defaultLogger$1 b = null;

    static {
        b = new OEALogger$defaultLogger$1();
    }

    public static void a(String r1, String r2) {
        Intrinsics.f(r1, "tag");
        Intrinsics.f(r2, NotificationCompat.CATEGORY_MESSAGE);
        if (f149a == null) goto L6;
        Log.d("OEA_SDK", r1 + "->" + r2);
        return;
    }

    public static void b(String r2) {
        Intrinsics.f(r2, NotificationCompat.CATEGORY_MESSAGE);
        OEALogger$defaultLogger$1 r0 = f149a;
        if (r0 == null) goto L5;
        r0.a(r2, null);
        return;
    L5:
        b.a(r2, null);
    }

    public static void c(String r2) {
        Intrinsics.f(r2, NotificationCompat.CATEGORY_MESSAGE);
        OEALogger$defaultLogger$1 r0 = f149a;
        if (r0 == null) goto L6;
        r0.b("AnimatableRunner", r2);
        return;
    }

    public static void d(String r1, String r2) {
        Intrinsics.f(r2, NotificationCompat.CATEGORY_MESSAGE);
        OEALogger$defaultLogger$1 r0 = f149a;
        if (r0 == null) goto L5;
        r0.b(r1, r2);
        return;
    L5:
        b.b(r1, r2);
    }

    public static void e(String r1) {
        Intrinsics.f(r1, NotificationCompat.CATEGORY_MESSAGE);
        if (f149a == null) goto L6;
        Log.v("OEA_SDK", "AnimationLifecycleListener->".concat(r1));
        return;
    }
}
