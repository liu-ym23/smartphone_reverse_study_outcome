package cz.msebera.android.httpclient.util;

import cz.msebera.android.httpclient.protocol.HTTP;
import java.io.Serializable;
import java.nio.CharBuffer;

/* JADX INFO: loaded from: classes5.dex */
public final class CharArrayBuffer implements CharSequence, Serializable {
    private static final long serialVersionUID = -6208952725094867135L;
    private char[] buffer;
    private int len;

    public CharArrayBuffer(int r2) {
        Args.notNegative(r2, "Buffer capacity");
        this.buffer = new char[r2];
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
        throw new IndexOutOfBoundsException("off: " + r5 + " len: " + r6 + " b.length: " + r4.length);
    }

    public void append(String r6) {
        if (r6 != null) goto L5;
        r6 = "null";
    L5:
        int r0 = r6.length();
        int r1 = this.len + r0;
        if (r1 <= this.buffer.length) goto L8;
        expand(r1);
    L8:
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
        this.buffer[r1] = (char) (r4[r5] & 255);
        r5 = r5 + 1;
        r1 = r1 + 1;
        goto L17
    L19:
        this.len = r7;
        return;
    L22:
        throw new IndexOutOfBoundsException("off: " + r5 + " len: " + r6 + " b.length: " + r4.length);
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

    @Override // java.lang.CharSequence
    public char charAt(int r1) {
        return this.buffer[r1];
    }

    public char[] buffer() {
        return this.buffer;
    }

    public int capacity() {
        return this.buffer.length;
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.len;
    }

    public void ensureCapacity(int r3) {
        if (r3 > 0) goto L4;
        return;
    L4:
        int r0 = this.buffer.length;
        int r1 = this.len;
        if (r3 <= (r0 - r1)) goto L8;
        expand(r1 + r3);
        return;
    }

    public void setLength(int r4) {
        if (r4 < 0) goto L8;
        if (r4 > this.buffer.length) goto L8;
        this.len = r4;
        return;
    L8:
        throw new IndexOutOfBoundsException("len: " + r4 + " < 0 or > buffer len: " + this.buffer.length);
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

    public String substring(int r3, int r4) {
        if (r3 < 0) goto L13;
        if (r4 > this.len) goto L11;
        if (r3 > r4) goto L9;
        return new String(this.buffer, r3, r4 - r3);
    L9:
        throw new IndexOutOfBoundsException("beginIndex: " + r3 + " > endIndex: " + r4);
    L11:
        throw new IndexOutOfBoundsException("endIndex: " + r4 + " > length: " + this.len);
    L13:
        throw new IndexOutOfBoundsException("Negative beginIndex: " + r3);
    }

    public String substringTrimmed(int r3, int r4) {
        if (r3 < 0) goto L21;
        if (r4 > this.len) goto L19;
        if (r3 > r4) goto L17;
    L6:
        if (r3 >= r4) goto L10;
        if (HTTP.isWhitespace(this.buffer[r3]) == false) goto L10;
        r3 = r3 + 1;
    L10:
        if (r4 <= r3) goto L15;
        if (HTTP.isWhitespace(this.buffer[r4 - 1]) == false) goto L15;
        r4 = r4 - 1;
    L15:
        return new String(this.buffer, r3, r4 - r3);
    L17:
        throw new IndexOutOfBoundsException("beginIndex: " + r3 + " > endIndex: " + r4);
    L19:
        throw new IndexOutOfBoundsException("endIndex: " + r4 + " > length: " + this.len);
    L21:
        throw new IndexOutOfBoundsException("Negative beginIndex: " + r3);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int r3, int r4) {
        if (r3 < 0) goto L13;
        if (r4 > this.len) goto L11;
        if (r3 > r4) goto L9;
        return CharBuffer.wrap(this.buffer, r3, r4);
    L9:
        throw new IndexOutOfBoundsException("beginIndex: " + r3 + " > endIndex: " + r4);
    L11:
        throw new IndexOutOfBoundsException("endIndex: " + r4 + " > length: " + this.len);
    L13:
        throw new IndexOutOfBoundsException("Negative beginIndex: " + r3);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return new String(this.buffer, 0, this.len);
    }
}
