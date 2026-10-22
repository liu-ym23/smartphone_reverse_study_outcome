package com.obric.oui.utils.log;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class L {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AndroidLogger f313a = null;
    public static final int b = 0;

    @Metadata
    public interface Logger {

        @Metadata
        public static final class DefaultImpls {
        }
    }

    static {
        f313a = new AndroidLogger();
        b = 31;
    }

    public static final void a(String r3, String r4) {
        Intrinsics.f(r3, "tag");
        Intrinsics.f(r4, NotificationCompat.CATEGORY_MESSAGE);
        e(r3, 2, r4, null, 24);
    }

    public static final void b(String r3, String r4) {
        Intrinsics.f(r4, NotificationCompat.CATEGORY_MESSAGE);
        e(r3, 16, r4, null, 24);
    }

    public static final void c(String r1, String r2, Exception r3) {
        Intrinsics.f(r1, "tag");
        Intrinsics.f(r2, NotificationCompat.CATEGORY_MESSAGE);
        e(r1, 16, r2, r3, 16);
    }

    public static final void d(String r3, String r4) {
        Intrinsics.f(r3, "tag");
        Intrinsics.f(r4, NotificationCompat.CATEGORY_MESSAGE);
        e(r3, 4, r4, null, 24);
    }

    public static void e(String r0, int r1, String r2, Exception r3, int r4) {
        if ((r4 & 8) == 0) goto L6;
        r3 = null;
    L6:
        if ((b & r1) == 0) goto L10;
        f313a.a(r0, r1, r2, r3);
        return;
    }

    public static final void f(String r3, String r4) {
        Intrinsics.f(r3, "tag");
        Intrinsics.f(r4, NotificationCompat.CATEGORY_MESSAGE);
        e(r3, 1, r4, null, 24);
    }

    public static final void g(String r3, String r4) {
        Intrinsics.f(r3, "tag");
        Intrinsics.f(r4, NotificationCompat.CATEGORY_MESSAGE);
        e(r3, 8, r4, null, 24);
    }
}
