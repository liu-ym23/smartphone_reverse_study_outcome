package com.bytedance.android.sdk.bdticketguard.n1;

import java.util.Set;
import kotlin.f0;
import kotlin.i0.t0;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Set<Class<? extends d>> f883d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f884e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.n0.c.a<f0> f885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f887c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public final Set<Class<? extends d>> a() {
            return d.a();
        }
    }

    static {
        f884e = new a(null);
        f883d = t0.e(new Class[]{com.bytedance.android.sdk.bdticketguard.n1.a.class, f.class, e.class});
    }

    private d(kotlin.n0.c.a<f0> r1, boolean r2, String r3) {
        this.f885a = r1;
        this.f886b = r2;
        this.f887c = r3;
    }

    public /* synthetic */ d(kotlin.n0.c.a r1, boolean r2, String r3, kotlin.n0.d.g r4) {
        this(r1, r2, r3);
    }

    public static final /* synthetic */ Set a() {
        return f883d;
    }

    public final kotlin.n0.c.a<f0> b() {
        return this.f885a;
    }

    public final boolean c() {
        return this.f886b;
    }

    public final String d() {
        return this.f887c;
    }
}
