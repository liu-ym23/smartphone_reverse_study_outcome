package com.android.apksig.internal.zip;

import com.android.apksig.internal.util.ByteBufferSink;
import com.android.apksig.util.DataSink;
import com.android.apksig.util.DataSource;
import com.android.apksig.zip.ZipFormatException;
import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes.dex */
public class LocalFileRecord {
    private static final int COMPRESSED_SIZE_OFFSET = 18;
    private static final int CRC32_OFFSET = 14;
    private static final int DATA_DESCRIPTOR_SIGNATURE = 134695760;
    private static final int DATA_DESCRIPTOR_SIZE_BYTES_WITHOUT_SIGNATURE = 12;
    private static final ByteBuffer EMPTY_BYTE_BUFFER = null;
    private static final int EXTRA_LENGTH_OFFSET = 28;
    private static final int GP_FLAGS_OFFSET = 6;
    private static final int HEADER_SIZE_BYTES = 30;
    private static final int NAME_LENGTH_OFFSET = 26;
    private static final int NAME_OFFSET = 30;
    private static final int RECORD_SIGNATURE = 67324752;
    private static final int UNCOMPRESSED_SIZE_OFFSET = 22;
    private final boolean mDataCompressed;
    private final long mDataSize;
    private final int mDataStartOffset;
    private final ByteBuffer mExtra;
    private final String mName;
    private final int mNameSizeBytes;
    private final long mSize;
    private final long mStartOffsetInArchive;
    private final long mUncompressedDataSize;

    /* JADX INFO: renamed from: com.android.apksig.internal.zip.LocalFileRecord$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class InflateSinkAdapter implements DataSink, Closeable {
        private boolean mClosed;
        private final DataSink mDelegate;
        private Inflater mInflater;
        private byte[] mInputBuffer;
        private byte[] mOutputBuffer;
        private long mOutputByteCount;

        /* synthetic */ InflateSinkAdapter(DataSink r1, AnonymousClass1 r2) {
            this(r1);
        }

        private void checkNotClosed() {
            if (this.mClosed == true) goto L6;
            return;
        L6:
            throw new IllegalStateException("Closed");
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.mClosed = true;
            this.mInputBuffer = null;
            this.mOutputBuffer = null;
            Inflater r1 = this.mInflater;
            if (r1 == null) goto L6;
            r1.end();
            this.mInflater = null;
            return;
        }

        @Override // com.android.apksig.util.DataSink
        public void consume(byte[] r3, int r4, int r5) throws IOException {
            checkNotClosed();
            this.mInflater.setInput(r3, r4, r5);
            if (this.mOutputBuffer != null) goto L6;
            this.mOutputBuffer = new byte[65536];
        L6:
            if (this.mInflater.finished() == true) goto L14;
            int r6 = this.mInflater.inflate(this.mOutputBuffer);     // Catch: DataFormatException -> L11
            if (r6 == 0) goto L9;
            this.mDelegate.consume(this.mOutputBuffer, 0, r6);
            this.mOutputByteCount += (long) r6;
            goto L6
        L9:
            return;
        L11:
            e = move-exception;
            throw new IOException("Failed to inflate data", e);
        }

        public long getOutputByteCount() {
            return this.mOutputByteCount;
        }

        private InflateSinkAdapter(DataSink r3) {
            this.mInflater = new Inflater(true);
            this.mDelegate = r3;
        }

