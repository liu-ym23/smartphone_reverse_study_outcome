package com.bytedance.apm;

import com.bytedance.compression.zstd.ZstdCompress;
import com.bytedance.compression.zstd.ZstdDictCompress;
import com.bytedance.services.apm.api.IZstdCompress;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class l implements IZstdCompress {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f1646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ZstdDictCompress f1648c;

    public l() {
    }

    @Override // com.bytedance.services.apm.api.IZstdCompress
    public byte[] compress(byte[] r1, int r2) {
        return ZstdCompress.compress(r1, r2);
    }

    @Override // com.bytedance.services.apm.api.IZstdCompress
    public byte[] compress(byte[] r2, byte[] r3, int r4) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if (this.f1648c != null) goto L8;
    L11:
        this.f1648c = new ZstdDictCompress(r3, r4);
        this.f1646a = r3;
        this.f1647b = r4;
    L13:
        return ZstdCompress.compress(r2, this.f1648c);
    L8:
        if (Arrays.equals(r3, this.f1646a) == false) goto L11;
        if (r4 == this.f1647b) goto L13;
        goto L11
    }
}
