package com.bytedance.applog.o;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.bytedance.applog.util.l;
import com.bytedance.applog.util.n;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class g extends c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long[] f2282h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.bytedance.applog.y.b f2283i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final com.bytedance.applog.s.b f2284j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f2285k;

    g(@NonNull e r5) {
        super(r5);
        this.f2282h = new long[]{BDLocationConfig.sScanBleMaxInterval};
        this.f2284j = null;
        this.f2285k = "Sender";
        this.f2283i = new com.bytedance.applog.y.b("Sender", r5.q(), null);
    }

    g(@NonNull e r8, @NonNull com.bytedance.applog.s.b r9) {
        super(r8);
        long[] r0 = {BDLocationConfig.sScanBleMaxInterval};
        this.f2282h = r0;
        this.f2284j = r9;
        String r4 = "Sender_p_" + r9.f();
        this.f2285k = r4;
        long r5 = r9.c();
        if (r5 >= BDLocationConfig.sScanBleMaxInterval) goto L5;
        r0[0] = r5;
    L5:
        this.f2283i = new com.bytedance.applog.y.b(r4, r8.q(), r9);
    }

    private com.bytedance.applog.y.a m(com.bytedance.applog.q.b r1) {
        com.bytedance.applog.s.b r0 = this.f2284j;
        if (r0 == null) goto L7;
        return r0.b();
    L7:
        return r1.n();
    }

    private e.C0071e n(com.bytedance.applog.q.b r11, String[] r12, List<com.bytedance.applog.w.g> r13, int r14) {
        e.C0071e r0 = new e.C0071e();
        Iterator<com.bytedance.applog.w.g> r15 = r13.iterator();
    L4:
        if (r15.hasNext() == false) goto L34;
        com.bytedance.applog.w.g r1 = r15.next();
        String r2 = r1.toString();
        byte[] r3 = r1.v;
        if (r3 == null) goto L32;
        if (r3.length <= 0) goto L32;
        com.bytedance.applog.v.a.m(this.f2259a.s(), r1, this.f2284j);
        if (this.f2283i.f() == false) goto L12;
        com.bytedance.applog.y.a r4 = m(r11);
        if (r4 == null) goto L19;
        if (r4.a(r14) == false) goto L19;
        b.d(com.bytedance.applog.r.b.a.n, com.bytedance.applog.r.b.d.y);
        StringBuilder r5 = new StringBuilder();
        r5.append(this.f2285k);
        String r6 = " backoff request as ratio not allowed to send: ";
    L33:
        r5.append(r6);
        r5.append(r2);
        n.e(r5.toString());
    L19:
        if (com.bytedance.applog.a.g() == false) goto L23;
        if (r1.I(this.f2259a.x()) == false) goto L23;
        r5 = new StringBuilder();
        r5.append(this.f2285k);
        r6 = " adjust terminate not allowed to send: ";
    L23:
        n.e(this.f2285k + " send pack start: " + r2);
        int r7 = com.bytedance.applog.v.a.k(r12, r1.v, r11, r1.F(), r1.N, r1.O);
        r1.x = r7;
        n.e(this.f2285k + " send pack end: " + r2 + ", resp code: " + r7);
        if (com.bytedance.applog.v.a.b(r7) == true) goto L25;
        if (r7 == 200) goto L28;
        r0.f2280b.add(r1);
        com.bytedance.applog.s.b r8 = this.f2284j;
        if (r8 == null) goto L4;
        r8.a(r7);
        goto L4
    L28:
        this.f2283i.d();
        r0.f2279a.add(r1);
        goto L4
    L25:
        this.f2283i.c();
        r0.f2280b.add(r1);
        goto L34
    L12:
        b.d(com.bytedance.applog.r.b.a.n, com.bytedance.applog.r.b.d.x);
        n.e(this.f2285k + " CongestionController not allowed to send: " + r2);
    L32:
        r0.f2279a.add(r1);
        b.d(com.bytedance.applog.r.b.a.n, com.bytedance.applog.r.b.d.u);
        r5 = new StringBuilder();
        r5.append(this.f2285k);
        r6 = " send empty pack: ";
    L34:
        return r0;
    }

    private List<com.bytedance.applog.w.g> o(com.bytedance.applog.w.b r5) {
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        ArrayList r2 = new ArrayList();
        Iterator<com.bytedance.applog.w.g> r4 = r5.u(this.f2284j).iterator();
    L4:
        if (r4.hasNext() == false) goto L13;
        com.bytedance.applog.w.g r6 = r4.next();
        if (r6.G() == true) goto L7;
        if (r6.H() == true) goto L10;
        r0.add(r6);
        goto L4
    L10:
        r2.add(r6);
        goto L4
    L7:
        r1.add(r6);
        goto L4
    L13:
        if (r2.isEmpty() == true) goto L16;
        r1.addAll(r2);
    L16:
        if (r1.isEmpty() == true) goto L18;
        r0.addAll(!r0.isEmpty() ? 1 : 0, r1);
    L18:
        return r0;
    }

    private void p(int r6) {
        List<com.bytedance.applog.w.g> r0 = o(this.f2259a.s());
        if (r0.size() <= 0) goto L6;
        e.C0071e r7 = n(this.f2259a.q(), com.bytedance.applog.v.b.a(this.f2259a, false, this.f2284j), r0, r6);
        n.f(this.f2285k + " " + r7.f2279a.size() + " " + r0.size(), null);
        this.f2259a.n(r7);
        return;
    }

    @Override // com.bytedance.applog.o.c
    public boolean c(int r10) {
        long r0 = System.currentTimeMillis();
        h r2 = this.f2259a.x();
        StringBuilder r3 = new StringBuilder();
        r3.append(this.f2285k);
        r3.append(" start doWork curTs=");
        r3.append(r0);
        r3.append(", curSid=");
        if (r2 == null) goto L5;
        String r4 = r2.d();
    L6:
        r3.append(r4);
        n.e(r3.toString());
        boolean r5 = true;
        if (com.bytedance.applog.a.D() == true) goto L9;
    L12:
        if (r2 == null) goto L16;
        Bundle r1 = r2.g(r0, 50000);
        if (r1 == null) goto L16;
        com.bytedance.applog.a.E("play_session", r1);
        com.bytedance.applog.a.d();
    L16:
        com.bytedance.applog.w.b r6 = this.f2259a.s();
        com.bytedance.applog.q.c r7 = this.f2259a.t();
        if (r7.l() == false) goto L30;
        JSONObject r8 = l.a(r7.d());
        if (r7.m(r8) == false) goto L25;
        com.bytedance.applog.g r9 = com.bytedance.applog.a.q();
        if (r9 == null) goto L23;
        r9.a(r8);
    L23:
        r6.o(r8, this.f2284j, r10);
        p(r10);
    L36:
        return r5;
    L25:
        if (r8 == null) goto L27;
        StringBuilder r11 = new StringBuilder();
        r11.append(this.f2285k);
        r11.append(" new header without valid did: ");
        r11.append(r8.optString(WsConstants.KEY_DEVICE_ID));
        r11.append(", iid: ");
        String r12 = r8.optString("install_id");
    L28:
        r11.append(r12);
        n.c(r11.toString(), null);
        b.d(com.bytedance.applog.r.b.a.n, com.bytedance.applog.r.b.d.z);
        r5 = false;
        goto L36
    L27:
        r11 = new StringBuilder();
        r11.append(this.f2285k);
        r12 = " new header is null";
        goto L28
    L30:
        JSONObject r13 = r7.d();
        if (r13 == null) goto L33;
        String r14 = this.f2285k + " device header without valid did: " + r13.optString(WsConstants.KEY_DEVICE_ID) + ", iid: " + r13.optString("install_id");
    L34:
        n.c(r14, null);
        b.d(com.bytedance.applog.r.b.a.n, com.bytedance.applog.r.b.d.z);
        return false;
    L33:
        r14 = this.f2285k + " device header is null";
        goto L34
    L9:
        if (com.bytedance.applog.a.A() == true) goto L12;
        n.h(this.f2285k + " not send events in tourist mode", null);
        return true;
    L5:
        r4 = "null";
        goto L6
    }

    @Override // com.bytedance.applog.o.c
    protected String e() {
        return this.f2285k;
    }

    @Override // com.bytedance.applog.o.c
    protected long[] f() {
        return this.f2282h;
    }

    @Override // com.bytedance.applog.o.c
    protected boolean h() {
        return !this.f2261c;
    }

    @Override // com.bytedance.applog.o.c
    protected long i() {
        com.bytedance.applog.s.b r0 = this.f2284j;
        if (r0 == null) goto L7;
        return r0.c();
    L7:
        return this.f2259a.q().p();
    }

    void q(com.bytedance.applog.s.b r2, int r3) {
        if (r2 != this.f2284j) goto L6;
        this.f2283i.g(r3);
        return;
    }
}
