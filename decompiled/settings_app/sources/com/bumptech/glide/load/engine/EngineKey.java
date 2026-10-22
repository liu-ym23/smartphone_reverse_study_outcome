package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
class EngineKey implements Key {
    private int hashCode;
    private final int height;
    private final Object model;
    private final Options options;
    private final Class<?> resourceClass;
    private final Key signature;
    private final Class<?> transcodeClass;
    private final Map<Class<?>, Transformation<?>> transformations;
    private final int width;

    EngineKey(Object r1, Key r2, int r3, int r4, Map<Class<?>, Transformation<?>> r5, Class<?> r6, Class<?> r7, Options r8) {
        this.model = Preconditions.checkNotNull(r1);
        this.signature = (Key) Preconditions.checkNotNull(r2, "Signature must not be null");
        this.width = r3;
        this.height = r4;
        this.transformations = (Map) Preconditions.checkNotNull(r5);
        this.resourceClass = (Class) Preconditions.checkNotNull(r6, "Resource class must not be null");
        this.transcodeClass = (Class) Preconditions.checkNotNull(r7, "Transcode class must not be null");
        this.options = (Options) Preconditions.checkNotNull(r8);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r4) {
        if ((r4 instanceof EngineKey) == false) goto L22;
        EngineKey r5 = (EngineKey) r4;
        if (this.model.equals(r5.model) == true) goto L7;
        return false;
    L7:
        if (this.signature.equals(r5.signature) == true) goto L9;
        return false;
    L9:
        if (this.height == r5.height) goto L11;
        return false;
    L11:
        if (this.width == r5.width) goto L13;
        return false;
    L13:
        if (this.transformations.equals(r5.transformations) == true) goto L15;
        return false;
    L15:
        if (this.resourceClass.equals(r5.resourceClass) == true) goto L17;
        return false;
    L17:
        if (this.transcodeClass.equals(r5.transcodeClass) == true) goto L19;
        return false;
    L19:
        if (this.options.equals(r5.options) == false) goto L30;
        return true;
    L30:
        return false;
    L22:
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        if (this.hashCode != 0) goto L6;
        int r0 = this.model.hashCode();
        this.hashCode = r0;
        int r1 = (((((r0 * 31) + this.signature.hashCode()) * 31) + this.width) * 31) + this.height;
        this.hashCode = r1;
        int r2 = (r1 * 31) + this.transformations.hashCode();
        this.hashCode = r2;
        int r3 = (r2 * 31) + this.resourceClass.hashCode();
        this.hashCode = r3;
        int r4 = (r3 * 31) + this.transcodeClass.hashCode();
        this.hashCode = r4;
        this.hashCode = (r4 * 31) + this.options.hashCode();
    L6:
        return this.hashCode;
    }

    public String toString() {
        return "EngineKey{model=" + this.model + ", width=" + this.width + ", height=" + this.height + ", resourceClass=" + this.resourceClass + ", transcodeClass=" + this.transcodeClass + ", signature=" + this.signature + ", hashCode=" + this.hashCode + ", transformations=" + this.transformations + ", options=" + this.options + '}';
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r1) {
        throw new UnsupportedOperationException();
    }
}
