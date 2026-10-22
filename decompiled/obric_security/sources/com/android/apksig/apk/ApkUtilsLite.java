package com.android.apksig.apk;

import com.android.apksig.internal.util.Pair;
import com.android.apksig.internal.zip.ZipUtils;
import com.android.apksig.util.DataSource;
import com.android.apksig.zip.ZipFormatException;
import com.android.apksig.zip.ZipSections;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes.dex */
public class ApkUtilsLite {
    private static final long APK_SIG_BLOCK_MAGIC_HI = 3617552046287187010L;
    private static final long APK_SIG_BLOCK_MAGIC_LO = 2334950737559900225L;
    private static final int APK_SIG_BLOCK_MIN_SIZE = 32;

    public static class ApkSigningBlock {
        private final DataSource mContents;
        private final long mStartOffsetInApk;

        public ApkSigningBlock(long r1, DataSource r3) {
            this.mStartOffsetInApk = r1;
            this.mContents = r3;
        }

        public DataSource getContents() {
            return this.mContents;
        }

        public long getStartOffset() {
            return this.mStartOffsetInApk;
        }
    }

    private ApkUtilsLite() {
    }

    public static byte[] computeSha256DigestBytes(byte[] r2) {
        MessageDigest r0 = MessageDigest.getInstance("SHA-256");     // Catch: NoSuchAlgorithmException -> L5
        r0.update(r2);
        return r0.digest();
    L5:
        e = move-exception;
        throw new IllegalStateException("SHA-256 is not found", e);
    }

    public static ApkSigningBlock findApkSigningBlock(DataSource r11, ZipSections r12) throws IOException, ApkSigningBlockNotFoundException {
        long r0 = r12.getZipCentralDirectoryOffset();
        long r2 = r12.getZipCentralDirectorySizeBytes() + r0;
        long r4 = r12.getZipEndOfCentralDirectoryOffset();
        if (r2 != r4) goto L31;
        if (r0 < 32) goto L29;
        ByteBuffer r13 = r11.getByteBuffer(r0 - 24, 24);
        ByteOrder r3 = ByteOrder.LITTLE_ENDIAN;
        r13.order(r3);
        if (r13.getLong(8) != APK_SIG_BLOCK_MAGIC_LO) goto L27;
        if (r13.getLong(16) != APK_SIG_BLOCK_MAGIC_HI) goto L27;
        long r5 = r13.getLong(0);
        if (r5 < r13.capacity()) goto L25;
        if (r5 > 2147483639) goto L25;
        long r7 = (int) (8 + r5);
        long r1 = r0 - r7;
        if (r1 < 0) goto L23;
        ByteBuffer r14 = r11.getByteBuffer(r1, 8);
        r14.order(r3);
        long r6 = r14.getLong(0);
        if (r6 != r5) goto L21;
        return new ApkSigningBlock(r1, r11.slice(r1, r7));
    L21:
        throw new ApkSigningBlockNotFoundException("APK Signing Block sizes in header and footer do not match: " + r6 + " vs " + r5);
    L23:
        throw new ApkSigningBlockNotFoundException("APK Signing Block offset out of range: " + r1);
    L25:
        throw new ApkSigningBlockNotFoundException("APK Signing Block size out of range: " + r5);
    L27:
        throw new ApkSigningBlockNotFoundException("No APK Signing Block before ZIP Central Directory");
    L29:
        throw new ApkSigningBlockNotFoundException("APK too small for APK Signing Block. ZIP Central Directory offset: " + r0);
    L31:
        throw new ApkSigningBlockNotFoundException("ZIP Central Directory is not immediately followed by End of Central Directory. CD end: " + r2 + ", EoCD start: " + r4);
    }

    public static ZipSections findZipSections(DataSource r10) throws IOException, ZipFormatException {
        Pair<ByteBuffer, Long> r11 = ZipUtils.findZipEndOfCentralDirectoryRecord(r10);
        if (r11 == null) goto L15;
        ByteBuffer r9 = r11.getFirst();
        long r7 = r11.getSecond().longValue();
        r9.order(ByteOrder.LITTLE_ENDIAN);
        long r2 = ZipUtils.getZipEocdCentralDirectoryOffset(r9);
        if (r2 > r7) goto L13;
        long r4 = ZipUtils.getZipEocdCentralDirectorySizeBytes(r9);
        long r0 = r2 + r4;
        if (r0 > r7) goto L11;
        return new ZipSections(r2, r4, ZipUtils.getZipEocdCentralDirectoryTotalRecordCount(r9), r7, r9);
    L11:
        throw new ZipFormatException("ZIP Central Directory overlaps with End of Central Directory. CD end: " + r0 + ", EoCD start: " + r7);
    L13:
        throw new ZipFormatException("ZIP Central Directory start offset out of range: " + r2 + ". ZIP End of Central Directory offset: " + r7);
    L15:
        throw new ZipFormatException("ZIP End of Central Directory record not found");
    }
}
