package com.android.icu.charset;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/* JADX INFO: loaded from: classes.dex */
public final class CharsetICU extends Charset {
    protected CharsetICU(String r1, String r2, String[] r3) {
        super(null, null);
        throw new RuntimeException("Stub!");
    }

    @Override // java.nio.charset.Charset
    public CharsetDecoder newDecoder() {
        throw new RuntimeException("Stub!");
    }

    @Override // java.nio.charset.Charset
    public CharsetEncoder newEncoder() {
        throw new RuntimeException("Stub!");
    }

    @Override // java.nio.charset.Charset
    public boolean contains(Charset r1) {
        throw new RuntimeException("Stub!");
    }
}
