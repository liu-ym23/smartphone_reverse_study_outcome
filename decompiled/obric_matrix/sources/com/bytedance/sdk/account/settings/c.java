package com.bytedance.sdk.account.settings;

import androidx.annotation.VisibleForTesting;
import java.util.Iterator;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;
import kotlin.n0.d.y;
import kotlin.s0.l;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final /* synthetic */ l[] f5715f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f5716g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile JSONObject f5717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile JSONObject f5718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f5719c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kotlin.p0.c f5720d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f5721e;

    private static final class a<T> extends b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Object f5722a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private JSONObject f5723b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final kotlin.n0.c.l<JSONObject, T> f5724c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f5725d;

        /* JADX INFO: renamed from: com.bytedance.sdk.account.settings.c$a$a, reason: collision with other inner class name */
        private static final class C0183a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0183a f5726a = null;

            static {
                f5726a = new C0183a();
            }

            private C0183a() {
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(kotlin.n0.c.l<? super JSONObject, ? extends T> r2, boolean r3) {
            o.g(r2, "getter");
            this.f5724c = r2;
            this.f5725d = r3;
            this.f5722a = C0183a.f5726a;
        }

        @Override // com.bytedance.sdk.account.settings.c.b
        public boolean d() {
            return this.f5725d;
        }

        @Override // com.bytedance.sdk.account.settings.c.b
        public T e(JSONObject r3) {
            if (d() == false) goto L5;
        L6:
            T r0 = (T) this.f5722a;
            if (r0 == C0183a.f5726a) goto L9;
            return r0;
        L9:
            monitor-enter(this);
        L21:
            th = move-exception;
            throw th;
        L11:
            if (d() == false) goto L13;
        L14:
            T r1 = (T) this.f5722a;
            if (r1 == C0183a.f5726a) goto L18;
            monitor-exit(this);
            return r1;
        L18:
            T r2 = this.f5724c.invoke(r3);     // Catch: Throwable -> L21
            this.f5722a = r2;     // Catch: Throwable -> L21
            this.f5723b = r3;     // Catch: Throwable -> L21
            monitor-exit(this);
            return r2;
        L13:
            if (this.f5723b != r3) goto L18;
        L5:
            if (this.f5723b != r3) goto L9;
            goto L6
        }
    }

    public static abstract class b<T> implements kotlin.p0.c<c, T> {
        public b() {
        }

        private final JSONObject c(JSONObject r4) {
            JSONObject r3 = new JSONObject();
            Iterator<String> r0 = r4.keys();
            o.b(r0, "original.keys()");
        L4:
            if (r0.hasNext() == false) goto L6;
            String r1 = r0.next();
            r3.put(r1, r4.get(r1));
            goto L4
        L6:
            return r3;
        }

        @Override // kotlin.p0.c
        public /* bridge */ /* synthetic */ Object a(c r1, l r2) {
            return f(r1, r2);
        }

        public abstract boolean d();

        public abstract T e(JSONObject r1);

        public final T f(c r4, l<?> r5) {
            o.g(r4, "thisRef");
            o.g(r5, "property");
            JSONObject r2 = null;
            if (d() == false) goto L5;
            JSONObject r6 = r4.c();
            if (r6 == null) goto L11;
            T r7 = e(r6);
            if (r7 == null) goto L11;
        L23:
            return r7;
        L11:
            monitor-enter(this);
            JSONObject r8 = r4.c();     // Catch: Throwable -> L24
            if (r8 == null) goto L17;
            r7 = e(r8);     // Catch: Throwable -> L24
            if (r7 == null) goto L17;
        L22:
            monitor-exit(this);
        L17:
            JSONObject r9 = c.b(r4, false, 1, null);     // Catch: Throwable -> L24
            T r0 = e(r9);     // Catch: Throwable -> L24
            if (r9 == null) goto L20;
            r2 = c(r9);     // Catch: Throwable -> L24
        L20:
            r4.j(r2);     // Catch: Throwable -> L24
            r7 = r0;
        L24:
            th = move-exception;
            throw th;
        L5:
            return e(c.b(r4, false, 1, null));
        }
    }

    static {
        f5715f = new l[]{e0.g(new y(e0.b(c.class), "settingGetterService", "getSettingGetterService()Lcom/bytedance/sdk/account/settings/ISettingsGetter;"))};
    }

    public c() {
        this.f5719c = 1000;
        this.f5720d = new d.b.s.a.g0.a.b(ISettingsGetter.class);
    }

    public static /* synthetic */ JSONObject b(c r0, boolean r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L7;
        r1 = false;
    L7:
        return r0.a(r1);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLatestConfig");
    }

    private final ISettingsGetter d() {
        return (ISettingsGetter) this.f5720d.a(this, f5715f[0]);
    }

    @VisibleForTesting
    public final JSONObject a(boolean r5) {
        JSONObject r0 = f();
        long r1 = System.currentTimeMillis();
        if (r0 == this.f5717a) goto L9;
        if (r5 == false) goto L6;
    L7:
        JSONObject r6 = this.f5717a;
        this.f5717a = r0;
        this.f5721e = r1;
        h(r6, r0);
        goto L9
    L6:
        if (i(r1) == true) goto L7;
    L9:
        return this.f5717a;
    }

    public final JSONObject c() {
        return this.f5718b;
    }

    public abstract String e();

    protected JSONObject f() {
        return d().getSettings(e());
    }

    protected long g() {
        return this.f5719c;
    }

    public void h(JSONObject r1, JSONObject r2) {
    }

    @VisibleForTesting
    public final boolean i(long r6) {
        if (f5716g == false) goto L5;
    L14:
        return true;
    L5:
        if (g() <= 0) goto L14;
        long r0 = this.f5721e;
        if (r6 < r0) goto L14;
        if (r0 <= 0) goto L14;
        if ((r6 - r0) > g()) goto L14;
        return false;
    }

    public final void j(JSONObject r1) {
        this.f5718b = r1;
    }

    protected final <T> b<T> k(kotlin.n0.c.l<? super JSONObject, ? extends T> r2) {
        o.g(r2, "getter");
        return new a(r2, false);
    }
}
