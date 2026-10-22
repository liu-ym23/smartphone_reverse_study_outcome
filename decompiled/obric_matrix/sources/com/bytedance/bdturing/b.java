package com.bytedance.bdturing;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import androidx.room.RoomDatabase;
import com.bytedance.bdturing.identityverify.IdentityVerifyService;
import com.bytedance.bdturing.ttnet.TTNetHttpClient;
import com.bytedance.bdturing.verify.RiskControlService;
import com.bytedance.bdturing.verify.TwiceVerifyService;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BdTuringConfig f3036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f3037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private RiskControlService f3038c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashMap<String, com.bytedance.bdturing.verify.a> f3039d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f3040e;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ BdTuringConfig f3041f;

        a(b r1, BdTuringConfig r2) {
            this.f3041f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.bdturing.s.a.c(this.f3041f);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.bdturing.b$b, reason: collision with other inner class name */
    private static class C0083b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static b f3042a;

        static {
            f3042a = new b(null);
        }

        static /* synthetic */ b a() {
            return f3042a;
        }
    }

    private b() {
        this.f3037b = false;
        this.f3038c = null;
        this.f3039d = new HashMap();
        this.f3040e = 0;
    }

    /* synthetic */ b(a r1) {
        this();
    }

    private void b(BdTuringConfig r2) {
        if (r2 == null) goto L44;
        if (r2.getApplicationContext() == null) goto L44;
        if (r2.getHttpClient() != null) goto L9;
        r2.setHttpClient(new TTNetHttpClient(r2.getApplicationContext()));
    L9:
        if (r2.getHttpClient() == null) goto L42;
        if (r2.getEventClient() == null) goto L42;
        if (r2.getTwiceVerifyDepend() == null) goto L40;
        if (TextUtils.isEmpty(r2.getTwiceVerifyDepend().c()) == true) goto L38;
        if (TextUtils.isEmpty(r2.getTwiceVerifyDepend().e()) == true) goto L36;
        if (TextUtils.isEmpty(r2.getAppId()) == true) goto L34;
        if (TextUtils.isEmpty(r2.getAppVersion()) == true) goto L32;
        if (TextUtils.isEmpty(r2.getAppVersionCode()) == true) goto L30;
        if (TextUtils.isEmpty(r2.getAppName()) == true) goto L28;
        return;
    L28:
        throw new RuntimeException("appName is null");
    L30:
        throw new RuntimeException("appVersionCode is null");
    L32:
        throw new RuntimeException("appVersion is null");
    L34:
        throw new RuntimeException("appId is null");
    L36:
        throw new RuntimeException("TwiceVerify url is null");
    L38:
        throw new RuntimeException("TwiceVerify host is null");
    L40:
        throw new RuntimeException("TwiceVerifyDepend is null");
    L42:
        throw new RuntimeException("httpClient or eventClient is null");
    L44:
        throw new RuntimeException("config or applicationContext is null");
    }

    private boolean c(Activity r3, int r4, c r5) {
        if (this.f3037b == false) goto L17;
        if (r5 == null) goto L17;
        if (r3 == null) goto L17;
        if (k() == false) goto L12;
        g.c("BdTuring", "invoke multi times, u should take a breath");
        r5.a(1000, null);
        return false;
    L12:
        if (Build.VERSION.SDK_INT >= 17) goto L15;
        g.c("BdTuring", "The Android system version is too low, Please upgrade the system.");
        r5.a(RoomDatabase.MAX_BIND_PARAMETER_CNT, null);
        e.s();
        return false;
    L15:
        return true;
    L17:
        r5.a(2, null);
        return false;
    }

    private void d() {
        if (this.f3036a.getInjectHeader() == false) goto L6;
        com.bytedance.bdturing.ttnet.c.a();
    L6:
        if (this.f3036a.isTTNetProcessorEnable() == false) goto L9;
        com.bytedance.bdturing.ttnet.c.g();
    L9:
        if (this.f3036a.isBypassBdTuring() == false) goto L12;
        com.bytedance.bdturing.ttnet.c.b();
        return;
    }

    public static b f() {
        return C0083b.a();
    }

    private void h() {
        RiskControlService r0 = new RiskControlService();
        this.f3038c = r0;
        a(r0);
        a(new TwiceVerifyService());
        a(new IdentityVerifyService());
        a((com.bytedance.bdturing.verify.a) Class.forName("com.bytedance.bdturing.verify.IdentityService").newInstance());     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        g.e(e);
    }

    private void j(Activity r3, com.bytedance.bdturing.verify.b.a r4, c r5) {
        g.c("BdTuring", "BdTuring showVerifyDialog");
        r4.l(r3);
        Iterator<com.bytedance.bdturing.verify.a> r2 = this.f3039d.values().iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        com.bytedance.bdturing.verify.a r6 = r2.next();
        if (r6.isProcess(r4.j()) == false) goto L4;
        r6.execute(r4, r5);
        boolean r7 = true;
    L9:
        if (r7 == true) goto L15;
        r5.a(996, null);
        return;
    L15:
        return;
    L8:
        r7 = false;
        goto L9
    }

    private boolean k() {
        if ((System.currentTimeMillis() - this.f3040e) >= 500) goto L5;
        boolean r0 = true;
    L6:
        this.f3040e = System.currentTimeMillis();
        return r0;
    L5:
        r0 = false;
        goto L6
    }

    public void a(com.bytedance.bdturing.verify.a r3) {
        if (this.f3039d.containsKey(r3.getClass().getName()) == false) goto L5;
        return;
    L5:
        this.f3039d.put(r3.getClass().getName(), r3);
    }

    public BdTuringConfig e() {
        return this.f3036a;
    }

    public synchronized b g(BdTuringConfig r5) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.f3037b == false) goto L7;
        monitor-exit(this);
        return this;
    L7:
        long r0 = System.currentTimeMillis();     // Catch: Throwable -> L10
        this.f3036a = r5;     // Catch: Throwable -> L10
        b(r5);     // Catch: Throwable -> L10
        d();     // Catch: Throwable -> L10
        q.c().j();     // Catch: Throwable -> L10
        q.c().e(new a(this, r5));     // Catch: Throwable -> L10
        h();     // Catch: Throwable -> L10
        com.bytedance.bdturing.twiceverify.c.d().g(this.f3036a.getTwiceVerifyDepend());     // Catch: Throwable -> L10
        this.f3037b = true;     // Catch: Throwable -> L10
        e.q(System.currentTimeMillis() - r0);     // Catch: Throwable -> L10
        monitor-exit(this);
        return this;
    }

    public void i(Activity r3, com.bytedance.bdturing.verify.b.a r4, c r5) {
        e.h(r4);
        if (c(r3, r4.j(), r5) == true) goto L6;
        return;
    L6:
        if (j.a().e(r4.j()) == false) goto L8;
        return;
    L8:
        j(r3, r4, r5);
    }
}
