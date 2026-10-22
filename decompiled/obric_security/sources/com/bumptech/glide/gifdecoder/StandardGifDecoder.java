package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.fragment.app.FragmentTransaction;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public class StandardGifDecoder implements GifDecoder {
    private static final int BYTES_PER_INTEGER = 4;
    private static final int COLOR_TRANSPARENT_BLACK = 0;
    private static final int INITIAL_FRAME_POINTER = -1;
    private static final int MASK_INT_LOWEST_BYTE = 255;
    private static final int MAX_STACK_SIZE = 4096;
    private static final int NULL_CODE = -1;
    private static final String TAG = "StandardGifDecoder";
    private int[] act;
    private Bitmap.Config bitmapConfig;
    private final GifDecoder.BitmapProvider bitmapProvider;
    private byte[] block;
    private int downsampledHeight;
    private int downsampledWidth;
    private int framePointer;
    private GifHeader header;
    private Boolean isFirstFrameTransparent;
    private byte[] mainPixels;
    private int[] mainScratch;
    private GifHeaderParser parser;
    private final int[] pct;
    private byte[] pixelStack;
    private short[] prefix;
    private Bitmap previousImage;
    private ByteBuffer rawData;
    private int sampleSize;
    private boolean savePrevious;
    private int status;
    private byte[] suffix;

    static {
    }

    public StandardGifDecoder(GifDecoder.BitmapProvider r2, GifHeader r3, ByteBuffer r4) {
        this(r2, r3, r4, 1);
    }

    public StandardGifDecoder(GifDecoder.BitmapProvider r1, GifHeader r2, ByteBuffer r3, int r4) {
        this(r1);
        setData(r2, r3, r4);
    }

    public StandardGifDecoder(GifDecoder.BitmapProvider r2) {
        this.pct = new int[256];
        this.bitmapConfig = Bitmap.Config.ARGB_8888;
        this.bitmapProvider = r2;
        this.header = new GifHeader();
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getWidth() {
        return this.header.width;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getHeight() {
        return this.header.height;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public ByteBuffer getData() {
        return this.rawData;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getStatus() {
        return this.status;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void advance() {
        this.framePointer = (this.framePointer + 1) % this.header.frameCount;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getDelay(int r2) {
        if (r2 >= 0) goto L4;
    L6:
        return -1;
    L4:
        if (r2 >= this.header.frameCount) goto L6;
        return this.header.frames.get(r2).delay;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getNextDelay() {
        if (this.header.frameCount <= 0) goto L9;
        int r0 = this.framePointer;
        if (r0 >= 0) goto L8;
        return 0;
    L8:
        return getDelay(r0);
    L9:
        return 0;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getFrameCount() {
        return this.header.frameCount;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getCurrentFrameIndex() {
        return this.framePointer;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void resetFrameIndex() {
        this.framePointer = -1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @Deprecated
    public int getLoopCount() {
        if (this.header.loopCount != (-1)) goto L7;
        return 1;
    L7:
        return this.header.loopCount;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getNetscapeLoopCount() {
        return this.header.loopCount;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getTotalIterationCount() {
        if (this.header.loopCount != (-1)) goto L6;
        return 1;
    L6:
        if (this.header.loopCount != 0) goto L10;
        return 0;
    L10:
        return this.header.loopCount + 1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getByteSize() {
        return (this.rawData.limit() + this.mainPixels.length) + (this.mainScratch.length * 4);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized Bitmap getNextFrame() {
        monitor-enter(this);
    L51:
        th = move-exception;
        throw th;
    L5:
        if (this.header.frameCount > 0) goto L7;
    L8:
        String r3 = TAG;     // Catch: Throwable -> L51
        if (Log.isLoggable(r3, 3) == false) goto L11;
        Log.d(r3, "Unable to decode frame, frameCount=" + this.header.frameCount + ", framePointer=" + this.framePointer);     // Catch: Throwable -> L51
    L11:
        this.status = 1;     // Catch: Throwable -> L51
    L12:
        int r2 = this.status;     // Catch: Throwable -> L51
        if (r2 != 1) goto L15;
    L46:
        String r0 = TAG;     // Catch: Throwable -> L51
        if (Log.isLoggable(r0, 3) == false) goto L49;
        Log.d(r0, "Unable to decode frame, status=" + this.status);     // Catch: Throwable -> L51
    L49:
        monitor-exit(this);
        return null;
    L15:
        if (r2 == 2) goto L46;
        this.status = 0;     // Catch: Throwable -> L51
        if (this.block != null) goto L20;
        this.block = this.bitmapProvider.obtainByteArray(255);     // Catch: Throwable -> L51
    L20:
        GifFrame r4 = this.header.frames.get(this.framePointer);     // Catch: Throwable -> L51
        int r7 = this.framePointer - 1;     // Catch: Throwable -> L51
        if (r7 < 0) goto L23;
        GifFrame r8 = this.header.frames.get(r7);     // Catch: Throwable -> L51
    L25:
        if (r4.lct == null) goto L27;
        int[] r9 = r4.lct;     // Catch: Throwable -> L51
    L28:
        this.act = r9;     // Catch: Throwable -> L51
        if (r9 != null) goto L37;
        String r1 = TAG;     // Catch: Throwable -> L51
        if (Log.isLoggable(r1, 3) == false) goto L33;
        Log.d(r1, "No valid color table found for frame #" + this.framePointer);     // Catch: Throwable -> L51
    L33:
        this.status = 1;     // Catch: Throwable -> L51
        monitor-exit(this);
        return null;
    L37:
        if (r4.transparency == false) goto L43;
        int[] r5 = this.act;     // Catch: Throwable -> L51
        System.arraycopy(r5, 0, this.pct, 0, r5.length);     // Catch: Throwable -> L51
        int[] r6 = this.pct;     // Catch: Throwable -> L51
        this.act = r6;     // Catch: Throwable -> L51
        r6[r4.transIndex] = 0;     // Catch: Throwable -> L51
        if (r4.dispose != 2) goto L43;
        if (this.framePointer != 0) goto L43;
        this.isFirstFrameTransparent = true;     // Catch: Throwable -> L51
    L43:
        Bitmap r10 = setPixels(r4, r8);     // Catch: Throwable -> L51
        monitor-exit(this);
        return r10;
    L27:
        r9 = this.header.gct;     // Catch: Throwable -> L51
        goto L28
    L23:
        r8 = null;
        goto L25
    L7:
        if (this.framePointer >= 0) goto L12;
        goto L8
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int read(InputStream r6, int r7) {
        if (r6 != null) goto L4;
        this.status = 2;
    L16:
        if (r6 == null) goto L22;
        r6.close();     // Catch: IOException -> L19
    L19:
        e = move-exception;
        Log.w(TAG, "Error closing stream", e);
    L22:
        return this.status;
    L4:
        if (r7 <= 0) goto L6;
        int r8 = r7 + 4096;
    L25:
        ByteArrayOutputStream r1 = new ByteArrayOutputStream(r8);     // Catch: IOException -> L13
        byte[] r9 = new byte[16384];     // Catch: IOException -> L13
    L8:
        int r3 = r6.read(r9, 0, 16384);     // Catch: IOException -> L13
        if (r3 == (-1)) goto L11;
        r1.write(r9, 0, r3);     // Catch: IOException -> L13
        goto L8
    L11:
        r1.flush();     // Catch: IOException -> L13
        read(r1.toByteArray());     // Catch: IOException -> L13
    L13:
        e = move-exception;
        Log.w(TAG, "Error reading data from stream", e);
        goto L16
    L6:
        r8 = 16384;
        goto L25
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void clear() {
        this.header = null;
        byte[] r1 = this.mainPixels;
        if (r1 == null) goto L5;
        this.bitmapProvider.release(r1);
    L5:
        int[] r2 = this.mainScratch;
        if (r2 == null) goto L8;
        this.bitmapProvider.release(r2);
    L8:
        Bitmap r3 = this.previousImage;
        if (r3 == null) goto L11;
        this.bitmapProvider.release(r3);
    L11:
        this.previousImage = null;
        this.rawData = null;
        this.isFirstFrameTransparent = null;
        byte[] r0 = this.block;
        if (r0 == null) goto L15;
        this.bitmapProvider.release(r0);
        return;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void setData(GifHeader r1, byte[] r2) {
        monitor-enter(this);
        setData(r1, ByteBuffer.wrap(r2));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void setData(GifHeader r2, ByteBuffer r3) {
        monitor-enter(this);
        setData(r2, r3, 1);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void setData(GifHeader r3, ByteBuffer r4, int r5) {
        monitor-enter(this);
        if (r5 <= 0) goto L17;
        int r6 = Integer.highestOneBit(r5);     // Catch: Throwable -> L14
        this.status = 0;     // Catch: Throwable -> L14
        this.header = r3;     // Catch: Throwable -> L14
        this.framePointer = -1;     // Catch: Throwable -> L14
        ByteBuffer r7 = r4.asReadOnlyBuffer();     // Catch: Throwable -> L14
        this.rawData = r7;     // Catch: Throwable -> L14
        r7.position(0);     // Catch: Throwable -> L14
        this.rawData.order(ByteOrder.LITTLE_ENDIAN);     // Catch: Throwable -> L14
        this.savePrevious = false;     // Catch: Throwable -> L14
        Iterator<GifFrame> r8 = r3.frames.iterator();     // Catch: Throwable -> L14
    L7:
        if (r8.hasNext() == false) goto L11;
        if (r8.next().dispose != 3) goto L7;
        this.savePrevious = true;     // Catch: Throwable -> L14
    L11:
        this.sampleSize = r6;     // Catch: Throwable -> L14
        this.downsampledWidth = r3.width / r6;     // Catch: Throwable -> L14
        this.downsampledHeight = r3.height / r6;     // Catch: Throwable -> L14
        this.mainPixels = this.bitmapProvider.obtainByteArray(r3.width * r3.height);     // Catch: Throwable -> L14
        this.mainScratch = this.bitmapProvider.obtainIntArray(this.downsampledWidth * this.downsampledHeight);     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L17:
        throw new IllegalArgumentException("Sample size must be >=0, not: " + r5);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    private GifHeaderParser getHeaderParser() {
        if (this.parser != null) goto L6;
        this.parser = new GifHeaderParser();
    L6:
        return this.parser;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized int read(byte[] r2) {
        monitor-enter(this);
        GifHeader r0 = getHeaderParser().setData(r2).parseHeader();     // Catch: Throwable -> L9
        this.header = r0;     // Catch: Throwable -> L9
        if (r2 == null) goto L6;
        setData(r0, r2);     // Catch: Throwable -> L9
    L6:
        int r3 = this.status;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void setDefaultBitmapConfig(Bitmap.Config r3) {
        if (r3 != Bitmap.Config.ARGB_8888) goto L5;
    L9:
        this.bitmapConfig = r3;
        return;
    L5:
        if (r3 == Bitmap.Config.RGB_565) goto L9;
        throw new IllegalArgumentException("Unsupported format: " + r3 + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
    }

    private Bitmap setPixels(GifFrame r10, GifFrame r11) {
        int[] r8 = this.mainScratch;
        int r0 = 0;
        if (r11 != null) goto L9;
        Bitmap r1 = this.previousImage;
        if (r1 == null) goto L7;
        this.bitmapProvider.release(r1);
    L7:
        this.previousImage = null;
        Arrays.fill(r8, 0);
    L9:
        if (r11 != null) goto L11;
    L15:
        if (r11 != null) goto L17;
    L39:
        decodeBitmapData(r10);
        if (r10.interlace == false) goto L42;
    L45:
        copyCopyIntoScratchRobust(r10);
    L47:
        if (this.savePrevious == true) goto L49;
    L56:
        Bitmap r12 = getNextBitmap();
        int r6 = this.downsampledWidth;
        r12.setPixels(r8, 0, r6, 0, 0, r6, this.downsampledHeight);
        return r12;
    L49:
        if (r10.dispose == 0) goto L53;
        if (r10.dispose != 1) goto L56;
    L53:
        if (this.previousImage != null) goto L55;
        this.previousImage = getNextBitmap();
    L55:
        Bitmap r2 = this.previousImage;
        int r7 = this.downsampledWidth;
        r2.setPixels(r8, 0, r7, 0, 0, r7, this.downsampledHeight);
        goto L56
    L42:
        if (this.sampleSize != 1) goto L45;
        copyIntoScratchFast(r10);
        goto L47
    L17:
        if (r11.dispose <= 0) goto L39;
        if (r11.dispose != 2) goto L35;
        if (r10.transparency == true) goto L28;
        int r3 = this.header.bgColor;
        if (r10.lct != null) goto L25;
    L27:
        r0 = r3;
        goto L28
    L25:
        if (this.header.bgIndex != r10.transIndex) goto L27;
    L28:
        int r4 = r11.ih / this.sampleSize;
        int r5 = r11.iy / this.sampleSize;
        int r9 = r11.iw / this.sampleSize;
        int r13 = r11.ix / this.sampleSize;
        int r14 = this.downsampledWidth;
        int r15 = (r5 * r14) + r13;
        int r16 = (r4 * r14) + r15;
    L29:
        if (r15 >= r16) goto L39;
        int r17 = r15 + r9;
        int r18 = r15;
    L31:
        if (r18 >= r17) goto L33;
        r8[r18] = r0;
        r18 = r18 + 1;
        goto L31
    L33:
        r15 = r15 + this.downsampledWidth;
        goto L29
    L35:
        if (r11.dispose != 3) goto L39;
        Bitmap r19 = this.previousImage;
        if (r19 == null) goto L39;
        int r20 = this.downsampledWidth;
        r19.getPixels(r8, 0, r20, 0, 0, r20, this.downsampledHeight);
        goto L39
    L11:
        if (r11.dispose != 3) goto L15;
        if (this.previousImage != null) goto L15;
        Arrays.fill(r8, 0);
        goto L15
    }

    private void copyIntoScratchFast(GifFrame r19) {
        GifFrame r1 = r19;
        int[] r2 = this.mainScratch;
        int r3 = r1.ih;
        int r4 = r1.iy;
        int r5 = r1.iw;
        int r6 = r1.ix;
        if (this.framePointer != 0) goto L5;
        boolean r7 = true;
    L6:
        int r10 = this.downsampledWidth;
        byte[] r11 = this.mainPixels;
        int[] r12 = this.act;
        int r14 = 0;
        byte r15 = -1;
    L7:
        if (r14 >= r3) goto L21;
        int r16 = (r14 + r4) * r10;
        int r17 = r16 + r6;
        int r8 = r17 + r5;
        int r9 = r16 + r10;
        if (r9 >= r8) goto L11;
        r8 = r9;
    L11:
        int r13 = r1.iw * r14;
        int r18 = r17;
    L12:
        if (r18 >= r8) goto L20;
        byte r20 = r11[r13];
        int r110 = r3;
        int r21 = r20 & UByte.MAX_VALUE;
        if (r21 == r15) goto L19;
        int r22 = r12[r21];
        if (r22 == 0) goto L18;
        r2[r18] = r22;
        goto L19
    L18:
        r15 = r20;
    L19:
        r13 = r13 + 1;
        r18 = r18 + 1;
        r3 = r110;
        goto L12
    L20:
        r14 = r14 + 1;
        r1 = r19;
        goto L7
    L21:
        Boolean r23 = this.isFirstFrameTransparent;
        if (r23 == null) goto L26;
        if (r23.booleanValue() == false) goto L26;
    L30:
        boolean r24 = true;
    L32:
        this.isFirstFrameTransparent = Boolean.valueOf(r24);
        return;
    L26:
        if (this.isFirstFrameTransparent != null) goto L31;
        if (r7 == false) goto L31;
        if (r15 != (-1)) goto L30;
    L31:
        r24 = false;
        goto L32
    L5:
        r7 = false;
        goto L6
    }

    private void copyCopyIntoScratchRobust(GifFrame r25) {
        int[] r2 = this.mainScratch;
        int r3 = r25.ih / this.sampleSize;
        int r4 = r25.iy / this.sampleSize;
        int r5 = r25.iw / this.sampleSize;
        int r6 = r25.ix;
        int r7 = this.sampleSize;
        int r8 = r6 / r7;
        if (this.framePointer != 0) goto L5;
        boolean r9 = true;
    L6:
        int r12 = this.downsampledWidth;
        int r13 = this.downsampledHeight;
        byte[] r14 = this.mainPixels;
        int[] r15 = this.act;
        Boolean r11 = this.isFirstFrameTransparent;
        int r16 = 8;
        int r19 = 1;
        int r10 = 0;
        int r17 = 0;
    L7:
        if (r10 >= r3) goto L56;
        Boolean r20 = r11;
        if (r25.interlace == false) goto L23;
        if (r17 < r3) goto L21;
        int r18 = r19 + 1;
        int r21 = r3;
        if (r18 != 2) goto L14;
        r17 = 4;
    L17:
        r19 = r18;
    L22:
        int r22 = r17 + r16;
    L24:
        int r110 = r17 + r4;
        if (r7 != 1) goto L27;
        boolean r111 = true;
    L28:
        if (r110 >= r13) goto L53;
        int r112 = r110 * r12;
        int r23 = r112 + r8;
        int r113 = r23 + r5;
        int r114 = r112 + r12;
        if (r114 >= r113) goto L32;
        r113 = r114;
    L32:
        int r24 = r22;
        int r115 = (r10 * r7) * r25.iw;
        if (r111 == false) goto L43;
        int r26 = r23;
    L35:
        if (r26 >= r113) goto L54;
        int r116 = r4;
        int r27 = r15[r14[r115] & UByte.MAX_VALUE];
        if (r27 == 0) goto L39;
        r2[r26] = r27;
    L42:
        r115 = r115 + r7;
        r26 = r26 + 1;
        r4 = r116;
        goto L35
    L39:
        if (r9 == false) goto L42;
        if (r20 != null) goto L42;
        r20 = true;
    L54:
        int r117 = r4;
        int r28 = r5;
    L55:
        r11 = r20;
        r10 = r10 + 1;
        r4 = r117;
        r3 = r21;
        r5 = r28;
        r17 = r24;
        goto L7
    L43:
        r117 = r4;
        int r29 = ((r113 - r23) * r7) + r115;
        int r30 = r23;
    L44:
        r28 = r5;
        if (r30 >= r113) goto L55;
        int r31 = averageColorsNear(r115, r29, r25.iw);
        if (r31 == 0) goto L49;
        r2[r30] = r31;
    L52:
        r115 = r115 + r7;
        r30 = r30 + 1;
        r5 = r28;
        goto L44
    L49:
        if (r9 == false) goto L52;
        if (r20 != null) goto L52;
        r20 = true;
        goto L52
    L53:
        r24 = r22;
        goto L54
    L27:
        r111 = false;
        goto L28
    L14:
        if (r18 != 3) goto L16;
        r16 = 4;
        r19 = r18;
        r17 = 2;
        goto L22
    L16:
        if (r18 != 4) goto L17;
        r19 = r18;
        r17 = 1;
        r16 = 2;
        goto L22
    L21:
        r21 = r3;
        goto L22
    L23:
        r21 = r3;
        r22 = r17;
        r17 = r10;
        goto L24
    L56:
        Boolean r210 = r11;
        if (this.isFirstFrameTransparent != null) goto L75;
        if (r210 != null) goto L60;
        boolean r118 = false;
    L61:
        this.isFirstFrameTransparent = Boolean.valueOf(r118);
        return;
    L60:
        r118 = r210.booleanValue();
        goto L61
    L75:
        return;
    L5:
        r9 = false;
        goto L6
    }

    private int averageColorsNear(int r10, int r11, int r12) {
        int r1 = r10;
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
    L4:
        if (r1 >= (this.sampleSize + r10)) goto L12;
        byte[] r7 = this.mainPixels;
        if (r1 >= r7.length) goto L12;
        if (r1 >= r11) goto L12;
        int r8 = this.act[r7[r1] & UByte.MAX_VALUE];
        if (r8 == 0) goto L11;
        r2 = r2 + ((r8 >> 24) & 255);
        r3 = r3 + ((r8 >> 16) & 255);
        r4 = r4 + ((r8 >> 8) & 255);
        r5 = r5 + (r8 & 255);
        r6 = r6 + 1;
    L11:
        r1 = r1 + 1;
    L12:
        int r13 = r10 + r12;
        int r14 = r13;
    L14:
        if (r14 >= (this.sampleSize + r13)) goto L22;
        byte[] r9 = this.mainPixels;
        if (r14 >= r9.length) goto L22;
        if (r14 >= r11) goto L22;
        int r15 = this.act[r9[r14] & UByte.MAX_VALUE];
        if (r15 == 0) goto L21;
        r2 = r2 + ((r15 >> 24) & 255);
        r3 = r3 + ((r15 >> 16) & 255);
        r4 = r4 + ((r15 >> 8) & 255);
        r5 = r5 + (r15 & 255);
        r6 = r6 + 1;
    L21:
        r14 = r14 + 1;
    L22:
        if (r6 != 0) goto L25;
        return 0;
    L25:
        return ((((r2 / r6) << 24) | ((r3 / r6) << 16)) | ((r4 / r6) << 8)) | (r5 / r6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v15, types: [short] */
    /* JADX WARN: Type inference failed for: r7v17 */
    private void decodeBitmapData(GifFrame r29) {
        StandardGifDecoder this = this;
        if (r29 == null) goto L5;
        this.rawData.position(r29.bufferFrameStart);
    L5:
        if (r29 != null) goto L7;
        int r1 = this.header.width * this.header.height;
    L8:
        byte[] r2 = this.mainPixels;
        if (r2 != null) goto L11;
    L12:
        this.mainPixels = this.bitmapProvider.obtainByteArray(r1);
    L13:
        byte[] r3 = this.mainPixels;
        if (this.prefix != null) goto L16;
        this.prefix = new short[4096];
    L16:
        short[] r4 = this.prefix;
        if (this.suffix != null) goto L19;
        this.suffix = new byte[4096];
    L19:
        byte[] r5 = this.suffix;
        if (this.pixelStack != null) goto L22;
        this.pixelStack = new byte[FragmentTransaction.TRANSIT_FRAGMENT_OPEN];
    L22:
        byte[] r6 = this.pixelStack;
        int r7 = readByte();
        int r9 = 1 << r7;
        int r10 = r9 + 1;
        int r11 = r9 + 2;
        int r8 = r7 + 1;
        int r12 = (1 << r8) - 1;
        int r13 = 0;
        int r14 = 0;
    L23:
        if (r14 >= r9) goto L25;
        r4[r14] = 0;
        r5[r14] = (byte) r14;
        r14 = r14 + 1;
        goto L23
    L25:
        byte[] r15 = this.block;
        int r23 = r8;
        int r21 = r11;
        int r22 = r12;
        int r16 = 0;
        int r17 = 0;
        int r18 = 0;
        int r19 = 0;
        int r20 = 0;
        int r25 = 0;
        int r26 = 0;
        int r24 = -1;
    L26:
        if (r13 >= r1) goto L59;
        if (r16 != 0) goto L32;
        r16 = readBlock();
        if (r16 <= 0) goto L30;
        r17 = 0;
        goto L32
    L30:
        this.status = 3;
    L32:
        r19 = r19 + ((r15[r17] & UByte.MAX_VALUE) << r18);
        r17 = r17 + 1;
        r16 = r16 - 1;
        int r27 = r18 + 8;
        r21 = r21;
        r23 = r23;
        r24 = r24;
        r8 = r8;
        r25 = r25;
    L33:
        if (r27 < r23) goto L58;
        int r28 = r11;
        int r110 = r19 & r22;
        r19 = r19 >> r23;
        r27 = r27 - r23;
        if (r110 == r9) goto L36;
        if (r110 == r10) goto L38;
        if (r24 == (-1)) goto L41;
        if (r110 < r21) goto L44;
        r6[r26] = (byte) r25;
        r26 = r26 + 1;
        short r30 = r24;
    L45:
        if (r30 < r9) goto L47;
        r6[r26] = r5[r30];
        r26 = r26 + 1;
        r30 = r4[r30];
        goto L45
    L47:
        r25 = r5[r30] & UByte.MAX_VALUE;
        byte r31 = (byte) r25;
        r3[r20] = r31;
    L48:
        r20 = r20 + 1;
        r13 = r13 + 1;
        if (r26 <= 0) goto L51;
        r26 = r26 - 1;
        r3[r20] = r6[r26];
        goto L48
    L51:
        byte[] r210 = r6;
        if (r21 >= 4096) goto L57;
        r4[r21] = (short) r24;
        r5[r21] = r31;
        r21 = r21 + 1;
        if ((r21 & r22) != 0) goto L57;
        if (r21 >= 4096) goto L57;
        r23 = r23 + 1;
        r22 = r22 + r21;
    L57:
        r24 = r110;
        r11 = r28;
        r27 = r27;
        r6 = r210;
        goto L33
    L44:
        r30 = r110;
        goto L45
    L41:
        r3[r20] = r5[r110];
        r20 = r20 + 1;
        r13 = r13 + 1;
        r24 = r110;
        r25 = r24;
        r11 = r28;
        r27 = r27;
        goto L33
    L38:
        r18 = r27;
        r11 = r28;
        goto L26
    L36:
        r22 = r12;
        r23 = r8;
        r21 = r28;
        r11 = r21;
        r24 = -1;
        goto L33
    L58:
        r18 = r27;
    L59:
        Arrays.fill(r3, r20, r1, (byte) 0);
        return;
    L11:
        if (r2.length >= r1) goto L13;
    L7:
        r1 = r29.ih * r29.iw;
        goto L8
    }

    private int readByte() {
        return this.rawData.get() & UByte.MAX_VALUE;
    }

    private int readBlock() {
        int r0 = readByte();
        if (r0 > 0) goto L5;
        return r0;
    L5:
        ByteBuffer r1 = this.rawData;
        r1.get(this.block, 0, Math.min(r0, r1.remaining()));
        return r0;
    }

    private Bitmap getNextBitmap() {
        Boolean r0 = this.isFirstFrameTransparent;
        if (r0 != null) goto L5;
    L8:
        Bitmap.Config r1 = Bitmap.Config.ARGB_8888;
    L9:
        Bitmap r3 = this.bitmapProvider.obtain(this.downsampledWidth, this.downsampledHeight, r1);
        r3.setHasAlpha(true);
        return r3;
    L5:
        if (r0.booleanValue() == true) goto L8;
        r1 = this.bitmapConfig;
        goto L9
    }
}
