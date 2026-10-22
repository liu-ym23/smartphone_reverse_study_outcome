package com.bytedance.badger.k;

import java.util.List;
import kotlin.n0.d.o;
import kotlin.u;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f2626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f2627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<u<String, String>> f2628c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f2629d;

    public f(boolean r2, int r3, List<u<String, String>> r4, String r5) {
        o.g(r4, "headers");
        o.g(r5, "body");
        this.f2626a = r2;
        this.f2627b = r3;
        this.f2628c = r4;
        this.f2629d = r5;
    }

    public final List<u<String, String>> a() {
        return this.f2628c;
    }

    public final int b() {
        return this.f2627b;
    }

    public final boolean c() {
        return this.f2626a;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L5;
    L22:
        return true;
    L5:
        if ((r5 instanceof f) == false) goto L21;
        f r6 = (f) r5;
        if (this.f2626a != r6.f2626a) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L21;
        if (this.f2627b != r6.f2627b) goto L14;
        boolean r2 = true;
    L15:
        if (r2 == false) goto L21;
        if (o.a(this.f2628c, r6.f2628c) == false) goto L21;
        if (o.a(this.f2629d, r6.f2629d) == false) goto L21;
    L14:
        r2 = false;
        goto L15
    L9:
        r1 = false;
    L21:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean r0 = this.f2626a;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = ((r1 * 31) + Integer.hashCode(this.f2627b)) * 31;
        List<u<String, String>> r3 = this.f2628c;
        int r4 = 0;
        if (r3 == null) goto L8;
        int r5 = r3.hashCode();
    L9:
        int r6 = (r2 + r5) * 31;
        String r7 = this.f2629d;
        if (r7 == null) goto L13;
        r4 = r7.hashCode();
    L13:
        return r6 + r4;
    L8:
        r5 = 0;
        goto L9
    }

    public String toString() {
        return "ResponseBundle(isSuccess=" + this.f2626a + ", status=" + this.f2627b + ", headers=" + this.f2628c + ", body=" + this.f2629d + ")";
    }
}
