package com.tencent.wcdb.extension.fts;

import com.tencent.wcdb.extension.SQLiteExtension;

/* JADX INFO: loaded from: classes5.dex */
public final class MMFtsTokenizer implements SQLiteExtension {
    public static final SQLiteExtension EXTENSION = null;

    private static native void nativeInitialize(long r0, long r2);

    static {
        EXTENSION = new MMFtsTokenizer();
    }

    private MMFtsTokenizer() {
    }

    @Override // com.tencent.wcdb.extension.SQLiteExtension
    public void initialize(long r1, long r3) {
        nativeInitialize(r1, r3);
    }
}
