package com.loc;

import android.text.TextUtils;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.amap.api.location.AMapLocation;

/* JADX INFO: loaded from: classes2.dex */
public final class w3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ew f7937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f7938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f7939c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f7940d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f7941e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    long f7942f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    AMapLocation f7943g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    long f7944h;

    public w3() {
        this.f7937a = null;
        this.f7938b = 0;
        this.f7939c = 0;
        this.f7940d = true;
        this.f7941e = 0;
        this.f7942f = 0;
        this.f7943g = null;
        this.f7944h = 0;
    }

    private ew e(ew r3) {
        if (a5.q(r3) == true) goto L5;
    L15:
        return r3;
    L5:
        if (this.f7940d == true) goto L7;
    L13:
        int r2 = this.f7941e;
    L14:
        r3.L0(r2);
        goto L15
    L7:
        if (r4.f(r3.getTime()) == false) goto L13;
        if (r3.Y() != 5) goto L11;
    L12:
        r2 = 4;
        goto L14
    L11:
        if (r3.Y() != 6) goto L15;
        goto L12
    }

    public final AMapLocation a(AMapLocation r6) {
        if (a5.p(r6) == true) goto L5;
        return r6;
    L5:
        long r0 = a5.A() - this.f7944h;
        this.f7944h = a5.A();
        if (r0 <= CoroutineLiveDataKt.DEFAULT_TIMEOUT) goto L8;
        return r6;
    L8:
        AMapLocation r1 = this.f7943g;
        if (r1 != null) goto L13;
        this.f7943g = r6;
        return r6;
    L13:
        if (1 == r1.Y()) goto L19;
        if ("gps".equalsIgnoreCase(this.f7943g.getProvider()) == true) goto L19;
        this.f7943g = r6;
        return r6;
    L19:
        if (this.f7943g.getAltitude() == r6.getAltitude()) goto L21;
    L24:
        long r2 = Math.abs(r6.getTime() - this.f7943g.getTime());
        if (30000 >= r2) goto L29;
        this.f7943g = r6;
        return r6;
    L29:
        if (a5.c(r6, this.f7943g) > (((((this.f7943g.getSpeed() + r6.getSpeed()) * r2) / 2000.0f) + ((this.f7943g.getAccuracy() + r6.getAccuracy()) * 2.0f)) + 3000.0f)) goto L31;
        this.f7943g = r6;
        return r6;
    L31:
        return this.f7943g;
    L21:
        if (this.f7943g.getLongitude() != r6.getLongitude()) goto L24;
        this.f7943g = r6;
        return r6;
    }

    public final ew b(ew r21) {
        if ((a5.A() - this.f7942f) <= 30000) goto L6;
        this.f7937a = r21;
        this.f7942f = a5.A();
        return this.f7937a;
    L6:
        this.f7942f = a5.A();
        if (a5.q(this.f7937a) == true) goto L9;
    L91:
        this.f7938b = a5.A();
        this.f7937a = r21;
        return r21;
    L9:
        if (a5.q(r21) == false) goto L91;
        if (r21.getTime() != this.f7937a.getTime()) goto L17;
        if (r21.getAccuracy() >= 300.0f) goto L17;
        return r21;
    L17:
        if ("gps".equals(r21.getProvider()) == false) goto L21;
        this.f7938b = a5.A();
        this.f7937a = r21;
        return r21;
    L21:
        if (r21.f1() == this.f7937a.f1()) goto L25;
        this.f7938b = a5.A();
        this.f7937a = r21;
        return r21;
    L25:
        if (r21.N() != null) goto L27;
    L32:
        this.f7941e = r21.Y();
        float r2 = a5.c(r21, this.f7937a);
        float r6 = this.f7937a.getAccuracy();
        float r7 = r21.getAccuracy();
        float r8 = r7 - r6;
        long r9 = a5.A();
        long r11 = r9 - this.f7938b;
        boolean r15 = true;
        if (r6 <= 100.0f) goto L35;
    L37:
        boolean r14 = false;
    L39:
        if (r6 > 299.0f) goto L41;
    L43:
        r15 = false;
    L45:
        if (r14 == true) goto L82;
        if (r15 == true) goto L82;
        if (r7 >= 100.0f) goto L54;
        if (r6 <= 299.0f) goto L54;
        this.f7938b = r9;
        this.f7937a = r21;
        this.f7939c = 0;
        return r21;
    L54:
        if (r7 > 299.0f) goto L57;
        this.f7939c = 0;
    L57:
        if (r2 >= 10.0f) goto L73;
        if (r2 <= 0.1d) goto L73;
        if (r7 <= 5.0f) goto L73;
        if (r8 < (-300.0f)) goto L67;
        ew r1 = this.f7937a;
        e(r1);
        this.f7937a = r1;
        return r1;
    L67:
        if ((r6 / r7) < 2.0f) goto L70;
        this.f7938b = r9;
        this.f7937a = r21;
        return r21;
    L70:
        ew r3 = this.f7937a;
        e(r3);
        this.f7937a = r3;
        return r3;
    L73:
        if (r8 >= 300.0f) goto L75;
        this.f7938b = a5.A();
        this.f7937a = r21;
        return r21;
    L75:
        if (r11 < 30000) goto L78;
        this.f7938b = a5.A();
        this.f7937a = r21;
        return r21;
    L78:
        ew r4 = this.f7937a;
        e(r4);
        this.f7937a = r4;
        return r4;
    L82:
        long r5 = this.f7939c;
        if (r5 != 0) goto L86;
        this.f7939c = r9;
    L89:
        ew r10 = this.f7937a;
        e(r10);
        this.f7937a = r10;
        return r10;
    L86:
        if ((r9 - r5) <= 30000) goto L89;
        this.f7938b = r9;
        this.f7937a = r21;
        this.f7939c = 0;
        return r21;
    L41:
        if (r7 <= 299.0f) goto L43;
    L35:
        if (r7 <= 299.0f) goto L37;
        r14 = true;
        goto L39
    L27:
        if (r21.N().equals(this.f7937a.N()) == true) goto L32;
        if (TextUtils.isEmpty(r21.N()) == true) goto L32;
        this.f7938b = a5.A();
        this.f7937a = r21;
        return r21;
    }

    public final void c() {
        this.f7937a = null;
        this.f7938b = 0;
        this.f7939c = 0;
        this.f7943g = null;
        this.f7944h = 0;
    }

    public final void d(boolean r1) {
        this.f7940d = r1;
    }
}
