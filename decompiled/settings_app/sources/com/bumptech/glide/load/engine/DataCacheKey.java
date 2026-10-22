package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes3.dex */
final class DataCacheKey implements Key {
    private final Key signature;
    private final Key sourceKey;

    DataCacheKey(Key r1, Key r2) {
        this.sourceKey = r1;
        this.signature = r2;
    }

    Key getSourceKey() {
        return this.sourceKey;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r4) {
        if ((r4 instanceof DataCacheKey) == false) goto L10;
        DataCacheKey r5 = (DataCacheKey) r4;
        if (this.sourceKey.equals(r5.sourceKey) == true) goto L7;
        return false;
    L7:
        if (this.signature.equals(r5.signature) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return (this.sourceKey.hashCode() * 31) + this.signature.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.sourceKey + ", signature=" + this.signature + '}';
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r2) {
        this.sourceKey.updateDiskCacheKey(r2);
        this.signature.updateDiskCacheKey(r2);
    }
}
