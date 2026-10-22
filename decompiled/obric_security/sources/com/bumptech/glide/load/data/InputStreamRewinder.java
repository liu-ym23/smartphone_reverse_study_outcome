package com.bumptech.glide.load.data;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class InputStreamRewinder implements DataRewinder<InputStream> {
    private static final int MARK_READ_LIMIT = 5242880;
    private final RecyclableBufferedInputStream bufferedStream;

    public static final class Factory implements DataRewinder.Factory<InputStream> {
        private final ArrayPool byteArrayPool;

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        public /* bridge */ /* synthetic */ DataRewinder<InputStream> build(InputStream r1) {
            return build2(r1);
        }

        public Factory(ArrayPool r1) {
            this.byteArrayPool = r1;
        }

        /* JADX INFO: renamed from: build, reason: avoid collision after fix types in other method */
        public DataRewinder<InputStream> build2(InputStream r2) {
            return new InputStreamRewinder(r2, this.byteArrayPool);
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        public Class<InputStream> getDataClass() {
            return InputStream.class;
        }
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    public /* bridge */ /* synthetic */ InputStream rewindAndGet() throws IOException {
        return rewindAndGet();
    }

    public InputStreamRewinder(InputStream r2, ArrayPool r3) {
        RecyclableBufferedInputStream r0 = new RecyclableBufferedInputStream(r2, r3);
        this.bufferedStream = r0;
        r0.mark(MARK_READ_LIMIT);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.data.DataRewinder
    public InputStream rewindAndGet() throws IOException {
        this.bufferedStream.reset();
        return this.bufferedStream;
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    public void cleanup() {
        this.bufferedStream.release();
    }

    public void fixMarkLimits() {
        this.bufferedStream.fixMarkLimit();
    }
}
