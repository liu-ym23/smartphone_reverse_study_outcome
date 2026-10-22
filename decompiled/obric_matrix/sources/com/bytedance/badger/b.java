package com.bytedance.badger;

import kotlin.h;
import kotlin.i;
import kotlin.n0.d.e0;
import kotlin.n0.d.q;
import kotlin.n0.d.w;
import kotlin.s0.l;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ l[] f2522a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final h f2523b = null;

    static final class a extends q implements kotlin.n0.c.a<IBadger> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f2524f = null;

        static {
            f2524f = new a();
        }

        a() {
            super(0);
        }

        public final IBadger a() {
            return (IBadger) com.bytedance.news.common.service.manager.d.a(IBadger.class);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ IBadger invoke() {
            return a();
        }
    }

    static {
        f2522a = new l[]{e0.f(new w(e0.d(b.class, "badger-api_release"), "core", "getCore()Lcom/bytedance/badger/IBadger;"))};
        f2523b = i.b(a.f2524f);
    }

    public static final /* synthetic */ IBadger a() {
        return b();
    }

    private static final IBadger b() {
        h r0 = f2523b;
        l r1 = f2522a[0];
        return (IBadger) r0.getValue();
    }
}
