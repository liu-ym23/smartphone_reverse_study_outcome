package com.bytedance.apm.config;

import androidx.annotation.NonNull;
import com.bytedance.apm.util.p;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.services.apm.api.IEncrypt;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.IWidget;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private final com.bytedance.apm.w.b A;
    private final com.bytedance.apm.w.a B;
    private final com.bytedance.apm.w.f C;
    private final ExecutorService D;
    private final IEncrypt E;
    private final String F;
    private final com.bytedance.apm.w.g G;
    private final com.bytedance.apm.w.e H;
    private final com.bytedance.apm.w.c I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private final com.bytedance.apm.n.a f1400J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<String> f1401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<String> f1402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<String> f1403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<String> f1404d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.bytedance.apm.w.d f1405e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f1406f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f1407g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f1408h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f1409i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f1410j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f1411k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f1412l;
    private final long m;
    private final boolean n;
    private final boolean o;
    private final boolean p;
    private final boolean q;
    private final boolean r;
    private final boolean s;
    private final boolean t;
    private final JSONObject u;
    private final com.bytedance.apm.core.b v;
    private final com.bytedance.apm.core.d w;
    private final IHttpService x;
    private final Set<IWidget> y;
    private final long z;

    static /* synthetic */ class a {
    }

    public static final class b {
        com.bytedance.apm.w.f A;
        com.bytedance.apm.w.g B;
        com.bytedance.apm.w.c C;
        com.bytedance.apm.core.d D;
        ExecutorService E;
        com.bytedance.apm.w.d F;
        IEncrypt G;
        com.bytedance.apm.x.c H;
        d.b.b.i.b I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        String f1413J;
        com.bytedance.apm.w.e K;
        com.bytedance.apm.n.a L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f1414a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f1415b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f1416c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f1417d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f1418e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f1419f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f1420g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        long f1421h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f1422i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f1423j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        boolean f1424k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        boolean f1425l;
        boolean m;
        boolean n;
        boolean o;
        List<String> p;
        List<String> q;
        List<String> r;
        List<String> s;
        JSONObject t;
        com.bytedance.apm.core.b u;
        IHttpService v;
        Set<IWidget> w;
        long x;
        com.bytedance.apm.w.b y;
        com.bytedance.apm.w.a z;

        class a implements IEncrypt {
            a(b r1) {
            }

            @Override // com.bytedance.services.apm.api.IEncrypt
            public byte[] encrypt(byte[] r1) {
                return d.b.h.b.a.b.a(r1, r1.length);
            }
        }

        b() {
            this.f1418e = false;
            this.f1424k = true;
            this.p = com.bytedance.apm.s.a.f1952a;
            this.q = com.bytedance.apm.s.a.f1953b;
            this.r = com.bytedance.apm.s.a.f1955d;
            this.s = com.bytedance.apm.s.a.f1954c;
            this.t = new JSONObject();
            this.w = new HashSet();
            this.x = 0;
            this.f1421h = 2500;
            this.G = new a(this);
            this.f1417d = h.f1467a;
            this.f1422i = h.f1468b;
            this.f1423j = h.f1469c;
        }

        public b a(int r2) {
            g(WsConstants.KEY_APP_ID, r2);
            return this;
        }

        public b b(String r2) {
            h(WsConstants.KEY_APP_VERSION, r2);
            return this;
        }

        public c c() {
            p.a(this.t.optString(WsConstants.KEY_APP_ID), WsConstants.KEY_APP_ID);
            p.c(this.u, "dynamicParams");
            p.b(this.t.optString(WsConstants.KEY_APP_VERSION), WsConstants.KEY_APP_VERSION);
            p.b(this.t.optString("update_version_code"), "update_version_code");
            p.b(this.t.optString(WsConstants.KEY_DEVICE_ID), WsConstants.KEY_DEVICE_ID);
            p.b(this.t.optString("release_build"), "release_build");
            return new c(this, null);
        }

        public b d(String r2) {
            h("channel", r2);
            return this;
        }

        public b e(String r2) {
            h(WsConstants.KEY_DEVICE_ID, r2);
            return this;
        }

        public b f(com.bytedance.apm.core.b r1) {
            this.u = r1;
            return this;
        }

        public b g(String r2, int r3) {
            this.t.put(r2, r3);     // Catch: JSONException -> L4
        L3:
            return this;
        }

        public b h(String r2, String r3) {
            this.t.put(r2, r3);     // Catch: JSONException -> L4
        L3:
            return this;
        }

        public b i(String r2) {
            h("update_version_code", r2);
            return this;
        }
    }

    private c(b r3) {
        this.u = r3.t;
        this.r = r3.f1414a;
        this.s = r3.f1415b;
        this.v = r3.u;
        this.f1401a = r3.p;
        this.x = r3.v;
        this.f1407g = r3.f1424k;
        this.f1406f = r3.f1423j;
        this.f1409i = r3.f1417d;
        this.f1410j = r3.f1418e;
        this.f1411k = r3.f1419f;
        this.f1412l = r3.f1420g;
        this.m = r3.f1421h;
        this.o = r3.m;
        this.p = r3.n;
        this.q = r3.o;
        this.y = r3.w;
        this.f1402b = r3.q;
        this.f1403c = r3.r;
        this.f1404d = r3.s;
        this.z = r3.x;
        this.n = r3.f1422i;
        this.f1408h = r3.f1425l;
        this.B = r3.z;
        this.A = r3.y;
        this.C = r3.A;
        this.D = r3.E;
        this.f1405e = r3.F;
        this.E = r3.G;
        this.t = r3.f1416c;
        this.F = r3.f1413J;
        this.G = r3.B;
        this.H = r3.K;
        this.w = r3.D;
        this.I = r3.C;
        com.bytedance.apm.n.a r2 = r3.L;
        com.bytedance.apm.x.a.h(r3.H);
        com.bytedance.apm.x.a.j(r3.I);
    }

    /* synthetic */ c(b r1, a r2) {
        this(r1);
    }

    public static b a() {
        return new b();
    }

    public boolean A() {
        return this.s;
    }

    public boolean B() {
        return this.r;
    }

    public boolean C() {
        return this.f1412l;
    }

    public boolean D() {
        return this.q;
    }

    public boolean E() {
        return this.o;
    }

    public boolean F() {
        return this.f1409i;
    }

    public boolean G() {
        return this.f1411k;
    }

    public void H(List<String> r1) {
        this.f1402b = r1;
    }

    public void I(List<String> r1) {
        this.f1403c = r1;
    }

    public void J(List<String> r1) {
        this.f1401a = r1;
    }

    public String b() {
        return this.F;
    }

    public com.bytedance.apm.w.a c() {
        return this.B;
    }

    public com.bytedance.apm.w.b d() {
        return this.A;
    }

    public com.bytedance.apm.w.c e() {
        return this.I;
    }

    public long f() {
        return this.m;
    }

    public List<String> g() {
        return this.f1402b;
    }

    public long h() {
        return this.z;
    }

    @NonNull
    public com.bytedance.apm.core.b i() {
        return this.v;
    }

    public IEncrypt j() {
        return this.E;
    }

    public List<String> k() {
        return this.f1403c;
    }

    public ExecutorService l() {
        return this.D;
    }

    public JSONObject m() {
        return this.u;
    }

    public IHttpService n() {
        return this.x;
    }

    public d.b.b.l.d o() {
        return this.f1400J;
    }

    public com.bytedance.apm.w.d p() {
        return this.f1405e;
    }

    public boolean q() {
        return this.t;
    }

    public com.bytedance.apm.w.e r() {
        return this.H;
    }

    public com.bytedance.apm.core.d s() {
        return this.w;
    }

    public List<String> t() {
        return this.f1401a;
    }

    public String toString() {
        return "ApmStartConfig{mSlardarConfigUrls=" + this.f1401a + ", mDefaultLogReportUrls=" + this.f1402b + ", mExceptionLogReportUrls=" + this.f1403c + ", mTraceReportUrls=" + this.f1404d + ", mMemoryReachTopListener=" + this.f1405e + ", mWithExceptionTrafficDetect=" + this.f1406f + ", mEnableTrafficDetect=" + this.f1407g + ", mWithWebViewTrafficDetect=" + this.f1408h + ", mWithBlockDetect=" + this.f1409i + ", mEnableBlockOnlySampled=" + this.f1410j + ", mWithSeriousBlockDetect=" + this.f1411k + ", mBlockThresholdMs=" + this.m + ", mWithTemperatureDetect=" + this.n + ", mWithBatteryDetect=" + this.o + ", mEnableBatteryLocalRecord=" + this.p + ", mEnableTemperatureLocalRecord=" + this.q + ", mForceUpdateSlardarSetting=" + this.r + ", mEnableMultiProcessRequestSetting=" + this.s + ", mNetMonitorWithDisconnected=" + this.t + ", mHeader=" + this.u + ", mDynamicParams=" + this.v + ", mQueryParams=" + this.w + ", mHttpService=" + this.x + ", mWidgets=" + this.y + ", mDelayNetRequestSeconds=" + this.z + ", mApmStartListener=" + this.A + ", mApmLogListener=" + this.B + ", mStorageCheckListener=" + this.C + ", mExecutor=" + this.D + ", mEncryptor=" + this.E + ", mAlogFilesDir='" + this.F + "', mCallback=" + this.G + ", mNtpTimeService=" + this.H + '}';
    }

    public com.bytedance.apm.w.f u() {
        return this.C;
    }

    public List<String> v() {
        return this.f1404d;
    }

    public com.bytedance.apm.w.g w() {
        return this.G;
    }

    public Set<IWidget> x() {
        return this.y;
    }

    public boolean y() {
        return this.p;
    }

    public boolean z() {
        return this.f1410j;
    }
}
