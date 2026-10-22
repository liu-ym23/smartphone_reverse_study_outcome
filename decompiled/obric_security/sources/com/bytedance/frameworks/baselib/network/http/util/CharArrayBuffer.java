package com.bytedance.frameworks.baselib.network.http.util;

/* JADX INFO: loaded from: classes.dex */
public final class CharArrayBuffer {
    private char[] buffer;
    private int len;

    public CharArrayBuffer(int r1) {
        if (r1 < 0) goto L7;
        this.buffer = new char[r1];
        return;
    L7:
        throw new IllegalArgumentException("Buffer capacity may not be negative");
    }

    private void expand(int r4) {
        char[] r5 = new char[Math.max(this.buffer.length << 1, r4)];
        System.arraycopy(this.buffer, 0, r5, 0, this.len);
        this.buffer = r5;
    }

    public void append(char[] r4, int r5, int r6) {
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

    public void append(String r6) {
        if (r6 != null) goto L4;
        r6 = "null";
    L4:
        int r0 = r6.length();
        int r1 = this.len + r0;
        if (r1 <= this.buffer.length) goto L7;
        expand(r1);
    L7:
        r6.getChars(0, r0, this.buffer, this.len);
        this.len = r1;
    }

    public void append(CharArrayBuffer r1, int r2, int r3) {
        if (r1 != null) goto L4;
        return;
    L4:
        append(r1.buffer, r2, r3);
    }

    public void append(CharArrayBuffer r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        append(r3.buffer, 0, r3.len);
    }

    public void append(char r4) {
        int r0 = this.len + 1;
        if (r0 <= this.buffer.length) goto L5;
        expand(r0);
    L5:
        this.buffer[this.len] = r4;
        this.len = r0;
    }

    public void append(byte[] r4, int r5, int r6) {
        if (r4 != 0) goto L4;
        return;
    L4:
        if (r5 < 0) goto L25;
        if (r5 > r4.length) goto L25;
        if (r6 < 0) goto L25;
        int r0 = r5 + r6;
        if (r0 < 0) goto L25;
        if (r0 > r4.length) goto L25;
        if (r6 != 0) goto L14;
        return;
    L14:
        int r1 = this.len;
        int r7 = r6 + r1;
        if (r7 <= this.buffer.length) goto L17;
        expand(r7);
    L17:
        if (r1 >= r7) goto L22;
        int r2 = r4[r5];
        if (r2 >= 0) goto L21;
        r2 = r2 + 256;
    L21:
        this.buffer[r1] = (char) r2;
        r5 = r5 + 1;
        r1 = r1 + 1;
        goto L17
    L22:
        this.len = r7;
        return;
    L25:
        throw new IndexOutOfBoundsException();
    }

    public void append(ByteArrayBuffer r1, int r2, int r3) {
        if (r1 != null) goto L4;
        return;
    L4:
        append(r1.buffer(), r2, r3);
    }

    public void append(Object r1) {
        append(String.valueOf(r1));
    }

    public void clear() {
        this.len = 0;
    }

    public char[] toCharArray() {
        int r0 = this.len;
        char[] r1 = new char[r0];
        if (r0 <= 0) goto L5;
        System.arraycopy(this.buffer, 0, r1, 0, r0);
    L5:
        return r1;
    }

    public char charAt(int r1) {
        return this.buffer[r1];
    }

    public char[] buffer() {
        return this.buffer;
    }

    public int capacity() {
        return this.buffer.length;
    }

    public int length() {
        return this.len;
    }

    public void ensureCapacity(int r3) {
        int r0 = this.buffer.length;
        int r1 = this.len;
        if (r3 <= (r0 - r1)) goto L6;
        expand(r1 + r3);
        return;
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

    public int indexOf(int r3, int r4, int r5) {
        if (r4 >= 0) goto L4;
        r4 = 0;
    L4:
        int r0 = this.len;
        if (r5 <= r0) goto L8;
        r5 = r0;
    L8:
        if (r4 <= r5) goto L10;
        return -1;
    L10:
        if (r4 >= r5) goto L15;
        if (this.buffer[r4] == r3) goto L13;
        r4 = r4 + 1;
        goto L10
    L13:
        return r4;
    L15:
        return -1;
    }

    public int indexOf(int r3) {
        return indexOf(r3, 0, this.len);
    }

    public String substring(int r2, int r3) {
        if (r2 < 0) goto L13;
        if (r3 > this.len) goto L11;
        if (r2 > r3) goto L9;
        return new String(this.buffer, r2, r3 - r2);
    L9:
        throw new IndexOutOfBoundsException();
    L11:
        throw new IndexOutOfBoundsException();
    L13:
        throw new IndexOutOfBoundsException();
    }

    public String substringTrimmed(int r3, int r4) {
        if (r3 < 0) goto L21;
        if (r4 > this.len) goto L19;
        if (r3 > r4) goto L17;
    L6:
        if (r3 >= r4) goto L10;
        if (UrlUtils.isWhitespace(this.buffer[r3]) == false) goto L10;
        r3 = r3 + 1;
    L10:
        if (r4 <= r3) goto L15;
        if (UrlUtils.isWhitespace(this.buffer[r4 - 1]) == false) goto L15;
        r4 = r4 - 1;
    L15:
        return new String(this.buffer, r3, r4 - r3);
    L17:
        throw new IndexOutOfBoundsException();
    L19:
        throw new IndexOutOfBoundsException();
    L21:
        throw new IndexOutOfBoundsException();
    }

    public String toString() {
        return new String(this.buffer, 0, this.len);
    }
}
