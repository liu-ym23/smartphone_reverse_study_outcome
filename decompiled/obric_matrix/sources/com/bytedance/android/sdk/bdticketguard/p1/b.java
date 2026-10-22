package com.bytedance.android.sdk.bdticketguard.p1;

import android.os.Build;
import androidx.annotation.VisibleForTesting;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.f0;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<kotlin.n0.c.l<JSONObject, f0>> f1015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile JSONObject f1016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private kotlin.n0.c.a<? extends JSONObject> f1017c;

    static final /* synthetic */ class a extends kotlin.n0.d.l implements kotlin.n0.c.a<JSONObject> {
        a(b r2) {
            super(0, r2);
        }

        @Override // kotlin.n0.d.c, kotlin.s0.c
        public final String getName() {
            return "getLatestSettings";
        }

        @Override // kotlin.n0.d.c
        public final kotlin.s0.f getOwner() {
            return e0.b(b.class);
        }

        @Override // kotlin.n0.d.c
        public final String getSignature() {
            return "getLatestSettings$bd_ticket_guard_api_release()Lorg/json/JSONObject;";
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ JSONObject invoke() {
            return m();
        }

        public final JSONObject m() {
            return ((b) this.receiver).c();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.sdk.bdticketguard.p1.b$b, reason: collision with other inner class name */
    static final /* synthetic */ class C0035b extends kotlin.n0.d.l implements kotlin.n0.c.a<JSONObject> {
        C0035b(b r2) {
            super(0, r2);
        }

        @Override // kotlin.n0.d.c, kotlin.s0.c
        public final String getName() {
            return "getLatestSettings";
        }

        @Override // kotlin.n0.d.c
        public final kotlin.s0.f getOwner() {
            return e0.b(b.class);
        }

        @Override // kotlin.n0.d.c
        public final String getSignature() {
            return "getLatestSettings$bd_ticket_guard_api_release()Lorg/json/JSONObject;";
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ JSONObject invoke() {
            return m();
        }

        public final JSONObject m() {
            return ((b) this.receiver).c();
        }
    }

    static final /* synthetic */ class c extends kotlin.n0.d.l implements kotlin.n0.c.a<JSONObject> {
        c(b r2) {
            super(0, r2);
        }

        @Override // kotlin.n0.d.c, kotlin.s0.c
        public final String getName() {
            return "getLatestSettings";
        }

        @Override // kotlin.n0.d.c
        public final kotlin.s0.f getOwner() {
            return e0.b(b.class);
        }

        @Override // kotlin.n0.d.c
        public final String getSignature() {
            return "getLatestSettings$bd_ticket_guard_api_release()Lorg/json/JSONObject;";
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ JSONObject invoke() {
            return m();
        }

        public final JSONObject m() {
            return ((b) this.receiver).c();
        }
    }

    static final /* synthetic */ class d extends kotlin.n0.d.l implements kotlin.n0.c.a<JSONObject> {
        d(b r2) {
            super(0, r2);
        }

        @Override // kotlin.n0.d.c, kotlin.s0.c
        public final String getName() {
            return "getLatestSettings";
        }

        @Override // kotlin.n0.d.c
        public final kotlin.s0.f getOwner() {
            return e0.b(b.class);
        }

        @Override // kotlin.n0.d.c
        public final String getSignature() {
            return "getLatestSettings$bd_ticket_guard_api_release()Lorg/json/JSONObject;";
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ JSONObject invoke() {
            return m();
        }

        public final JSONObject m() {
            return ((b) this.receiver).c();
        }
    }

    public b() {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        Set<kotlin.n0.c.l<JSONObject, f0>> r0 = ConcurrentHashMap.newKeySet();
        String r1 = "ConcurrentHashMap.newKeySet()";
    L6:
        o.b(r0, r1);
        this.f1015a = r0;
        return;
    L5:
        r0 = Collections.newSetFromMap(new ConcurrentHashMap());
        r1 = "Collections.newSetFromMa…ct?) -> Unit, Boolean>())";
        goto L6
    }

    public final void a(kotlin.n0.c.l<? super JSONObject, f0> r2) {
        o.g(r2, "listener");
        this.f1015a.add(r2);
    }

    public final <T> com.bytedance.android.sdk.bdticketguard.p1.d<T> b(T r1) {
        return new com.bytedance.android.sdk.bdticketguard.p1.d(r1);
    }

    @VisibleForTesting
    public final JSONObject c() {
        kotlin.n0.c.a<? extends JSONObject> r0 = this.f1017c;
        if (r0 == null) goto L6;
        k(r0.invoke());
    L6:
        return this.f1016b;
    }

    public final <T> e<T> d(kotlin.n0.c.a<? extends T> r1) {
        o.g(r1, "settingGetter");
        return new j(r1);
    }

    public final void e(kotlin.n0.c.l<? super JSONObject, f0> r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.f1015a.remove(r1);
    }

    public final void f(kotlin.n0.c.a<? extends JSONObject> r1) {
        this.f1017c = r1;
    }

    public final l<Boolean> g(String r4, boolean r5) {
        o.g(r4, "settingKey");
        return new l(new f(r4, r5, new a(this)));
    }

    public final l<Integer> h(String r4, int r5) {
        o.g(r4, "settingKey");
        return new l(new g(r4, r5, new C0035b(this)));
    }

    public final l<Long> i(String r4, long r5) {
        o.g(r4, "settingKey");
        return new l(new h(r4, r5, new c(this)));
    }

    public final l<String> j(String r4, String r5) {
        o.g(r4, "settingKey");
        o.g(r5, "defaultValue");
        return new l(new i(r4, r5, new d(this)));
    }

    public final void k(JSONObject r2) {
        if (this.f1016b == r2) goto L8;
        this.f1016b = r2;
        Iterator<T> r1 = this.f1015a.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        ((kotlin.n0.c.l) r1.next()).invoke(r2);
        goto L6
    L10:
        return;
    }
}
