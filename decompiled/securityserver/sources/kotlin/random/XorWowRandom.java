package kotlin.random;

import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class XorWowRandom extends Random implements Serializable {
    public int e;
    public int f;
    public int i;
    public int j;
    public int k;
    public int l;

    @Metadata
    public static final class Companion {
    }

    @Override // kotlin.random.Random
    public final int a(int r2) {
        return (b() >>> (32 - r2)) & ((-r2) >> 31);
    }

    @Override // kotlin.random.Random
    public final int b() {
        int r0 = this.e;
        int r1 = r0 ^ (r0 >>> 2);
        this.e = this.f;
        this.f = this.i;
        this.i = this.j;
        int r2 = this.k;
        this.j = r2;
        int r3 = ((r1 ^ (r1 << 1)) ^ r2) ^ (r2 << 4);
        this.k = r3;
        int r4 = this.l + 362437;
        this.l = r4;
        return r3 + r4;
    }
}
