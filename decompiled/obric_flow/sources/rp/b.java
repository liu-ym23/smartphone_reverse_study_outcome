package rp;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f21793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f21794b = null;

    static {
        f21794b = new a();
    }

    public static void a(String r5) {
        Intrinsics.checkNotNullParameter("SmoothCornerHelper", "tag");
        Intrinsics.checkNotNullParameter(r5, "msg");
        if (f21793a == null) goto L5;
        a.a(r5, null);
        return;
    L5:
        a.a(r5, null);
    }
}
