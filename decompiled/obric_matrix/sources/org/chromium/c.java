package org.chromium;

import android.util.Pair;
import com.ttnet.org.chromium.base.Reflect;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile c f22663b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f22664a;

    private c() {
    }

    private String J(String r2) {
        Object r1 = this.f22664a;     // Catch: Throwable -> L8
        if (r1 != null) goto L6;
        return "";
    L6:
        return (String) Reflect.on(r1).call(r2).get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    public static c W() {
        if (f22663b != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f22663b != null) goto L9;
        f22663b = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f22663b;
    }

    public ArrayList<byte[]> A() {
        Object r2 = this.f22664a;     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return null;
    L6:
        return (ArrayList) Reflect.on(r2).call("getOpaqueData").get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public boolean B() {
        Object r2 = this.f22664a;     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return false;
    L6:
        return ((Boolean) Reflect.on(r2).call("getOptInit").get()).booleanValue();
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public Map<String, Pair<Integer, Integer>> C() {
        Object r2 = this.f22664a;     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return null;
    L6:
        return (Map) Reflect.on(r2).call("getQuicHint").get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public String D() {
        return J("getRegion");
    }

    public String E() {
        return J("getSdkAppId");
    }

    public String F() {
        return J("getSdkVersion");
    }

    public String G() {
        Object r2 = this.f22664a;     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return "";
    L6:
        return (String) Reflect.on(r2).call("getSimOperator").get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    public String H() {
        return J("getStoreIdc");
    }

    public String I() {
        Object r2 = this.f22664a;     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return null;
    L6:
        return (String) Reflect.on(r2).call("getStoreIdcRuleJSON").get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public String K() {
        return J("getSysRegion");
    }

    public String L() {
        return J("getTNCRequestFlags");
    }

    public Map<String, String> M() {
        Object r2 = this.f22664a;     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return null;
    L6:
        return (Map) Reflect.on(r2).call("getTNCRequestHeader").get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public Map<String, String> N() {
        Object r2 = this.f22664a;     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return null;
    L6:
        return (Map) Reflect.on(r2).call("getTNCRequestQuery").get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public String O() {
        return J("getUpdateVersionCode");
    }

    public String P() {
        return J("getUserId");
    }

    public String Q() {
        return J("getVersionCode");
    }

    public String R() {
        return J("getVersionName");
    }

    public int S() {
        Object r2 = this.f22664a;     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return 0;
    L6:
        return ((Integer) Reflect.on(r2).call("getWifiFrequency").get()).intValue();
    L8:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    public int T() {
        Object r2 = this.f22664a;     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return 0;
    L6:
        return ((Integer) Reflect.on(r2).call("getWifiRssi").get()).intValue();
    L8:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    public void U(boolean r28, String r29, String r30, String r31, long r32, long r34, long r36, long r38, long r40, long r42, long r44, long r46, long r48, long r50, boolean r52, long r53, long r55, String r57, String r58, String r59, int r60, int r61, String r62) {
        if (d.a().loggerDebug() == false) goto L16;
        d.a().loggerD("CronetAppProviderManager", "handleApiResult ");
    L16:
    L13:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (this.f22664a != null) goto L8;
        return;
    L8:
        IOException r2 = null;
        if (r28 == true) goto L11;
        r2 = g.d(g.a(r60, r61, r62));     // Catch: Throwable -> L13
    L11:
        Reflect r0 = Reflect.on(this.f22664a);     // Catch: Throwable -> L13
        Class<?> r6 = Boolean.TYPE;     // Catch: Throwable -> L13
        Class<?> r11 = Long.TYPE;     // Catch: Throwable -> L13
        r0.call("handleApiResult", new Class[]{r6, String.class, String.class, String.class, r11, r11, r11, r11, r11, r11, r11, r11, r11, r11, r6, r11, r11, String.class, String.class, String.class, Exception.class}, new Object[]{Boolean.valueOf(r28), r29, r30, r31, Long.valueOf(r32), Long.valueOf(r34), Long.valueOf(r36), Long.valueOf(r38), Long.valueOf(r40), Long.valueOf(r42), Long.valueOf(r44), Long.valueOf(r46), Long.valueOf(r48), Long.valueOf(r50), Boolean.valueOf(r52), Long.valueOf(r53), Long.valueOf(r55), r57, r58, r59, r2});     // Catch: Throwable -> L13
    }

    public boolean V(String r7, String r8) {
        if (d.a().loggerDebug() == false) goto L14;
        d.a().loggerD("CronetAppProviderManager", "handleApiSample");
    L14:
        Object r6 = this.f22664a;     // Catch: Throwable -> L11
        if (r6 != null) goto L9;
        return false;
    L9:
        return ((Boolean) Reflect.on(r6).call("handleApiSample", new Class[]{String.class, String.class}, new Object[]{r7, r8}).get()).booleanValue();
    L11:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public boolean X() {
        Object r2 = this.f22664a;     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return false;
    L6:
        return ((Boolean) Reflect.on(r2).call("isBOEProxyEnabled").get()).booleanValue();
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public boolean Y() {
        Object r2 = this.f22664a;     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return false;
    L6:
        return ((Boolean) Reflect.on(r2).call("isEnableBrotli").get()).booleanValue();
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public boolean Z() {
        Object r2 = this.f22664a;     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return false;
    L6:
        return ((Boolean) Reflect.on(r2).call("isEnableHttp2").get()).booleanValue();
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public void a(String r6) {
        Object r5 = this.f22664a;     // Catch: Throwable -> L7
        if (r5 != null) goto L5;
        return;
    L5:
        Reflect.on(r5).call("doLoadLibrary", new Class[]{String.class}, new Object[]{r6});     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    public boolean a0() {
        Object r2 = this.f22664a;     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return false;
    L6:
        return ((Boolean) Reflect.on(r2).call("isEnableQuic").get()).booleanValue();
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public List<String> b() {
        Object r2 = this.f22664a;     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return null;
    L6:
        return (List) Reflect.on(r2).call("getAbSdkVersion").get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public boolean b0() {
        Object r2 = this.f22664a;     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return false;
    L6:
        return ((Boolean) Reflect.on(r2).call("needCustomLoadLibrary").get()).booleanValue();
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public String c() {
        return J("getAbi");
    }

    public Map<String, String> c0(String r8, Map<String, String> r9) {
        if (d.a().loggerDebug() == false) goto L14;
        d.a().loggerD("CronetAppProviderManager", "onCallToAddSecurityFactor info url = " + r8);
    L14:
        Object r7 = this.f22664a;     // Catch: Throwable -> L11
        if (r7 != null) goto L9;
        return null;
    L9:
        return (Map) Reflect.on(r7).call("onCallToAddSecurityFactor", new Class[]{String.class, Map.class}, new Object[]{r8, r9}).get();
    L11:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public String d() {
        return J("getAppId");
    }

    public void d0(String r6) {
        if (d.a().loggerDebug() == false) goto L13;
        d.a().loggerD("CronetAppProviderManager", "onClientIPChanged ");
    L13:
        Object r5 = this.f22664a;     // Catch: Throwable -> L10
        if (r5 != null) goto L8;
        return;
    L8:
        Reflect.on(r5).call("onClientIPChanged", new Class[]{String.class}, new Object[]{r6});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public String e() {
        return J("getAppName");
    }

    public void e0() {
        if (d.a().loggerDebug() == false) goto L13;
        d.a().loggerD("CronetAppProviderManager", "onColdStartFinish ");
    L13:
        Object r3 = this.f22664a;     // Catch: Throwable -> L10
        if (r3 != null) goto L8;
        return;
    L8:
        Reflect.on(r3).call("onColdStartFinish");     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public long f() {
        Object r3 = this.f22664a;     // Catch: Throwable -> L8
        if (r3 != null) goto L6;
        return -1;
    L6:
        return ((Long) Reflect.on(r3).call("getAppStartTime").get()).longValue();
    L8:
        th = move-exception;
        th.printStackTrace();
        return -1;
    }

    public void f0() {
        if (d.a().loggerDebug() == false) goto L13;
        d.a().loggerD("CronetAppProviderManager", "onCronetBootSucceed ");
    L13:
        Object r3 = this.f22664a;     // Catch: Throwable -> L10
        if (r3 != null) goto L8;
        return;
    L8:
        Reflect.on(r3).call("onCronetBootSucceed");     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public String g() {
        Object r2 = this.f22664a;     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return null;
    L6:
        return (String) Reflect.on(r2).call("getBypassBOEJSON").get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public void g0(boolean r7, List<Integer> r8) {
        if (d.a().loggerDebug() == false) goto L13;
        d.a().loggerD("CronetAppProviderManager", "onDropReasonChanged " + r7 + ", Drop Reason List " + r8);
    L13:
        Object r6 = this.f22664a;     // Catch: Throwable -> L10
        if (r6 != null) goto L8;
        return;
    L8:
        Reflect.on(r6).call("onDropReasonChanged", new Class[]{Boolean.TYPE, List.class}, new Object[]{Boolean.valueOf(r7), r8});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public String h() {
        return J("getCarrierRegion");
    }

    public void h0(int r6) {
        if (d.a().loggerDebug() == false) goto L13;
        d.a().loggerD("CronetAppProviderManager", "onEffectiveConnectionTypeChanged type = " + r6);
    L13:
        Object r5 = this.f22664a;     // Catch: Throwable -> L10
        if (r5 != null) goto L8;
        return;
    L8:
        Reflect.on(r5).call("onEffectiveConnectionTypeChangedOnIOThread", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r6)});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public String i() {
        return J("getChannel");
    }

    public void i0(String r7, int r8) {
        if (d.a().loggerDebug() == false) goto L13;
        d.a().loggerD("CronetAppProviderManager", "onMappingRequestStatus key = " + r7 + " status = " + r8);
    L13:
        Object r6 = this.f22664a;     // Catch: Throwable -> L10
        if (r6 != null) goto L8;
        return;
    L8:
        Reflect.on(r6).call("onMappingRequestStatus", new Class[]{String.class, Integer.TYPE}, new Object[]{r7, Integer.valueOf(r8)});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public Map<String[], Pair<byte[], byte[]>> j() {
        Object r2 = this.f22664a;     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return null;
    L6:
        return (Map) Reflect.on(r2).call("getClientOpaqueData").get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public void j0(int r7, int r8) {
        if (d.a().loggerDebug() == false) goto L13;
        d.a().loggerD("CronetAppProviderManager", "onMultiNetStateChanged, prev state = " + r7 + ", curr state = " + r8);
    L13:
        Object r6 = this.f22664a;     // Catch: Throwable -> L10
        if (r6 != null) goto L8;
        return;
    L8:
        Reflect r9 = Reflect.on(r6);     // Catch: Throwable -> L10
        Class<?> r3 = Integer.TYPE;     // Catch: Throwable -> L10
        r9.call("onMultiNetStateChanged", new Class[]{r3, r3}, new Object[]{Integer.valueOf(r7), Integer.valueOf(r8)}).get();     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public String k() {
        Object r2 = this.f22664a;     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return null;
    L6:
        return (String) Reflect.on(r2).call("getCronetSoPath").get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public void k0(int r7, int r8) {
        if (d.a().loggerDebug() == false) goto L13;
        d.a().loggerD("CronetAppProviderManager", "onMultiNetworkStateChanged, prev state = " + r7 + ", curr state = " + r8);
    L13:
        Object r6 = this.f22664a;     // Catch: Throwable -> L10
        if (r6 != null) goto L8;
        return;
    L8:
        Reflect r9 = Reflect.on(r6);     // Catch: Throwable -> L10
        Class<?> r3 = Integer.TYPE;     // Catch: Throwable -> L10
        r9.call("onWiFiToCellStateChangedOnIOThread", new Class[]{r3, r3}, new Object[]{Integer.valueOf(r7), Integer.valueOf(r8)}).get();     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public String l() {
        return J("getDeviceBrand");
    }

    public void l0(int r6) {
        if (d.a().loggerDebug() == false) goto L13;
        d.a().loggerD("CronetAppProviderManager", "onNetworkQualityLevelChanged, nql: " + r6);
    L13:
        Object r5 = this.f22664a;     // Catch: Throwable -> L10
        if (r5 != null) goto L8;
        return;
    L8:
        Reflect.on(r5).call("onNetworkQualityLevelChangedOnIOThread", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r6)}).get();     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public String m() {
        return J("getDeviceId");
    }

    public void m0(int r8, int r9, int r10) {
        if (d.a().loggerDebug() == false) goto L13;
        d.a().loggerD("CronetAppProviderManager", "onNetworkQualityRttAndThroughputNotified, effectiveHrttMs: " + r8 + ", effectiveTrttMs: " + r9 + ", effectiveRxThroughputKbps: " + r10);
    L13:
        Object r7 = this.f22664a;     // Catch: Throwable -> L10
        if (r7 != null) goto L8;
        return;
    L8:
        Reflect r11 = Reflect.on(r7);     // Catch: Throwable -> L10
        Class<?> r3 = Integer.TYPE;     // Catch: Throwable -> L10
        r11.call("onNetworkQualityRttAndThroughputNotifiedOnIOThread", new Class[]{r3, r3, r3}, new Object[]{Integer.valueOf(r8), Integer.valueOf(r9), Integer.valueOf(r10)}).get();     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public String n() {
        return J("getDeviceModel");
    }

    public void n0(int r8) {
        if (d.a().loggerDebug() == false) goto L13;
        d.a().loggerD("CronetAppProviderManager", "onNetworkQualityTypeChangedV3, network_quality_type = " + r8);
    L13:
        Object r7 = this.f22664a;     // Catch: Throwable -> L10
        if (r7 != null) goto L8;
        return;
    L8:
        Reflect r9 = Reflect.on(r7);     // Catch: Throwable -> L10
        Class<?> r3 = Integer.TYPE;     // Catch: Throwable -> L10
        r9.call("onEffectiveConnectionTypeChangedOnIOThread", new Class[]{r3}, new Object[]{Integer.valueOf(r8)});     // Catch: Throwable -> L10
        Reflect.on("com.bytedance.ttnet.NQEManager").call("notifyNQTChanged", new Class[]{r3}, new Object[]{Integer.valueOf(r8)});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public String o() {
        return J("getDevicePlatform");
    }

    public void o0(int r20, double r21, double r23, double r25, double r27) {
        if (d.a().loggerDebug() == false) goto L15;
        d.a().loggerD("CronetAppProviderManager", "onPacketLossComputed protocol = " + r20 + ", upstreamLossRate = " + r21 + ", upstreamLossRateVariance = " + r23 + ", downstreamLossRate = " + r25 + ", downstreamLossRateVariance = " + r27);
    L15:
        Object r0 = this.f22664a;     // Catch: Throwable -> L12
        if (r0 != null) goto L10;
        return;
    L10:
        Reflect r1 = Reflect.on(r0);     // Catch: Throwable -> L12
        Class<?> r13 = Double.TYPE;     // Catch: Throwable -> L12
        r1.call("onPacketLossComputedOnIOThread", new Class[]{Integer.TYPE, r13, r13, r13, r13}, new Object[]{Integer.valueOf(r20), Double.valueOf(r21), Double.valueOf(r23), Double.valueOf(r25), Double.valueOf(r27)});     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        th.printStackTrace();
    }

    public String p() {
        return J("getDeviceType");
    }

    public void p0(List<String> r7, List<String> r8) {
        if (d.a().loggerDebug() == false) goto L13;
        d.a().loggerD("CronetAppProviderManager", "onPublicIPsChanged ");
    L13:
        Object r6 = this.f22664a;     // Catch: Throwable -> L10
        if (r6 != null) goto L8;
        return;
    L8:
        Reflect.on(r6).call("onPublicIPsChanged", new Class[]{List.class, List.class}, new Object[]{r7, r8});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public String q() {
        Object r2 = this.f22664a;     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return null;
    L6:
        return (String) Reflect.on(r2).call("getGetDomainDefaultJSON").get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public void q0(int r8, int r9, int r10) {
        if (d.a().loggerDebug() == false) goto L13;
        d.a().loggerD("CronetAppProviderManager", "onRTTOrThroughputEstimatesComputed httpRtt = " + r8 + ", transportRttMs = " + r9 + ",downstreamThroughputKbps = " + r10);
    L13:
        Object r7 = this.f22664a;     // Catch: Throwable -> L10
        if (r7 != null) goto L8;
        return;
    L8:
        Reflect r11 = Reflect.on(r7);     // Catch: Throwable -> L10
        Class<?> r3 = Integer.TYPE;     // Catch: Throwable -> L10
        r11.call("onRTTOrThroughputEstimatesComputedOnIOThread", new Class[]{r3, r3, r3}, new Object[]{Integer.valueOf(r8), Integer.valueOf(r9), Integer.valueOf(r10)});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public Map<String, String> r() {
        Object r1 = this.f22664a;     // Catch: Throwable -> L8
        if (r1 != null) goto L7;
        return Collections.emptyMap();
    L7:
        return (Map) Reflect.on(r1).call("getGetDomainDependHostMap").get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return Collections.emptyMap();
    }

    public void r0(String r8, String r9, String r10) {
        if (d.a().loggerDebug() == false) goto L13;
        d.a().loggerD("CronetAppProviderManager", "onServerConfigUpdated json = " + r8);
    L13:
        Object r1 = this.f22664a;     // Catch: Throwable -> L10
        if (r1 != null) goto L8;
        return;
    L8:
        Reflect.on(r1).call("onServerConfigEtagChanged", new Class[]{String.class}, new Object[]{r9});     // Catch: Throwable -> L10
        Reflect.on(this.f22664a).call("onServerConfigABTestChanged", new Class[]{String.class}, new Object[]{r10});     // Catch: Throwable -> L10
        Reflect.on(this.f22664a).call("onServerConfigUpdated", new Class[]{String.class}, new Object[]{r8});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public String s() {
        return J("getHttpDnsRequestFlags");
    }

    public void s0(String r12, String r13, String r14, String r15, String r16, String r17) {
        if (d.a().loggerDebug() == false) goto L14;
        d.a().loggerD("CronetAppProviderManager", "onStoreIdcChanged ");
    L14:
        Object r1 = this.f22664a;     // Catch: Throwable -> L11
        if (r1 != null) goto L9;
        return;
    L9:
        Reflect.on(r1).call("onStoreIdcChanged", new Class[]{String.class, String.class, String.class, String.class, String.class, String.class}, new Object[]{r12, r13, r14, r15, r16, r17});     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
    }

    public String t() {
        return J("getAppInitialRegionInfo");
    }

    public void t0(String[] r7, String r8) {
        if (d.a().loggerDebug() == false) goto L20;
        d.a().loggerD("CronetAppProviderManager", "onTNCUpdateFailed ");
    L20:
    L17:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (this.f22664a == null) goto L16;
        if (r7 != null) goto L9;
        return;
    L9:
        if (r7.length <= 0) goto L24;
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L17
        int r1 = r7.length;     // Catch: Throwable -> L17
        int r3 = 0;
    L12:
        if (r3 >= r1) goto L14;
        r0.add(r7[r3]);     // Catch: Throwable -> L17
        r3 = r3 + 1;     // Catch: Throwable -> L17
        goto L12
    L14:
        Reflect.on(this.f22664a).call("onTNCUpdateFailed", new Class[]{ArrayList.class, String.class}, new Object[]{r0, r8});     // Catch: Throwable -> L17
        return;
    L24:
        return;
    }

    public String u() {
        Object r1 = this.f22664a;     // Catch: Throwable -> L8
        if (r1 != null) goto L6;
        return null;
    L6:
        return (String) Reflect.on(r1).call("getIsDropFirstTnc").get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    public void u0(String r15, String r16, int r17, int r18, int r19, List<String> r20, String r21) {
        if (d.a().loggerDebug() == false) goto L14;
        d.a().loggerD("CronetAppProviderManager", "onTTDnsResolveResult info uuid = " + r15 + " host: " + r16);
    L14:
        Object r3 = this.f22664a;     // Catch: Throwable -> L11
        if (r3 != null) goto L9;
        return;
    L9:
        Reflect r4 = Reflect.on(r3);     // Catch: Throwable -> L11
        Class<?> r9 = Integer.TYPE;     // Catch: Throwable -> L11
        r4.call("onTTDnsResolveResult", new Class[]{String.class, String.class, r9, r9, r9, List.class, String.class}, new Object[]{r15, r16, Integer.valueOf(r17), Integer.valueOf(r18), Integer.valueOf(r19), r20, r21});     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
    }

    public String v() {
        return J("getManifestVersionCode");
    }

    public void v0(String r6) {
        if (d.a().loggerDebug() == false) goto L13;
        d.a().loggerD("CronetAppProviderManager", "onTTNetDetectInfoChanged info str = " + r6);
    L13:
        Object r5 = this.f22664a;     // Catch: Throwable -> L10
        if (r5 != null) goto L8;
        return;
    L8:
        Reflect.on(r5).call("onTTNetDetectInfoChanged", new Class[]{String.class}, new Object[]{r6});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public String w() {
        return J("getNetAccessType");
    }

    public void w0(boolean r8, boolean r9, int r10) {
        Object r7 = this.f22664a;     // Catch: Throwable -> L7
        if (r7 != null) goto L5;
        return;
    L5:
        Reflect r11 = Reflect.on(r7);     // Catch: Throwable -> L7
        Class<?> r3 = Boolean.TYPE;     // Catch: Throwable -> L7
        r11.call("onTncRequestSucceeded", new Class[]{r3, r3, Integer.TYPE}, new Object[]{Boolean.valueOf(r8), Boolean.valueOf(r9), Integer.valueOf(r10)}).get();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    public String x() {
        Object r2 = this.f22664a;     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return "";
    L6:
        return (String) Reflect.on(r2).call("getNetworkOperator").get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    public void x0(boolean r6) {
        if (d.a().loggerDebug() == false) goto L13;
        d.a().loggerD("CronetAppProviderManager", "onUserSpecifiedNetworkEnabled, enable = " + r6);
    L13:
        Object r5 = this.f22664a;     // Catch: Throwable -> L10
        if (r5 != null) goto L8;
        return;
    L8:
        Reflect.on(r5).call("onUserSpecifiedNetworkEnabled", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(r6)});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public String y() {
        return J("getOSApi");
    }

    public void y0(String r7, String r8) {
        if (d.a().loggerDebug() == false) goto L13;
        d.a().loggerD("CronetAppProviderManager", "Send monitor json = " + r7 + ", log type =" + r8);
    L13:
        Object r6 = this.f22664a;     // Catch: Throwable -> L10
        if (r6 != null) goto L8;
        return;
    L8:
        Reflect.on(r6).call("sendAppMonitorEvent", new Class[]{String.class, String.class}, new Object[]{r7, r8});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public String z() {
        return J("getOSVersion");
    }

    public void z0(Object r4) {
        if (r4 == null) goto L31;
        Class<?> r0 = r4.getClass();     // Catch: Throwable -> L22
        if (r0 != null) goto L6;
        return;
    L6:
        List r1 = g.b(r0);     // Catch: Throwable -> L22
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.isEmpty() == true) goto L30;
        Iterator r2 = r1.iterator();     // Catch: Throwable -> L22
    L13:
        if (r2.hasNext() == false) goto L33;
        if ("com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider".equals(((Class) r2.next()).getName()) == false) goto L13;
        if (d.a().loggerDebug() == false) goto L19;
        d.a().loggerD("CronetAppProviderManager", "inject CronetAppProviderManager success");     // Catch: Throwable -> L22
    L19:
        this.f22664a = r4;     // Catch: Throwable -> L22
        return;
    L33:
        return;
    L30:
        return;
    L22:
        th = move-exception;
        th.printStackTrace();
        return;
    }
}
