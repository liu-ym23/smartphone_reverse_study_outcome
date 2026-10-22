package com.android.apksig.internal.util;

/* JADX INFO: loaded from: classes.dex */
public final class Pair<A, B> {
    private final A mFirst;
    private final B mSecond;

    private Pair(A r1, B r2) {
        this.mFirst = r1;
        this.mSecond = r2;
    }

    public static <A, B> Pair<A, B> of(A r1, B r2) {
        return new Pair(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (Pair.class == r5.getClass()) goto L11;
        return false;
    L11:
        Pair r6 = (Pair) r5;
        A r2 = this.mFirst;
        if (r2 != null) goto L17;
        if (r6.mFirst == null) goto L19;
        return false;
    L19:
        B r4 = this.mSecond;
        if (r4 != null) goto L27;
        if (r6.mSecond != null) goto L25;
        return true;
    L25:
        return false;
    L27:
        return r4.equals(r6.mSecond);
    L17:
        if (r2.equals(r6.mFirst) == true) goto L19;
        return false;
    }

    public A getFirst() {
        return this.mFirst;
    }

    public B getSecond() {
        return this.mSecond;
    }

    public int hashCode() {
        A r0 = this.mFirst;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (r2 + 31) * 31;
        B r4 = this.mSecond;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }
}
