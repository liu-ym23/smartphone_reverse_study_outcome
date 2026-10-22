package com.bytedance.android.sdk.bdticketguard.m1;

import com.bytedance.android.sdk.bdticketguard.s0;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final /* synthetic */ byte[] a(byte[] r0) {
        return b(r0);
    }

    private static final byte[] b(byte[] r3) {
        return MessageDigest.getInstance("SHA-256").digest(r3);
    L4:
        e = move-exception;
        s0.f1065a.c("AttestSignSha256", "Exception during sha256", e);
        return null;
    }
}
