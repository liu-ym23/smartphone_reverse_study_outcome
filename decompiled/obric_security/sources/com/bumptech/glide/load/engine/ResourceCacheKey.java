package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
final class ResourceCacheKey implements Key {
    private static final LruCache<Class<?>, byte[]> RESOURCE_CLASS_BYTES = null;
    private final ArrayPool arrayPool;
    private final Class<?> decodedResourceClass;
    private final int height;
    private final Options options;
    private final Key signature;
    private final Key sourceKey;
    private final Transformation<?> transformation;
    private final int width;

    static {
        RESOURCE_CLASS_BYTES = new LruCache(50);
    }

    ResourceCacheKey(ArrayPool r1, Key r2, Key r3, int r4, int r5, Transformation<?> r6, Class<?> r7, Options r8) {
        this.arrayPool = r1;
        this.sourceKey = r2;
        this.signature = r3;
        this.width = r4;
        this.height = r5;
        this.transformation = r6;
        this.decodedResourceClass = r7;
        this.options = r8;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r4) {
        if ((r4 instanceof ResourceCacheKey) == false) goto L20;
        ResourceCacheKey r5 = (ResourceCacheKey) r4;
        if (this.height == r5.height) goto L7;
        return false;
    L7:
        if (this.width == r5.width) goto L9;
        return false;
    L9:
        if (Util.bothNullOrEqual(this.transformation, r5.transformation) == true) goto L11;
        return false;
    L11:
        if (this.decodedResourceClass.equals(r5.decodedResourceClass) == true) goto L13;
        return false;
    L13:
        if (this.sourceKey.equals(r5.sourceKey) == true) goto L15;
        return false;
    L15:
        if (this.signature.equals(r5.signature) == true) goto L17;
        return false;
    L17:
        if (this.options.equals(r5.options) == false) goto L27;
        return true;
    L27:
        return false;
    L20:
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        int r0 = (((((this.sourceKey.hashCode() * 31) + this.signature.hashCode()) * 31) + this.width) * 31) + this.height;
        Transformation<?> r1 = this.transformation;
        if (r1 == null) goto L6;
        r0 = (r0 * 31) + r1.hashCode();
    L6:
        return (((r0 * 31) + this.decodedResourceClass.hashCode()) * 31) + this.options.hashCode();
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r4) {
        byte[] r0 = (byte[]) this.arrayPool.getExact(8, byte[].class);
        ByteBuffer.wrap(r0).putInt(this.width).putInt(this.height).array();
        this.signature.updateDiskCacheKey(r4);
        this.sourceKey.updateDiskCacheKey(r4);
        r4.update(r0);
        Transformation<?> r1 = this.transformation;
        if (r1 == null) goto L5;
        r1.updateDiskCacheKey(r4);
    L5:
        this.options.updateDiskCacheKey(r4);
        r4.update(getResourceClassBytes());
        this.arrayPool.put(r0);
    }

    private byte[] getResourceClassBytes() {
        LruCache<Class<?>, byte[]> r0 = RESOURCE_CLASS_BYTES;
        byte[] r1 = r0.get(this.decodedResourceClass);
        if (r1 != null) goto L6;
        byte[] r2 = this.decodedResourceClass.getName().getBytes(CHARSET);
        r0.put(this.decodedResourceClass, r2);
        return r2;
    L6:
        return r1;
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.sourceKey + ", signature=" + this.signature + ", width=" + this.width + ", height=" + this.height + ", decodedResourceClass=" + this.decodedResourceClass + ", transformation='" + this.transformation + "', options=" + this.options + '}';
    }
}
