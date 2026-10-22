package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.gifdecoder.StandardGifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

/* JADX INFO: loaded from: classes3.dex */
public class ByteBufferGifDecoder implements ResourceDecoder<ByteBuffer, GifDrawable> {
    private static final GifDecoderFactory GIF_DECODER_FACTORY = null;
    private static final GifHeaderParserPool PARSER_POOL = null;
    private static final String TAG = "BufferGifDecoder";
    private final Context context;
    private final GifDecoderFactory gifDecoderFactory;
    private final GifHeaderParserPool parserPool;
    private final List<ImageHeaderParser> parsers;
    private final GifBitmapProvider provider;

    static class GifDecoderFactory {
        GifDecoderFactory() {
        }

        GifDecoder build(GifDecoder.BitmapProvider r1, GifHeader r2, ByteBuffer r3, int r4) {
            return new StandardGifDecoder(r1, r2, r3, r4);
        }
    }

    static class GifHeaderParserPool {
        private final Queue<GifHeaderParser> pool;

        GifHeaderParserPool() {
            this.pool = Util.createQueue(0);
        }

        synchronized GifHeaderParser obtain(ByteBuffer r2) {
            monitor-enter(this);
            GifHeaderParser r0 = this.pool.poll();     // Catch: Throwable -> L9
            if (r0 != null) goto L6;
            r0 = new GifHeaderParser();     // Catch: Throwable -> L9
        L6:
            GifHeaderParser r3 = r0.setData(r2);     // Catch: Throwable -> L9
            monitor-exit(this);
            return r3;
        L9:
            th = move-exception;
            throw th;
        }

        synchronized void release(GifHeaderParser r2) {
            monitor-enter(this);
            r2.clear();     // Catch: Throwable -> L6
            this.pool.offer(r2);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ Resource<GifDrawable> decode(ByteBuffer r1, int r2, int r3, Options r4) throws IOException {
        return decode2(r1, r2, r3, r4);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ boolean handles(ByteBuffer r1, Options r2) throws IOException {
        return handles2(r1, r2);
    }

    static {
        GIF_DECODER_FACTORY = new GifDecoderFactory();
        PARSER_POOL = new GifHeaderParserPool();
    }

    public ByteBufferGifDecoder(Context r4) {
        this(r4, Glide.get(r4).getRegistry().getImageHeaderParsers(), Glide.get(r4).getBitmapPool(), Glide.get(r4).getArrayPool());
    }

    public ByteBufferGifDecoder(Context r8, List<ImageHeaderParser> r9, BitmapPool r10, ArrayPool r11) {
        this(r8, r9, r10, r11, PARSER_POOL, GIF_DECODER_FACTORY);
    }

    ByteBufferGifDecoder(Context r1, List<ImageHeaderParser> r2, BitmapPool r3, ArrayPool r4, GifHeaderParserPool r5, GifDecoderFactory r6) {
        this.context = r1.getApplicationContext();
        this.parsers = r2;
        this.gifDecoderFactory = r6;
        this.provider = new GifBitmapProvider(r3, r4);
        this.parserPool = r5;
    }

    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public boolean handles2(ByteBuffer r2, Options r3) throws IOException {
        if (((Boolean) r3.get(GifOptions.DISABLE_ANIMATION)).booleanValue() == false) goto L5;
    L7:
        return false;
    L5:
        if (ImageHeaderParserUtils.getType(this.parsers, r2) != ImageHeaderParser.ImageType.GIF) goto L7;
        return true;
    }

    /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
    public GifDrawableResource decode2(ByteBuffer r8, int r9, int r10, Options r11) {
        GifHeaderParser r0 = this.parserPool.obtain(r8);
        GifDrawableResource r12 = decode(r8, r9, r10, r0, r11);     // Catch: Throwable -> L6
        this.parserPool.release(r0);
        return r12;
    L6:
        th = move-exception;
        this.parserPool.release(r0);
        throw th;
    }

    private GifDrawableResource decode(ByteBuffer r17, int r18, int r19, GifHeaderParser r20, Options r21) {
        long r3 = LogTime.getLogTime();
        GifHeader r6 = r20.parseHeader();     // Catch: Throwable -> L27
        if (r6.getNumFrames() <= 0) goto L24;
        if (r6.getStatus() != 0) goto L24;
        if (r21.get(GifOptions.DECODE_FORMAT) != DecodeFormat.PREFER_RGB_565) goto L11;
        Bitmap.Config r7 = Bitmap.Config.RGB_565;     // Catch: Throwable -> L27
    L12:
        GifDecoder r11 = this.gifDecoderFactory.build(this.provider, r6, r17, getSampleSize(r6, r18, r19));     // Catch: Throwable -> L27
        r11.setDefaultBitmapConfig(r7);     // Catch: Throwable -> L27
        r11.advance();     // Catch: Throwable -> L27
        Bitmap r15 = r11.getNextFrame();     // Catch: Throwable -> L27
        if (r15 == null) goto L15;
        GifDrawableResource r0 = new GifDrawableResource(new GifDrawable(this.context, r11, UnitTransformation.get(), r18, r19, r15));     // Catch: Throwable -> L27
        if (Log.isLoggable(TAG, 2) == false) goto L22;
        Log.v(TAG, "Decoded GIF from stream in " + LogTime.getElapsedMillis(r3));
    L22:
        return r0;
    L15:
        if (Log.isLoggable(TAG, 2) == false) goto L17;
        Log.v(TAG, "Decoded GIF from stream in " + LogTime.getElapsedMillis(r3));
    L17:
        return null;
    L11:
        r7 = Bitmap.Config.ARGB_8888;     // Catch: Throwable -> L27
    L24:
        if (Log.isLoggable(TAG, 2) == false) goto L26;
        Log.v(TAG, "Decoded GIF from stream in " + LogTime.getElapsedMillis(r3));
    L26:
        return null;
    L27:
        th = move-exception;
        if (Log.isLoggable(TAG, 2) == false) goto L31;
        Log.v(TAG, "Decoded GIF from stream in " + LogTime.getElapsedMillis(r3));
    L31:
        throw th;
    }

    private static int getSampleSize(GifHeader r4, int r5, int r6) {
        int r0 = Math.min(r4.getHeight() / r6, r4.getWidth() / r5);
        if (r0 != 0) goto L5;
        int r1 = 0;
    L6:
        int r2 = Math.max(1, r1);
        if (Log.isLoggable(TAG, 2) == false) goto L10;
        if (r2 <= 1) goto L10;
        Log.v(TAG, "Downsampling GIF, sampleSize: " + r2 + ", target dimens: [" + r5 + MaterialConfigFormatNames.X + r6 + "], actual dimens: [" + r4.getWidth() + MaterialConfigFormatNames.X + r4.getHeight() + "]");
    L10:
        return r2;
    L5:
        r1 = Integer.highestOneBit(r0);
        goto L6
    }
}
