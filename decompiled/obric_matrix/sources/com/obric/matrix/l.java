package com.obric.matrix;

import kotlin.Metadata;
import kotlin.v;
import kotlin.w;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/matrix/EnvUtils;", "", "()V", "getCurrChannel", "", "getOSVersion", "isReleaseChannel", "", "app_matrix_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f9107a = null;

    static {
        f9107a = new l();
    }

    private l() {
    }

    private final String b() {
        Object r2 = "";
        v.a r0 = v.f21457g;     // Catch: Throwable -> L5
        Object r1 = d.b.w.a.d.e.a("ro.os.ota.version", "");     // Catch: Throwable -> L5
        v.b(r1);     // Catch: Throwable -> L5
    L8:
        if (v.f(r1) == true) goto L12;
        r2 = r1;
    L12:
        return (String) r2;
    L5:
        th = move-exception;
        v.a r3 = v.f21457g;
        r1 = w.a(th);
        v.b(r1);
        goto L8
    }

    public final String a() {
        if (c() == false) goto L6;
        return "release";
    L6:
        return "dev";
    }

    public final boolean c() {
        return kotlin.u0.k.F(b(), "release", false, 2, null);
    }
}
