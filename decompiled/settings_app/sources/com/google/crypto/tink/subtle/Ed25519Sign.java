package com.google.crypto.tink.subtle;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.Ed25519;
import com.google.crypto.tink.signature.Ed25519Parameters;
import com.google.crypto.tink.signature.Ed25519PrivateKey;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class Ed25519Sign implements PublicKeySign {
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = null;
    public static final int SECRET_KEY_LEN = 32;
    private final byte[] hashedPrivateKey;
    private final byte[] messageSuffix;
    private final byte[] outputPrefix;
    private final byte[] publicKey;

    public static final class KeyPair {
        private final byte[] privateKey;
        private final byte[] publicKey;

        private KeyPair(final byte[] publicKey, final byte[] privateKey) {
            this.publicKey = publicKey;
            this.privateKey = privateKey;
        }

        public byte[] getPublicKey() {
            byte[] r1 = this.publicKey;
            return Arrays.copyOf(r1, r1.length);
        }

        public byte[] getPrivateKey() {
            byte[] r1 = this.privateKey;
            return Arrays.copyOf(r1, r1.length);
        }

        public static KeyPair newKeyPair() throws GeneralSecurityException {
            return newKeyPairFromSeed(Random.randBytes(32));
        }

        public static KeyPair newKeyPairFromSeed(byte[] secretSeed) throws GeneralSecurityException {
            if (secretSeed.length != 32) goto L7;
            return new KeyPair(Ed25519.scalarMultWithBaseToBytes(Ed25519.getHashedScalar(secretSeed)), secretSeed);
        L7:
            throw new IllegalArgumentException(String.format("Given secret seed length is not %s", new Object[]{32}));
        }
    }

    static {
        FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    }

    public static PublicKeySign create(Ed25519PrivateKey key) throws GeneralSecurityException {
        byte[] r1 = key.getPrivateKeyBytes().toByteArray(InsecureSecretKeyAccess.get());
        byte[] r2 = key.getOutputPrefix().toByteArray();
        if (key.getParameters().getVariant().equals(Ed25519Parameters.Variant.LEGACY) == false) goto L5;
        byte[] r4 = {0};
    L7:
        return new Ed25519Sign(r1, r2, r4);
    L5:
        r4 = new byte[0];
        goto L7
    }

    private Ed25519Sign(final byte[] privateKey, final byte[] outputPrefix, final byte[] messageSuffix) throws GeneralSecurityException {
        if (FIPS.isCompatible() == false) goto L11;
        if (privateKey.length != 32) goto L9;
        byte[] r3 = Ed25519.getHashedScalar(privateKey);
        this.hashedPrivateKey = r3;
        this.publicKey = Ed25519.scalarMultWithBaseToBytes(r3);
        this.outputPrefix = outputPrefix;
        this.messageSuffix = messageSuffix;
        return;
    L9:
        throw new IllegalArgumentException(String.format("Given private key's length is not %s", new Object[]{32}));
    L11:
        throw new GeneralSecurityException("Can not use Ed25519 in FIPS-mode.");
    }

    public Ed25519Sign(final byte[] privateKey) throws GeneralSecurityException {
        this(privateKey, new byte[0], new byte[0]);
    }

    private byte[] noPrefixSign(final byte[] data) throws GeneralSecurityException {
        return Ed25519.sign(data, this.publicKey, this.hashedPrivateKey);
    }

    @Override // com.google.crypto.tink.PublicKeySign
    public byte[] sign(final byte[] data) throws GeneralSecurityException {
        byte[] r0 = this.messageSuffix;
        if (r0.length != 0) goto L5;
        byte[] r6 = noPrefixSign(data);
    L6:
        byte[] r5 = this.outputPrefix;
        if (r5.length != 0) goto L10;
        return r6;
    L10:
        return Bytes.concat(new byte[][]{r5, r6});
    L5:
        r6 = noPrefixSign(Bytes.concat(new byte[][]{data, r0}));
        goto L6
    }
}
