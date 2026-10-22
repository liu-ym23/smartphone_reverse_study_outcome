package com.android.apksig.internal.apk;

import com.android.apksig.apk.ApkFormatException;
import com.android.apksig.apk.ApkSigningBlockNotFoundException;
import com.android.apksig.apk.ApkUtilsLite;
import com.android.apksig.util.DataSource;
import com.android.apksig.zip.ZipSections;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public class ApkSigningBlockUtilsLite {
    private static final char[] HEX_DIGITS = null;

    /* JADX INFO: renamed from: com.android.apksig.internal.apk.ApkSigningBlockUtilsLite$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$android$apksig$internal$apk$ContentDigestAlgorithm = null;

        static {
            int[] r0 = new int[ContentDigestAlgorithm.values().length];
            $SwitchMap$com$android$apksig$internal$apk$ContentDigestAlgorithm = r0;
            r0[ContentDigestAlgorithm.CHUNKED_SHA256.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$android$apksig$internal$apk$ContentDigestAlgorithm[ContentDigestAlgorithm.CHUNKED_SHA512.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$android$apksig$internal$apk$ContentDigestAlgorithm[ContentDigestAlgorithm.VERITY_CHUNKED_SHA256.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        HEX_DIGITS = "0123456789abcdef".toCharArray();
    }

    private ApkSigningBlockUtilsLite() {
    }

    public static void checkByteOrderLittleEndian(ByteBuffer r1) {
        if (r1.order() != ByteOrder.LITTLE_ENDIAN) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
    }

    private static int compareContentDigestAlgorithm(ContentDigestAlgorithm r8, ContentDigestAlgorithm r9) {
        int[] r0 = AnonymousClass1.$SwitchMap$com$android$apksig$internal$apk$ContentDigestAlgorithm;
        int r1 = r0[r8.ordinal()];
        if (r1 == 1) goto L26;
        if (r1 == 2) goto L17;
        if (r1 != 3) goto L16;
        int r10 = r0[r9.ordinal()];
        if (r10 == 1) goto L14;
        if (r10 == 2) goto L13;
        if (r10 != 3) goto L12;
        return 0;
    L12:
        throw new IllegalArgumentException("Unknown alg2: " + r9);
    L13:
        return -1;
    L14:
        return 1;
    L16:
        throw new IllegalArgumentException("Unknown alg1: " + r8);
    L17:
        int r11 = r0[r9.ordinal()];
        if (r11 == 1) goto L25;
        if (r11 == 2) goto L24;
        if (r11 == 3) goto L25;
        throw new IllegalArgumentException("Unknown alg2: " + r9);
    L24:
        return 0;
    L25:
        return 1;
    L26:
        int r12 = r0[r9.ordinal()];
        if (r12 == 1) goto L34;
        if (r12 == 2) goto L33;
        if (r12 == 3) goto L33;
        throw new IllegalArgumentException("Unknown alg2: " + r9);
    L33:
        return -1;
    L34:
        return 0;
    }

    public static int compareSignatureAlgorithm(SignatureAlgorithm r0, SignatureAlgorithm r1) {
        return compareContentDigestAlgorithm(r0.getContentDigestAlgorithm(), r1.getContentDigestAlgorithm());
    }

    public static ByteBuffer findApkSignatureSchemeBlock(ByteBuffer r9, int r10) throws SignatureNotFoundException {
        checkByteOrderLittleEndian(r9);
        ByteBuffer r11 = sliceFromTo(r9, 8, r9.capacity() - 24);
        int r0 = 0;
    L4:
        if (r11.hasRemaining() == false) goto L25;
        r0 = r0 + 1;
        if (r11.remaining() < 8) goto L23;
        long r2 = r11.getLong();
        if (r2 < 4) goto L21;
        if (r2 > 2147483647L) goto L21;
        int r3 = (int) r2;
        int r4 = r11.position() + r3;
        if (r3 > r11.remaining()) goto L19;
        if (r11.getInt() == r10) goto L16;
        r11.position(r4);
        goto L4
    L16:
        return getByteBuffer(r11, r3 - 4);
    L19:
        throw new SignatureNotFoundException("APK Signing Block entry #" + r0 + " size out of range: " + r3 + ", available: " + r11.remaining());
    L21:
        throw new SignatureNotFoundException("APK Signing Block entry #" + r0 + " size out of range: " + r2);
    L23:
        throw new SignatureNotFoundException("Insufficient data to read size of APK Signing Block entry #" + r0);
    L25:
        throw new SignatureNotFoundException("No APK Signature Scheme block in APK Signing Block with ID: " + r10);
    }

    public static SignatureInfo findSignature(DataSource r9, ZipSections r10, int r11) throws IOException, SignatureNotFoundException {
        ApkUtilsLite.ApkSigningBlock r12 = ApkUtilsLite.findApkSigningBlock(r9, r10);     // Catch: ApkSigningBlockNotFoundException -> L5
        long r2 = r12.getStartOffset();     // Catch: ApkSigningBlockNotFoundException -> L5
        DataSource r13 = r12.getContents();     // Catch: ApkSigningBlockNotFoundException -> L5
        ByteBuffer r14 = r13.getByteBuffer(0, (int) r13.size());
        r14.order(ByteOrder.LITTLE_ENDIAN);
        return new SignatureInfo(findApkSignatureSchemeBlock(r14, r11), r2, r10.getZipCentralDirectoryOffset(), r10.getZipEndOfCentralDirectoryOffset(), r10.getZipEndOfCentralDirectory());
    L5:
        e = move-exception;
        throw new SignatureNotFoundException(e.getMessage(), e);
    }

    private static ByteBuffer getByteBuffer(ByteBuffer r3, int r4) {
        if (r4 < 0) goto L16;
        int r0 = r3.limit();
        int r1 = r3.position();
        int r5 = r4 + r1;
        if (r5 < r1) goto L14;
        if (r5 > r0) goto L14;
        r3.limit(r5);
        ByteBuffer r2 = r3.slice();     // Catch: Throwable -> L10
        r2.order(r3.order());     // Catch: Throwable -> L10
        r3.position(r5);     // Catch: Throwable -> L10
        r3.limit(r0);
        return r2;
    L10:
        th = move-exception;
        r3.limit(r0);
        throw th;
    L14:
        throw new BufferUnderflowException();
    L16:
        throw new IllegalArgumentException("size: " + r4);
    }

    public static ByteBuffer getLengthPrefixedSlice(ByteBuffer r4) throws ApkFormatException {
        if (r4.remaining() < 4) goto L15;
        int r0 = r4.getInt();
        if (r0 < 0) goto L13;
        if (r0 > r4.remaining()) goto L11;
        return getByteBuffer(r4, r0);
    L11:
        throw new ApkFormatException("Length-prefixed field longer than remaining buffer. Field length: " + r0 + ", remaining: " + r4.remaining());
    L13:
        throw new IllegalArgumentException("Negative length");
    L15:
        throw new ApkFormatException("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + r4.remaining());
    }

    public static <T extends ApkSupportedSignature> List<T> getSignaturesToVerify(List<T> r6, int r7, int r8, boolean r9) throws NoApkSupportedSignaturesException {
        HashMap r0 = new HashMap();
        Iterator<T> r10 = r6.iterator();
        int r1 = Integer.MAX_VALUE;
    L4:
        if (r10.hasNext() == false) goto L18;
        T r2 = r10.next();
        SignatureAlgorithm r3 = r2.algorithm;
        if (r9 == false) goto L8;
        int r4 = r3.getJcaSigAlgMinSdkVersion();
    L9:
        if (r4 > r8) goto L4;
        if (r4 >= r1) goto L13;
        r1 = r4;
    L13:
        ApkSupportedSignature r5 = (ApkSupportedSignature) r0.get(Integer.valueOf(r4));
        if (r5 == null) goto L17;
        if (compareSignatureAlgorithm(r3, r5.algorithm) <= 0) goto L4;
    L17:
        r0.put(Integer.valueOf(r4), r2);
        goto L4
    L8:
        r4 = r3.getMinSdkVersion();
        goto L9
    L18:
        if (r7 < r1) goto L26;
        if (r0.isEmpty() == true) goto L24;
        ArrayList r11 = new ArrayList(r0.values());
        Collections.sort(r11, new ApkSigningBlockUtilsLite$$ExternalSyntheticLambda0());
        return r11;
    L24:
        throw new NoApkSupportedSignaturesException("No supported signature");
    L26:
        throw new NoApkSupportedSignaturesException("Minimum provided signature version " + r1 + " > minSdkVersion " + r7);
    }

    static /* synthetic */ int lambda$getSignaturesToVerify$0(ApkSupportedSignature r0, ApkSupportedSignature r1) {
        return Integer.compare(r0.algorithm.getId(), r1.algorithm.getId());
    }

    public static byte[] readLengthPrefixedByteArray(ByteBuffer r4) throws ApkFormatException {
        int r0 = r4.getInt();
        if (r0 < 0) goto L11;
        if (r0 > r4.remaining()) goto L9;
        byte[] r1 = new byte[r0];
        r4.get(r1);
        return r1;
    L9:
        throw new ApkFormatException("Underflow while reading length-prefixed value. Length: " + r0 + ", available: " + r4.remaining());
    L11:
        throw new ApkFormatException("Negative length");
    }

    private static ByteBuffer sliceFromTo(ByteBuffer r3, int r4, int r5) {
        if (r4 < 0) goto L18;
        if (r5 < r4) goto L16;
        int r0 = r3.capacity();
        if (r5 > r3.capacity()) goto L14;
        int r1 = r3.limit();
        int r2 = r3.position();
        r3.position(0);     // Catch: Throwable -> L10
        r3.limit(r5);     // Catch: Throwable -> L10
        r3.position(r4);     // Catch: Throwable -> L10
        ByteBuffer r6 = r3.slice();     // Catch: Throwable -> L10
        r6.order(r3.order());     // Catch: Throwable -> L10
        r3.position(0);
        r3.limit(r1);
        r3.position(r2);
        return r6;
    L10:
        th = move-exception;
        r3.position(0);
        r3.limit(r1);
        r3.position(r2);
        throw th;
    L14:
        throw new IllegalArgumentException("end > capacity: " + r5 + " > " + r0);
    L16:
        throw new IllegalArgumentException("end < start: " + r5 + " < " + r4);
    L18:
        throw new IllegalArgumentException("start: " + r4);
    }

    public static String toHex(byte[] r6) {
        StringBuilder r0 = new StringBuilder(r6.length * 2);
        int r1 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        byte r3 = r6[r2];
        int r4 = (r3 & UByte.MAX_VALUE) >>> 4;
        char[] r5 = HEX_DIGITS;
        r0.append(r5[r4]).append(r5[r3 & 15]);
        r2 = r2 + 1;
        goto L3
    L6:
        return r0.toString();
    }
}
