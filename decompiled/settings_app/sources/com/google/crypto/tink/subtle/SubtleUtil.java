package com.google.crypto.tink.subtle;

import com.google.crypto.tink.internal.BigIntegerEncoding;
import com.google.crypto.tink.internal.Util;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes4.dex */
public final class SubtleUtil {

    /* JADX INFO: renamed from: com.google.crypto.tink.subtle.SubtleUtil$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType = null;

        static {
            int[] r0 = new int[Enums.HashType.values().length];
            $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType = r0;
            r0[Enums.HashType.SHA1.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[Enums.HashType.SHA224.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[Enums.HashType.SHA256.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[Enums.HashType.SHA384.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[Enums.HashType.SHA512.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static String toEcdsaAlgo(Enums.HashType hash) throws GeneralSecurityException {
        Validators.validateSignatureHash(hash);
        return hash + "withECDSA";
    }

    public static String toRsaSsaPkcs1Algo(Enums.HashType hash) throws GeneralSecurityException {
        Validators.validateSignatureHash(hash);
        return hash + "withRSA";
    }

    public static String toDigestAlgo(Enums.HashType hash) throws GeneralSecurityException {
        int r0 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[hash.ordinal()];
        if (r0 != 1) goto L5;
        return "SHA-1";
    L5:
        if (r0 != 2) goto L7;
        return "SHA-224";
    L7:
        if (r0 != 3) goto L9;
        return "SHA-256";
    L9:
        if (r0 != 4) goto L11;
        return "SHA-384";
    L11:
        if (r0 != 5) goto L15;
        return "SHA-512";
    L15:
        throw new GeneralSecurityException("Unsupported hash " + hash);
    }

    public static boolean isAndroid() {
        return "The Android Project".equals(System.getProperty("java.vendor"));
    }

    @Deprecated
    public static int androidApiLevel() {
        Integer r0 = Util.getAndroidApiLevel();
        if (r0 != null) goto L5;
        return -1;
    L5:
        return r0.intValue();
    }

    public static BigInteger bytes2Integer(byte[] bs) {
        return BigIntegerEncoding.fromUnsignedBigEndianBytes(bs);
    }

    public static byte[] integer2Bytes(BigInteger num, int intendedLength) throws GeneralSecurityException {
        return BigIntegerEncoding.toBigEndianBytesOfFixedLength(num, intendedLength);
    }

    public static byte[] mgf1(byte[] mgfSeed, int maskLen, Enums.HashType mgfHash) throws GeneralSecurityException {
        MessageDigest r10 = EngineFactory.MESSAGE_DIGEST.getInstance(toDigestAlgo(mgfHash));
        int r0 = r10.getDigestLength();
        byte[] r1 = new byte[maskLen];
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r3 > ((maskLen - 1) / r0)) goto L6;
        r10.reset();
        r10.update(mgfSeed);
        r10.update(integer2Bytes(BigInteger.valueOf(r3), 4));
        byte[] r5 = r10.digest();
        System.arraycopy(r5, 0, r1, r4, Math.min(r5.length, maskLen - r4));
        r4 = r4 + r5.length;
        r3 = r3 + 1;
        goto L4
    L6:
        return r1;
    }

    public static void putAsUnsigedInt(ByteBuffer buffer, long value) throws GeneralSecurityException {
        if (0 > value) goto L9;
        if (value >= 4294967296L) goto L9;
        buffer.putInt((int) value);
        return;
    L9:
        throw new GeneralSecurityException("Index out of range");
    }

    private SubtleUtil() {
    }
}
