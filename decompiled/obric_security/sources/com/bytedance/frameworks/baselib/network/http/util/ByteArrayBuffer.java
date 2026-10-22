package com.bytedance.frameworks.baselib.network.http.util;

/* JADX INFO: loaded from: classes.dex */
public final class ByteArrayBuffer {
    private byte[] buffer;
    private int len;

    public ByteArrayBuffer(int r1) {
        if (r1 < 0) goto L7;
        this.buffer = new byte[r1];
        return;
    L7:
        throw new IllegalArgumentException("Buffer capacity may not be negative");
    }

    private void expand(int r4) {
        byte[] r5 = new byte[Math.max(this.buffer.length << 1, r4)];
        System.arraycopy(this.buffer, 0, r5, 0, this.len);
        this.buffer = r5;
    }

    public void append(byte[] r4, int r5, int r6) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r5 < 0) goto L20;
        if (r5 > r4.length) goto L20;
        if (r6 < 0) goto L20;
        int r0 = r5 + r6;
        if (r0 < 0) goto L20;
        if (r0 > r4.length) goto L20;
        if (r6 != 0) goto L14;
        return;
    L14:
        int r1 = this.len + r6;
        if (r1 <= this.buffer.length) goto L17;
        expand(r1);
    L17:
        System.arraycopy(r4, r5, this.buffer, this.len, r6);
        this.len = r1;
        return;
    L20:
        throw new IndexOutOfBoundsException();
    }

    public void append(int r4) {
        int r0 = this.len + 1;
        if (r0 <= this.buffer.length) goto L5;
        expand(r0);
    L5:
        this.buffer[this.len] = (byte) r4;
        this.len = r0;
    }

    public void append(char[] r4, int r5, int r6) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r5 < 0) goto L22;
        if (r5 > r4.length) goto L22;
        if (r6 < 0) goto L22;
        int r0 = r5 + r6;
        if (r0 < 0) goto L22;
        if (r0 > r4.length) goto L22;
        if (r6 != 0) goto L14;
        return;
    L14:
        int r1 = this.len;
        int r7 = r6 + r1;
        if (r7 <= this.buffer.length) goto L17;
        expand(r7);
    L17:
        if (r1 >= r7) goto L19;
        this.buffer[r1] = (byte) r4[r5];
        r5 = r5 + 1;
        r1 = r1 + 1;
        goto L17
    L19:
        this.len = r7;
        return;
    L22:
        throw new IndexOutOfBoundsException();
    }

    public void append(CharArrayBuffer r1, int r2, int r3) {
        if (r1 != null) goto L4;
        return;
    L4:
        append(r1.buffer(), r2, r3);
    }

    public void clear() {
        this.len = 0;
    }

    public byte[] toByteArray() {
        int r0 = this.len;
        byte[] r1 = new byte[r0];
        if (r0 <= 0) goto L5;
        System.arraycopy(this.buffer, 0, r1, 0, r0);
    L5:
        return r1;
    }

    public int byteAt(int r1) {
        return this.buffer[r1];
    }

    public int capacity() {
        return this.buffer.length;
    }

    public int length() {
        return this.len;
    }

    public byte[] buffer() {
        return this.buffer;
    }

    public void setLength(int r2) {
        if (r2 < 0) goto L8;
        if (r2 > this.buffer.length) goto L8;
        this.len = r2;
        return;
    L8:
        throw new IndexOutOfBoundsException();
    }

    public boolean isEmpty() {
        if (this.len != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isFull() {
        if (this.len != this.buffer.length) goto L5;
        return true;
    L5:
        return false;
    }
}