        @Override // com.android.apksig.util.DataSink
        public void consume(ByteBuffer r4) throws IOException {
            checkNotClosed();
            if (r4.hasArray() == false) goto L6;
            consume(r4.array(), r4.arrayOffset() + r4.position(), r4.remaining());
            r4.position(r4.limit());
            return;
        L6:
            if (this.mInputBuffer != null) goto L9;
            this.mInputBuffer = new byte[65536];
        L9:
            if (r4.hasRemaining() == false) goto L14;
            int r0 = Math.min(r4.remaining(), this.mInputBuffer.length);
            r4.get(this.mInputBuffer, 0, r0);
            consume(this.mInputBuffer, 0, r0);
            goto L9
        }
    }

    static {
        EMPTY_BYTE_BUFFER = ByteBuffer.allocate(0);
    }

    private LocalFileRecord(String r1, int r2, ByteBuffer r3, long r4, long r6, int r8, long r9, boolean r11, long r12) {
        this.mName = r1;
        this.mNameSizeBytes = r2;
        this.mExtra = r3;
        this.mStartOffsetInArchive = r4;
        this.mSize = r6;
        this.mDataStartOffset = r8;
        this.mDataSize = r9;
        this.mDataCompressed = r11;
        this.mUncompressedDataSize = r12;
    }

    private static LocalFileRecord getRecord(DataSource r25, CentralDirectoryRecord r26, long r27, boolean r29, boolean r30) throws ZipFormatException, IOException {
        String r3 = r26.getName();
        int r4 = r26.getNameSizeBytes();
        int r5 = r4 + 30;
        long r6 = r26.getLocalFileHeaderOffset();
        long r8 = ((long) r5) + r6;
        if (r8 > r27) goto L74;
        ByteBuffer r7 = r25.getByteBuffer(r6, r5);     // Catch: IOException -> L70
        ByteOrder r9 = ByteOrder.LITTLE_ENDIAN;
        r7.order(r9);
        int r10 = r7.getInt();
        if (r10 != RECORD_SIGNATURE) goto L69;
        int r11 = r7.getShort(6) & 8;
        if (r11 == 0) goto L10;
        boolean r13 = true;
    L11:
        r26.getGpFlags();
        long r14 = r26.getCrc32();
        long r12 = r26.getCompressedSize();
        long r15 = r26.getUncompressedSize();
        if (r13 == true) goto L26;
        long r0 = ZipUtils.getUnsignedInt32(r7, 14);
        if (r0 != r14) goto L25;
        long r1 = ZipUtils.getUnsignedInt32(r7, 18);
        if (r1 != r12) goto L23;
        long r2 = ZipUtils.getUnsignedInt32(r7, 22);
        if (r2 == r15) goto L26;
        throw new ZipFormatException("Uncompressed size mismatch between Local File Header and Central Directory for entry " + r3 + ". LFH: " + r2 + ", CD: " + r15);
    L23:
        throw new ZipFormatException("Compressed size mismatch between Local File Header and Central Directory for entry " + r3 + ". LFH: " + r1 + ", CD: " + r12);
    L25:
        throw new ZipFormatException("CRC-32 mismatch between Local File Header and Central Directory for entry " + r3 + ". LFH: " + r0 + ", CD: " + r14);
    L26:
        int r16 = ZipUtils.getUnsignedInt16(r7, 26);
        if (r16 > r4) goto L67;
        String r17 = CentralDirectoryRecord.getName(r7, 30, r16);
        if (r3.equals(r17) == false) goto L65;
        int r18 = ZipUtils.getUnsignedInt16(r7, 28);
        long r19 = (30 + r6) + ((long) r16);
        long r110 = ((long) r18) + r19;
        if (r26.getCompressionMethod() == 0) goto L33;
        boolean r111 = true;
    L35:
        if (r111 == true) goto L38;
        r12 = r15;
    L38:
        long r20 = r110 + r12;
        if (r20 > r27) goto L63;
        ByteBuffer r21 = EMPTY_BYTE_BUFFER;
        if (r29 == false) goto L44;
        if (r18 <= 0) goto L44;
        DataSource r112 = r25;
        int r113 = r18;
        r21 = r112.getByteBuffer(r19, r113);
    L45:
        if (r30 == false) goto L59;
        if (r11 == 0) goto L59;
        long r114 = 12 + r20;
        long r23 = r15;
        if (r114 > r27) goto L58;
        ByteBuffer r115 = r112.getByteBuffer(r20, 4);
        r115.order(r9);
        if (r115.getInt() != DATA_DESCRIPTOR_SIGNATURE) goto L56;
        long r116 = 16 + r20;
        if (r116 > r27) goto L55;
        r20 = r116;
    L61:
        return new LocalFileRecord(r3, r4, r21, r6, r20 - r6, (r16 + 30) + r113, r12, r111, r23);
    L55:
        throw new ZipFormatException("Data Descriptor of " + r3 + " overlaps with Central Directory. Data Descriptor end: " + r20 + ", CD start: " + r27);
    L56:
        r20 = r114;
        goto L61
    L58:
        throw new ZipFormatException("Data Descriptor of " + r3 + " overlaps with Central Directory. Data Descriptor end: " + r20 + ", CD start: " + r27);
    L59:
        r23 = r15;
    L44:
        r112 = r25;
        r113 = r18;
        goto L45
    L63:
        throw new ZipFormatException("Local File Header data of " + r3 + " overlaps with Central Directory. LFH data start: " + r110 + ", LFH data end: " + r20 + ", CD start: " + r27);
    L33:
        r111 = false;
        goto L35
    L65:
        throw new ZipFormatException("Name mismatch between Local File Header and Central Directory. LFH: \"" + r17 + "\", CD: \"" + r3 + "\"");
    L67:
        throw new ZipFormatException("Name mismatch between Local File Header and Central Directory for entry" + r3 + ". LFH: " + r16 + " bytes, CD: " + r4 + " bytes");
    L10:
        r13 = false;
        goto L11
    L69:
        throw new ZipFormatException("Not a Local File Header record for entry " + r3 + ". Signature: 0x" + Long.toHexString(((long) r10) & 4294967295L));
    L70:
        e = move-exception;
        throw new IOException("Failed to read Local File Header of " + r3, e);
    L74:
        throw new ZipFormatException("Local File Header of " + r3 + " extends beyond start of Central Directory. LFH end: " + r8 + ", CD start: " + r27);
    }

    public static byte[] getUncompressedData(DataSource r4, CentralDirectoryRecord r5, long r6) throws ZipFormatException, IOException {
        if (r5.getUncompressedSize() > 2147483647L) goto L7;
        byte[] r0 = new byte[(int) r5.getUncompressedSize()];
        outputUncompressedData(r4, r5, r6, new ByteBufferSink(ByteBuffer.wrap(r0)));
        return r0;
    L7:
        throw new IOException(r5.getName() + " too large: " + r5.getUncompressedSize());
    }

    public static void outputUncompressedData(DataSource r6, CentralDirectoryRecord r7, long r8, DataSink r10) throws ZipFormatException, IOException {
        getRecord(r6, r7, r8, false, false).outputUncompressedData(r6, r10);
    }

    public String getName() {
        return this.mName;
    }

    public long getSize() {
        return this.mSize;
    }

    public void outputUncompressedData(DataSource r13, DataSink r14) throws IOException, ZipFormatException {
        long r7 = this.mStartOffsetInArchive + ((long) this.mDataStartOffset);
    L29:
        e = move-exception;
        StringBuilder r0 = new StringBuilder("Failed to read data of ");
        if (this.mDataCompressed == false) goto L33;
        String r1 = "compressed";
    L35:
        throw new IOException(r0.append(r1).append(" entry ").append(this.mName).toString(), e);
    L33:
        r1 = "uncompressed";
        goto L35
    L4:
        if (this.mDataCompressed == true) goto L38;
        r13.feed(r7, this.mDataSize, r14);     // Catch: IOException -> L29
        return;
    L38:
        InflateSinkAdapter r2 = new InflateSinkAdapter(r14, null);     // Catch: IOException -> L21
        r13.feed(r7, this.mDataSize, r2);     // Catch: Throwable -> L13
        long r15 = r2.getOutputByteCount();     // Catch: Throwable -> L13
        if (r15 != this.mUncompressedDataSize) goto L12;
        r2.close();     // Catch: IOException -> L21
        return;
    L12:
        throw new ZipFormatException("Unexpected size of uncompressed data of " + this.mName + ". Expected: " + this.mUncompressedDataSize + " bytes, actual: " + r15 + " bytes");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L18
    L20:
        throw th;     // Catch: IOException -> L21
    L18:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L21
    L21:
        e = move-exception;
        if ((e.getCause() instanceof DataFormatException) == true) goto L25;
        throw e;     // Catch: IOException -> L29
    L25:
        throw new ZipFormatException("Data of entry " + this.mName + " malformed", e);     // Catch: IOException -> L29
    }
}
