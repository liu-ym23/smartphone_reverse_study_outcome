package com.bumptech.glide.signature;

import com.bumptech.glide.load.Key;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes3.dex */
public class MediaStoreSignature implements Key {
    private final long dateModified;
    private final String mimeType;
    private final int orientation;

    public MediaStoreSignature(String r1, long r2, int r4) {
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        this.mimeType = r1;
        this.dateModified = r2;
        this.orientation = r4;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (r7 != null) goto L8;
    L20:
        return false;
    L8:
        if (getClass() != r7.getClass()) goto L20;
        MediaStoreSignature r8 = (MediaStoreSignature) r7;
        if (this.dateModified == r8.dateModified) goto L14;
        return false;
    L14:
        if (this.orientation == r8.orientation) goto L17;
        return false;
    L17:
        if (this.mimeType.equals(r8.mimeType) == true) goto L19;
        return false;
    L19:
        return true;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        int r0 = this.mimeType.hashCode() * 31;
        long r1 = this.dateModified;
        return ((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.orientation;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r4) {
        r4.update(ByteBuffer.allocate(12).putLong(this.dateModified).putInt(this.orientation).array());
        r4.update(this.mimeType.getBytes(CHARSET));
    }
}
