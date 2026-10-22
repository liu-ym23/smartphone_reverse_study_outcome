package com.bytedance.apm.util;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class n<F, S> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public F f2055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public S f2056b;

    public n(@Nullable F r1, @Nullable S r2) {
        this.f2055a = r1;
        this.f2056b = r2;
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof n) == true) goto L5;
        return false;
    L5:
        n r5 = (n) r4;
        if (m.a(r5.f2055a, this.f2055a) == true) goto L8;
        return false;
    L8:
        if (m.a(r5.f2056b, this.f2056b) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        F r0 = this.f2055a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        S r3 = this.f2056b;
        if (r3 == null) goto L11;
        r1 = r3.hashCode();
    L11:
        return r2 ^ r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f2055a) + " " + this.f2056b + "}";
    }
}
