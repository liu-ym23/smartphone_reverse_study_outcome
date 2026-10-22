package com.ttnet.org.chromium.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
public class ByteArrayGenerator {
    public ByteArrayGenerator() {
    }

    public byte[] getBytes(int r3) throws IOException, GeneralSecurityException {
        FileInputStream r0 = new FileInputStream("/dev/urandom");     // Catch: Throwable -> L12
        byte[] r2 = new byte[r3];     // Catch: Throwable -> L10
        if (r3 != r0.read(r2)) goto L9;
        r0.close();
        return r2;
    L9:
        throw new GeneralSecurityException("Not enough random data available");     // Catch: Throwable -> L10
    L10:
        Throwable th = th;
    L14:
        if (r0 == null) goto L16;
        r0.close();
    L16:
        throw th;
    L12:
        th = move-exception;
        r0 = null;
        th = th;
        goto L14
    }
}
