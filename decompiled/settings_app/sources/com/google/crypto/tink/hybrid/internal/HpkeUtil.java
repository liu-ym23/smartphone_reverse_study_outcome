package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.hybrid.HpkeParameters;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.subtle.Bytes;
import com.google.crypto.tink.subtle.EllipticCurves;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes4.dex */
public final class HpkeUtil {
    public static final byte[] AES_128_GCM_AEAD_ID = null;
    public static final byte[] AES_256_GCM_AEAD_ID = null;
    public static final byte[] AUTH_MODE = null;
    public static final byte[] BASE_MODE = null;
    public static final byte[] CHACHA20_POLY1305_AEAD_ID = null;
    public static final byte[] EMPTY_SALT = null;
    public static final byte[] HKDF_SHA256_KDF_ID = null;
    public static final byte[] HKDF_SHA384_KDF_ID = null;
    public static final byte[] HKDF_SHA512_KDF_ID = null;
    private static final byte[] HPKE = null;
    private static final byte[] HPKE_V1 = null;
    private static final byte[] KEM = null;
    public static final byte[] P256_HKDF_SHA256_KEM_ID = null;
    public static final byte[] P384_HKDF_SHA384_KEM_ID = null;
    public static final byte[] P521_HKDF_SHA512_KEM_ID = null;
    public static final byte[] X25519_HKDF_SHA256_KEM_ID = null;

    static {
        BASE_MODE = intToByteArray(1, 0);
        AUTH_MODE = intToByteArray(1, 2);
        X25519_HKDF_SHA256_KEM_ID = intToByteArray(2, 32);
        P256_HKDF_SHA256_KEM_ID = intToByteArray(2, 16);
        P384_HKDF_SHA384_KEM_ID = intToByteArray(2, 17);
        P521_HKDF_SHA512_KEM_ID = intToByteArray(2, 18);
        HKDF_SHA256_KDF_ID = intToByteArray(2, 1);
        HKDF_SHA384_KDF_ID = intToByteArray(2, 2);
        HKDF_SHA512_KDF_ID = intToByteArray(2, 3);
        AES_128_GCM_AEAD_ID = intToByteArray(2, 1);
        AES_256_GCM_AEAD_ID = intToByteArray(2, 2);
        CHACHA20_POLY1305_AEAD_ID = intToByteArray(2, 3);
        EMPTY_SALT = new byte[0];
        KEM = "KEM".getBytes(Util.UTF_8);
        HPKE = "HPKE".getBytes(Util.UTF_8);
        HPKE_V1 = "HPKE-v1".getBytes(Util.UTF_8);
    }

    public static byte[] intToByteArray(int capacity, int value) {
        if (capacity > 4) goto L17;
        if (capacity < 0) goto L17;
        if (value < 0) goto L15;
        if (capacity < 4) goto L9;
    L10:
        byte[] r0 = new byte[capacity];
        int r2 = 0;
    L11:
        if (r2 >= capacity) goto L13;
        r0[r2] = (byte) ((value >> (((capacity - r2) - 1) * 8)) & 255);
        r2 = r2 + 1;
        goto L11
    L13:
        return r0;
    L9:
        if (value < (1 << (capacity * 8))) goto L10;
    L15:
        throw new IllegalArgumentException("value too large");
    L17:
        throw new IllegalArgumentException("capacity must be between 0 and 4");
    }

    static byte[] kemSuiteId(byte[] kemId) throws GeneralSecurityException {
        return Bytes.concat(new byte[][]{KEM, kemId});
    }

    static byte[] hpkeSuiteId(byte[] kemId, byte[] kdfId, byte[] aeadId) throws GeneralSecurityException {
        return Bytes.concat(new byte[][]{HPKE, kemId, kdfId, aeadId});
    }

    static byte[] labelIkm(String label, byte[] ikm, byte[] suiteId) throws GeneralSecurityException {
        return Bytes.concat(new byte[][]{HPKE_V1, suiteId, label.getBytes(Util.UTF_8), ikm});
    }

    static byte[] labelInfo(String label, byte[] info, byte[] suiteId, int length) throws GeneralSecurityException {
        return Bytes.concat(new byte[][]{intToByteArray(2, length), HPKE_V1, suiteId, label.getBytes(Util.UTF_8), info});
    }

    static EllipticCurves.CurveType nistHpkeKemToCurve(HpkeParameters.KemId kemId) throws GeneralSecurityException {
        if (kemId != HpkeParameters.KemId.DHKEM_P256_HKDF_SHA256) goto L7;
        return EllipticCurves.CurveType.NIST_P256;
    L7:
        if (kemId != HpkeParameters.KemId.DHKEM_P384_HKDF_SHA384) goto L11;
        return EllipticCurves.CurveType.NIST_P384;
    L11:
        if (kemId != HpkeParameters.KemId.DHKEM_P521_HKDF_SHA512) goto L15;
        return EllipticCurves.CurveType.NIST_P521;
    L15:
        throw new GeneralSecurityException("Unrecognized NIST HPKE KEM identifier");
    }

    public static int getEncodedPublicKeyLength(HpkeParameters.KemId kemId) throws GeneralSecurityException {
        if (kemId != HpkeParameters.KemId.DHKEM_X25519_HKDF_SHA256) goto L7;
        return 32;
    L7:
        if (kemId != HpkeParameters.KemId.DHKEM_P256_HKDF_SHA256) goto L11;
        return 65;
    L11:
        if (kemId != HpkeParameters.KemId.DHKEM_P384_HKDF_SHA384) goto L15;
        return 97;
    L15:
        if (kemId != HpkeParameters.KemId.DHKEM_P521_HKDF_SHA512) goto L19;
        return 133;
    L19:
        throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
    }

    public static int encodingSizeInBytes(HpkeParameters.KemId kemId) {
        if (kemId != HpkeParameters.KemId.DHKEM_X25519_HKDF_SHA256) goto L7;
        return 32;
    L7:
        if (kemId != HpkeParameters.KemId.DHKEM_P256_HKDF_SHA256) goto L11;
        return 65;
    L11:
        if (kemId != HpkeParameters.KemId.DHKEM_P384_HKDF_SHA384) goto L15;
        return 97;
    L15:
        if (kemId != HpkeParameters.KemId.DHKEM_P521_HKDF_SHA512) goto L19;
        return 133;
    L19:
        throw new IllegalArgumentException("Unable to determine KEM-encoding length for " + kemId);
    }

    public static int getEncodedPrivateKeyLength(HpkeParameters.KemId kemId) throws GeneralSecurityException {
        if (kemId != HpkeParameters.KemId.DHKEM_X25519_HKDF_SHA256) goto L6;
        return 32;
    L6:
        if (kemId != HpkeParameters.KemId.DHKEM_P256_HKDF_SHA256) goto L9;
        return 32;
    L9:
        if (kemId != HpkeParameters.KemId.DHKEM_P384_HKDF_SHA384) goto L13;
        return 48;
    L13:
        if (kemId != HpkeParameters.KemId.DHKEM_P521_HKDF_SHA512) goto L17;
        return 66;
    L17:
        throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
    }

    private HpkeUtil() {
    }
}
