package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.data.InputStreamRewinder;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.ByteBufferUtil;
import com.bumptech.glide.util.Preconditions;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
interface ImageReader {

    public static final class ByteArrayReader implements ImageReader {
        private final ArrayPool byteArrayPool;
        private final byte[] bytes;
        private final List<ImageHeaderParser> parsers;

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public void stopGrowingBuffers() {
        }

        ByteArrayReader(byte[] r1, List<ImageHeaderParser> r2, ArrayPool r3) {
            this.bytes = r1;
            this.parsers = r2;
            this.byteArrayPool = r3;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public Bitmap decodeBitmap(BitmapFactory.Options r3) {
            byte[] r2 = this.bytes;
            return BitmapFactory.decodeByteArray(r2, 0, r2.length, r3);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public ImageHeaderParser.ImageType getImageType() throws IOException {
            return ImageHeaderParserUtils.getType(this.parsers, ByteBuffer.wrap(this.bytes));
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public int getImageOrientation() throws IOException {
            return ImageHeaderParserUtils.getOrientation(this.parsers, ByteBuffer.wrap(this.bytes), this.byteArrayPool);
        }
    }

    public static final class ByteBufferReader implements ImageReader {
        private final ByteBuffer buffer;
        private final ArrayPool byteArrayPool;
        private final List<ImageHeaderParser> parsers;

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public void stopGrowingBuffers() {
        }

        ByteBufferReader(ByteBuffer r1, List<ImageHeaderParser> r2, ArrayPool r3) {
            this.buffer = r1;
            this.parsers = r2;
            this.byteArrayPool = r3;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public Bitmap decodeBitmap(BitmapFactory.Options r2) {
            return BitmapFactory.decodeStream(stream(), null, r2);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public ImageHeaderParser.ImageType getImageType() throws IOException {
            return ImageHeaderParserUtils.getType(this.parsers, ByteBufferUtil.rewind(this.buffer));
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public int getImageOrientation() throws IOException {
            return ImageHeaderParserUtils.getOrientation(this.parsers, ByteBufferUtil.rewind(this.buffer), this.byteArrayPool);
        }

        private InputStream stream() {
            return ByteBufferUtil.toStream(ByteBufferUtil.rewind(this.buffer));
        }
    }

    public static final class FileReader implements ImageReader {
        private final ArrayPool byteArrayPool;
        private final File file;
        private final List<ImageHeaderParser> parsers;

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public void stopGrowingBuffers() {
        }

        FileReader(File r1, List<ImageHeaderParser> r2, ArrayPool r3) {
            this.file = r1;
            this.parsers = r2;
            this.byteArrayPool = r3;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public Bitmap decodeBitmap(BitmapFactory.Options r5) throws FileNotFoundException {
            RecyclableBufferedInputStream r0 = null;
            RecyclableBufferedInputStream r1 = new RecyclableBufferedInputStream(new FileInputStream(this.file), this.byteArrayPool);     // Catch: Throwable -> L9
            Bitmap r4 = BitmapFactory.decodeStream(r1, null, r5);     // Catch: Throwable -> L7
            r1.close();     // Catch: IOException -> L13
        L6:
            return r4;
        L7:
            th = th;
            r0 = r1;
        L10:
            if (r0 != null) goto L21;
        L12:
            throw th;
        L21:
            r0.close();     // Catch: IOException -> L14
        L9:
            th = th;
            goto L10
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public ImageHeaderParser.ImageType getImageType() throws IOException {
            RecyclableBufferedInputStream r0 = null;
            RecyclableBufferedInputStream r1 = new RecyclableBufferedInputStream(new FileInputStream(this.file), this.byteArrayPool);     // Catch: Throwable -> L9
            ImageHeaderParser.ImageType r4 = ImageHeaderParserUtils.getType(this.parsers, r1, this.byteArrayPool);     // Catch: Throwable -> L7
            r1.close();     // Catch: IOException -> L13
        L6:
            return r4;
        L7:
            th = th;
            r0 = r1;
        L10:
            if (r0 != null) goto L17;
        L12:
            throw th;
        L17:
            r0.close();     // Catch: IOException -> L14
        L9:
            th = th;
            goto L10
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public int getImageOrientation() throws IOException {
            RecyclableBufferedInputStream r0 = null;
            RecyclableBufferedInputStream r1 = new RecyclableBufferedInputStream(new FileInputStream(this.file), this.byteArrayPool);     // Catch: Throwable -> L9
            int r4 = ImageHeaderParserUtils.getOrientation(this.parsers, r1, this.byteArrayPool);     // Catch: Throwable -> L7
            r1.close();     // Catch: IOException -> L13
        L6:
            return r4;
        L7:
            th = th;
            r0 = r1;
        L10:
            if (r0 != null) goto L17;
        L12:
            throw th;
        L17:
            r0.close();     // Catch: IOException -> L14
        L9:
            th = th;
            goto L10
        }
    }

    public static final class InputStreamImageReader implements ImageReader {
        private final ArrayPool byteArrayPool;
        private final InputStreamRewinder dataRewinder;
        private final List<ImageHeaderParser> parsers;

        InputStreamImageReader(InputStream r2, List<ImageHeaderParser> r3, ArrayPool r4) {
            this.byteArrayPool = (ArrayPool) Preconditions.checkNotNull(r4);
            this.parsers = (List) Preconditions.checkNotNull(r3);
            this.dataRewinder = new InputStreamRewinder(r2, r4);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public Bitmap decodeBitmap(BitmapFactory.Options r2) throws IOException {
            return BitmapFactory.decodeStream(this.dataRewinder.rewindAndGet(), null, r2);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public ImageHeaderParser.ImageType getImageType() throws IOException {
            return ImageHeaderParserUtils.getType(this.parsers, this.dataRewinder.rewindAndGet(), this.byteArrayPool);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public int getImageOrientation() throws IOException {
            return ImageHeaderParserUtils.getOrientation(this.parsers, this.dataRewinder.rewindAndGet(), this.byteArrayPool);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public void stopGrowingBuffers() {
            this.dataRewinder.fixMarkLimits();
        }
    }

    public static final class ParcelFileDescriptorImageReader implements ImageReader {
        private final ArrayPool byteArrayPool;
        private final ParcelFileDescriptorRewinder dataRewinder;
        private final List<ImageHeaderParser> parsers;

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public void stopGrowingBuffers() {
        }

        ParcelFileDescriptorImageReader(ParcelFileDescriptor r1, List<ImageHeaderParser> r2, ArrayPool r3) {
            this.byteArrayPool = (ArrayPool) Preconditions.checkNotNull(r3);
            this.parsers = (List) Preconditions.checkNotNull(r2);
            this.dataRewinder = new ParcelFileDescriptorRewinder(r1);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public Bitmap decodeBitmap(BitmapFactory.Options r2) throws IOException {
            return BitmapFactory.decodeFileDescriptor(this.dataRewinder.rewindAndGet().getFileDescriptor(), null, r2);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public ImageHeaderParser.ImageType getImageType() throws IOException {
            return ImageHeaderParserUtils.getType(this.parsers, this.dataRewinder, this.byteArrayPool);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public int getImageOrientation() throws IOException {
            return ImageHeaderParserUtils.getOrientation(this.parsers, this.dataRewinder, this.byteArrayPool);
        }
    }

    Bitmap decodeBitmap(BitmapFactory.Options r1) throws IOException;

    int getImageOrientation() throws IOException;

    ImageHeaderParser.ImageType getImageType() throws IOException;

    void stopGrowingBuffers();
}
