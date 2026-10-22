package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.core.util.Pools;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes3.dex */
public class DecodePath<DataType, ResourceType, Transcode> {
    private static final String TAG = "DecodePath";
    private final Class<DataType> dataClass;
    private final List<? extends ResourceDecoder<DataType, ResourceType>> decoders;
    private final String failureMessage;
    private final Pools.Pool<List<Throwable>> listPool;
    private final ResourceTranscoder<ResourceType, Transcode> transcoder;

    interface DecodeCallback<ResourceType> {
        Resource<ResourceType> onResourceDecoded(Resource<ResourceType> r1);
    }

    public DecodePath(Class<DataType> r1, Class<ResourceType> r2, Class<Transcode> r3, List<? extends ResourceDecoder<DataType, ResourceType>> r4, ResourceTranscoder<ResourceType, Transcode> r5, Pools.Pool<List<Throwable>> r6) {
        this.dataClass = r1;
        this.decoders = r4;
        this.transcoder = r5;
        this.listPool = r6;
        this.failureMessage = "Failed DecodePath{" + r1.getSimpleName() + "->" + r2.getSimpleName() + "->" + r3.getSimpleName() + VectorFormat.DEFAULT_SUFFIX;
    }

    public Resource<Transcode> decode(DataRewinder<DataType> r1, int r2, int r3, Options r4, DecodeCallback<ResourceType> r5) throws GlideException {
        Resource<ResourceType> r6 = r5.onResourceDecoded(decodeResource(r1, r2, r3, r4));
        return this.transcoder.transcode(r6, r4);
    }

    private Resource<ResourceType> decodeResource(DataRewinder<DataType> r8, int r9, int r10, Options r11) throws GlideException {
        List<Throwable> r0 = (List) Preconditions.checkNotNull(this.listPool.acquire());
        Resource<ResourceType> r12 = decodeResourceWithList(r8, r9, r10, r11, r0);     // Catch: Throwable -> L6
        this.listPool.release(r0);
        return r12;
    L6:
        th = move-exception;
        this.listPool.release(r0);
        throw th;
    }

    private Resource<ResourceType> decodeResourceWithList(DataRewinder<DataType> r9, int r10, int r11, Options r12, List<Throwable> r13) throws GlideException {
        int r0 = this.decoders.size();
        Resource<ResourceType> r1 = null;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L17;
        ResourceDecoder<DataType, ResourceType> r3 = this.decoders.get(r2);
    L9:
        e = move-exception;
        if (Log.isLoggable(TAG, 2) == false) goto L13;
        Log.v(TAG, "Failed to decode data for " + r3, e);
    L13:
        r13.add(e);
    L14:
        if (r1 != null) goto L17;
        r2 = r2 + 1;
        goto L3
    L6:
        if (r3.handles(r9.rewindAndGet(), r12) == false) goto L14;
        r1 = r3.decode(r9.rewindAndGet(), r10, r11, r12);     // Catch: Throwable -> L9
    L17:
        if (r1 == null) goto L20;
        return r1;
    L20:
        throw new GlideException(this.failureMessage, new ArrayList(r13));
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.dataClass + ", decoders=" + this.decoders + ", transcoder=" + this.transcoder + '}';
    }
}
