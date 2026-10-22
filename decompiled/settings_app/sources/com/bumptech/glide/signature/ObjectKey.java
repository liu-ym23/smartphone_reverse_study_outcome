package com.bumptech.glide.signature;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes3.dex */
public final class ObjectKey implements Key {
    private final Object object;

    public ObjectKey(Object r1) {
        this.object = Preconditions.checkNotNull(r1);
    }

    public String toString() {
        return "ObjectKey{object=" + this.object + '}';
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r2) {
        if ((r2 instanceof ObjectKey) == true) goto L5;
        return false;
    L5:
        return this.object.equals(((ObjectKey) r2).object);
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.object.hashCode();
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r2) {
        r2.update(this.object.toString().getBytes(CHARSET));
    }
}
