package com.bytedance.android.sdk.bdticketguard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f1072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<t0> f1073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f1074c;

    public u0(String r1, int r2, List<t0> r3, String r4) {
        this.f1072a = r2;
        this.f1073b = Collections.unmodifiableList(new ArrayList(r3));
        this.f1074c = r4;
    }

    public String a() {
        return this.f1074c;
    }

    public List<t0> b() {
        return this.f1073b;
    }

    public int c() {
        return this.f1072a;
    }

    public boolean d() {
        int r1 = this.f1072a;
        if (r1 >= 200) goto L5;
    L7:
        return false;
    L5:
        if (r1 >= 300) goto L7;
        return true;
    }
}
