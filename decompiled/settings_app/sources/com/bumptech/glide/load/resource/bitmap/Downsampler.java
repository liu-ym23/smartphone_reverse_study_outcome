package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class Downsampler {
    public static final Option<Boolean> ALLOW_HARDWARE_CONFIG = null;
    public static final Option<DecodeFormat> DECODE_FORMAT = null;

    @Deprecated
    public static final Option<DownsampleStrategy> DOWNSAMPLE_STRATEGY = null;
    private static final DecodeCallbacks EMPTY_CALLBACKS = null;
    public static final Option<Boolean> FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS = null;
    private static final String ICO_MIME_TYPE = "image/x-ico";
    private static final Set<String> NO_DOWNSAMPLE_PRE_N_MIME_TYPES = null;
    private static final Queue<BitmapFactory.Options> OPTIONS_QUEUE = null;
    public static final Option<PreferredColorSpace> PREFERRED_COLOR_SPACE = null;
    static final String TAG = "Downsampler";
    private static final Set<ImageHeaderParser.ImageType> TYPES_THAT_USE_POOL_PRE_KITKAT = null;
    private static final String WBMP_MIME_TYPE = "image/vnd.wap.wbmp";
    private final BitmapPool bitmapPool;
    private final ArrayPool byteArrayPool;
    private final DisplayMetrics displayMetrics;
    private final HardwareConfigState hardwareConfigState;
    private final List<ImageHeaderParser> parsers;

    public interface DecodeCallbacks {
        void onDecodeComplete(BitmapPool r1, Bitmap r2) throws IOException;

        void onObtainBounds();
    }

    private static boolean isRotationRequired(int r1) {
        if (r1 != 90) goto L5;
    L8:
        return true;
    L5:
        if (r1 == 270) goto L8;
        return false;
    }

    private static int round(double r2) {
        return (int) (r2 + 0.5d);
    }

    private boolean shouldUsePool(ImageHeaderParser.ImageType r1) {
        return true;
    }

    public boolean handles(InputStream r1) {
        return true;
    }

    public boolean handles(ByteBuffer r1) {
        return true;
    }

    static {
        DECODE_FORMAT = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);
        PREFERRED_COLOR_SPACE = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace");
        DOWNSAMPLE_STRATEGY = DownsampleStrategy.OPTION;
        FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", false);
        ALLOW_HARDWARE_CONFIG = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", false);
        NO_DOWNSAMPLE_PRE_N_MIME_TYPES = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{WBMP_MIME_TYPE, ICO_MIME_TYPE})));
        EMPTY_CALLBACKS = new AnonymousClass1();
        TYPES_THAT_USE_POOL_PRE_KITKAT = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        OPTIONS_QUEUE = Util.createQueue(0);
    }

    public Downsampler(List<ImageHeaderParser> r2, DisplayMetrics r3, BitmapPool r4, ArrayPool r5) {
        this.hardwareConfigState = HardwareConfigState.getInstance();
        this.parsers = r2;
        this.displayMetrics = (DisplayMetrics) Preconditions.checkNotNull(r3);
        this.bitmapPool = (BitmapPool) Preconditions.checkNotNull(r4);
        this.byteArrayPool = (ArrayPool) Preconditions.checkNotNull(r5);
    }

    public boolean handles(ParcelFileDescriptor r1) {
        return ParcelFileDescriptorRewinder.isSupported();
    }

    public Resource<Bitmap> decode(InputStream r7, int r8, int r9, Options r10) throws IOException {
        return decode(r7, r8, r9, r10, EMPTY_CALLBACKS);
    }

    public Resource<Bitmap> decode(ByteBuffer r7, int r8, int r9, Options r10) throws IOException {
        return decode(new ImageReader.ByteBufferReader(r7, this.parsers, this.byteArrayPool), r8, r9, r10, EMPTY_CALLBACKS);
    }

    public Resource<Bitmap> decode(InputStream r7, int r8, int r9, Options r10, DecodeCallbacks r11) throws IOException {
        return decode(new ImageReader.InputStreamImageReader(r7, this.parsers, this.byteArrayPool), r8, r9, r10, r11);
    }

    void decode(byte[] r7, int r8, int r9, Options r10) throws IOException {
        decode(new ImageReader.ByteArrayReader(r7, this.parsers, this.byteArrayPool), r8, r9, r10, EMPTY_CALLBACKS);
    }

    void decode(File r7, int r8, int r9, Options r10) throws IOException {
        decode(new ImageReader.FileReader(r7, this.parsers, this.byteArrayPool), r8, r9, r10, EMPTY_CALLBACKS);
    }

    public Resource<Bitmap> decode(ParcelFileDescriptor r7, int r8, int r9, Options r10) throws IOException {
        return decode(new ImageReader.ParcelFileDescriptorImageReader(r7, this.parsers, this.byteArrayPool), r8, r9, r10, EMPTY_CALLBACKS);
    }

    private Resource<Bitmap> decode(ImageReader r16, int r17, int r18, Options r19, DecodeCallbacks r20) throws IOException {
        byte[] r13 = (byte[]) this.byteArrayPool.get(65536, byte[].class);
        BitmapFactory.Options r14 = getDefaultOptions();
        r14.inTempStorage = r13;
        DecodeFormat r5 = (DecodeFormat) r19.get(DECODE_FORMAT);
        PreferredColorSpace r6 = (PreferredColorSpace) r19.get(PREFERRED_COLOR_SPACE);
        DownsampleStrategy r4 = (DownsampleStrategy) r19.get(DownsampleStrategy.OPTION);
        boolean r10 = ((Boolean) r19.get(FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS)).booleanValue();
        Option<Boolean> r1 = ALLOW_HARDWARE_CONFIG;
        if (r19.get(r1) != null) goto L5;
    L7:
        boolean r0 = false;
    L15:
        BitmapResource r2 = BitmapResource.obtain(decodeFromWrappedStreams(r16, r14, r4, r5, r6, r0, r17, r18, r10, r20), this.bitmapPool);     // Catch: Throwable -> L12
        releaseOptions(r14);
        this.byteArrayPool.put(r13);
        return r2;
    L12:
        th = move-exception;
        releaseOptions(r14);
        this.byteArrayPool.put(r13);
        throw th;
    L5:
        if (((Boolean) r19.get(r1)).booleanValue() == false) goto L7;
        r0 = true;
        goto L15
    }

    private Bitmap decodeFromWrappedStreams(ImageReader r30, BitmapFactory.Options r31, DownsampleStrategy r32, DecodeFormat r33, PreferredColorSpace r34, boolean r35, int r36, int r37, boolean r38, DecodeCallbacks r39) throws IOException {
        long r20 = LogTime.getLogTime();
        int[] r0 = getDimensions(r30, r31, r39, this.bitmapPool);
        boolean r22 = false;
        int r3 = r0[0];
        int r1 = r0[1];
        String r2 = r31.outMimeType;
        if (r3 == (-1)) goto L7;
        if (r1 == (-1)) goto L7;
        boolean r23 = r35;
    L8:
        int r15 = r30.getImageOrientation();
        int r14 = TransformationUtils.getExifOrientationDegrees(r15);
        boolean r24 = TransformationUtils.isExifOrientationRequired(r15);
        if (r36 != Integer.MIN_VALUE) goto L14;
        int r12 = r37;
        if (isRotationRequired(r14) == false) goto L13;
        int r25 = r1;
    L15:
        if (r12 == Integer.MIN_VALUE) goto L17;
        int r26 = r12;
    L21:
        ImageHeaderParser.ImageType r11 = r30.getImageType();
        calculateScaling(r11, r30, r39, this.bitmapPool, r32, r14, r3, r1, r25, r26, r31);
        calculateConfig(r30, r33, r23, r24, r31, r25, r26);
        int r4 = r31.inSampleSize;
        if (shouldUsePool(r11) == false) goto L37;
        if (r3 < 0) goto L28;
        if (r1 < 0) goto L28;
        if (r38 == false) goto L28;
        int r5 = r25;
        int r6 = r26;
    L34:
        if (r5 <= 0) goto L37;
        if (r6 <= 0) goto L37;
        setInBitmap(r31, this.bitmapPool, r5, r6);
    L28:
        if (isScaling(r31) == false) goto L30;
        float r7 = r31.inTargetDensity / r31.inDensity;
    L31:
        int r8 = r31.inSampleSize;
        float r9 = r8;
        int r10 = (int) Math.ceil(r3 / r9);
        int r13 = (int) Math.ceil(r1 / r9);
        r5 = Math.round(r10 * r7);
        r6 = Math.round(r13 * r7);
        if (Log.isLoggable(TAG, 2) == false) goto L34;
        Log.v(TAG, "Calculated target [" + r5 + MaterialConfigFormatNames.X + r6 + "] for source [" + r3 + MaterialConfigFormatNames.X + r1 + "], sampleSize: " + r8 + ", targetDensity: " + r31.inTargetDensity + ", density: " + r31.inDensity + ", density multiplier: " + r7);
        goto L34
    L30:
        r7 = 1.0f;
    L37:
        if (r34 != null) goto L39;
    L49:
        Bitmap r16 = decodeStream(r30, r31, r39, this.bitmapPool);
        r39.onDecodeComplete(this.bitmapPool, r16);
        if (Log.isLoggable(TAG, 2) == false) goto L52;
        logDecode(r3, r1, r2, r31, r16, r36, r37, r20);
    L52:
        if (r16 == null) goto L56;
        r16.setDensity(this.displayMetrics.densityDpi);
        Bitmap r17 = TransformationUtils.rotateImageExif(this.bitmapPool, r16, r15);
        if (r16.equals(r17) == true) goto L58;
        this.bitmapPool.put(r16);
        return r17;
    L58:
        return r17;
    L56:
        return null;
    L39:
        if (r34 == PreferredColorSpace.DISPLAY_P3) goto L41;
    L45:
        if (r22 == false) goto L47;
        ColorSpace.Named r18 = ColorSpace.Named.DISPLAY_P3;
    L48:
        r31.inPreferredColorSpace = ColorSpace.get(r18);
        goto L49
    L47:
        r18 = ColorSpace.Named.SRGB;
        goto L48
    L41:
        if (r31.outColorSpace == null) goto L45;
        if (r31.outColorSpace.isWideGamut() == false) goto L45;
        r22 = true;
        goto L45
    L17:
        if (isRotationRequired(r14) == false) goto L19;
        r26 = r3;
        goto L21
    L19:
        r26 = r1;
        goto L21
    L13:
        r25 = r3;
        goto L15
    L14:
        r12 = r37;
        r25 = r36;
    L7:
        r23 = false;
        goto L8
    }

    private static void calculateScaling(ImageHeaderParser.ImageType r16, ImageReader r17, DecodeCallbacks r18, BitmapPool r19, DownsampleStrategy r20, int r21, int r22, int r23, int r24, int r25, BitmapFactory.Options r26) throws IOException {
        if (r22 <= 0) goto L57;
        if (r23 <= 0) goto L57;
        if (isRotationRequired(r21) == false) goto L9;
        int r11 = r22;
        int r10 = r23;
    L10:
        float r12 = r20.getScaleFactor(r10, r11, r24, r25);
        if (r12 <= 0.0f) goto L55;
        DownsampleStrategy.SampleSizeRounding r7 = r20.getSampleSizeRounding(r10, r11, r24, r25);
        if (r7 == null) goto L53;
        float r13 = r10;
        int r14 = round(r12 * r13);
        float r15 = r11;
        int r3 = r10 / r14;
        int r2 = r11 / round(r12 * r15);
        if (r7 != DownsampleStrategy.SampleSizeRounding.MEMORY) goto L17;
        int r4 = Math.max(r3, r2);
    L18:
        int r5 = Math.max(1, Integer.highestOneBit(r4));
        if (r7 == DownsampleStrategy.SampleSizeRounding.MEMORY) goto L21;
    L23:
        r26.inSampleSize = r5;
        if (r16 != ImageHeaderParser.ImageType.JPEG) goto L29;
        float r0 = Math.min(r5, 8);
        int r8 = (int) Math.ceil(r13 / r0);
        int r1 = (int) Math.ceil(r15 / r0);
        int r110 = r5 / 8;
        if (r110 <= 0) goto L44;
        r8 = r8 / r110;
        r1 = r1 / r110;
    L44:
        double r111 = r20.getScaleFactor(r8, r1, r24, r25);
        r26.inTargetDensity = adjustTargetDensityForError(r111);
        r26.inDensity = getDensityMultiplier(r111);
        if (isScaling(r26) == false) goto L47;
        r26.inScaled = true;
    L49:
        if (Log.isLoggable(TAG, 2) == false) goto L60;
        Log.v(TAG, "Calculate scaling, source: [" + r22 + MaterialConfigFormatNames.X + r23 + "], degreesToRotate: " + r21 + ", target: [" + r24 + MaterialConfigFormatNames.X + r25 + "], power of two scaled: [" + r8 + MaterialConfigFormatNames.X + r1 + "], exact scale factor: " + r12 + ", power of 2 sample size: " + r5 + ", adjusted scale factor: " + r111 + ", target density: " + r26.inTargetDensity + ", density: " + r26.inDensity);
        return;
    L60:
        return;
    L47:
        r26.inTargetDensity = 0;
        r26.inDensity = 0;
        goto L49
    L29:
        if (r16 != ImageHeaderParser.ImageType.PNG) goto L31;
    L43:
        float r6 = r5;
        r8 = (int) Math.floor(r13 / r6);
        r1 = (int) Math.floor(r15 / r6);
        goto L44
    L31:
        if (r16 == ImageHeaderParser.ImageType.PNG_A) goto L43;
        if (r16.isWebp() == false) goto L37;
        float r9 = r5;
        r8 = Math.round(r13 / r9);
        r1 = Math.round(r15 / r9);
        goto L44
    L37:
        if ((r10 % r5) == 0) goto L39;
    L42:
        int[] r27 = getDimensions(r17, r26, r18, r19);
        r8 = r27[0];
        r1 = r27[1];
        goto L44
    L39:
        if ((r11 % r5) != 0) goto L42;
        r8 = r10 / r5;
        r1 = r11 / r5;
        goto L44
    L21:
        if (r5 >= (1.0f / r12)) goto L23;
        r5 = r5 << 1;
        goto L23
    L17:
        r4 = Math.min(r3, r2);
        goto L18
    L53:
        throw new IllegalArgumentException("Cannot round with null rounding");
    L55:
        throw new IllegalArgumentException("Cannot scale with factor: " + r12 + " from: " + r20 + ", source: [" + r22 + MaterialConfigFormatNames.X + r23 + "], target: [" + r24 + MaterialConfigFormatNames.X + r25 + "]");
    L9:
        r10 = r22;
        r11 = r23;
    L57:
        if (Log.isLoggable(TAG, 3) == false) goto L61;
        Log.d(TAG, "Unable to determine dimensions for: " + r16 + " with target [" + r24 + MaterialConfigFormatNames.X + r25 + "]");
        return;
    }

    private static int adjustTargetDensityForError(double r4) {
        int r0 = getDensityMultiplier(r4);
        int r1 = round(((double) r0) * r4);
        return round((r4 / ((double) (r1 / r0))) * ((double) r1));
    }

    private static int getDensityMultiplier(double r3) {
        if (r3 <= 1.0d) goto L7;
        r3 = 1.0d / r3;
    L7:
        return (int) Math.round(r3 * 2.147483647E9d);
    }

    private void calculateConfig(ImageReader r7, DecodeFormat r8, boolean r9, boolean r10, BitmapFactory.Options r11, int r12, int r13) {
        if (this.hardwareConfigState.setHardwareConfigIfAllowed(r12, r13, r11, r9, r10) == false) goto L6;
        return;
    L6:
        if (r8 != DecodeFormat.PREFER_ARGB_8888) goto L23;
        r11.inPreferredConfig = Bitmap.Config.ARGB_8888;
        return;
    L23:
        boolean r6 = r7.getImageType().hasAlpha();     // Catch: IOException -> L9
    L14:
        if (r6 == false) goto L16;
        Bitmap.Config r14 = Bitmap.Config.ARGB_8888;
    L17:
        r11.inPreferredConfig = r14;
        if (r11.inPreferredConfig != Bitmap.Config.RGB_565) goto L25;
        r11.inDither = true;
        return;
    L25:
        return;
    L16:
        r14 = Bitmap.Config.RGB_565;
    L9:
        e = move-exception;
        if (Log.isLoggable(TAG, 3) == false) goto L13;
        Log.d(TAG, "Cannot determine whether the image has alpha or not from header, format " + r8, e);
    L13:
        r6 = false;
        goto L14
    }

    private static int[] getDimensions(ImageReader r1, BitmapFactory.Options r2, DecodeCallbacks r3, BitmapPool r4) throws IOException {
        r2.inJustDecodeBounds = true;
        decodeStream(r1, r2, r3, r4);
        r2.inJustDecodeBounds = false;
        return new int[]{r2.outWidth, r2.outHeight};
    }

    private static Bitmap decodeStream(ImageReader r5, BitmapFactory.Options r6, DecodeCallbacks r7, BitmapPool r8) throws IOException {
        if (r6.inJustDecodeBounds == true) goto L5;
        r7.onObtainBounds();
        r5.stopGrowingBuffers();
    L5:
        int r1 = r6.outWidth;
        int r2 = r6.outHeight;
        String r3 = r6.outMimeType;
        TransformationUtils.getBitmapDrawableLock().lock();
        Bitmap r9 = r5.decodeBitmap(r6);     // Catch: Throwable -> L9 IllegalArgumentException -> L11
        TransformationUtils.getBitmapDrawableLock().unlock();
        return r9;
    L9:
        th = move-exception;
        TransformationUtils.getBitmapDrawableLock().unlock();
        throw th;
    L11:
        e = move-exception;
        IOException r4 = newIoExceptionForInBitmapAssertion(e, r1, r2, r3, r6);     // Catch: Throwable -> L9
        if (Log.isLoggable(TAG, 3) == false) goto L16;
        Log.d(TAG, "Failed to decode with inBitmap, trying again without Bitmap re-use", r4);     // Catch: Throwable -> L9
    L16:
        if (r6.inBitmap != null) goto L25;
        throw r4;     // Catch: Throwable -> L9
    L25:
        r8.put(r6.inBitmap);     // Catch: Throwable -> L9 IOException -> L20
        r6.inBitmap = null;     // Catch: Throwable -> L9 IOException -> L20
        Bitmap r10 = decodeStream(r5, r6, r7, r8);     // Catch: Throwable -> L9 IOException -> L20
        TransformationUtils.getBitmapDrawableLock().unlock();
        return r10;
    L28:
        throw r4;     // Catch: Throwable -> L9
    L20:
        throw r4;     // Catch: Throwable -> L9
    }

    private static boolean isScaling(BitmapFactory.Options r1) {
        if (r1.inTargetDensity > 0) goto L5;
    L9:
        return false;
    L5:
        if (r1.inDensity <= 0) goto L9;
        if (r1.inTargetDensity == r1.inDensity) goto L9;
        return true;
    }

    private static void logDecode(int r2, int r3, String r4, BitmapFactory.Options r5, Bitmap r6, int r7, int r8, long r9) {
        Log.v(TAG, "Decoded " + getBitmapString(r6) + " from [" + r2 + MaterialConfigFormatNames.X + r3 + "] " + r4 + " with inBitmap " + getInBitmapString(r5) + " for [" + r7 + MaterialConfigFormatNames.X + r8 + "], sample size: " + r5.inSampleSize + ", density: " + r5.inDensity + ", target density: " + r5.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + LogTime.getElapsedMillis(r9));
    }

    private static String getInBitmapString(BitmapFactory.Options r0) {
        return getBitmapString(r0.inBitmap);
    }

    private static String getBitmapString(Bitmap r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        return "[" + r3.getWidth() + MaterialConfigFormatNames.X + r3.getHeight() + "] " + r3.getConfig() + (" (" + r3.getAllocationByteCount() + ")");
    }

    private static IOException newIoExceptionForInBitmapAssertion(IllegalArgumentException r3, int r4, int r5, String r6, BitmapFactory.Options r7) {
        return new IOException("Exception decoding bitmap, outWidth: " + r4 + ", outHeight: " + r5 + ", outMimeType: " + r6 + ", inBitmap: " + getInBitmapString(r7), r3);
    }

    private static void setInBitmap(BitmapFactory.Options r2, BitmapPool r3, int r4, int r5) {
        if (r2.inPreferredConfig != Bitmap.Config.HARDWARE) goto L5;
        return;
    L5:
        Bitmap.Config r0 = r2.outConfig;
        if (r0 != null) goto L8;
        r0 = r2.inPreferredConfig;
    L8:
        r2.inBitmap = r3.getDirty(r4, r5, r0);
    }

    private static synchronized BitmapFactory.Options getDefaultOptions() {
        monitor-enter(Downsampler.class);
        Queue<BitmapFactory.Options> r1 = OPTIONS_QUEUE;     // Catch: Throwable -> L15
        monitor-enter(r1);     // Catch: Throwable -> L15
        BitmapFactory.Options r2 = r1.poll();     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        if (r2 != null) goto L10;
        r2 = new BitmapFactory.Options();     // Catch: Throwable -> L15
        resetOptions(r2);     // Catch: Throwable -> L15
    L10:
        monitor-exit(Downsampler.class);
        return r2;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    private static void releaseOptions(BitmapFactory.Options r1) {
        resetOptions(r1);
        Queue<BitmapFactory.Options> r0 = OPTIONS_QUEUE;
        monitor-enter(r0);
        r0.offer(r1);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void resetOptions(BitmapFactory.Options r3) {
        r3.inTempStorage = null;
        r3.inDither = false;
        r3.inScaled = false;
        r3.inSampleSize = 1;
        r3.inPreferredConfig = null;
        r3.inJustDecodeBounds = false;
        r3.inDensity = 0;
        r3.inTargetDensity = 0;
        r3.inPreferredColorSpace = null;
        r3.outColorSpace = null;
        r3.outConfig = null;
        r3.outWidth = 0;
        r3.outHeight = 0;
        r3.outMimeType = null;
        r3.inBitmap = null;
        r3.inMutable = true;
    }
}
