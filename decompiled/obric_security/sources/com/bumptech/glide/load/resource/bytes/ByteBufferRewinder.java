package com.bumptech.glide.load.resource.bytes;

import com.bumptech.glide.load.data.DataRewinder;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class ByteBufferRewinder implements DataRewinder<ByteBuffer> {
    private final ByteBuffer buffer;

    public static class Factory implements DataRewinder.Factory<ByteBuffer> {
        public Factory() {
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        public /* bridge */ /* synthetic */ DataRewinder<ByteBuffer> build(ByteBuffer r1) {
            return build2(r1);
        }

        /* JADX INFO: renamed from: build, reason: avoid collision after fix types in other method */
        public DataRewinder<ByteBuffer> build2(ByteBuffer r1) {
            return new ByteBufferRewinder(r1);
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        public Class<ByteBuffer> getDataClass() {
            return ByteBuffer.class;
        }
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    public void cleanup() {
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    public /* bridge */ /* synthetic */ ByteBuffer rewindAndGet() throws IOException {
        return rewindAndGet2();
    }

    public ByteBufferRewinder(ByteBuffer r1) {
        this.buffer = r1;
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    /* JADX INFO: renamed from: rewindAndGet, reason: avoid collision after fix types in other method */
    public ByteBuffer rewindAndGet2() {
        this.buffer.position(0);
        return this.buffer;
    }
}
