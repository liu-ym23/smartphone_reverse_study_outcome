package i.a.a.a;

import android.content.Context;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.privacy.PrivacySdk;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import kotlin.v;
import kotlin.w;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006¨\u0006\n"}, d2 = {"Lobric/common/security/attestation/PrivacySDKUtils;", "", "()V", "buildAttestationConfig", "Lcom/bytedance/privacy/attestation/AttestationConfig;", LocationMonitorConst.INFO, "", "getIDAttestation", "appId", "Companion", "common_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f17599a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile c f17600b;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lobric/common/security/attestation/PrivacySDKUtils$Companion;", "", "()V", "TAG", "", "instance", "Lobric/common/security/attestation/PrivacySDKUtils;", "getInstance", "common_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g r1) {
            this();
        }

        public final c a() {
            c r0 = c.a();
            if (r0 != null) goto L13;
            monitor-enter(this);
            r0 = c.a();     // Catch: Throwable -> L10
            if (r0 != null) goto L8;
            r0 = new c(null);     // Catch: Throwable -> L10
            a r1 = c.f17599a;     // Catch: Throwable -> L10
            c.b(r0);     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
        L10:
            th = move-exception;
            throw th;
        L13:
            return r0;
        }
    }

    static {
        f17599a = new a(null);
    }

    private c() {
        v.a r2 = v.f21457g;     // Catch: Throwable -> L5
        PrivacySdk.init(new i.a.a.a.a(), new b());     // Catch: Throwable -> L5
        Object r3 = f0.f18324a;     // Catch: Throwable -> L5
        v.b(r3);     // Catch: Throwable -> L5
    L7:
        Throwable r4 = v.d(r3);
        if (r4 == null) goto L13;
        com.obric.matrix.r.c.c.g("PrivacySDKUtils", "init privacy sdk failed", r4);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        v.a r0 = v.f21457g;
        r3 = w.a(th);
        v.b(r3);
        goto L7
    }

    public /* synthetic */ c(g r1) {
        this();
    }

    public static final /* synthetic */ c a() {
        return f17600b;
    }

    public static final /* synthetic */ void b(c r0) {
        f17600b = r0;
    }

    private final com.bytedance.privacy.a.a c(String r3) {
        v.a r2 = v.f21457g;     // Catch: Throwable -> L4
        com.bytedance.privacy.a.a.b r4 = new com.bytedance.privacy.a.a.b();     // Catch: Throwable -> L4
        r4.e(r3);     // Catch: Throwable -> L4
        r4.f();     // Catch: Throwable -> L4
        Object r5 = r4.d();     // Catch: Throwable -> L4
        v.b(r5);     // Catch: Throwable -> L4
    L6:
        Throwable r6 = v.d(r5);
        if (r6 == null) goto L10;
        com.obric.matrix.r.c.c.g("PrivacySDKUtils", "build attestation config failed", r6);
    L10:
        if (v.f(r5) == false) goto L13;
        r5 = null;
    L13:
        return (com.bytedance.privacy.a.a) r5;
    L4:
        th = move-exception;
        v.a r7 = v.f21457g;
        r5 = w.a(th);
        v.b(r5);
        goto L6
    }

    public final String d(String r4, String r5) {
        o.f(r4, LocationMonitorConst.INFO);
        o.f(r5, "appId");
        Object r0 = null;
        v.a r1 = v.f21457g;     // Catch: Throwable -> L13
        com.bytedance.privacy.a.a r3 = c(r4);     // Catch: Throwable -> L13
        if (r3 != null) goto L6;
        Object r6 = null;
    L11:
        v.b(r6);     // Catch: Throwable -> L13
    L15:
        Throwable r7 = v.d(r6);
        if (r7 == null) goto L19;
        com.obric.matrix.r.c.c.g("PrivacySDKUtils", "get id attestation failed", r7);
    L19:
        if (v.f(r6) == true) goto L23;
        r0 = r6;
    L23:
        return (String) r0;
    L6:
        com.bytedance.privacy.a.c r8 = PrivacySdk.getIdAttestationManager();     // Catch: Throwable -> L13
        Context r2 = com.bytedance.mpaas.app.a.a();     // Catch: Throwable -> L13
        if (r2.isDeviceProtectedStorage() == true) goto L10;
        r2 = r2.createDeviceProtectedStorageContext();     // Catch: Throwable -> L13
    L10:
        r6 = r8.e(r2, r5, "SYSTEM_Device_TLS_pkey", r3);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        v.a r9 = v.f21457g;
        r6 = w.a(th);
        v.b(r6);
        goto L15
    }
}
