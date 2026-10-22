package com.bytedance.android.sdk.bdticketguard.p1;

import kotlin.n0.d.e0;
import kotlin.n0.d.o;
import kotlin.n0.d.s;
import kotlin.n0.d.y;

/* JADX INFO: loaded from: classes.dex */
public final class k extends b {
    private static final l A = null;
    private static final l B = null;
    private static final l C = null;
    private static final l D = null;
    private static final l E = null;
    private static final l F = null;
    private static final l G = null;
    private static final l H = null;
    private static final l I = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final k f1023J = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final /* synthetic */ kotlin.s0.l[] f1024d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final d f1025e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final l f1026f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final d f1027g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final d f1028h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final d f1029i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final d f1030j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final d f1031k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final l f1032l = null;
    private static final l m = null;
    private static final l n = null;
    private static final l o = null;
    private static final l p = null;
    private static final l q = null;
    private static final l r = null;
    private static final l s = null;
    private static final l t = null;
    private static final l u = null;
    private static final l v = null;
    private static final l w = null;
    private static final l x = null;
    private static final l y = null;
    private static final l z = null;

    static {
        f1024d = new kotlin.s0.l[]{e0.e(new s(e0.b(k.class), "useStandardizedHmacAlgorithm", "getUseStandardizedHmacAlgorithm()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), e0.g(new y(e0.b(k.class), "ticketGuardConfigVersion", "getTicketGuardConfigVersion()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), e0.e(new s(e0.b(k.class), "enableInitOpt", "getEnableInitOpt()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), e0.e(new s(e0.b(k.class), "enableTeeReeParallelInit", "getEnableTeeReeParallelInit()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), e0.e(new s(e0.b(k.class), "enableHighThreadPriorityInit", "getEnableHighThreadPriorityInit()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), e0.e(new s(e0.b(k.class), "enableInitRefactor", "getEnableInitRefactor()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), e0.e(new s(e0.b(k.class), "enableHmacCache", "getEnableHmacCache()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), e0.g(new y(e0.b(k.class), "enableKeyAttestation", "getEnableKeyAttestation()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), e0.g(new y(e0.b(k.class), "keyAttestationInitialDelay", "getKeyAttestationInitialDelay()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), e0.g(new y(e0.b(k.class), "keyAttestationRetryInterval", "getKeyAttestationRetryInterval()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), e0.g(new y(e0.b(k.class), "keyAttestationMaxAttempts", "getKeyAttestationMaxAttempts()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), e0.g(new y(e0.b(k.class), "keyAttestationDetectKeyChange", "getKeyAttestationDetectKeyChange()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), e0.g(new y(e0.b(k.class), "keyAttestationEnableInvalidate", "getKeyAttestationEnableInvalidate()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), e0.g(new y(e0.b(k.class), "keyAttestationEnableWaitForSettings", "getKeyAttestationEnableWaitForSettings()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), e0.g(new y(e0.b(k.class), "enablePrioritizeAccountInitParam", "getEnablePrioritizeAccountInitParam()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), e0.g(new y(e0.b(k.class), "enableAttestationSnapshotReport", "getEnableAttestationSnapshotReport()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), e0.g(new y(e0.b(k.class), "enableAttestationRegenKeyIfFailed", "getEnableAttestationRegenKeyIfFailed()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), e0.g(new y(e0.b(k.class), "enableAttestationMonitorSuccessIfHasReport", "getEnableAttestationMonitorSuccessIfHasReport()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), e0.g(new y(e0.b(k.class), "needAttestationSnapshotLocalErrorCodes", "getNeedAttestationSnapshotLocalErrorCodes()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), e0.g(new y(e0.b(k.class), "needAttestationSnapshotRemoteErrorCodes", "getNeedAttestationSnapshotRemoteErrorCodes()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), e0.g(new y(e0.b(k.class), "enableHuaweiAttestationAdapter", "getEnableHuaweiAttestationAdapter()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), e0.g(new y(e0.b(k.class), "enableHuaweiAdapterUpgrade", "getEnableHuaweiAdapterUpgrade()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), e0.g(new y(e0.b(k.class), "enableHonorAttestationAdapter", "getEnableHonorAttestationAdapter()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), e0.g(new y(e0.b(k.class), "enableHonorAdapterUpgrade", "getEnableHonorAdapterUpgrade()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), e0.g(new y(e0.b(k.class), "attestationAdapterOverride", "getAttestationAdapterOverride()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), e0.g(new y(e0.b(k.class), "enableAttestationTriggerInit", "getEnableAttestationTriggerInit()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), e0.g(new y(e0.b(k.class), "attestationWaitForCertRequestTimeoutSeconds", "getAttestationWaitForCertRequestTimeoutSeconds()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), e0.g(new y(e0.b(k.class), "honorSdkAppId", "getHonorSdkAppId()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), e0.g(new y(e0.b(k.class), "enableMagic7Attest", "getEnableMagic7Attest()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), e0.g(new y(e0.b(k.class), "useOldHuaweiAttestRestriction", "getUseOldHuaweiAttestRestriction()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;")), e0.g(new y(e0.b(k.class), "enableLoginAttestation", "getEnableLoginAttestation()Lcom/bytedance/android/sdk/bdticketguard/setting/ISettingProvider;"))};
        k r0 = new k();
        f1023J = r0;
        f1025e = r0.b(Boolean.TRUE);
        f1026f = r0.j("ticket_guard_config_version", "<default>");
        Boolean r1 = Boolean.FALSE;
        f1027g = r0.b(r1);
        f1028h = r0.b(r1);
        f1029i = r0.b(r1);
        f1030j = r0.b(r1);
        f1031k = r0.b(r1);
        f1032l = r0.g("enable_key_attestation", false);
        m = r0.i("key_attestation_initial_delay", 60);
        n = r0.i("key_attestation_retry_delay", 60);
        o = r0.h("key_attestation_max_attempts", 3);
        p = r0.g("key_attestation_enable_detect_key_change", true);
        q = r0.g("key_attestation_enable_invalidate", false);
        r = r0.g("key_attestation_enable_wait_for_settings", true);
        s = r0.g("enable_prioritize_account_init_param", true);
        t = r0.g("enable_attestation_snapshot_report", false);
        u = r0.g("enable_attestation_regen_key_if_failed", false);
        v = r0.g("enable_attestation_monitor_success_if_has_report", false);
        w = r0.j("need_attestation_snapshot_local_error_codes", "");
        x = r0.j("need_attestation_snapshot_remote_error_codes", "");
        y = r0.g("enable_huawei_attestation_adapter", false);
        z = r0.g("enable_huawei_adapter_upgrade", true);
        A = r0.g("enable_honor_attestation_adapter", false);
        B = r0.g("enable_honor_adapter_upgrade", true);
        C = r0.j("attestation_adapter_override", "");
        D = r0.g("enable_attestation_trigger_init", true);
        E = r0.i("attestation_wait_for_cert_request_timeout_seconds", 10);
        F = r0.j("honor_sdk_app_id", "");
        G = r0.g("enable_magic7_attest", false);
        H = r0.g("use_old_huawei_attest_restriction", false);
        I = r0.g("enable_login_attestation", false);
    }

    private k() {
    }

    public final e<Boolean> A() {
        return I.a(this, f1024d[30]);
    }

    public final e<Boolean> B() {
        return G.a(this, f1024d[28]);
    }

    public final e<Boolean> C() {
        return s.a(this, f1024d[14]);
    }

    public final e<Boolean> D() {
        return f1028h.b(this, f1024d[3]);
    }

    public final e<String> E() {
        return F.a(this, f1024d[27]);
    }

    public final e<Boolean> F() {
        return p.a(this, f1024d[11]);
    }

    public final e<Boolean> G() {
        return q.a(this, f1024d[12]);
    }

    public final e<Boolean> H() {
        return r.a(this, f1024d[13]);
    }

    public final e<Long> I() {
        return m.a(this, f1024d[8]);
    }

    public final e<Integer> J() {
        return o.a(this, f1024d[10]);
    }

    public final e<Long> K() {
        return n.a(this, f1024d[9]);
    }

    public final e<String> L() {
        return w.a(this, f1024d[18]);
    }

    public final e<String> M() {
        return x.a(this, f1024d[19]);
    }

    public final e<String> N() {
        return f1026f.a(this, f1024d[1]);
    }

    public final e<Boolean> O() {
        return H.a(this, f1024d[29]);
    }

    public final e<Boolean> P() {
        return f1025e.b(this, f1024d[0]);
    }

    public final void Q(e<Boolean> r4) {
        o.g(r4, "<set-?>");
        f1029i.c(this, f1024d[4], r4);
    }

    public final void R(e<Boolean> r4) {
        o.g(r4, "<set-?>");
        f1031k.c(this, f1024d[6], r4);
    }

    public final void S(e<Boolean> r4) {
        o.g(r4, "<set-?>");
        f1027g.c(this, f1024d[2], r4);
    }

    public final void T(e<Boolean> r4) {
        o.g(r4, "<set-?>");
        f1030j.c(this, f1024d[5], r4);
    }

    public final void U(e<Boolean> r4) {
        o.g(r4, "<set-?>");
        f1028h.c(this, f1024d[3], r4);
    }

    public final void V(e<Boolean> r4) {
        o.g(r4, "<set-?>");
        f1025e.c(this, f1024d[0], r4);
    }

    public final e<String> l() {
        return C.a(this, f1024d[24]);
    }

    public final e<Long> m() {
        return E.a(this, f1024d[26]);
    }

    public final e<Boolean> n() {
        return v.a(this, f1024d[17]);
    }

    public final e<Boolean> o() {
        return u.a(this, f1024d[16]);
    }

    public final e<Boolean> p() {
        return t.a(this, f1024d[15]);
    }

    public final e<Boolean> q() {
        return D.a(this, f1024d[25]);
    }

    public final e<Boolean> r() {
        return f1029i.b(this, f1024d[4]);
    }

    public final e<Boolean> s() {
        return f1031k.b(this, f1024d[6]);
    }

    public final e<Boolean> t() {
        return B.a(this, f1024d[23]);
    }

    public final e<Boolean> u() {
        return A.a(this, f1024d[22]);
    }

    public final e<Boolean> v() {
        return z.a(this, f1024d[21]);
    }

    public final e<Boolean> w() {
        return y.a(this, f1024d[20]);
    }

    public final e<Boolean> x() {
        return f1027g.b(this, f1024d[2]);
    }

    public final e<Boolean> y() {
        return f1030j.b(this, f1024d[5]);
    }

    public final e<Boolean> z() {
        return f1032l.a(this, f1024d[7]);
    }
}
