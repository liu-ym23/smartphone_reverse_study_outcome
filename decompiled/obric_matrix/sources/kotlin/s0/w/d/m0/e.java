package kotlin.s0.w.d.m0;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
final class e<K, V> implements Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final K f21313f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final V f21314g;

    public e(K r1, V r2) {
        this.f21313f = r1;
        this.f21314g = r2;
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof e) == true) goto L5;
        return false;
    L5:
        e r5 = (e) r4;
        K r0 = this.f21313f;
        if (r0 != null) goto L11;
        if (r5.f21313f != null) goto L21;
    L12:
        V r3 = this.f21314g;
        if (r3 != null) goto L18;
        if (r5.f21314g != null) goto L23;
    L19:
        return true;
    L23:
        return false;
    L18:
        if (r3.equals(r5.f21314g) == true) goto L19;
        return false;
    L21:
        return false;
    L11:
        if (r0.equals(r5.f21313f) == true) goto L12;
        return false;
    }

    public int hashCode() {
        K r0 = this.f21313f;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        V r3 = this.f21314g;
        if (r3 == null) goto L11;
        r1 = r3.hashCode();
    L11:
        return r2 ^ r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return this.f21313f + "=" + this.f21314g;
    }
}
