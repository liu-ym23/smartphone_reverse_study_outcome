package com.loc;

import android.os.Build;
import com.bytedance.bdlocation.client.LocationInfoConst;

/* JADX INFO: loaded from: classes2.dex */
public final enum q extends Enum<q> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final q f7600k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final q f7601l = null;
    public static final q m = null;
    public static final q n = null;
    public static final q o = null;
    public static final q p = null;
    public static final q q = null;
    public static final q r = null;
    public static final q s = null;
    public static final q t = null;
    public static final q u = null;
    public static final q v = null;
    public static final q w = null;
    private static final /* synthetic */ q[] x = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f7602f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f7603g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f7604h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f7605i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f7606j;

    static {
        q r0 = new q("MIUI", 0, u5.u("IeGlhb21p"));
        f7600k = r0;
        q r1 = new q("Flyme", 1, u5.u("IbWVpenU"));
        f7601l = r1;
        q r2 = new q("RH", 2, u5.u("IaHVhd2Vp"));
        m = r2;
        q r4 = new q("ColorOS", 3, u5.u("Ib3Bwbw"));
        n = r4;
        q r6 = new q("FuntouchOS", 4, u5.u("Idml2bw"));
        o = r6;
        q r8 = new q("SmartisanOS", 5, u5.u("Mc21hcnRpc2Fu"));
        p = r8;
        q r10 = new q("AmigoOS", 6, u5.u("IYW1pZ28"));
        q = r10;
        q r12 = new q("EUI", 7, u5.u("IbGV0dg"));
        r = r12;
        q r14 = new q("Sense", 8, u5.u("EaHRj"));
        s = r14;
        q r13 = new q("LG", 9, u5.u("EbGdl"));
        t = r13;
        q r11 = new q(LocationInfoConst.GOOGLE, 10, u5.u("IZ29vZ2xl"));
        u = r11;
        q r9 = new q("NubiaUI", 11, u5.u("IbnViaWE"));
        v = r9;
        q r7 = new q("Other", 12, "");
        w = r7;
        x = new q[]{r0, r1, r2, r4, r6, r8, r10, r12, r14, r13, r11, r9, r7};
    }

    private q(String r1, int r2, String r3) {
        super(r1, r2);
        this.f7606j = Build.MANUFACTURER;
        this.f7602f = r3;
    }

    public static q valueOf(String r1) {
        return (q) Enum.valueOf(q.class, r1);
    }

    public static q[] values() {
        return (q[]) x.clone();
    }

    public final String a() {
        return this.f7602f;
    }

    public final void b(int r1) {
        this.f7603g = r1;
    }

    public final void c(String r1) {
        this.f7604h = r1;
    }

    public final String g() {
        return this.f7604h;
    }

    public final void j(String r1) {
        this.f7605i = r1;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "ROM{name='" + name() + "',versionCode=" + this.f7603g + ", versionName='" + this.f7605i + "',ma=" + this.f7602f + "',manufacturer=" + this.f7606j + "'}";
    }
}
