package d.b.u;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f15024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d.b.u.w.k f15025c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d.b.u.w.a f15026d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f15027e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f15028f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f15029g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f15030h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f15031i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final d.b.u.w.d f15032j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f15033k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final i f15034l;
    public final Map<String, com.bytedance.sync.v2.e.c> m;

    static /* synthetic */ class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f15035a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f15036b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f15037c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public d.b.u.w.d f15038d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private h f15039e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private d.b.u.w.k f15040f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private d.b.u.w.a f15041g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f15042h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f15043i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f15044j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f15045k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private i f15046l;
        public Map<String, com.bytedance.sync.v2.e.c> m;

        public b(String r1, int r2, int r3) {
            this.f15035a = r1;
            this.f15036b = r2;
            this.f15037c = r3;
        }

        static /* synthetic */ String a(b r0) {
            return r0.f15035a;
        }

        static /* synthetic */ h b(b r0) {
            return r0.f15039e;
        }

        static /* synthetic */ i c(b r0) {
            return r0.f15046l;
        }

        static /* synthetic */ d.b.u.w.k d(b r0) {
            return r0.f15040f;
        }

        static /* synthetic */ d.b.u.w.a e(b r0) {
            return r0.f15041g;
        }

        static /* synthetic */ int f(b r0) {
            return r0.f15036b;
        }

        static /* synthetic */ int g(b r0) {
            return r0.f15037c;
        }

        static /* synthetic */ String h(b r0) {
            return r0.f15042h;
        }

        static /* synthetic */ String i(b r0) {
            return r0.f15043i;
        }

        static /* synthetic */ boolean j(b r0) {
            return r0.f15044j;
        }

        static /* synthetic */ boolean k(b r0) {
            return r0.f15045k;
        }

        public e l() {
            if (TextUtils.isEmpty(this.f15042h) == true) goto L26;
            if (TextUtils.isEmpty(this.f15035a) == true) goto L24;
            if (this.f15037c < 0) goto L22;
            if (this.f15039e == null) goto L20;
            if (this.f15040f == null) goto L18;
            if (this.f15041g != null) goto L16;
            this.f15041g = new d.b.u.c0.b();
        L16:
            return new e(this, null);
        L18:
            throw new IllegalArgumentException("please set wsService before build");
        L20:
            throw new IllegalArgumentException("please set commonParamProvider before build");
        L22:
            throw new IllegalArgumentException("please set upStreamServiceId before build");
        L24:
            throw new IllegalArgumentException("please set aid before build");
        L26:
            throw new IllegalArgumentException("please set host before build");
        }

        public b m(h r1) {
            this.f15039e = r1;
            return this;
        }

        public b n(String r1) {
            this.f15042h = r1;
            return this;
        }

        public b o(d.b.u.w.d r1) {
            this.f15038d = r1;
            return this;
        }

        public b p(d.b.u.w.k r1) {
            this.f15040f = r1;
            return this;
        }
    }

    private e(b r3) {
        this.f15023a = b.a(r3);
        this.f15024b = new c(b.b(r3));
        this.f15025c = b.d(r3);
        this.f15026d = b.e(r3);
        this.f15027e = b.f(r3);
        this.f15028f = b.g(r3);
        this.f15029g = b.h(r3);
        this.f15030h = b.i(r3);
        this.f15031i = b.j(r3);
        this.f15032j = r3.f15038d;
        this.f15033k = b.k(r3);
        this.f15034l = b.c(r3);
        Map<String, com.bytedance.sync.v2.e.c> r0 = r3.m;
        if (r0 != null) goto L5;
    L7:
        this.m = new HashMap();
        return;
    L5:
        if (r0.isEmpty() == true) goto L7;
        this.m = new HashMap(r3.m);
    }

    /* synthetic */ e(b r1, a r2) {
        this(r1);
    }
}
