package com.tencent.wcdb;

/* JADX INFO: loaded from: classes5.dex */
public class CursorIndexOutOfBoundsException extends IndexOutOfBoundsException {
    public CursorIndexOutOfBoundsException(int r3, int r4) {
        super("Index " + r3 + " requested, with a size of " + r4);
    }

    public CursorIndexOutOfBoundsException(String r1) {
        super(r1);
    }
}
