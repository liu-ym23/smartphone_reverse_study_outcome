package com.google.crypto.tink.util;

import com.google.crypto.tink.subtle.Hex;
import com.google.errorprone.annotations.Immutable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class Bytes {
    private final byte[] data;

    public static Bytes copyFrom(final byte[] data) {
        if (data == null) goto L6;
        return copyFrom(data, 0, data.length);
    L6:
        throw new NullPointerException("data must be non-null");
    }

    public static Bytes copyFrom(byte[] data, int start, int len) {
        if (data == null) goto L9;
        if ((start + len) <= data.length) goto L7;
        len = data.length - start;
    L7:
        return new Bytes(data, start, len);
    L9:
        throw new NullPointerException("data must be non-null");
    }

    public byte[] toByteArray() {
        byte[] r3 = this.data;
        byte[] r0 = new byte[r3.length];
        System.arraycopy(r3, 0, r0, 0, r3.length);
        return r0;
    }

    public int size() {
        return this.data.length;
    }

    private Bytes(final byte[] buf, final int start, final int len) {
        byte[] r0 = new byte[len];
        this.data = r0;
        System.arraycopy(buf, start, r0, 0, len);
    }

    public boolean equals(Object o) {
        if ((o instanceof Bytes) == true) goto L7;
        return false;
    L7:
        return Arrays.equals(((Bytes) o).data, this.data);
    }

    public int hashCode() {
        return Arrays.hashCode(this.data);
    }

    public String toString() {
        return "Bytes(" + Hex.encode(this.data) + ")";
    }
}
