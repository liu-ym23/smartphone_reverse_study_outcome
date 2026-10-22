package com.loc;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a3 implements Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f7139f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f7140g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f7141h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f7142i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f7143j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f7144k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f7145l;
    public boolean m;
    public boolean n;

    public a3() {
        this.f7139f = "";
        this.f7140g = "";
        this.f7141h = 99;
        this.f7142i = Integer.MAX_VALUE;
        this.f7143j = 0;
        this.f7144k = 0;
        this.f7145l = 0;
        this.n = true;
    }

    public a3(boolean r3, boolean r4) {
        this.f7139f = "";
        this.f7140g = "";
        this.f7141h = 99;
        this.f7142i = Integer.MAX_VALUE;
        this.f7143j = 0;
        this.f7144k = 0;
        this.f7145l = 0;
        this.n = true;
        this.m = r3;
        this.n = r4;
    }

    private static int a(String r0) {
        return Integer.parseInt(r0);
    L4:
        e = move-exception;
        l3.a(e);
        return 0;
    }

    public abstract a3 b();

    public final void c(a3 r3) {
        this.f7139f = r3.f7139f;
        this.f7140g = r3.f7140g;
        this.f7141h = r3.f7141h;
        this.f7142i = r3.f7142i;
        this.f7143j = r3.f7143j;
        this.f7144k = r3.f7144k;
        this.f7145l = r3.f7145l;
        this.m = r3.m;
        this.n = r3.n;
    }

    public /* synthetic */ Object clone() {
        return b();
    }

    public final int d() {
        return a(this.f7139f);
    }

    public final int e() {
        return a(this.f7140g);
    }

    public String toString() {
        return "AmapCell{mcc=" + this.f7139f + ", mnc=" + this.f7140g + ", signalStrength=" + this.f7141h + ", asulevel=" + this.f7142i + ", lastUpdateSystemMills=" + this.f7143j + ", lastUpdateUtcMills=" + this.f7144k + ", age=" + this.f7145l + ", main=" + this.m + ", newapi=" + this.n + '}';
    }
}
