package com.google.crypto.tink.subtle;

import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes4.dex */
public final class Hkdf {
    public static byte[] computeHkdf(String macAlgorithm, final byte[] ikm, final byte[] salt, final byte[] info, int size) throws GeneralSecurityException {
        Mac r0 = EngineFactory.MAC.getInstance(macAlgorithm);
        if (size > (r0.getMacLength() * 255)) goto L17;
        if (salt != null) goto L6;
    L9:
        r0.init(new SecretKeySpec(new byte[r0.getMacLength()], macAlgorithm));
    L10:
        byte[] r6 = new byte[size];
        r0.init(new SecretKeySpec(r0.doFinal(ikm), macAlgorithm));
        byte[] r5 = new byte[0];
        int r1 = 1;
        int r2 = 0;
    L11:
        r0.update(r5);
        r0.update(info);
        r0.update((byte) r1);
        r5 = r0.doFinal();
        if ((r5.length + r2) >= size) goto L14;
        System.arraycopy(r5, 0, r6, r2, r5.length);
        r2 = r2 + r5.length;
        r1 = r1 + 1;
        goto L11
    L14:
        System.arraycopy(r5, 0, r6, r2, size - r2);
        return r6;
    L6:
        if (salt.length == 0) goto L9;
        r0.init(new SecretKeySpec(salt, macAlgorithm));
        goto L10
    L17:
        throw new GeneralSecurityException("size too large");
    }

    public static byte[] computeEciesHkdfSymmetricKey(final byte[] ephemeralPublicKeyBytes, final byte[] sharedSecret, String hmacAlgo, final byte[] hkdfSalt, final byte[] hkdfInfo, int keySizeInBytes) throws GeneralSecurityException {
        return computeHkdf(hmacAlgo, Bytes.concat(new byte[][]{ephemeralPublicKeyBytes, sharedSecret}), hkdfSalt, hkdfInfo, keySizeInBytes);
    }

    private Hkdf() {
    }
}
