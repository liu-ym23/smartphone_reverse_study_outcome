package com.bumptech.glide.load.resource.bitmap;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.MediaDataSource;
import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class VideoDecoder<T> implements ResourceDecoder<T, Bitmap> {
    private static final MediaMetadataRetrieverFactory DEFAULT_FACTORY = null;
    public static final long DEFAULT_FRAME = -1;
    static final int DEFAULT_FRAME_OPTION = 2;
    public static final Option<Integer> FRAME_OPTION = null;
    private static final List<String> PIXEL_T_BUILD_ID_PREFIXES_REQUIRING_HDR_180_ROTATION_FIX = null;
    private static final String TAG = "VideoDecoder";
    public static final Option<Long> TARGET_FRAME = null;
    private static final String WEBM_MIME_TYPE = "video/webm";
    private final BitmapPool bitmapPool;
    private final MediaMetadataRetrieverFactory factory;
    private final MediaInitializer<T> initializer;

    private static final class AssetFileDescriptorInitializer implements MediaInitializer<AssetFileDescriptor> {
        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaInitializer
        public /* bridge */ /* synthetic */ void initializeExtractor(MediaExtractor r1, AssetFileDescriptor r2) throws IOException {
            initializeExtractor2(r1, r2);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaInitializer
        public /* bridge */ /* synthetic */ void initializeRetriever(MediaMetadataRetriever r1, AssetFileDescriptor r2) {
            initializeRetriever2(r1, r2);
        }

        private AssetFileDescriptorInitializer() {
        }

        /* synthetic */ AssetFileDescriptorInitializer(AnonymousClass1 r1) {
            this();
        }

        /* JADX INFO: renamed from: initializeRetriever, reason: avoid collision after fix types in other method */
        public void initializeRetriever2(MediaMetadataRetriever r7, AssetFileDescriptor r8) {
            r7.setDataSource(r8.getFileDescriptor(), r8.getStartOffset(), r8.getLength());
        }

        /* JADX INFO: renamed from: initializeExtractor, reason: avoid collision after fix types in other method */
        public void initializeExtractor2(MediaExtractor r7, AssetFileDescriptor r8) throws IOException {
            r7.setDataSource(r8.getFileDescriptor(), r8.getStartOffset(), r8.getLength());
        }
    }

    static final class ByteBufferInitializer implements MediaInitializer<ByteBuffer> {
        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaInitializer
        public /* bridge */ /* synthetic */ void initializeExtractor(MediaExtractor r1, ByteBuffer r2) throws IOException {
            initializeExtractor2(r1, r2);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaInitializer
        public /* bridge */ /* synthetic */ void initializeRetriever(MediaMetadataRetriever r1, ByteBuffer r2) {
            initializeRetriever2(r1, r2);
        }

        ByteBufferInitializer() {
        }

        /* JADX INFO: renamed from: initializeRetriever, reason: avoid collision after fix types in other method */
        public void initializeRetriever2(MediaMetadataRetriever r1, ByteBuffer r2) {
            r1.setDataSource(getMediaDataSource(r2));
        }

        /* JADX INFO: renamed from: initializeExtractor, reason: avoid collision after fix types in other method */
        public void initializeExtractor2(MediaExtractor r1, ByteBuffer r2) throws IOException {
            r1.setDataSource(getMediaDataSource(r2));
        }

        private MediaDataSource getMediaDataSource(final ByteBuffer r2) {
            return new AnonymousClass1(this, r2);
        }
    }

    interface MediaInitializer<T> {
        void initializeExtractor(MediaExtractor r1, T r2) throws IOException;

        void initializeRetriever(MediaMetadataRetriever r1, T r2);
    }

    static class MediaMetadataRetrieverFactory {
        MediaMetadataRetrieverFactory() {
        }

        public MediaMetadataRetriever build() {
            return new MediaMetadataRetriever();
        }
    }

    static final class ParcelFileDescriptorInitializer implements MediaInitializer<ParcelFileDescriptor> {
        ParcelFileDescriptorInitializer() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaInitializer
        public /* bridge */ /* synthetic */ void initializeExtractor(MediaExtractor r1, ParcelFileDescriptor r2) throws IOException {
            initializeExtractor2(r1, r2);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaInitializer
        public /* bridge */ /* synthetic */ void initializeRetriever(MediaMetadataRetriever r1, ParcelFileDescriptor r2) {
            initializeRetriever2(r1, r2);
        }

        /* JADX INFO: renamed from: initializeRetriever, reason: avoid collision after fix types in other method */
        public void initializeRetriever2(MediaMetadataRetriever r1, ParcelFileDescriptor r2) {
            r1.setDataSource(r2.getFileDescriptor());
        }

        /* JADX INFO: renamed from: initializeExtractor, reason: avoid collision after fix types in other method */
        public void initializeExtractor2(MediaExtractor r1, ParcelFileDescriptor r2) throws IOException {
            r1.setDataSource(r2.getFileDescriptor());
        }
    }

    private static final class VideoDecoderException extends RuntimeException {
        private static final long serialVersionUID = -2556382523004027815L;

        VideoDecoderException() {
            super("MediaMetadataRetriever failed to retrieve a frame without throwing, check the adb logs for .*MetadataRetriever.* prior to this exception for details");
        }
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(T r1, Options r2) {
        return true;
    }

    static {
        TARGET_FRAME = Option.disk("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new AnonymousClass1());
        FRAME_OPTION = Option.disk("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new AnonymousClass2());
        DEFAULT_FACTORY = new MediaMetadataRetrieverFactory();
        PIXEL_T_BUILD_ID_PREFIXES_REQUIRING_HDR_180_ROTATION_FIX = Collections.unmodifiableList(Arrays.asList(new String[]{"TP1A", "TD1A.220804.031"}));
    }

    public static ResourceDecoder<AssetFileDescriptor, Bitmap> asset(BitmapPool r3) {
        return new VideoDecoder(r3, new AssetFileDescriptorInitializer(null));
    }

    public static ResourceDecoder<ParcelFileDescriptor, Bitmap> parcel(BitmapPool r2) {
        return new VideoDecoder(r2, new ParcelFileDescriptorInitializer());
    }

    public static ResourceDecoder<ByteBuffer, Bitmap> byteBuffer(BitmapPool r2) {
        return new VideoDecoder(r2, new ByteBufferInitializer());
    }

    VideoDecoder(BitmapPool r2, MediaInitializer<T> r3) {
        this(r2, r3, DEFAULT_FACTORY);
    }

    VideoDecoder(BitmapPool r1, MediaInitializer<T> r2, MediaMetadataRetrieverFactory r3) {
        this.bitmapPool = r1;
        this.initializer = r2;
        this.factory = r3;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<Bitmap> decode(T r11, int r12, int r13, Options r14) throws IOException {
        long r4 = ((Long) r14.get(TARGET_FRAME)).longValue();
        if (r4 < 0) goto L5;
    L9:
        Integer r0 = (Integer) r14.get(FRAME_OPTION);
        if (r0 != null) goto L12;
        r0 = 2;
    L12:
        DownsampleStrategy r15 = (DownsampleStrategy) r14.get(DownsampleStrategy.OPTION);
        if (r15 != null) goto L15;
        r15 = DownsampleStrategy.DEFAULT;
    L15:
        DownsampleStrategy r9 = r15;
        MediaMetadataRetriever r16 = this.factory.build();
        this.initializer.initializeRetriever(r16, r11);     // Catch: Throwable -> L19
        Bitmap r17 = decodeFrame(r11, r16, r4, r0.intValue(), r12, r13, r9);     // Catch: Throwable -> L19
        r16.close();
        return BitmapResource.obtain(r17, this.bitmapPool);
    L19:
        th = move-exception;
        r16.close();
        throw th;
    L5:
        if (r4 == (-1)) goto L9;
        throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + r4);
    }

    private Bitmap decodeFrame(T r1, MediaMetadataRetriever r2, long r3, int r5, int r6, int r7, DownsampleStrategy r8) {
        if (isUnsupportedFormat(r1, r2) == true) goto L19;
        if (r6 == Integer.MIN_VALUE) goto L10;
        if (r7 == Integer.MIN_VALUE) goto L10;
        if (r8 == DownsampleStrategy.NONE) goto L10;
        Bitmap r0 = decodeScaledFrame(r2, r3, r5, r6, r7, r8);
    L11:
        if (r0 != null) goto L13;
        r0 = decodeOriginalFrame(r2, r3, r5);
    L13:
        Bitmap r4 = correctHdr180DegVideoFrameOrientation(r2, r0);
        if (r4 == null) goto L17;
        return r4;
    L17:
        throw new VideoDecoderException();
    L10:
        r0 = null;
        goto L11
    L19:
        throw new IllegalStateException("Cannot decode VP8 video on CrOS.");
    }

    private static Bitmap correctHdr180DegVideoFrameOrientation(MediaMetadataRetriever r8, Bitmap r9) {
        if (isHdr180RotationFixRequired() == true) goto L5;
        return r9;
    L5:
        boolean r2 = false;
        if (isHDR(r8) == false) goto L15;
        if (Math.abs(Integer.parseInt(r8.extractMetadata(24))) != 180) goto L15;
        r2 = true;
    L15:
        if (r2 == true) goto L18;
        return r9;
    L18:
        if (Log.isLoggable(TAG, 3) == false) goto L20;
        Log.d(TAG, "Applying HDR 180 deg thumbnail correction");
    L20:
        Matrix r6 = new Matrix();
        r6.postRotate(180.0f, r9.getWidth() / 2.0f, r9.getHeight() / 2.0f);
        return Bitmap.createBitmap(r9, 0, 0, r9.getWidth(), r9.getHeight(), r6, true);
    L13:
        if (Log.isLoggable(TAG, 3) == false) goto L15;
        Log.d(TAG, "Exception trying to extract HDR transfer function or rotation");
        goto L15
    }

    private static boolean isHDR(MediaMetadataRetriever r3) throws NumberFormatException {
        String r0 = r3.extractMetadata(36);
        String r4 = r3.extractMetadata(35);
        int r1 = Integer.parseInt(r0);
        int r5 = Integer.parseInt(r4);
        if (r1 == 7) goto L5;
        if (r1 == 6) goto L5;
    L7:
        return false;
    L5:
        if (r5 != 6) goto L7;
        return true;
    }

    static boolean isHdr180RotationFixRequired() {
        if (Build.MODEL.startsWith("Pixel") == true) goto L5;
        return false;
    L5:
        if (Build.VERSION.SDK_INT == 33) goto L7;
        return false;
    L7:
        return isTBuildRequiringRotationFix();
    }

    private static boolean isTBuildRequiringRotationFix() {
        Iterator<String> r0 = PIXEL_T_BUILD_ID_PREFIXES_REQUIRING_HDR_180_ROTATION_FIX.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        String r1 = r0.next();
        if (Build.ID.startsWith(r1) == false) goto L4;
        return true;
    L9:
        return false;
    }

    private static Bitmap decodeScaledFrame(MediaMetadataRetriever r9, long r10, int r12, int r13, int r14, DownsampleStrategy r15) {
        int r0 = Integer.parseInt(r9.extractMetadata(18));     // Catch: Throwable -> L10
        int r1 = Integer.parseInt(r9.extractMetadata(19));     // Catch: Throwable -> L10
        int r2 = Integer.parseInt(r9.extractMetadata(24));     // Catch: Throwable -> L10
        if (r2 != 90) goto L6;
    L7:
        r1 = r0;
        r0 = r1;
    L8:
        float r16 = r15.getScaleFactor(r0, r1, r13, r14);     // Catch: Throwable -> L10
        return r9.getScaledFrameAtTime(r10, r12, Math.round(r0 * r16), Math.round(r16 * r1));
    L6:
        if (r2 != 270) goto L8;
    L10:
        th = move-exception;
        if (Log.isLoggable(TAG, 3) == false) goto L18;
        Log.d(TAG, "Exception trying to decode a scaled frame on oreo+, falling back to a fullsize frame", th);
        return null;
    L18:
        return null;
    }

    private static Bitmap decodeOriginalFrame(MediaMetadataRetriever r0, long r1, int r3) {
        return r0.getFrameAtTime(r1, r3);
    }

    private boolean isUnsupportedFormat(T r6, MediaMetadataRetriever r7) {
        if (Build.DEVICE != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L10;
        return false;
    L10:
        MediaExtractor r4 = null;
    L25:
        th = th;
    L41:
    L33:
        th = move-exception;
        if (r4 == null) goto L36;
        r4.release();
    L36:
        throw th;
    L28:
        if (Log.isLoggable(TAG, 3) == false) goto L30;
        Log.d(TAG, "Exception trying to extract track info for a webm video on CrOS.", th);     // Catch: Throwable -> L33
    L30:
        if (r4 == null) goto L32;
        r4.release();
    L32:
        return false;
    L12:
        if (WEBM_MIME_TYPE.equals(r7.extractMetadata(12)) == true) goto L14;
        return false;
    L14:
        MediaExtractor r8 = new MediaExtractor();     // Catch: Throwable -> L25
        this.initializer.initializeExtractor(r8, r6);     // Catch: Throwable -> L23
        int r5 = r8.getTrackCount();     // Catch: Throwable -> L23
        int r9 = 0;
    L16:
        if (r9 >= r5) goto L22;
        if ("video/x-vnd.on2.vp8".equals(r8.getTrackFormat(r9).getString("mime")) == true) goto L19;
        r9 = r9 + 1;
        goto L16
    L19:
        r8.release();
        return true;
    L22:
        r8.release();
    L23:
        th = th;
        r4 = r8;
        goto L41
    L5:
        if (Build.DEVICE.matches(".+_cheets|cheets_.+") == false) goto L7;
        r1 = true;
        goto L8
    }
}
