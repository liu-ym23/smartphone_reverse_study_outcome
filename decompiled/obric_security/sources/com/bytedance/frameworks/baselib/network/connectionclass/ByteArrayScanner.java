package com.bytedance.frameworks.baselib.network.connectionclass;

import com.bytedance.librarian.LibrarianImpl;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
class ByteArrayScanner {
    private int mCurrentOffset;
    private byte[] mData;
    private char mDelimiter;
    private boolean mDelimiterSet;
    private int mTotalLength;

    ByteArrayScanner() {
    }

    public ByteArrayScanner reset(byte[] r1, int r2) {
        this.mData = r1;
        this.mCurrentOffset = 0;
        this.mTotalLength = r2;
        this.mDelimiterSet = false;
        return this;
    }

    public ByteArrayScanner useDelimiter(char r1) {
        throwIfNotReset();
        this.mDelimiter = r1;
        this.mDelimiterSet = true;
        return this;
    }

    private void throwIfNotReset() {
        if (this.mData == null) goto L6;
        return;
    L6:
        throw new IllegalStateException("Must call reset first");
    }

    private void throwIfDelimiterNotSet() {
        if (this.mDelimiterSet == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Must call useDelimiter first");
    }

    public String nextString() throws NoSuchElementException {
        throwIfNotReset();
        throwIfDelimiterNotSet();
        int r0 = this.mCurrentOffset;
        int r1 = advance();
        return new String(this.mData, r0, r1);
    }

    public boolean nextStringEquals(String r6) throws NoSuchElementException {
        int r0 = this.mCurrentOffset;
        if (r6.length() == advance()) goto L5;
        return false;
    L5:
        int r1 = 0;
    L7:
        if (r1 >= r6.length()) goto L12;
        if (r6.charAt(r1) != this.mData[r0]) goto L10;
        r0 = r0 + 1;
        r1 = r1 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    public int nextInt() throws NoSuchElementException {
        throwIfNotReset();
        throwIfDelimiterNotSet();
        int r0 = this.mCurrentOffset;
        int r1 = advance();
        return parseInt(this.mData, r0, r1 + r0);
    }

    public void skip() throws NoSuchElementException {
        throwIfNotReset();
        throwIfDelimiterNotSet();
        advance();
    }

    private int advance() throws NoSuchElementException {
        throwIfNotReset();
        throwIfDelimiterNotSet();
        int r0 = this.mTotalLength;
        int r1 = this.mCurrentOffset;
        if (r0 <= r1) goto L11;
        int r2 = indexOf(this.mData, r1, r0, this.mDelimiter);
        if (r2 != (-1)) goto L8;
        int r3 = this.mTotalLength;
        int r4 = r3 - this.mCurrentOffset;
        this.mCurrentOffset = r3;
        return r4;
    L8:
        int r5 = r2 - this.mCurrentOffset;
        this.mCurrentOffset = r2 + 1;
        return r5;
    L11:
        throw new NoSuchElementException("Reading past end of input stream at " + this.mCurrentOffset + LibrarianImpl.Constants.DOT);
    }

    private static int parseInt(byte[] r3, int r4, int r5) throws NumberFormatException {
        int r0 = 0;
    L3:
        if (r4 >= r5) goto L11;
        int r1 = r4 + 1;
        int r6 = r3[r4] - 48;
        if (r6 < 0) goto L10;
        if (r6 > 9) goto L10;
        r0 = (r0 * 10) + r6;
        r4 = r1;
    L10:
        throw new NumberFormatException("Invalid int in buffer at " + (r1 - 1) + LibrarianImpl.Constants.DOT);
    L11:
        return r0;
    }

    private static int indexOf(byte[] r1, int r2, int r3, char r4) {
    L2:
        if (r2 >= r3) goto L7;
        if (r1[r2] == r4) goto L5;
        r2 = r2 + 1;
        goto L2
    L5:
        return r2;
    L7:
        return -1;
    }
}
