package com.bytedance.badger.k;

import java.util.List;
import kotlin.i0.r;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<String> f2621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<String> f2622b;

    /* JADX WARN: Multi-variable type inference failed */
    public d() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public d(List<String> r2, List<String> r3) {
        o.g(r2, "ipv4AddressList");
        o.g(r3, "ipv6AddressList");
        this.f2621a = r2;
        this.f2622b = r3;
    }

    public /* synthetic */ d(List r1, List r2, int r3, g r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r.g();
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = r.g();
    L8:
        this(r1, r2);
    }

    public final List<String> a() {
        return this.f2621a;
    }

    public final List<String> b() {
        return this.f2622b;
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof d) == false) goto L10;
        d r4 = (d) r3;
        if (o.a(this.f2621a, r4.f2621a) == true) goto L8;
        return false;
    L8:
        if (o.a(this.f2622b, r4.f2622b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        List<String> r0 = this.f2621a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<String> r4 = this.f2622b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "IPAddressInfo(ipv4AddressList=" + this.f2621a + ", ipv6AddressList=" + this.f2622b + ")";
    }
}
