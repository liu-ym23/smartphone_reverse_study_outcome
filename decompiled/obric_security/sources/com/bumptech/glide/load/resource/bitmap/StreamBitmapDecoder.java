package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.ExceptionPassthroughInputStream;
import com.bumptech.glide.util.MarkEnforcingInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class StreamBitmapDecoder implements ResourceDecoder<InputStream, Bitmap> {
    private final ArrayPool byteArrayPool;
    private final Downsampler downsampler;

    static class UntrustedCallbacks implements Downsampler.DecodeCallbacks {
        private final RecyclableBufferedInputStream bufferedStream;
        private final ExceptionPassthroughInputStream exceptionStream;

        UntrustedCallbacks(RecyclableBufferedInputStream r1, ExceptionPassthroughInputStream r2) {
            this.bufferedStream = r1;
            this.exceptionStream = r2;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
        public void onObtainBounds() {
            this.bufferedStream.fixMarkLimit();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
        public void onDecodeComplete(BitmapPool r1, Bitmap r2) throws IOException {
            IOException r0 = this.exceptionStream.getException();
            if (r0 == null) goto L7;
            if (r2 == null) goto L8;
            r1.put(r2);
            throw r0;
        L8:
            throw r0;
        }
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ Resource<Bitmap> decode(InputStream r1, int r2, int r3, Options r4) throws IOException {
        return decode2(r1, r2, r3, r4);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ boolean handles(InputStream r1, Options r2) throws IOException {
        return handles2(r1, r2);
    }

    public StreamBitmapDecoder(Downsampler r1, ArrayPool r2) {
        this.downsampler = r1;
        this.byteArrayPool = r2;
    }

    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public boolean handles2(InputStream r1, Options r2) {
        return this.downsampler.handles(r1);
    }

    /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
    public Resource<Bitmap> decode2(InputStream r10, int r11, int r12, Options r13) throws IOException {
        if ((r10 instanceof RecyclableBufferedInputStream) == false) goto L5;
        RecyclableBufferedInputStream r14 = (RecyclableBufferedInputStream) r10;
        boolean r0 = false;
    L6:
        ExceptionPassthroughInputStream r1 = ExceptionPassthroughInputStream.obtain(r14);
        Resource<Bitmap> r9 = this.downsampler.decode(new MarkEnforcingInputStream(r1), r11, r12, r13, new UntrustedCallbacks(r14, r1));     // Catch: Throwable -> L12
        r1.release();
        if (r0 == false) goto L11;
        r14.release();
    L11:
        return r9;
    L12:
        th = move-exception;
        r1.release();
        if (r0 == false) goto L16;
        r14.release();
    L16:
        throw th;
    L5:
        r0 = true;
        r14 = new RecyclableBufferedInputStream(r10, this.byteArrayPool);
        goto L6
    }
}
