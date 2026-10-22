package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public interface ResourceDecoder<T, Z> {
    Resource<Z> decode(T r1, int r2, int r3, Options r4) throws IOException;

    boolean handles(T r1, Options r2) throws IOException;
}
