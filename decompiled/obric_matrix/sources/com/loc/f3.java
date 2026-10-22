package com.loc;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class f3 extends a3 implements Serializable {
    public int o;
    public int p;
    public int q;
    public int r;

    public f3() {
        this.o = 0;
        this.p = 0;
        this.q = Integer.MAX_VALUE;
        this.r = Integer.MAX_VALUE;
    }

    public f3(boolean r1, boolean r2) {
        super(r1, r2);
        this.o = 0;
        this.p = 0;
        this.q = Integer.MAX_VALUE;
        this.r = Integer.MAX_VALUE;
    }

    @Override // com.loc.a3
    public final a3 b() {
        f3 r0 = new f3(this.m, this.n);
        r0.c(this);
        r0.o = this.o;
        r0.p = this.p;
        r0.q = this.q;
        r0.r = this.r;
        return r0;
    }

    @Override // com.loc.a3
    public final /* synthetic */ Object clone() {
        return b();
    }

    @Override // com.loc.a3
    public final String toString() {
        return "AmapCellWcdma{lac=" + this.o + ", cid=" + this.p + ", psc=" + this.q + ", uarfcn=" + this.r + ", mcc='" + this.f7139f + "', mnc='" + this.f7140g + "', signalStrength=" + this.f7141h + ", asuLevel=" + this.f7142i + ", lastUpdateSystemMills=" + this.f7143j + ", lastUpdateUtcMills=" + this.f7144k + ", age=" + this.f7145l + ", main=" + this.m + ", newApi=" + this.n + '}';
    }
}
