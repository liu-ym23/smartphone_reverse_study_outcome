package com.bumptech.glide.load;

import android.content.Context;
import com.bumptech.glide.load.engine.Resource;

/* JADX INFO: loaded from: classes3.dex */
public interface Transformation<T> extends Key {
    Resource<T> transform(Context r1, Resource<T> r2, int r3, int r4);
}
