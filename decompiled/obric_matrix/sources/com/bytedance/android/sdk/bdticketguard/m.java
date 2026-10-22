package com.bytedance.android.sdk.bdticketguard;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* JADX INFO: loaded from: classes.dex */
public class m extends h0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f843d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f844e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f845f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f846g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f847h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f848i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f849j;

    public m(String r1, String r2, String r3, String r4, boolean r5, boolean r6, boolean r7, boolean r8, long r9, boolean r11, boolean r12) {
        kotlin.n0.d.o.g(r1, TypedValues.AttributesType.S_TARGET);
        kotlin.n0.d.o.g(r2, "host");
        kotlin.n0.d.o.g(r3, "path");
        kotlin.n0.d.o.g(r4, "ticketName");
        super(r2, r3, r9);
        this.f843d = r1;
        this.f844e = r4;
        this.f845f = r6;
        this.f846g = r7;
        this.f847h = r8;
        this.f848i = r11;
        this.f849j = r12;
    }

    public final boolean d() {
        return this.f849j;
    }

    public final boolean e() {
        return this.f845f;
    }

    public final boolean f() {
        return this.f848i;
    }

    public final boolean g() {
        return this.f847h;
    }

    public final boolean h() {
        return this.f846g;
    }

    public final String i() {
        return this.f843d;
    }

    public final String j() {
        return this.f844e;
    }
}
