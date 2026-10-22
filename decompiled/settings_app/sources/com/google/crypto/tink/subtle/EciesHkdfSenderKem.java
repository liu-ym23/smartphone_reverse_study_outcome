package com.google.crypto.tink.subtle;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;

/* JADX INFO: loaded from: classes4.dex */
public final class EciesHkdfSenderKem {
    private final ECPublicKey recipientPublicKey;

    public static final class KemKey {
        private final com.google.crypto.tink.util.Bytes kemBytes;
        private final com.google.crypto.tink.util.Bytes symmetricKey;

        public KemKey(final byte[] kemBytes, final byte[] symmetricKey) {
            if (kemBytes == null) goto L10;
            if (symmetricKey == null) goto L8;
            this.kemBytes = com.google.crypto.tink.util.Bytes.copyFrom(kemBytes);
            this.symmetricKey = com.google.crypto.tink.util.Bytes.copyFrom(symmetricKey);
            return;
        L8:
            throw new NullPointerException("symmetricKey must be non-null");
        L10:
            throw new NullPointerException("KemBytes must be non-null");
        }

        public byte[] getKemBytes() {
            return this.kemBytes.toByteArray();
        }

        public byte[] getSymmetricKey() {
            return this.symmetricKey.toByteArray();
        }
    }

    public EciesHkdfSenderKem(final ECPublicKey recipientPublicKey) {
        this.recipientPublicKey = recipientPublicKey;
    }

    public KemKey generateKey(String hmacAlgo, final byte[] hkdfSalt, final byte[] hkdfInfo, int keySizeInBytes, EllipticCurves.PointFormatType pointFormat) throws GeneralSecurityException {
        KeyPair r0 = EllipticCurves.generateKeyPair(this.recipientPublicKey.getParams());
        ECPublicKey r1 = (ECPublicKey) r0.getPublic();
        byte[] r3 = EllipticCurves.computeSharedSecret((ECPrivateKey) r0.getPrivate(), this.recipientPublicKey);
        byte[] r8 = EllipticCurves.pointEncode(r1.getParams().getCurve(), pointFormat, r1.getW());
        return new KemKey(r8, Hkdf.computeEciesHkdfSymmetricKey(r8, r3, hmacAlgo, hkdfSalt, hkdfInfo, keySizeInBytes));
    }
}
