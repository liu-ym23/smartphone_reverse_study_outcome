package com.ss.android.account.group_onekey.d;

import com.ss.android.account.group_onekey.c.c;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {
    public b() {
    }

    public static /* synthetic */ void b(b r0, c r1, boolean r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        r0.a(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onResult");
    }

    public abstract void a(c r1, boolean r2);
}
