package com.bumptech.glide.signature;

import android.content.Context;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes3.dex */
public final class AndroidResourceSignature implements Key {
    private final Key applicationVersion;
    private final int nightMode;

    public static Key obtain(Context r2) {
        Key r0 = ApplicationVersionSignature.obtain(r2);
        return new AndroidResourceSignature(r2.getResources().getConfiguration().uiMode & 48, r0);
    }

    private AndroidResourceSignature(int r1, Key r2) {
        this.nightMode = r1;
        this.applicationVersion = r2;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r4) {
        if ((r4 instanceof AndroidResourceSignature) == false) goto L10;
        AndroidResourceSignature r5 = (AndroidResourceSignature) r4;
        if (this.nightMode == r5.nightMode) goto L7;
        return false;
    L7:
        if (this.applicationVersion.equals(r5.applicationVersion) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return Util.hashCode(this.applicationVersion, this.nightMode);
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r2) {
        this.applicationVersion.updateDiskCacheKey(r2);
        r2.update(ByteBuffer.allocate(4).putInt(this.nightMode).array());
    }
}
