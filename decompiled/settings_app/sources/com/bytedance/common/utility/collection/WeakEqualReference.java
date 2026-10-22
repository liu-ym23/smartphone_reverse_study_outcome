package com.bytedance.common.utility.collection;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public class WeakEqualReference<T> extends WeakReference<T> {
    int hash;

    public WeakEqualReference(T r1) {
        super(r1);
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        this.hash = r2;
        return;
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public boolean equals(Object r3) {
        if ((r3 instanceof WeakEqualReference) == true) goto L5;
        return false;
    L5:
        Object r2 = super.get();
        Object r4 = ((WeakEqualReference) r3).get();
        if (r2 != null) goto L10;
        if (r2 != r4) goto L11;
        return true;
    L11:
        return false;
    L10:
        return r2.equals(r4);
    }

    public int hashCode() {
        return this.hash;
    }
}
