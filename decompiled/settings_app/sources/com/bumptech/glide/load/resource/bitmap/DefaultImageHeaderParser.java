package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultImageHeaderParser implements ImageHeaderParser {
    private static final int AVIF_BRAND = 1635150182;
    private static final int AVIS_BRAND = 1635150195;
    private static final int[] BYTES_PER_FORMAT = null;
    static final int EXIF_MAGIC_NUMBER = 65496;
    static final int EXIF_SEGMENT_TYPE = 225;
    private static final int FTYP_HEADER = 1718909296;
    private static final int GIF_HEADER = 4671814;
    private static final int INTEL_TIFF_MAGIC_NUMBER = 18761;
    private static final String JPEG_EXIF_SEGMENT_PREAMBLE = "Exif\u0000\u0000";
    static final byte[] JPEG_EXIF_SEGMENT_PREAMBLE_BYTES = null;
    private static final int MARKER_EOI = 217;
    private static final int MOTOROLA_TIFF_MAGIC_NUMBER = 19789;
    private static final int ORIENTATION_TAG_TYPE = 274;
    private static final int PNG_HEADER = -1991225785;
    private static final int RIFF_HEADER = 1380533830;
    private static final int SEGMENT_SOS = 218;
    static final int SEGMENT_START_ID = 255;
    private static final String TAG = "DfltImageHeaderParser";
    private static final int VP8_HEADER = 1448097792;
    private static final int VP8_HEADER_MASK = -256;
    private static final int VP8_HEADER_TYPE_EXTENDED = 88;
    private static final int VP8_HEADER_TYPE_LOSSLESS = 76;
    private static final int VP8_HEADER_TYPE_MASK = 255;
    private static final int WEBP_EXTENDED_ALPHA_FLAG = 16;
    private static final int WEBP_EXTENDED_ANIMATION_FLAG = 2;
    private static final int WEBP_HEADER = 1464156752;
    private static final int WEBP_LOSSLESS_ALPHA_FLAG = 8;

    private static final class ByteBufferReader implements Reader {
        private final ByteBuffer byteBuffer;

        ByteBufferReader(ByteBuffer r1) {
            this.byteBuffer = r1;
            r1.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public short getUInt8() throws Reader.EndOfFileException {
            if (this.byteBuffer.remaining() < 1) goto L7;
            return (short) (this.byteBuffer.get() & 255);
        L7:
            throw new Reader.EndOfFileException();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int getUInt16() throws Reader.EndOfFileException {
            int r0 = getUInt8() << 8;
            return getUInt8() | r0;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int read(byte[] r2, int r3) {
            int r4 = Math.min(r3, this.byteBuffer.remaining());
            if (r4 != 0) goto L6;
            return -1;
        L6:
            this.byteBuffer.get(r2, 0, r4);
            return r4;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public long skip(long r3) {
            int r4 = (int) Math.min(this.byteBuffer.remaining(), r3);
            ByteBuffer r2 = this.byteBuffer;
            r2.position(r2.position() + r4);
            return r4;
        }
    }

    private static final class RandomAccessReader {
        private final ByteBuffer data;

        RandomAccessReader(byte[] r2, int r3) {
            this.data = (ByteBuffer) ByteBuffer.wrap(r2).order(ByteOrder.BIG_ENDIAN).limit(r3);
        }

        void order(ByteOrder r1) {
            this.data.order(r1);
        }

        int length() {
            return this.data.remaining();
        }

        int getInt32(int r2) {
            if (isAvailable(r2, 4) == true) goto L7;
            return -1;
        L7:
            return this.data.getInt(r2);
        }

        short getInt16(int r2) {
            if (isAvailable(r2, 2) == true) goto L7;
            return -1;
        L7:
            return this.data.getShort(r2);
        }

        private boolean isAvailable(int r1, int r2) {
            if ((this.data.remaining() - r1) < r2) goto L5;
            return true;
        L5:
            return false;
        }
    }

    private interface Reader {

        public static final class EndOfFileException extends IOException {
            private static final long serialVersionUID = 1;

            EndOfFileException() {
                super("Unexpectedly reached end of a file");
            }
        }

        int getUInt16() throws IOException;

        short getUInt8() throws IOException;

        int read(byte[] r1, int r2) throws IOException;

        long skip(long r1) throws IOException;
    }

    private static final class StreamReader implements Reader {
        private final InputStream is;

        StreamReader(InputStream r1) {
            this.is = r1;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public short getUInt8() throws IOException {
            int r1 = this.is.read();
            if (r1 == (-1)) goto L7;
            return (short) r1;
        L7:
            throw new Reader.EndOfFileException();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int getUInt16() throws IOException {
            int r0 = getUInt8() << 8;
            return getUInt8() | r0;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int read(byte[] r5, int r6) throws IOException {
            int r0 = 0;
            int r1 = 0;
        L4:
            if (r0 >= r6) goto L8;
            r1 = this.is.read(r5, r0, r6 - r0);
            if (r1 == (-1)) goto L8;
            r0 = r0 + r1;
        L8:
            if (r0 != 0) goto L13;
            if (r1 != (-1)) goto L13;
            throw new Reader.EndOfFileException();
        L13:
            return r0;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public long skip(long r8) throws IOException {
            if (r8 >= 0) goto L5;
            return 0;
        L5:
            long r2 = r8;
        L7:
            if (r2 <= 0) goto L16;
            long r4 = this.is.skip(r2);
            if (r4 > 0) goto L10;
            if (this.is.read() == (-1)) goto L16;
            r4 = 1;
        L10:
            r2 = r2 - r4;
        L16:
            return r8 - r2;
        }
    }

    private static int calcTagOffset(int r0, int r1) {
        return (r0 + 2) + (r1 * 12);
    }

    private static boolean handles(int r2) {
        if ((r2 & EXIF_MAGIC_NUMBER) != EXIF_MAGIC_NUMBER) goto L5;
    L10:
        return true;
    L5:
        if (r2 == MOTOROLA_TIFF_MAGIC_NUMBER) goto L10;
        if (r2 == INTEL_TIFF_MAGIC_NUMBER) goto L10;
        return false;
    }

    public DefaultImageHeaderParser() {
    }

    static {
        JPEG_EXIF_SEGMENT_PREAMBLE_BYTES = JPEG_EXIF_SEGMENT_PREAMBLE.getBytes(Charset.forName("UTF-8"));
        BYTES_PER_FORMAT = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType getType(InputStream r2) throws IOException {
        return getType(new StreamReader((InputStream) Preconditions.checkNotNull(r2)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType getType(ByteBuffer r2) throws IOException {
        return getType(new ByteBufferReader((ByteBuffer) Preconditions.checkNotNull(r2)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int getOrientation(InputStream r2, ArrayPool r3) throws IOException {
        return getOrientation(new StreamReader((InputStream) Preconditions.checkNotNull(r2)), (ArrayPool) Preconditions.checkNotNull(r3));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int getOrientation(ByteBuffer r2, ArrayPool r3) throws IOException {
        return getOrientation(new ByteBufferReader((ByteBuffer) Preconditions.checkNotNull(r2)), (ArrayPool) Preconditions.checkNotNull(r3));
    }

    private ImageHeaderParser.ImageType getType(Reader r5) throws IOException {
        int r0 = r5.getUInt16();     // Catch: Reader.EndOfFileException -> L53
        if (r0 == EXIF_MAGIC_NUMBER) goto L5;
        int r1 = (r0 << 8) | r5.getUInt8();     // Catch: Reader.EndOfFileException -> L53
        if (r1 == GIF_HEADER) goto L9;
        int r2 = (r1 << 8) | r5.getUInt8();     // Catch: Reader.EndOfFileException -> L53
        if (r2 != PNG_HEADER) goto L21;
        r5.skip(21);     // Catch: Reader.EndOfFileException -> L53
        if (r5.getUInt8() < 3) goto L17;
        return ImageHeaderParser.ImageType.PNG_A;
    L17:
        return ImageHeaderParser.ImageType.PNG;
    L19:
        return ImageHeaderParser.ImageType.PNG;
    L21:
        if (r2 != RIFF_HEADER) goto L23;
        r5.skip(4);     // Catch: Reader.EndOfFileException -> L53
        if (((r5.getUInt16() << 16) | r5.getUInt16()) != WEBP_HEADER) goto L27;
        int r4 = (r5.getUInt16() << 16) | r5.getUInt16();     // Catch: Reader.EndOfFileException -> L53
        if ((r4 & (-256)) != VP8_HEADER) goto L31;
        int r6 = r4 & 255;     // Catch: Reader.EndOfFileException -> L53
        if (r6 != 88) goto L45;
        r5.skip(4);     // Catch: Reader.EndOfFileException -> L53
        short r7 = r5.getUInt8();     // Catch: Reader.EndOfFileException -> L53
        if ((r7 & 2) == 0) goto L39;
        return ImageHeaderParser.ImageType.ANIMATED_WEBP;
    L39:
        if ((r7 & 16) == 0) goto L43;
        return ImageHeaderParser.ImageType.WEBP_A;
    L43:
        return ImageHeaderParser.ImageType.WEBP;
    L45:
        if (r6 != 76) goto L52;
        r5.skip(4);     // Catch: Reader.EndOfFileException -> L53
        if ((r5.getUInt8() & 8) == 0) goto L50;
        return ImageHeaderParser.ImageType.WEBP_A;
    L50:
        return ImageHeaderParser.ImageType.WEBP;
    L52:
        return ImageHeaderParser.ImageType.WEBP;
    L31:
        return ImageHeaderParser.ImageType.UNKNOWN;
    L27:
        return ImageHeaderParser.ImageType.UNKNOWN;
    L23:
        return sniffAvif(r5, r2);
    L9:
        return ImageHeaderParser.ImageType.GIF;
    L5:
        return ImageHeaderParser.ImageType.JPEG;
    L54:
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    private ImageHeaderParser.ImageType sniffAvif(Reader r7, int r8) throws IOException {
        if (((r7.getUInt16() << 16) | r7.getUInt16()) != FTYP_HEADER) goto L5;
        int r6 = (r7.getUInt16() << 16) | r7.getUInt16();
        if (r6 == AVIS_BRAND) goto L9;
        int r1 = 0;
        if (r6 != AVIF_BRAND) goto L13;
        boolean r9 = true;
    L14:
        r7.skip(4);
        int r10 = r8 - 16;
        if ((r10 % 4) == 0) goto L17;
    L26:
        if (r9 == false) goto L29;
        return ImageHeaderParser.ImageType.AVIF;
    L29:
        return ImageHeaderParser.ImageType.UNKNOWN;
    L17:
        if (r1 >= 5) goto L26;
        if (r10 <= 0) goto L26;
        int r4 = (r7.getUInt16() << 16) | r7.getUInt16();
        if (r4 == AVIS_BRAND) goto L22;
        if (r4 != AVIF_BRAND) goto L25;
        r9 = true;
    L25:
        r1 = r1 + 1;
        r10 = r10 - 4;
        goto L17
    L22:
        return ImageHeaderParser.ImageType.ANIMATED_AVIF;
    L13:
        r9 = false;
        goto L14
    L9:
        return ImageHeaderParser.ImageType.ANIMATED_AVIF;
    L5:
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    private int getOrientation(Reader r7, ArrayPool r8) throws IOException {
        int r2 = r7.getUInt16();     // Catch: Reader.EndOfFileException -> L23
        if (handles(r2) == false) goto L7;
        int r0 = moveToExifSegmentAndGetLength(r7);     // Catch: Reader.EndOfFileException -> L23
        if (r0 == (-1)) goto L13;
        byte[] r3 = (byte[]) r8.get(r0, byte[].class);     // Catch: Reader.EndOfFileException -> L23
        int r6 = parseExifSegment(r7, r3, r0);     // Catch: Throwable -> L20
        r8.put(r3);     // Catch: Reader.EndOfFileException -> L23
        return r6;
    L20:
        th = move-exception;
        r8.put(r3);     // Catch: Reader.EndOfFileException -> L23
        throw th;     // Catch: Reader.EndOfFileException -> L23
    L13:
        if (Log.isLoggable(TAG, 3) == false) goto L15;
        Log.d(TAG, "Failed to parse exif segment length, or exif segment not found");     // Catch: Reader.EndOfFileException -> L23
    L15:
        return -1;
    L7:
        if (Log.isLoggable(TAG, 3) == false) goto L9;
        Log.d(TAG, "Parser doesn't handle magic number: " + r2);     // Catch: Reader.EndOfFileException -> L23
    L9:
        return -1;
    L23:
        return -1;
    }

    private int parseExifSegment(Reader r4, byte[] r5, int r6) throws IOException {
        int r7 = r4.read(r5, r6);
        if (r7 == r6) goto L9;
        if (Log.isLoggable(TAG, 3) == false) goto L7;
        Log.d(TAG, "Unable to read exif segment data, length: " + r6 + ", actually read: " + r7);
    L7:
        return -1;
    L9:
        if (hasJpegExifPreamble(r5, r6) == false) goto L13;
        return parseExifSegment(new RandomAccessReader(r5, r6));
    L13:
        if (Log.isLoggable(TAG, 3) == false) goto L15;
        Log.d(TAG, "Missing jpeg exif preamble");
    L15:
        return -1;
    }

    private boolean hasJpegExifPreamble(byte[] r4, int r5) {
        if (r4 != null) goto L5;
    L7:
        boolean r6 = false;
    L8:
        if (r6 == false) goto L17;
        int r0 = 0;
    L10:
        byte[] r1 = JPEG_EXIF_SEGMENT_PREAMBLE_BYTES;
        if (r0 >= r1.length) goto L17;
        if (r4[r0] != r1[r0]) goto L20;
        r0 = r0 + 1;
        goto L10
    L20:
        return false;
    L17:
        return r6;
    L5:
        if (r5 <= JPEG_EXIF_SEGMENT_PREAMBLE_BYTES.length) goto L7;
        r6 = true;
        goto L8
    }

    private int moveToExifSegmentAndGetLength(Reader r9) throws IOException {
    L2:
        short r8 = r9.getUInt8();
        if (r8 != 255) goto L5;
        short r10 = r9.getUInt8();
        if (r10 == 218) goto L10;
        if (r10 == 217) goto L14;
        int r0 = r9.getUInt16() - 2;
        if (r10 == 225) goto L25;
        long r4 = r0;
        long r6 = r9.skip(r4);
        if (r6 == r4) goto L2;
        if (Log.isLoggable(TAG, 3) == false) goto L24;
        Log.d(TAG, "Unable to skip enough data, type: " + r10 + ", wanted to skip: " + r0 + ", but actually skipped: " + r6);
    L24:
        return -1;
    L25:
        return r0;
    L14:
        if (Log.isLoggable(TAG, 3) == false) goto L16;
        Log.d(TAG, "Found MARKER_EOI in exif segment");
    L16:
        return -1;
    L10:
        return -1;
    L5:
        if (Log.isLoggable(TAG, 3) == false) goto L7;
        Log.d(TAG, "Unknown segmentId=" + r8);
    L7:
        return -1;
    }

    private static int parseExifSegment(RandomAccessReader r12) {
        short r1 = r12.getInt16(6);
        if (r1 != INTEL_TIFF_MAGIC_NUMBER) goto L5;
        ByteOrder r2 = ByteOrder.LITTLE_ENDIAN;
    L12:
        r12.order(r2);
        int r3 = r12.getInt32(10) + 6;
        short r0 = r12.getInt16(r3);
        int r4 = 0;
    L13:
        if (r4 >= r0) goto L56;
        int r5 = calcTagOffset(r3, r4);
        short r6 = r12.getInt16(r5);
        if (r6 != 274) goto L55;
        short r7 = r12.getInt16(r5 + 2);
        if (r7 < 1) goto L53;
        if (r7 > 12) goto L53;
        int r8 = r12.getInt32(r5 + 4);
        if (r8 >= 0) goto L28;
        if (Log.isLoggable(TAG, 3) == false) goto L55;
        Log.d(TAG, "Negative tiff component count");
        goto L55
    L28:
        if (Log.isLoggable(TAG, 3) == false) goto L30;
        Log.d(TAG, "Got tagIndex=" + r4 + " tagType=" + r6 + " formatCode=" + r7 + " componentCount=" + r8);
    L30:
        int r9 = r8 + BYTES_PER_FORMAT[r7];
        if (r9 > 4) goto L33;
        int r10 = r5 + 8;
        if (r10 < 0) goto L50;
        if (r10 > r12.length()) goto L50;
        if (r9 < 0) goto L47;
        if ((r9 + r10) > r12.length()) goto L47;
        return r12.getInt16(r10);
    L47:
        if (Log.isLoggable(TAG, 3) == false) goto L55;
        Log.d(TAG, "Illegal number of bytes for TI tag data tagType=" + r6);
    L50:
        if (Log.isLoggable(TAG, 3) == false) goto L55;
        Log.d(TAG, "Illegal tagValueOffset=" + r10 + " tagType=" + r6);
        goto L55
    L33:
        if (Log.isLoggable(TAG, 3) == false) goto L55;
        Log.d(TAG, "Got byte count > 4, not orientation, continuing, formatCode=" + r7);
    L53:
        if (Log.isLoggable(TAG, 3) == false) goto L55;
        Log.d(TAG, "Got invalid format code = " + r7);
    L55:
        r4 = r4 + 1;
        goto L13
    L56:
        return -1;
    L5:
        if (r1 != MOTOROLA_TIFF_MAGIC_NUMBER) goto L7;
        r2 = ByteOrder.BIG_ENDIAN;
        goto L12
    L7:
        if (Log.isLoggable(TAG, 3) == false) goto L9;
        Log.d(TAG, "Unknown endianness = " + r1);
    L9:
        r2 = ByteOrder.BIG_ENDIAN;
        goto L12
    }
}
