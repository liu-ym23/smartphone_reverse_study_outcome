package com.android.apksig.internal.zip;

import com.android.apksig.zip.ZipFormatException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class CentralDirectoryRecord {
    public static final Comparator<CentralDirectoryRecord> BY_LOCAL_FILE_HEADER_OFFSET_COMPARATOR = null;
    private static final int GP_FLAGS_OFFSET = 8;
    private static final int HEADER_SIZE_BYTES = 46;
    private static final int LOCAL_FILE_HEADER_OFFSET_OFFSET = 42;
    private static final int NAME_OFFSET = 46;
    private static final int RECORD_SIGNATURE = 33639248;
    private final long mCompressedSize;
    private final short mCompressionMethod;
    private final long mCrc32;
    private final ByteBuffer mData;
    private final short mGpFlags;
    private final int mLastModificationDate;
    private final int mLastModificationTime;
    private final long mLocalFileHeaderOffset;
    private final String mName;
    private final int mNameSizeBytes;
    private final long mUncompressedSize;

    /* JADX INFO: renamed from: com.android.apksig.internal.zip.CentralDirectoryRecord$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class ByLocalFileHeaderOffsetComparator implements Comparator<CentralDirectoryRecord> {
        private ByLocalFileHeaderOffsetComparator() {
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(CentralDirectoryRecord r1, CentralDirectoryRecord r2) {
            return compare2(r1, r2);
        }

        /* synthetic */ ByLocalFileHeaderOffsetComparator(AnonymousClass1 r1) {
            this();
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(CentralDirectoryRecord r3, CentralDirectoryRecord r4) {
            long r2 = r3.getLocalFileHeaderOffset();
            long r0 = r4.getLocalFileHeaderOffset();
            if (r2 <= r0) goto L6;
            return 1;
        L6:
            if (r2 >= r0) goto L9;
            return -1;
        L9:
            return 0;
        }
    }

    static {
        BY_LOCAL_FILE_HEADER_OFFSET_COMPARATOR = new ByLocalFileHeaderOffsetComparator(null);
    }

    private CentralDirectoryRecord(ByteBuffer r1, short r2, short r3, int r4, int r5, long r6, long r8, long r10, long r12, String r14, int r15) {
        this.mData = r1;
        this.mGpFlags = r2;
        this.mCompressionMethod = r3;
        this.mLastModificationDate = r5;
        this.mLastModificationTime = r4;
        this.mCrc32 = r6;
        this.mCompressedSize = r8;
        this.mUncompressedSize = r10;
        this.mLocalFileHeaderOffset = r12;
        this.mName = r14;
        this.mNameSizeBytes = r15;
    }

    public static CentralDirectoryRecord createWithDeflateCompressedData(String r18, int r19, int r20, long r21, long r23, long r25, long r27) {
        byte[] r0 = r18.getBytes(StandardCharsets.UTF_8);
        ByteBuffer r2 = ByteBuffer.allocate(r0.length + 46);
        r2.order(ByteOrder.LITTLE_ENDIAN);
        r2.putInt(RECORD_SIGNATURE);
        ZipUtils.putUnsignedInt16(r2, 20);
        ZipUtils.putUnsignedInt16(r2, 20);
        r2.putShort(ZipUtils.GP_FLAG_EFS);
        r2.putShort(8);
        ZipUtils.putUnsignedInt16(r2, r19);
        ZipUtils.putUnsignedInt16(r2, r20);
        ZipUtils.putUnsignedInt32(r2, r21);
        ZipUtils.putUnsignedInt32(r2, r23);
        ZipUtils.putUnsignedInt32(r2, r25);
        ZipUtils.putUnsignedInt16(r2, r0.length);
        ZipUtils.putUnsignedInt16(r2, 0);
        ZipUtils.putUnsignedInt16(r2, 0);
        ZipUtils.putUnsignedInt16(r2, 0);
        ZipUtils.putUnsignedInt16(r2, 0);
        ZipUtils.putUnsignedInt32(r2, 0);
        ZipUtils.putUnsignedInt32(r2, r27);
        r2.put(r0);
        if (r2.hasRemaining() == true) goto L7;
        r2.flip();
        return new CentralDirectoryRecord(r2, ZipUtils.GP_FLAG_EFS, 8, r19, r20, r21, r23, r25, r27, r18, r0.length);
    L7:
        throw new RuntimeException("pos: " + r2.position() + ", limit: " + r2.limit());
    }

    static String getName(ByteBuffer r2, int r3, int r4) {
        if (r2.hasArray() == false) goto L5;
        byte[] r0 = r2.array();
        int r5 = r2.arrayOffset() + r3;
    L9:
        return new String(r0, r5, r4, StandardCharsets.UTF_8);
    L5:
        r0 = new byte[r4];
        int r1 = r2.position();
        r2.position(r3);     // Catch: Throwable -> L10
        r2.get(r0);     // Catch: Throwable -> L10
        r2.position(r1);
        r5 = 0;
    L10:
        th = move-exception;
        r2.position(r1);
        throw th;
    }

    public static CentralDirectoryRecord getRecord(ByteBuffer r20) throws ZipFormatException {
        ZipUtils.assertByteOrderLittleEndian(r20);
        if (r20.remaining() < 46) goto L20;
        int r0 = r20.position();
        int r2 = r20.getInt();
        if (r2 != RECORD_SIGNATURE) goto L18;
        r20.position(r0 + 8);
        short r6 = r20.getShort();
        short r7 = r20.getShort();
        int r8 = ZipUtils.getUnsignedInt16(r20);
        int r9 = ZipUtils.getUnsignedInt16(r20);
        long r10 = ZipUtils.getUnsignedInt32(r20);
        long r12 = ZipUtils.getUnsignedInt32(r20);
        long r14 = ZipUtils.getUnsignedInt32(r20);
        int r3 = ZipUtils.getUnsignedInt16(r20);
        int r4 = ZipUtils.getUnsignedInt16(r20);
        int r5 = ZipUtils.getUnsignedInt16(r20);
        r20.position(r0 + 42);
        long r17 = ZipUtils.getUnsignedInt32(r20);
        r20.position(r0);
        int r11 = ((r3 + 46) + r4) + r5;
        if (r11 > r20.remaining()) goto L16;
        String r19 = getName(r20, r0 + 46, r3);
        r20.position(r0);
        int r13 = r20.limit();
        int r1 = r0 + r11;
        r20.limit(r1);     // Catch: Throwable -> L12
        ByteBuffer r15 = r20.slice();     // Catch: Throwable -> L12
        r20.limit(r13);
        r20.position(r1);
        return new CentralDirectoryRecord(r15, r6, r7, r8, r9, r10, r12, r14, r17, r19, r3);
    L12:
        th = move-exception;
        r20.limit(r13);
        throw th;
    L16:
        throw new ZipFormatException("Input too short. Need: " + r11 + " bytes, available: " + r20.remaining() + " bytes", new BufferUnderflowException());
    L18:
        throw new ZipFormatException("Not a Central Directory record. Signature: 0x" + Long.toHexString(((long) r2) & 4294967295L));
    L20:
        throw new ZipFormatException("Input too short. Need at least: 46 bytes, available: " + r20.remaining() + " bytes", new BufferUnderflowException());
    }

    public CentralDirectoryRecord createWithModifiedLocalFileHeaderOffset(long r19) {
        ByteBuffer r3 = ByteBuffer.allocate(this.mData.remaining());
        r3.put(this.mData.slice());
        r3.flip();
        r3.order(ByteOrder.LITTLE_ENDIAN);
        ZipUtils.setUnsignedInt32(r3, 42, r19);
        return new CentralDirectoryRecord(r3, this.mGpFlags, this.mCompressionMethod, this.mLastModificationTime, this.mLastModificationDate, this.mCrc32, this.mCompressedSize, this.mUncompressedSize, r19, this.mName, this.mNameSizeBytes);
    }

    public long getCompressedSize() {
        return this.mCompressedSize;
    }

    public short getCompressionMethod() {
        return this.mCompressionMethod;
    }

    public long getCrc32() {
        return this.mCrc32;
    }

    public short getGpFlags() {
        return this.mGpFlags;
    }

    public long getLocalFileHeaderOffset() {
        return this.mLocalFileHeaderOffset;
    }

    public int getNameSizeBytes() {
        return this.mNameSizeBytes;
    }

    public int getSize() {
        return this.mData.remaining();
    }

    public long getUncompressedSize() {
        return this.mUncompressedSize;
    }

    public String getName() {
        return this.mName;
    }
}
