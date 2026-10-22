package com.google.crypto.tink.util;

import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.subtle.Random;
import com.google.errorprone.annotations.Immutable;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class SecretBytes {
    private final Bytes bytes;

    private SecretBytes(Bytes bytes) {
        this.bytes = bytes;
    }

    public static SecretBytes copyFrom(byte[] value, SecretKeyAccess access) {
        if (access == null) goto L6;
        return new SecretBytes(Bytes.copyFrom(value));
    L6:
        throw new NullPointerException("SecretKeyAccess required");
    }

    public static SecretBytes randomBytes(int length) {
        return new SecretBytes(Bytes.copyFrom(Random.randBytes(length)));
    }

    public byte[] toByteArray(SecretKeyAccess access) {
        if (access == null) goto L6;
        return this.bytes.toByteArray();
    L6:
        throw new NullPointerException("SecretKeyAccess required");
    }

    public int size() {
        return this.bytes.size();
    }

    public boolean equalsSecretBytes(SecretBytes other) {
        return MessageDigest.isEqual(this.bytes.toByteArray(), other.bytes.toByteArray());
    }
}
