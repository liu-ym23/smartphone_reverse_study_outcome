package com.obric.matrix.r.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/matrix/common_utils/utils/PackageUtils;", "", "()V", "TAG", "", "getInstalledVersionCode", "", "packageName", "common_utils_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f9942a = null;

    static {
        f9942a = new i();
    }

    private i() {
    }

    public final long a(String r5) {
        kotlin.n0.d.o.f(r5, "packageName");
        Context r0 = com.obric.matrix.r.a.c();
        if (r0 != null) goto L6;
        return -1;
    L6:
        long r1 = 0;
        PackageInfo r2 = r0.getPackageManager().getPackageInfo(r5, 0);     // Catch: Exception -> L12
        if (r2 != null) goto L10;
        com.obric.matrix.r.c.c.f("PackageManagerUtils", "the packageInfo for " + r5 + " is null");     // Catch: Exception -> L12
    L15:
    L13:
        com.obric.matrix.r.c.c.f("PackageManagerUtils", "the longVersionCode is " + r1);
        return r1;
    L10:
        r1 = r2.getLongVersionCode();     // Catch: Exception -> L12
    L12:
        com.obric.matrix.r.c.c.f("PackageManagerUtils", "the exception is occurred when getPackageInfo for " + r5);
        goto L13
    }
}
