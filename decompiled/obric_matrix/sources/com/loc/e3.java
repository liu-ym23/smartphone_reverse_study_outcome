package com.loc;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class e3 extends a3 implements Serializable {
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;

    public e3() {
        this.o = 0;
        this.p = 0;
        this.q = Integer.MAX_VALUE;
        this.r = Integer.MAX_VALUE;
        this.s = Integer.MAX_VALUE;
    }

    public e3(boolean r2) {
        super(r2, true);
        this.o = 0;
        this.p = 0;
        this.q = Integer.MAX_VALUE;
        this.r = Integer.MAX_VALUE;
        this.s = Integer.MAX_VALUE;
    }

    @Override // com.loc.a3
    public final a3 b() {
        e3 r0 = new e3(this.m);
        r0.c(this);
        r0.o = this.o;
        r0.p = this.p;
        r0.q = this.q;
        r0.r = this.r;
        r0.s = this.s;
        return r0;
    }

    @Override // com.loc.a3
    public final /* synthetic */ Object clone() {
        return b();
    }

    @Override // com.loc.a3
    public final String toString() {
        return "AmapCellLte{tac=" + this.o + ", ci=" + this.p + ", pci=" + this.q + ", earfcn=" + this.r + ", timingAdvance=" + this.s + ", mcc='" + this.f7139f + "', mnc='" + this.f7140g + "', signalStrength=" + this.f7141h + ", asuLevel=" + this.f7142i + ", lastUpdateSystemMills=" + this.f7143j + ", lastUpdateUtcMills=" + this.f7144k + ", age=" + this.f7145l + ", main=" + this.m + ", newApi=" + this.n + '}';
    }
}
