package tmsdkobf;

import android.content.Context;
import android.text.TextUtils;
import tmsdk.common.TMSDKContext;

/* JADX INFO: loaded from: classes5.dex */
public class m3 extends z6 {
    protected Context d;
    private volatile boolean e;

    public m3(ya r3) {
        super(ya.h(), r3, ya.g());
        this.e = true;
        this.d = rd.e();
    }

    public static boolean v() {
        Class<?> r1 = Class.forName(new String(zc.l));     // Catch: Throwable -> L5
        return "harmony".equals((String) r1.getMethod("getOsBrand", new Class[0]).invoke(r1, new Object[0]));
    L8:
        return false;
    }

    @Override // tmsdkobf.z6
    public void a(int r8, int r9) {
        int r7 = j4.a(r9);
        boolean r1 = true;
        if (r7 != (-220000)) goto L5;
        boolean r0 = true;
    L7:
        if (r7 != (-160000)) goto L9;
        boolean r3 = true;
    L11:
        if (r7 != (-450000)) goto L13;
    L16:
        boolean r4 = true;
    L18:
        if (r7 != (-70000)) goto L20;
    L25:
        boolean r5 = true;
    L27:
        if (r7 != (-350000)) goto L29;
    L34:
        r8.c("ccr_shark_CustomSharkOutlet", "cmdId: " + r8 + " retCode: " + r9 + " isNoConnect: " + r0 + " isNeedWifiApprove: " + r3 + " isNetworkUnreachable: " + r4 + " isNoRoute: " + r5 + " isPermissionDenied: " + r1);
        return;
    L29:
        if (r7 == (-360000)) goto L34;
        if (r7 == (-430000)) goto L34;
        r1 = false;
        goto L34
    L20:
        if (r7 == (-370000)) goto L25;
        if (r7 == (-380000)) goto L25;
        r5 = false;
        goto L27
    L13:
        if (r7 == (-540000)) goto L16;
        r4 = false;
        goto L18
    L9:
        r3 = false;
        goto L11
    L5:
        r0 = false;
        goto L7
    }

    @Override // tmsdkobf.z6
    public boolean b(int r3) {
        boolean r2 = true;
        if (r3 != 1) goto L6;
    L7:
        r2 = false;
    L8:
        r8.a("Shark_Allow", "onAllow:[" + r3 + "]ret:[" + r2 + "]");
        return r2;
    L6:
        if (r3 != 2) goto L8;
        goto L7
    }

    @Override // tmsdkobf.z6
    public int d() {
        return 3272;
    }

    @Override // tmsdkobf.z6
    public void d(String r1) {
    }

    @Override // tmsdkobf.z6
    public boolean d(String r1, boolean r2) {
        return false;
    }

    @Override // tmsdkobf.z6
    public String g() {
        return null;
    }

    @Override // tmsdkobf.z6
    public String k() {
        r8.c("ccr_shark_CustomSharkOutlet", "onGetOpenidTicket()——mTdidTicket = " + lf.b);
        if (TextUtils.isEmpty(lf.b) == false) goto L5;
    L10:
        lf.a();
        return lf.b;
    L5:
        if (TextUtils.isEmpty(lf.c) == true) goto L10;
        if (TextUtils.isEmpty(lf.d) == true) goto L10;
        return lf.b;
    }

    @Override // tmsdkobf.z6
    public d1 l() {
        Context r0 = TMSDKContext.getApplicaionContext();
        d1 r1 = new d1();
        if (v() == false) goto L5;
        String r2 = "1";
    L6:
        r1.l0 = r2;
        r1.m0 = lf.b + ";" + lf.c;
        r1.n0 = "105478;" + lf.d;
        if (b3.c() == false) goto L9;
        String r3 = ";" + p5.b();
    L10:
        r1.o0 = s9.b() + r3;
        r8.a("ccr_shark_CustomSharkOutlet", "mGuid = " + lf.f330a);
        if (mb.a() == false) goto L14;
        r1.p = qe.a(la.a(r0));
    L14:
        if (this.e == false) goto L16;
    L17:
        this.e = false;
        m9.e().a(false);
        r1.n = qe.a(la.d());
        r1.C = la.a("ro.product.name");
        r1.r0 = la.c();
        String r7 = qe.a(la.a());
        r1.s0 = r7;
        r1.z = r7;
    L18:
        r1.b = "";
        r1.L = "";
        r1.d = "0";
        r1.e = "0";
        r1.f = ve.d();
        r1.g = qe.a("82AC7FBRVE1JJMA7");
        r1.h = 3272;
        r1.i = qe.a(ve.b());
        r1.j = 2;
        r1.k = 201;
        r1.m = TMSDKContext.getApplicaionContext().getPackageName();     // Catch: Throwable -> L22
    L20:
        r1.o = vc.a();
        r1.q = 2052;
        r1.r = 1;
        r1.P = "8.2.13";
        r1.Q = 1;
        r1.R = "";
        r1.H = 0;
        r1.I = 0;
        r1.f140J = false;
        r1.d0 = 0;
        r1.e0 = la.b();
        return r1;
    L16:
        if (m9.e().d() == false) goto L18;
    L9:
        r3 = "";
        goto L10
    L5:
        r2 = "0";
        goto L6
    }

    @Override // tmsdkobf.z6
    public String p() {
        return null;
    }

    @Override // tmsdkobf.z6
    public void a(String r1, boolean r2) {
        super.a(r1, r2);
        if (r1 != null) goto L5;
        return;
    L5:
        r8.c("ccr_shark_CustomSharkOutlet", "onSaveGuidToPhone() guid: " + r1);
        lf.f330a = r1;
    }
}
