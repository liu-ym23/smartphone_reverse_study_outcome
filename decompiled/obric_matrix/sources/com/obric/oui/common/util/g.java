package com.obric.oui.common.util;

import android.content.Context;
import android.content.res.Resources;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f10945a = null;

    static {
        f10945a = new g();
    }

    private g() {
    }

    public final boolean a(Context r3) {
        o.f(r3, "context");
        Resources r4 = r3.getResources();     // Catch: Exception -> L7
        o.e(r4, "context.resources");     // Catch: Exception -> L7
        if (r4.getConfiguration().orientation != 2) goto L12;
        return true;
    L12:
        return false;
    L7:
        e = move-exception;
        d.g.d.f.f.b.c("ResourceUtils", "isLandscape error", e);
        return false;
    }
}
