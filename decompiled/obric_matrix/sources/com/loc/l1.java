package com.loc;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class l1 extends o1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f7508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f7509c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f7510d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f7511e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f7512f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f7513g;

    public l1(Context r9, boolean r10, int r11, int r12, String r13) {
        this.f7508b = "iKey";
        this.f7513g = 0;
        f(r9, r10, r11, r12, r13, 0);
    }

    public l1(Context r2, boolean r3, int r4, int r5, String r6, int r7) {
        this.f7508b = "iKey";
        this.f7513g = 0;
        f(r2, r3, r4, r5, r6, r7);
    }

    private void f(Context r1, boolean r2, int r3, int r4, String r5, int r6) {
        this.f7509c = r1;
        this.f7510d = r2;
        this.f7511e = r3;
        this.f7512f = r4;
        this.f7508b = r5;
        this.f7513g = r6;
    }

    @Override // com.loc.o1
    public final void a(int r6) {
        if (l5.M(this.f7509c) != 1) goto L5;
        return;
    L5:
        String r0 = u5.c(System.currentTimeMillis(), "yyyyMMdd");
        String r2 = t.b(this.f7509c, this.f7508b);
        if (TextUtils.isEmpty(r2) == true) goto L16;
        String[] r3 = r2.split("\\|");
        if (r3 != null) goto L10;
    L15:
        t.h(this.f7509c, this.f7508b);
        goto L16
    L10:
        if (r3.length < 2) goto L15;
        if (r0.equals(r3[0]) == false) goto L16;
        r6 = r6 + Integer.parseInt(r3[1]);
    L16:
        t.e(this.f7509c, this.f7508b, r0 + "|" + r6);
    }

    @Override // com.loc.o1
    protected final boolean c() {
        if (l5.M(this.f7509c) != 1) goto L6;
        return true;
    L6:
        if (this.f7510d == true) goto L8;
        return false;
    L8:
        String r0 = t.b(this.f7509c, this.f7508b);
        if (TextUtils.isEmpty(r0) == false) goto L11;
        return true;
    L11:
        String[] r1 = r0.split("\\|");
        if (r1 != null) goto L14;
    L22:
        t.h(this.f7509c, this.f7508b);
        return true;
    L14:
        if (r1.length < 2) goto L22;
        String r3 = r1[0];
        if (u5.c(System.currentTimeMillis(), "yyyyMMdd").equals(r3) == true) goto L19;
    L21:
        return true;
    L19:
        if (Integer.parseInt(r1[1]) < this.f7512f) goto L21;
        return false;
    }

    @Override // com.loc.o1
    public final int d() {
        int r1 = Integer.MAX_VALUE;
        if (l5.M(this.f7509c) == 1) goto L8;
        int r0 = this.f7511e;
        if (r0 <= 0) goto L8;
    L7:
        r1 = r0;
    L12:
        o1 r3 = this.f7587a;
        if (r3 != null) goto L15;
        return r1;
    L15:
        return Math.max(r1, r3.d());
    L8:
        r0 = this.f7513g;
        if (r0 <= 0) goto L12;
        if (r0 >= Integer.MAX_VALUE) goto L12;
        goto L12
    }
}
