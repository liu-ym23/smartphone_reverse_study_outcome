package com.bumptech.glide.load;

import android.content.Context;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class MultiTransformation<T> implements Transformation<T> {
    private final Collection<? extends Transformation<T>> transformations;

    @SafeVarargs
    public MultiTransformation(Transformation<T>... r2) {
        if (r2.length == 0) goto L7;
        this.transformations = Arrays.asList(r2);
        return;
    L7:
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }

    public MultiTransformation(Collection<? extends Transformation<T>> r2) {
        if (r2.isEmpty() == true) goto L7;
        this.transformations = r2;
        return;
    L7:
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }

    @Override // com.bumptech.glide.load.Transformation
    public Resource<T> transform(Context r4, Resource<T> r5, int r6, int r7) {
        Iterator<? extends Transformation<T>> r3 = this.transformations.iterator();
        Resource<T> r0 = r5;
    L4:
        if (r3.hasNext() == false) goto L13;
        Resource<T> r1 = r3.next().transform(r4, r0, r6, r7);
        if (r0 == null) goto L12;
        if (r0.equals(r5) == true) goto L12;
        if (r0.equals(r1) == true) goto L12;
        r0.recycle();
    L12:
        r0 = r1;
        goto L4
    L13:
        return r0;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r2) {
        if ((r2 instanceof MultiTransformation) == true) goto L5;
        return false;
    L5:
        return this.transformations.equals(((MultiTransformation) r2).transformations);
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.transformations.hashCode();
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r2) {
        Iterator<? extends Transformation<T>> r1 = this.transformations.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().updateDiskCacheKey(r2);
        goto L4
    }
}
