package com.bytedance.feedbackerlib.model.e;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f4617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4619c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<c> f4620d;

    public c(long r1, String r3, int r4, c r5, List<c> r6) {
        this.f4617a = r1;
        this.f4618b = r3;
        this.f4619c = r4;
        this.f4620d = r6;
    }

    public static c a(@Nullable c r9, @NonNull com.bytedance.feedbackerlib.model.d.a r10) {
        ArrayList r7 = new ArrayList();
        c r8 = new c(r10.f4607a, r10.f4608b, r10.f4610d, r9, r7);
        List<com.bytedance.feedbackerlib.model.d.a> r11 = r10.f4609c;
        if (r11 == null) goto L8;
        Iterator<com.bytedance.feedbackerlib.model.d.a> r12 = r11.iterator();
    L6:
        if (r12.hasNext() == false) goto L8;
        r7.add(a(r8, r12.next()));
    L8:
        return r8;
    }

    public boolean equals(@Nullable Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (r3 != null) goto L7;
        return false;
    L7:
        if (c.class == r3.getClass()) goto L10;
        return false;
    L10:
        return this.f4618b.equals(((c) r3).f4618b);
    }

    public int hashCode() {
        return ((217 + this.f4618b.hashCode()) * 31) + this.f4619c;
    }
}
