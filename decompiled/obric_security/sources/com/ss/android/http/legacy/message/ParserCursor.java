package com.ss.android.http.legacy.message;

import com.bytedance.frameworks.baselib.network.http.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class ParserCursor {
    private final int lowerBound;
    private int pos;
    private final int upperBound;

    public ParserCursor(int r1, int r2) {
        if (r1 < 0) goto L10;
        if (r1 > r2) goto L8;
        this.lowerBound = r1;
        this.upperBound = r2;
        this.pos = r1;
        return;
    L8:
        throw new IndexOutOfBoundsException("Lower bound cannot be greater then upper bound");
    L10:
        throw new IndexOutOfBoundsException("Lower bound cannot be negative");
    }

    public int getLowerBound() {
        return this.lowerBound;
    }

    public int getUpperBound() {
        return this.upperBound;
    }

    public int getPos() {
        return this.pos;
    }

    public void updatePos(int r2) {
        if (r2 < this.lowerBound) goto L11;
        if (r2 > this.upperBound) goto L9;
        this.pos = r2;
        return;
    L9:
        throw new IndexOutOfBoundsException();
    L11:
        throw new IndexOutOfBoundsException();
    }

    public boolean atEnd() {
        if (this.pos < this.upperBound) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        CharArrayBuffer r0 = new CharArrayBuffer(16);
        r0.append('[');
        r0.append(Integer.toString(this.lowerBound));
        r0.append('>');
        r0.append(Integer.toString(this.pos));
        r0.append('>');
        r0.append(Integer.toString(this.upperBound));
        r0.append(']');
        return r0.toString();
    }
}
