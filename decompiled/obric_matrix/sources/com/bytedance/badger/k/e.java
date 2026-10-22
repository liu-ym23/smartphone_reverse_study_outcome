package com.bytedance.badger.k;

import com.bytedance.common.wschannel.WsConstants;
import java.util.List;
import java.util.Map;
import kotlin.n0.d.o;
import kotlin.u;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f2623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<u<String, String>> f2624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, String> f2625c;

    public e(String r2, List<u<String, String>> r3, Map<String, String> r4) {
        o.g(r2, WsConstants.KEY_CONNECTION_URL);
        o.g(r3, "headers");
        o.g(r4, "body");
        this.f2623a = r2;
        this.f2624b = r3;
        this.f2625c = r4;
    }

    public final Map<String, String> a() {
        return this.f2625c;
    }

    public final List<u<String, String>> b() {
        return this.f2624b;
    }

    public final String c() {
        return this.f2623a;
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof e) == false) goto L12;
        e r4 = (e) r3;
        if (o.a(this.f2623a, r4.f2623a) == true) goto L8;
        return false;
    L8:
        if (o.a(this.f2624b, r4.f2624b) == true) goto L10;
        return false;
    L10:
        if (o.a(this.f2625c, r4.f2625c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r0 = this.f2623a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<u<String, String>> r4 = this.f2624b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Map<String, String> r7 = this.f2625c;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "RequestBundle(url=" + this.f2623a + ", headers=" + this.f2624b + ", body=" + this.f2625c + ")";
    }
}
