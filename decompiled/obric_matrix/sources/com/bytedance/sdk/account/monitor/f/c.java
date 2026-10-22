package com.bytedance.sdk.account.monitor.f;

import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public abstract class c implements g {
    private c() {
    }

    public /* synthetic */ c(kotlin.n0.d.g r1) {
        this();
    }

    protected final boolean b(Object r3) {
        if (r3 != null) goto L6;
        return true;
    L6:
        if ((r3 instanceof Boolean) == false) goto L12;
        if (((Boolean) r3).booleanValue() == true) goto L18;
        return true;
    L18:
        return false;
    L12:
        if ((r3 instanceof Number) == false) goto L15;
        return o.a(r3, 0);
    L15:
        if ((r3 instanceof String) == false) goto L18;
        if (((CharSequence) r3).length() != 0) goto L18;
        return true;
    }
}
