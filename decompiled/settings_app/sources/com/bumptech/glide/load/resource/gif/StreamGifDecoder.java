package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class StreamGifDecoder implements ResourceDecoder<InputStream, GifDrawable> {
    private static final String TAG = "StreamGifDecoder";
    private final ArrayPool byteArrayPool;
    private final ResourceDecoder<ByteBuffer, GifDrawable> byteBufferDecoder;
    private final List<ImageHeaderParser> parsers;

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ Resource<GifDrawable> decode(InputStream r1, int r2, int r3, Options r4) throws IOException {
        return decode2(r1, r2, r3, r4);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ boolean handles(InputStream r1, Options r2) throws IOException {
        return handles2(r1, r2);
    }

    public StreamGifDecoder(List<ImageHeaderParser> r1, ResourceDecoder<ByteBuffer, GifDrawable> r2, ArrayPool r3) {
        this.parsers = r1;
        this.byteBufferDecoder = r2;
        this.byteArrayPool = r3;
    }

    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public boolean handles2(InputStream r2, Options r3) throws IOException {
        if (((Boolean) r3.get(GifOptions.DISABLE_ANIMATION)).booleanValue() == false) goto L5;
    L7:
        return false;
    L5:
        if (ImageHeaderParserUtils.getType(this.parsers, r2, this.byteArrayPool) != ImageHeaderParser.ImageType.GIF) goto L7;
        return true;
    }

    /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
    public Resource<GifDrawable> decode2(InputStream r1, int r2, int r3, Options r4) throws IOException {
        byte[] r5 = inputStreamToBytes(r1);
        if (r5 != null) goto L6;
        return null;
    L6:
        ByteBuffer r6 = ByteBuffer.wrap(r5);
        return this.byteBufferDecoder.decode(r6, r2, r3, r4);
    }

    private static byte[] inputStreamToBytes(InputStream r4) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(16384);
        byte[] r1 = new byte[16384];     // Catch: IOException -> L10
    L4:
        int r2 = r4.read(r1);     // Catch: IOException -> L10
        if (r2 == (-1)) goto L7;
        r0.write(r1, 0, r2);     // Catch: IOException -> L10
        goto L4
    L7:
        r0.flush();     // Catch: IOException -> L10
        return r0.toByteArray();
    L10:
        e = move-exception;
        if (Log.isLoggable(TAG, 5) == false) goto L19;
        Log.w(TAG, "Error reading data from stream", e);
        return null;
    L19:
        return null;
    }
}
