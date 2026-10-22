package com.bumptech.glide.load.engine;

import androidx.core.util.Pools;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LoadPath<Data, ResourceType, Transcode> {
    private final Class<Data> dataClass;
    private final List<? extends DecodePath<Data, ResourceType, Transcode>> decodePaths;
    private final String failureMessage;
    private final Pools.Pool<List<Throwable>> listPool;

    public LoadPath(Class<Data> r1, Class<ResourceType> r2, Class<Transcode> r3, List<DecodePath<Data, ResourceType, Transcode>> r4, Pools.Pool<List<Throwable>> r5) {
        this.dataClass = r1;
        this.listPool = r5;
        this.decodePaths = (List) Preconditions.checkNotEmpty(r4);
        this.failureMessage = "Failed LoadPath{" + r1.getSimpleName() + "->" + r2.getSimpleName() + "->" + r3.getSimpleName() + "}";
    }

    public Resource<Transcode> load(DataRewinder<Data> r9, Options r10, int r11, int r12, DecodePath.DecodeCallback<ResourceType> r13) throws GlideException {
        List<Throwable> r0 = (List) Preconditions.checkNotNull(this.listPool.acquire());
        Resource<Transcode> r14 = loadWithExceptionList(r9, r10, r11, r12, r13, r0);     // Catch: Throwable -> L6
        this.listPool.release(r0);
        return r14;
    L6:
        th = move-exception;
        this.listPool.release(r0);
        throw th;
    }

    private Resource<Transcode> loadWithExceptionList(DataRewinder<Data> r13, Options r14, int r15, int r16, DecodePath.DecodeCallback<ResourceType> r17, List<Throwable> r18) throws GlideException {
        int r3 = this.decodePaths.size();
        int r5 = 0;
        Resource<Transcode> r4 = null;
    L3:
        if (r5 >= r3) goto L12;
        r4 = this.decodePaths.get(r5).decode(r13, r15, r16, r14, r17);     // Catch: GlideException -> L7
    L9:
        if (r4 != null) goto L12;
        r5 = r5 + 1;
    L7:
        e = move-exception;
        r18.add(e);
    L12:
        if (r4 == null) goto L15;
        return r4;
    L15:
        throw new GlideException(this.failureMessage, new ArrayList(r18));
    }

    public Class<Data> getDataClass() {
        return this.dataClass;
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.decodePaths.toArray()) + '}';
    }
}
