package com.google.crypto.tink.subtle;

import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.Ed25519;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.signature.Ed25519Parameters;
import com.google.crypto.tink.signature.Ed25519PublicKey;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class Ed25519Verify implements PublicKeyVerify {
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = null;
    public static final int PUBLIC_KEY_LEN = 32;
    public static final int SIGNATURE_LEN = 64;
    private final byte[] messageSuffix;
    private final byte[] outputPrefix;
    private final com.google.crypto.tink.util.Bytes publicKey;

    static {
        FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    }

    public static PublicKeyVerify create(Ed25519PublicKey key) throws GeneralSecurityException {
        if (FIPS.isCompatible() == false) goto L11;
        byte[] r1 = key.getPublicKeyBytes().toByteArray();
        byte[] r2 = key.getOutputPrefix().toByteArray();
        if (key.getParameters().getVariant().equals(Ed25519Parameters.Variant.LEGACY) == false) goto L7;
        byte[] r4 = {0};
    L9:
        return new Ed25519Verify(r1, r2, r4);
    L7:
        r4 = new byte[0];
        goto L9
    L11:
        throw new GeneralSecurityException("Can not use Ed25519 in FIPS-mode.");
    }

    public Ed25519Verify(final byte[] publicKey) {
        this(publicKey, new byte[0], new byte[0]);
    }

    private Ed25519Verify(final byte[] publicKey, final byte[] outputPrefix, final byte[] messageSuffix) {
        if (FIPS.isCompatible() == false) goto L11;
        if (publicKey.length != 32) goto L9;
        this.publicKey = com.google.crypto.tink.util.Bytes.copyFrom(publicKey);
        this.outputPrefix = outputPrefix;
        this.messageSuffix = messageSuffix;
        Ed25519.init();
        return;
    L9:
        throw new IllegalArgumentException(String.format("Given public key's length is not %s.", new Object[]{32}));
    L11:
        throw new IllegalStateException(new GeneralSecurityException("Can not use Ed25519 in FIPS-mode."));
    }

    private void noPrefixVerify(byte[] signature, byte[] data) throws GeneralSecurityException {
        if (signature.length != 64) goto L10;
        if (Ed25519.verify(data, signature, this.publicKey.toByteArray()) == false) goto L8;
        return;
    L8:
        throw new GeneralSecurityException("Signature check failed.");
    L10:
        throw new GeneralSecurityException(String.format("The length of the signature is not %s.", new Object[]{64}));
    }

    @Override // com.google.crypto.tink.PublicKeyVerify
    public void verify(final byte[] signature, final byte[] data) throws GeneralSecurityException {
        byte[] r0 = this.outputPrefix;
        if (r0.length != 0) goto L9;
        if (this.messageSuffix.length != 0) goto L9;
        noPrefixVerify(signature, data);
        return;
    L9:
        if (Util.isPrefix(r0, signature) == false) goto L16;
        byte[] r1 = this.messageSuffix;
        if (r1.length == 0) goto L13;
        data = Bytes.concat(new byte[][]{data, r1});
    L13:
        noPrefixVerify(Arrays.copyOfRange(signature, this.outputPrefix.length, signature.length), data);
        return;
    L16:
        throw new GeneralSecurityException("Invalid signature (output prefix mismatch)");
    }
}
