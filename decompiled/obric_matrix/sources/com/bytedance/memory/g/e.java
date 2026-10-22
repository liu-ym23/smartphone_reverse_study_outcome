package com.bytedance.memory.g;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f5035a;

    public e(byte[] r3) {
        int r0 = r3.length;
        byte[] r1 = new byte[r0];
        this.f5035a = r1;
        System.arraycopy(r3, 0, r1, 0, r0);
    }

    public byte[] a() {
        return this.f5035a;
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof e) == true) goto L7;
        return false;
    L7:
        return Arrays.equals(this.f5035a, ((e) r2).f5035a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f5035a);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("0x");
        byte[] r4 = this.f5035a;
        int r1 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        r0.append(Integer.toHexString(r4[r2] & 255));
        r2 = r2 + 1;
        goto L3
    L6:
        return r0.toString();
    }
}
