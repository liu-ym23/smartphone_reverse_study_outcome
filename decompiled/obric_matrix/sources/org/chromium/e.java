package org.chromium;

import android.os.Process;
import com.ttnet.org.chromium.net.TTEventListener;
import com.ttnet.org.chromium.net.impl.TTCronetInitTimingInfo;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e extends TTEventListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile e f22668c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f22669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f22670b;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f22671f;

        a(e r1, long r2) {
            this.f22671f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r0 = d.b.h.a.a.c.k().c();
            JSONObject r4 = d.b.h.a.a.c.k().d(this.f22671f);
            c.W().y0(r0.toString(), "ttnet_init");
            c.W().y0(r4.toString(), "ttnet_init_v2");
        }
    }

    private e() {
        this.f22669a = false;
        this.f22670b = false;
    }

    public static e a() {
        if (f22668c != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f22668c != null) goto L9;
        f22668c = new e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f22668c;
    }

    public void b(String r1, int r2) {
        if (this.f22669a == false) goto L6;
        c.W().i0(r1, r2);
        return;
    }

    public void c(boolean r1) {
        this.f22669a = r1;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void handleApiResult(boolean r38, String r39, String r40, String r41, long r42, long r44, long r46, long r48, long r50, long r52, long r54, long r56, long r58, long r60, boolean r62, long r63, long r65, String r67, String r68, String r69, int r70, int r71, String r72) {
        if (this.f22669a == false) goto L6;
        c.W().U(r38, r39, r40, r41, r42, r44, r46, r48, r50, r52, r54, r56, r58, r60, r62, r63, r65, r67, r68, r69, r70, r71, r72);
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public boolean handleApiSample(String r1, String r2) {
        return c.W().V(r1, r2);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public Map<String, String> onCallToAddSecurityFactor(String r1, Map<String, String> r2) {
        return c.W().c0(r1, r2);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onClientIPChanged(String r1) {
        if (this.f22669a == false) goto L6;
        c.W().d0(r1);
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onColdStartFinish() {
        if (this.f22669a == false) goto L6;
        c.W().e0();
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onContextInitCompleted(long r8, long r10, long r12, long r14, long r16, long r18, long r20, long r22, long r24, long r26, long r28, long r30, long r32, long r34, long r36, long r38) {
        if (this.f22670b == false) goto L5;
        d.b.h.a.a.c.o(true);
    L5:
        d.b.h.a.a.c r1 = d.b.h.a.a.c.k();
        r1.f13227c = Process.getThreadPriority(0);
        r1.F = TTCronetInitTimingInfo.sInitThreadStart;
        r1.G = TTCronetInitTimingInfo.sInitThreadEnd;
        r1.H = TTCronetInitTimingInfo.sLoadCronetSoStart;
        r1.I = TTCronetInitTimingInfo.sLoadCronetSoEnd;
        r1.f13224J = TTCronetInitTimingInfo.sNativeInitTimingJson;
        r1.L = TTCronetInitTimingInfo.sABTest;
        r1.K = System.nanoTime();
        r1.N = r8;
        r1.O = r10;
        r1.P = r12;
        r1.M = r14;
        r1.Q = r16;
        r1.R = r18;
        r1.S = r20;
        r1.T = r22;
        r1.U = r24;
        r1.V = r26;
        r1.W = r28;
        r1.X = r30;
        r1.Y = r32;
        r1.Z = r34;
        r1.a0 = r36;
        r1.b0 = r38;
        long r3 = c.W().f();
        if (d.b.h.a.a.c.k().b() == true) goto L11;
        com.bytedance.common.utility.m.a.d().schedule(new a(this, r3), 5, TimeUnit.SECONDS);
        if (this.f22670b == true) goto L16;
        d.b.h.a.a.c.o(true);
        return;
    L16:
        return;
    L11:
        JSONObject r2 = d.b.h.a.a.c.k().c();
        JSONObject r4 = d.b.h.a.a.c.k().d(r3);
        if (this.f22670b == true) goto L14;
        d.b.h.a.a.c.o(true);
    L14:
        c.W().y0(r2.toString(), "ttnet_init");
        c.W().y0(r4.toString(), "ttnet_init_v2");
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onCronetBootSucceed() {
        if (this.f22669a == false) goto L6;
        c.W().f0();
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onDropReasonChanged(boolean r1, List<Integer> r2) {
        if (this.f22669a == false) goto L6;
        c.W().g0(r1, r2);
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onEffectiveConnectionTypeChanged(int r1) {
        c.W().h0(r1);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onMultiNetStateChanged(int r1, int r2) {
        c.W().j0(r1, r2);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onMultiNetworkStateChanged(int r1, int r2) {
        c.W().k0(r1, r2);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onNetworkQualityLevelChanged(int r1) {
        c.W().l0(r1);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onNetworkQualityRttAndThroughputNotified(int r1, int r2, int r3) {
        c.W().m0(r1, r2, r3);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onNetworkQualityTypeChangedV3(int r1) {
        c.W().n0(r1);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onPacketLossComputed(int r11, double r12, double r14, double r16, double r18) {
        c.W().o0(r11, r12, r14, r16, r18);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onPublicIPsChanged(List<String> r1, List<String> r2) {
        if (this.f22669a == false) goto L6;
        c.W().p0(r1, r2);
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onRTTOrThroughputEstimatesComputed(int r1, int r2, int r3) {
        c.W().q0(r1, r2, r3);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public String onRequestInterceptorToStart(String r1, Map<String, String> r2, List<String> r3) {
        return d.b.h.a.a.h.f.a(r1, r2, r3);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public String onResponseInterceptorToStart(String r1, Map<String, List<String>> r2, int r3) {
        return d.b.h.a.a.h.f.b(r1, r2, r3);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onServerConfigUpdated(String r1, String r2, String r3) {
        if (this.f22669a == false) goto L6;
        c.W().r0(r1, r2, r3);
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onStoreIdcChanged(String r8, String r9, String r10, String r11, String r12, String r13) {
        if (this.f22669a == false) goto L6;
        c.W().s0(r8, r9, r10, r11, r12, r13);
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onTLBDecompressFail() {
        d.b.r.k0.f.q();
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onTNCUpdateFailed(String[] r1, String r2) {
        if (this.f22669a == false) goto L6;
        c.W().t0(r1, r2);
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onTTDnsResolveResult(String r9, String r10, int r11, int r12, int r13, List<String> r14, String r15) {
        c.W().u0(r9, r10, r11, r12, r13, r14, r15);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onTTNetDetectInfoChanged(String r1) {
        if (this.f22669a == false) goto L6;
        c.W().v0(r1);
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onTncRequestSucceeded(boolean r1, boolean r2, int r3) {
        c.W().w0(r1, r2, r3);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onUserSpecifiedNetworkEnabled(boolean r1) {
        c.W().x0(r1);
    }
}
