package com.google.crypto.tink.util;

import com.google.crypto.tink.SecretKeyAccess;
import com.google.errorprone.annotations.Immutable;
import java.math.BigInteger;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class SecretBigInteger {
    private final BigInteger value;

    private SecretBigInteger(BigInteger value) {
        this.value = value;
    }

    public static SecretBigInteger fromBigInteger(BigInteger value, SecretKeyAccess access) {
        if (access == null) goto L6;
        return new SecretBigInteger(value);
    L6:
        throw new NullPointerException("SecretKeyAccess required");
    }

    public BigInteger getBigInteger(SecretKeyAccess access) {
        if (access == null) goto L6;
        return this.value;
    L6:
        throw new NullPointerException("SecretKeyAccess required");
    }

    public boolean equalsSecretBigInteger(SecretBigInteger other) {
        return MessageDigest.isEqual(this.value.toByteArray(), other.value.toByteArray());
    }
}
